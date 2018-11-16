/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;
import java.util.Date;

/**
 * This class corresponds to the database table `tb_base_data`
 */
public abstract class BaseDataBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_base_data`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_base_data`.id
     */
    private static final String PROPERTY_REMARK_ID = "自增ID";

    /**
     * This field corresponds to the database column `tb_base_data`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Long id;

    /**
     * This field corresponds to the database column `tb_base_data`.device_id
     */
    private static final String PROPERTY_DEVICEID = "deviceId";

    /**
     * This field corresponds to the database column `tb_base_data`.device_id
     */
    private static final String PROPERTY_REMARK_DEVICEID = "设备ID";

    /**
     * This field corresponds to the database column `tb_base_data`.device_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DEVICEID)
    private Integer deviceId;

    /**
     * This field corresponds to the database column `tb_base_data`.start_time
     */
    private static final String PROPERTY_STARTTIME = "startTime";

    /**
     * This field corresponds to the database column `tb_base_data`.start_time
     */
    private static final String PROPERTY_REMARK_STARTTIME = "开始时间";

    /**
     * This field corresponds to the database column `tb_base_data`.start_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_STARTTIME)
    private Date startTime;

    /**
     * This field corresponds to the database column `tb_base_data`.end_time
     */
    private static final String PROPERTY_ENDTIME = "endTime";

    /**
     * This field corresponds to the database column `tb_base_data`.end_time
     */
    private static final String PROPERTY_REMARK_ENDTIME = "结束时间";

    /**
     * This field corresponds to the database column `tb_base_data`.end_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ENDTIME)
    private Date endTime;

    /**
     * This field corresponds to the database column `tb_base_data`.driver_time
     */
    private static final String PROPERTY_DRIVERTIME = "driverTime";

    /**
     * This field corresponds to the database column `tb_base_data`.driver_time
     */
    private static final String PROPERTY_REMARK_DRIVERTIME = "驾驶时间";

    /**
     * This field corresponds to the database column `tb_base_data`.driver_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DRIVERTIME)
    private Double driverTime;

    /**
     * This field corresponds to the database column `tb_base_data`.km
     */
    private static final String PROPERTY_KM = "km";

    /**
     * This field corresponds to the database column `tb_base_data`.km
     */
    private static final String PROPERTY_REMARK_KM = "行驶里程";

    /**
     * This field corresponds to the database column `tb_base_data`.km
     */
    @ColumnDescription(desc = PROPERTY_REMARK_KM)
    private Double km;

    /**
     * This field corresponds to the database column `tb_base_data`.oil
     */
    private static final String PROPERTY_OIL = "oil";

    /**
     * This field corresponds to the database column `tb_base_data`.oil
     */
    private static final String PROPERTY_REMARK_OIL = "油耗";

    /**
     * This field corresponds to the database column `tb_base_data`.oil
     */
    @ColumnDescription(desc = PROPERTY_REMARK_OIL)
    private Double oil;

    /**
     * This method returns the value of the database column `tb_base_data`.id
     *
     * @return the value of `tb_base_data`.id
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_base_data`.id
     *
     * @param id the value for `tb_base_data`.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_base_data`.device_id
     *
     * @return the value of `tb_base_data`.device_id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * This method sets the value of the database column `tb_base_data`.device_id
     *
     * @param deviceId the value for `tb_base_data`.device_id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * This method returns the value of the database column `tb_base_data`.start_time
     *
     * @return the value of `tb_base_data`.start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method sets the value of the database column `tb_base_data`.start_time
     *
     * @param startTime the value for `tb_base_data`.start_time
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method returns the value of the database column `tb_base_data`.end_time
     *
     * @return the value of `tb_base_data`.end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method sets the value of the database column `tb_base_data`.end_time
     *
     * @param endTime the value for `tb_base_data`.end_time
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method returns the value of the database column `tb_base_data`.driver_time
     *
     * @return the value of `tb_base_data`.driver_time
     */
    public Double getDriverTime() {
        return driverTime;
    }

    /**
     * This method sets the value of the database column `tb_base_data`.driver_time
     *
     * @param driverTime the value for `tb_base_data`.driver_time
     */
    public void setDriverTime(Double driverTime) {
        this.driverTime = driverTime;
    }

    /**
     * This method returns the value of the database column `tb_base_data`.km
     *
     * @return the value of `tb_base_data`.km
     */
    public Double getKm() {
        return km;
    }

    /**
     * This method sets the value of the database column `tb_base_data`.km
     *
     * @param km the value for `tb_base_data`.km
     */
    public void setKm(Double km) {
        this.km = km;
    }

    /**
     * This method returns the value of the database column `tb_base_data`.oil
     *
     * @return the value of `tb_base_data`.oil
     */
    public Double getOil() {
        return oil;
    }

    /**
     * This method sets the value of the database column `tb_base_data`.oil
     *
     * @param oil the value for `tb_base_data`.oil
     */
    public void setOil(Double oil) {
        this.oil = oil;
    }
}