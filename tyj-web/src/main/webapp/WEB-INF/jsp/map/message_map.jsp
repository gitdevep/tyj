<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>地图统计</title>
    </head>
    <body>
        <div id="newSearch">
            <form id="queryForm">
                <table>
                    <tr>
                        <td>
                            <b>图表类型：</b>
                            <input class="easyui-combobox" id="type" name="type" data-options="required:true" style="width:90px;"/>
                        </td>
                        <td id="cityTd" style="display: none;">
                            <b>城市：</b>
                            <input class="easyui-textbox" type="text" id="city" data-options="prompt:'默认北京'"/>
                        </td>
                        <td id="windowTd">
                            <b>设备编号：</b>
                            <input class="easyui-textbox" id="deviceId" name="deviceId" data-options="required:true" style="width:100px;"/>
                            <b>开始时间：</b>
                            <input class="easyui-my97" data-options="required:true,skin:'whyGreen',maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M-%d\'}',dateFmt:'yyyy-MM-dd HH:mm'" id="startDate">
                            <b>结束时间：</b>
                            <input class="easyui-my97" data-options="required:true,skin:'whyGreen',minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'%y-%M-%d}',dateFmt:'yyyy-MM-dd HH:mm'" id="endDate">
                            <input class="easyui-combobox" id="msgType" name="msgType" data-options="required:true" style="width:90px;"/>
                        </td>
                        <td>
                            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
                        </td>
                    </tr>
                </table>
            </form>
            <iframe scrolling="auto" frameborder="0" id="oneIframe"  src="" style="width:100%;height:100%;"></iframe>
        </div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/page/map/message_map.js"></script>