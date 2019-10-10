/*
Navicat MySQL Data Transfer

Source Server         : hong
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : hunnu

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-13 10:57:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `mes_id` int(11) NOT NULL,
  `mes_sender` int(11) DEFAULT NULL,
  `mes_receiver` int(11) DEFAULT NULL,
  `mes_describe` varchar(1000) DEFAULT NULL,
  `mes_time` datetime(6) DEFAULT NULL,
  `mes_states` int(11) DEFAULT NULL,
  PRIMARY KEY (`mes_id`),
  KEY `11` (`mes_sender`),
  KEY `111` (`mes_states`),
  KEY `1111` (`mes_receiver`),
  CONSTRAINT `11` FOREIGN KEY (`mes_sender`) REFERENCES `users` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `111` FOREIGN KEY (`mes_states`) REFERENCES `states` (`states_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `1111` FOREIGN KEY (`mes_receiver`) REFERENCES `users` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messages
-- ----------------------------

-- ----------------------------
-- Table structure for pets_adop
-- ----------------------------
DROP TABLE IF EXISTS `pets_adop`;
CREATE TABLE `pets_adop` (
  `pets_id` int(40) NOT NULL,
  `pets_name` varchar(100) DEFAULT NULL,
  `pets_kind` varchar(20) DEFAULT NULL,
  `pets_species` varchar(50) DEFAULT NULL,
  `pets_address` varchar(200) DEFAULT NULL,
  `pets_adopCondition` varchar(1000) DEFAULT NULL,
  `pets_describe` varchar(2000) DEFAULT NULL,
  `pets_linkman` varchar(20) DEFAULT NULL,
  `pets_lmWechat` varchar(100) DEFAULT NULL,
  `pets_lmPhone` int(12) DEFAULT NULL,
  `sender_id` int(11) DEFAULT NULL,
  `send_time` datetime(6) DEFAULT NULL,
  `pets_img` varchar(200) DEFAULT NULL,
  `isMoney` int(4) DEFAULT NULL,
  PRIMARY KEY (`pets_id`),
  KEY `pets_1` (`sender_id`),
  KEY `221` (`pets_kind`),
  CONSTRAINT `pets_1` FOREIGN KEY (`sender_id`) REFERENCES `users` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pets_adop
-- ----------------------------
INSERT INTO `pets_adop` VALUES ('1', 'pe', '狗', '田园狗', '长沙', '可爱...', '打疫苗', '王', null, '1587405029', '2', '2019-01-15 00:26:49.000000', null, null);

-- ----------------------------
-- Table structure for pets_save
-- ----------------------------
DROP TABLE IF EXISTS `pets_save`;
CREATE TABLE `pets_save` (
  `save_id` int(10) NOT NULL,
  `save_linkman` varchar(20) DEFAULT NULL,
  `save_lmPhone` varchar(11) DEFAULT NULL,
  `save_address` varchar(100) DEFAULT NULL,
  `save_describe` varchar(2000) DEFAULT NULL,
  `sender_id` int(11) DEFAULT NULL,
  `reciver_id` int(11) DEFAULT NULL,
  `save_state` int(11) DEFAULT NULL,
  `save_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`save_id`),
  KEY `save_1` (`sender_id`),
  KEY `save_2` (`reciver_id`),
  KEY `save_3` (`save_state`),
  CONSTRAINT `save_1` FOREIGN KEY (`sender_id`) REFERENCES `users` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `save_2` FOREIGN KEY (`reciver_id`) REFERENCES `users` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `save_3` FOREIGN KEY (`save_state`) REFERENCES `states` (`states_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pets_save
-- ----------------------------

-- ----------------------------
-- Table structure for pets_trade
-- ----------------------------
DROP TABLE IF EXISTS `pets_trade`;
CREATE TABLE `pets_trade` (
  `trade_id` int(40) NOT NULL,
  `pets_id` int(40) DEFAULT NULL,
  `trade_applyman` int(11) DEFAULT NULL,
  `trade_respondman` int(11) DEFAULT NULL,
  `trade_states` int(11) DEFAULT NULL,
  `trade_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`trade_id`),
  KEY `1` (`pets_id`),
  KEY `2` (`trade_applyman`),
  KEY `3` (`trade_respondman`),
  KEY `4` (`trade_states`),
  CONSTRAINT `1` FOREIGN KEY (`pets_id`) REFERENCES `pets_adop` (`pets_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `2` FOREIGN KEY (`trade_applyman`) REFERENCES `users` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `3` FOREIGN KEY (`trade_respondman`) REFERENCES `users` (`users_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `4` FOREIGN KEY (`trade_states`) REFERENCES `states` (`states_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pets_trade
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `roles_id` int(11) NOT NULL,
  `roles_name` varchar(20) DEFAULT NULL,
  KEY `roles_id` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '管理员');
INSERT INTO `roles` VALUES ('2', '普通用户');

-- ----------------------------
-- Table structure for states
-- ----------------------------
DROP TABLE IF EXISTS `states`;
CREATE TABLE `states` (
  `states_id` int(11) NOT NULL,
  `states_describe` varchar(100) DEFAULT NULL,
  KEY `states_id` (`states_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of states
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `users_id` int(11) NOT NULL,
  `users_name` varchar(20) DEFAULT NULL,
  `users_password` varchar(32) DEFAULT NULL,
  `users_address` varchar(200) DEFAULT NULL,
  `users_phone` varchar(11) DEFAULT NULL,
  `users_role` int(11) DEFAULT NULL,
  `users_img` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`users_id`),
  KEY `users_1` (`users_role`),
  CONSTRAINT `users_1` FOREIGN KEY (`users_role`) REFERENCES `roles` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'hong', '123456', '长沙', '15874050298', '1', null);
INSERT INTO `users` VALUES ('2', 'root', 'root', '长沙', '11111111111', '2', null);
