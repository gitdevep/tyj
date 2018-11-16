/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.cityWeatherBase.service.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.vo.Constant;
import com.tyj.dao.demo.cityWeatherBase.bo.CityWeatherBase;
import com.tyj.dao.demo.cityWeatherBase.dao.CityWeatherBaseDao;
import com.tyj.service.demo.cityWeatherBase.service.CityWeatherBaseService;
import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_city_weather_base`
 */
@Service("cityWeatherBaseService")
public class CityWeatherBaseServiceImpl extends GenericSqlMapServiceImpl<CityWeatherBase, Integer>
        implements CityWeatherBaseService, InitializingBean {
    @Resource(name = "cityWeatherBaseDao")
    private CityWeatherBaseDao cityWeatherBaseDao;

    @Override
    public SqlMapDao<CityWeatherBase, Integer> getDao() {
        return cityWeatherBaseDao;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<CityWeatherBase> list = cityWeatherBaseDao.selectAllCity();
        for (CityWeatherBase c : list) {
            Constant.CITY_BASE.put(c.getAreaNameCn(), c);
        }
    }
}