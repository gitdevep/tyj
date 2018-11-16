/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.vo;

import com.tyj.dao.demo.cityWeatherBase.bo.CityWeatherBase;
import com.tyj.dao.demo.deviceGpsInfos.bo.ConditionBaseScore;
import com.tyj.dao.demo.old.bo.FactorWarning;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/2/29
 */
public class Constant {
    /**
     * 基础条件分数
     */
    public static final Map<Integer, ConditionBaseScore> CONDITION_BASE_SCORE_MAP = new HashMap<Integer, ConditionBaseScore>();

    /**
     * 数值因素分数
     */
    public static final Map<Integer, Map<Integer, FactorWarning>> FACTOR_WARNING = new HashMap<Integer, Map<Integer, FactorWarning>>();

    /**
     * 基础城市信息
     */
    public static final Map<String, CityWeatherBase> CITY_BASE = new HashMap<String, CityWeatherBase>();
}
