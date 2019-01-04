-- ----------------------------
-- Table structure for `order_3party`
-- ----------------------------
DROP TABLE IF EXISTS `order_3party`;
CREATE TABLE `order_3party` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT,
  `reseive_address` varchar(100) DEFAULT NULL,
  `buyer_name` varchar(50) DEFAULT NULL,
  `buyer_phone` varchar(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of order_3party
-- ----------------------------
INSERT INTO `order_3party` VALUES ('1', '第三方', '张三', '123132134', '2019-01-03 17:40:05');

-- ----------------------------
-- Table structure for `order_promotion_3party`
-- ----------------------------
DROP TABLE IF EXISTS `order_promotion_3party`;
CREATE TABLE `order_promotion_3party` (
  `tid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `promotion_name` varchar(200) DEFAULT NULL,
  `discount_fee` varchar(50) DEFAULT NULL,
  `partner_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_promotion_3party
-- ----------------------------
INSERT INTO `order_promotion_3party` VALUES ('1', '第三方', '5412.21', '9');
