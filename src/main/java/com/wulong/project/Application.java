package com.wulong.project;

import com.wulong.project.tool.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@ServletComponentScan
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 加载SpringUtils
     * 有时候service注入不了可以使用springUtil从IOC中拿
     * @return
     */
    @Bean
    public SpringUtil getSpringUtil2() {
        return new SpringUtil();
    }
}

