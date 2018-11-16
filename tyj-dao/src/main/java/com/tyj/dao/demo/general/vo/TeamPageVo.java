package com.tyj.dao.demo.general.vo;

import cn.vansky.framework.core.vo.BaseVo;
import com.tyj.dao.demo.general.bo.Team;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/5/6
 */
public class TeamPageVo extends BaseVo<Team> {
    private String teamName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
