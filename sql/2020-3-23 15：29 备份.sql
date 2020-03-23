/*
 Navicat Premium Data Transfer

 Source Server         : connection
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 23/03/2020 15:28:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dep_location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (2, '销售部', '深圳');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `dep_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `emp_dept_fk`(`dep_id`) USING BTREE,
  CONSTRAINT `emp_dept_fk` FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (4, '老王', 20, 2);
INSERT INTO `employee` VALUES (5, '大王', 22, 2);
INSERT INTO `employee` VALUES (6, '小王', 18, 2);
INSERT INTO `employee` VALUES (7, '王炸', 20, 2);

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES (1, 'aaa');
INSERT INTO `stu` VALUES (2, 'bbb');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `math` int(11) NULL DEFAULT NULL,
  `english` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '马云', 55, '男', '杭州', 66, 78);
INSERT INTO `student` VALUES (2, '马化腾', 45, '女', '深圳', 98, 87);
INSERT INTO `student` VALUES (3, '马景涛', 55, '男', '香港', 56, 77);
INSERT INTO `student` VALUES (4, '柳岩', 20, '女', '湖南', 76, 65);
INSERT INTO `student` VALUES (5, '柳青', 20, '男', '湖南', 86, NULL);
INSERT INTO `student` VALUES (6, '刘德华', 57, '男', '香港 ', 99, 99);
INSERT INTO `student` VALUES (7, '马德', 22, '女', '香港', 99, 99);
INSERT INTO `student` VALUES (8, '德玛西亚', 18, '男', '南京', 56, 65);
INSERT INTO `student` VALUES (9, NULL, 28, NULL, '西安', NULL, NULL);

-- ----------------------------
-- Table structure for tab_category
-- ----------------------------
DROP TABLE IF EXISTS `tab_category`;
CREATE TABLE `tab_category`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  UNIQUE INDEX `cname`(`cname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tab_category
-- ----------------------------
INSERT INTO `tab_category` VALUES (2, '出境游');
INSERT INTO `tab_category` VALUES (1, '周边游');
INSERT INTO `tab_category` VALUES (3, '国内游');
INSERT INTO `tab_category` VALUES (4, '港澳游');

-- ----------------------------
-- Table structure for tab_favorite
-- ----------------------------
DROP TABLE IF EXISTS `tab_favorite`;
CREATE TABLE `tab_favorite`  (
  `rid` int(11) NOT NULL DEFAULT 0,
  `date` datetime NULL DEFAULT NULL,
  `uid` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`rid`, `uid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `tab_favorite_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `tab_route` (`rid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tab_favorite_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `tab_user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tab_favorite
-- ----------------------------
INSERT INTO `tab_favorite` VALUES (1, '2018-01-01 00:00:00', 1);
INSERT INTO `tab_favorite` VALUES (2, '2018-02-11 00:00:00', 1);
INSERT INTO `tab_favorite` VALUES (2, '2018-04-21 00:00:00', 2);
INSERT INTO `tab_favorite` VALUES (3, '2018-03-21 00:00:00', 1);
INSERT INTO `tab_favorite` VALUES (3, '2018-05-08 00:00:00', 2);
INSERT INTO `tab_favorite` VALUES (5, '2018-06-02 00:00:00', 2);

-- ----------------------------
-- Table structure for tab_route
-- ----------------------------
DROP TABLE IF EXISTS `tab_route`;
CREATE TABLE `tab_route`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` double NULL DEFAULT NULL,
  `rdate` date NULL DEFAULT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE,
  UNIQUE INDEX `rname`(`rname`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `tab_route_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `tab_category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tab_route
-- ----------------------------
INSERT INTO `tab_route` VALUES (1, '【厦门+鼓浪屿+南普陀寺+曾厝垵 高铁 3 天 惠贵团】尝味友鸭面线 住 1 晚鼓浪屿', 1499, '2018-01-27', 1);
INSERT INTO `tab_route` VALUES (2, '【浪漫桂林 阳朔西街高铁 3 天纯玩 高级团】城徽象鼻山 兴坪漓江 西山公园', 699, '2018-02-22', 3);
INSERT INTO `tab_route` VALUES (3, '【爆款￥1699 秒杀】泰国 曼谷 芭堤雅 金沙岛 杜拉拉水上市场 双飞六天【含送签费 泰风情 广州 往返 特价团】', 1699, '2018-01-27', 2);
INSERT INTO `tab_route` VALUES (4, '【经典•狮航 ￥2399 秒杀】巴厘岛双飞五天 抵玩【广州往返 特价团】', 2399, '2017-12-23', 2);
INSERT INTO `tab_route` VALUES (5, '香港迪士尼乐园自由行 2 天【永东跨境巴士广东至迪士尼去程交通+迪士尼一日门票+香港如心海景酒店 暨会议中心标准房 1 晚住宿】', 799, '2018-04-10', 4);

-- ----------------------------
-- Table structure for tab_user
-- ----------------------------
DROP TABLE IF EXISTS `tab_user`;
CREATE TABLE `tab_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '男',
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tab_user
-- ----------------------------
INSERT INTO `tab_user` VALUES (1, 'cz110', '123456', '老王', '1977-07-07', '男', '13888888888', '66666@qq.com');
INSERT INTO `tab_user` VALUES (2, 'cz119', '654321', '小王', '1999-09-09', '男', '13999999999', '99999@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
