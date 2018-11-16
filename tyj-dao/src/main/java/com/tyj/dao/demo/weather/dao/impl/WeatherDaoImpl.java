/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.weather.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.weather.bo.Weather;
import com.tyj.dao.demo.weather.dao.WeatherDao;
import com.tyj.dao.demo.weather.dao.WeatherMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class corresponds to the database table `tb_weather`
 */
@Repository("weatherDao")
public class WeatherDaoImpl extends ConfigurableBaseSqlMapDao<Weather, Integer> implements WeatherDao {
    @Autowired
    private WeatherMapper weatherMapper;

    @Override
    public DaoMapper<Weather, Integer> getDaoMapper() {
        return weatherMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}