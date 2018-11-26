package com.wulong.project.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.wulong.project.core.ProjectConstant;
import com.wulong.project.tool.IpUtils;
import com.wulong.project.tool.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局token拦截器
 * 进行token验证
 * @Author:wulong
 * @Date:2018/8/21 12:34
 * @mail:491925129@qq.com
 */
public class TokenInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

	//不需要登录就可以访问的路径(比如:注册登录等)
	String[] includeUrls = new String[]{"login","regist"};

	/**
	 * requert请求处理之前执行token认证
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		String uri = request.getRequestURI();
		boolean needFilter = isNeedFilter(uri);
		// url白名单验证
		if (!needFilter) {
			return true;
		} else {
			String token = request.getHeader(ProjectConstant.JWT_TOKEN);
			// 返回true认证通过  返回false认证不通过
			if (JwtUtils.validateJWT(token)) {
				return true;
			} else {
				PrintWriter out = null;
				Map<String,Object> json = new HashMap<>();
				json.put("code",401);
				json.put("msg","身份认证失败，请重新登陆认证！");
				try {
					//设定类容为json的格式
					response.setContentType("application/json;charset=UTF-8");
					response.setHeader("Access-Control-Allow-Origin", "*");
					response.setStatus(401);
					out = response.getWriter();
					//写到客户端
					out.write(JSON.toJSONString(json));
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(out != null){
						out.close();
					}
				}
				logger.warn("签名认证失败，请求接口：{}，请求IP：{}，请求参数：{}",
						request.getRequestURI(), IpUtils.getIpAddr(request), JSON.toJSONString(request.getParameterMap()));
				return false;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}


	/**
	 * 判断该uri是否需要过滤
	 * @param uri
	 * @return
	 */
	public boolean isNeedFilter(String uri) {
		String[] list = uri.split("/");
		String path = list[list.length - 1];
 		for (String includeUrl : includeUrls) {
			if (includeUrl.equals(path)) {
				return false;
			}
			if (path.contains(includeUrl)) {
				return false;
			}
		}
		return true;
	}
}
