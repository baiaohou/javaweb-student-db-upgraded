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

 Date: 05/10/2020 16:55:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `cname` varchar(20) NOT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `teacher` varchar(20) DEFAULT NULL,
  `slogan` varchar(50) DEFAULT NULL,
  `people_count` int DEFAULT NULL,
  PRIMARY KEY (`cname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
BEGIN;
INSERT INTO `t_class` VALUES ('1.1', '1', '1', '1', 10);
INSERT INTO `t_class` VALUES ('一年一班', '一年级', '李雷', 'How are you, Han Meimei?', 4);
INSERT INTO `t_class` VALUES ('三年一班', '三年级', '吴亦凡', '我觉得不行', 2);
INSERT INTO `t_class` VALUES ('二年一班', '二年级', '韩梅梅', 'Fine, thank you! And you?', 5);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
