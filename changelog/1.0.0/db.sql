DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` VARCHAR(255) NOT NULL COMMENT '菜单名称',
  `remark` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '菜单备注',
  `parent_id` INT(11) NOT NULL DEFAULT '0' COMMENT '父菜单ID',
  `url` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '菜单URL',
  `icon` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '菜单图片',
  `if_show` TINYINT(3) NOT NULL DEFAULT '1' COMMENT '是否可见：1:可见，2:不可见',
  `status` TINYINT(3) NOT NULL DEFAULT '1' COMMENT '删除标志，1:未删除，2:已删除',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`Id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='菜单表';
insert into `tb_menu` (`Id`, `name`, `remark`, `parent_id`, `url`, `icon`, `if_show`, `status`, `create_time`) values
('1','系统管理','','0','','','1','1','2016-05-14 18:38:59'),
('2','账户管理','','1','general/user_init','','1','1','2016-05-14 18:38:59'),
('3','角色管理','','1','general/role_init','','1','1','2016-05-14 18:38:59'),
('4','菜单管理','','1','general/menu_init','','1','1','2016-05-14 18:38:59'),
('5','用户数据','','0','','','1','1','2016-05-15 10:44:45'),
('6','车辆列表','','5','deviceInfo/device_info','','1','1','2016-05-15 10:45:22'),
('7','团队列表','','5','team/team_init','','1','1','2016-05-15 10:45:36'),
('8','路线列表','','5','route/route_init','','1','1','2016-05-15 10:45:49'),
('9','数据统计','','0','','','1','1','2016-05-15 10:46:01'),
('10','个人用户','','9','','','1','1','2016-05-15 10:46:16'),
('11','团队用户','','9','','','1','1','2016-05-15 10:46:31'),
('12','每天预警','','10','alarm/day_alarm','','1','1','2016-05-15 10:46:55'),
('13','时段预警','','10','alarm/alarm_interval','','1','1','2016-05-15 10:47:12'),
('14','每日车速','','10','daySpeed/day_speed','','1','1','2016-05-15 10:47:25'),
('15','驾车时长','','10','driverTime/drive_time','','1','1','2016-05-15 10:47:37'),
('16','用户评分','','10','userScore/user_score','','1','1','2016-05-15 10:47:47'),
('17','基础信息查询','','11','general/user_init','','1','1','2016-05-15 10:48:03'),
('18','单车统计','','11','one/one_alarm','','1','1','2016-05-15 10:48:14'),
('19','对比统计','','11','more/more_alarm','','1','1','2016-05-15 10:48:26'),
('20','地图统计','','11','map/message_map','','1','1','2016-05-15 10:48:39'),
('21','团队用户评分','','11','userScore/user_score','','1','1','2016-05-15 10:49:00'),
('22','报表打印','','11','alarm/init_total_alarm','','1','1','2016-05-15 10:49:11'),
('23','菜单新增','','4','menu/add_menu','','2','1','2016-05-14 19:03:46'),
('24','菜单编辑','','4','menu/edit_menu','','2','1','2016-05-14 19:05:11'),
('25','账户新增','','2','user/add_user','','2','1','2016-05-14 19:52:00'),
('26','账户编辑','','2','user/edit_user','','2','1','2016-05-14 19:52:22'),
('27','角色新增','','3','role/add_role','','2','1','2016-05-14 19:53:38'),
('28','角色编辑','','3','role/edit_role','','2','1','2016-05-14 19:54:03'),
('29','团队新增','','7','team/add_team','','2','1','2016-05-15 11:03:34'),
('30','团队编辑','','7','team/edit_team','','2','1','2016-05-15 11:04:11'),
('31','路线新增','','8','route/add_route','','2','1','2016-05-15 11:05:27'),
('32','路线编辑','','8','route/edit_route','','2','1','2016-05-15 11:05:57');

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '密码',
  `role_id` INT(11) NOT NULL COMMENT '角色ID',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户表';
insert into `tb_user` (`id`, `name`, `password`, `role_id`, `create_time`) values('1','admin','admin','1','2016-05-15 11:16:38');

DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` VARCHAR(20) NOT NULL COMMENT '角色名',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='角色表';
insert into `tb_role` (`id`, `name`, `create_time`) values('1','管理员','2016-05-15 11:25:22'),('2','操作员','2016-05-15 11:26:59');

DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '角色-菜单ID',
  `role_id` INT(11) NOT NULL DEFAULT '0' COMMENT '角色ID',
  `menu_id` INT(11) NOT NULL DEFAULT '0' COMMENT '菜单ID',
  PRIMARY KEY (`Id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='角色-菜单表';
