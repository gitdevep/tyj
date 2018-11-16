/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.common.util.MapUtils;
import cn.vansky.framework.common.util.ReflectUtil;
import com.tyj.dao.demo.deviceGpsInfos.bo.DeviceGpsInfos;
import com.tyj.dao.demo.general.bo.DeviceInfo;
import com.tyj.dao.demo.old.bo.DrivingEvaluation;
import com.tyj.dao.demo.old.bo.SeqWarning;
import com.tyj.dao.demo.old.bo.SpeedFactor;
import com.tyj.dao.demo.old.bo.TimeSlotFatigue;
import com.tyj.dao.demo.old.bo.TimeSpanFatigue;
import com.tyj.dao.demo.old.bo.VisibilityFactor;
import com.tyj.dao.demo.vo.BaseScore;
import com.tyj.dao.demo.vo.FactorAdjustor;
import com.tyj.dao.demo.vo.MsgTypeOld;
import com.tyj.service.demo.deviceGpsInfos.service.DeviceGpsInfosService;
import com.tyj.service.demo.old.DrivingEvaluationService;
import com.tyj.service.demo.old.SeqWarningService;
import com.tyj.service.demo.old.SpeedFactorService;
import com.tyj.service.demo.old.TimeSlotFatigueService;
import com.tyj.service.demo.old.TimeSpanFatigueService;
import com.tyj.service.demo.old.VisibilityFactorService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/4/17
 */
@Service("exportOldDataSchedule")
public class ExportOldDataSchedule implements InitializingBean {
    public static final List<SpeedFactor> SPEED_FACTOR = new ArrayList<SpeedFactor>();

    public static final List<TimeSlotFatigue> TIME_SLOT_FATIGUES = new ArrayList<TimeSlotFatigue>();

    public static final List<TimeSpanFatigue> TIME_SPAN_FATIGUES = new ArrayList<TimeSpanFatigue>();

    public static final List<VisibilityFactor> VISIBILITY_FACTORS = new ArrayList<VisibilityFactor>();

    public static final Map<Integer, SeqWarning> SEQ_WARNING_MAP = new HashMap<Integer, SeqWarning>();

    @Resource(name = "deviceGpsInfosService")
    DeviceGpsInfosService deviceGpsInfosService;

    @Resource(name = "drivingEvaluationService")
    DrivingEvaluationService drivingEvaluationService;

    @Resource(name = "speedFactorService")
    SpeedFactorService speedFactorService;

    @Resource(name = "timeSlotFatigueService")
    TimeSlotFatigueService timeSlotFatigueService;

    @Resource(name = "timeSpanFatigueService")
    TimeSpanFatigueService timeSpanFatigueService;

    @Resource(name = "visibilityFactorService")
    VisibilityFactorService visibilityFactorService;

    @Resource(name = "seqWarningService")
    SeqWarningService seqWarningService;

    public void export(String day, List<DeviceInfo> ds) {
        for (DeviceInfo deviceInfo : ds) {
            export(day, deviceInfo.getDeviceId() + "");
        }
    }

    public void export(String day, String... ds) {
        Date date = DateUtil.parse(DateUtil.yyyy_MM_dd, day);
        Map<String, Object> p = MapUtils.<String, Object>build().put("startDate", day)
                .put("endDate", DateUtil.getDateStr(date, DateUtil.yyyy_MM_dd, Calendar.DATE, 1)).get();
        int i = 0;
        int COMMIT = 20;
        List<DrivingEvaluation> l = new ArrayList<DrivingEvaluation>(COMMIT);
        for (String deviceId : ds) {
            Integer d = Integer.valueOf(deviceId);
            ++i;
            p.put("deviceId", d);
            calculateScore(deviceGpsInfosService.findByDeviceIdAndTime(p), date, d, l);
            if (i % COMMIT == 0) {
                drivingEvaluationService.saveBatch(l);
                l = new ArrayList<DrivingEvaluation>(COMMIT);
            }
        }
        if (!l.isEmpty()) {
            drivingEvaluationService.saveBatch(l);
        }
    }

