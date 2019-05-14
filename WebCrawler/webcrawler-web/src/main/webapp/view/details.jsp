<%--
  Created by IntelliJ IDEA.
  User: WZH
  Date: 2019/5/10
  Time: 19:12
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

    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
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
<section class="page-search">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <!-- Advance Search -->
                <div class="advance-search">
                    <form id="searchForm" action="/coreData/getCoreDataPage.do" method="post">
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <input type="text" class="form-control" id="city" name="city" value="${queryCity}" placeholder="市：例如 杭州">
                            </div>
                            <div class="form-group col-md-3">
                                <input type="text" class="form-control" id="district" name="district" value="${queryDistrict}" placeholder="行政区：例如 滨江区">
                            </div>
                            <div class="form-group col-md-3">
                                <input type="text" class="form-control" id="region"  name="region"  value="${queryRegion}" placeholder="街道：例如 浦沿">
                            </div>
                            <div class="form-group col-md-2">
                                <button id="search" type="submit" class="btn btn-primary">搜索</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--===================================
=            Store Section            =
====================================-->
<section class="section bg-gray">
    <!-- Container Start -->
    <div class="container">
        <div class="row">
            <!-- Left sidebar -->
            <div class="col-md-8">
                <div class="product-details">
                    <h1 class="product-title">${details.district}&nbsp;${details.community}&nbsp;${details.houseModel}</h1>
                    <div class="product-meta">
                        <ul class="list-inline">
                            <li class="list-inline-item"><i class="fa fa-location-arrow"></i> 信息来源：<a href="">蛋壳公寓</a></li>
                        </ul>
                    </div>
                    <div id="carouselExampleIndicators" class="product-slider carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">

                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>

                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="d-block w-100" src="https://public.danke.com.cn/public-20190123-isz_FqsmPgvSxOShhOhWysBTxXDnuly8-roomPcDetail.jpg"   height="450px" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="https://public.danke.com.cn/public-20190124-isz_FgNeeDgg-NzCyfqzn4uXr1S_zPXx-roomPcDetail.jpg"    height="450px" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="https://public.danke.com.cn/public-20190124-isz_FgNeeDgg-NzCyfqzn4uXr1S_zPXx-roomPcDetail.jpg"   height="450px" alt="Third slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="https://public.danke.com.cn/public-20190123-isz_FqsmPgvSxOShhOhWysBTxXDnuly8-roomPcDetail.jpg" height="450px" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="https://public.danke.com.cn/public-20190123-isz_FqsmPgvSxOShhOhWysBTxXDnuly8-roomPcDetail.jpg"  height="450px" alt="First slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="widget rate">
                    <h5 class="widget-header text-center">What would you rate
                        <br>
                        this product</h5>
                    <div class="starrr"></div>
                </div>
                <div class="widget disclaimer">
                    <h5 class="widget-header">Safety Tips</h5>
                    <ul>
                        <li>Meet seller at a public place</li>
                        <li>Check the item before you buy</li>
                        <li>Pay only after collecting the item</li>
                        <li>Pay only after collecting the item</li>
                    </ul>
                </div>
                <!-- Coupon Widget -->
                <div class="widget coupon text-center">
                    <!-- Coupon description -->
                    <p>Have a great product to post ? Share it with
                        your fellow users.
                    </p>
                    <!-- Submii button -->
                    <a href="" class="btn btn-transparent-white">Submit Listing</a>
                </div>

            </div>
        </div>

    </div>
    </div>
    <!-- Container End -->
</section>
<!--============================
=            Footer            =
=============================-->
<!-- Footer Bottom -->
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
