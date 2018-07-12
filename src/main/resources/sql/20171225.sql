CREATE DATABASE lejian DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use lejian;

/*
Navicat MySQL Data Transfer

Source Server         : 104
Source Server Version : 50173
Source Host           : 192.168.1.104:3306
Source Database       : lejian

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-12-25 10:25:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `notification`
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `msg_content` text,
  `image_path` varchar(255) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `expire_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notification
-- ----------------------------
INSERT INTO `notification` VALUES ('19', '通知标题7', 'tongzhixiaoxi ', '/home/soft/apache-tomcat-7.0.73/webapps/weixin/upload', 'fea87fcf-94d2-429b-bc8e-3ffd8c933224-staypose.png', '2017-09-29 00:00:00', null);
INSERT INTO `notification` VALUES ('20', '通知标题', 'asdg weatyuip[]567890-=', '/home/soft/apache-tomcat-7.0.73/webapps/weixin/upload', 'c8567a7d-629e-4721-a1d1-1fdcf0a79c54-staypose.png', '2017-09-20 00:00:00', null);
INSERT INTO `notification` VALUES ('21', '通知标题', '4654163111111111111111111afdsa', '/home/soft/tomcat/webapps/weixin/upload', '06de1cf2-f10d-4dea-b19b-73e7ffed0a5b-staypose.png', '2017-09-06 00:00:00', null);
INSERT INTO `notification` VALUES ('22', '欢迎高总莅临风云传媒指导项目工作', '2017年10月16日，荣祥中建筑有限公司创始人高总莅临风云传媒有限公司视察建筑平台互联网加项目进展情况。', '/home/soft/tomcat/webapps/weixin/upload', 'e7160ca6-8aa3-459d-b6f5-2417854130e3-timg.jpg', '2017-10-28 00:00:00', null);
INSERT INTO `notification` VALUES ('23', '欢迎高总莅临风云传媒指导项目工作！', '欢迎高总莅临风云传媒指导项目工作！\r\n欢迎高总莅临风云传媒指导项目工作！', '/home/soft/apache-tomcat-7.0.73/webapps/weixin/upload', 'bd284367-d40a-4f03-a4ea-e7dd86224028-timg.jpg', '2017-10-28 00:00:00', null);
INSERT INTO `notification` VALUES ('24', '欢迎高总莅临风云传媒指导项目工作！2', '欢迎高总莅临风云传媒指导项目工作！2\r\n欢迎高总莅临风云传媒指导项目工作！2', '/home/soft/apache-tomcat-7.0.73/webapps/weixin/upload', '095518ce-df1e-449c-b317-ac52d22b5c41-timg.jpg', '2017-10-28 00:00:00', null);
INSERT INTO `notification` VALUES ('25', '欢迎高总莅临风云传媒指导项目工作！3', '欢迎高总莅临风云传媒指导项目工作！3', '/home/soft/apache-tomcat-7.0.73/webapps/weixin/upload', '56465d4b-03b0-4b8e-a5eb-636a3fb3a45b-timg.jpg', '2017-10-20 00:00:00', null);
INSERT INTO `notification` VALUES ('26', '欢迎高总莅临风云传媒指导项目工作4', '欢迎高总莅临风云传媒指导项目工作4', '/home/soft/tomcat/webapps/weixin/upload', '7fa4c343-0ee6-4b9e-9561-123f8c8cf52a-timg.jpg', '2017-10-17 00:00:00', null);

-- ----------------------------
-- Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `mobile` int(11) NOT NULL DEFAULT '0' COMMENT '手机号（绑定手机）',
  `userId` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名称',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱（只有注册时候使用，绑定邮箱时作为一个默认选项）',
  `bindEmail` varchar(255) DEFAULT NULL COMMENT '绑定邮箱（当确认绑定邮箱后使用都会此邮箱）',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userName` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `province` varchar(255) DEFAULT NULL COMMENT '所在省份',
  `city` varchar(255) DEFAULT NULL COMMENT '所在城市',
  `street` varchar(255) DEFAULT NULL COMMENT '所在街道',
  `QQ` bigint(20) DEFAULT NULL COMMENT 'QQ号码',
  PRIMARY KEY (`mobile`,`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of User
-- ----------------------------
