package com.wulong.project.config.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wulong.project.slog.SLog;
import com.wulong.project.tool.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * AOP统一日志处理
 *
 * @Author:wulong
 * @Date:2018/7/9 14:34
 * @mail:491925129@qq.com
 */
@Aspect
@Component
public class WebLogAspect {
	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	private static Long startTime;

	/*@Autowired
	private SysLogService sysLogService;*/

	/**
	* @Description: 后面2个*表示controller包下所有类的所有方法，如果一个*会报错
	* @Param:
	* @return:
	* @Author: wulong
	* @Date: 2018/7/9
	*/
	@Pointcut("execution(public * com.wulong.project.web.*.*(..))")
	private void webLog(){}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {
		startTime = System.currentTimeMillis();
		// 接收到请求，记录请求内容
		logger.info("------------------------- 请求成功 Start -------------------------");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("请求路径: " + request.getRequestURL().toString());
		logger.info("请求方式: " + request.getMethod());
		logger.info("请求来源: " + IpUtils.getIpAddr(request));
		logger.info("响应方法: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature
				().getName());
		Map<String,Object> params = getMethodParams(request);
		logger.info("请求参数: " + JSON.toJSONString(params));
	}

	/**
	 * 请求结束
	 * @param joinPoint
	 * @param retVal
	 */
	@AfterReturning(pointcut="webLog()",argNames = "joinPoint,retVal",returning = "retVal")
	public void doAfterReturning(JoinPoint joinPoint,Object retVal) {
		logger.info("请求耗时: "+(System.currentTimeMillis()-startTime)+"毫秒");
		Map<String,Object> result = JSONObject.parseObject(JSON.toJSONString(retVal,SerializerFeature.WriteMapNullValue));
		if (result.containsKey("data")) {
			Map<String,Object> dataMap = (Map<String, Object>) result.get("data");
			if (dataMap != null && dataMap.containsKey("auth_token")) {
				((Map<String, Object>) result.get("data")).put("auth_token","******");
			}
		}
		doSLog(joinPoint,retVal);
		logger.info("返回结果: "+JSON.toJSONString(result));
		// 处理完请求，返回内容
		logger.info("------------------------- 请求成功  End  -------------------------");
	}


	/**
	 * 打日志
	 * @param joinPoint
	 * @param retVal
	 */
	public void doSLog(JoinPoint joinPoint, Object retVal) {
		// 拦截方法上的SLog注解
		Signature signature = joinPoint.getSignature();
		String className = signature.getDeclaringTypeName();
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		MethodSignature methodSignature = (MethodSignature)signature;
		Method targetMethod = methodSignature.getMethod();
		String methodName = signature.getName();
		if (targetMethod.isAnnotationPresent(SLog.class)) {
			SLog sLog = (SLog)targetMethod.getAnnotation(SLog.class);
			// 含有日志表可以使用aop的方式全局插入日志
			/*SysLog sysLog = new SysLog();
			sysLog.setId(UUID.randomUUID().toString().replace("-",""));
			sysLog.setIp(IpUtils.getIpAddr(request));
			sysLog.setMsg(sLog.msg());
			sysLog.setTag(sLog.tag());
			sysLog.setSrc(className + "." + methodName);
			sysLog.setType(sLog.type());
			sysLog.setParam(JSON.toJSONString(getMethodParams(request)));
			// null也输出
			sysLog.setResult(JSON.toJSONString(retVal,SerializerFeature.WriteMapNullValue));
			sysLog.setOpTime(new Date());
			sysLogService.save(sysLog);*/
		}
	}

	/**
	 * 获取request请求的参数
	 * @param request
	 * @return
	 */
	public Map<String, Object> getMethodParams(HttpServletRequest request) {
		Map<String,Object> result = new HashMap<>();
		//获取所有参数方法一：
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = enu.nextElement();
			if (paraName.equals("password")) {
				result.put(paraName,"******");
			} else {
				result.put(paraName,request.getParameter(paraName));
			}
		}
		return result;
	}
}

