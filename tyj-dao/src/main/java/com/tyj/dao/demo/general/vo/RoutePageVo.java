package com.tyj.dao.demo.general.vo;

import cn.vansky.framework.core.vo.BaseVo;
import com.tyj.dao.demo.general.bo.Route;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/5/6
 */
public class RoutePageVo extends BaseVo<Route> {
    private String routeName;

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}
