<%--
  Created by IntelliJ IDEA.
  User: WZH
  Date: 2019/5/14
  Time: 13:01
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
    <title>爬虫控制</title>

    <link href="plugins/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <!-- JAVASCRIPTS -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script src="plugins/bootstrap/dist/js/popper.min.js"></script>
    <script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>

    <script>

        /*更新系统参数*/
        function updateSysParam(name,value) {
            var paramName = name;
            var paramValue = value;
            var form = document.createElement("form");
            form.action="/spider/updateSysParam.do";
            form.target="_self";
            form.method="POST";
            var nameInput = document.createElement("input");
            nameInput.value=paramName;
            nameInput.name="id";
            var valueInput = document.createElement("input");
            valueInput.name="value";
            valueInput.value=paramValue;
            form.append(nameInput);
            form.append(valueInput);
            document.body.appendChild(form);
            form.submit();
        }

        /*跳转用户管理页面*/
        function goUserManage() {
            var form = document.createElement("form");
            form.target='_self';
            form.method='POST';
            form.action='/admin/goUserManage.do';
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

        /*跳转个人信息页面*/
        function goPersonal() {
            var form = document.createElement("form");
            form.target='_self';
            form.method='POST';
            form.action='/user/goPersonal.do';
            document.body.appendChild(form);
            form.submit();
        }

        /*新增URL*/
        function addNewUrl() {
            var city = $('#city').val();
            var url = $('#url').val();
            $.post("/spider/addNewUrl.do",{
                city:city,
                url:url
            },function (data,status) {
                if(status=="success")
                    alert(data);
                else
                    alert("新增失败！！");
            });
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
<!--==================================
=            User Profile            =
===================================-->
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
                            <li ><a style="cursor: pointer" onclick="goPersonal()"><i class="fa fa-user"></i> 个人信息 </a></li>
                            <c:if test="${currentUser.type==1}">
                                <li ><a style="cursor: pointer" onclick="goUserManage()" ><i class="fa fa-cog"></i> 用户管理 </a></li>
                                <li class="active"><a  style="cursor: pointer" >&nbsp;<i class="fa fa-bolt"></i> 爬虫控制 </a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
                <div class="widget change-password">
                    <h3 class="widget-header user">新增链接</h3>
                        <div class="form-group">
                            <input type="text" class="form-control"  id="city" placeholder="市：例如 杭州">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="url" placeholder="URL:例如 www.baidu.com">
                        </div>
                        <button class="btn btn-transparent" onclick="addNewUrl()" > 提 &nbsp;&nbsp;交 </button>
                </div>
                <!-- Recently Favorited -->
                <div class="widget dashboard-container my-adslist">
                    <h3 class="widget-header">爬虫控制</h3>
                    <table class="table table-responsive product-dashboard-table">
                        <thead >
                        <tr>
                            <th>#</th>
                            <th>参数名</th>
                            <th class="text-center"></th>
                            <th class="text-center">当前状态</th>
                            <th class="text-center">设置</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="sysParam" items="${sysParams}" varStatus="index">
                        <tr>

                            <td class="product-thumb">
                                <span >${index.index+1}</span></td>
                            <td class="product-details" style="width: 300px">
                                <h3 class="title">${sysParam.reserve1}</h3>
                            </td>
                            <td class="action" data-title="Action"></td>
                            <c:if test="${sysParam.paramValue==0}">
                                <td class="product-category"><span class="categories">关闭</span></td>
                            </c:if>
                            <c:if test="${sysParam.paramValue!=0}">
                                <td class="product-category"><span class="categories">开启</span></td>
                            </c:if>
                            <td class="action" data-title="Action">
                                <div class="">
                                    <ul class="list-inline justify-content-center">
                                        <c:if test="${sysParam.paramValue==0}">
                                        <li class="list-inline-item">
                                            <a  class="view" style="cursor: pointer" onclick="updateSysParam(${sysParam.id},1)" >
                                                <i class="fa fa-check fa-2x"></i>
                                            </a>
                                        </li>
                                        </c:if>
                                        <c:if test="${sysParam.paramValue!=0}">
                                        <li class="list-inline-item">
                                            <a class="delete" style="cursor: pointer" onclick="updateSysParam(${sysParam.id},0)">
                                                <i class="fa fa-times fa-2x"></i>
                                            </a>
                                        </li>
                                        </c:if>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        </c:forEach>

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
