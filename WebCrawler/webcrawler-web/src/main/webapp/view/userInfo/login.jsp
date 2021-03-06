<%--
  Created by IntelliJ IDEA.
  User: WZH
  Date: 2019/4/2
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>

    <script>
        $(function () {
            var massage = "${errorMessage}";
            if(massage!=""){
                $('#errorMessage').html(massage);
            }
        })
    </script>


</head>
<body style="background-color: #fafafa">
<div class="container" style="margin-left: 39%;margin-top: 14%">
    <div style="width: 400px;">
        <form class="form-signin" action="/user/login.do" method="post">
            <h2 class="form-signin-heading">Please login</h2>
            <div class="control-group">
                <label for="inputEmail" class="sr-only">UserName</label>
                <div class="controls">
                    <input type="text" id="inputEmail" name="userName" class="form-control" placeholder="UserName" required autofocus><a style="color: red" id="errorMessage"></a>
                </div>
            </div>
            <div class="control-group">
                <label for="inputPassword" class="sr-only">Password</label>
                <div class="controls">
                    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                </div>
            </div>
            <div class="checkbox">
                <label>
                    <a  href="/view/userInfo/register.jsp" /> Go Register
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">login</button>
        </form>
    </div>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
