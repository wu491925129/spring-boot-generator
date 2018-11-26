package com.wulong.project.slog;

import java.lang.annotation.*;

/**
 * @Author:wulong
 * @Date:2018/11/20 15:04
 * @mail:491925129@qq.com
 * 自定义日志注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SLog {
	String type() default "system";
	/**
	 * 标签
	 *
	 * @return
	 */
	String tag() default "";

	String msg() default "";

}
