/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.common.util.MapUtils;
import cn.vansky.framework.core.kv.dao.KvDao;
import cn.vansky.framework.core.kv.handler.KvHandler;
import cn.vansky.framework.core.kv.handler.SimpleKvHandler;
import cn.vansky.framework.core.kv.service.KvService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/1/29
 */
@Service("kvHandlerConfig")
public class KvHandlerConfig {
    @Resource(name = "kvService")
    KvService kvService;

    @Resource(name = "kvDao")
    KvDao dao;

    public void addHandler(KvHandler handler) {
        kvService.addHandler(handler);
    }

    @PostConstruct
    void setup() {
        addHandler(new SimpleKvHandler(1, "tb_team", "team_name",
                "id", MapUtils.<String, Object>build().put("team_name", ":team_name").get(),
                KvHandler.ALL));
        addHandler(new SimpleKvHandler(2, "tb_route", "route_name",
                "id", MapUtils.<String, Object>build().put("route_name", ":route_name").get(),
                KvHandler.ALL));
        addHandler(new SimpleKvHandler(3, "tb_route", "route_name",
                "id", MapUtils.<String, Object>build().get(), KvHandler.ALL));
        addHandler(new SimpleKvHandler(4, "tb_user", "name",
                "id", MapUtils.<String, Object>build().put("name", ":name").get(),
                KvHandler.ALL));
        addHandler(new SimpleKvHandler(5, "tb_route", "route_name",
                "id", MapUtils.<String, Object>build().get(), KvHandler.PREFIX_SQL));
//        addHandler(new SimpleKvHandler(6, "tb_role", "name",
//                "id", MapUtils.<String, Object>build().get(), KvHandler.ALL));
//        addHandler(new SimpleKvHandler(7, "tb_menu", "name",
//                "id", MapUtils.<String, Object>build().put("name", ":name").get(),
//                KvHandler.ALL));
//        addHandler(new SimpleKvHandler(8, "tb_menu", "name",
//                "id", MapUtils.<String, Object>build().get(), KvHandler.PREFIX_SQL));
        addHandler(new SimpleKvHandler(9, "td_composite_dictionary", "dic_name",
                "dic_id", MapUtils.<String, Object>build().put("dic_type", 1).get(),
                KvHandler.ALL));
        addHandler(new SimpleKvHandler(10, "td_composite_dictionary", "dic_name",
                "dic_id", MapUtils.<String, Object>build().put("dic_type", 2).get(),
                KvHandler.ALL));
//        addHandler(new SimpleKvHandler(11, "tb_role", "name",
//                "id", MapUtils.<String, Object>build().put("name", ":name").get(),
//                KvHandler.ALL));
    }
}
