/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.weather.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.weather.bo.WeatherHistory;

/**
 * This class corresponds to the database table `weather_history`
 */
public interface WeatherHistoryDao extends SqlMapDao<WeatherHistory, Integer> {
    /*
     * 通过时间及城市ID查询天气信息
     * @param time 时间
     * @param areaId 城市ID
     * @return 天气信息
     */
    WeatherHistory findByTimeAndAreaId(String time, String areaId);
}