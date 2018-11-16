<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>css/frame/common_map.css">
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=lTz3Ctx4eC9QAXl7ZjoyzyWb"></script>
        <title>地理位置</title>
    </head>
    <body>
        <div id="newSearch">
            <form id="queryForm">
                <table>
                    <tr>
                        <td id="windowTd">
                            <b>设备编号：</b>
                            <input class="easyui-textbox" id="deviceId" name="deviceId" data-options="prompt:'多个设备以|分隔'" style="width:500px;"/>
                            <input class="easyui-combobox" id="msgType" name="msgType" data-options="required:true" style="width:90px;"/>
                        </td>
                        <td>
                            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
                        </td>
                    </tr>
                </table>
            </form>
            <div id="allmap"></div>
        </div>
    </body>
</html>
<script type="text/javascript" src="<c:url value="/"/>js/mapicon.js"></script>
<script type="text/javascript" src="<c:url value="/"/>js/page/map/location.js"></script>