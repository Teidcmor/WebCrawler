<%@ page import="userInfo.dto.UserInfoDTO" %><%--
  Created by IntelliJ IDEA.
  User: WZH
  Date: 2019/4/16
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${currentUser.userName}</p>

<form method="get" action="/index.html">
    <button type="submit" value="开启爬虫"/>
</form>
</body>
</html>
