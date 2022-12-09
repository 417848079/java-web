/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : study

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 09/12/2022 15:32:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stu2
-- ----------------------------
DROP TABLE IF EXISTS `stu2`;
CREATE TABLE `stu2`  (
  `id` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `math` double(5, 2) NULL DEFAULT NULL,
  `english` double(5, 2) NULL DEFAULT NULL,
  `hire_date` date NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu2
-- ----------------------------
INSERT INTO `stu2` VALUES (1, '马云', 55, '男', '杭州', 66.00, 78.00, '1998-01-01');
INSERT INTO `stu2` VALUES (2, '马化腾', 45, '女', '深圳', 98.00, 99.00, '1999-09-01');
INSERT INTO `stu2` VALUES (3, '马斯克', 55, '男', '香港', 56.00, 77.00, '2000-01-01');
INSERT INTO `stu2` VALUES (4, '留白', 18, '女', '广东', 80.00, 75.00, '2008-01-01');
INSERT INTO `stu2` VALUES (5, '柳青', 16, '女', '云南', 90.00, NULL, '1998-08-01');
INSERT INTO `stu2` VALUES (6, '刘德华', 57, '男', '香港', 98.00, 93.00, '1999-01-01');
INSERT INTO `stu2` VALUES (7, '张学友', 60, '男', '台湾', 90.00, 100.00, '2000-01-01');
INSERT INTO `stu2` VALUES (8, '小马', 22, '女', '新疆', 100.00, 99.00, '2000-01-01');
INSERT INTO `stu2` VALUES (9, '孟浩然', 20, '男', '湖南', 99.00, 93.00, '2010-01-29');
INSERT INTO `stu2` VALUES (10, '林秒可', 20, '女', '北京', 90.00, 95.00, '2010-10-01');
INSERT INTO `stu2` VALUES (11, '德玛西亚', 30, '男', '上海', 98.00, 88.00, '2011-10-19');

SET FOREIGN_KEY_CHECKS = 1;
