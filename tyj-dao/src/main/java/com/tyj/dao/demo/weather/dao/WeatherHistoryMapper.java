/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.weather.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.weather.bo.WeatherHistory;
import org.apache.ibatis.annotations.Param;

/**
 * This class corresponds to the database table `weather_history`
 */
@SqlMapper
public interface WeatherHistoryMapper extends DaoMapper<WeatherHistory, Integer> {
    /*
     * 通过时间及城市ID查询天气信息
     * @param time 时间
     * @param areaId 城市ID
     * @return 天气信息
     */
    WeatherHistory findByTimeAndAreaId(@Param("time") String time, @Param("areaId") String areaId);
}