/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.cityWeatherBase.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_city_weather_base`
 */
public abstract class CityWeatherBaseBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_city_weather_base`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.id
     */
    private static final String PROPERTY_REMARK_ID = "主键ID";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_city_weather_base`.area_id
     */
    private static final String PROPERTY_AREAID = "areaId";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.area_id
     */
    private static final String PROPERTY_REMARK_AREAID = "城市ID";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.area_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_AREAID)
    private String areaId;

    /**
     * This field corresponds to the database column `tb_city_weather_base`.area_name_en
     */
    private static final String PROPERTY_AREANAMEEN = "areaNameEn";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.area_name_en
     */
    private static final String PROPERTY_REMARK_AREANAMEEN = "地区英文名称";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.area_name_en
     */
    @ColumnDescription(desc = PROPERTY_REMARK_AREANAMEEN)
    private String areaNameEn;

    /**
     * This field corresponds to the database column `tb_city_weather_base`.area_name_cn
     */
    private static final String PROPERTY_AREANAMECN = "areaNameCn";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.area_name_cn
     */
    private static final String PROPERTY_REMARK_AREANAMECN = "地区中文名称";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.area_name_cn
     */
    @ColumnDescription(desc = PROPERTY_REMARK_AREANAMECN)
    private String areaNameCn;

    /**
     * This field corresponds to the database column `tb_city_weather_base`.prov_name_en
     */
    private static final String PROPERTY_PROVNAMEEN = "provNameEn";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.prov_name_en
     */
    private static final String PROPERTY_REMARK_PROVNAMEEN = "省会英文名称";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.prov_name_en
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PROVNAMEEN)
    private String provNameEn;

    /**
     * This field corresponds to the database column `tb_city_weather_base`.prov_name_cn
     */
    private static final String PROPERTY_PROVNAMECN = "provNameCn";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.prov_name_cn
     */
    private static final String PROPERTY_REMARK_PROVNAMECN = "省会中文名称";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.prov_name_cn
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PROVNAMECN)
    private String provNameCn;

    /**
     * This field corresponds to the database column `tb_city_weather_base`.nation_name_en
     */
    private static final String PROPERTY_NATIONNAMEEN = "nationNameEn";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.nation_name_en
     */
    private static final String PROPERTY_REMARK_NATIONNAMEEN = "国家英文名称";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.nation_name_en
     */
    @ColumnDescription(desc = PROPERTY_REMARK_NATIONNAMEEN)
    private String nationNameEn;

    /**
     * This field corresponds to the database column `tb_city_weather_base`.nation_name_cn
     */
    private static final String PROPERTY_NATIONNAMECN = "nationNameCn";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.nation_name_cn
     */
    private static final String PROPERTY_REMARK_NATIONNAMECN = "国家中文名称";

    /**
     * This field corresponds to the database column `tb_city_weather_base`.nation_name_cn
     */
    @ColumnDescription(desc = PROPERTY_REMARK_NATIONNAMECN)
    private String nationNameCn;

    /**
     * This method returns the value of the database column `tb_city_weather_base`.id
     *
     * @return the value of `tb_city_weather_base`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_base`.id
     *
     * @param id the value for `tb_city_weather_base`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_city_weather_base`.area_id
     *
     * @return the value of `tb_city_weather_base`.area_id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_base`.area_id
     *
     * @param areaId the value for `tb_city_weather_base`.area_id
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * This method returns the value of the database column `tb_city_weather_base`.area_name_en
     *
     * @return the value of `tb_city_weather_base`.area_name_en
     */
    public String getAreaNameEn() {
        return areaNameEn;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_base`.area_name_en
     *
     * @param areaNameEn the value for `tb_city_weather_base`.area_name_en
     */
    public void setAreaNameEn(String areaNameEn) {
        this.areaNameEn = areaNameEn;
    }

    /**
     * This method returns the value of the database column `tb_city_weather_base`.area_name_cn
     *
     * @return the value of `tb_city_weather_base`.area_name_cn
     */
    public String getAreaNameCn() {
        return areaNameCn;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_base`.area_name_cn
     *
     * @param areaNameCn the value for `tb_city_weather_base`.area_name_cn
     */
    public void setAreaNameCn(String areaNameCn) {
        this.areaNameCn = areaNameCn;
    }

    /**
     * This method returns the value of the database column `tb_city_weather_base`.prov_name_en
     *
     * @return the value of `tb_city_weather_base`.prov_name_en
     */
    public String getProvNameEn() {
        return provNameEn;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_base`.prov_name_en
     *
     * @param provNameEn the value for `tb_city_weather_base`.prov_name_en
     */
    public void setProvNameEn(String provNameEn) {
        this.provNameEn = provNameEn;
    }

    /**
     * This method returns the value of the database column `tb_city_weather_base`.prov_name_cn
     *
     * @return the value of `tb_city_weather_base`.prov_name_cn
     */
    public String getProvNameCn() {
        return provNameCn;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_base`.prov_name_cn
     *
     * @param provNameCn the value for `tb_city_weather_base`.prov_name_cn
     */
    public void setProvNameCn(String provNameCn) {
        this.provNameCn = provNameCn;
    }

    /**
     * This method returns the value of the database column `tb_city_weather_base`.nation_name_en
     *
     * @return the value of `tb_city_weather_base`.nation_name_en
     */
    public String getNationNameEn() {
        return nationNameEn;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_base`.nation_name_en
     *
     * @param nationNameEn the value for `tb_city_weather_base`.nation_name_en
     */
    public void setNationNameEn(String nationNameEn) {
        this.nationNameEn = nationNameEn;
    }

    /**
     * This method returns the value of the database column `tb_city_weather_base`.nation_name_cn
     *
     * @return the value of `tb_city_weather_base`.nation_name_cn
     */
    public String getNationNameCn() {
        return nationNameCn;
    }

    /**
     * This method sets the value of the database column `tb_city_weather_base`.nation_name_cn
     *
     * @param nationNameCn the value for `tb_city_weather_base`.nation_name_cn
     */
    public void setNationNameCn(String nationNameCn) {
        this.nationNameCn = nationNameCn;
    }
}