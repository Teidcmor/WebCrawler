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
    <title>${details.district}&nbsp;${details.community}&nbsp;${details.houseModel}</title>

    <link href="plugins/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <!-- JAVASCRIPTS -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script src="plugins/bootstrap/dist/js/popper.min.js"></script>
    <script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>

    <script>
        function goPersonal() {
            var path = "<%=basePath%>";
            window.open(path+"user/goPersonal.do");
        }
    </script>

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
                                <a class="nav-link login-button" id="personal" style="cursor: pointer" onclick="goPersonal()">个人中心</a>
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
                            <li class="list-inline-item"><i class="fa fa-location-arrow"></i> 信息来源：<a >蛋壳公寓</a></li>
                        </ul>
                    </div>
                    <div id="carouselExampleIndicators" class="product-slider carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <c:forEach var="index" begin="1" end="${fn:length(details.pictures)}">
                                <c:if test="${index==1}">
                                    <li data-target="#carouselExampleIndicators" data-slide-to="1" class="active"></li>
                                </c:if>
                                <c:if test="${index!=1}">
                                <li data-target="#carouselExampleIndicators" data-slide-to="${index}"></li>
                                </c:if>
                            </c:forEach>


                        </ol>
                        <div class="carousel-inner">
                            <c:forEach var="coreData" items="${details.pictures}" varStatus="index">
                                <c:if test="${index.first}">
                                    <div class="carousel-item active">
                                        <img class="d-block w-100" src="${coreData}"   height="450px" alt="First slide">
                                    </div>
                                </c:if>
                                <c:if test="${!index.first}">
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="${coreData}"   height="450px" alt="First slide">
                                </div>
                                </c:if>
                            </c:forEach>
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
                <div class="widget disclaimer">
                    <h5 class="widget-header">位置信息：</h5>
                    <ul>
                        <li>市：${details.city}</li>
                        <li>行政区：${details.district}</li>
                        <li>街道：${details.region}</li>
                        <li>小区：${details.community}</li>
                    </ul>
                </div>
                <div class="widget disclaimer">
                    <h5 class="widget-header">房间信息：</h5>
                    <ul>
                        <li>户型：${details.houseModel}</li>
                        <li>朝向：${details.toward}</li>
                        <li>面积：约${details.area}m²</li>
                        <li>楼层：${details.floor}</li>
                        <c:if test="${details.otherDetails!=null and details.otherDetails!=''}">
                        <li>其他：${details.otherDetails}</li>
                        </c:if>
                    </ul>
                </div>
                <div class="widget disclaimer">
                    <h5 class="widget-header">价格：</h5>
                    <ul>
                        <li>价格：${details.price}元/月</li>
                        <c:if test="${details.preference!=null and details.preference!=''}">
                            <li>优惠信息：${details.preference}元/月</li>
                        </c:if>
                    </ul>
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
