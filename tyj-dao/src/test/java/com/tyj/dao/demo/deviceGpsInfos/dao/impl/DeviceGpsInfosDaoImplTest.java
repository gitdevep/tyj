package com.tyj.dao.demo.deviceGpsInfos.dao.impl;

import com.tyj.dao.demo.deviceGpsInfos.dao.DeviceGpsInfosDao;
import com.tyj.dbunit.BaseDbTestCase;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class DeviceGpsInfosDaoImplTest extends BaseDbTestCase {

    @Resource(name = "deviceGpsInfosDao")
    DeviceGpsInfosDao deviceGpsInfosDao;

    @Test
    public void testCreatePartition() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("table_schema", "demo_test");
        params.put("table_name", "device_gps_infos");
        deviceGpsInfosDao.createPartition(params);
    }
}