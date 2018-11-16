/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.cityWeatherBase.bo;

/**
 * This class corresponds to the database table `tb_city_weather_base`
 */
public class CityWeatherBase extends CityWeatherBaseBase {
    /**
     * k780的天气编号
     */
    private Integer weaId;

    public Integer getWeaId() {
        return weaId;
    }

    public void setWeaId(Integer weaId) {
        this.weaId = weaId;
    }
}