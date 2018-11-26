package com.wulong.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author:wulong
 * @Date:2018/8/20 15:16
 * @mail:491925129@qq.com
 * 项目启动后自动执行
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);

	@Value("${server.servlet.context-path}")
	private String path;

	@Value("${server.port}")
	private String port;


	@Override
	public void run(ApplicationArguments args) {
		// 开机自动初始化
		logger.info("项目开机初始化成功！");
		logger.info("项目访问入口：localhost:"+port+path);
	}

}


