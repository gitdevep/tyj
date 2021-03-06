/*
 * Copyright (C) 2015 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general;

import cn.vansky.framework.core.service.GenericService;
import com.tyj.dao.demo.general.bo.DeviceInfo;

import java.util.List;
import java.util.Map;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table `device_info`
 *
 * @mbggenerated 2015-12-09 08:31:58
 */
public interface DeviceInfoService extends GenericService<DeviceInfo, Integer> {

    List<DeviceInfo> findPageDeviceInfo(Map<String, Object> map);

    List<DeviceInfo> findPageTeamMember(Map<String, Object> map);

    List<DeviceInfo> findPageCars(Map<String, Object> map);

    List<DeviceInfo> findAllCars(Map<String, Object> map);

    void truncate();
}