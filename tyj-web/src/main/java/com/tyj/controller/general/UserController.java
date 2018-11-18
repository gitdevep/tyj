/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller.general;

import cn.vansky.framework.common.util.DateUtil;
import cn.vansky.framework.common.util.HttpClientUtils;
import cn.vansky.framework.common.util.JsonUtil;
import cn.vansky.framework.core.util.JsonResp;
import cn.vansky.framework.core.web.filter.auth.AuthWrapper;
import cn.vansky.framework.core.web.filter.auth.GeneralAuthWrapper;
import cn.vansky.framework.core.web.http.session.SessionProvider;
import com.tyj.controller.AbstractController;
import com.tyj.dao.demo.general.bo.DeviceInfo;
import com.tyj.dao.demo.general.vo.DeviceInfoPageVo;
import com.tyj.dao.demo.general.bo.User;
import com.tyj.dao.demo.general.bo.UserDevice;
import com.tyj.dao.demo.general.bo.UserTeam;
import com.tyj.dao.demo.general.vo.UserPageVo;
import com.tyj.service.demo.general.DeviceInfoService;
import com.tyj.service.demo.general.impl.SystemConfig;
import com.tyj.service.demo.general.UserDeviceService;
import com.tyj.service.demo.general.UserService;
import com.tyj.service.demo.general.UserTeamService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/12/9
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractController {
    @Resource(name = "userService")
    UserService userService;

    @Resource(name = "deviceInfoService")
    DeviceInfoService deviceInfoService;

    @Resource(name = "userDeviceService")
    UserDeviceService userDeviceService;

    @Resource(name = "userTeamService")
    UserTeamService userTeamService;

    @Resource(name = "sessionProvider")
    SessionProvider sessionProvider;

    @ResponseBody
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam Map<String, Object> param) {
        ModelAndView mv;
        User user = userService.findUserByMap(param);
        if (null == user) {
            mv = new ModelAndView("redirect:/");
            mv.addObject("message", "用户名或密码错误");
            return mv;
        }
        String url = SystemConfig.getStr("auth.url");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", user.getAuthId());
        params.put("systemId", 3);
        String json = HttpClientUtils.execute(params, url);
        GeneralAuthWrapper generalAuthWrapper = JsonUtil.fromJson(json, GeneralAuthWrapper.class);
        if (generalAuthWrapper.getStatus() != 0) {
            mv = new ModelAndView("redirect:/");
            mv.addObject("message", generalAuthWrapper.getStatusInfo());
            return mv;
        }
        sessionProvider.setAttribute(AuthWrapper.SESSION_USER_MESSAGE, user);
        sessionProvider.setAttribute(AuthWrapper.SESSION_AUTH_WRAPPER_MESSAGE, generalAuthWrapper.getData());
        List l = generalAuthWrapper.getData().getMenuList();
        if (CollectionUtils.isEmpty(l)) {
            mv = new ModelAndView("redirect:/");
            mv.addObject("message", "没有菜单,请找管理员");
            return mv;
        }
        mv = new ModelAndView("common/frame");
        mv.addObject("message", JsonResp.asList().addAll(l).toJson());
        mv.addObject("userNameShow", user.getName());
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/page/list")
    public String findPageUser(UserPageVo vo) {
        List<User> l = userService.findPageUser(vo.convertPageMap());
        vo.setRows(l);
        return JsonResp.asData(vo).setDatePattern(DateUtil.yyyy_MM_dd_HH_mm_ss).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/add_user")
    public String addUser(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", user.getName());
        KvVoExt kvVoExt = new KvVoExt(4, "用户", params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        user.setCreateTime(new Date());
        userService.saveEntitySelective(user);

        if (!StringUtils.isBlank(user.getTeams())) {
            String [] teams = user.getTeams().split(",");
            List<UserTeam> tc = new ArrayList<UserTeam>();
            for (String d :teams) {
                UserTeam userTeam = new UserTeam();
                userTeam.setUserId(user.getId());
                userTeam.setTeamId(Integer.valueOf(d));
                tc.add(userTeam);
            }
            userTeamService.saveBatch(tc);
        }

        if (!StringUtils.isBlank(user.getCars())) {
            String [] cars = user.getCars().split(",");
            List<UserDevice> uc = new ArrayList<UserDevice>();
            for (String d :cars) {
                UserDevice userTeam = new UserDevice();
                userTeam.setUserId(user.getId());
                userTeam.setDeviceId(Integer.valueOf(d));
                uc.add(userTeam);
            }
            userDeviceService.saveBatch(uc);
        }
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/edit_user")
    public String editUser(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", user.getName());
        KvVoExt kvVoExt = new KvVoExt(4, "用户", user.getId(), params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        userService.updateEntitySelective(user);

        if (!StringUtils.isBlank(user.getTeams())) {
            String [] teams = user.getTeams().split(",");
            List<UserTeam> tc = new ArrayList<UserTeam>();
            for (String d :teams) {
                UserTeam userTeam = new UserTeam();
                userTeam.setUserId(user.getId());
                userTeam.setTeamId(Integer.valueOf(d));
                tc.add(userTeam);
            }
            userTeamService.saveBatch(tc);
        }

        if (!StringUtils.isBlank(user.getCars())) {
            String [] cars = user.getCars().split(",");
            List<UserDevice> uc = new ArrayList<UserDevice>();
            for (String d :cars) {
                UserDevice userTeam = new UserDevice();
                userTeam.setUserId(user.getId());
                userTeam.setDeviceId(Integer.valueOf(d));
                uc.add(userTeam);
            }
            userDeviceService.saveBatch(uc);
        }
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/remove_user")
    public String removeUser(String ids) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ids", ids.split(","));
        params.put("status", 2);
        userService.updateStatus(params);
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/page/list_cars")
    public String listCars(DeviceInfoPageVo vo) {
        if (vo.getUserId() == null) {
            vo.setRows(new ArrayList());
            return JsonResp.asData(vo).toJson();
        }
        List<DeviceInfo> ul = deviceInfoService.findPageCars(vo.convertPageMap());
        vo.setRows(ul);
        return JsonResp.asData(vo).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/page/list_teams")
    public String listTeams(DeviceInfoPageVo vo) {
        List<DeviceInfo> ul = userService.findPageTeams(vo.convertPageMap());
        vo.setRows(ul);
        return JsonResp.asData(vo).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/remove_cars")
    public String removeCars(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", user.getId());
        params.put("members", user.getMembers().split(","));
        userDeviceService.delMember(params);
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/remove_teams")
    public String removeTeams(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", user.getId());
        params.put("members", user.getMembers().split(","));
        userTeamService.delMember(params);
        return JsonResp.asEmpty().toJson();
    }

    @RequestMapping(value = "/loginOut")
    public ModelAndView loginOut() {
        sessionProvider.logout();
        return new ModelAndView("redirect:/");
    }
}
