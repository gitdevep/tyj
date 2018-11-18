<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>天盈健数据分析平台</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/frame/default.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/frame/frame.css"/>
    <script type="text/javascript" src="<%=basePath%>js/frame/timer.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/frame/frame.js"></script>
</head>
<body class="easyui-layout" style="overflow-y: hidden">
<div class="north" region="north" border="false">
    <div class="northDiv1">&nbsp;<img src="<%=basePath%>images/resources/blocks.gif" align="absmiddle"/> 天盈健数据分析平台
    </div>
    <div class="northDiv2">
        <div class="headLeft" id="systime"></div>
        <div class="headRight">欢迎你，<span id="userNameShow"><c:out value="${userNameShow}"/></span>&nbsp;<a href="#" id="loginOut" onclick="loginOut()">安全退出</a></div>
    </div>
</div>
<div class="west" region="west" title="菜单" split="true">
    <div id="nav" fit="true" border="false">
        <ul id="tt" class="easyui-tree">
        </ul>
    </div>
</div>
<div class="center" region="center">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
    </div>
</div>
<div class="south" region="south" split="true">
    <div class="footer">2016&copy;Copy rights reserve</div>
</div>
<input id="message" type="hidden" value='${message}'>
</body>
<script type="text/javascript">
    function loginOut() {
        $.messager.confirm("系统提示", "您确定要退出本次登录吗?", function (r) {
            delCookie("userName");
            delCookie("id");
            window.location.href = "<%=basePath%>/user/loginOut";
        });
    }
</script>
</html>
