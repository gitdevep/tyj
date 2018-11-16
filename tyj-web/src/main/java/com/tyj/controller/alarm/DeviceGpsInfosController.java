/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller.alarm;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.core.util.JsonResp;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/8/24
 */
@Controller
@RequestMapping(value = "gpsinfo")
public class DeviceGpsInfosController {

    @Resource(name = "deviceGpsInfosService")
    DeviceGpsInfosService deviceGpsInfosService;

    @ResponseBody
    @RequestMapping({"/add"})
    public String add(DeviceGpsInfos deviceGpsInfos) {
        deviceGpsInfos.setEventTime(DateUtil.parse("yyyy-MM-dd HH:mm:ss", deviceGpsInfos.getEventTimeStr()));
        deviceGpsInfos.setUploadTime(DateUtil.parse("yyyy-MM-dd HH:mm:ss", deviceGpsInfos.getUploadTimeStr()));
        this.deviceGpsInfosService.saveEntitySelective(deviceGpsInfos);
        return JsonResp.asEmpty().toJson();
    }
}
