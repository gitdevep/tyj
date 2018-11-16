/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.weather.service;

import cn.vansky.framework.core.service.GenericService;
import com.tyj.dao.demo.weather.bo.Weather;

/**
 * This class corresponds to the database table `tb_weather`
 */
public interface WeatherService extends GenericService<Weather, Integer> {
}