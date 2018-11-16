/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_user_device`
 */
public abstract class UserDeviceBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_user_device`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_user_device`.id
     */
    private static final String PROPERTY_REMARK_ID = "自增ID";

    /**
     * This field corresponds to the database column `tb_user_device`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_user_device`.device_id
     */
    private static final String PROPERTY_DEVICEID = "deviceId";

    /**
     * This field corresponds to the database column `tb_user_device`.device_id
     */
    private static final String PROPERTY_REMARK_DEVICEID = "设备ID";

    /**
     * This field corresponds to the database column `tb_user_device`.device_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_DEVICEID)
    private Integer deviceId;

    /**
     * This field corresponds to the database column `tb_user_device`.user_id
     */
    private static final String PROPERTY_USERID = "userId";

    /**
     * This field corresponds to the database column `tb_user_device`.user_id
     */
    private static final String PROPERTY_REMARK_USERID = "用户ID";

    /**
     * This field corresponds to the database column `tb_user_device`.user_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_USERID)
    private Integer userId;

    /**
     * This method returns the value of the database column `tb_user_device`.id
     *
     * @return the value of `tb_user_device`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_user_device`.id
     *
     * @param id the value for `tb_user_device`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_user_device`.device_id
     *
     * @return the value of `tb_user_device`.device_id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * This method sets the value of the database column `tb_user_device`.device_id
     *
     * @param deviceId the value for `tb_user_device`.device_id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * This method returns the value of the database column `tb_user_device`.user_id
     *
     * @return the value of `tb_user_device`.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method sets the value of the database column `tb_user_device`.user_id
     *
     * @param userId the value for `tb_user_device`.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}