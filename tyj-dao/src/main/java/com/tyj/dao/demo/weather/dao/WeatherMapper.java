/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.weather.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.weather.bo.Weather;

/**
 * This class corresponds to the database table `tb_weather`
 */
@SqlMapper
public interface WeatherMapper extends DaoMapper<Weather, Integer> {
}