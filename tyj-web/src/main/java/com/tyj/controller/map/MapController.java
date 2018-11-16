/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller.map;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.core.util.JsonResp;
import com.tyj.controller.AbstractController;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.dao.jhpt.deviceGpsInfos.bo.MsgType;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import com.tyj.service.demo.general.DeviceInfoService;
import com.tyj.service.demo.general.UserDeviceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/4/3
 */
@Controller
@RequestMapping(value = "map")
public class MapController extends AbstractController {

    @Resource(name = "deviceGpsInfosService")
    DeviceGpsInfosService deviceGpsInfosService;

    @Resource(name = "deviceInfoService")
    DeviceInfoService deviceInfoService;

    @Resource(name = "userDeviceService")
    UserDeviceService userDeviceService;

    @ResponseBody
    @RequestMapping(value = "/getMessageWindow")
    public String getMessageWindow(@RequestParam Map<String, Object> p) {
        p.put("map", 1);
        Map<String, Object> map = new HashMap<String, Object>();
        String [] ds = p.get("deviceId").toString().split(",");
        List<Integer> deviceIds = new ArrayList<Integer>();
        for (String d : ds) {
            deviceIds.add(Integer.valueOf(d));
        }
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Object flag = p.get("flag");
        for (int i = 0; i < ds.length; i++) {
            String deviceId = ds[i];
            p.put("deviceId", deviceId);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            List<DeviceGpsInfos> results = new ArrayList<DeviceGpsInfos>();
            if (null != flag) {
                results.add(l.get(0));
                int length = l.size() / 10;
                for (int j = 1; j < 10; j++) {
                    results.add(l.get(j * length));
                }
                results.add(l.get(l.size() - 1));
            } else {
                for (DeviceGpsInfos d : l) {
                    d.setMsgTypeName(MsgType.getName(d.getMsgType().intValue()));
                    d.setLongitude(d.getLongitude());
                    d.setLatitude(d.getLatitude());
                    d.setIcon(i);
                    results.add(d);
                }
            }
            map.put(p.get("deviceId").toString(), results);
        }
        return JsonResp.asData().addAll(map).setDatePattern(DateUtil.yyyy_MM_dd_HH_mm_ss).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/geographyLocation")
    public String geographyLocation(@RequestParam Map<String, Object> p) {
        if (p.get("deviceIds") != null && !StringUtils.isBlank(p.get("deviceIds").toString())) {
            // 不为空时验证输入设备号
            String [] ds = p.get("deviceIds").toString().split("\\|");
            List<Integer> deviceIds = new ArrayList<Integer>();
            for (String d : ds) {
                deviceIds.add(Integer.valueOf(d));
            }
            String msg = userDeviceService.validation(deviceIds);
            if (msg != null) {
                return JsonResp.asEmpty().error(msg).toJson();
            }
            p.put("deviceIds", ds);
        } else {
            // 查询当前账户下所有设备号
            List<Integer> deviceIds = userDeviceService.findDeviceIdsByCurrentUser();
            p.put("deviceIds", deviceIds);
        }
        List<DeviceGpsInfos> l = deviceGpsInfosService.findLocation(p);
        for (int i = 0; i < l.size(); i++) {
            DeviceGpsInfos deviceGpsInfos = l.get(i);
            deviceGpsInfos.setIcon(i);
        }
        return JsonResp.asList().addAll(l).setDatePattern(DateUtil.yyyy_MM_dd_HH_mm_ss).toJson();
    }
}
