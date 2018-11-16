/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule.condition;

import cn.vansky.framework.common.util.DateUtil;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosCount;
import com.tyj.dao.demo.old.bo.FactorWarning;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosCountService;

import javax.annotation.Resource;
import java.util.*;

/**
 * 前天分数
 * Author: CK
 * Date: 2016/2/28
 */
public class FrontDateScoreCondition extends AbstractCondition {

    @Resource(name = "deviceGpsInfosCountService")
    DeviceGpsInfosCountService deviceGpsInfosCountService;

    public FrontDateScoreCondition(Object obj) {
        super(obj, FactorWarning.PREV_DAY);
    }

    @Override
    public double calculateExtendScore() {
        String frontDate = DateUtil.getDateStr(new Date(), DateUtil.yyyy_MM_dd, Calendar.DATE, -1);
        Map<String, Object> p = new HashMap<String, Object>(3);
        p.put("deviceId", deviceId);
        p.put("startDate", frontDate);
        p.put("endDate", frontDate);
        List<DeviceGpsInfosCount> l = deviceGpsInfosCountService.findParams(p);
        // TODO 根据前天结果计算分数
        return 0;
    }
}
