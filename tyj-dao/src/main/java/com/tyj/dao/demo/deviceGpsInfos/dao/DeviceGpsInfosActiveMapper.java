/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.deviceGpsInfos.dao;

import cn.vansky.framework.core.dao.DaoMapper;
import cn.vansky.framework.core.orm.mybatis.annotation.SqlMapper;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosActive;
import java.util.HashMap;

/**
 * This class corresponds to the database table `device_gps_infos_active`
 */
@SqlMapper
public interface DeviceGpsInfosActiveMapper extends DaoMapper<DeviceGpsInfosActive, HashMap> {
}