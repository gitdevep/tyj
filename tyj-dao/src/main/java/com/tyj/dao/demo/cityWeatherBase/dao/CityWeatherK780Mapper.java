/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.cityWeatherBase.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.cityWeatherBase.bo.CityWeatherK780;

/**
 * This class corresponds to the database table `tb_city_weather_k780`
 */
@SqlMapper
public interface CityWeatherK780Mapper extends DaoMapper<CityWeatherK780, Integer> {
}