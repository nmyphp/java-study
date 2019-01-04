-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT,
  `reseive_address` varchar(100) DEFAULT NULL,
  `buyer_name` varchar(50) DEFAULT NULL,
  `buyer_phone` varchar(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '默认', '李四', '1321545461', '2019-01-03 17:44:23');

-- ----------------------------
-- Table structure for `order_promotion`
-- ----------------------------
DROP TABLE IF EXISTS `order_promotion`;
CREATE TABLE `order_promotion` (
  `tid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `promotion_name` varchar(200) DEFAULT NULL,
  `discount_fee` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of order_promotion
-- ----------------------------
INSERT INTO `order_promotion` VALUES ('1', '默认', '6005.23');
