/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.weather.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.weather.bo.WeatherHistory;
import com.tyj.dao.demo.weather.dao.WeatherHistoryDao;
import com.tyj.dao.demo.weather.dao.WeatherHistoryMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class corresponds to the database table `weather_history`
 */
@Repository("weatherHistoryDao")
public class WeatherHistoryDaoImpl extends ConfigurableBaseSqlMapDao<WeatherHistory, Integer> implements WeatherHistoryDao {
    @Autowired
    private WeatherHistoryMapper weatherHistoryMapper;

    @Override
    public DaoMapper<WeatherHistory, Integer> getDaoMapper() {
        return weatherHistoryMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public WeatherHistory findByTimeAndAreaId(String time, String areaId) {
        return weatherHistoryMapper.findByTimeAndAreaId(time, areaId);
    }
}