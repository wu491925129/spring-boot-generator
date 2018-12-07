# spring-boot-generator

## 项目简介
本项目为spring-boot脚手架，开箱即用

## 功能特性
内置全局异常处理、拦截器、log4j2日志、aop日志管理、PageHelper分页、JWT Token签名

## 环境依赖
JKD1.8

## 目录结构描述
* config：平台配置文件
    * aop：aop统一日志处理
    * exception：全局异常处理器
    * interception：全局拦截器
* core：核心文件，涉及接口统一返回值，mybatis配置
* quartz：定时器管理
* slog：自定义日志注解
* tool：工具类

## 启动配置说明
* 配置文件application-dev为开发环境配置文件，
application-prod为生产环境配置文件，
application-test为测试环境配置文件，
在生产和测试环境下全局过滤器生效，拦截request header中的auth_token
进行jwt token验证
* log4j2-spring.xml为log4j2的配置文件，默认日志会储存到opt/logs/test文件夹下，
日志会按天生成
* banner.txt为项目启动banner，可以自定义修改

## 快速开始
* 在相应的配置文件中配置好数据库连接
* 打开test/CodeGenerator.java，输入好数据库连接信息
* 在main方法中输入连接的数据库中的表名后运行main方法，自动生成dao、model、service、web、mapper文件
* web为视图api文件
* 项目默认访问路径为http://localhost:8888/test
