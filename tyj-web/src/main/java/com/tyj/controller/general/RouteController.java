/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller.general;

import cn.vansky.framework.core.util.JsonResp;
import com.tyj.controller.AbstractController;
import com.tyj.dao.demo.general.bo.Route;
import com.tyj.dao.demo.general.vo.RoutePageVo;
import com.tyj.service.demo.general.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/4/24
 */
@Controller
@RequestMapping(value = "route")
public class RouteController extends AbstractController {

    @Resource(name = "routeService")
    RouteService routeService;

    @ResponseBody
    @RequestMapping(value = "/page/list")
    public String findPageRoute(RoutePageVo vo) {
        List<Route> l = routeService.findPageRoute(vo.convertPageMap());
        vo.setRows(l);
        return JsonResp.asData(vo).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/add_route")
    public String addRoute(Route route) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("route_name", route.getRouteName());
        KvVoExt kvVoExt = new KvVoExt(2, "路线", params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        routeService.saveEntitySelective(route);
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/edit_route")
    public String editRoute(Route route) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("route_name", route.getRouteName());
        KvVoExt kvVoExt = new KvVoExt(2, "路线", route.getId(), params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        routeService.updateEntitySelective(route);
        return JsonResp.asEmpty().toJson();
    }
}
