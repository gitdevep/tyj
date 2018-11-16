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
 * This class corresponds to the database table `tb_user`
 */
public abstract class UserBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_user`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_user`.id
     */
    private static final String PROPERTY_REMARK_ID = "用户编号";

    /**
     * This field corresponds to the database column `tb_user`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_user`.name
     */
    private static final String PROPERTY_NAME = "name";

    /**
     * This field corresponds to the database column `tb_user`.name
     */
    private static final String PROPERTY_REMARK_NAME = "用户名";

    /**
     * This field corresponds to the database column `tb_user`.name
     */
    @ColumnDescription(desc = PROPERTY_REMARK_NAME)
    private String name;

    /**
     * This field corresponds to the database column `tb_user`.password
     */
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * This field corresponds to the database column `tb_user`.password
     */
    private static final String PROPERTY_REMARK_PASSWORD = "密码";

    /**
     * This field corresponds to the database column `tb_user`.password
     */
    @ColumnDescription(desc = PROPERTY_REMARK_PASSWORD)
    private String password;

    /**
     * This field corresponds to the database column `tb_user`.create_time
     */
    private static final String PROPERTY_CREATETIME = "createTime";

    /**
     * This field corresponds to the database column `tb_user`.create_time
     */
    private static final String PROPERTY_REMARK_CREATETIME = "创建时间";

    /**
     * This field corresponds to the database column `tb_user`.create_time
     */
    @ColumnDescription(desc = PROPERTY_REMARK_CREATETIME)
    private Date createTime;

    /**
     * This field corresponds to the database column `tb_user`.auth_id
     */
    private static final String PROPERTY_AUTHID = "authId";

    /**
     * This field corresponds to the database column `tb_user`.auth_id
     */
    private static final String PROPERTY_REMARK_AUTHID = "权限系统ID";

    /**
     * This field corresponds to the database column `tb_user`.auth_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_AUTHID)
    private Integer authId;

    /**
     * This field corresponds to the database column `tb_user`.status
     */
    private static final String PROPERTY_STATUS = "status";

    /**
     * This field corresponds to the database column `tb_user`.status
     */
    private static final String PROPERTY_REMARK_STATUS = "状态:1:可用,2:不可用";

    /**
     * This field corresponds to the database column `tb_user`.status
     */
    @ColumnDescription(desc = PROPERTY_REMARK_STATUS)
    private Byte status;

    /**
     * This method returns the value of the database column `tb_user`.id
     *
     * @return the value of `tb_user`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_user`.id
     *
     * @param id the value for `tb_user`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_user`.name
     *
     * @return the value of `tb_user`.name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value of the database column `tb_user`.name
     *
     * @param name the value for `tb_user`.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the value of the database column `tb_user`.password
     *
     * @return the value of `tb_user`.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets the value of the database column `tb_user`.password
     *
     * @param password the value for `tb_user`.password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method returns the value of the database column `tb_user`.create_time
     *
     * @return the value of `tb_user`.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column `tb_user`.create_time
     *
     * @param createTime the value for `tb_user`.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column `tb_user`.auth_id
     *
     * @return the value of `tb_user`.auth_id
     */
    public Integer getAuthId() {
        return authId;
    }

    /**
     * This method sets the value of the database column `tb_user`.auth_id
     *
     * @param authId the value for `tb_user`.auth_id
     */
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    /**
     * This method returns the value of the database column `tb_user`.status
     *
     * @return the value of `tb_user`.status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column `tb_user`.status
     *
     * @param status the value for `tb_user`.status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}