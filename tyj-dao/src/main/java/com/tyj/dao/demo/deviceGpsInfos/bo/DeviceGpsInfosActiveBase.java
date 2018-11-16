/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.deviceGpsInfos.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;
import java.util.Date;

/**
 * This class corresponds to the database table `device_gps_infos_active`
 */
public abstract class DeviceGpsInfosActiveBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `device_gps_infos_active`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.id
     */
    private static final String PROPERTY_REMARK_ID = "设备ID";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.event_time
     */
    private static final String PROPERTY_EVENTTIME = "eventTime";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.event_time
     */
    private static final String PROPERTY_REMARK_EVENTTIME = "数据采集时间";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.event_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_EVENTTIME)
    @Id
    private Date eventTime;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.device_id
     */
    private static final String PROPERTY_DEVICEID = "deviceId";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.device_id
     */
    private static final String PROPERTY_REMARK_DEVICEID = "设备ID";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.device_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DEVICEID)
    private Integer deviceId;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.msg_id
     */
    private static final String PROPERTY_MSGID = "msgId";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.msg_id
     */
    private static final String PROPERTY_REMARK_MSGID = "终端带的消息ID";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.msg_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_MSGID)
    private Integer msgId;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.longitude
     */
    private static final String PROPERTY_LONGITUDE = "longitude";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.longitude
     */
    private static final String PROPERTY_REMARK_LONGITUDE = "经度";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.longitude
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LONGITUDE)
    private Double longitude;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.latitude
     */
    private static final String PROPERTY_LATITUDE = "latitude";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.latitude
     */
    private static final String PROPERTY_REMARK_LATITUDE = "纬度";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.latitude
     */
    @ColumnDescription(desc = PROPERTY_REMARK_LATITUDE)
    private Double latitude;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.speed
     */
    private static final String PROPERTY_SPEED = "speed";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.speed
     */
    private static final String PROPERTY_REMARK_SPEED = "车速";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.speed
     */
    @ColumnDescription(desc = PROPERTY_REMARK_SPEED)
    private Integer speed;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.msg_type
     */
    private static final String PROPERTY_MSGTYPE = "msgType";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.msg_type
     */
    private static final String PROPERTY_REMARK_MSGTYPE = "告警类型,表:msg_type";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.msg_type
     */
    @ColumnDescription(desc = PROPERTY_REMARK_MSGTYPE)
    private Byte msgType;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.flash_state
     */
    private static final String PROPERTY_FLASHSTATE = "flashState";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.flash_state
     */
    private static final String PROPERTY_REMARK_FLASHSTATE = "设备flash状态（正常为00，当FLASH存储空间饱和为FF）";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.flash_state
     */
    @ColumnDescription(desc = PROPERTY_REMARK_FLASHSTATE)
    private Byte flashState;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.upload_time
     */
    private static final String PROPERTY_UPLOADTIME = "uploadTime";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.upload_time
     */
    private static final String PROPERTY_REMARK_UPLOADTIME = "上传时间";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.upload_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_UPLOADTIME)
    private Date uploadTime;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.acceleration
     */
    private static final String PROPERTY_ACCELERATION = "acceleration";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.acceleration
     */
    private static final String PROPERTY_REMARK_ACCELERATION = "加速度";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.acceleration
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ACCELERATION)
    private Float acceleration;

    /**
     * This field corresponds to the database column `device_gps_infos_active`.flag
     */
    private static final String PROPERTY_FLAG = "flag";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.flag
     */
    private static final String PROPERTY_REMARK_FLAG = "0:正常,1:异常";

    /**
     * This field corresponds to the database column `device_gps_infos_active`.flag
     */
    @ColumnDescription(desc = PROPERTY_REMARK_FLAG)
    private Byte flag;

    /**
     * This method returns the value of the database column `device_gps_infos_active`.id
     *
     * @return the value of `device_gps_infos_active`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.id
     *
     * @param id the value for `device_gps_infos_active`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.event_time
     *
     * @return the value of `device_gps_infos_active`.event_time
     */
    public Date getEventTime() {
        return eventTime;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.event_time
     *
     * @param eventTime the value for `device_gps_infos_active`.event_time
     */
    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.device_id
     *
     * @return the value of `device_gps_infos_active`.device_id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.device_id
     *
     * @param deviceId the value for `device_gps_infos_active`.device_id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.msg_id
     *
     * @return the value of `device_gps_infos_active`.msg_id
     */
    public Integer getMsgId() {
        return msgId;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.msg_id
     *
     * @param msgId the value for `device_gps_infos_active`.msg_id
     */
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.longitude
     *
     * @return the value of `device_gps_infos_active`.longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.longitude
     *
     * @param longitude the value for `device_gps_infos_active`.longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.latitude
     *
     * @return the value of `device_gps_infos_active`.latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.latitude
     *
     * @param latitude the value for `device_gps_infos_active`.latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.speed
     *
     * @return the value of `device_gps_infos_active`.speed
     */
    public Integer getSpeed() {
        return speed;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.speed
     *
     * @param speed the value for `device_gps_infos_active`.speed
     */
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.msg_type
     *
     * @return the value of `device_gps_infos_active`.msg_type
     */
    public Byte getMsgType() {
        return msgType;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.msg_type
     *
     * @param msgType the value for `device_gps_infos_active`.msg_type
     */
    public void setMsgType(Byte msgType) {
        this.msgType = msgType;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.flash_state
     *
     * @return the value of `device_gps_infos_active`.flash_state
     */
    public Byte getFlashState() {
        return flashState;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.flash_state
     *
     * @param flashState the value for `device_gps_infos_active`.flash_state
     */
    public void setFlashState(Byte flashState) {
        this.flashState = flashState;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.upload_time
     *
     * @return the value of `device_gps_infos_active`.upload_time
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.upload_time
     *
     * @param uploadTime the value for `device_gps_infos_active`.upload_time
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.acceleration
     *
     * @return the value of `device_gps_infos_active`.acceleration
     */
    public Float getAcceleration() {
        return acceleration;
    }

    /**
     * This method sets the value of the database column `device_gps_infos_active`.acceleration
     *
     * @param acceleration the value for `device_gps_infos_active`.acceleration
     */
    public void setAcceleration(Float acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * This method returns the value of the database column `device_gps_infos_active`.flag
     *
     * @return the value of `device_gps_infos_active`.flag
     */
    public Byte getFlag() {
        return flag;
    }
}