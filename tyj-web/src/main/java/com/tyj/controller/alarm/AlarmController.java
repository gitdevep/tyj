/*
 * Copyright (C) 2015 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller.alarm;

import cn.vansky.framework.common.util.AmountCountUtil;
import cn.vansky.framework.common.util.CsvUtil;
import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.core.util.JsonResp;
import com.tyj.controller.AbstractController;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfosCount;
import com.tyj.dao.jhpt.deviceGpsInfos.bo.MsgType;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosCountService;
import com.tyj.service.demo.general.UserDeviceService;
import com.tyj.service.schedule.CalculateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/12/9
 */
@Controller
@RequestMapping(value = "alarm")
public class AlarmController extends AbstractController {

    @Resource(name = "deviceGpsInfosCountService")
    DeviceGpsInfosCountService deviceGpsInfosCountService;

    @Resource(name = "deviceGpsInfosService")
    DeviceGpsInfosService deviceGpsInfosService;

    @Resource(name = "userDeviceService")
    UserDeviceService userDeviceService;

    /**
     * 每天预警
     * @param deviceId 设备编号
     * @param date 开始日期
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getDayAlarm")
    public String getDayAlarm(@RequestParam("deviceId") Integer deviceId,
                              @RequestParam("date") String date) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(deviceId);
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> p = new HashMap<String, Object>(3);
        p.put("deviceId", deviceId);
        Date cd = DateUtil.parse(DateUtil.yyyy_MM_dd, date);
        int w = DateUtil.week(cd);
        p.put("startDate", DateUtil.getDateStr(cd, DateUtil.yyyy_MM_dd, Calendar.DATE, 1 - w));
        p.put("endDate", DateUtil.getDateStr(cd, DateUtil.yyyy_MM_dd, Calendar.DATE, 7 - w));
        List<DeviceGpsInfosCount> l = deviceGpsInfosCountService.findParams(p);
        int [] d = new int[10];
        int [] m1 = new int[7];
        int [] m2 = new int[7];
        int [] m3 = new int[7];
        int [] m4 = new int[7];
        int [] m5 = new int[7];
        int [] m6 = new int[7];
        int [] m7 = new int[7];
        int [] m8 = new int[7];
        int [] m9 = new int[7];
        for (DeviceGpsInfosCount g : l) {
            // 获取当天星期几
            int week = DateUtil.week(g.getCountDate()) - 1;
            if (date.equals(DateUtil.format(DateUtil.yyyy_MM_dd, g.getCountDate()))) {
                d[0] = g.getOneCarFrontCollide() + g.getTwoCarFrontCollide() + g.getLimitSpeedAlarm()
                        + g.getLeftLaneDeviate() + g.getRightLaneDeviate() + g.getCityFrontCollide()
                        + g.getCarDistanceMonitor() + g.getPersonFrontCollide() + g.getSpeedUp() + g.getSpeedDown();
                d[1] = g.getTwoCarFrontCollide();
                d[2] = g.getOneCarFrontCollide();
                d[3] = g.getLimitSpeedAlarm();
                d[4] = g.getLeftLaneDeviate() + g.getRightLaneDeviate();
                d[5] = g.getCityFrontCollide();
                d[6] = g.getCarDistanceMonitor();
                d[7] = g.getPersonFrontCollide();
                d[8] = g.getSpeedUp();
                d[9] = g.getSpeedDown();
            }
            m1[week] = g.getTwoCarFrontCollide();
            m2[week] = g.getOneCarFrontCollide();
            m3[week] = g.getLimitSpeedAlarm();
            m4[week] = g.getLeftLaneDeviate() + g.getRightLaneDeviate();
            m5[week] = g.getCityFrontCollide();
            m6[week] = g.getCarDistanceMonitor();
            m7[week] = g.getPersonFrontCollide();
            m8[week] = g.getSpeedUp();
            m9[week] = g.getSpeedDown();
        }
        return JsonResp.asData()
                .add("MSG", d)
                .add("M1", m1)
                .add("M2", m2)
                .add("M3", m3)
                .add("M4", m4)
                .add("M5", m5)
                .add("M6", m6)
                .add("M7", m7)
                .add("M8", m8)
                .add("M9", m9)
                .toJson();
    }

    /**
     * 时段预警
     * @param deviceId 设备编号
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getAlarmInterval")
    public String getAlarmInterval(@RequestParam("deviceId") Integer deviceId,
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
        String [] m = new String[day];
        int [] m1 = new int[day];
        int [] m2 = new int[day];
        int [] m3 = new int[day];
        int [] m4 = new int[day];
        int [] m5 = new int[day];
        int [] m6 = new int[day];
        for (int i = 0; i < day; i++) {
            String tmp = DateUtil.getDateStr(start, DateUtil.yyyy_MM_dd, Calendar.DATE, i);
            m[i] = tmp;
            for (DeviceGpsInfosCount dgc : l) {
                String countDate = DateUtil.format(DateUtil.yyyy_MM_dd, dgc.getCountDate());
                if (tmp.equals(countDate)) {
                    m[i] = countDate;
                    m1[i] = dgc.getCarFrontCollide();
                    m2[i] = dgc.getLimitSpeedAlarm();
                    m3[i] = dgc.getLeftLaneDeviate();
                    m4[i] = dgc.getCityFrontCollide();
                    m5[i] = dgc.getCarDistanceMonitor();
                    m6[i] = dgc.getRightLaneDeviate();
                    break;
                }
            }
        }
        return JsonResp.asData()
                .add("CAT", m)
                .add("M1", m1)
                .add("M2", m2)
                .add("M3", m3)
                .add("M4", m4)
                .add("M5", m5)
                .add("M6", m6)
                .toJson();
    }

    /**
     * 单车统计-平均每小时告警量统计
     * <p>平均每小时告警量=单个告警总量/驾驶时长</p>
     * @param p map
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getAlarmHour")
    public String getAlarmHour(@RequestParam() Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double time = CalculateUtils.calculateTime(l);
            int [] count = CalculateUtils.calculateTypeCount(l);
            double [] r = CalculateUtils.calculateTypeCountByParam(count, time);
            map.put(ds[i], r);
        }
        return JsonResp.asData().addAll(map).toJson();
    }

    /**
     * 单车统计-平均每小时告警量统计(下载)
     * <p>平均每小时告警量=单个告警总量/驾驶时长</p>
     * @param p map
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/downloadAlarmHour")
    public void downloadAlarmHour(HttpServletResponse response, HttpServletRequest request,
                                  @RequestParam() Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "左车道偏离", "右车道偏离",
                "车距监测", "限速警示", "城市前碰撞", "车辆前部碰撞", "急加速", "急减速", "行人前部碰撞"};
        List<String[]> list = new ArrayList<String[]>();
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            String [] result = new String [title.length];
            result[0] = p.get("deviceId").toString();
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double time = CalculateUtils.calculateTime(l);
            int [] count = CalculateUtils.calculateTypeCount(l);
            for (int j = 0; j < count.length; j++) {
                if (time != 0) {
                    result[j + 3] = String.valueOf(AmountCountUtil.div(count[j], time));
                }
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "平均每小时告警量统计表", title, list);
    }

    /**
     * 单车统计-平均每百公里告警量统计
     * <p>平均每百公里告警量=单个告警总量/总里程</p>
     * @param p map
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getAlarmKm")
    public String getAlarmKm(@RequestParam() Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double km = CalculateUtils.calculateDistance(l) / 100;
            int [] count = CalculateUtils.calculateTypeCount(l);
            double [] r = CalculateUtils.calculateTypeCountByParam(count, km);
            map.put(ds[i], r);
        }
        return JsonResp.asData().addAll(map).toJson();
    }

    /**
     * 单车统计-平均每百公里告警量统计(下载)
     * <p>平均每百公里告警量=单个告警总量/总里程</p>
     * @param p map
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/downloadAlarmKm")
    public void downloadAlarmKm(HttpServletResponse response, HttpServletRequest request,
                                  @RequestParam() Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "左车道偏离", "右车道偏离",
                "车距监测", "限速警示", "城市前碰撞", "车辆前部碰撞", "急加速", "急减速", "行人前部碰撞"};
        List<String[]> list = new ArrayList<String[]>();
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            String [] result = new String [title.length];
            result[0] = p.get("deviceId").toString();
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double km = CalculateUtils.calculateDistance(l) / 100;
            int [] count = CalculateUtils.calculateTypeCount(l);
            for (int j = 0; j < count.length; j++) {
                if (km != 0) {
                    result[j + 3] = String.valueOf(AmountCountUtil.div(count[j], km));
                }
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "平均每百公里告警量统计表", title, list);
    }

    /**
     * 速度段告警统计
     * <p>速度段平均每小时告警量=相应速度段内单个告警总量/驾驶时长</p>
     * @param p map
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getAlarmSpeed")
    public String getAlarmSpeed(@RequestParam() Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
        Map<Integer, double[]> m = CalculateUtils.calculateTypeCountBySpeed(l);
        double time = CalculateUtils.calculateTime(l);
        // 速度段平均每小时告警量=相应速度段内单个告警总量/驾驶时长
        for (int i = 0; i < 9; i++) {
            // 每个类型的全部速度表遍历
            for (int j = 0; j < 5; j++) {
                // 每个区间速度遍历
                if (0 != time) {
                    m.get(i)[j] = AmountCountUtil.div(m.get(i)[j], time);
                }
            }
        }
        return JsonResp.asData()
                .add("M1", m.get(0))
                .add("M2", m.get(1))
                .add("M3", m.get(2))
                .add("M4", m.get(3))
                .add("M5", m.get(4))
                .add("M6", m.get(5))
                .add("M7", m.get(6))
                .add("M8", m.get(7))
                .add("M9", m.get(8))
                .toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadAlarmSpeed")
    public void downloadAlarmSpeed(HttpServletResponse response, HttpServletRequest request,
                                   @RequestParam() Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"告警类型", "设备号", "开始时间", "结束时间",
                "<0, 20>", "<20, 40>", "<40, 60>", "<60, 80>", "<80, *>"};
        List<String[]> list = new ArrayList<String[]>(2);
        List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
        double time = CalculateUtils.calculateTime(l);
        Map<Integer, double[]> m = CalculateUtils.calculateTypeCountBySpeed(l);
        // 速度段平均每小时告警量=相应速度段内单个告警总量/驾驶时长
        for (int i = 0; i < 9; i++) {
            String [] result = new String [title.length];
            result[0] = MsgType.getNameByIndex(i);
            result[1] = p.get("deviceId").toString();
            result[2] = p.get("startDate").toString();
            result[3] = p.get("endDate").toString();
            // 每个类型的全部速度表遍历
            for (int j = 0; j < 5; j++) {
                // 每个区间速度遍历
                if (0 != time) {
                    result[j + 4] = String.valueOf(AmountCountUtil.div(m.get(i)[j], time));
                }
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "速度段-平均每小时告警量统计表", title, list);
    }

    /**
     * 时段告警统计(以每小时为准,多天的相应小时段合并计算)
     * <p>时段平均告警量=相应时间段内单个告警总量/驾驶时长</p>
     * @param p map
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getAlarmTime")
    public String getAlarmTime(@RequestParam() Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
        Map<Integer, double[]> m = CalculateUtils.calculateTypeCountByTime(l);
        double time = CalculateUtils.calculateTime(l);
        // 时段平均告警量=相应速度段内单个告警总量/驾驶时长
        for (int i = 0; i < 9; i++) {
            // 每个类型的全部时间表遍历
            for (int j = 0; j < 24; j++) {
                // 每个区间时间遍历
                if (0 != time) {
                    m.get(i)[j] = AmountCountUtil.div(m.get(i)[j], time);
                }
            }
        }
        return JsonResp.asData()
                .add("M1", m.get(0))
                .add("M2", m.get(1))
                .add("M3", m.get(2))
                .add("M4", m.get(3))
                .add("M5", m.get(4))
                .add("M6", m.get(5))
                .add("M7", m.get(6))
                .add("M8", m.get(7))
                .add("M9", m.get(8))
                .toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadAlarmTime")
    public void downloadAlarmTime(HttpServletResponse response, HttpServletRequest request,
                                  @RequestParam() Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"告警类型", "设备号", "开始时间", "结束时间",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
        List<String[]> list = new ArrayList<String[]>(2);
        List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
        Map<Integer, double[]> m = CalculateUtils.calculateTypeCountByTime(l);
        double time = CalculateUtils.calculateTime(l);
        // 时段平均告警量=相应速度段内单个告警总量/驾驶时长
        for (int i = 0; i < 9; i++) {
            String [] result = new String [title.length];
            result[0] = MsgType.getNameByIndex(i);
            result[1] = p.get("deviceId").toString();
            result[2] = p.get("startDate").toString();
            result[3] = p.get("endDate").toString();
            // 每个类型的全部时间表遍历
            for (int j = 0; j < 24; j++) {
                // 每个区间时间遍历
                if (0 != time) {
                    result[j + 4] = String.valueOf(AmountCountUtil.div(m.get(i)[j], time));
                }
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "时间段-平均每小时告警量统计表", title, list);
    }

    /**
     * 超速统计
     * <p>(限速警示)平均每小时告警量=相应速度段内(限速警示)告警总量/驾驶时长</p>
     * @param p map
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getAlarmLimitSpeed")
    public String getAlarmLimitSpeed(@RequestParam() Map<String, Object> p) {
        String [] str = p.get("deviceId").toString().split(",");
        List<Integer> deviceIds = new ArrayList<Integer>();
        for (String s : str) {
            deviceIds.add(Integer.valueOf(s));
        }
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        for (String s : str) {
            p.put("deviceId", s);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double [] m = CalculateUtils.calculateTypeCountByLimitSpeed(l);
            double time = CalculateUtils.calculateTime(l);
            // (限速警示)平均每小时告警量=相应速度段内(限速警示)告警总量/驾驶时长
            for (int i = 0; i < m.length; i++) {
                if (0 != time) {
                    m[i] = AmountCountUtil.div(m[i], time);
                }
            }
            map.put(s, m);
        }
        return JsonResp.asData().addAll(map).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadAlarmLimitSpeed")
    public void downloadAlarmLimitSpeed(HttpServletResponse response, HttpServletRequest request,
                                        @RequestParam() Map<String, Object> p) {
        String [] ds = p.get("deviceId").toString().split(",");
        List<Integer> deviceIds = new ArrayList<Integer>();
        for (String s : ds) {
            deviceIds.add(Integer.valueOf(s));
        }
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "5Km/h", "20Km/h", "30Km/h",
                "40Km/h", "50Km/h", "60Km/h", "70Km/h", "80Km/h", "90Km/h", "100Km/h", "120Km/h"};
        List<String[]> list = new ArrayList<String[]>(ds.length + 1);
        for (String d : ds) {
            p.put("deviceId", d);
            String [] result = new String [title.length];
            result[0] = d;
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double [] m = CalculateUtils.calculateTypeCountByLimitSpeed(l);
            double time = CalculateUtils.calculateTime(l);
            // (限速警示)平均每小时告警量=相应速度段内(限速警示)告警总量/驾驶时长
            for (int i = 0; i < m.length; i++) {
                if (0 != time) {
                    result[i + 3] = String.valueOf(AmountCountUtil.div(m[i], time));
                }
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "限速-平均每小时告警量统计表", title, list);
    }

    /**
     * 平均每小时告警量统计
     * <p>平均每小时告警量=单个告警总量/驾驶时长</p>
     * @param p map
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getAlarmTeam")
    public String getAlarmTeam(@RequestParam() Map<String, Object> p) {
        String [] ss = p.get("team").toString().split(",");
        String [] dd = p.get("deviceId").toString().split(",");
        // 验证设备号是否属于当前所选团队
        if (!validation(ss, dd)) {
            return JsonResp.asEmpty().error("当前设备号不属于当前团队,请重新选择!").toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        // 多个设备的告警计算
        for (String s : dd) {
            p.put("deviceId", s);
            calculateTypeAndDeviceId(map, p);
        }
        int length = 9;
        // 团队时间的计算
        double time = 0;
        int [] d = new int[length];
        for (String s : ss) {
            p.put("deviceId", s);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            time += CalculateUtils.calculateTime(l);
            // 计算每个类型对应的告警总量
            for (DeviceGpsInfos g : l) {
                int index = MsgType.getIndex(g.getMsgType().intValue());
                if (index == -1) {
                    continue;
                }
                if (index < length) {
                    d[index]++;
                }
            }
        }
        // 平均每小时告警量=单个告警总量/驾驶时长
        double [] r = CalculateUtils.calculateTypeCountByParam(d, time);
        map.put(p.get("teamName").toString(), r);
        return JsonResp.asData().addAll(map).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadAlarmTeam")
    public void downloadAlarmTeam(HttpServletResponse response, HttpServletRequest request,
                                  @RequestParam() Map<String, Object> p) {
        String [] ss = p.get("team").toString().split(",");
        String [] dd = p.get("deviceId").toString().split(",");
        // 验证设备号是否属于当前所选团队
        if (!validation(ss, dd)) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "左车道偏离", "右车道偏离",
                "车距监测", "限速警示", "城市前碰撞", "车辆前部碰撞", "急加速", "急减速", "行人前部碰撞"};
        String [] ds = p.get("deviceId").toString().split(",");
        List<String[]> list = new ArrayList<String[]>(ds.length + 1);
        int length = 9;
        // 团队时间的计算
        double time = 0;
        int [] count = new int[length];
        for (String s : ss) {
            p.put("deviceId", s);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            time += CalculateUtils.calculateTime(l);
            // 计算每个类型对应的告警总量
            for (DeviceGpsInfos g : l) {
                int index = MsgType.getIndex(g.getMsgType().intValue());
                if (index == -1) {
                    continue;
                }
                if (index < length) {
                    count[index]++;
                }
            }
        }
        // 团队的记录
        String [] result = new String [title.length];
        result[0] = "平均值";
        result[1] = p.get("startDate").toString();
        result[2] = p.get("endDate").toString();
        for (int i = 0; i < count.length; i++) {
            if (time != 0) {
                result[i + 3] = String.valueOf(AmountCountUtil.div(count[i], time));
            }
        }
        list.add(result);
        for (String d : ds) {
            result = new String [title.length];
            result[0] = d;
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            p.put("deviceId", d);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            time = CalculateUtils.calculateTime(l);
            count = CalculateUtils.calculateTypeCount(l);
            for (int i = 0; i < count.length; i++) {
                if (time != 0) {
                    result[i + 3] = String.valueOf(AmountCountUtil.div(count[i], time));
                }
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, p.get("teamName").toString() + "平均每小时告警量统计表", title, list);
    }

    /**
     * 团队平均每公里告警量统计
     * <p>平均每小时告警量=单个告警总量/驾驶时长</p>
     * @param p map
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getAlarmKmTeam")
    public String getAlarmKmTeam(@RequestParam() Map<String, Object> p) {
        String [] ss = p.get("team").toString().split(",");
        String [] dd = p.get("deviceId").toString().split(",");
        // 验证设备号是否属于当前所选团队
        if (!validation(ss, dd)) {
            return JsonResp.asEmpty().error("当前设备号不属于当前团队,请重新选择!").toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        int length = 9;
        // 团队时间的计算
        double sumKm = 0;
        int [] d = new int[length];
        for (String s : ss) {
            p.put("deviceId", s);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double km = CalculateUtils.calculateDistance(l) / 100;
            sumKm += km;
            int [] count = CalculateUtils.calculateTypeCount(l);
            for (int i = 0; i < length; i++) {
                d[i] += count[i];
            }
            double [] r = CalculateUtils.calculateTypeCountByParam(count, km);
            map.put(s, r);
        }
        // 平均每小时告警量=单个告警总量/驾驶时长
        double [] r = CalculateUtils.calculateTypeCountByParam(d, sumKm);
        map.put(p.get("teamName").toString(), r);
        return JsonResp.asData().addAll(map).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadAlarmKmTeam")
    public void downloadAlarmKmTeam(HttpServletResponse response, HttpServletRequest request,
                                  @RequestParam() Map<String, Object> p) {
        String [] ss = p.get("team").toString().split(",");
        String [] dd = p.get("deviceId").toString().split(",");
        // 验证设备号是否属于当前所选团队
        if (!validation(ss, dd)) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "左车道偏离", "右车道偏离",
                "车距监测", "限速警示", "城市前碰撞", "车辆前部碰撞", "急加速", "急减速", "行人前部碰撞"};
        String [] ds = p.get("deviceId").toString().split(",");
        List<String[]> list = new ArrayList<String[]>(ds.length + 1);
        int length = 9;
        // 团队时间的计算
        double sumKm = 0;
        int [] d = new int[length];
        for (String s : ss) {
            String [] result = new String [title.length];
            result[0] = s;
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            p.put("deviceId", s);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double km = CalculateUtils.calculateDistance(l) / 100;
            sumKm += km;
            int [] count = CalculateUtils.calculateTypeCount(l);
            for (int i = 0; i < length; i++) {
                d[i] += count[i];
            }
            double [] r = CalculateUtils.calculateTypeCountByParam(count, km);
            for (int i = 0; i < r.length; i++) {
                result[i + 3] = String.valueOf(r[i]);
            }
            list.add(result);
        }
        String [] result = new String [title.length];
        // 平均每小时告警量=单个告警总量/驾驶时长
        double [] r = CalculateUtils.calculateTypeCountByParam(d, sumKm);
        result[0] = p.get("teamName").toString();
        result[1] = p.get("startDate").toString();
        result[2] = p.get("endDate").toString();
        for (int i = 0; i < r.length; i++) {
            result[i + 3] = String.valueOf(r[i]);
        }
        list.add(result);
        CsvUtil.writeCsvFile(response, request, p.get("teamName").toString() + "平均每小时告警量统计表", title, list);
    }

    /**
     * 验证当前设备是否属于当前团队
     * @param ss 当前团队
     * @param dd 当前设备数组
     * @return true:属于，false:不属于
     */
    private boolean validation(String [] ss, String [] dd) {
        for (String d : dd) {
            boolean flag = false;
            for (String s : ss) {
                if (d.equals(s)) {
                    // 当前设备属于当前团队
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    private void calculateTypeAndDeviceId(Map<String, Object> map, Map<String, Object> p) {
        List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
        double time = CalculateUtils.calculateTime(l);
        int [] d = CalculateUtils.calculateTypeCount(l);
        double [] r = CalculateUtils.calculateTypeCountByParam(d, time);
        map.put(p.get("deviceId").toString(), r);
    }

    /**
     * 平均每小时告警量统计
     * <p>平均每小时告警量=单个告警总量/驾驶时长</p>
     * @param p map
     * @return json
     */
    @ResponseBody
    @RequestMapping(value = "/getTotalAlarm")
    public String getTotalAlarm(@RequestParam Map<String, Object> p) {
        String [] ds = p.get("deviceId").toString().split(",");
        List<Integer> deviceIds = new ArrayList<Integer>();
        for (String s : ds) {
            deviceIds.add(Integer.valueOf(s));
        }
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        List<DeviceGpsInfosCount> l = deviceGpsInfosCountService.findTotalAlarm(p);
        Map<String, Object> map = new HashMap<String, Object>();
        for (DeviceGpsInfosCount c : l) {
            int [] d = new int[9];
            d[0] = c.getLeftLaneDeviate();
            d[1] = c.getRightLaneDeviate();
            d[2] = c.getCarDistanceMonitor();
            d[3] = c.getLimitSpeedAlarm();
            d[4] = c.getCityFrontCollide();
            d[5] = c.getCarFrontCollide();
            d[6] = c.getSpeedUp();
            d[7] = c.getSpeedDown();
            d[8] = c.getPersonFrontCollide();
            map.put(c.getDeviceId().toString(), d);
        }
        return JsonResp.asData().addAll(map).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadTotalAlarm")
    public void downloadTotalAlarm(HttpServletResponse response, HttpServletRequest request,
                             @RequestParam Map<String, Object> p) {
        String [] ds = p.get("deviceId").toString().split(",");
        List<Integer> deviceIds = new ArrayList<Integer>();
        for (String s : ds) {
            deviceIds.add(Integer.valueOf(s));
        }
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        List<DeviceGpsInfosCount> l = deviceGpsInfosCountService.findTotalAlarm(p);
        String[] title = new String [] {"设备号", "月份", "左车道偏离", "右车道偏离",
                "车距监测", "限速警示", "城市前碰撞", "车辆前部碰撞", "急加速", "急减速", "行人前部碰撞"};
        List<String[]> list = new ArrayList<String[]>();
        for (DeviceGpsInfosCount c : l) {
            String [] result = new String [title.length];
            result[0] = c.getDeviceId().toString();
            result[1] = p.get("date").toString();
            result[2] = c.getLeftLaneDeviate().toString();
            result[3] = c.getRightLaneDeviate().toString();
            result[4] = c.getCarDistanceMonitor().toString();
            result[5] = c.getLimitSpeedAlarm().toString();
            result[6] = c.getCityFrontCollide().toString();
            result[7] = c.getCarFrontCollide().toString();
            result[8] = c.getSpeedUp().toString();
            result[9] = c.getSpeedDown().toString();
            result[10] = c.getPersonFrontCollide().toString();
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "限速-平均每小时告警量统计表", title, list);
    }


    @ResponseBody
    @RequestMapping(value = "/getOverSpeedTime")
    public String getOverSpeedTime(@RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        String [] types = p.get("types").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("types", types);
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            map.put(ds[i], CalculateUtils.calculateOverSpeedTime(l));
        }
        return JsonResp.asData().addAll(map).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadOverSpeedTime")
    public void downloadOverSpeedTime(HttpServletResponse response, HttpServletRequest request,
                                   @RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "<0, 10>秒", "<10, 20>秒",
                "<20, 30>秒", "<30, 60>秒", "<1, 5>分钟", "<5, ~>分钟"};
        List<String[]> list = new ArrayList<String[]>();
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        String [] types = p.get("types").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("types", types);
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTypes(p);
            int [] arrays = CalculateUtils.calculateOverSpeedTime(l);
            String [] result = new String [title.length];
            result[0] = p.get("deviceId").toString();
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            for (int j = 0; j < arrays.length; j++) {
                result[3 + j] = String.valueOf(arrays[j]);
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "超速时长告警量统计表", title, list);
    }

    @ResponseBody
    @RequestMapping(value = "/getOverSpeedTimeMaxValue")
    public String getOverSpeedTimeMaxValue(@RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        String [] types = p.get("types").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("types", types);
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            map.put(ds[i], CalculateUtils.calculateOverSpeedTimeMaxValue(l));
        }
        return JsonResp.asData().addAll(map).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadOverSpeedTimeMaxValue")
    public void downloadOverSpeedTimeMaxValue(HttpServletResponse response, HttpServletRequest request,
                                      @RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "<0, 10>", "<10, 20>",
                "<20, 30>", "<30, 40>", "<40, ~>"};
        List<String[]> list = new ArrayList<String[]>();
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        String [] types = p.get("types").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("types", types);
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTypes(p);
            int [] arrays = CalculateUtils.calculateOverSpeedTimeMaxValue(l);
            String [] result = new String [title.length];
            result[0] = p.get("deviceId").toString();
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            for (int j = 0; j < arrays.length; j++) {
                result[3 + j] = String.valueOf(arrays[j]);
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "最大超速值告警量统计表", title, list);
    }

    @ResponseBody
    @RequestMapping(value = "/getOverSpeedTimeLimitValue")
    public String getOverSpeedTimeLimitValue(@RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        String [] types = p.get("types").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("types", types);
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            map.put(ds[i], CalculateUtils.calculateOverSpeedTimeLimitValue(l));
        }
        return JsonResp.asData().addAll(map).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadOverSpeedTimeLimitValue")
    public void downloadOverSpeedTimeLimitValue(HttpServletResponse response, HttpServletRequest request,
                                              @RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "<0, 5>", "<5, 10>",
                "<10, 15>", "<15, 20>", "<20, 30>", "<30, 40>", "<40, 50>", "<50, 60>", "<60, 70>",
                "<70, 80>", "<80, 90>", "<90, 100>", "<100, 110>", "<110, 120>", "<120, ~>"};
        List<String[]> list = new ArrayList<String[]>();
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        String [] types = p.get("types").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("types", types);
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTypes(p);
            int [] arrays = CalculateUtils.calculateOverSpeedTimeLimitValue(l);
            String [] result = new String [title.length];
            result[0] = p.get("deviceId").toString();
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            for (int j = 0; j < arrays.length; j++) {
                result[3 + j] = String.valueOf(arrays[j]);
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "不同限速值下告警量统计表", title, list);
    }

    @ResponseBody
    @RequestMapping(value = "/getOverSpeedTimeCount")
    public String getOverSpeedTimeCount(@RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        DecimalFormat df = new DecimalFormat("######0.00");
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double time = CalculateUtils.calculateTime(l);
            int [] arrays = CalculateUtils.calculateOverSpeedTimeLimitValue(l);
            String [] results = new String[arrays.length];
            for (int j = 0; j < arrays.length; j++) {
                if (time != 0) {
                    results[j] = df.format(arrays[j] / time);
                }
            }
            map.put(ds[i], results);
        }
        return JsonResp.asData().addAll(map).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadOverSpeedTimeCount")
    public void downloadOverSpeedTimeCount(HttpServletResponse response, HttpServletRequest request,
                                                @RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "<0, 5>", "<5, 10>",
                "<10, 15>", "<15, 20>", "<20, 30>", "<30, 40>", "<40, 50>", "<50, 60>", "<60, 70>",
                "<70, 80>", "<80, 90>", "<90, 100>", "<100, 110>", "<110, 120>", "<120, ~>"};
        List<String[]> list = new ArrayList<String[]>();
        DecimalFormat df = new DecimalFormat("######0.00");
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTypes(p);
            double time = CalculateUtils.calculateTime(l);
            int [] arrays = CalculateUtils.calculateOverSpeedTimeLimitValue(l);
            String [] result = new String [title.length];
            result[0] = p.get("deviceId").toString();
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            for (int j = 0; j < arrays.length; j++) {
                result[3 + j] = df.format(arrays[j] / time);
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "平均超速次数告警量统计表", title, list);
    }

    @ResponseBody
    @RequestMapping(value = "/getPersonCollideSpeed")
    public String getPersonCollideSpeed(@RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        DecimalFormat df = new DecimalFormat("######0.00");
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double time = CalculateUtils.calculateTime(l);
            int [] arrays = CalculateUtils.calculateCollideSpeedValue(l, MsgType.PERSON_FRONT_COLLIDE.getMsgType());
            String [] results = new String[arrays.length];
            for (int j = 0; j < arrays.length; j++) {
                if (time != 0) {
                    results[j] = df.format(arrays[j] / time);
                }
            }
            map.put(ds[i], results);
        }
        return JsonResp.asData().addAll(map).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadPersonCollideSpeed")
    public void downloadPersonCollideSpeed(HttpServletResponse response, HttpServletRequest request,
                                           @RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "<0,20>", "<20,40>",
                "<40,60>", "<60,80>", "<80,120>", "<120,*>"};
        List<String[]> list = new ArrayList<String[]>();
        DecimalFormat df = new DecimalFormat("######0.00");
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTypes(p);
            double time = CalculateUtils.calculateTime(l);
            int [] arrays = CalculateUtils.calculateCollideSpeedValue(l, MsgType.PERSON_FRONT_COLLIDE.getMsgType());
            String [] result = new String [title.length];
            result[0] = p.get("deviceId").toString();
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            for (int j = 0; j < arrays.length; j++) {
                result[3 + j] = df.format(arrays[j] / time);
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "行人速度段-平均每小时告警量统计表", title, list);
    }

