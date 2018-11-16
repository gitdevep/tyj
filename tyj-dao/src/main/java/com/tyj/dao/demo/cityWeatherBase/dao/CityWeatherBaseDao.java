/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.cityWeatherBase.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.cityWeatherBase.bo.CityWeatherBase;

import java.util.List;

/**
 * This class corresponds to the database table `tb_city_weather_base`
 */
public interface CityWeatherBaseDao extends SqlMapDao<CityWeatherBase, Integer> {

    List<CityWeatherBase> selectAllCity();
}