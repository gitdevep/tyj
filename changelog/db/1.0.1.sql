CREATE TABLE `device_gps_infos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `device_id` INT(11) NOT NULL COMMENT '设备ID',
  `msg_id` INT(11) DEFAULT NULL COMMENT '终端带的消息ID',
  `event_time` DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '数据采集时间',
  `longitude` DOUBLE DEFAULT NULL COMMENT '经度',
  `latitude` DOUBLE DEFAULT NULL COMMENT '纬度',
  `speed` INT(4) DEFAULT NULL COMMENT '车速',
  `msg_type` TINYINT(4) DEFAULT NULL COMMENT '告警类型,表:msg_type',
  `flash_state` TINYINT(4) DEFAULT NULL COMMENT '设备flash状态（正常为00，当FLASH存储空间饱和为FF）',
  `upload_time` DATETIME DEFAULT NULL COMMENT '上传时间',
  `acceleration` FLOAT DEFAULT '0' COMMENT '加速度',
  PRIMARY KEY (`id`,`event_time`),
  KEY `event_time_id` (`event_time`,`device_id`)
) ENGINE=MYISAM DEFAULT CHARSET=utf8 COMMENT='客户原始数据表'
 PARTITION BY RANGE (TO_DAYS(event_time))
(PARTITION p20151001 VALUES LESS THAN (TO_DAYS('20151001')),
 PARTITION p20151101 VALUES LESS THAN (TO_DAYS('20151101')),
 PARTITION p20151201 VALUES LESS THAN (TO_DAYS('20151201')),
 PARTITION p20160101 VALUES LESS THAN (TO_DAYS('20160101')),
 PARTITION p20160201 VALUES LESS THAN (TO_DAYS('20160201')),
 PARTITION p20160301 VALUES LESS THAN (TO_DAYS('20160301')),
 PARTITION p20160401 VALUES LESS THAN (TO_DAYS('20160401')));


CREATE TABLE `tb_condition_base_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `flag_type` int(11) NOT NULL DEFAULT '0' COMMENT '条件类型标志',
  `car_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '车辆前部碰撞',
  `limit_speed_alarm` int(11) NOT NULL DEFAULT '0' COMMENT '限速警示',
  `left_lane_deviate` int(11) NOT NULL DEFAULT '0' COMMENT '左车道偏离',
  `city_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '城市前碰撞',
  `car_distance_monitor` int(11) NOT NULL DEFAULT '0' COMMENT '车距监测',
  `right_lane_deviate` int(11) NOT NULL DEFAULT '0' COMMENT '右车道偏离',
  `car_start` int(11) NOT NULL DEFAULT '0' COMMENT '汽车启动',
  `car_end` int(11) NOT NULL DEFAULT '0' COMMENT '汽车熄火',
  `speed_up` int(11) NOT NULL DEFAULT '0' COMMENT '急加速',
  `speed_down` int(11) NOT NULL DEFAULT '0' COMMENT '急减速',
  `person_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '行人前部碰撞',
  `collide_follow` int(11) NOT NULL DEFAULT '0' COMMENT '碰撞跟踪',
  `car_collide_follow` int(11) NOT NULL DEFAULT '0' COMMENT '车辆前部碰撞跟踪',
  `person_collide_follow` int(11) NOT NULL DEFAULT '0' COMMENT '行人前部碰撞跟踪',
  `one_car_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '一类车辆前部碰撞',
  `two_car_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '二类车辆前部碰撞',
  `description` varchar(50) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_flag_type` (`flag_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='条件基础分数表';

insert into `tb_condition_base_score` (`id`, `flag_type`, `car_front_collide`, `limit_speed_alarm`, `left_lane_deviate`, `city_front_collide`, `car_distance_monitor`, `right_lane_deviate`, `car_start`, `car_end`, `speed_up`, `speed_down`, `person_front_collide`, `collide_follow`, `car_collide_follow`, `person_collide_follow`, `one_car_front_collide`, `two_car_front_collide`, `description`) values('1','1','90','90','90','90','90','90','0','0','90','90','90','0','90','90','90','90','速度');
insert into `tb_condition_base_score` (`id`, `flag_type`, `car_front_collide`, `limit_speed_alarm`, `left_lane_deviate`, `city_front_collide`, `car_distance_monitor`, `right_lane_deviate`, `car_start`, `car_end`, `speed_up`, `speed_down`, `person_front_collide`, `collide_follow`, `car_collide_follow`, `person_collide_follow`, `one_car_front_collide`, `two_car_front_collide`, `description`) values('2','2','90','90','90','90','90','90','0','0','90','90','90','0','90','90','90','90','每天驾驶时长');
insert into `tb_condition_base_score` (`id`, `flag_type`, `car_front_collide`, `limit_speed_alarm`, `left_lane_deviate`, `city_front_collide`, `car_distance_monitor`, `right_lane_deviate`, `car_start`, `car_end`, `speed_up`, `speed_down`, `person_front_collide`, `collide_follow`, `car_collide_follow`, `person_collide_follow`, `one_car_front_collide`, `two_car_front_collide`, `description`) values('3','3','90','90','90','90','90','90','0','0','90','90','90','0','90','90','90','90','前后时间间隔');
insert into `tb_condition_base_score` (`id`, `flag_type`, `car_front_collide`, `limit_speed_alarm`, `left_lane_deviate`, `city_front_collide`, `car_distance_monitor`, `right_lane_deviate`, `car_start`, `car_end`, `speed_up`, `speed_down`, `person_front_collide`, `collide_follow`, `car_collide_follow`, `person_collide_follow`, `one_car_front_collide`, `two_car_front_collide`, `description`) values('4','4','90','90','90','90','90','90','0','0','90','90','90','0','90','90','90','90','天气条件');
insert into `tb_condition_base_score` (`id`, `flag_type`, `car_front_collide`, `limit_speed_alarm`, `left_lane_deviate`, `city_front_collide`, `car_distance_monitor`, `right_lane_deviate`, `car_start`, `car_end`, `speed_up`, `speed_down`, `person_front_collide`, `collide_follow`, `car_collide_follow`, `person_collide_follow`, `one_car_front_collide`, `two_car_front_collide`, `description`) values('5','5','90','90','90','90','90','90','0','0','90','90','90','0','90','90','90','90','疲劳度');
insert into `tb_condition_base_score` (`id`, `flag_type`, `car_front_collide`, `limit_speed_alarm`, `left_lane_deviate`, `city_front_collide`, `car_distance_monitor`, `right_lane_deviate`, `car_start`, `car_end`, `speed_up`, `speed_down`, `person_front_collide`, `collide_follow`, `car_collide_follow`, `person_collide_follow`, `one_car_front_collide`, `two_car_front_collide`, `description`) values('6','6','90','90','90','90','90','90','0','0','90','90','90','0','90','90','90','90','能见度');
insert into `tb_condition_base_score` (`id`, `flag_type`, `car_front_collide`, `limit_speed_alarm`, `left_lane_deviate`, `city_front_collide`, `car_distance_monitor`, `right_lane_deviate`, `car_start`, `car_end`, `speed_up`, `speed_down`, `person_front_collide`, `collide_follow`, `car_collide_follow`, `person_collide_follow`, `one_car_front_collide`, `two_car_front_collide`, `description`) values('7','7','90','90','90','90','90','90','0','0','90','90','90','0','90','90','90','90','前天分数');

CREATE TABLE `factor_warning` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '主键ID',
  `flag_type` int(11) NOT NULL DEFAULT '0' COMMENT '类型标志',
  `car_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '车辆前部碰撞',
  `limit_speed_alarm` int(11) NOT NULL DEFAULT '0' COMMENT '限速警示',
  `left_lane_deviate` int(11) NOT NULL DEFAULT '0' COMMENT '左车道偏离',
  `city_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '城市前碰撞',
  `car_distance_monitor` int(11) NOT NULL DEFAULT '0' COMMENT '车距监测',
  `right_lane_deviate` int(11) NOT NULL DEFAULT '0' COMMENT '右车道偏离',
  `car_start` int(11) NOT NULL DEFAULT '0' COMMENT '汽车启动',
  `car_end` int(11) NOT NULL DEFAULT '0' COMMENT '汽车熄火',
  `speed_up` int(11) NOT NULL DEFAULT '0' COMMENT '急加速',
  `speed_down` int(11) NOT NULL DEFAULT '0' COMMENT '急减速',
  `person_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '行人前部碰撞',
  `collide_follow` int(11) NOT NULL DEFAULT '0' COMMENT '碰撞跟踪',
  `car_collide_follow` int(11) NOT NULL DEFAULT '0' COMMENT '车辆前部碰撞跟踪',
  `person_collide_follow` int(11) NOT NULL DEFAULT '0' COMMENT '行人前部碰撞跟踪',
  `one_car_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '一类车辆前部碰撞',
  `two_car_front_collide` int(11) NOT NULL DEFAULT '0' COMMENT '二类车辆前部碰撞',
  `description` varchar(50) NOT NULL DEFAULT '0' COMMENT '描述',
  PRIMARY KEY (`id`,`flag_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='速度配置表';

insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (0,1,0,0,0,0,0,0,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (10,1,0,0,0,0,0,0,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (20,1,0,0,0,0,0,0,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (30,1,0,0,5,0,5,0,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (40,1,0,0,10,5,10,0,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (50,1,0,0,15,10,15,5,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (60,1,5,5,20,15,20,10,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (70,1,10,10,25,20,25,15,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (80,1,15,15,30,25,30,20,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (90,1,20,20,35,30,35,25,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (100,1,25,25,40,35,40,30,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (110,1,30,30,45,40,45,35,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (120,1,35,35,50,45,50,40,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (130,1,40,40,55,50,55,45,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (140,1,45,45,60,55,60,50,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (150,1,50,50,65,60,65,55,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (160,1,55,55,70,65,70,60,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (170,1,60,60,75,70,75,65,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (180,1,65,65,80,75,80,70,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (190,1,70,70,85,80,85,75,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (200,1,75,75,90,85,90,80,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (210,1,80,80,95,90,95,85,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (220,1,85,85,100,95,100,90,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (230,1,90,90,105,100,105,95,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (240,1,95,95,110,105,110,100,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (250,1,100,100,115,110,115,105,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (260,1,105,105,120,115,120,110,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (270,1,110,110,125,120,125,115,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (280,1,115,115,130,125,130,120,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (290,1,120,120,135,130,135,125,0,'速度因素');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (0,2,1,1,1,1,1,1,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (1,2,2,2,2,2,2,2,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (2,2,3,3,3,3,3,3,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (3,2,5,5,5,5,5,5,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (4,2,10,10,10,10,10,10,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (5,2,15,15,15,15,15,15,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (6,2,20,20,20,20,20,20,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (7,2,25,25,25,25,25,25,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (8,2,30,30,30,30,30,30,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (9,2,35,35,35,35,35,35,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (10,2,40,40,40,40,40,40,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (11,2,45,45,45,45,45,45,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (12,2,50,50,50,50,50,50,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (13,2,55,55,55,55,55,55,0,'每天驾驶时长');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (1,3,55,55,55,55,55,55,0,'前后间隔时间');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (1,4,10,10,10,10,10,10,10,'天气条件(晴)');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (2,4,20,20,20,20,20,20,20,'天气条件(多云)');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (3,4,30,30,30,30,30,30,30,'天气条件(雷阵雨)');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (4,4,40,40,40,40,40,40,40,'天气条件(雨)');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (30,5,5,5,5,5,5,5,5,'疲劳度');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (150,5,10,10,10,10,10,10,10,'疲劳度');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (360,5,5,5,5,5,5,5,5,'疲劳度');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (600,5,0,0,0,0,0,0,0,'疲劳度');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (1440,5,0,0,0,0,0,0,0,'疲劳度');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (300,6,6,6,6,6,6,6,6,'能见度');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (480,6,8,8,8,8,8,8,8,'能见度');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (1020,6,0,0,0,0,0,0,0,'能见度');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (1260,6,4,4,4,4,4,4,4,'能见度');
insert  into `factor_warning`(`id`,`flag_type`,`left_lane_deviate`,`right_lane_deviate`,`car_distance_monitor`,`limit_speed_alarm`,`city_front_collide`,`car_front_collide`,`person_front_collide`,`description`) values (1440,6,6,6,6,6,6,6,6,'能见度');

CREATE TABLE `weather_history` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `json` LONGTEXT NOT NULL COMMENT 'JSON',
  `area_id` CHAR(9) NOT NULL DEFAULT '' COMMENT '城市ID',
  `history_time` DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '历史时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='历史天气表';

CREATE TABLE `tb_city_weather_base` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `area_id` CHAR(9) NOT NULL DEFAULT '' COMMENT '城市ID',
  `area_name_en` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '地区英文名称',
  `area_name_cn` VARCHAR(10) NOT NULL DEFAULT '' COMMENT '地区中文名称',
  `prov_name_en` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '省会英文名称',
  `prov_name_cn` VARCHAR(10) NOT NULL DEFAULT '' COMMENT '省会中文名称',
  `nation_name_en` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '国家英文名称',
  `nation_name_cn` VARCHAR(10) NOT NULL DEFAULT '' COMMENT '国家中文名称',
  PRIMARY KEY (`id`),
  KEY `idx_area_id` (`area_id`)
) ENGINE=MYISAM DEFAULT CHARSET=utf8 COMMENT='基础城市天气码表';

CREATE TABLE `tb_weather` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` TINYINT(3) NOT NULL DEFAULT '0' COMMENT '编码',
  `name_cn` VARCHAR(10) NOT NULL DEFAULT '' COMMENT '中文名称',
  `name_en` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '英文名称',
  PRIMARY KEY (`id`)
) ENGINE=MYISAM DEFAULT CHARSET=utf8 COMMENT='天气现象编码表';

CREATE TABLE `tb_city_weather_k780` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `wea_id` INT(11) NOT NULL DEFAULT '-1' COMMENT 'k780id',
  `area_id` CHAR(9) NOT NULL DEFAULT '' COMMENT '城市ID',
  PRIMARY KEY (`id`),
  KEY `idx_area_id` (`area_id`)
) ENGINE=MYISAM DEFAULT CHARSET=utf8 COMMENT='k780码表';