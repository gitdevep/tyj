<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src="<c:url value="/"/>js/page/alarm/day_action.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>每天预警</title>
    </head>
    <body>
        <div id="search">
            <form id="queryForm">
                <b>设备编号：</b>
                <input id="deviceId" name="deviceId" type="text" class="easyui-textbox" data-options="required:true"/>
                <b>日期：</b>
                <input class="easyui-my97" type="text" data-options="required:true,skin:'whyGreen',maxDate:'%y-%M-{%d-1}}'" id="dt">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
            </form>
        </div>
        <div id="alarmDayCount" style="height:300px;border:1px solid #ccc;padding:10px;"></div>
        <div id="alarmWeekCount" style="height:300px;border:1px solid #ccc;padding:10px;"></div>
    </body>
</html>
