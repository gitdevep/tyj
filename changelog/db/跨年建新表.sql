CREATE DEFINER=`tyj_demo`@`%` PROCEDURE `create_info_table`(IN ori_table_name VARCHAR(100), IN tmp_table_name VARCHAR(100), IN new_table_name VARCHAR(100))
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;
    START TRANSACTION;
    -- 每年1月1号执行,需要加1月,分区开始为2016-02-01
    SET @next_date = DATE(DATE_ADD(NOW(), INTERVAL 1 MONTH)) - 1;
    SET @s1 = CONCAT(
   'CREATE TABLE ', new_table_name, ' (
    `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT ''设备ID'',
    `device_id` INT(11) NOT NULL COMMENT ''设备ID'',
    `msg_id` INT(11) DEFAULT NULL COMMENT ''终端带的消息ID'',
    `event_time` DATETIME DEFAULT NULL COMMENT ''数据采集时间'',
    `longitude` DOUBLE DEFAULT NULL COMMENT ''经度'',
    `latitude` DOUBLE DEFAULT NULL COMMENT ''纬度'',
    `speed` INT(4) DEFAULT NULL COMMENT ''车速'',
    `msg_type` TINYINT(4) DEFAULT NULL COMMENT ''告警类型,表:msg_type'',
    `flash_state` TINYINT(4) DEFAULT NULL COMMENT ''设备flash状态（正常为00，当FLASH存储空间饱和为FF）'',
    `upload_time` DATETIME DEFAULT NULL COMMENT ''上传时间'',
    `acceleration` FLOAT DEFAULT ''0'' COMMENT ''加速度'',
    PRIMARY KEY (`id`, `event_time`),
    KEY `event_time_id` (`event_time`,`device_id`)
    ) ENGINE=MYISAM DEFAULT CHARSET=utf8 COMMENT=''客户原始数据表''
     PARTITION BY RANGE(TO_DAYS(event_time))
    (
     PARTITION p',@next_date,' VALUES LESS THAN (TO_DAYS(''',@next_date,'''))
    )'
  ) ;
    PREPARE stmt1 FROM @s1;
    EXECUTE stmt1;
    DEALLOCATE PREPARE stmt1;
    SET @s2 = CONCAT('ALTER TABLE ', ori_table_name, ' RENAME ', tmp_table_name);
    PREPARE stmt2 FROM @s2;
    EXECUTE stmt2;
    DEALLOCATE PREPARE stmt2;
    SET @s3 = CONCAT('ALTER TABLE ', new_table_name, ' RENAME ', ori_table_name);
    PREPARE stmt3 FROM @s3;
    EXECUTE stmt3;
    DEALLOCATE PREPARE stmt3;
    SET @s4 = CONCAT('ALTER TABLE ', tmp_table_name, ' RENAME ', new_table_name);
    PREPARE stmt4 FROM @s4;
    EXECUTE stmt4;
    DEALLOCATE PREPARE stmt4;
  COMMIT ;
END