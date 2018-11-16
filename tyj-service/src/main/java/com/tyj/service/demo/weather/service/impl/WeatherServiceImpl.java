/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.weather.service.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.weather.bo.Weather;
import com.tyj.dao.demo.weather.dao.WeatherDao;
import com.tyj.service.demo.weather.service.WeatherService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * This class corresponds to the database table `tb_weather`
 */
@Service("weatherService")
public class WeatherServiceImpl extends GenericSqlMapServiceImpl<Weather, Integer> implements WeatherService {
    @Resource(name = "weatherDao")
    private WeatherDao weatherDao;

    @Override
    public SqlMapDao<Weather, Integer> getDao() {
        return weatherDao;
    }
}