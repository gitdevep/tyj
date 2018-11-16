CREATE TABLE `tb_task_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `system_id` int(11) NOT NULL COMMENT '系统ID',
  `system_unique_id` int(11) DEFAULT NULL COMMENT '系统唯一标识',
  `drive_time` datetime DEFAULT NULL COMMENT '执行时间',
  `task_type` int(11) DEFAULT NULL COMMENT '任务类型',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='状态记录表';

CREATE TABLE `device_gps_infos` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `device_id` int(11) NOT NULL COMMENT '设备ID',
  `msg_id` int(11) DEFAULT NULL COMMENT '终端带的消息ID',
  `event_time` datetime DEFAULT NULL COMMENT '数据采集时间',
  `longitude` double DEFAULT NULL COMMENT '经度',
  `latitude` double DEFAULT NULL COMMENT '纬度',
  `speed` int(4) DEFAULT NULL COMMENT '车速',
  `msg_type` tinyint(4) DEFAULT NULL COMMENT '告警类型,表:msg_type',
  `flash_state` tinyint(4) DEFAULT NULL COMMENT '设备flash状态（正常为00，当FLASH存储空间饱和为FF）',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `acceleration` float DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `event_time_id` (`event_time`,`device_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='客户原始数据表';

CREATE TABLE `device_gps_infos_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `device_id` int(11) NOT NULL COMMENT '设备编号',
  `count_date` datetime DEFAULT NULL COMMENT '统计时间',
  `drive_time` double NOT NULL DEFAULT '0' COMMENT '开车时长',
  `car_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '车辆前部碰撞',
  `limit_speed_alarm` int(11) NOT NULL DEFAULT '0' COMMENT '限速警示',
  `left_lane_deviate` int(11) NOT NULL DEFAULT '0' COMMENT '左车道偏离',
  `city_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '城市前碰撞',
  `car_distance_monitor` int(11) NOT NULL DEFAULT '0' COMMENT '车距监测',
  `right_lane_deviate` int(11) NOT NULL DEFAULT '0' COMMENT '右车道偏离',
  `car_start` int(11) NOT NULL DEFAULT '0' COMMENT '汽车启动',
  `car_end` int(11) NOT NULL DEFAULT '0' COMMENT '汽车熄火',
  `location_message` int(11) NOT NULL DEFAULT '0' COMMENT '定位信息',
  `speed_up` int(11) NOT NULL DEFAULT '0' COMMENT '急加速',
  `speed_down` int(11) NOT NULL DEFAULT '0' COMMENT '急减速',
  `vd_no_sart` int(11) NOT NULL DEFAULT '0' COMMENT 'VD未启动',
  `device_active` int(11) NOT NULL DEFAULT '0' COMMENT '设备已激活',
  `person_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '行人前部碰撞',
  `collide_follow` int(11) NOT NULL DEFAULT '0' COMMENT '碰撞跟踪',
  `device_set_success` int(11) NOT NULL DEFAULT '0' COMMENT '设备配置成功',
  `device_set_fail` int(11) NOT NULL DEFAULT '0' COMMENT '设备配置失败',
  `scores` double NOT NULL DEFAULT '0' COMMENT '平均分数',
  `sum` double NOT NULL DEFAULT '0' COMMENT '总分数',
  PRIMARY KEY (`id`),
  KEY `count_date_id` (`count_date`,`device_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='统计信息表';

CREATE TABLE `device_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '车主姓名',
  `age` int(4) NOT NULL DEFAULT '0' COMMENT '年龄',
  `driving_license` int(20) NOT NULL DEFAULT '0' COMMENT '驾照类型',
  `identity_no` varchar(18) NOT NULL DEFAULT '' COMMENT '身份证号',
  `telephone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `plate_no` varchar(7) NOT NULL DEFAULT '' COMMENT '车牌号',
  `car_type` int(4) NOT NULL DEFAULT '0' COMMENT '车型（1为私家车，2为集团车）',
  `phone_of_device` varchar(20) NOT NULL DEFAULT '' COMMENT '设备SIM卡号',
  `device_id` int(11) NOT NULL DEFAULT '0' COMMENT '设备ID',
  `weixin_account` varchar(50) NOT NULL DEFAULT '' COMMENT '微信账号',
  `create_time` datetime DEFAULT NULL COMMENT '录入时间',
  `recorder_id` int(11) NOT NULL DEFAULT '0' COMMENT '录入人ID',
  `outofdate_time` datetime NOT NULL DEFAULT '1888-08-08 08:08:08' COMMENT '设备过期时间',
  `activate_times` int(11) NOT NULL DEFAULT '0' COMMENT '有效时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='客车用户表';

CREATE TABLE `factor_warning` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '主键ID',
  `flag_type` int(11) NOT NULL DEFAULT '0' COMMENT '类型标志',
  `left_lane_deviate` int(11) NOT NULL DEFAULT '0' COMMENT '左车道偏离',
  `right_lane_deviate` int(11) NOT NULL DEFAULT '0' COMMENT '右车道偏离',
  `car_distance_monitor` int(11) NOT NULL DEFAULT '0' COMMENT '车距检测',
  `limit_speed_alarm` int(11) NOT NULL DEFAULT '0' COMMENT '限速警示',
  `city_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '城市前碰撞',
  `car_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '车辆前部碰撞',
  `description` varchar(50) NOT NULL DEFAULT '0' COMMENT '描述',
  PRIMARY KEY (`id`,`flag_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='速度配置表';

CREATE TABLE `time_warning` (
  `id` char(8) NOT NULL DEFAULT '' COMMENT '主键ID',
  `flag_type` int(11) NOT NULL DEFAULT '0' COMMENT '类型标志',
  `description` varchar(50) NOT NULL DEFAULT '' COMMENT '描述',
  `left_lane_deviate` int(11) NOT NULL DEFAULT '0' COMMENT '左车道偏离',
  `right_lane_deviate` int(11) NOT NULL DEFAULT '0' COMMENT '右车道偏离',
  `car_distance_monitor` int(11) NOT NULL DEFAULT '0' COMMENT '车距检测',
  `limit_speed_alarm` int(11) NOT NULL DEFAULT '0' COMMENT '限速警示',
  `city_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '城市前碰撞',
  `car_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '车辆前部碰撞',
  PRIMARY KEY (`id`,`flag_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='时间跟踪配置表';