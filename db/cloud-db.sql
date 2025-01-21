/*
 Navicat Premium Data Transfer

 Source Server         : Local-MySQL
 Source Server Type    : MySQL
 Source Server Version : 80401 (8.4.1)
 Source Host           : localhost:3306
 Source Schema         : cloud-db

 Target Server Type    : MySQL
 Target Server Version : 80401 (8.4.1)
 File Encoding         : 65001

 Date: 21/01/2025 19:32:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for seata_user
-- ----------------------------
DROP TABLE IF EXISTS `seata_user`;
CREATE TABLE `seata_user` (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                              `username` varchar(50) NOT NULL COMMENT '用户名',
                              `balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '账户余额',
                              `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='分布式事务测试表-用户信息表';

-- ----------------------------
-- Records of seata_user
-- ----------------------------
BEGIN;
INSERT INTO `seata_user` (`id`, `username`, `balance`, `created_at`) VALUES (1, '小明', 1000.00, '2024-12-26 14:23:21');
COMMIT;

-- ----------------------------
-- Table structure for seata_user_order
-- ----------------------------
DROP TABLE IF EXISTS `seata_user_order`;
CREATE TABLE `seata_user_order` (
                                    `id` int NOT NULL AUTO_INCREMENT COMMENT '订单ID',
                                    `user_id` int NOT NULL COMMENT '用户ID',
                                    `order_amount` decimal(10,2) NOT NULL COMMENT '订单金额',
                                    `status` varchar(20) NOT NULL DEFAULT 'PENDING' COMMENT '订单状态',
                                    `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    PRIMARY KEY (`id`),
                                    KEY `fk_user_id` (`user_id`),
                                    CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `seata_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='分布式事务测试表-用户订单表';

-- ----------------------------
-- Records of seata_user_order
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `config_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '配置描述',
                              `config_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '配置 key',
                              `config_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '配置值',
                              `crate_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                              `status` tinyint DEFAULT NULL COMMENT '状态 0：禁用 1：启用',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
INSERT INTO `sys_config` (`id`, `config_info`, `config_key`, `config_value`, `crate_time`, `update_time`, `status`) VALUES (1, '测试数据', '测试 key', '测试 value', '2024-12-21 09:24:27', '2024-12-21 09:24:27', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
