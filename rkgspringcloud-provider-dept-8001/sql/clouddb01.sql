/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : 127.0.0.1:3306
Source Database       : clouddb01

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-04-04 17:31:04
*/

drop database if exists cloudDB01;
create database cloudDB01 character set utf8;
use cloudDB01;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(60) DEFAULT NULL,
  `db_source` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '人事部', 'clouddb01');
INSERT INTO `dept` VALUES ('2', '开发部', 'clouddb01');
INSERT INTO `dept` VALUES ('3', '财务部', 'clouddb01');
INSERT INTO `dept` VALUES ('4', '市场部', 'clouddb01');
INSERT INTO `dept` VALUES ('5', '运维部', 'clouddb01');



#insert into dept(dname,db_source) values('人事部',DATABASE());
#insert into dept(dname,db_source) values('开发部',DATABASE());
#insert into dept(dname,db_source) values('财务部',DATABASE());
#insert into dept(dname,db_source) values('市场部',DATABASE());
#insert into dept(dname,db_source) values('运维部',DATABASE());
