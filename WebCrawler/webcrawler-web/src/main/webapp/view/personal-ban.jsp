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
                                <li class="active"><a style="cursor: pointer" ><i class="fa fa-bolt"></i> 爬虫控制 </a></li>
                                <li><a href=""><i class="fa fa-cog"></i> 用户管理 </a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
                <!-- Recently Favorited -->
                <div class="widget dashboard-container my-adslist">
                    <h3 class="widget-header">My Ads</h3>
                    <table class="table table-responsive product-dashboard-table">
                        <thead>
                        <tr>
                            <th>Image</th>
                            <th>Product Title</th>
                            <th class="text-center">Category</th>
                            <th class="text-center">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>

                            <td class="product-thumb">
                                <img width="80px" height="auto" src="images/products/products-1.jpg" alt="image description"></td>
                            <td class="product-details">
                                <h3 class="title">Macbook Pro 15inch</h3>
                                <span class="add-id"><strong>Ad ID:</strong> ng3D5hAMHPajQrM</span>
                                <span><strong>Posted on: </strong><time>Jun 27, 2017</time> </span>
                                <span class="status active"><strong>Status</strong>Active</span>
                                <span class="location"><strong>Location</strong>Dhaka,Bangladesh</span>
                            </td>
                            <td class="product-category"><span class="categories">Laptops</span></td>
                            <td class="action" data-title="Action">
                                <div class="">
                                    <ul class="list-inline justify-content-center">
                                        <li class="list-inline-item">
                                            <a class="edit" href="">
                                                <i class="fa fa-clipboard"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item">
                                            <a class="delete" href="">
                                                <i class="fa fa-trash"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td class="product-thumb">
                                <img width="80px" height="auto" src="images/products/products-2.jpg" alt="image description"></td>
                            <td class="product-details">
                                <h3 class="title">Study Table Combo</h3>
                                <span class="add-id"><strong>Ad ID:</strong> ng3D5hAMHPajQrM</span>
                                <span><strong>Posted on: </strong><time>Feb 12, 2017</time> </span>
                                <span class="status active"><strong>Status</strong>Active</span>
                                <span class="location"><strong>Location</strong>USA</span>
                            </td>
                            <td class="product-category"><span class="categories">Laptops</span></td>
                            <td class="action" data-title="Action">
                                <div class="">
                                    <ul class="list-inline justify-content-center">
                                        <li class="list-inline-item">
                                            <a class="edit" href="">
                                                <i class="fa fa-clipboard"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item">
                                            <a class="delete" href="">
                                                <i class="fa fa-trash"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td class="product-thumb">
                                <img width="80px" height="auto" src="images/products/products-3.jpg" alt="image description"></td>
                            <td class="product-details">
                                <h3 class="title">Macbook Pro 15inch</h3>
                                <span class="add-id"><strong>Ad ID:</strong> ng3D5hAMHPajQrM</span>
                                <span><strong>Posted on: </strong><time>Jun 27, 2017</time> </span>
                                <span class="status active"><strong>Status</strong>Active</span>
                                <span class="location"><strong>Location</strong>Dhaka,Bangladesh</span>
                            </td>
                            <td class="product-category"><span class="categories">Laptops</span></td>
                            <td class="action" data-title="Action">
                                <div class="">
                                    <ul class="list-inline justify-content-center">
                                        <li class="list-inline-item">
                                            <a class="edit" href="">
                                                <i class="fa fa-clipboard"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item">
                                            <a class="delete" href="">
                                                <i class="fa fa-trash"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td class="product-thumb">
                                <img width="80px" height="auto" src="images/products/products-4.jpg" alt="image description"></td>
                            <td class="product-details">
                                <h3 class="title">Macbook Pro 15inch</h3>
                                <span class="add-id"><strong>Ad ID:</strong> ng3D5hAMHPajQrM</span>
                                <span><strong>Posted on: </strong><time>Jun 27, 2017</time> </span>
                                <span class="status active"><strong>Status</strong>Active</span>
                                <span class="location"><strong>Location</strong>Dhaka,Bangladesh</span>
                            </td>
                            <td class="product-category"><span class="categories">Laptops</span></td>
                            <td class="action" data-title="Action">
                                <div class="">
                                    <ul class="list-inline justify-content-center">
                                        <li class="list-inline-item">
                                            <a class="edit" href="">
                                                <i class="fa fa-clipboard"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item">
                                            <a class="delete" href="">
                                                <i class="fa fa-trash"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr>

                            <td class="product-thumb">
                                <img width="80px" height="auto" src="images/products/products-1.jpg" alt="image description"></td>
                            <td class="product-details">
                                <h3 class="title">Macbook Pro 15inch</h3>
                                <span class="add-id"><strong>Ad ID:</strong> ng3D5hAMHPajQrM</span>
                                <span><strong>Posted on: </strong><time>Jun 27, 2017</time> </span>
                                <span class="status active"><strong>Status</strong>Active</span>
                                <span class="location"><strong>Location</strong>Dhaka,Bangladesh</span>
                            </td>
                            <td class="product-category"><span class="categories">Laptops</span></td>
                            <td class="action" data-title="Action">
                                <div class="">
                                    <ul class="list-inline justify-content-center">
                                        <li class="list-inline-item">
                                            <a class="edit" href="">
                                                <i class="fa fa-clipboard"></i>
                                            </a>
                                        </li>
                                        <li class="list-inline-item">
                                            <a class="delete" href="">
                                                <i class="fa fa-trash"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
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