    @ResponseBody
    @RequestMapping(value = "/getCarCollideSpeed")
    public String getCarCollideSpeed(@RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return JsonResp.asEmpty().error(msg).toJson();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        DecimalFormat df = new DecimalFormat("######0.00");
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTime(p);
            double time = CalculateUtils.calculateTime(l);
            int [] arrays = CalculateUtils.calculateCollideSpeedValue(l, MsgType.CAR_FRONT_COLLIDE.getMsgType());
            String [] results = new String[arrays.length];
            for (int j = 0; j < arrays.length; j++) {
                if (time != 0) {
                    results[j] = df.format(arrays[j] / time);
                }
            }
            map.put(ds[i], results);
        }
        return JsonResp.asData().addAll(map).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/downloadCarCollideSpeed")
    public void downloadCarCollideSpeed(HttpServletResponse response, HttpServletRequest request,
                                           @RequestParam Map<String, Object> p) {
        List<Integer> deviceIds = new ArrayList<Integer>();
        deviceIds.add(Integer.valueOf(p.get("deviceId").toString()));
        String msg = userDeviceService.validation(deviceIds);
        if (msg != null) {
            return;
        }
        String[] title = new String [] {"设备号", "开始时间", "结束时间", "<0,20>", "<20,40>",
                "<40,60>", "<60,80>", "<80,120>", "<120,*>"};
        List<String[]> list = new ArrayList<String[]>();
        DecimalFormat df = new DecimalFormat("######0.00");
        String [] ds = p.get("dates").toString().split(",");
        String [] startDates = p.get("startDates").toString().split(",");
        String [] endDates = p.get("endDates").toString().split(",");
        for (int i = 0; i < ds.length; i++) {
            p.put("deviceId", p.get("deviceId"));
            p.put("startDate", startDates[i]);
            p.put("endDate", endDates[i]);
            List<DeviceGpsInfos> l = deviceGpsInfosService.findByDeviceIdAndTypes(p);
            double time = CalculateUtils.calculateTime(l);
            int [] arrays = CalculateUtils.calculateCollideSpeedValue(l, MsgType.CAR_FRONT_COLLIDE.getMsgType());
            String [] result = new String [title.length];
            result[0] = p.get("deviceId").toString();
            result[1] = p.get("startDate").toString();
            result[2] = p.get("endDate").toString();
            for (int j = 0; j < arrays.length; j++) {
                result[3 + j] = df.format(arrays[j] / time);
            }
            list.add(result);
        }
        CsvUtil.writeCsvFile(response, request, "车辆速度段-平均每小时告警量统计表", title, list);
    }
}
