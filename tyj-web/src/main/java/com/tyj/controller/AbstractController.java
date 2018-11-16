/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller;

import cn.vansky.framework.core.kv.handler.KvHandlerSupport;
import cn.vansky.framework.core.kv.service.KvService;
import cn.vansky.framework.core.util.JsonResp;
import com.tyj.controller.general.KvVoExt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/4/4
 */
public abstract class AbstractController {

    @Resource(name = "kvService")
    KvService kvService;

    /**
     * 统一初始化页面
     * @return
     */
    @RequestMapping(value = "/{model}")
    public ModelAndView init(@PathVariable String model) {
        RequestMapping r = this.getClass().getAnnotation(RequestMapping.class);
        return new ModelAndView(r.value()[0] + "/" + model);
    }

    protected String validation(KvVoExt kvVoExt) {
        KvHandlerSupport support = kvService.lookup(kvVoExt.getModule());
        if (!support.isExist()) {
            return JsonResp.asEmpty().error("无此模块").toJson();
        }
        List<Map<Object, Object>> list = kvService.all(support, kvVoExt.getParams());
        if (list != null && !list.isEmpty()) {
            if (kvVoExt.getId() != null && kvVoExt.getId().equals(list.get(0).get("value"))) {
                return null;
            }
            return JsonResp.asEmpty().error(kvVoExt.getDesc() + "已存在,请重新添加").toJson();
        }
        return null;
    }
}
