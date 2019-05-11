<%@ page import="userInfo.dto.UserInfoDTO" %><%--
  Created by IntelliJ IDEA.
  User: WZH
  Date: 2019/4/16
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();
    String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%=basePath%></title>

    <!-- PLUGINS CSS STYLE -->
    <link href="plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="plugins/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- Owl Carousel -->
    <link href="plugins/slick-carousel/slick/slick.css" rel="stylesheet">
    <link href="plugins/slick-carousel/slick/slick-theme.css" rel="stylesheet">
    <!-- Fancy Box -->
    <link href="plugins/fancybox/jquery.fancybox.pack.css" rel="stylesheet">
    <link href="plugins/jquery-nice-select/css/nice-select.css" rel="stylesheet">
    <link href="plugins/seiyria-bootstrap-slider/dist/css/bootstrap-slider.min.css" rel="stylesheet">
    <!-- CUSTOM CSS -->
    <link href="css/style.css" rel="stylesheet">

    <!-- FAVICON -->
    <link href="img/favicon.png" rel="shortcut icon">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                    <!--<button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>-->
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <!--<ul class="navbar-nav ml-auto main-nav ">
                            <li class="nav-item active">
                                <a class="nav-link" href="index.html">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="dashboard.html">Dashboard</a>
                            </li>
                            <li class="nav-item dropdown dropdown-slide">
                                <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true"
                                   aria-expanded="false">
                                    Pages <span><i class="fa fa-angle-down"></i></span>
                                </a>
                                &lt;!&ndash; Dropdown list &ndash;&gt;
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a class="dropdown-item" href="category.html">Category</a>
                                    <a class="dropdown-item" href="single.html">Single Page</a>
                                    <a class="dropdown-item" href="store-single.html">Store Single</a>
                                    <a class="dropdown-item" href="dashboard.html">Dashboard</a>
                                    <a class="dropdown-item" href="user-profile.html">User Profile</a>
                                    <a class="dropdown-item" href="submit-coupon.html">Submit Coupon</a>
                                    <a class="dropdown-item" href="blog.html">Blog</a>
                                    <a class="dropdown-item" href="single-blog.html">Single Post</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown dropdown-slide">
                                <a class="nav-link dropdown-toggle" href="" data-toggle="dropdown" aria-haspopup="true"
                                   aria-expanded="false">
                                    Listing <span><i class="fa fa-angle-down"></i></span>
                                </a>
                                &lt;!&ndash; Dropdown list &ndash;&gt;
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a class="dropdown-item" href="#">Action</a>
                                    <a class="dropdown-item" href="#">Another action</a>
                                    <a class="dropdown-item" href="#">Something else here</a>
                                </div>
                            </li>
                        </ul>-->
                        <ul class="navbar-nav ml-auto mt-10">
                            <li class="nav-item">
                                <a class="nav-link login-button" href="index.html">个人中心</a>
                            </li>
                            <!--<li class="nav-item">
                                <a class="nav-link add-button" href="#"><i class="fa fa-plus-circle"></i> Add
                                    Listing</a>
                            </li>-->
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
                    <form action="/initialUrl/spiderBegin.do" method="get">
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
        <!--<div class="row">
            <div class="col-md-12">
                <div class="search-result bg-gray">
                    <h2>Results For "Electronics"</h2>
                    <p>123 Results on 12 December, 2017</p>
                </div>
            </div>
        </div>-->
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

                    <!--<div class="widget filter">
                        <h4 class="widget-header">Show Produts</h4>
                        <select>
                            <option>Popularity</option>
                            <option value="1">Top rated</option>
                            <option value="2">Lowest Price</option>
                            <option value="4">Highest Price</option>
                        </select>
                    </div>-->

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

                    <!-- <div class="widget product-shorting">
                         <h4 class="widget-header">By Condition</h4>
                         <div class="form-check">
                             <label class="form-check-label">
                                 <input class="form-check-input" type="checkbox" value="">
                                 Brand New
                             </label>
                         </div>
                         <div class="form-check">
                             <label class="form-check-label">
                                 <input class="form-check-input" type="checkbox" value="">
                                 Almost New
                             </label>
                         </div>
                         <div class="form-check">
                             <label class="form-check-label">
                                 <input class="form-check-input" type="checkbox" value="">
                                 Gently New
                             </label>
                         </div>
                         <div class="form-check">
                             <label class="form-check-label">
                                 <input class="form-check-input" type="checkbox" value="">
                                 Havely New
                             </label>
                         </div>
                     </div>-->

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
                        <div class="col-sm-12 col-lg-4 col-md-6">
                            <!-- product card -->
                            <div class="product-item bg-light">
                                <div class="card">
                                    <div class="thumb-content">
                                        <!-- <div class="price">$200</div> -->
                                        <a href="">
                                            <img class="card-img-top img-fluid"
                                                 src="https://public.danke.com.cn/public-20181110-Fq0FzvA5Gs77o9iT6VV0U5Rnzogu-roomPcDetail.jpg"
                                                 alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title"><a href="">11inch Macbook Air</a></h4>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href="">小区：湘云雅苑</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href="">面积：约14㎡</a>
                                            </li>
                                        </ul>
                                        <li>
                                            <ul></ul>
                                        </li>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href="">朝向：南</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href="">户型：4室1卫</a>
                                            </li>
                                        </ul>
                                        <p class="card-text">1930 元/月</p>
                                        <p class="card-text">来源：蛋壳</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-4 col-md-6">
                            <!-- product card -->
                            <div class="product-item bg-light">
                                <div class="card">
                                    <div class="thumb-content">
                                        <!-- <div class="price">$200</div> -->
                                        <a href="">
                                            <img class="card-img-top img-fluid"
                                                 src="https://public.danke.com.cn/public-20181016-lm6yrqq_rwGze9KZXh1KV3jmu-Kl-roomPcDetail.jpg"
                                                 alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title"><a href="">11inch Macbook Air</a></h4>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>湘云雅苑</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>约14㎡</a>
                                            </li>
                                        </ul>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>朝向：南</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>4室1卫</a>
                                            </li>
                                        </ul>
                                        <p class="card-text">1930 元/月</p>
                                        <p class="card-text">来源：蛋壳</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-4 col-md-6">
                            <!-- product card -->
                            <div class="product-item bg-light">
                                <div class="card">
                                    <div class="thumb-content">
                                        <!-- <div class="price">$200</div> -->
                                        <a href="">
                                            <img class="card-img-top img-fluid"
                                                 src="https://public.danke.com.cn/public-20181016-liFe8lpcgVv1ZmA91v7L0H7-voPA-roomPcDetail.jpg"
                                                 alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title"><a href="">11inch Macbook Air</a></h4>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>湘云雅苑</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>约14㎡</a>
                                            </li>
                                        </ul>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>朝向：南</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>4室1卫</a>
                                            </li>
                                        </ul>
                                        <p class="card-text">1930 元/月</p>
                                        <p class="card-text">来源：蛋壳</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-4 col-md-6">
                            <!-- product card -->
                            <div class="product-item bg-light">
                                <div class="card">
                                    <div class="thumb-content">
                                        <!-- <div class="price">$200</div> -->
                                        <a href="">
                                            <img class="card-img-top img-fluid"
                                                 src="https://public.danke.com.cn/public-20181011-lp993kNC0sO5ieLFxWxKtU-HAjn8-roomPcDetail.jpg"
                                                 alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title"><a href="">11inch Macbook Air</a></h4>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>湘云雅苑</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>约14㎡</a>
                                            </li>
                                        </ul>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>朝向：南</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>4室1卫</a>
                                            </li>
                                        </ul>
                                        <p class="card-text">1930 元/月</p>
                                        <p class="card-text">来源：蛋壳</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-4 col-md-6">
                            <!-- product card -->
                            <div class="product-item bg-light">
                                <div class="card">
                                    <div class="thumb-content">
                                        <!-- <div class="price">$200</div> -->
                                        <a href="">
                                            <img class="card-img-top img-fluid"
                                                 src="https://public.danke.com.cn/public-20181110-Fq0FzvA5Gs77o9iT6VV0U5Rnzogu-roomPcDetail.jpg"
                                                 alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title"><a href="">11inch Macbook Air</a></h4>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>湘云雅苑</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>约14㎡</a>
                                            </li>
                                        </ul>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>朝向：南</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>4室1卫</a>
                                            </li>
                                        </ul>
                                        <p class="card-text">1930 元/月</p>
                                        <p class="card-text">来源：蛋壳</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-4 col-md-6">
                            <!-- product card -->
                            <div class="product-item bg-light">
                                <div class="card">
                                    <div class="thumb-content">
                                        <!-- <div class="price">$200</div> -->
                                        <a href="">
                                            <img class="card-img-top img-fluid"
                                                 src="https://public.danke.com.cn/public-20181110-Fq0FzvA5Gs77o9iT6VV0U5Rnzogu-roomPcDetail.jpg"
                                                 alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title"><a href="">11inch Macbook Air</a></h4>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>湘云雅苑</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>约14㎡</a>
                                            </li>
                                        </ul>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>朝向：南</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>4室1卫</a>
                                            </li>
                                        </ul>
                                        <p class="card-text">1930 元/月</p>
                                        <p class="card-text">来源：蛋壳</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-4 col-md-6">
                            <!-- product card -->
                            <div class="product-item bg-light">
                                <div class="card">
                                    <div class="thumb-content">
                                        <!-- <div class="price">$200</div> -->
                                        <a href="">
                                            <img class="card-img-top img-fluid"
                                                 src="https://public.danke.com.cn/public-20181110-Fq0FzvA5Gs77o9iT6VV0U5Rnzogu-roomPcDetail.jpg"
                                                 alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title"><a href="">11inch Macbook Air</a></h4>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>湘云雅苑</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>约14㎡</a>
                                            </li>
                                        </ul>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>朝向：南</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>4室1卫</a>
                                            </li>
                                        </ul>
                                        <p class="card-text">1930 元/月</p>
                                        <p class="card-text">来源：蛋壳</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-4 col-md-6">
                            <!-- product card -->
                            <div class="product-item bg-light">
                                <div class="card">
                                    <div class="thumb-content">
                                        <!-- <div class="price">$200</div> -->
                                        <a href="">
                                            <img class="card-img-top img-fluid"
                                                 src="https://public.danke.com.cn/public-20181110-Fq0FzvA5Gs77o9iT6VV0U5Rnzogu-roomPcDetail.jpg"
                                                 alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title"><a href="">11inch Macbook Air</a></h4>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>湘云雅苑</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>约14㎡</a>
                                            </li>
                                        </ul>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>朝向：南</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>4室1卫</a>
                                            </li>
                                        </ul>
                                        <p class="card-text">1930 元/月</p>
                                        <p class="card-text">来源：蛋壳</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-4 col-md-6">
                            <!-- product card -->
                            <div class="product-item bg-light">
                                <div class="card">
                                    <div class="thumb-content">
                                        <!-- <div class="price">$200</div> -->
                                        <a href="">
                                            <img class="card-img-top img-fluid"
                                                 src="https://public.danke.com.cn/public-20181110-Fq0FzvA5Gs77o9iT6VV0U5Rnzogu-roomPcDetail.jpg"
                                                 alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title"><a href="">11inch Macbook Air</a></h4>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>湘云雅苑</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>约14㎡</a>
                                            </li>
                                        </ul>
                                        <ul class="list-inline product-meta">
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-folder-open-o"></i>朝向：南</a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a href=""><i class="fa fa-calendar"></i>4室1卫</a>
                                            </li>
                                        </ul>
                                        <p class="card-text">1930 元/月</p>
                                        <p class="card-text">来源：蛋壳</p>
                                    </div>
                                </div>
                            </div>
                        </div>
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
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item active"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
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
<!--============================
=            Footer            =
=============================-->
<!--
<footer class="footer section section-sm">
    &lt;!&ndash; Container Start &ndash;&gt;
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-7 offset-md-1 offset-lg-0">
                &lt;!&ndash; About &ndash;&gt;
                <div class="block about">
                    &lt;!&ndash; footer logo &ndash;&gt;
                    <img src="images/logo-footer.png" alt="">
                    &lt;!&ndash; description &ndash;&gt;
                    <p class="alt-color">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                        ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                </div>
            </div>
            &lt;!&ndash; Link list &ndash;&gt;
            <div class="col-lg-2 offset-lg-1 col-md-3">
                <div class="block">
                    <h4>Site Pages</h4>
                    <ul>
                        <li><a href="#">Boston</a></li>
                        <li><a href="#">How It works</a></li>
                        <li><a href="#">Deals & Coupons</a></li>
                        <li><a href="#">Articls & Tips</a></li>
                        <li><a href="#">Terms of Services</a></li>
                    </ul>
                </div>
            </div>
            &lt;!&ndash; Link list &ndash;&gt;
            <div class="col-lg-2 col-md-3 offset-md-1 offset-lg-0">
                <div class="block">
                    <h4>Admin Pages</h4>
                    <ul>
                        <li><a href="#">Boston</a></li>
                        <li><a href="#">How It works</a></li>
                        <li><a href="#">Deals & Coupons</a></li>
                        <li><a href="#">Articls & Tips</a></li>
                        <li><a href="#">Terms of Services</a></li>
                    </ul>
                </div>
            </div>
            &lt;!&ndash; Promotion &ndash;&gt;
            <div class="col-lg-4 col-md-7">
                &lt;!&ndash; App promotion &ndash;&gt;
                <div class="block-2 app-promotion">
                    <a href="">
                        &lt;!&ndash; Icon &ndash;&gt;
                        <img src="images/footer/phone-icon.png" alt="mobile-icon">
                    </a>
                    <p>Get the Dealsy Mobile App and Save more</p>
                </div>
            </div>
        </div>
    </div>
    &lt;!&ndash; Container End &ndash;&gt;
