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

 Date: 16/09/2022 09:29:17
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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department_management
-- ----------------------------
INSERT INTO `department_management` VALUES (3, '产品研发部', '负责产品研发', '李瑞文', '2022-09-05 16:23:17', '李瑞文', NULL, NULL, 0);
INSERT INTO `department_management` VALUES (4, '财务部', '负责财务信息', '李瑞文', '2022-09-05 16:24:12', '李瑞文', NULL, NULL, 0);
INSERT INTO `department_management` VALUES (5, '宣传部', '负责宣传信息', '李瑞文', '2022-09-05 16:24:30', '李瑞文', NULL, NULL, 0);
INSERT INTO `department_management` VALUES (6, '引擎开发部', '负责开发引擎', '李瑞文', '2022-09-05 16:25:01', '李瑞文', NULL, NULL, 0);
INSERT INTO `department_management` VALUES (7, '人事部', '负责人事招收', '李瑞文', '2022-09-05 16:25:26', '李瑞文', NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee_management
-- ----------------------------
INSERT INTO `employee_management` VALUES (8, 1916020219, '李瑞文', '男', '18840753217', NULL, '产品研发部', NULL, '2022-09-01 11:53:40', '李瑞文', '2022-09-01 11:55:07', '李瑞文', 0);
INSERT INTO `employee_management` VALUES (17, 1916020211, '李四', '男', '15540516151', '地球', '人事部', 'fd79e3e4-06fa-4558-81c5-c988bc738ce3/1.jpg', '2022-09-08 14:40:06', '李瑞文', NULL, NULL, 0);
INSERT INTO `employee_management` VALUES (20, 1916020799, '王五', '男', '15666464654', 'asd', '财务部', NULL, '2022-09-09 16:40:08', '李瑞文', NULL, NULL, 0);
INSERT INTO `employee_management` VALUES (21, 1916020939, '赵四', '男', '13123123123', '阿萨德', '财务部', 'b7a87c43-5c4e-4b34-864e-4e2e46cab945/1.jpg', '2022-09-14 15:23:17', '李瑞文', NULL, NULL, 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of holiday_management
-- ----------------------------
INSERT INTO `holiday_management` VALUES (6, '1', 8, 0, 1, '2022-09-08 13:25:21', '2022-09-22 00:00:00', '2022-09-08 13:25:27', '李瑞文', '2022-09-08 13:26:00', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (7, '2', 8, 1, 2, '2022-09-10 00:00:00', '2022-09-15 00:00:00', '2022-09-08 13:25:36', '李瑞文', '2022-09-08 13:26:00', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (8, '3', 8, 2, 2, '2022-09-08 13:25:43', '2022-09-08 13:25:44', '2022-09-08 13:25:46', '李瑞文', '2022-09-08 13:26:00', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (9, '4', 8, 0, 2, '2022-09-08 13:25:59', '2022-09-09 00:00:00', '2022-09-08 13:26:06', '李瑞文', '2022-09-08 13:27:00', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (10, '5', 8, 1, 2, '2022-09-09 00:00:00', '2022-09-16 00:00:00', '2022-09-08 13:26:16', '李瑞文', '2022-09-08 13:26:34', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (11, '6', 8, 2, 2, '2022-09-08 13:26:27', '2022-09-08 13:26:28', '2022-09-08 13:26:30', '李瑞文', '2022-09-08 13:27:00', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (13, '8', 8, 1, 2, '2022-09-09 16:50:15', '2022-09-16 00:00:00', '2022-09-09 16:50:23', '李瑞文', '2022-09-09 16:50:43', '李瑞文', 0);
INSERT INTO `holiday_management` VALUES (18, '国庆', 21, 1, 1, '2022-09-14 15:40:40', '2022-09-29 00:00:00', '2022-09-14 15:40:43', '李瑞文', '2022-09-14 15:40:51', '李瑞文', 0);

-- ----------------------------
-- Table structure for overtime_management
-- ----------------------------
DROP TABLE IF EXISTS `overtime_management`;
CREATE TABLE `overtime_management`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `employee_id` int(20) NULL DEFAULT NULL COMMENT '员工id',
  `overtime_from` datetime NULL DEFAULT NULL COMMENT '加班开始时间',
  `overtime_to` datetime NULL DEFAULT NULL COMMENT '加班结束时间',
  `is_allow` tinyint(20) NULL DEFAULT 2 COMMENT '是否通过(0是不通过，1是通过，2是审批中)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(0是未删除，1是删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of overtime_management
-- ----------------------------
INSERT INTO `overtime_management` VALUES (1, 8, NULL, NULL, 2, NULL, NULL, NULL, NULL, 1);
INSERT INTO `overtime_management` VALUES (2, 8, '2022-09-15 14:39:27', '2022-09-16 00:00:00', 1, '2022-09-15 14:39:30', '李瑞文', '2022-09-15 14:49:32', '李瑞文', 0);
INSERT INTO `overtime_management` VALUES (3, 8, '2022-09-15 14:43:49', '2022-09-16 00:00:00', 2, '2022-09-15 14:43:52', '李瑞文', '2022-09-15 14:44:58', '李瑞文', 1);
INSERT INTO `overtime_management` VALUES (4, 8, '2022-09-15 14:50:36', '2022-09-16 00:00:00', 0, '2022-09-15 14:50:39', '李瑞文', '2022-09-15 14:50:46', '李瑞文', 0);
INSERT INTO `overtime_management` VALUES (5, 8, '2022-09-15 14:52:08', '2022-09-17 00:00:00', 1, '2022-09-15 14:52:14', '李瑞文', '2022-09-15 14:52:22', '李瑞文', 0);
INSERT INTO `overtime_management` VALUES (6, 8, '2022-09-15 14:53:00', '2022-09-16 00:00:00', 1, '2022-09-15 14:53:03', '李瑞文', '2022-09-15 14:53:10', '李瑞文', 0);
INSERT INTO `overtime_management` VALUES (7, 8, '2022-09-15 14:54:20', '2022-09-16 00:00:00', 1, '2022-09-15 14:54:27', '李瑞文', '2022-09-15 15:12:00', '李瑞文', 0);
INSERT INTO `overtime_management` VALUES (8, 8, '2022-09-15 15:12:30', '2022-09-15 23:12:40', 1, '2022-09-15 15:12:56', '李瑞文', '2022-09-15 15:13:03', '李瑞文', 0);
INSERT INTO `overtime_management` VALUES (9, 8, '2022-09-16 00:00:00', '2022-09-16 18:00:00', 2, '2022-09-15 16:00:43', '李瑞文', NULL, NULL, 0);

-- ----------------------------
-- Table structure for salary_management
-- ----------------------------
DROP TABLE IF EXISTS `salary_management`;
CREATE TABLE `salary_management`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `employee_Id` int(20) NULL DEFAULT NULL COMMENT '员工id',
  `base_pay` decimal(10, 2) NULL DEFAULT 3000.00 COMMENT '基本工资',
  `holiday` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '事病假',
  `overtime` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '加班',
  `net_salary` decimal(10, 2) NULL DEFAULT 3000.00 COMMENT '实发工资',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(0是未删除，1是删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salary_management
-- ----------------------------
INSERT INTO `salary_management` VALUES (1, 20, 3000.00, 0.00, 0.00, 3000.00, '2022-09-09 16:40:08', '李瑞文', NULL, NULL, 0);
INSERT INTO `salary_management` VALUES (2, 8, 3000.00, 0.00, 80.00, 3080.00, NULL, NULL, '2022-09-09 16:44:48', '李瑞文', 0);
INSERT INTO `salary_management` VALUES (3, 21, 3000.00, -1400.00, 0.00, 1600.00, '2022-09-14 15:23:17', '李瑞文', '2022-09-14 15:31:23', '李瑞文', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'a', '123456', 1, '2022-09-02 17:14:40', '李瑞文', '2022-09-15 16:57:48', '李瑞文', 0, NULL);
INSERT INTO `user` VALUES (5, 'a', '123456', 0, '2022-09-02 17:21:58', '李瑞文', '2022-09-08 16:52:47', '李瑞文', 0, 8);
INSERT INTO `user` VALUES (9, 'as', '123456', 0, '2022-09-08 16:11:36', '李瑞文', '2022-09-08 16:54:05', '李瑞文', 0, 17);
INSERT INTO `user` VALUES (10, 'li', '123456', 0, '2022-09-14 15:22:18', '李瑞文', '2022-09-14 15:23:34', '李瑞文', 0, 21);

SET FOREIGN_KEY_CHECKS = 1;
