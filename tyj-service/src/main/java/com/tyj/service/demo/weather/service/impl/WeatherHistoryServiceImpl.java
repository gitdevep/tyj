/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.weather.service.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.weather.bo.WeatherHistory;
import com.tyj.dao.demo.weather.dao.WeatherHistoryDao;
import com.tyj.service.demo.weather.service.WeatherHistoryService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * This class corresponds to the database table `weather_history`
 */
@Service("weatherHistoryService")
public class WeatherHistoryServiceImpl extends GenericSqlMapServiceImpl<WeatherHistory, Integer> implements WeatherHistoryService {
    @Resource(name = "weatherHistoryDao")
    private WeatherHistoryDao weatherHistoryDao;

    @Override
    public SqlMapDao<WeatherHistory, Integer> getDao() {
        return weatherHistoryDao;
    }

    @Override
    public WeatherHistory findByTimeAndAreaId(String time, String areaId) {
        return weatherHistoryDao.findByTimeAndAreaId(time, areaId);
    }
}