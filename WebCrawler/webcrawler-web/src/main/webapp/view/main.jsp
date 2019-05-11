<%@ page import="userInfo.dto.UserInfoDTO" %><%--
  Created by IntelliJ IDEA.
  User: WZH
  Date: 2019/4/16
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha256-pasqAKBDmFT4eHoN2ndd6lN370kFiGUFyTiUHWhU7k8=" crossorigin="anonymous"></script>


    <script >

        $(document).ready(function(){
            $(function () {
                alert("test")
            });
        });


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
                                <a class="nav-link login-button" id="personal">个人中心</a>
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
                    <form id="search" action="/coreData/getCoreDataPage.do" method="post">
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <input type="text" class="form-control" id="inputtext4"
                                       placeholder="市：例如 杭州">
                            </div>
                            <div class="form-group col-md-3">
                                <input type="text" class="form-control" id="inputCategory4" placeholder="行政区：例如 滨江区">
                            </div>
                            <div class="form-group col-md-3">
                                <input type="text" class="form-control" id="inputLocation4" placeholder="街道：例如 浦沿">
                            </div>
                            <div class="form-group col-md-2">

                                <button type="submit" class="btn btn-primary">搜索</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="section-sm">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="category-sidebar">
                    <div class="widget category-list">
                        <h4 class="widget-header">价格区间：</h4>
                        <ul class="category-list">
                            <li><a href="category.html"><1000元 <span>93</span></a></li>
                            <li><a href="category.html"><2000元 <span>233</span></a></li>
                            <li><a href="category.html"><3000元 <span>183</span></a></li>
                            <li><a href="category.html">>3000元 <span>343</span></a></li>
                        </ul>
                    </div>

                    <div class="widget category-list">
                        <h4 class="widget-header">房间朝向：</h4>
                        <ul class="category-list">
                            <li><a href="category.html">南 <span>93</span></a></li>
                            <li><a href="category.html">北 <span>233</span></a></li>
                            <li><a href="category.html">东 <span>183</span></a></li>
                            <li><a href="category.html">西 <span>120</span></a></li>
                        </ul>
                    </div>

                    <div class="widget category-list">
                        <h4 class="widget-header">房间面积：</h4>
                        <ul class="category-list">
                            <li><a href="category.html"><10 <span>93</span></a></li>
                            <li><a href="category.html"><20 <span>233</span></a></li>
                            <li><a href="category.html"><30 <span>183</span></a></li>
                            <li><a href="category.html">>30 <span>120</span></a></li>
                        </ul>
                    </div>
                    <div class="widget price-range">
                        <h4 class="widget-header">自定义价格区间</h4>
                        <div class="block">
                            <input id="ex2" type="text" class="span2" value="" data-slider-min="10"
                                   data-slider-max="1000" data-slider-step="5" data-slider-value="[250,450]"/>
                            <br/><b>-</b><br/>
                            <input id="ex3" type="text" class="span2" value="" data-slider-min="10"
                                   data-slider-max="1000" data-slider-step="5" data-slider-value="[250,450]"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="category-search-filter">
                    <div class="row">
                        <div class="col-md-6">
                            <strong>排序：</strong>
                            <select>
                                <option>综合排序</option>
                                <option value="1">综合排序</option>
                                <option value="2">低价优先</option>
                                <option value="4">好房优先</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="product-grid-list">
                    <div class="row mt-30">

                        <c:forEach var="coreData" items="${coreDatas}">

                            <div class="col-sm-12 col-lg-4 col-md-6">
                                <div class="product-item bg-light">
                                    <div class="card">
                                        <div class="thumb-content">
                                            <a href="">
                                                <img class="card-img-top img-fluid"
                                                     src="${coreData.pictureUrl}"
                                                     alt="Card image cap">
                                            </a>
                                        </div>
                                        <div class="card-body">
                                            <h4 class="card-title"><a href="">${coreData.district}&nbsp;${coreData.community}&nbsp;${coreData.houseModel}</a></h4>
                                            <ul class="list-inline product-meta">
                                                <li class="list-inline-item">
                                                    <a href="">小区：${coreData.community}</a>
                                                </li>
                                                <li class="list-inline-item">
                                                    <a href="">面积：约${coreData.area}㎡</a>
                                                </li>
                                            </ul>
                                            <ul class="list-inline product-meta">
                                                <li class="list-inline-item">
                                                    <a href="">朝向：${coreData.toward}</a>
                                                </li>
                                                <li class="list-inline-item">
                                                    <a href="">户型：${coreData.houseModel}</a>
                                                </li>
                                            </ul>
                                            <p class="card-text">${coreData.price} 元/月</p>
                                            <p class="card-text">来源：蛋壳</p>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>

                    </div>
                </div>
                <div class="pagination justify-content-center">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">${page.prePage}</a></li>
                            <li class="page-item active"><a class="page-link" href="#">${page.pageNum}</a></li>
                            <li class="page-item"><a class="page-link" href="#">${page.nextPage}</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</section>
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
    <div class="top-to">
        <a id="top" class="" href=""><i class="fa fa-angle-up"></i></a>
    </div>
</footer>
</body>

</html>
