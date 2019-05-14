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
    <title>租房信息爬取平台</title>

    <link href="plugins/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body class="body-wrapper">

<section>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar navbar-expand-lg  navigation">
                    <a class="navbar-brand" href="index.html">
                        <!--<img src="images/logo.png" alt="">-->
                        租房信息爬取平台
                    </a>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                        <ul class="navbar-nav ml-auto mt-10">
                            <li class="nav-item">
                                <a class="nav-link login-button" id="personal" style="cursor: pointer">个人中心</a>
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
                            <img src="images/user/user-thumb.jpg" alt="" class="rounded-circle">
                        </div>
                        <!-- User Name -->
                        <h5 class="text-center">Samanta Doe</h5>
                        <p>Joined February 06, 2017</p>
                        <a href="user-profile.html" class="btn btn-main-sm">Edit Profile</a>
                    </div>
                    <!-- Dashboard Links -->
                    <div class="widget user-dashboard-menu">
                        <ul>
                            <li><a href="dashboard-my-ads.html"><i class="fa fa-user"></i> My Ads</a></li>
                            <li>
                                <a href="dashboard-favourite-ads.html"><i class="fa fa-bookmark-o"></i> Favourite Ads <span>5</span></a>
                            </li>
                            <li class="active" >
                                <a href="dashboard-archived-ads.html"><i class="fa fa-file-archive-o"></i>Archeved Ads <span>12</span></a>
                            </li>
                            <li>
                                <a href="dashboard-pending-ads.html"><i class="fa fa-bolt"></i> Pending Approval<span>23</span></a>
                            </li>
                            <li>
                                <a href="logout.html"><i class="fa fa-cog"></i> Logout</a>
                            </li>
                            <li>
                                <a href="delete-account.html"><i class="fa fa-power-off"></i>Delete Account</a>
                            </li>
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
<!-- JAVASCRIPTS -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="plugins/bootstrap/dist/js/popper.min.js"></script>
<script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>

</body>

</html>
