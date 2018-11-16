/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.schedule;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.common.util.HttpClientUtils;
import com.tyj.dao.demo.vo.Constant;
import com.tyj.dao.demo.cityWeatherBase.bo.CityWeatherBase;
import com.tyj.dao.demo.weather.bo.WeatherHistory;
import com.tyj.service.demo.weather.service.WeatherHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 历史天气定时保存
 * Author: CK
 * Date: 2016/3/1
 */
@Service("weatherHistorySchedule")
public class WeatherHistorySchedule {

    private static final Logger logger = LoggerFactory.getLogger(ExportDataSchedule.class);

    static Map<String, Object> params = new HashMap<String, Object>();
    static {
        params.put("app", "weather.today");
        params.put("appkey", "18125");
        params.put("sign", "fcf87168f2b39709fb1259048886fea4");
        params.put("format", "json");
    }

    static final String data = "http://api.k780.com:88/";

    @Resource(name = "weatherHistoryService")
    WeatherHistoryService weatherHistoryService;

    /**
     * 定时任务获取当天的天气情况
     */
//    @Scheduled(cron = "0 0 1 * * ?")
    public void export() {
        Date date = new Date();
        String frontDate = DateUtil.format(DateUtil.yyyy_MM_dd, date);
        Map<String, CityWeatherBase> cityMap = Constant.CITY_BASE;
        for (Map.Entry<String, CityWeatherBase> city : cityMap.entrySet()) {
            params.put("weaid", city.getValue().getWeaId());
            params.put("date", frontDate);
            String json = HttpClientUtils.execute(params, data);
            WeatherHistory weatherHistory = new WeatherHistory();
            weatherHistory.setAreaId(city.getKey());
            weatherHistory.setHistoryTime(date);
            weatherHistory.setJson(json);
            weatherHistoryService.saveEntitySelective(weatherHistory);
        }
    }
}