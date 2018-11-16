/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.common.util.BaseConfig;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/5/22
 */
public class SystemConfig {

    private static BaseConfig config = new BaseConfig("system-config.properties");

    public static int getInt(String key) {
        return config.getInt(key);
    }

    public static String getStr(String key) {
        return config.getString(key);
    }

    public static Boolean getBoolean(String key) {
        return config.getBoolean(key);
    }
}