</footer>-->
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
            <!--<div class="col-sm-6 col-12">
                &lt;!&ndash; Social Icons &ndash;&gt;
                <ul class="social-media-icons text-right">
                    <li><a class="fa fa-facebook" href=""></a></li>
                    <li><a class="fa fa-twitter" href=""></a></li>
                    <li><a class="fa fa-pinterest-p" href=""></a></li>
                    <li><a class="fa fa-vimeo" href=""></a></li>
                </ul>
            </div>-->
        </div>
    </div>
    <!-- Container End -->
    <!-- To Top -->
    <div class="top-to">
        <a id="top" class="" href=""><i class="fa fa-angle-up"></i></a>
    </div>
</footer>

<!-- JAVASCRIPTS -->
<script src="plugins/jquery/jquery.min.js"></script>
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="plugins/tether/js/tether.min.js"></script>
<script src="plugins/raty/jquery.raty-fa.js"></script>
<script src="plugins/bootstrap/dist/js/popper.min.js"></script>
<script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="plugins/seiyria-bootstrap-slider/dist/bootstrap-slider.min.js"></script>
<script src="plugins/slick-carousel/slick/slick.min.js"></script>
<script src="plugins/jquery-nice-select/js/jquery.nice-select.min.js"></script>
<script src="plugins/fancybox/jquery.fancybox.pack.js"></script>
<script src="plugins/smoothscroll/SmoothScroll.min.js"></script>

<script src="js/scripts.js"></script>
<%--<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>--%>
</body>

</html>
