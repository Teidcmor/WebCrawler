<%--
  Created by IntelliJ IDEA.
  User: WZH
  Date: 2019/5/14
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%String path = request.getContextPath();
    String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个人中心</title>

    <link href="plugins/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- JAVASCRIPTS -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script src="plugins/bootstrap/dist/js/popper.min.js"></script>
    <script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>


    <script>
        /*修改密码方法*/
        function changePassword() {
            var result = confirm("密码已修改，是否保存？");
            if(result)
                $('#passwordForm').submit();

        }

        /*修改性别方法*/
        function changeSex() {
            var result = confirm("性别已修改，是否保存？");
            if(result)
                $('#sexForm').submit();
        }

        $(function () {
            var value = ${currentUser.reserve1};
            var target = "";
            if(value==0)
                target = "女";
            else
                target = "男";
            $('#sex').val(target);
        })

        /*跳转用户管理页面*/
        function goUserManage() {
            var form = document.createElement("form");
            form.target='_self';
            form.method='POST';
            form.action='/admin/goUserManage.do';
            document.body.appendChild(form);
            form.submit();
        }

        /*跳转爬虫控制页面*/
        function goSpiderController() {
            var form = document.createElement("form");
            form.target='_self';
            form.method='POST';
            form.action='/spider/goSpiderController.do';
            document.body.appendChild(form);
            form.submit();
        }

        /*跳转主页面*/
        function goMain() {
            var form = document.createElement("form");
            form.action="/coreData/goMain.do";
            form.target="_self";
            form.method="POST";
            document.body.appendChild(form);
            form.submit();
        }

        /*退出登录*/
        function out() {
            var form = document.createElement("form");
            form.action="/root/toLogin.do";
            form.target="_self";
            form.method="POST";
            document.body.appendChild(form);
            form.submit();
        }

    </script>

</head>

<body class="body-wrapper">
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar navbar-expand-lg  navigation">
                    <a class="navbar-brand" onclick="goMain()" style="cursor: pointer">
                        <!--<img src="images/logo.png" alt="">-->
                        租房信息爬取平台
                    </a>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                        <ul class="navbar-nav ml-auto mt-10">
                            <li class="nav-item">
                                <span class="nav-link add-button" id="personal" style="cursor: pointer" onclick="goPersonal()">个人中心</span>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link login-button" style="cursor: pointer" onclick="out()"></i> 退出登录</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</section>
<section class="dashboard section">
    <!-- Container Start -->
    <div class="container">
        <!-- Row Start -->
        <div class="row">
            <div class="col-md-10 offset-md-1 col-lg-4 offset-lg-0">
                <div class="sidebar">
                    <!-- User Widget -->
                    <div class="widget user-dashboard-profile">
                        <!-- User Image -->
                        <div class="profile-thumb">
                            <c:if test="${currentUser.reserve1==1}">
                                <img src="images/user/user-thumb.jpg" alt="" class="rounded-circle">
                            </c:if>
                            <c:if test="${currentUser.reserve1!=1}">
                                <img src="images/user/u2.jpg" alt="" class="rounded-circle">
                            </c:if>
                        </div>
                        <!-- User Name -->
                        <h5 class="text-center">${currentUser.userName}</h5>
                        <c:if test="${currentUser.type==1}">
                            <p>管理员</p>
                        </c:if>
                        <c:if test="${currentUser.type!=1}">
                            <p>普通用户</p>
                        </c:if>
                    </div>
                    <!-- Dashboard Links -->
                    <div class="widget user-dashboard-menu">
                        <ul>
                            <li class="active" ><a style="cursor: pointer"><i class="fa fa-user"></i> 个人信息 </a></li>
                            <c:if test="${currentUser.type==1}">
                            <li><a onclick="goUserManage()" style="cursor: pointer"><i class="fa fa-cog"></i> 用户管理 </a></li>
                            <li><a onclick="goSpiderController()" style="cursor: pointer">&nbsp;<i class="fa fa-bolt"></i> 爬虫控制 </a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
                <!-- Recently Favorited -->
                <div class="widget dashboard-container my-adslist">
                    <h3 class="widget-header">个人信息：</h3>
                    <table class="table table-responsive product-dashboard-table">
                        <tbody>
                        <tr>

                            <td class="product-category"><span class="categories">用户名：</span></td>
                            <td class="action" data-title="Action">
                                <div class="form-group col-md-3">
                                    <input type="text" disabled="disabled"  class="form-control" style="width: 300px ;background-color: white" id="region" value="${currentUser.userName}" >
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="product-category"><span class="categories">密码：</span></td>
                            <td class="action" data-title="Action">
                                <div class="form-group col-md-3">
                                    <form id="passwordForm" action="/user/changePassword.do" method="post">
                                        <input type="password"  class="form-control" style="width: 300px" id="password"  name="password"  value="${currentUser.password}" onchange="changePassword()">
                                    </form>
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td class="product-category"><span class="categories">性别：</span></td>
                            <td class="action" data-title="Action">
                                <div class="form-group col-md-3">
                                    <form id="sexForm" action="/user/changeSex.do" method="post">
                                        <input type="text" class="form-control" style="width: 300px" id="sex"  name="sex"  onchange="changeSex()">
                                    </form>
                                </div>
                            </td>
                        </tr>
                        <tr style="visibility: hidden">
                            <td class="product-category"><span class="categories"></span></td>
                            <td class="action" data-title="Action">

                            </td>
                        </tr>
                        <tr style="visibility: hidden">
                            <td class="product-category"><span class="categories"></span></td>
                            <td class="action" data-title="Action">

                            </td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
        <!-- Row End -->
    </div>
    <!-- Container End -->
</section>
<!--============================
=            Footer            =
=============================-->

<footer class="footer-bottom">
    <!-- Container Start -->
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-12">
                <!-- Copyright -->
                <div class="copyright">
                    <p>租房信息爬取平台-作者：  <a href="https://github.com/Teidcmor"
                                        target="_blank" title="温珍辉">温珍辉</a> -
                        2019年05月10日-南昌大学-南昌大学软件工程专业</p>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>

</html>
