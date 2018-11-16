CREATE DEFINER=`tyj_demo`@`%` PROCEDURE `create_partition`(IN table_schema VARCHAR(100), IN table_name VARCHAR(100))
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;
    START TRANSACTION;
  -- 查询最大分区
  SELECT
    REPLACE(partition_name, 'p', '') INTO @P12_Name
  FROM
    INFORMATION_SCHEMA.PARTITIONS
  WHERE TABLE_SCHEMA = table_schema
    AND table_name = table_name
  ORDER BY partition_ordinal_position DESC
  LIMIT 1 ;
  -- 新建分区,下个分区日期
  -- 最大分区不跨年
  IF(MONTH(@P12_Name) != 1)
  THEN
    -- 分区加1月
    SET @next_date = DATE(DATE_ADD(@P12_Name, INTERVAL 1 MONTH)) + 0;
    -- 拼出添加分区SQL
    SET @s1 = CONCAT(
      'ALTER TABLE ', table_name, ' ADD PARTITION (PARTITION p',
      @next_date,
      ' VALUES LESS THAN (TO_DAYS (''',
      @next_date,
      ''')))'
    ) ;
    PREPARE stmt1 FROM @s1;
    EXECUTE stmt1;
    DEALLOCATE PREPARE stmt1;
  END IF;
  -- 最大分区为1月(跨年),把旧分区生成新表new_table_2016
  IF(MONTH(@P12_Name) = 1)
  THEN
  -- 获取去年年份
  SET @pre_date = YEAR(DATE_SUB(NOW(), INTERVAL 1 YEAR)) + 0;
    CALL `demo`.`create_info_table`(table_name, 'device_gps_infos_tmp', CONCAT(table_name, '_', @pre_date));
  END IF;
  COMMIT ;
END