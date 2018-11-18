<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>天盈健数据分析平台—欢迎登陆</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/frame/ivi_login.css">
</head>
<body style="background-color:#0014c8">
<img src="images/logo_white.png" style="float:left;margin:40px 0 0 20px;" />
<div class="line"></div>
<div class="box">
    <span class="msg">${param.message}</span>
    <form name="form2" action="user/login" method="post" id="form2">
        <input type="text" name="userName" placeholder="用户名">
        <input type="password" name="userPassword" placeholder="密码">
        <input type="submit" name="but5" id="but5" value="登录">
    </form>
</div>
</body>
</html>
