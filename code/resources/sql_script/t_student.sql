/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : db_web

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 05/10/2020 16:56:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `class_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `class_name` (`class_name`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`class_name`) REFERENCES `t_class` (`cname`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES (1, '李四', '女', '1992-02-02', 'lisi@sina.com', '文艺委员', '一年一班');
INSERT INTO `t_student` VALUES (2, '王二麻子', '男', '1993-03-03', 'wangermazi@126.com', '宣传委员', '一年一班');
INSERT INTO `t_student` VALUES (3, '哈拉少', '男', '1994-04-04', 'halashao@qq.com', '平民', '一年一班');
INSERT INTO `t_student` VALUES (4, '广坤', '女', '1999-09-09', 'guangkun@qq.com', '气人', '一年一班');
INSERT INTO `t_student` VALUES (5, '赵四', '男', '1999-09-09', 'zhao4@gmail.com', '亚洲舞王', '二年一班');
INSERT INTO `t_student` VALUES (6, '臭弟弟', '男', '1997-07-04', 'haoyuxia@seas', '帅哥一枚', '二年一班');
INSERT INTO `t_student` VALUES (7, '包租婆', '女', '1999-09-09', 'baiaohou@gmail.com', '中老年女性', '二年一班');
INSERT INTO `t_student` VALUES (8, '小红', '男', '1999-09-09', '598848415@qq.com', '壮汉', '二年一班');
INSERT INTO `t_student` VALUES (9, '老八蜜汁小汉堡', '未知', '2020-02-02', 'laobaburger@qq.com', '哈拉少的晚餐', '二年一班');
INSERT INTO `t_student` VALUES (10, '小明', '男', '1999-09-09', '598848415@qq.com', 'Daming', '三年一班');
INSERT INTO `t_student` VALUES (15, 'Sam', '男', '1999-09-09', 'sam@123.com', 'my name is sam', '三年一班');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
