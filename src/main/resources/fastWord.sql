/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : fast_word

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-11-23 11:06:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(64) NOT NULL,
  `display_name` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `type` varchar(50) DEFAULT NULL COMMENT '日志类型',
  `tag` varchar(50) DEFAULT NULL COMMENT '日志标识',
  `src` varchar(255) DEFAULT NULL COMMENT '执行类',
  `ip` varchar(255) DEFAULT NULL COMMENT '请求ip',
  `msg` text COMMENT '日志内容',
  `param` text COMMENT '请求参数',
  `result` text COMMENT '执行结果',
  `op_user_id` varchar(64) DEFAULT NULL COMMENT '操作人id',
  `op_user_name` varchar(255) DEFAULT NULL COMMENT '操作人用户名',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(64) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `display_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `gold` int(11) DEFAULT NULL COMMENT '金币',
  `my_level` int(11) DEFAULT NULL COMMENT '积分等级',
  `on_line` tinyint(4) DEFAULT NULL COMMENT '是否在线',
  `disable` tinyint(4) DEFAULT NULL COMMENT '是否禁用',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `login_time` datetime DEFAULT NULL COMMENT '登陆时间',
  `login_ip` varchar(255) DEFAULT NULL COMMENT '登陆ip地址',
  `like_tag` text COMMENT '订阅标签',
  `login_count` int(11) DEFAULT NULL COMMENT '登陆次数',
  `login_theme` varchar(255) DEFAULT NULL COMMENT '主题',
  `avatar_url` text COMMENT '头像图片url',
  `op_user_id` varchar(255) DEFAULT NULL COMMENT '操作人id',
  `op_user_name` varchar(255) DEFAULT NULL COMMENT '操作人姓名',
  `op_time` datetime DEFAULT NULL COMMENT '操作时间',
  `del_flag` tinyint(4) DEFAULT NULL COMMENT '删除标记',
  `country` varchar(255) DEFAULT NULL COMMENT '登陆国家',
  `city` varchar(255) DEFAULT NULL COMMENT '登陆城市',
  `region` varchar(255) DEFAULT NULL COMMENT '登陆省份',
  `isp` varchar(255) DEFAULT NULL COMMENT '登陆运营商',
  `country_id` varchar(100) DEFAULT NULL COMMENT '国家id',
  `region_id` varchar(100) DEFAULT NULL COMMENT '省份id',
  `city_id` varchar(100) DEFAULT NULL COMMENT '城市id',
  `isp_id` varchar(100) DEFAULT NULL COMMENT '运营商id',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
