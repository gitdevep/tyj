/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller.general;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.common.util.MapDistance;
import cn.vansky.framework.core.util.JsonResp;
import com.tyj.controller.AbstractController;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.dao.demo.general.bo.BaseData;
import com.tyj.dao.demo.general.vo.BaseDataPageVo;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import com.tyj.service.demo.general.BaseDataService;
import com.tyj.service.schedule.CalculateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/5/14
 */
@Controller
@RequestMapping("/general")
public class GeneralController extends AbstractController {

    @Resource(name = "baseDataService")
    BaseDataService baseDataService;

    @Resource(name = "deviceGpsInfosService")
    DeviceGpsInfosService deviceGpsInfosService;

    @ResponseBody
    @RequestMapping(value = "/page/list")
    public String findPageUser(BaseDataPageVo vo) {
        if (vo.getType() == 2) {
            Map<String, Object> p = new HashMap<String, Object>();
            p.put("deviceId", vo.getDeviceId());
            p.put("startDate", vo.getStartDate());
            p.put("endDate", vo.getEndDate());
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double distance = CalculateUtils.calculateDistance(l);
            BaseData baseData = new BaseData();
            baseData.setDeviceId(vo.getDeviceId());
            baseData.setStartTime(DateUtil.parse(DateUtil.yyyy_MM_dd, vo.getStartDate()));
            baseData.setEndTime(DateUtil.parse(DateUtil.yyyy_MM_dd, vo.getEndDate()));
            double time = CalculateUtils.calculateTime(l);
            baseData.setDriverTime(time);
            baseData.setKm(distance);
            baseData.setOil(vo.getOil());
            if (distance != 0) {
                baseData.setOilAvg(vo.getOil() / distance / 100);
            }
            baseDataService.saveEntitySelective(baseData);
            List<BaseData> result = new ArrayList<BaseData>(1);
            result.add(baseData);
            vo.setTotal(1);
            vo.setRows(result);
            return JsonResp.asData(vo).setDatePattern(DateUtil.yyyy_MM_dd).toJson();
        } else {
            List<BaseData> result = baseDataService.findPage(vo.convertPageMap());
            for (BaseData it : result) {
                if (it.getKm() != 0) {
                    it.setOilAvg(it.getOil() / it.getKm() / 100);
                }
            }
            vo.setRows(result);
            return JsonResp.asData(vo).setDatePattern(DateUtil.yyyy_MM_dd).toJson();
        }
    }
}
