/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.deviceGpsInfos.dao;

import cn.vansky.framework.core.dao.SqlMapDao;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosActive;
import java.util.HashMap;

/**
 * This class corresponds to the database table `device_gps_infos_active`
 */
public interface DeviceGpsInfosActiveDao extends SqlMapDao<DeviceGpsInfosActive, HashMap> {
}