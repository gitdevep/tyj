/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.deviceGpsInfos.service.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosActive;
import com.tyj.dao.demo.deviceGpsInfos.dao.DeviceGpsInfosActiveDao;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosActiveService;
import java.util.HashMap;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * This class corresponds to the database table `device_gps_infos_active`
 */
@Service("deviceGpsInfosActiveService")
public class DeviceGpsInfosActiveServiceImpl extends GenericSqlMapServiceImpl<DeviceGpsInfosActive, HashMap> implements DeviceGpsInfosActiveService {
    @Resource(name = "deviceGpsInfosActiveDao")
    private DeviceGpsInfosActiveDao deviceGpsInfosActiveDao;

    @Override
    public SqlMapDao<DeviceGpsInfosActive, HashMap> getDao() {
        return deviceGpsInfosActiveDao;
    }
}