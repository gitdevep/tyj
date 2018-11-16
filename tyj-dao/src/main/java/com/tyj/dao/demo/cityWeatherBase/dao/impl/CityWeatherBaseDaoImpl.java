/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.cityWeatherBase.dao.impl;

import cn.vansky.framework.core.dao.ConfigurableBaseSqlMapDao;
import cn.vansky.framework.core.dao.DaoMapper;
import com.tyj.dao.demo.cityWeatherBase.bo.CityWeatherBase;
import com.tyj.dao.demo.cityWeatherBase.dao.CityWeatherBaseDao;
import com.tyj.dao.demo.cityWeatherBase.dao.CityWeatherBaseMapper;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class corresponds to the database table `tb_city_weather_base`
 */
@Repository("cityWeatherBaseDao")
public class CityWeatherBaseDaoImpl extends ConfigurableBaseSqlMapDao<CityWeatherBase, Integer> implements CityWeatherBaseDao {
    @Autowired
    private CityWeatherBaseMapper cityWeatherBaseMapper;

    @Override
    public DaoMapper<CityWeatherBase, Integer> getDaoMapper() {
        return cityWeatherBaseMapper;
    }

    @Resource(name = "sqlSessionFactory")
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        setSqlSessionFactoryInternal(sqlSessionFactory);
    }

    @Override
    public List<CityWeatherBase> selectAllCity() {
        return cityWeatherBaseMapper.selectAllCity();
    }
}