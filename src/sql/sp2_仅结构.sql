/*
Navicat MySQL Data Transfer

Source Server         : 112.90.89.16_开发
Source Server Version : 50722
Source Host           : 112.90.89.16:3306
Source Database       : sp2

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-30 18:00:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity_register
-- ----------------------------
DROP TABLE IF EXISTS `activity_register`;
CREATE TABLE `activity_register` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '活动名称',
  `code` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` datetime NOT NULL,
  `status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'online offline',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='活动注册';

-- ----------------------------
-- Table structure for banner_pic
-- ----------------------------
DROP TABLE IF EXISTS `banner_pic`;
CREATE TABLE `banner_pic` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `pic_url` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '图片url',
  `pic_order` int(11) DEFAULT NULL COMMENT '排序',
  `pic_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片名称',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1：已删除;0：正常',
  `type` tinyint(4) NOT NULL,
  `position` int(11) NOT NULL COMMENT '1微信首页banner，2支付宝首页banner',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for bargain_record
-- ----------------------------
DROP TABLE IF EXISTS `bargain_record`;
CREATE TABLE `bargain_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `bargain_system` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `activity_id` bigint(20) NOT NULL COMMENT '活动ID',
  `user_id` varchar(45) DEFAULT NULL,
  `thirdparty` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID来源',
  `thirdparty_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '被邀请人ID',
  `thirdparty_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '被邀请人姓名',
  `thirdparty_head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '被邀请人头像URL',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '机票价格',
  `discount_percent` decimal(10,2) DEFAULT '0.00' COMMENT '优惠折扣',
  `discount_amt` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `blessing_value` varchar(145) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '祝福语',
  `client_ip` varchar(45) DEFAULT NULL COMMENT '客户端IP',
  `remark` varchar(245) DEFAULT NULL COMMENT '备注',
  `operate_time` datetime NOT NULL COMMENT '点赞时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for common_bargain_activity
-- ----------------------------
DROP TABLE IF EXISTS `common_bargain_activity`;
CREATE TABLE `common_bargain_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
  `thirdparty` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '第三方',
  `thirdparty_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thirdparty_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `thirdparty_head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户头像URL',
  `activity_date` date NOT NULL COMMENT '活动日期',
  `status` varchar(20) NOT NULL COMMENT '活动状态:VOTING("投票中"),CLOSED("已结束")',
  `upvote_time` int(11) NOT NULL DEFAULT '0' COMMENT '点赞次数',
  `discount_amt` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `ranking` int(11) DEFAULT NULL COMMENT '排名',
  `reserve` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '优惠券名称',
  `code` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `activity_id` bigint(20) DEFAULT NULL,
  `type` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '券的类型：CASH(“现金券”), DISCOUNT(“折扣券”)',
  `scope` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '范围：ALL(“通用”),FLIGHT(“机票”),HOTEL(“酒店”),TRAIN(“火车票”)；',
  `source` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'FLIGHT_BARGAIN("机票砍价"), HOTEL_BARGAIN("酒店砍价"), TRAIN_BARGAIN("火车票砍价"), TRAIN_STUDENT_GROUP("火车票学生拼团"), PTT("平团团");',
  `amount` decimal(12,2) DEFAULT NULL COMMENT '券的金额',
  `discount` decimal(8,4) DEFAULT NULL COMMENT '券的折扣',
  `min_limit` decimal(12,2) DEFAULT '0.00' COMMENT '消费满多少时可用，0表示无门槛',
  `most_deduction` decimal(12,2) DEFAULT NULL COMMENT '最高抵扣,当为折扣券时，此字段必填',
  `open_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '券生效时间，默认创建券的时间',
  `close_time` datetime NOT NULL COMMENT '券失效时间',
  `status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态：CAN_USE(“未使用”),USED(“已使用”),EXPIRED(“已过期”)',
  `ctime` datetime NOT NULL,
  `utime` datetime NOT NULL,
  `self_superposition` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '是否可以和自己叠加（两张同类型的券一起使用）',
  `other_superposition` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '是否可以和其他类型的券叠加',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='优惠券';

-- ----------------------------
-- Table structure for coupon_operation_record
-- ----------------------------
DROP TABLE IF EXISTS `coupon_operation_record`;
CREATE TABLE `coupon_operation_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_id` bigint(20) NOT NULL COMMENT '优惠券ID',
  `source` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '来源',
  `code` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '优惠券编码',
  `operation_type` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作类型：发放，使用，释放，过期',
  `bussiness_system` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作系统：机票，酒店，火车票，小程序',
  `bussiness_orderno` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '业务系统订单号',
  `reason` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '释放优惠券的原因',
  `remark` varchar(245) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注说明',
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='优惠券操作记录';

-- ----------------------------
-- Table structure for flight_bargain_activity
-- ----------------------------
DROP TABLE IF EXISTS `flight_bargain_activity`;
CREATE TABLE `flight_bargain_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
  `thirdparty` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '第三方',
  `thirdparty_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thirdparty_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `thirdparty_head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户头像URL',
  `weekday` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '周几',
  `activity_date` date NOT NULL COMMENT '活动日期',
  `departure_place` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '出发地',
  `arrival_place` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '到达地',
  `departure_date` date DEFAULT NULL COMMENT '出发日期',
  `status` int(11) NOT NULL COMMENT '活动状态:-1:过期未购买;1:投票中;2:已购买;3:可购买;4:不可购买;5:出票失败',
  `upvote_time` int(11) NOT NULL DEFAULT '0' COMMENT '点赞次数',
  `pre_ticket_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠前机票价格',
  `discount_percent` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '折扣比率',
  `discount_amt` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `after_ticket_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠后机票价格',
  `ranking` int(11) DEFAULT NULL COMMENT '排名',
  `form_id` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reserve` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for hotel_bargain_activity
-- ----------------------------
DROP TABLE IF EXISTS `hotel_bargain_activity`;
CREATE TABLE `hotel_bargain_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
  `thirdparty` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thirdparty_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thirdparty_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `thirdparty_head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户头像URL',
  `check_out_date` date NOT NULL COMMENT '离店日期',
  `activity_date` date NOT NULL COMMENT '活动日期',
  `nights` int(11) DEFAULT NULL,
  `room_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hotel_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '出发地',
  `room_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '到达地',
  `check_in_date` date DEFAULT NULL COMMENT '出发日期',
  `status` int(11) NOT NULL COMMENT '活动状态:-1:过期未购买;1:投票中;2:已购买;3:可购买;4:不可购买;5:出票失败',
  `upvote_time` int(11) NOT NULL DEFAULT '0' COMMENT '点赞次数',
  `pre_hotel_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠前机票价格',
  `discount_percent` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '折扣比率',
  `discount_amt` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `after_hotel_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠后机票价格',
  `ranking` int(11) DEFAULT NULL COMMENT '排名',
  `form_id` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reserve` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for ptt_activity
-- ----------------------------
DROP TABLE IF EXISTS `ptt_activity`;
CREATE TABLE `ptt_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `user_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thirdparty` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `thirdparty_user_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `thirdparty_nickname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `thirdparty_head_icon` varchar(245) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `endtime` datetime NOT NULL COMMENT '拼团团活动结束时间',
  `limit_num` int(11) NOT NULL DEFAULT '6' COMMENT '活动限制参与人数',
  `current_num` int(11) NOT NULL DEFAULT '1' COMMENT '当前参与人数',
  `status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'NEW' COMMENT '状态：NEW("新建"),SUCCESS("拼团成功"),FAIL("拼团失败"), WIN("中奖"), LOSE("未中奖");',
  `ctime` datetime NOT NULL,
  `utime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for ptt_activity_member
-- ----------------------------
DROP TABLE IF EXISTS `ptt_activity_member`;
CREATE TABLE `ptt_activity_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) NOT NULL COMMENT '拼团团活动ID',
  `user_id` varchar(45) NOT NULL,
  `thirdparty` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `thirdparty_user_id` varchar(145) NOT NULL,
  `thirdparty_nickname` varchar(45) NOT NULL,
  `thirdparty_head_icon` varchar(245) DEFAULT NULL,
  `role` varchar(45) NOT NULL COMMENT '成员角色:CREATOR("创建者"),MEMBER("普通成员")',
  `ctime` datetime NOT NULL,
  `utime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for push_message_record
-- ----------------------------
DROP TABLE IF EXISTS `push_message_record`;
CREATE TABLE `push_message_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `thirdparty` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `thirdparty_user_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `thirdparty_nickname` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `thirdparty_head_portrait` varchar(245) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `form_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `activity_id` bigint(20) DEFAULT NULL,
  `activity_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动名称',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `remark` varchar(245) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `result` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='推送消息记录';

-- ----------------------------
-- Table structure for speed_bargain_activity
-- ----------------------------
DROP TABLE IF EXISTS `speed_bargain_activity`;
CREATE TABLE `speed_bargain_activity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL COMMENT '马踏飞燕用户ID',
  `thirdparty` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '第三方',
  `thirdparty_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thirdparty_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `thirdparty_head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户头像URL',
  `bussiness_system` varchar(45) NOT NULL COMMENT '业务系统：FLIGHT("机票"), HOTEL("酒店"), TRAIN("火车票")',
  `order_no` varchar(45) NOT NULL COMMENT '订单号',
  `order_amount` decimal(12,2) NOT NULL COMMENT '订单总金额',
  `after_order_amount` decimal(12,2) NOT NULL COMMENT '优惠后的金额',
  `end_time` datetime NOT NULL COMMENT '砍价结束时间',
  `join_num` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '砍价人数',
  `total_bargain_amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '总砍价金额',
  `status` varchar(45) NOT NULL DEFAULT 'ONGOING' COMMENT 'ONGOING(“进行中”),SUCCESS(“成功”),FAIL(“失败”),HAD_ACKNOWLEDGE(“已答谢”)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='极速砍价活动';

-- ----------------------------
-- Table structure for speed_bargain_record
-- ----------------------------
DROP TABLE IF EXISTS `speed_bargain_record`;
CREATE TABLE `speed_bargain_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) NOT NULL COMMENT '活动ID',
  `user_id` varchar(45) DEFAULT NULL,
  `thirdparty` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '第三方',
  `thirdparty_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '第三方用户ID',
  `thirdparty_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第三方用户昵称',
  `thirdparty_head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第三方用户头像',
  `red_envelope_amount` decimal(10,2) NOT NULL COMMENT '倍数',
  `discount_amt` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `before_amount` decimal(12,2) NOT NULL COMMENT '砍价之前的金额',
  `after_amount` decimal(12,2) NOT NULL COMMENT '优惠之后的金额',
  `status` varchar(20) NOT NULL COMMENT 'ENABLE("能翻倍"),DISENABLE("不能翻倍"),HAD("已翻倍"),EXPIRED("过期未翻倍")',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for spinwin_activity
-- ----------------------------
DROP TABLE IF EXISTS `spinwin_activity`;
CREATE TABLE `spinwin_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
  `thirdparty` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '第三方',
  `thirdparty_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thirdparty_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `thirdparty_head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户头像URL',
  `activity_date` date NOT NULL COMMENT '活动日期',
  `end_time` datetime NOT NULL COMMENT '活动结束时间',
  `hold_times` int(11) NOT NULL DEFAULT '3' COMMENT '当前抽奖次数',
  `opened_times` int(11) DEFAULT '0' COMMENT '已抽奖次数',
  `coupon_opened` int(11) DEFAULT '0' COMMENT '已开优惠券数',
  `total_amount` decimal(10,2) DEFAULT '0.00' COMMENT '抽取总金额',
  `total_invite` int(11) DEFAULT '1' COMMENT '邀新人数',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for spinwin_activity_broadcast
-- ----------------------------
DROP TABLE IF EXISTS `spinwin_activity_broadcast`;
CREATE TABLE `spinwin_activity_broadcast` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `amount` decimal(10,2) DEFAULT '0.00' COMMENT '奖项金额',
  `type` tinyint(4) DEFAULT NULL COMMENT '活动项目',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for spinwin_activity_member
-- ----------------------------
DROP TABLE IF EXISTS `spinwin_activity_member`;
CREATE TABLE `spinwin_activity_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '拼运气活动ID',
  `user_id` varchar(45) NOT NULL COMMENT '用户ID',
  `thirdparty` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '第三方',
  `thirdparty_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thirdparty_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `thirdparty_head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户头像URL',
  `role` varchar(45) DEFAULT NULL COMMENT '成员角色:CREATOR("创建者"),MEMBER("普通成员")',
  `invite_order` int(11) DEFAULT '0' COMMENT '被邀新次序',
  `coupon_amount` decimal(12,2) DEFAULT '0.00' COMMENT '助力红包金额',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for spinwin_activity_prize
-- ----------------------------
DROP TABLE IF EXISTS `spinwin_activity_prize`;
CREATE TABLE `spinwin_activity_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prize_amount` decimal(10,2) DEFAULT '0.00' COMMENT '奖项金额',
  `prize_desc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '奖项描述',
  `prize_pic` varchar(255) NOT NULL COMMENT '奖项图片地址',
  `prize_order` int(11) DEFAULT NULL COMMENT '排序',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1：已删除;0：正常',
  `prob` tinyint(4) DEFAULT NULL COMMENT '获奖概率,百分数的分子部分,取值范围(0,100)',
  `type` tinyint(4) DEFAULT NULL COMMENT '活动项目',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_blessings
-- ----------------------------
DROP TABLE IF EXISTS `t_blessings`;
CREATE TABLE `t_blessings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(45) NOT NULL,
  `value` varchar(145) NOT NULL,
  `ctime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `key_UNIQUE` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_red_envelope_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_red_envelope_activity`;
CREATE TABLE `t_red_envelope_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `user_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者ID',
  `thirdparty` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '第三方：ali_mp_mtfy("支付宝小程序马踏飞燕"), wx_microprogram_yijianGO("微信小程序一键购"), wx_microprogram("微信小程序"), wx_microprogram_flight("微信小程序机票"), wx_microprogram_train("微信小程序火车票");',
  `thirdparty_user_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '第三方用户id',
  `thirdparty_nickname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第三方用户昵称',
  `thirdparty_head_icon` varchar(245) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第三方用户头像地址',
  `endtime` datetime NOT NULL COMMENT '活动结束时间',
  `limit_num` int(11) DEFAULT '4' COMMENT '最多红包数',
  `current_num` int(11) DEFAULT '0' COMMENT '已拥有开红包次数',
  `opened_num` int(11) DEFAULT '0' COMMENT '已开红包数',
  `total_amount` decimal(12,2) DEFAULT NULL COMMENT '当前红包总金额',
  `total_invite` int(11) DEFAULT '0' COMMENT '当前邀请人数',
  `status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'ALIVE' COMMENT 'ALIVE("进行中"), EXPIRED("已过期")',
  `ctime` datetime NOT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='马上红包活动表';

-- ----------------------------
-- Table structure for t_red_envelope_activity_member
-- ----------------------------
DROP TABLE IF EXISTS `t_red_envelope_activity_member`;
CREATE TABLE `t_red_envelope_activity_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '红包活动ID',
  `user_id` varchar(45) NOT NULL COMMENT '用户ID',
  `thirdparty` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `thirdparty_user_id` varchar(145) DEFAULT NULL,
  `thirdparty_nickname` varchar(45) DEFAULT NULL,
  `thirdparty_head_icon` varchar(245) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL COMMENT '成员角色:CREATOR("创建者"),MEMBER("普通成员")',
  `red_amount` decimal(12,2) DEFAULT NULL COMMENT '助力红包金额',
  `position` int(11) DEFAULT '0' COMMENT '红包位置次序',
  `reserve` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '预留字段',
  `ctime` datetime NOT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for train_bargain_activity
-- ----------------------------
DROP TABLE IF EXISTS `train_bargain_activity`;
CREATE TABLE `train_bargain_activity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户id',
  `thirdparty` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thirdparty_user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `thirdparty_nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `thirdparty_head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户头像URL',
  `weekday` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '周几',
  `activity_date` date NOT NULL COMMENT '活动日期',
  `departure_place` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '出发地',
  `arrival_place` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '到达地',
  `departure_date` date DEFAULT NULL COMMENT '出发日期',
  `status` int(11) NOT NULL COMMENT '活动状态:-1:过期未购买;1:投票中;2:已购买;3:可购买;4:不可购买',
  `upvote_time` int(11) NOT NULL DEFAULT '0' COMMENT '点赞次数',
  `pre_ticket_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠前火车票价格',
  `discount_percent` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '折扣比率',
  `discount_amt` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `after_ticket_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠后火车票价格',
  `ranking` int(11) DEFAULT NULL COMMENT '排名',
  `form_id` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reserve` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备用字段',
  `discount_coupon_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
