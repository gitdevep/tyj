package com.tyj.service.schedule;

import cn.vansky.framework.common.util.HttpClientUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class WeatherHistoryScheduleTest {

    @Test
    public void testExport() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app", "weather.today");
        params.put("appkey", "18125");
        params.put("sign", "fcf87168f2b39709fb1259048886fea4");
        params.put("format", "json");
        params.put("weaid", 1);
        params.put("date", "2016-04-28");
        String json = HttpClientUtils.execute(params, "http://api.k780.com:88/");
        System.out.println(json);
    }
}