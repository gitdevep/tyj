/*
 * Copyright (C) 2015 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller.general;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.core.util.JsonResp;
import com.tyj.controller.AbstractController;
import com.tyj.dao.demo.general.bo.DeviceInfo;
import com.tyj.dao.demo.general.vo.DeviceInfoPageVo;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import com.tyj.service.demo.general.DeviceInfoService;
import com.tyj.service.demo.general.UserDeviceService;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/12/9
 */
@Controller
@RequestMapping(value = "deviceInfo")
public class DeviceInfoController extends AbstractController {

    @Resource(name = "deviceInfoService")
    DeviceInfoService deviceInfoService;

    @Resource(name = "deviceGpsInfosService")
    DeviceGpsInfosService deviceGpsInfosService;

    @Resource(name = "userDeviceService")
    UserDeviceService userDeviceService;

    /**
     * 分页查询用户
     * @param vo 姓名、车牌、微信号
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/page/listDeviceInfo")
    public String listDeviceInfo(DeviceInfoPageVo vo) {
        Map<String, Object> params = vo.convertPageMap();
        List<Integer> list = userDeviceService.findDeviceIdsByCurrentUser();
        if (list.isEmpty()) {
            vo.setRows(new ArrayList());
            return JsonResp.asData(vo).setDatePattern(DateUtil.yyyy_MM_dd_HH_mm_ss).toJson();
        }
        params.put("list", list);
        List<DeviceInfo> ul = deviceInfoService.findPageDeviceInfo(params);
        List<Integer> dl = new ArrayList<Integer>(ul.size());
        for (int i = 0; i < ul.size(); i++) {
            dl.add(ul.get(i).getDeviceId());
        }
        if (!dl.isEmpty()) {
            List<Map<String, Object>> l = deviceGpsInfosService.findByDeviceIds(dl);
            for (int i = 0; i < ul.size(); i++) {
                for (Map<String, Object> m : l) {
                    if (ul.get(i).getDeviceId().equals(MapUtils.getInteger(m, "device_id"))) {
                        Object o = MapUtils.getObject(m, "event_time");
                        if (o != null) {
                            ul.get(i).setDistance(DateUtil.getBetweenDiff((Date) o, new Date(), DateUtil.HOUR_TIME));
                        }
                        break;
                    }
                }
            }
        }
        vo.setRows(ul);
        return JsonResp.asData(vo).setDatePattern(DateUtil.yyyy_MM_dd_HH_mm_ss).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/page/list_team_member")
    public String list(DeviceInfoPageVo vo) {
        List<DeviceInfo> ul = deviceInfoService.findPageTeamMember(vo.convertPageMap());
        vo.setRows(ul);
        return JsonResp.asData(vo).toJson();
    }
}
