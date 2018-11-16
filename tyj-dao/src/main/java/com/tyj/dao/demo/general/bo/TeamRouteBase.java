/*
 * Copyright (C) 2016 CK, Inc. All Rights Reserved.
 */

package com.tyj.dao.demo.general.bo;

import cn.vansky.framework.core.dao.FieldAccessVo;
import cn.vansky.framework.core.dao.TableDataConvertable;
import cn.vansky.framework.core.dao.annotation.ColumnDescription;
import cn.vansky.framework.core.dao.annotation.Id;

/**
 * This class corresponds to the database table `tb_team_route`
 */
public abstract class TeamRouteBase extends FieldAccessVo implements TableDataConvertable {
    /**
     * This field corresponds to the database column `tb_team_route`.id
     */
    private static final String PROPERTY_ID = "id";

    /**
     * This field corresponds to the database column `tb_team_route`.id
     */
    private static final String PROPERTY_REMARK_ID = "自增ID";

    /**
     * This field corresponds to the database column `tb_team_route`.id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ID)
    @Id
    private Integer id;

    /**
     * This field corresponds to the database column `tb_team_route`.route_id
     */
    private static final String PROPERTY_ROUTEID = "routeId";

    /**
     * This field corresponds to the database column `tb_team_route`.route_id
     */
    private static final String PROPERTY_REMARK_ROUTEID = "线路ID";

    /**
     * This field corresponds to the database column `tb_team_route`.route_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_ROUTEID)
    private Integer routeId;

    /**
     * This field corresponds to the database column `tb_team_route`.team_id
     */
    private static final String PROPERTY_TEAMID = "teamId";

    /**
     * This field corresponds to the database column `tb_team_route`.team_id
     */
    private static final String PROPERTY_REMARK_TEAMID = "团队ID";

    /**
     * This field corresponds to the database column `tb_team_route`.team_id
     */
    @ColumnDescription(desc = PROPERTY_REMARK_TEAMID)
    private Integer teamId;

    /**
     * This method returns the value of the database column `tb_team_route`.id
     *
     * @return the value of `tb_team_route`.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column `tb_team_route`.id
     *
     * @param id the value for `tb_team_route`.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column `tb_team_route`.route_id
     *
     * @return the value of `tb_team_route`.route_id
     */
    public Integer getRouteId() {
        return routeId;
    }

    /**
     * This method sets the value of the database column `tb_team_route`.route_id
     *
     * @param routeId the value for `tb_team_route`.route_id
     */
    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    /**
     * This method returns the value of the database column `tb_team_route`.team_id
     *
     * @return the value of `tb_team_route`.team_id
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * This method sets the value of the database column `tb_team_route`.team_id
     *
     * @param teamId the value for `tb_team_route`.team_id
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}