insert into `tb_role_menu` (`Id`, `role_id`, `menu_id`) values('1','1','1'),('2','1','2'),('3','1','3'),('4','1','4'),('5','1','5'),('6','1','6'),('7','1','7'),('8','1','8'),('9','1','9'),('10','1','10'),('11','1','11'),('12','1','12'),('13','1','13'),('14','1','14'),('15','1','15'),('16','1','16'),('17','1','17'),('18','1','18'),('19','1','19'),('20','1','20'),('21','1','21'),('22','1','22'),('23','1','23'),('24','1','24'),('25','1','25'),('26','1','26'),('27','1','27'),('28','1','28'),('29','1','29'),('30','1','30'),('31','1','31'),('32','1','32'),('33','2','1'),('34','2','2'),('35','2','3'),('36','2','4'),('37','2','5'),('38','2','6'),('39','2','7'),('40','2','8'),('41','2','9'),('42','2','10'),('43','2','11'),('44','2','12'),('45','2','13'),('46','2','14'),('47','2','15'),('48','2','16'),('49','2','17'),('50','2','18'),('51','2','19'),('52','2','20'),('53','2','21'),('54','2','22');

DROP TABLE IF EXISTS `td_composite_dictionary`;
CREATE TABLE `td_composite_dictionary` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键标识',
  `dic_id` INT(11) NOT NULL COMMENT '字典ID',
  `dic_name` VARCHAR(100) NOT NULL COMMENT '字典名称',
  `dic_type` INT(11) NOT NULL COMMENT '类型',
  `status` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '字典状态:1:启用,0:禁用',
  `dic_desc` VARCHAR(1000) NOT NULL DEFAULT '' COMMENT '字典描述',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='字典表';
insert into `td_composite_dictionary` (`id`, `dic_id`, `dic_name`, `dic_type`, `status`, `dic_desc`) values('1','1','可见','1','1','菜单可见度'),('2','2','不可见','1','1','菜单可见度'),('3','1','可用','2','1','状态'),('4','2','禁用','2','1','状态');

CREATE TABLE `tb_route` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `route_name` varchar(50) NOT NULL COMMENT '线路名',
  `km` double NOT NULL DEFAULT '0' COMMENT '公里数',
  `oil_cost` double NOT NULL DEFAULT '0' COMMENT '油耗',
  `start_lng` double NOT NULL COMMENT '起点位置经度',
  `start_lat` double NOT NULL COMMENT '起点位置纬度',
  `end_lng` double NOT NULL COMMENT '终点位置经度',
  `end_lat` double NOT NULL COMMENT '终点位置纬度',
  `start_name` varchar(100) NOT NULL COMMENT '起点名称',
  `end_name` varchar(100) NOT NULL COMMENT '终点名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `route_name` (`route_name`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='路线信息';

CREATE TABLE `tb_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `team_name` varchar(50) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `team_name` (`team_name`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='团队信息';

CREATE TABLE `tb_team_route` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `route_id` int(11) NOT NULL COMMENT '线路ID',
  `team_id` int(11) NOT NULL COMMENT '团队ID',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='团队-路线信息';

CREATE TABLE `tb_team_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `device_id` int(11) NOT NULL COMMENT '设备ID',
  `team_id` int(11) NOT NULL COMMENT '团队ID',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='团队-设备信息';

ALTER TABLE `tb_user` ADD COLUMN auth_id INT(11) NOT NULL COMMENT '权限系统ID';

CREATE TABLE `tb_base_data` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `device_id` INT(11) NOT NULL COMMENT '设备ID',
  `start_time` DATETIME NOT NULL COMMENT '开始时间',
  `end_time` DATETIME NOT NULL COMMENT '结束时间',
  `driver_time` DOUBLE NOT NULL COMMENT '驾驶时间',
  `km` DOUBLE NOT NULL COMMENT '行驶里程',
  `oil` DOUBLE NOT NULL DEFAULT '0' COMMENT '油耗',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='基础信息表';

CREATE TABLE `tb_user_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `device_id` int(11) NOT NULL COMMENT '设备ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-设备信息';

CREATE TABLE `tb_user_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `team_id` int(11) NOT NULL COMMENT '团队ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队-用户信息';