package com.tyj.service.demo.deviceGpsInfos.service.impl;

import com.tyj.dao.demo.deviceGpsInfos.dao.DeviceGpsInfosDao;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceGpsInfosServiceImplTest {

    @InjectMocks
    private DeviceGpsInfosService service;

    @Mock
    private DeviceGpsInfosDao dao;

    @BeforeClass(alwaysRun = true)
    public void initMocks() {
        service = new DeviceGpsInfosServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByDeviceIds() throws Exception {
        List<Integer> l = new ArrayList<Integer>();
        Mockito.when(dao.findByDeviceIds(l)).thenReturn(get());
        List<Map<String, Object>> list = service.findByDeviceIds(l);
        if (list != null) {
            System.out.println(list.size());
        }
    }

    private List<Map<String, Object>> get() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("device_id", "10051");
        m.put("event_time", "2016-01-01 10:00:00");
        list.add(m);
        Map<String, Object> m1 = new HashMap<String, Object>();
        m1.put("device_id", "10055");
        m1.put("event_time", "2016-01-02 10:00:00");
        list.add(m1);
        Map<String, Object> m2 = new HashMap<String, Object>();
        m2.put("device_id", "10056");
        m2.put("event_time", "2016-01-03 10:00:00");
        list.add(m2);
        return list;
    }
}