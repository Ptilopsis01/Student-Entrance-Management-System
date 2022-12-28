/*
 Navicat Premium Data Transfer

 Source Server         : database
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : student_management

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 25/12/2022 18:59:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for campus
-- ----------------------------
DROP TABLE IF EXISTS `campus`;
CREATE TABLE `campus`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `auth` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of campus
-- ----------------------------
INSERT INTO `campus` VALUES (1, 'ghjgh', 1);
INSERT INTO `campus` VALUES (2, 'bmjb', 1);

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dept_id` int NOT NULL,
  `admin_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, 'csdvs', 1, 1);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, 'gdgdg', 2);

-- ----------------------------
-- Table structure for enter_report
-- ----------------------------
DROP TABLE IF EXISTS `enter_report`;
CREATE TABLE `enter_report`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `region` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` int NOT NULL,
  `stu_id` int NOT NULL,
  `sub_time` datetime(6) NOT NULL,
  `dept_id` int NOT NULL,
  `class_id` int NOT NULL,
  `ref_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enter_report
-- ----------------------------
INSERT INTO `enter_report` VALUES (1, 'csvsv', 'vsdvsdvsvv', 2, 1, '2022-12-10 08:00:00.000000', 1, 1, NULL);
INSERT INTO `enter_report` VALUES (2, 'vregvere', 'svdbsvbdbb', 2, 2, '2022-12-21 22:43:06.000000', 1, 1, NULL);
INSERT INTO `enter_report` VALUES (3, 'dsvsdvb', 'bdfhfgndnym', 2, 1, '2022-12-23 00:00:00.000000', 1, 1, NULL);

-- ----------------------------
-- Table structure for health_report
-- ----------------------------
DROP TABLE IF EXISTS `health_report`;
CREATE TABLE `health_report`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `stu_id` int NOT NULL,
  `sub_date` datetime NOT NULL,
  `health` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dept_id` int NOT NULL,
  `class_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of health_report
-- ----------------------------
INSERT INTO `health_report` VALUES (2, 1, '2022-12-14 00:00:00', 'csvsv', 'vsdvsdvsvv', 1, 1);
INSERT INTO `health_report` VALUES (3, 1, '2022-12-23 02:09:03', 'sgdbdb', 'nxtfxjncfnfny', 1, 1);

-- ----------------------------
-- Table structure for leave_report
-- ----------------------------
DROP TABLE IF EXISTS `leave_report`;
CREATE TABLE `leave_report`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `back_time` datetime(6) NOT NULL,
  `leave_time` datetime(6) NOT NULL,
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` int NOT NULL,
  `stu_id` int NOT NULL,
  `sub_time` datetime(6) NOT NULL,
  `dept_id` int NOT NULL,
  `class_id` int NOT NULL,
  `ref_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leave_report
-- ----------------------------
INSERT INTO `leave_report` VALUES (1, '2022-12-25 00:00:00.000000', '2022-12-24 00:00:00.000000', 'fhskjfhksdhfksjdbv', 2, 1, '2022-12-23 02:25:40.600000', 1, 1, NULL);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `camp_id` int NOT NULL,
  `stu_id` int NOT NULL,
  `time` timestamp NOT NULL,
  `type` int NOT NULL,
  `dept_id` int NOT NULL,
  `class_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (1, 2, 1, '2022-12-16 00:00:00', 0, 1, 1);
INSERT INTO `log` VALUES (2, 2, 1, '2022-12-16 00:00:00', 1, 1, 1);
INSERT INTO `log` VALUES (4, 2, 1, '2022-12-18 00:00:00', 0, 1, 1);
INSERT INTO `log` VALUES (6, 1, 1, '2022-12-23 00:00:00', 1, 1, 1);
INSERT INTO `log` VALUES (7, 1, 1, '2022-12-23 00:00:00', 0, 1, 1);
INSERT INTO `log` VALUES (8, 1, 1, '2022-12-23 00:00:00', 1, 1, 1);
INSERT INTO `log` VALUES (9, 1, 1, '2022-12-23 00:00:00', 0, 1, 1);
INSERT INTO `log` VALUES (10, 1, 1, '2022-12-23 01:49:42', 1, 1, 1);
INSERT INTO `log` VALUES (11, 1, 1, '2022-12-23 01:52:36', 0, 1, 1);
INSERT INTO `log` VALUES (12, 1, 1, '2022-12-23 01:52:38', 1, 1, 1);
INSERT INTO `log` VALUES (13, 1, 1, '2022-12-23 02:40:28', 0, 1, 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `home` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` int NOT NULL,
  `auth` int NOT NULL,
  `class_id` int NOT NULL,
  `dept_id` int NOT NULL,
  `leave_request` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'abc', '256165265', 'dsdfv@vavv.com', 'fdhfthf', 'nfgfgnftn', 'gdggvh', '251256165', 0, 1, 1, 1, 0);
INSERT INTO `student` VALUES (2, 'bfb', '2523453', 'vbvf@fesff.com', 'sdcvvsv', 'vsdvdsbf', 'efdbgfbt', '13513135135513', 1, 1, 1, 1, 0);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'gfnfgh');
INSERT INTO `teacher` VALUES (2, 'vfbfgnbf');

SET FOREIGN_KEY_CHECKS = 1;
