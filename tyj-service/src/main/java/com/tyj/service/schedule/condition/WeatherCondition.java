/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule.condition;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.common.util.HttpClientUtils;
import cn.vansky.framework.common.util.JsonUtil;
import com.tyj.dao.demo.vo.Constant;
import com.tyj.dao.demo.cityWeatherBase.bo.CityWeatherBase;
import com.tyj.dao.demo.old.bo.FactorWarning;
import com.tyj.dao.demo.vo.CityLocationVo;
import com.tyj.dao.demo.weather.bo.WeatherHistory;
import com.tyj.service.demo.weather.service.WeatherHistoryService;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 天气条件
 * Author: CK
 * Date: 2016/2/28
 */
public class WeatherCondition extends AbstractCondition {

    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;

    private WeatherHistoryService weatherHistoryService;

    public WeatherCondition(Object obj, WeatherHistoryService weatherHistoryService) {
        super(obj, FactorWarning.WEATHER);
        this.weatherHistoryService = weatherHistoryService;
    }

    @Override
    public double calculateExtendScore() {
        // coordtype 坐标的类型,目前支持的坐标类型包括:bd09ll(百度经纬度坐标)、bd09mc(百度米制坐标)、gcj02ll(国测局经纬度坐标)、wgs84ll(GPS经纬度)
        // location 根据经纬度坐标获取地址
        // pois 是否显示指定位置周边的poi，0为不显示，1为显示。当值为1时，显示周边100米内的poi
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ak", "lTz3Ctx4eC9QAXl7ZjoyzyWb");
        params.put("location", latitude + "," + longitude);
        params.put("output", "json");
        params.put("pois", 0);
        String s = HttpClientUtils.execute(params, "http://api.map.baidu.com/geocoder/v2/");
        CityLocationVo vo = JsonUtil.fromJson(s, CityLocationVo.class);
        String frontDate = DateUtil.getDateStr(new Date(), DateUtil.yyyy_MM_dd, Calendar.DATE, -1);
        // 获取城市信息
        if (null != vo.getResult() && null != vo.getResult().getAddressComponent()
                && null != vo.getResult().getAddressComponent().getCity()) {
            String city = vo.getResult().getAddressComponent().getCity();
            for (Map.Entry<String, CityWeatherBase> m : Constant.CITY_BASE.entrySet()) {
                // 不能全名匹配
                if (city.contains(m.getKey())) {
                    // 查询当前城市对应的前一天天气信息
                    CityWeatherBase c = m.getValue();
                    WeatherHistory history = weatherHistoryService.findByTimeAndAreaId(frontDate, c.getAreaId());
                    // 获取前一天天气,计算分数
                    return 0;
                }
            }
        }
        return 0;
    }
}
