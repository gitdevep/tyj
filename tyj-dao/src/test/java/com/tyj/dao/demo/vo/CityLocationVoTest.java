/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.vo;

import cn.vansky.framework.common.util.HttpClientUtils;
import cn.vansky.framework.common.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

public class CityLocationVoTest {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ak", "lTz3Ctx4eC9QAXl7ZjoyzyWb");
        params.put("location", "40.037948,116.2712668");
        params.put("output", "json");
        params.put("pois", 0);
        String s = HttpClientUtils.execute(params, "http://api.map.baidu.com/geocoder/v2/");
        CityLocationVo vo = JsonUtil.fromJson(s, CityLocationVo.class);
        System.out.println(vo.getResult().getAddressComponent().getCity());
    }
}