    private void calculateScore(List<DeviceGpsInfos> dgs, Date date, Integer deviceId, List<DrivingEvaluation> l) {
        int sum = 0;
        DeviceGpsInfos front = null;
        for (DeviceGpsInfos g : dgs) {
            int type = g.getMsgType().intValue();
            if (type == 1 || type == 2 || type == 3 || type == 4 || type == 5 || type == 6) {
                // 基础分
                sum += calculateBaseScore(g, front);
                // 速度分
                sum += calculateSpeedFactor(g);
                // 疲劳度
                sum += calculateTimeSlotFatigueFactor(g);
                // 驾驶时长
                sum += calculateTimeSpanFatigueFactor(g, dgs.get(0));
                // 能见度
                sum += calculateVisibilityFactor(g);
                front = g;
            }
        }
        DrivingEvaluation de = new DrivingEvaluation();
        de.setEvaluateTime(date);
        de.setDeviceId(deviceId);
        int driveTime = (int) CalculateUtils.calculateMinute(dgs);
        de.setDrivingTime(driveTime);
        de.setSum(sum);
        double score = 0;
        if (driveTime != 0) {
            score = sum / driveTime;
            score = 31 * Math.atan((31 - 0.9 * score) / 15) + 65.27;
        }
        de.setScores(score);
        l.add(de);
    }

    private int calculateBaseScore(DeviceGpsInfos g, DeviceGpsInfos front) {
        if (front == null ||
                DateUtil.getBetweenDiff(g.getEventTime(), front.getEventTime(), DateUtil.SECOND_TIME) > FactorAdjustor.seq_warning_adjustor.getDiff()) {
            return BaseScore.getScore((int) g.getMsgType()) * FactorAdjustor.seq_warning_adjustor.getDiff();
        } else {
            SeqWarning o = SEQ_WARNING_MAP.get((int) front.getMsgType());
            return calculate(g, o, FactorAdjustor.seq_warning_adjustor.getDiff());
        }
    }

    private int calculateSpeedFactor(DeviceGpsInfos g) {
        for (SpeedFactor o : SPEED_FACTOR) {
            if (g.getSpeed() >= o.getRangeStart() && g.getSpeed() < o.getRangeEnd()) {
                return calculate(g, o, FactorAdjustor.speed_adjustor.getDiff());
            }
        }
        return 0;
    }

    private int calculateTimeSlotFatigueFactor(DeviceGpsInfos g) {
        for (TimeSlotFatigue o : TIME_SLOT_FATIGUES) {
            String tmp = DateUtil.format(DateUtil.HH_mm_ss, g.getEventTime());
            if (tmp.compareTo(o.getRangeStartStr()) >= 0 && tmp.compareTo(o.getRangeEndStr()) < 0) {
                return calculate(g, o, FactorAdjustor.time_slot_fatigue_adjustor.getDiff());
            }
        }
        return 0;
    }

    private int calculateTimeSpanFatigueFactor(DeviceGpsInfos g, DeviceGpsInfos start) {
        for (TimeSpanFatigue o : TIME_SPAN_FATIGUES) {
            int tmp = (int) DateUtil.getBetweenDiff(start.getEventTime(), g.getEventTime(), DateUtil.HOUR_TIME);
            if (tmp == o.getDrivingSpan()) {
                return calculate(g, o, FactorAdjustor.time_span_fatigure_adjustor.getDiff());
            }
        }
        return 0;
    }

    private int calculateVisibilityFactor(DeviceGpsInfos g) {
        for (VisibilityFactor o : VISIBILITY_FACTORS) {
            String tmp = DateUtil.format(DateUtil.HH_mm_ss, g.getEventTime());
            if (tmp.compareTo(o.getRangeStartStr()) >= 0 && tmp.compareTo(o.getRangeEndStr()) < 0) {
                return calculate(g, o, FactorAdjustor.visibility_adjustor.getDiff());
            }
        }
        return 0;
    }

    private int calculate(DeviceGpsInfos g, Object o, int diff) {
        Object t = ReflectUtil.getValueByFieldName(o, MsgTypeOld.getProperty((int) g.getMsgType()));
        return Integer.parseInt(t.toString()) * diff;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SPEED_FACTOR.addAll(speedFactorService.findAll());
        List<TimeSlotFatigue> timeSlotFatigues = timeSlotFatigueService.findAll();
        for (TimeSlotFatigue timeSlotFatigue : timeSlotFatigues) {
            timeSlotFatigue.setRangeStartStr();
            timeSlotFatigue.setRangeEndStr();
        }
        TIME_SLOT_FATIGUES.addAll(timeSlotFatigues);
        TIME_SPAN_FATIGUES.addAll(timeSpanFatigueService.findAll());
        List<VisibilityFactor> visibilityFactors = visibilityFactorService.findAll();
        for (VisibilityFactor visibilityFactor : visibilityFactors) {
            visibilityFactor.setRangeStartStr();
            visibilityFactor.setRangeEndStr();
        }
        VISIBILITY_FACTORS.addAll(visibilityFactors);

        List<SeqWarning> seqWarnings = seqWarningService.findAll();
        for (SeqWarning seqWarning : seqWarnings) {
            SEQ_WARNING_MAP.put(seqWarning.getId(), seqWarning);
        }
    }
}
