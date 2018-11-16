/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.general.bo.UserDevice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user_device`
 */
@SqlMapper
public interface UserDeviceMapper extends DaoMapper<UserDevice, Integer> {
    void delMember(Map<String, Object> params);

    List<Integer> findDeviceIdsByUserId(@Param("userId") Integer userId);
}