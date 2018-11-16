/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.weather.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.weather.bo.Weather;

/**
 * This class corresponds to the database table `tb_weather`
 */
public interface WeatherDao extends SqlMapDao<Weather, Integer> {
}