/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.weather.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;
import java.util.Date;

/**
 * This class corresponds to the database table `weather_history`
 */
public abstract class WeatherHistoryBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `weather_history`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `weather_history`.id
     */
    private static final String PROPERTY_REMARK_ID = "主键ID";

    /**
     * This field corresponds to the database column `weather_history`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `weather_history`.json
     */
    private static final String PROPERTY_JSON = "json";

    /**
     * This field corresponds to the database column `weather_history`.json
     */
    private static final String PROPERTY_REMARK_JSON = "JSON";

    /**
     * This field corresponds to the database column `weather_history`.json
     */
    @ColumnDescription(desc = PROPERTY_REMARK_JSON)
    private String json;

    /**
     * This field corresponds to the database column `weather_history`.area_id
     */
    private static final String PROPERTY_AREAID = "areaId";

    /**
     * This field corresponds to the database column `weather_history`.area_id
     */
    private static final String PROPERTY_REMARK_AREAID = "城市ID";

    /**
     * This field corresponds to the database column `weather_history`.area_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_AREAID)
    private String areaId;

    /**
     * This field corresponds to the database column `weather_history`.history_time
     */
    private static final String PROPERTY_HISTORYTIME = "historyTime";

    /**
     * This field corresponds to the database column `weather_history`.history_time
     */
    private static final String PROPERTY_REMARK_HISTORYTIME = "历史时间";

    /**
     * This field corresponds to the database column `weather_history`.history_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_HISTORYTIME)
    private Date historyTime;

    /**
     * This method returns the value of the database column `weather_history`.id
     *
     * @return the value of `weather_history`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `weather_history`.id
     *
     * @param id the value for `weather_history`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `weather_history`.json
     *
     * @return the value of `weather_history`.json
     */
    public String getJson() {
        return json;
    }

    /**
     * This method sets the value of the database column `weather_history`.json
     *
     * @param json the value for `weather_history`.json
     */
    public void setJson(String json) {
        this.json = json;
    }

    /**
     * This method returns the value of the database column `weather_history`.area_id
     *
     * @return the value of `weather_history`.area_id
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * This method sets the value of the database column `weather_history`.area_id
     *
     * @param areaId the value for `weather_history`.area_id
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * This method returns the value of the database column `weather_history`.history_time
     *
     * @return the value of `weather_history`.history_time
     */
    public Date getHistoryTime() {
        return historyTime;
    }

    /**
     * This method sets the value of the database column `weather_history`.history_time
     *
     * @param historyTime the value for `weather_history`.history_time
     */
    public void setHistoryTime(Date historyTime) {
        this.historyTime = historyTime;
    }
}