package com.wulong.project.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.wulong.project.config.exception.GlobalExceptionHandler;
import com.wulong.project.config.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:wulong
 * @Date:2018/8/21 12:27
 * @mail:491925129@qq.com
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

	/**
	 * 当前激活的配置文件
	 */
	@Value("${spring.profiles.active}")
	private String env;

	/**
	 * 使用阿里 FastJson 作为JSON MessageConverter
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		//保留空的字段
		config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
		//SerializerFeature.WriteNullStringAsEmpty,//String null -> ""
		//SerializerFeature.WriteNullNumberAsZero//Number null -> 0
		// 按需配置，更多参考FastJson文档哈

		converter.setFastJsonConfig(config);
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
		converters.add(converter);
	}

	/**
	 * 拦截器加载
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		//接口签名认证拦截器
		//开发环境忽略签名认证
		if (!"dev".equals(env)) {
			registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**");
		}
	}

	/**
	 * 全局异常捕捉
	 * @param resolvers
	 */
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		resolvers.add(new GlobalExceptionHandler());
	}
}
