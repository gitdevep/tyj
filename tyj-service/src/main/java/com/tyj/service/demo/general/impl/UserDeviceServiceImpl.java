/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.service.demo.general.impl;

import cn.vansky.framework.core.dao.SqlMapDao;
import cn.vansky.framework.core.service.GenericSqlMapServiceImpl;
import javax.annotation.Resource;

import cn.vansky.framework.core.web.filter.auth.AuthWrapper;
import cn.vansky.framework.core.web.http.session.SessionProvider;
import com.tyj.dao.demo.general.bo.User;
import com.tyj.dao.demo.general.bo.UserDevice;
import com.tyj.dao.demo.general.dao.UserDeviceDao;
import com.tyj.service.demo.general.UserDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * This class corresponds to the database table `tb_user_device`
 */
@Service("userDeviceService")
public class UserDeviceServiceImpl extends GenericSqlMapServiceImpl<UserDevice, Integer> implements UserDeviceService {
    @Resource(name = "userDeviceDao")
    private UserDeviceDao userDeviceDao;

    @Resource(name = "sessionProvider")
    private SessionProvider sessionProvider;

    public SqlMapDao<UserDevice, Integer> getDao() {
        return userDeviceDao;
    }

    @Override
    public void delMember(Map<String, Object> params) {
        userDeviceDao.delMember(params);
    }

    @Override
    public List<Integer> findDeviceIdsByCurrentUser() {
        User user =(User) sessionProvider.getAttribute(AuthWrapper.SESSION_USER_MESSAGE);
        return userDeviceDao.findDeviceIdsByUserId(user.getId());
    }

    @Override
    public String validation(List<Integer> deviceIds) {
        List<Integer> list = this.findDeviceIdsByCurrentUser();
        StringBuilder sb = new StringBuilder();
        for (Integer deviceId : deviceIds) {
            if (!list.contains(deviceId)) {
                sb.append("没有查询" + deviceId + "设备的权限\n");
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}