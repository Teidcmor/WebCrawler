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
    <title>个人中心</title>

    <link href="plugins/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- JAVASCRIPTS -->

    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script src="plugins/bootstrap/dist/js/popper.min.js"></script>
    <script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>

    <script>

        function goPersonal() {
            var form = document.createElement("form");
            form.target='_self';
            form.method='POST';
            form.action='/user/goPersonal.do';
            document.body.appendChild(form);
            form.submit();
        }

        /*分页功能*/
        function changePage(pageNum) {
            var page = pageNum;
            if(page <=0 )
                page = 1;
            var form = document.createElement("form");
            form.target='_self';
            form.method='POST';
            form.action='/admin/changePage.do?pageNum='+page;
            document.body.appendChild(form);
            form.submit();
        }

        /*禁用用户或解禁*/
        function banUser(id,price,pageNum) {
            var i = id;
            var p = price;
            var pag = pageNum;
            $.post("/admin/banUser.do",{
                id:i,
                status:p,
                pageNum:pag
            },function (data,status) {
                document.close();
                document.write(data);
                document.close();
            });
        }
    </script>

</head>

<body class="body-wrapper">
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
                                <li class="active"><a style="cursor: pointer" ><i class="fa fa-cog"></i> 用户管理 </a></li>
                                <li><a href=""><i class="fa fa-bolt"></i> 爬虫控制 </a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
                <!-- Recently Favorited -->
                <div class="widget dashboard-container my-adslist">
                    <h3 class="widget-header">账号管理：<a style="font-size: small;float: right">共${page.pages}页 ${page.total}条记录</a></h3>
                    <table class="table table-responsive product-dashboard-table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>用户信息</th>
                            <th class="text-center">状态</th>
                            <th class="text-center">功能</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${users}" varStatus="index">
                        <tr>

                            <td class="product-thumb">
                                <span>${index.index+1}</span>
                            </td>
                            <td class="product-details" style="width: 300px">
                                <span class="add-id"><strong>用户名:</strong> ${user.userName}</span>
                                <c:if test="${user.reserve1==0}">
                                    <span><strong>性别: </strong><time>女</time> </span>
                                </c:if>
                                <c:if test="${user.reserve1!=0}">
                                    <span><strong>性别: </strong><time>男</time> </span>
                                </c:if>
                            </td>
                            <c:if test="${user.enabled==0}">
                                <td class="product-category"><span class="categories">已禁用</span></td>
                            </c:if>
                            <c:if test="${user.enabled!=0}">
                                <td class="product-category"><span class="categories">可用</span></td>
                            </c:if>
                            <td class="action" data-title="Action">
                                <div class="" >
                                    <ul class="list-inline justify-content-center">
                                        <c:if test="${user.enabled==0}">
                                            <li class="list-inline-item">
                                                <a class="edit" style="cursor: pointer" onclick="banUser(${user.id},1,${page.pageNum})" >
                                                    <i class="fa fa-unlock" ></i>
                                                </a>
                                            </li>
                                        </c:if>
                                        <c:if test="${user.enabled!=0}">
                                            <li class="list-inline-item">
                                                <a class="delete"  style="cursor: pointer" onclick="banUser(${user.id},0,${page.pageNum})">
                                                    <i class="fa fa-unlock-alt"></i>
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
                <div class="pagination justify-content-center">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" id="prePage" style="cursor: pointer" onclick="changePage(1)" >首页</a></li>
                            <li class="page-item">
                                <a class="page-link" style="cursor: pointer" onclick="changePage(${page.prePage})" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <li class="page-item active"><a id="pageNum" class="page-link" style="cursor: pointer">${page.pageNum}</a></li>
                            <li class="page-item">
                                <a class="page-link" style="cursor: pointer" onclick="changePage(${page.nextPage})" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" style="cursor: pointer" onclick="changePage(${page.pages})">尾页</a></li>
                        </ul>
                    </nav>
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
