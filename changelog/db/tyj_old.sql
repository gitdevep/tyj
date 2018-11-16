DROP TABLE IF EXISTS `jichujingshifen`;
CREATE TABLE `jichujingshifen` (
`id`  INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
`headwayMonitoringWarning`  INT(11) NOT NULL DEFAULT 30 COMMENT '车距监测',
`urbanForwardCollisionWarning`  INT(11) NOT NULL DEFAULT 20 COMMENT '城市前碰撞',
`forwardCollisionWarning`  INT(11) NOT NULL DEFAULT 80 COMMENT '车辆前部碰撞',
`overSpeedWarning`  INT(11) NOT NULL DEFAULT 40 COMMENT '限速警示',
`leftLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 40 COMMENT '左车道偏离',
`rightLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 40 COMMENT '右车道偏离',
PRIMARY KEY (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='基础分表';
INSERT INTO `jichujingshifen` VALUES (1, '30', '20', '80', '40', '40', '40');

DROP TABLE IF EXISTS `seq_warning`;
CREATE TABLE `seq_warning` (
`id`  INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
`headwayMonitoringWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '车距监测',
`urbanForwardCollisionWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '城市前碰撞',
`forwardCollisionWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '车辆前部碰撞',
`overSpeedWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '限速警示',
`leftLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '左车道偏离',
`rightLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '右车道偏离',
`description`  varchar(50) NOT NULL DEFAULT 0 COMMENT '描述',
PRIMARY KEY (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='分表';
INSERT INTO `seq_warning` VALUES (1, '40', '0', '0', '50', '50', '50', 'headwayMonitoringWarning(30)'), (2, '0', '25', '85', '45', '45', '45', 'urbanForwardCollisionWarning(20)'), (3, '0', '0', '90', '50', '50', '50', 'forwardCollisionWarning(80)'), (4, '40', '25', '95', '50', '45', '45', 'overSpeedWarning(40)'), (5, '40', '0', '95', '45', '45', '55', 'leftLaneDepartureWarning(40)'), (6, '40', '0', '95', '45', '55', '45', 'rightLaneDepartureWarning(40)');

DROP TABLE IF EXISTS `speed_factor`;
CREATE TABLE `speed_factor` (
`range_start`  INT(11) NOT NULL COMMENT '开始时间',
`range_end`  INT(11) NOT NULL COMMENT '结束时间',
`headwayMonitoringWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '车距监测',
`urbanForwardCollisionWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '城市前碰撞',
`forwardCollisionWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '车辆前部碰撞',
`overSpeedWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '限速警示',
`leftLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '左车道偏离',
`rightLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '右车道偏离',
PRIMARY KEY (`range_start`, `range_end`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='速度表';
INSERT INTO `speed_factor` VALUES ('0', '10', '0', '0', '0', '0', '0', '0'),('10', '20', '0', '0', '0', '0', '0', '0'), ('20', '30', '0', '0', '0', '0', '0', '0'), ('30', '40', '5', '5', '0', '0', '0', '0'), ('40', '50', '10', '10', '0', '5', '0', '0'), ('50', '60', '15', '15', '5', '10', '0', '0'), ('60', '70', '20', '20', '10', '15', '5', '5'), ('70', '80', '25', '25', '15', '20', '10', '10'), ('80', '90', '30', '30', '20', '25', '15', '15'), ('90', '100', '35', '35', '25', '30', '20', '20'), ('100', '110', '40', '40', '30', '35', '25', '25'), ('110', '120', '45', '45', '35', '40', '30', '30'), ('120', '130', '50', '50', '40', '45', '35', '35'), ('130', '140', '55', '55', '45', '50', '40', '40'), ('140', '150', '60', '60', '50', '55', '45', '45'), ('150', '160', '65', '65', '55', '60', '50', '50'), ('160', '170', '70', '70', '60', '65', '55', '55'), ('170', '180', '75', '75', '65', '70', '60', '60'), ('180', '190', '80', '80', '70', '75', '65', '65'), ('190', '200', '85', '85', '75', '80', '70', '70'), ('200', '210', '90', '90', '80', '85', '75', '75'), ('210', '220', '95', '95', '85', '90', '80', '80'), ('220', '230', '100', '100', '90', '95', '85', '85'), ('230', '240', '105', '105', '95', '100', '90', '90'), ('240', '250', '110', '110', '100', '105', '95', '95'), ('250', '260', '115', '115', '105', '110', '100', '100'), ('260', '270', '120', '120', '110', '115', '105', '105'), ('270', '280', '125', '125', '115', '120', '110', '110'), ('280', '290', '130', '130', '120', '125', '115', '115'), ('290', '300', '135', '135', '125', '130', '120', '120');

DROP TABLE IF EXISTS `time_slot_fatigue`;
CREATE TABLE `time_slot_fatigue` (
`range_start`  DATETIME NOT NULL COMMENT '开始时间',
`range_end`  DATETIME NOT NULL COMMENT '结束时间',
`headwayMonitoringWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '车距监测',
`urbanForwardCollisionWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '城市前碰撞',
`forwardCollisionWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '车辆前部碰撞',
`overSpeedWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '限速警示',
`leftLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '左车道偏离',
`rightLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '右车道偏离',
PRIMARY KEY (`range_start`, `range_end`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='疲劳度表';
INSERT INTO `time_slot_fatigue` VALUES ('2000-01-01 00:00:00', '2000-01-01 00:30:00', '0', '0', '0', '0', '0', '0'), ('2000-01-01 00:30:00', '2000-01-01 02:30:00', '5', '5', '5', '5', '5', '5'), ('2000-01-01 02:30:00', '2000-01-01 06:00:00', '10', '10', '10', '10', '10', '10'),  ('2000-01-01 06:00:00', '2000-01-01 10:00:00', '5', '5', '5', '5', '5', '5'), ('2000-01-01 10:00:00', '2000-01-01 23:59:59', '0', '0', '0', '0', '0', '0');

DROP TABLE IF EXISTS `time_span_fatigue`;
CREATE TABLE `time_span_fatigue` (
`driving_span`  INT(11) NOT NULL COMMENT '驾驶时间',
`headwayMonitoringWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '车距监测',
`urbanForwardCollisionWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '城市前碰撞',
`forwardCollisionWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '车辆前部碰撞',
`overSpeedWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '限速警示',
`leftLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '左车道偏离',
`rightLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '右车道偏离',
PRIMARY KEY (`driving_span`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='驾驶时长表';
INSERT INTO `time_span_fatigue` VALUES ('0', '1', '1', '1', '1', '1', '1'), ('1', '2', '2', '2', '2', '2', '2'), ('2', '3', '3', '3', '3', '3', '3'), ('3', '5', '5', '5', '5', '5', '5'), ('4', '10', '10', '10', '10', '10', '10'), ('5', '15', '15', '15', '15', '15', '15'), ('6', '20', '20', '20', '20', '20', '20'), ('7', '25', '25', '25', '25', '25', '25'), ('8', '30', '30', '30', '30', '30', '30'), ('9', '35', '35', '35', '35', '35', '35'), ('10', '40', '40', '40', '40', '40', '40'), ('11', '45', '45', '45', '45', '45', '45'), ('12', '50', '50', '50', '50', '50', '50'), ('13', '55', '55', '55', '55', '55', '55');

DROP TABLE IF EXISTS `visibility_factor`;
CREATE TABLE `visibility_factor` (
`range_start`  DATETIME NOT NULL COMMENT '开始时间',
`range_end`  DATETIME NOT NULL COMMENT '结束时间',
`headwayMonitoringWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '车距监测',
`urbanForwardCollisionWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '城市前碰撞',
`forwardCollisionWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '车辆前部碰撞',
`overSpeedWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '限速警示',
`leftLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '左车道偏离',
`rightLaneDepartureWarning`  INT(11) NOT NULL DEFAULT 0 COMMENT '右车道偏离',
PRIMARY KEY (`range_start`, `range_end`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='能见度表';
INSERT INTO `visibility_factor` VALUES ('2000-01-01 00:00:00', '2000-01-01 05:00:00', '6', '6', '6', '6', '6', '6'), ('2000-01-01 05:00:00', '2000-01-01 08:00:00', '8', '8', '8', '8', '8', '8'), ('2000-01-01 08:00:00', '2000-01-01 17:00:00', '0', '0', '0', '0', '0', '0'), ('2000-01-01 17:00:00', '2000-01-01 21:00:00', '4', '4', '4', '4', '4', '4'), ('2000-01-01 21:00:00', '2000-01-01 23:59:59', '6', '6', '6', '6', '6', '6');

DROP TABLE IF EXISTS `driving_evaluation`;
CREATE TABLE `driving_evaluation` (
`id`  INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
`device_id`  INT(11) NOT NULL DEFAULT 0 COMMENT '设备号',
`evaluate_time`  DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '计算时间',
`scores`  double NOT NULL DEFAULT 0 COMMENT '分数',
`driving_time`  INT(11) NOT NULL DEFAULT 0 COMMENT '驾驶时间',
`sum`  INT(11) NOT NULL DEFAULT 0 COMMENT '总数',
PRIMARY KEY (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='驾驶时长表';

DROP TABLE IF EXISTS `factor_adjustor`;
CREATE TABLE `factor_adjustor` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
`seq_warning_adjustor`  int(11) NULL DEFAULT NULL ,
`speed_adjustor`  int(11) NULL DEFAULT NULL ,
`time_slot_fatigue_adjustor`  int(11) NULL DEFAULT NULL ,
`time_span_fatigure_adjustor`  int(11) NULL DEFAULT NULL ,
`visibility_adjustor`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='条件因素表';
INSERT INTO `factor_adjustor` VALUES ('1', '1', '1', '2', '2', '2');

DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `device_id` int(11) DEFAULT NULL COMMENT '设备号',
  `msg_id` int(11) DEFAULT NULL COMMENT '消息ID',
  `event_time` datetime DEFAULT NULL COMMENT '事件时间',
  `longitude` double DEFAULT NULL COMMENT '经度',
  `latitude` double DEFAULT NULL COMMENT '纬度',
  `speed` tinyint(4) DEFAULT NULL COMMENT '速度',
  `msg_type` tinyint(4) DEFAULT NULL COMMENT '消息类型',
  `flash_state` tinyint(4) DEFAULT NULL COMMENT '状态',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `drive_state` tinyint(4) DEFAULT NULL COMMENT '驾驶状态',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='日志表';