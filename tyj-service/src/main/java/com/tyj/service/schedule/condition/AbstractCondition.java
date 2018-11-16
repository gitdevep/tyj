/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule.condition;

import cn.vansky.framework.common.util.ReflectUtil;
import com.tyj.dao.demo.vo.Constant;
import com.tyj.dao.demo.deviceGpsInfos.bo.ConditionBaseScore;
import com.tyj.dao.demo.old.bo.FactorWarning;
import com.tyj.dao.jhpt.deviceGpsInfos.bo.MsgType;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/2/28
 */
public abstract class AbstractCondition implements Condition {
    /**
     * 条件类型
     */
    protected Integer conditionType;
    /**
     * 条件基础分数
     */
    protected ConditionBaseScore base;
    /**
     * 类型基础分数
     */
    protected double baseScore;
    /**
     * 当前对应的属性名称
     */
    protected String currentPropertyName;
    /**
     * 当前时间
     */
    protected Date eventTime;
    /**
     * 当前类型
     */
    protected Byte msgType;
    /**
     * 设备ID
     */
    protected Integer deviceId;

    public AbstractCondition(Object obj, Integer conditionType) {
        this.conditionType = conditionType;
        BeanUtils.copyProperties(obj, this);
    }

    public double calculateScore() {
        // 计算基础分数
        getTypeScoreBaseByCondition(conditionType);
        // 当前对应的属性名称
        currentPropertyName = MsgType.getProperty(msgType);
        baseScore = getValue(base);
        double extendScore = calculateExtendScore();
        double result = baseScore + extendScore;
        return result;
    }

    public void getTypeScoreBaseByCondition(Integer type) {
        base = Constant.CONDITION_BASE_SCORE_MAP.get(type);
    }

    /**
     * 子类计算扩展分数
     * @return 扩展分数
     */
    public abstract double calculateExtendScore();

    /**
     * 扩展类型的分数类
     * @param id id
     * @return 扩展类型的分数类
     */
    protected FactorWarning get(int id) {
        return Constant.FACTOR_WARNING.get(conditionType).get(id);
    }

    /**
     * 反射获取对象字段的值
     * @param obj 对象
     * @return 值
     */
    protected double getValue(Object obj) {
        if (obj != null) {
            Object o = ReflectUtil.getValueByFieldName(obj, currentPropertyName);
            if (o != null) {
                return Double.valueOf((Integer) o);
            }
        }
        return 0;
    }

    public void setMsgType(Byte msgType) {
        this.msgType = msgType;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
}
