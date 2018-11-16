/*
 * Copyright (C) 2015 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.jhpt.deviceInfo.service.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import com.tyj.dao.jhpt.deviceInfo.bo.DeviceInfo;
import com.tyj.dao.jhpt.deviceInfo.dao.DeviceInfoJhptDao;
import com.tyj.service.jhpt.deviceInfo.service.DeviceInfoServiceJhpt;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table `device_info`
 *
 * @mbggenerated 2015-12-10 09:17:05
 */
@Service("deviceInfoServiceJhpt")
public class DeviceInfoServiceJhptImpl extends GenericSqlMapServiceImpl<DeviceInfo, Integer> implements DeviceInfoServiceJhpt {
    @Resource(name = "deviceInfoDaoJhpt")
    private DeviceInfoJhptDao deviceInfoJhptDao;

    @Override
    public SqlMapDao<DeviceInfo, Integer> getDao() {
        return deviceInfoJhptDao;
    }
}