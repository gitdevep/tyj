/*
 * Copyright (C) 2015 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller.alarm;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.core.util.JsonResp;
import com.tyj.controller.AbstractController;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosCount;
import com.tyj.dao.demo.old.bo.DrivingEvaluation;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosCountService;
import com.tyj.service.demo.general.UserDeviceService;
import com.tyj.service.demo.old.DrivingEvaluationService;
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
@RequestMapping(value = "userScore")
public class UserScoreController extends AbstractController {

    @Resource(name = "deviceGpsInfosCountService")
    DeviceGpsInfosCountService deviceGpsInfosCountService;

    @Resource(name = "drivingEvaluationService")
    DrivingEvaluationService drivingEvaluationService;

    @Resource(name = "userDeviceService")
    UserDeviceService userDeviceService;

    /**
     * 用户评分
     * @param deviceId 设备编号
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getUserScore")
    public String getUserScore(@RequestParam("deviceId") Integer deviceId,
                                @RequestParam("startDate") String startDate,
                                @RequestParam("endDate") String endDate) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(deviceId);
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> p = new HashMap<String, Object>(3);
        p.put("deviceId", deviceId);
        p.put("startDate", startDate);
        p.put("endDate", endDate);
        List<DeviceGpsInfosCount> l = deviceGpsInfosCountService.findParams(p);
        Date start = DateUtil.parse(DateUtil.yyyy_MM_dd, startDate);
        Date end = DateUtil.parse(DateUtil.yyyy_MM_dd, endDate);
        int day = (int) DateUtil.getBetweenDiff(start, end, DateUtil.DAY_TIME) + 1;
        String [] cl = new String[day];
        double [] d = new double[day];
        for (int i = 0; i < day; i++) {
            String tmp = DateUtil.getDateStr(start, DateUtil.yyyy_MM_dd, Calendar.DATE, i);
            cl[i] = tmp;
            for (DeviceGpsInfosCount g : l) {
                String countDate = DateUtil.format(DateUtil.yyyy_MM_dd, g.getCountDate());
                if (tmp.equals(countDate)) {
                    cl[i] = DateUtil.format(DateUtil.yyyy_MM_dd, g.getCountDate());
                    d[i] = g.getScores();
                    break;
                }
            }
        }
        return JsonResp.asData().add("CAT", cl).add("DATA", d).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/getOldUserScore")
    public String getOldUserScore(@RequestParam("deviceId") Integer deviceId,
                                  @RequestParam("startDate") String startDate,
                                  @RequestParam("endDate") String endDate) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(deviceId);
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> p = new HashMap<String, Object>(3);
        p.put("deviceId", deviceId);
        p.put("startDate", startDate);
        p.put("endDate", endDate);
        List<DrivingEvaluation> l = drivingEvaluationService.findParams(p);
        Date start = DateUtil.parse(DateUtil.yyyy_MM_dd, startDate);
        Date end = DateUtil.parse(DateUtil.yyyy_MM_dd, endDate);
        int day = (int) DateUtil.getBetweenDiff(start, end, DateUtil.DAY_TIME) + 1;
        String [] cl = new String[day];
        double [] d = new double[day];
        for (int i = 0; i < day; i++) {
            String tmp = DateUtil.getDateStr(start, DateUtil.yyyy_MM_dd, Calendar.DATE, i);
            cl[i] = tmp;
            for (DrivingEvaluation g : l) {
                String countDate = DateUtil.format(DateUtil.yyyy_MM_dd, g.getEvaluateTime());
                if (tmp.equals(countDate)) {
                    cl[i] = DateUtil.format(DateUtil.yyyy_MM_dd, g.getEvaluateTime());
                    d[i] = g.getScores();
                    break;
                }
            }
        }
        return JsonResp.asData().add("CAT", cl).add("DATA", d).toJson();
    }
}
