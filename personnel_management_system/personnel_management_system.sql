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

 Date: 06/09/2022 17:33:42
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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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

-- ----------------------------
-- Table structure for employee_management
-- ----------------------------
DROP TABLE IF EXISTS `employee_management`;
CREATE TABLE `employee_management`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工名字',
  `employee_sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工性别',
  `employee_telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工电话',
  `employee_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工地址',
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名',
  `employee_image_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工照片地址',
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'uuid',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(0是未删除，1是删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee_management
-- ----------------------------
INSERT INTO `employee_management` VALUES (1, '李', '男', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-09-02 15:31:03', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (2, 'lirw', '男', NULL, NULL, '引擎开发部', NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `employee_management` VALUES (5, 'test', '女', '188401111111', '1111111', NULL, NULL, NULL, '2022-08-29 11:15:18', '李瑞文', '2022-09-02 16:24:00', '李瑞文', 1);
INSERT INTO `employee_management` VALUES (6, 'lirw', '男', '18840753217', NULL, '财务部', '73c7ee8b-3301-4604-a505-1f3dba6dad59/2.png', NULL, '2022-08-29 14:36:23', '李瑞文', '2022-09-02 15:44:42', '李瑞文', 0);
INSERT INTO `employee_management` VALUES (7, 'lirw', '男', '18840753217', NULL, '引擎开发部', '4cd966b4-8558-4677-bcf7-d87188d0a682/background.jpg', NULL, '2022-08-29 15:00:25', '李瑞文', '2022-08-29 15:04:34', '李瑞文', 0);
INSERT INTO `employee_management` VALUES (8, '李瑞文', '男', '18840753217', NULL, '产品研发部', NULL, NULL, '2022-09-01 11:53:40', '李瑞文', '2022-09-01 11:55:07', '李瑞文', 0);
INSERT INTO `employee_management` VALUES (9, '李瑞文test', '男', NULL, NULL, NULL, NULL, NULL, '2022-09-02 15:39:48', '李瑞文', NULL, NULL, 1);
INSERT INTO `employee_management` VALUES (10, 'test01', '女', '123123123123', NULL, '宣传部', NULL, NULL, '2022-09-02 15:40:39', '李瑞文', '2022-09-05 15:10:17', '李瑞文', 0);
INSERT INTO `employee_management` VALUES (11, 'lirw', '男', '18840753217', NULL, '引擎开发部', NULL, NULL, '2022-09-02 15:45:15', '李瑞文', NULL, NULL, 1);
INSERT INTO `employee_management` VALUES (12, 'lirw', '男', '18840753217', NULL, '产品研发部', '07ff0fa1-1545-4d4b-a5bb-67a61e7b89fa/1.jpg', NULL, '2022-09-02 15:52:13', '李瑞文', '2022-09-05 15:20:31', '李瑞文', 0);
INSERT INTO `employee_management` VALUES (13, 'l', '男', '123123', '123', '产品研发部', NULL, NULL, '2022-09-02 17:27:11', '李瑞文', NULL, NULL, 1);
INSERT INTO `employee_management` VALUES (14, 'li', '女', '123123', '123', '人事部', 'f4c22306-9b83-47f8-aa83-86f15c4e0f13/1.jpg', NULL, '2022-09-05 15:12:51', '李瑞文', '2022-09-05 15:14:08', '李瑞文', 0);
INSERT INTO `employee_management` VALUES (15, '李瑞文123123', '男', '1111111111', '121212', '产品研发部', '160400c3-c919-42df-bf7f-5850cb76e4c8/notfound.jpg', NULL, '2022-09-06 15:38:17', '李瑞文', '2022-09-06 15:38:57', '李瑞文', 0);

-- ----------------------------
-- Table structure for holiday_management
-- ----------------------------
DROP TABLE IF EXISTS `holiday_management`;
CREATE TABLE `holiday_management`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `leave_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请假原因',
  `employee_id` int(20) NULL DEFAULT NULL COMMENT '请假人',
  `is_allow` tinyint(20) NULL DEFAULT 0 COMMENT '是否准许(0是不准，1是准)',
  `state` tinyint(20) NULL DEFAULT 0 COMMENT '审批状态(0是未审批，1是审批)',
  `from_time` datetime NULL DEFAULT NULL COMMENT '起始时间',
  `to_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除(0是未删除，1是删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of holiday_management
-- ----------------------------

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'li', '123456', 0, NULL, NULL, NULL, NULL, 1);
INSERT INTO `user` VALUES (2, 'a', '123456', 1, '2022-09-02 17:14:40', '李瑞文', NULL, NULL, 0);
INSERT INTO `user` VALUES (3, 'abc', '123456', 0, '2022-09-02 17:19:54', '李瑞文', NULL, NULL, 1);
INSERT INTO `user` VALUES (4, 'acs', '123456', 0, '2022-09-02 17:21:00', '李瑞文', NULL, NULL, 1);
INSERT INTO `user` VALUES (5, 'a', '123456', 0, '2022-09-02 17:21:58', '李瑞文', NULL, NULL, 0);
INSERT INTO `user` VALUES (6, 'aasd', 'asdasd', 0, '2022-09-02 17:22:30', '李瑞文', NULL, NULL, 1);
INSERT INTO `user` VALUES (7, 'a', '123das', 0, '2022-09-02 17:24:01', '李瑞文', NULL, NULL, 1);
INSERT INTO `user` VALUES (8, 'liruiwen', '123456', 0, '2022-09-02 17:26:22', '李瑞文', NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
