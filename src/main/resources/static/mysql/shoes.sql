/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : shoes

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 14/04/2019 22:01:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminAccount` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminPassword` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createadminId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stateId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminAuthority` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('afc682a8-b8b9-48bb-94d1-a044604ed6ab', '张三', 'SupperAdmin', '1514324415jyh', '13461020531', 'afc682a8-b8b9-48bb-94d1-a044604ed6ab', '66e75647-2b10-4553-a43d-2bb30fa33af7', '超级管理员', '2018-12-19 11:00:36');
INSERT INTO `admin` VALUES ('6360bb1c-f0ab-482f-a878-24a92d0d41c6', 'admin', 'admin', '123456', '13461020531', 'afc682a8-b8b9-48bb-94d1-a044604ed6ab', '66e75647-2b10-4553-a43d-2bb30fa33af7', '普通管理员', '2018-12-18 15:49:12');
INSERT INTO `admin` VALUES ('21627616-f019-4da2-8ad9-59c5f1ca50e3', '王五', 'admin2', '123456', '13461020531', 'afc682a8-b8b9-48bb-94d1-a044604ed6ab', '66e75647-2b10-4553-a43d-2bb30fa33af7', '普通管理员', '2018-12-14 10:57:14');
INSERT INTO `admin` VALUES ('59c5f1ca50e4', '赵六', 'admin3', '123456', '13461020531', 'afc682a8-b8b9-48bb-94d1-a044604ed6ab', '66e75647-2b10-4553-a43d-2bb30fa33af7', '普通管理员', '2018-12-14 11:28:19');
INSERT INTO `admin` VALUES ('27d1733e-8259-4edf-950a-ced6d2f5f851', '姬雨航', '151432415', '1514324415jyh', '13461020531', '21627616-f019-4da2-8ad9-59c5f1ca50e3', '66e75647-2b10-4553-a43d-2bb30fa33af7', '超级管理员', '2018-12-14 19:40:40');
INSERT INTO `admin` VALUES ('6c3bed4c-d03a-4b77-9f24-6eff1a72e76a', '找房东', '123456', '123456admkin', '13461020531', '21627616-f019-4da2-8ad9-59c5f1ca50e3', '66e75647-2b10-4553-a43d-2bb30fa33af7', '超级管理员', '2018-12-15 09:01:40');

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info`  (
  `customerinfoId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customerinfoName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rechargeAmount` double NULL DEFAULT NULL,
  `balance` double NULL DEFAULT NULL,
  `adminId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_info
-- ----------------------------
INSERT INTO `customer_info` VALUES ('9ba378d6-80dd-43c2-8c32-1ce4afd203e2', '张三', '15093077197', 502, 602, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:29:44');
INSERT INTO `customer_info` VALUES ('3d48a9e7-bbe9-4929-a43d-6c752457f128', '王五', '15093077191', 109, 109, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:40:33');
INSERT INTO `customer_info` VALUES ('f97130f7-7dd4-4398-ad91-a72195040e93', '李四', '15093077192', 101, 101, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:40:39');
INSERT INTO `customer_info` VALUES ('02d2d447-2184-4e31-b53e-b1425da9d9c4', '赵六', '15093077193', 500, 525, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 18:01:16');
INSERT INTO `customer_info` VALUES ('45085e37-f066-45b3-9014-0afb93fa531f', '李启', '15093077194', 1307.21, 1372.21, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 10:58:30');
INSERT INTO `customer_info` VALUES ('70fdddb1-3a1c-4abc-b9ed-faf16097b66f', '战三', '15093077195', 1751, 2006, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 15:19:59');
INSERT INTO `customer_info` VALUES ('2fea84f9-8f79-4099-b6af-9385bd7f43ab', '李青', '15093077196', 715, 795, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 15:18:18');
INSERT INTO `customer_info` VALUES ('16cf8155-44c1-427a-bbbf-51a049ce4cfe', '刘能', '15093077198', 2.5, 2.5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 16:39:43');
INSERT INTO `customer_info` VALUES ('01428279-b009-4d5d-8e94-23a657c52f6f', 'dsadasdas', '13461020531', 2500, 2995, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 13:13:01');
INSERT INTO `customer_info` VALUES ('3c7fa972-9f55-4d40-af84-87ea511aa1d3', '姬雨航', '15036387378', 500, 595, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 15:20:03');

-- ----------------------------
-- Table structure for expense_record
-- ----------------------------
DROP TABLE IF EXISTS `expense_record`;
CREATE TABLE `expense_record`  (
  `expenseRecordId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customerinfoId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `serviceId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `serviceName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `servicePrice` double NULL DEFAULT NULL,
  `expenseMoney` double NULL DEFAULT NULL,
  `adminId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expense_record
-- ----------------------------
INSERT INTO `expense_record` VALUES ('55799f1e-1f81-449c-8e86-4a9b5be38670', '9ba378d6-80dd-43c2-8c32-1ce4afd203e2', 'b29a9ea0-a765-4a8d-80d8-04024178c11c', '擦鞋', 10, 10, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 18:00:17');
INSERT INTO `expense_record` VALUES ('de6aba17-3607-4602-b89e-3a15bd50549e', '3d48a9e7-bbe9-4929-a43d-6c752457f128', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 18:00:38');
INSERT INTO `expense_record` VALUES ('4d195570-6f3a-4a85-b128-0c8b490b696a', 'f97130f7-7dd4-4398-ad91-a72195040e93', 'b29a9ea0-a765-4a8d-80d8-04024178c11c', '擦鞋', 10, 10, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 18:00:44');
INSERT INTO `expense_record` VALUES ('25ea91a5-58b3-421c-83cf-2bed7c6a4969', '02d2d447-2184-4e31-b53e-b1425da9d9c4', 'b29a9ea0-a765-4a8d-80d8-04024178c11c', '擦鞋', 10, 10, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 18:01:05');
INSERT INTO `expense_record` VALUES ('c128b870-dd45-40ba-9cc8-3a33887ddfb6', '02d2d447-2184-4e31-b53e-b1425da9d9c4', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 18:01:16');
INSERT INTO `expense_record` VALUES ('12229b30-bc73-4341-b662-9b5b8e21a88b', '02d2d447-2184-4e31-b53e-b1425da9d9c4', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 18:01:23');
INSERT INTO `expense_record` VALUES ('e8afafbb-6b45-4edc-bc4e-e020bfddeaae', '16cf8155-44c1-427a-bbbf-51a049ce4cfe', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 18:01:38');
INSERT INTO `expense_record` VALUES ('1d73aaaf-1a03-42c4-8930-f47c421ef02f', '45085e37-f066-45b3-9014-0afb93fa531f', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-15 10:29:48');
INSERT INTO `expense_record` VALUES ('c8f5ff7f-03fc-47f8-91ce-92b51dbe656f', '45085e37-f066-45b3-9014-0afb93fa531f', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-15 10:31:31');
INSERT INTO `expense_record` VALUES ('1762e338-88ba-4f7f-a40b-077b695f30eb', '45085e37-f066-45b3-9014-0afb93fa531f', 'b29a9ea0-a765-4a8d-80d8-04024178c11c', '擦鞋', 10, 10, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 10:55:30');
INSERT INTO `expense_record` VALUES ('7ef050a4-7959-4244-80bf-849a0c73e95e', '45085e37-f066-45b3-9014-0afb93fa531f', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 10:58:25');
INSERT INTO `expense_record` VALUES ('43f464d2-d82a-40e8-9cd2-6317d9a91717', '45085e37-f066-45b3-9014-0afb93fa531f', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 10:58:30');
INSERT INTO `expense_record` VALUES ('209a1714-425e-4b0d-86b0-77df329167fb', '01428279-b009-4d5d-8e94-23a657c52f6f', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 13:13:01');
INSERT INTO `expense_record` VALUES ('a84fe1e0-0490-4c5d-a7e0-af0aba18e60a', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', 'b29a9ea0-a765-4a8d-80d8-04024178c11c', '擦鞋', 10, 10, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 15:18:18');
INSERT INTO `expense_record` VALUES ('a9bec8ea-579a-4b2b-91b9-7c2c814a0004', '70fdddb1-3a1c-4abc-b9ed-faf16097b66f', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 15:19:59');
INSERT INTO `expense_record` VALUES ('3303befc-516f-4e1f-9506-87464fec7e06', '3c7fa972-9f55-4d40-af84-87ea511aa1d3', 'ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 15:20:03');

-- ----------------------------
-- Table structure for recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `recharge_record`;
CREATE TABLE `recharge_record`  (
  `rechargeRecordId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customerinfoId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `setMealId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `setMealPrice` double NULL DEFAULT NULL,
  `givenPrice` double NULL DEFAULT NULL,
  `rechargeMoney` double NULL DEFAULT NULL,
  `adminId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recharge_record
-- ----------------------------
INSERT INTO `recharge_record` VALUES ('295e81b2-8c5f-48c4-911f-e2f5efb57205', '9ba378d6-80dd-43c2-8c32-1ce4afd203e2', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-13 22:11:35');
INSERT INTO `recharge_record` VALUES ('e7180512-01ad-46e2-8d77-6eafe9d00644', '3d48a9e7-bbe9-4929-a43d-6c752457f128', NULL, 0, 0, 100, '25656727-98c2-417f-acae-37e561514bed', '2018-12-13 22:39:18');
INSERT INTO `recharge_record` VALUES ('721e10df-e74f-4e1c-aa00-6c40c62c724d', 'f97130f7-7dd4-4398-ad91-a72195040e93', NULL, 0, 0, 100, '25656727-98c2-417f-acae-37e561514bed', '2018-12-13 22:40:45');
INSERT INTO `recharge_record` VALUES ('3bb61463-85af-4f8c-9037-1399ff545eb5', '02d2d447-2184-4e31-b53e-b1425da9d9c4', 'b2c5ed5d-edbc-4934-9551-158c522706d8', 300, 30, 499.9, '25656727-98c2-417f-acae-37e561514bed', '2018-12-13 23:15:51');
INSERT INTO `recharge_record` VALUES ('722b04dd-63ff-46cf-b17c-9e384743a29a', '45085e37-f066-45b3-9014-0afb93fa531f', 'b2c5ed5d-edbc-4934-9551-158c522706d8', 300, 30, 499.9, '25656727-98c2-417f-acae-37e561514bed', '2018-12-13 23:16:27');
INSERT INTO `recharge_record` VALUES ('77012eb7-8232-4f43-831c-6ea96226fdc4', '70fdddb1-3a1c-4abc-b9ed-faf16097b66f', NULL, 0, 0, 50, '25656727-98c2-417f-acae-37e561514bed', '2018-12-13 23:16:59');
INSERT INTO `recharge_record` VALUES ('cea56bf9-3030-4ead-a0b3-01f0549e041b', '70fdddb1-3a1c-4abc-b9ed-faf16097b66f', 'b2c5ed5d-edbc-4934-9551-158c522706d8', 300, 30, 300, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:21:28');
INSERT INTO `recharge_record` VALUES ('84b84bbb-89f2-4923-9042-f4387931a924', '70fdddb1-3a1c-4abc-b9ed-faf16097b66f', NULL, 0, 0, 0.5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:21:38');
INSERT INTO `recharge_record` VALUES ('2a370973-4c1a-4502-a0ce-fe9ce136d819', '70fdddb1-3a1c-4abc-b9ed-faf16097b66f', NULL, 0, 0, 100, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:21:44');
INSERT INTO `recharge_record` VALUES ('bbcd6d82-4bf8-4a1d-850a-3e108d5ff030', '70fdddb1-3a1c-4abc-b9ed-faf16097b66f', 'b2c5ed5d-edbc-4934-9551-158c522706d8', 300, 30, 300, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:21:52');
INSERT INTO `recharge_record` VALUES ('be0ab290-d98f-4af6-be7c-cc1e13e9563f', '70fdddb1-3a1c-4abc-b9ed-faf16097b66f', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:22:12');
INSERT INTO `recharge_record` VALUES ('373750db-26d2-4f75-80ce-fd9d44f51bcd', '45085e37-f066-45b3-9014-0afb93fa531f', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:22:25');
INSERT INTO `recharge_record` VALUES ('949fa52b-1af9-4d57-89ad-f948855a8738', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 0, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:23:01');
INSERT INTO `recharge_record` VALUES ('e2a15645-dd91-4c41-954f-c93a40451337', '45085e37-f066-45b3-9014-0afb93fa531f', NULL, 0, 0, 100, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:23:12');
INSERT INTO `recharge_record` VALUES ('1fca4eca-1445-401a-afd3-f887360a8526', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 100, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:24:06');
INSERT INTO `recharge_record` VALUES ('75ac806b-f5b3-4ec8-97f8-677d5f3b3350', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 100, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:24:12');
INSERT INTO `recharge_record` VALUES ('2635de06-18f1-47bb-9668-c174a0e0233d', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:26:47');
INSERT INTO `recharge_record` VALUES ('1b556f73-f219-4fa7-b518-81775d255d8c', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:26:54');
INSERT INTO `recharge_record` VALUES ('b96cc38b-1e3c-472e-bdd8-5423e6177556', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:27:02');
INSERT INTO `recharge_record` VALUES ('fb5e89d6-7f1d-4e16-9186-b3880c5a33d7', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:28:13');
INSERT INTO `recharge_record` VALUES ('9dae1a30-5197-4d84-86a9-a78e5bf6c56e', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:28:22');
INSERT INTO `recharge_record` VALUES ('beae6eb5-f0fa-4fe4-ad45-c1e1740c5adf', '9ba378d6-80dd-43c2-8c32-1ce4afd203e2', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:29:38');
INSERT INTO `recharge_record` VALUES ('32246043-13b9-42ac-b53d-2a43c0fb4372', '9ba378d6-80dd-43c2-8c32-1ce4afd203e2', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:29:44');
INSERT INTO `recharge_record` VALUES ('70fc018a-a3be-4ea1-9f2c-a434cba6014d', '3d48a9e7-bbe9-4929-a43d-6c752457f128', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:31:21');
INSERT INTO `recharge_record` VALUES ('99a86fe1-24ee-40f9-9b8e-1034ec3ac689', '3d48a9e7-bbe9-4929-a43d-6c752457f128', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:31:26');
INSERT INTO `recharge_record` VALUES ('e088685c-165b-4a29-81ec-67b657ae2a59', '3d48a9e7-bbe9-4929-a43d-6c752457f128', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:33:34');
INSERT INTO `recharge_record` VALUES ('f4520911-bb53-4588-a5be-24606f29b26c', '3d48a9e7-bbe9-4929-a43d-6c752457f128', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:33:40');
INSERT INTO `recharge_record` VALUES ('a889dd00-d68b-4600-946b-9f0a94e958ba', '3d48a9e7-bbe9-4929-a43d-6c752457f128', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:35:23');
INSERT INTO `recharge_record` VALUES ('3aefe9ff-4181-4330-ba09-843d1466b0f5', '3d48a9e7-bbe9-4929-a43d-6c752457f128', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:35:31');
INSERT INTO `recharge_record` VALUES ('6d13c515-16dd-415d-bbb9-4da960200948', '3d48a9e7-bbe9-4929-a43d-6c752457f128', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:36:29');
INSERT INTO `recharge_record` VALUES ('437746e4-8d2c-4af5-b9eb-460d403f0338', '3d48a9e7-bbe9-4929-a43d-6c752457f128', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:36:35');
INSERT INTO `recharge_record` VALUES ('32167498-b4bc-4bb8-bd50-356e8199dc6d', '3d48a9e7-bbe9-4929-a43d-6c752457f128', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:40:33');
INSERT INTO `recharge_record` VALUES ('5de2c706-c997-4284-8070-46b53154c53b', 'f97130f7-7dd4-4398-ad91-a72195040e93', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:40:39');
INSERT INTO `recharge_record` VALUES ('66fb09cc-bcf3-4835-824c-8ad228cf272c', '02d2d447-2184-4e31-b53e-b1425da9d9c4', NULL, 0, 0, 0.1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:40:48');
INSERT INTO `recharge_record` VALUES ('189358bc-e5d3-463a-b9c3-3b801b9457d9', '70fdddb1-3a1c-4abc-b9ed-faf16097b66f', NULL, 0, 0, 0.5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:40:58');
INSERT INTO `recharge_record` VALUES ('780c69c2-c397-404a-9849-c8a5d7ea39f1', '45085e37-f066-45b3-9014-0afb93fa531f', NULL, 0, 0, 0.001, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:41:10');
INSERT INTO `recharge_record` VALUES ('434c4a86-2422-473f-ba1d-61b716a8abbd', '45085e37-f066-45b3-9014-0afb93fa531f', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:42:06');
INSERT INTO `recharge_record` VALUES ('26a5296b-a682-49c5-9973-36c83917d3aa', '45085e37-f066-45b3-9014-0afb93fa531f', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 14:42:20');
INSERT INTO `recharge_record` VALUES ('dd96b7a6-ae85-4b4b-aad3-4fbcc5198879', '16cf8155-44c1-427a-bbbf-51a049ce4cfe', NULL, 0, 0, 1.5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 16:33:58');
INSERT INTO `recharge_record` VALUES ('d5bea156-8c9a-4177-b66d-c92383e39eb7', '16cf8155-44c1-427a-bbbf-51a049ce4cfe', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 16:39:43');
INSERT INTO `recharge_record` VALUES ('f9badad7-9c99-41c7-8b7d-b5903d8c42fd', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 18:01:32');
INSERT INTO `recharge_record` VALUES ('eb1e806b-09a0-4ecd-b797-c321cfca60fe', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-15 09:22:57');
INSERT INTO `recharge_record` VALUES ('b769c5ff-52f8-4d3f-80b0-7eece4a6ebee', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-15 09:23:38');
INSERT INTO `recharge_record` VALUES ('1d179caa-feee-42d0-b959-10bed8a60f1d', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-15 09:25:09');
INSERT INTO `recharge_record` VALUES ('960a18e6-a9d8-4d85-a86b-df1da08241ea', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-15 09:25:57');
INSERT INTO `recharge_record` VALUES ('642e8f3b-82ed-4566-aa87-901389e273eb', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', NULL, 0, 0, 1, '25656727-98c2-417f-acae-37e561514bed', '2018-12-15 09:26:44');
INSERT INTO `recharge_record` VALUES ('a31dcd1a-9e88-41e7-b3c6-b18834765e00', '01428279-b009-4d5d-8e94-23a657c52f6f', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-15 10:31:17');
INSERT INTO `recharge_record` VALUES ('0ed960cd-c56f-494f-8c5b-f2d5b6f3dc8d', '45085e37-f066-45b3-9014-0afb93fa531f', NULL, 0, 0, 100, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 09:44:52');
INSERT INTO `recharge_record` VALUES ('59d1a27a-0a26-4e4f-bb24-c84ef9e863cd', '45085e37-f066-45b3-9014-0afb93fa531f', NULL, 0, 0, 105.21, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 09:54:19');
INSERT INTO `recharge_record` VALUES ('deca03ec-81dd-47c9-aeff-ce406cc42d05', '2fea84f9-8f79-4099-b6af-9385bd7f43ab', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 11:34:03');
INSERT INTO `recharge_record` VALUES ('33e49640-9f22-479a-8369-bb144dd3d104', '01428279-b009-4d5d-8e94-23a657c52f6f', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 11:34:22');
INSERT INTO `recharge_record` VALUES ('77b78f14-b36d-410f-ad2d-3fc8be454d71', '01428279-b009-4d5d-8e94-23a657c52f6f', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 11:34:49');
INSERT INTO `recharge_record` VALUES ('aab7f05a-4d71-4900-9aa5-c4df960ea143', '01428279-b009-4d5d-8e94-23a657c52f6f', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 13:12:46');
INSERT INTO `recharge_record` VALUES ('2be00e42-89bf-4d55-a383-b52e48b57812', '01428279-b009-4d5d-8e94-23a657c52f6f', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 13:12:55');
INSERT INTO `recharge_record` VALUES ('18f1662a-711e-41a0-97c1-9d9c20efe699', '70fdddb1-3a1c-4abc-b9ed-faf16097b66f', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 13:56:43');
INSERT INTO `recharge_record` VALUES ('71475e4e-8f2e-4727-8fb0-7398f749527e', '3c7fa972-9f55-4d40-af84-87ea511aa1d3', 'b7758a53-5ac1-401c-ba69-cfe830bac1a2', 500, 100, 500, '25656727-98c2-417f-acae-37e561514bed', '2018-12-18 14:15:58');

-- ----------------------------
-- Table structure for service
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service`  (
  `serviceId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `serviceName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `servicePrice` double NULL DEFAULT NULL,
  `adminId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  `stateId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service
-- ----------------------------
INSERT INTO `service` VALUES ('ff0ae519-6d9d-4196-ad02-4921d9058ac5', '修鞋', 5, '25656727-98c2-417f-acae-37e561514bed', '2018-12-14 16:13:06', '66e75647-2b10-4553-a43d-2bb30fa33af7');
INSERT INTO `service` VALUES ('b29a9ea0-a765-4a8d-80d8-04024178c11c', '擦鞋', 15, 'afc682a8-b8b9-48bb-94d1-a044604ed6ab', '2018-12-19 10:50:15', '66e75647-2b10-4553-a43d-2bb30fa33af7');
INSERT INTO `service` VALUES ('c75b1efa-efcc-4f5e-a45b-a4355da59371', '擦鞋', 15, '6360bb1c-f0ab-482f-a878-24a92d0d41c6', '2019-01-23 14:21:00', '66e75647-2b10-4553-a43d-2bb30fa33af7');

-- ----------------------------
-- Table structure for set_meal
-- ----------------------------
DROP TABLE IF EXISTS `set_meal`;
CREATE TABLE `set_meal`  (
  `setMealId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `setMealName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `setMealPrice` double NULL DEFAULT NULL,
  `givenPrice` double NULL DEFAULT NULL,
  `adminId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  `stateId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of set_meal
-- ----------------------------
INSERT INTO `set_meal` VALUES ('62c36c3a-4ded-4a93-a865-918baabf93db', '充200送20', 200, 20, '25656727-98c2-417f-acae-37e561514bed', '2018-12-13 18:19:54', '66e75647-2b10-4553-a43d-2bb30fa33af7');
INSERT INTO `set_meal` VALUES ('b2c5ed5d-edbc-4934-9551-158c522706d8', '充300送30', 300, 30, '25656727-98c2-417f-acae-37e561514bed', '2018-12-13 18:20:56', '66e75647-2b10-4553-a43d-2bb30fa33af7');
INSERT INTO `set_meal` VALUES ('b7758a53-5ac1-401c-ba69-cfe830bac1a2', '充500送100', 500, 100, '25656727-98c2-417f-acae-37e561514bed', '2018-12-13 18:21:53', '66e75647-2b10-4553-a43d-2bb30fa33af7');

-- ----------------------------
-- Table structure for state
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state`  (
  `stateId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stateName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES ('0df82e1d-c318-423f-b506-ef0ca2e628fe', '禁用');
INSERT INTO `state` VALUES ('42e92020-10ad-4954-a94a-4e1f71673fda', '删除');
INSERT INTO `state` VALUES ('66e75647-2b10-4553-a43d-2bb30fa33af7', '正常');

SET FOREIGN_KEY_CHECKS = 1;
