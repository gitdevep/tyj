package com.tyj.dao.demo.general.vo;

import cn.vansky.framework.core.vo.BaseVo;

/**
 * Created by IntelliJ IDEA .
 * Auth: CK
 * Date: 2016/5/6
 */
public class DeviceInfoPageVo extends BaseVo {

    private String keyword;

    private Integer no;

    private Integer teamId;

    private Integer userId;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
