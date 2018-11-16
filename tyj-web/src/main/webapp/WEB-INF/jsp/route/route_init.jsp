<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>css/frame/common_map.css">
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=lTz3Ctx4eC9QAXl7ZjoyzyWb"></script>
        <title>路线信息</title>
    </head>
    <body>
        <table id="list"></table>
        <div id="toolbar">
            <input class="easyui-textbox" type="text" id="routeName" data-options="prompt:'路线名称'" size="30" />
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
            <auth:auth test="route/add_route">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="doAdd()">新增</a>
            </auth:auth>
            <auth:auth test="route/edit_route">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="doEdit()">编辑</a>
            </auth:auth>
        </div>
        <div id="a" class="easyui-window" title="新增路线" data-options="closed:true," style="top:120px;width:800px;height:600px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <form id="f" class="easyui-form">
                    <table cellpadding="5">
                        <tr>
                            <input type="hidden" id="aStartLng" name="startLng">
                            <input type="hidden" id="aStartLat" name="startLat">
                            <input type="hidden" id="aEndLng" name="endLng">
                            <input type="hidden" id="aEndLat" name="endLat">
                            <td>路线:<input class="easyui-textbox" type="text" name="routeName" data-options="required:true" size="15"/></td>
                            <td>公里:<input class="easyui-textbox" type="text" id="akm" name="km" data-options="required:true" size="8"/></td>
                            <td>油耗:<input class="easyui-textbox" type="text" name="oilCost" size="8"/></td>
                            <td>
                                <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="submitForm($('#f'), 'add_route', $('#a'));" style="width:80px">提交</a>
                                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#a'));clearForm($('#f'));" style="width:80px">关闭</a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">起点:<input class="easyui-textbox" type="text" id="aStartLocation" name="startName" data-options="required:true" style="width:300px;"/></td>
                            <td colspan="2">终点:<input class="easyui-textbox" type="text" id="aEndLocation" name="endName" data-options="required:true" style="width:300px;"/></td>
                        </tr>
                    </table>
                </form>
                <div id="aallmap"></div>
                <%--<div id="ar-result"></div>--%>
            </div>
        </div>
        <div id="e" class="easyui-window" title="编辑路线" data-options="closed:true," style="top:120px;width:800px;height:600px;padding:5px;">
            <div class="easyui-layout" data-options="fit:true">
                <form id="ef" class="easyui-form">
                    <table cellpadding="5">
                        <input type="hidden" name="id"/>
                        <tr>
                            <input type="hidden" id="eStartLng" name="startLng">
                            <input type="hidden" id="eStartLat" name="startLat">
                            <input type="hidden" id="eEndLng" name="endLng">
                            <input type="hidden" id="eEndLat" name="endLat">
                            <td>路线:<input class="easyui-textbox" type="text" name="routeName" data-options="required:true" size="15"/></td>
                            <td>公里:<input class="easyui-textbox" type="text" id="ekm" name="km" data-options="required:true" size="8"/></td>
                            <td>油耗:<input class="easyui-textbox" type="text" name="oilCost" size="8"/></td>
                            <td>
                                <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="submitForm($('#ef'), 'edit_route', $('#e'));" style="width:80px">提交</a>
                                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="closeWindow($('#e'));clearForm($('#ef'));" style="width:80px">关闭</a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">起点:<input class="easyui-textbox" type="text" id="eStartLocation" name="startName" data-options="required:true" style="width:300px;"/></td>
                            <td colspan="2">终点:<input class="easyui-textbox" type="text" id="eEndLocation" name="endName" data-options="required:true" style="width:300px;"/></td>
                        </tr>
                    </table>
                </form>
                <div id="eallmap"></div>
                <%--<div id="er-result"></div>--%>
            </div>
        </div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/user/route_model.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/user/route_action.js"></script>
