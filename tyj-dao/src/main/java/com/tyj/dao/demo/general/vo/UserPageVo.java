/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.vo;

import cn.vansky.framework.core.vo.BaseVo;
import com.tyj.dao.demo.general.bo.User;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/5/6
 */
public class UserPageVo extends BaseVo<User> {
    private String name;
    private Byte status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
