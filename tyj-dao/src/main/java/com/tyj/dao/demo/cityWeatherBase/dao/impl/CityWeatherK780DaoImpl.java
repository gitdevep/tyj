/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.cityWeatherBase.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.cityWeatherBase.bo.CityWeatherK780;
import com.tyj.dao.demo.cityWeatherBase.dao.CityWeatherK780Dao;
import com.tyj.dao.demo.cityWeatherBase.dao.CityWeatherK780Mapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class corresponds to the database table `tb_city_weather_k780`
 */
@Repository("cityWeatherK780Dao")
public class CityWeatherK780DaoImpl extends ConfigurableBaseSqlMapDao<CityWeatherK780, Integer> implements CityWeatherK780Dao {
    @Autowired
    private CityWeatherK780Mapper cityWeatherK780Mapper;

    @Override
    public DaoMapper<CityWeatherK780, Integer> getDaoMapper() {
        return cityWeatherK780Mapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }
}