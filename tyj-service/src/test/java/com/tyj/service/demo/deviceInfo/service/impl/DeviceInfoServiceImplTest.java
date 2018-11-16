package com.tyj.service.demo.deviceInfo.service.impl;

import cn.vansky.framework.core.bean.ServiceLocator;
import cn.vansky.framework.core.orm.mybatis.plugin.page.BasePagination;
import cn.vansky.framework.core.orm.mybatis.plugin.page.Pagination;
import cn.vansky.framework.core.util.SpringUtils;
import com.tyj.dao.demo.general.bo.DeviceInfo;
import com.tyj.dao.demo.general.dao.DeviceInfoDao;
import com.tyj.service.demo.general.DeviceInfoService;
import com.tyj.service.demo.general.impl.DeviceInfoServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration(locations = { "classpath:/conf/applicationContext-test.xml" }, inheritLocations = false)
@TransactionConfiguration(transactionManager = "transactionManager")
public class DeviceInfoServiceImplTest {

    @InjectMocks
    DeviceInfoService service;

    @Mock
    DeviceInfoDao dao;

    @BeforeClass(alwaysRun = true)
    public void initMocks() {
        service = new DeviceInfoServiceImpl();
        MockitoAnnotations.initMocks(this);
        ServiceLocator.getInstance().setFactory(SpringUtils.getApplicationContext());
    }

    @Test
    public void testFindPageDeviceInfo() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Pagination page = new BasePagination();
        page.setCurrentPage(1);
        page.setLimit(10);
        map.put(Pagination.MAP_PAGE_FIELD, page);
        List<DeviceInfo> infos = service.findPageDeviceInfo(map);
    }
}