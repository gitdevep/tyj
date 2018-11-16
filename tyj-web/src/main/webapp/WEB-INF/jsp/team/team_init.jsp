<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>团队信息</title>
    </head>
    <body>
        <table id="list"></table>
        <div id="toolbar">
            <input class="easyui-textbox" type="text" id="teamName" data-options="prompt:'姓名'" size="30" />
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
            <auth:auth test="team/add_team">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="doAdd()">新增</a>
            </auth:auth>
            <auth:auth test="team/edit_team">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="doEdit()">编辑</a>
            </auth:auth>
        </div>
        <div id="a" class="easyui-window" title="新增团队" data-options="closed:true" style="top:120px;width:500px;height:200px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'">
                    <form id="f" class="easyui-form">
                        <table cellpadding="5">
                            <tr>
                                <td>团队:</td>
                                <td><input class="easyui-textbox" type="text" name="teamName" data-options="required:true"/></td>
                            </tr>
                            <tr>
                                <td>成员:</td>
                                <td><input class="easyui-searchbox" id="aMembers" name="members" data-options="required:true,prompt:'选择所属团队成员',searcher: doASearchTeamMember"></td>
                            </tr>
                            <%--<tr>--%>
                                <%--<td>路线:</td>--%>
                                <%--<td><input class="easyui-combobox" id="aRouteId" name="routeId" data-options="required:true"></td>--%>
                            <%--</tr>--%>
                        </table>
                    </form>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="submitForm($('#f'), 'add_team', $('#a'));" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#a'));clearForm($('#f'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        <div id="ad" class="easyui-window" title="新增成员" data-options="closed:true" style="top:50px;width:800px;height:420px;padding:1px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'">
                    <div>
                        <table id="ad_no_choice_list"></table>
                    </div>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="aSubmitMembers();" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#ad'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        <div id="e" class="easyui-window" title="编辑团队" data-options="closed:true" style="top:120px;width:500px;height:200px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'">
                    <form id="ef" class="easyui-form">
                        <table cellpadding="5">
                            <input type="hidden" id="eTeamId" name="id"/>
                            <input type="hidden" name="teamRouteId"/>
                            <tr>
                                <td>团队:</td>
                                <td><input class="easyui-textbox" type="text" name="teamName" data-options="required:true"/></td>
                            </tr>
                            <tr>
                                <td>成员:</td>
                                <td><input class="easyui-searchbox" id="eMembers" name="members" data-options="required:true,prompt:'选择所属团队成员',searcher: doESearchTeamMember"></td>
                            </tr>
                            <%--<tr>--%>
                                <%--<td>路线:</td>--%>
                                <%--<td><input class="easyui-combobox" id="eRouteId" name="routeId" data-options="required:true"></td>--%>
                            <%--</tr>--%>
                        </table>
                    </form>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="submitForm($('#ef'), 'edit_team', $('#e'));" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#e'));clearForm($('#ef'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
        <div id="ed" class="easyui-window" title="编辑成员" data-options="closed:true" style="top:50px;width:800px;height:420px;padding:1px;">
            <div class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center'">
                    <div style="padding:10px;">
                        <table id="ed_choice_list"></table>
                    </div>
                    <div style="padding:10px;">
                        <table id="ed_no_choice_list"></table>
                    </div>
                </div>
                <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="eSubmitMembers();" style="width:80px">提交</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="eRemoveMembers();" style="width:80px">移除</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#ed'));" style="width:80px">关闭</a>
                </div>
            </div>
        </div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/user/team_model.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/user/device_model.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/user/team_action.js"></script>
