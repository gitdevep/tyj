/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.controller.general;

import cn.vansky.framework.core.util.JsonResp;
import com.tyj.controller.AbstractController;
import com.tyj.dao.demo.general.bo.Team;
import com.tyj.dao.demo.general.vo.TeamPageVo;
import com.tyj.dao.demo.general.bo.TeamDevice;
import com.tyj.service.demo.general.TeamService;
import com.tyj.service.demo.general.TeamDeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/4/24
 */
@Controller
@RequestMapping(value = "team")
public class TeamController extends AbstractController {
    @Resource(name = "teamService")
    TeamService teamService;

    @Resource(name = "teamDeviceService")
    TeamDeviceService teamDeviceService;

    @ResponseBody
    @RequestMapping(value = "/page/list")
    public String findPageTeam(TeamPageVo vo) {
        List<Team> l = teamService.findPageTeam(vo.convertPageMap());
        vo.setRows(l);
        return JsonResp.asData(vo).toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/add_team")
    public String addTeam(Team team) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("team_name", team.getTeamName());
        KvVoExt kvVoExt = new KvVoExt(1, "团队", params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        teamService.saveEntitySelective(team);
        String [] ds = team.getMembers().split(",");
        List<TeamDevice> ts = new ArrayList<TeamDevice>();
        for (String d :ds) {
            TeamDevice teamDevice = new TeamDevice();
            teamDevice.setTeamId(team.getId());
            teamDevice.setDeviceId(Integer.valueOf(d));
            ts.add(teamDevice);
        }
        teamDeviceService.saveBatch(ts);
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/edit_team")
    public String editTeam(Team team) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("team_name", team.getTeamName());
        KvVoExt kvVoExt = new KvVoExt(1, "路线", team.getId(), params);
        String result = validation(kvVoExt);
        if (result != null) {
            return result;
        }
        teamService.updateEntitySelective(team);
        String [] ds = team.getMembers().split(",");
        List<TeamDevice> ts = new ArrayList<TeamDevice>();
        for (String d :ds) {
            TeamDevice teamDevice = new TeamDevice();
            teamDevice.setTeamId(team.getId());
            teamDevice.setDeviceId(Integer.valueOf(d));
            ts.add(teamDevice);
        }
        teamDeviceService.saveBatch(ts);
        return JsonResp.asEmpty().toJson();
    }

    @ResponseBody
    @RequestMapping(value = "/remove_member")
    public String removeMember(Team team) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("teamId", team.getId());
        params.put("members", team.getMembers().split(","));
        teamDeviceService.delMember(params);
        return JsonResp.asEmpty().toJson();
    }
}
