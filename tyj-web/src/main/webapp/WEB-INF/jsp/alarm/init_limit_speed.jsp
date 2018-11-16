<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>超速统计</title>
    </head>
    <body>
        <div id="search">
            <form id="queryForm">
                <b>设备编号：</b>
                <input class="easyui-textbox" type="text" id="deviceId" data-options="required:true,prompt:'多个设备号,以英文逗号分隔'" style="width:300px;"/>
                <b>开始时间：</b>
                <input class="easyui-my97" type="text" id="startDate" data-options="required:true,skin:'whyGreen',maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M-{%d-1}\'}',dateFmt:'yyyy-MM-dd HH:mm'">
                <b>结束时间：</b>
                <input class="easyui-my97" type="text" id="endDate" data-options="required:true,skin:'whyGreen',minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'%y-%M-{%d-1}',dateFmt:'yyyy-MM-dd HH:mm'">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doDownload()">下载</a>
            </form>
        </div>
        <div id="alarm" class="commonDiv"></div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/alarm/limit_speed_action.js"></script>