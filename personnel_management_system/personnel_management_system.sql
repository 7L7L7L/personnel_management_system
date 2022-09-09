/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : personnel_management_system

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 09/09/2022 17:28:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department_management
-- ----------------------------
DROP TABLE IF EXISTS `department_management`;
CREATE TABLE `department_management`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名',
  `department_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门信息',
  `principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(0是未删除，1是删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department_management
-- ----------------------------
INSERT INTO `department_management` VALUES (2, 't', 'e', '1', '2022-09-05 16:11:37', '李瑞文', '2022-09-05 16:13:59', '李瑞文', 1);
INSERT INTO `department_management` VALUES (3, '产品研发部', '负责产品研发', '李瑞文', '2022-09-05 16:23:17', '李瑞文', NULL, NULL, 0);
INSERT INTO `department_management` VALUES (4, '财务部', '负责财务信息', '李瑞文', '2022-09-05 16:24:12', '李瑞文', NULL, NULL, 0);
INSERT INTO `department_management` VALUES (5, '宣传部', '负责宣传信息', '李瑞文', '2022-09-05 16:24:30', '李瑞文', NULL, NULL, 0);
INSERT INTO `department_management` VALUES (6, '引擎开发部', '负责开发引擎', '李瑞文', '2022-09-05 16:25:01', '李瑞文', NULL, NULL, 0);
INSERT INTO `department_management` VALUES (7, '人事部', '负责人事招收', '李瑞文', '2022-09-05 16:25:26', '李瑞文', NULL, NULL, 0);
INSERT INTO `department_management` VALUES (8, 'test', '123123', 'liruiwen', '2022-09-06 15:37:13', '李瑞文', '2022-09-06 15:37:25', '李瑞文', 1);
INSERT INTO `department_management` VALUES (9, 'test1123123123', '123123123', '22221231231', '2022-09-07 11:40:28', '李瑞文', '2022-09-07 11:41:08', '李瑞文', 1);

-- ----------------------------
-- Table structure for employee_management
-- ----------------------------
DROP TABLE IF EXISTS `employee_management`;
CREATE TABLE `employee_management`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` bigint(255) NULL DEFAULT NULL COMMENT 'uuid',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工名字',
  `employee_sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工性别',
  `employee_telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工电话',
  `employee_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工地址',
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名',
  `employee_image_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工照片地址',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(0是未删除，1是删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee_management
-- ----------------------------
INSERT INTO `employee_management` VALUES (1, NULL, '李', '男', NULL, NULL, NULL, NULL, NULL, NULL, '2022-09-02 15:31:03', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (2, NULL, 'lirw', '男', NULL, NULL, '引擎开发部', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `employee_management` VALUES (5, NULL, 'test', '女', '188401111111', '1111111', NULL, NULL, '2022-08-29 11:15:18', '李瑞文', '2022-09-02 16:24:00', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (6, NULL, 'lirw', '男', '18840753217', NULL, '财务部', '73c7ee8b-3301-4604-a505-1f3dba6dad59/2.png', '2022-08-29 14:36:23', '李瑞文', '2022-09-02 15:44:42', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (7, NULL, 'lirw', '男', '18840753217', NULL, '引擎开发部', '4cd966b4-8558-4677-bcf7-d87188d0a682/background.jpg', '2022-08-29 15:00:25', '李瑞文', '2022-08-29 15:04:34', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (8, 1916020219, '李瑞文', '男', '18840753217', NULL, '产品研发部', NULL, '2022-09-01 11:53:40', '李瑞文', '2022-09-01 11:55:07', '李瑞文', 0);
INSERT INTO `employee_management` VALUES (9, NULL, '李瑞文test', '男', NULL, NULL, NULL, NULL, '2022-09-02 15:39:48', '李瑞文', NULL, NULL, 1);
INSERT INTO `employee_management` VALUES (10, NULL, 'test01', '女', '123123123123', NULL, '宣传部', NULL, '2022-09-02 15:40:39', '李瑞文', '2022-09-05 15:10:17', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (11, NULL, 'lirw', '男', '18840753217', NULL, '引擎开发部', NULL, '2022-09-02 15:45:15', '李瑞文', NULL, NULL, 1);
INSERT INTO `employee_management` VALUES (12, NULL, 'lirw', '男', '18840753217', NULL, '产品研发部', '07ff0fa1-1545-4d4b-a5bb-67a61e7b89fa/1.jpg', '2022-09-02 15:52:13', '李瑞文', '2022-09-05 15:20:31', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (13, NULL, 'l', '男', '123123', '123', '产品研发部', NULL, '2022-09-02 17:27:11', '李瑞文', NULL, NULL, 1);
INSERT INTO `employee_management` VALUES (14, NULL, 'li', '女', '123123', '123', '人事部', 'f4c22306-9b83-47f8-aa83-86f15c4e0f13/1.jpg', '2022-09-05 15:12:51', '李瑞文', '2022-09-05 15:14:08', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (15, NULL, '李瑞文123123', '男', '1111111111', '121212', '产品研发部', '160400c3-c919-42df-bf7f-5850cb76e4c8/notfound.jpg', '2022-09-06 15:38:17', '李瑞文', '2022-09-06 15:38:57', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (16, NULL, 'test123213123', '女', '123213123123', '12123123', '财务部', 'c29bee08-07f8-421f-9dc5-914c37614ba5/background.jpg', '2022-09-07 11:42:48', '李瑞文', '2022-09-07 11:44:19', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (17, 1916020211, '李四', '男', '15540516151', '地球', '人事部', 'fd79e3e4-06fa-4558-81c5-c988bc738ce3/1.jpg', '2022-09-08 14:40:06', '李瑞文', NULL, NULL, 0);
INSERT INTO `employee_management` VALUES (18, 19160202109, '1', '男', '', '', '', NULL, '2022-09-08 14:40:37', '李瑞文', NULL, NULL, 1);
INSERT INTO `employee_management` VALUES (19, 19160202665, '1', '男', '', '', '', NULL, '2022-09-08 14:41:04', '李瑞文', NULL, NULL, 1);
INSERT INTO `employee_management` VALUES (20, 1916020799, '王五', '男', '15666464654', 'asd', '财务部', NULL, '2022-09-09 16:40:08', '李瑞文', NULL, NULL, 0);

-- ----------------------------
-- Table structure for holiday_management
-- ----------------------------
DROP TABLE IF EXISTS `holiday_management`;
CREATE TABLE `holiday_management`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `leave_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请假原因',
  `employee_id` int(20) NULL DEFAULT NULL COMMENT '请假人',
  `is_allow` tinyint(20) NULL DEFAULT 0 COMMENT '是否准许(0是不准，1是准，2是审批中)',
  `state` tinyint(20) NULL DEFAULT 0 COMMENT '审批状态(0是未审批，1是审批，2是假期中，3是已过期)',
  `from_time` datetime NULL DEFAULT NULL COMMENT '起始时间',
  `to_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(0是未删除，1是删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of holiday_management
-- ----------------------------
INSERT INTO `holiday_management` VALUES (1, '1', 5, 2, 1, '2022-09-08 00:00:00', '2022-09-15 14:07:01', '2022-09-07 16:37:48', '李瑞文', '2022-09-07 16:54:31', '李瑞文', 1);
INSERT INTO `holiday_management` VALUES (2, 'test', 5, 2, 0, '2022-09-09 00:00:00', '2022-09-16 00:00:00', '2022-09-08 10:39:58', '李瑞文', '2022-09-08 10:40:00', '李瑞文', 1);
INSERT INTO `holiday_management` VALUES (3, 'test', 5, 2, 0, '2022-09-09 00:00:00', '2022-09-30 00:00:00', '2022-09-08 10:42:29', '李瑞文', '2022-09-08 10:43:00', '李瑞文', 1);
INSERT INTO `holiday_management` VALUES (4, 'test', 8, 2, 1, '2022-09-08 10:45:15', '2022-09-15 00:00:00', '2022-09-08 10:45:18', '李瑞文', '2022-09-08 10:45:51', '李瑞文', 1);
INSERT INTO `holiday_management` VALUES (5, 'test', 8, 1, 2, '2022-09-08 10:50:40', '2022-09-09 10:50:43', '2022-09-08 10:50:50', '李瑞文', '2022-09-08 10:51:00', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (6, '1', 8, 0, 1, '2022-09-08 13:25:21', '2022-09-22 00:00:00', '2022-09-08 13:25:27', '李瑞文', '2022-09-08 13:26:00', '李瑞文', 1);
INSERT INTO `holiday_management` VALUES (7, '2', 8, 1, 0, '2022-09-10 00:00:00', '2022-09-15 00:00:00', '2022-09-08 13:25:36', '李瑞文', '2022-09-08 13:26:00', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (8, '3', 8, 2, 2, '2022-09-08 13:25:43', '2022-09-08 13:25:44', '2022-09-08 13:25:46', '李瑞文', '2022-09-08 13:26:00', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (9, '4', 8, 0, 2, '2022-09-08 13:25:59', '2022-09-09 00:00:00', '2022-09-08 13:26:06', '李瑞文', '2022-09-08 13:27:00', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (10, '5', 8, 1, 1, '2022-09-09 00:00:00', '2022-09-16 00:00:00', '2022-09-08 13:26:16', '李瑞文', '2022-09-08 13:26:34', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (11, '6', 8, 2, 2, '2022-09-08 13:26:27', '2022-09-08 13:26:28', '2022-09-08 13:26:30', '李瑞文', '2022-09-08 13:27:00', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (12, '7', 8, 1, 1, '2022-09-09 16:48:10', '2022-09-10 00:00:00', '2022-09-09 16:48:30', '李瑞文', '2022-09-09 16:49:41', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (13, '8', 8, 1, 1, '2022-09-09 16:50:15', '2022-09-16 00:00:00', '2022-09-09 16:50:23', '李瑞文', '2022-09-09 16:50:43', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (14, '1', 8, 1, 1, '2022-09-09 16:52:40', '2022-09-10 00:00:00', '2022-09-09 16:52:45', '李瑞文', '2022-09-09 16:53:09', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (15, '', 8, 2, 3, '2022-09-09 17:15:32', '2022-09-10 00:00:00', '2022-09-09 17:17:58', '李瑞文', '2022-09-09 17:20:00', '李瑞文', 0);

-- ----------------------------
-- Table structure for overtime_management
-- ----------------------------
DROP TABLE IF EXISTS `overtime_management`;
CREATE TABLE `overtime_management`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `employee_id` int(20) NULL DEFAULT NULL COMMENT '员工id',
  `overtime_from` datetime NULL DEFAULT NULL COMMENT '加班开始时间',
  `ovettime_to` datetime NULL DEFAULT NULL COMMENT '加班结束时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(0是未删除，1是删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of overtime_management
-- ----------------------------

-- ----------------------------
-- Table structure for salary_management
-- ----------------------------
DROP TABLE IF EXISTS `salary_management`;
CREATE TABLE `salary_management`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `employee_Id` int(20) NULL DEFAULT NULL COMMENT '员工id',
  `base_pay` decimal(10, 2) NULL DEFAULT 3000.00 COMMENT '基本工资',
  `holiday` decimal(10, 2) NULL DEFAULT NULL COMMENT '事病假',
  `overtime` decimal(10, 2) NULL DEFAULT NULL COMMENT '加班',
  `net_salary` decimal(10, 2) NULL DEFAULT 3000.00 COMMENT '实发工资',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(0是未删除，1是删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salary_management
-- ----------------------------
INSERT INTO `salary_management` VALUES (1, 20, 3000.00, NULL, NULL, 3000.00, '2022-09-09 16:40:08', '李瑞文', NULL, NULL, 0);
INSERT INTO `salary_management` VALUES (2, 8, 3000.00, -700.00, NULL, 2300.00, NULL, NULL, '2022-09-09 16:44:48', '李瑞文', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `is_admin` tinyint(1) NULL DEFAULT 0 COMMENT '是否是管理员',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(0是未删除，1是删除)',
  `employee_id` int(20) NULL DEFAULT NULL COMMENT '员工id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'li', '123456', 0, NULL, NULL, NULL, NULL, 1, NULL);
INSERT INTO `user` VALUES (2, 'a', '123456', 1, '2022-09-02 17:14:40', '李瑞文', NULL, NULL, 0, NULL);
INSERT INTO `user` VALUES (3, 'abc', '123456', 0, '2022-09-02 17:19:54', '李瑞文', NULL, NULL, 1, NULL);
INSERT INTO `user` VALUES (4, 'acs', '123456', 0, '2022-09-02 17:21:00', '李瑞文', NULL, NULL, 1, NULL);
INSERT INTO `user` VALUES (5, 'a', '123456', 0, '2022-09-02 17:21:58', '李瑞文', '2022-09-08 16:52:47', '李瑞文', 0, 8);
INSERT INTO `user` VALUES (6, 'aasd', 'asdasd', 0, '2022-09-02 17:22:30', '李瑞文', NULL, NULL, 1, NULL);
INSERT INTO `user` VALUES (7, 'a', '123das', 0, '2022-09-02 17:24:01', '李瑞文', NULL, NULL, 1, NULL);
INSERT INTO `user` VALUES (8, 'liruiwen', '123456', 0, '2022-09-02 17:26:22', '李瑞文', NULL, NULL, 1, NULL);
INSERT INTO `user` VALUES (9, 'as', '123456', 0, '2022-09-08 16:11:36', '李瑞文', '2022-09-08 16:54:05', '李瑞文', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
