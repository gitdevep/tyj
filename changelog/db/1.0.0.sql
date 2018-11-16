ALTER TABLE `device_gps_infos_count` CHANGE `vd_no_sart` `vd_no_start` INT(11) NOT NULL DEFAULT '0' COMMENT 'VD未启动';
ALTER TABLE `device_gps_infos_count` ADD `car_collide_follow` INT(11) NOT NULL DEFAULT '0' COMMENT '车辆前部碰撞跟踪';
ALTER TABLE `device_gps_infos_count` ADD `person_collide_follow` INT(11) NOT NULL DEFAULT '0' COMMENT '行人前部碰撞跟踪';
ALTER TABLE `device_gps_infos_count` ADD `one_car_front_collide` INT(11) NOT NULL DEFAULT '0' COMMENT '一类车辆前部碰撞';
ALTER TABLE `device_gps_infos_count` ADD `two_car_front_collide` INT(11) NOT NULL DEFAULT '0' COMMENT '二类车辆前部碰撞';
ALTER TABLE `factor_warning` ADD `person_front_collide` INT(11) NOT NULL DEFAULT '0' COMMENT '行人前部碰撞' AFTER `car_front_collide`;
UPDATE factor_warning t SET t.`person_front_collide` = 95 WHERE t.`flag_type` = 3 AND t.`id` IN(1, 2, 17);
UPDATE factor_warning t SET t.`person_front_collide` = 85 WHERE t.`flag_type` = 3 AND t.`id` = 5;
UPDATE factor_warning t SET t.`person_front_collide` = 90 WHERE t.`flag_type` = 3 AND t.`id` = 6;

ALTER TABLE `device_gps_infos` ADD PARTITION (PARTITION p20160301 VALUES LESS THAN (TO_DAYS ('20160301')));