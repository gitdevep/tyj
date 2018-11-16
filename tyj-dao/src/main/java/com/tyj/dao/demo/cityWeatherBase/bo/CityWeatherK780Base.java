/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.cityWeatherBase.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_city_weather_k780`
 */
public abstract class CityWeatherK780Base extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_city_weather_k780`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_city_weather_k780`.id
     */
    private static final String PROPERTY_REMARK_ID = "主键ID";

    /**
     * This field corresponds to the database column `tb_city_weather_k780`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_city_weather_k780`.wea_id
     */
    private static final String PROPERTY_WEAID = "weaId";

    /**
     * This field corresponds to the database column `tb_city_weather_k780`.wea_id
     */
    private static final String PROPERTY_REMARK_WEAID = "k780id";

    /**
     * This field corresponds to the database column `tb_city_weather_k780`.wea_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_WEAID)
    private Integer weaId;

    /**
     * This field corresponds to the database column `tb_city_weather_k780`.area_id
     */
    private static final String PROPERTY_AREAID = "areaId";

    /**
     * This field corresponds to the database column `tb_city_weather_k780`.area_id
     */
    private static final String PROPERTY_REMARK_AREAID = "城市ID";

    /**
     * This field corresponds to the database column `tb_city_weather_k780`.area_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_AREAID)
    private String areaId;

    /**
     * This method returns the value of the database column `tb_city_weather_k780`.id
     *
     * @return the value of `tb_city_weather_k780`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_k780`.id
     *
     * @param id the value for `tb_city_weather_k780`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_city_weather_k780`.wea_id
     *
     * @return the value of `tb_city_weather_k780`.wea_id
     */
    public Integer getWeaId() {
        return weaId;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_k780`.wea_id
     *
     * @param weaId the value for `tb_city_weather_k780`.wea_id
     */
    public void setWeaId(Integer weaId) {
        this.weaId = weaId;
    }

    /**
     * This method returns the value of the database column `tb_city_weather_k780`.area_id
     *
     * @return the value of `tb_city_weather_k780`.area_id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_k780`.area_id
     *
     * @param areaId the value for `tb_city_weather_k780`.area_id
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}