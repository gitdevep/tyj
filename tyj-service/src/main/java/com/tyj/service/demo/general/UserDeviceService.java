/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general;

import cn.vansky.framework.core.service.GenericService;
import com.tyj.dao.demo.general.bo.UserDevice;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user_device`
 */
public interface UserDeviceService extends GenericService<UserDevice, Integer> {
    void delMember(Map<String, Object> params);

    List<Integer> findDeviceIdsByCurrentUser();

    String validation(List<Integer> deviceIds);
}