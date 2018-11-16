/*
 * Copyright (C) 2015 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller.alarm;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.core.util.JsonResp;
import com.tyj.controller.AbstractController;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import com.tyj.service.demo.general.UserDeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/12/9
 */
@Controller
@RequestMapping(value = "daySpeed")
public class DaySpeedController extends AbstractController {

    @Resource(name = "deviceGpsInfosService")
    DeviceGpsInfosService deviceGpsInfosService;

    @Resource(name = "userDeviceService")
    UserDeviceService userDeviceService;
    /**
     * 每日车速
     * @param deviceId 设备编号
     * @param date 日期
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getDaySpeed")
    public String getDaySpeed(@RequestParam("deviceId") Integer deviceId,
                                @RequestParam("date") String date) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(deviceId);
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> p = new HashMap<String, Object>(3);
        p.put("deviceId", deviceId);
        p.put("startDate", date);
        Date cd = DateUtil.parse(DateUtil.yyyy_MM_dd, date);
        p.put("endDate", DateUtil.getDateStr(cd, DateUtil.yyyy_MM_dd, Calendar.DATE, 1));
        List<DeviceGpsInfos> l = deviceGpsInfosService.findDaySpeed(p);
        String [] dl = new String[l.size()];
        int [] d = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            DeviceGpsInfos dgc = l.get(i);
            dl[i] = DateUtil.format(DateUtil.HH_mm, dgc.getEventTime());
            d[i] = dgc.getSpeed();
        }
        return JsonResp.asData().add("CAT", dl).add("DATA", d).toJson();
    }
}
