/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.cityWeatherBase.service.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.cityWeatherBase.bo.CityWeatherK780;
import com.tyj.dao.demo.cityWeatherBase.dao.CityWeatherK780Dao;
import com.tyj.service.demo.cityWeatherBase.service.CityWeatherK780Service;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * This class corresponds to the database table `tb_city_weather_k780`
 */
@Service("cityWeatherK780Service")
public class CityWeatherK780ServiceImpl extends GenericSqlMapServiceImpl<CityWeatherK780, Integer> implements CityWeatherK780Service {
    @Resource(name = "cityWeatherK780Dao")
    private CityWeatherK780Dao cityWeatherK780Dao;

    @Override
    public SqlMapDao<CityWeatherK780, Integer> getDao() {
        return cityWeatherK780Dao;
    }
}