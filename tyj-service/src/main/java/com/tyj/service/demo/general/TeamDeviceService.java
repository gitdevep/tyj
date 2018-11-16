/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general;

import cn.vansky.framework.core.service.GenericService;
import com.tyj.dao.demo.general.bo.TeamDevice;

import java.util.Map;

/**
 * This class corresponds to the database table `tb_team_device`
 */
public interface TeamDeviceService extends GenericService<TeamDevice, Integer> {

    void delMember(Map<String, Object> params);
}