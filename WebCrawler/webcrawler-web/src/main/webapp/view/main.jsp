<%--
  Created by IntelliJ IDEA.
  User: WZH
  Date: 2019/4/16
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%String path = request.getContextPath();
    String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html id="html" lang="en">
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

    <script >


        /*分页功能*/
        function getCoreDataByPage(pageNum) {
            var page = pageNum;
            if(page <=0 )
                page = 1;
            /*$.post("/coreData/changePages.do",{
                pageNum:page
            },function (data,status) {
                document.write(data);
                document.close();
            });*/
            var form = document.createElement("form");
            form.target='_self';
            form.method='POST';
            form.action='/coreData/changePages.do';
            var pageInput = document.createElement("input");
            pageInput.name="pageNum";
            pageInput.value=page;
            // 附加到Form
            form.append(pageInput);
            document.body.appendChild(form);
            form.submit();
        }

        /*根据价格分段搜索功能*/
        function getCoreDataByPrice(price) {
            var p = price;
            /*$.post("/coreData/getCoreDataByPrice.do",{
                price:p
            },function (data,status) {
                document.write(data);
                document.close();
            });*/
            var form = document.createElement("form");
            form.target='_self';
            form.method='POST';
            form.action='/coreData/getCoreDataByPrice.do';
            var priceInput = document.createElement("input");
            priceInput.name="price";
            priceInput.value=p;
            // 附加到Form
            form.append(priceInput);
            document.body.appendChild(form);
            form.submit();
        }

        /*根据房间面积分段搜索功能*/
        function getCoreDataByArea(area) {
            var p = area;
            /*$.post("/coreData/getCoreDataByArea.do",{
                area:p
            },function (data,status) {
                document.write(data);
                document.close();
            });*/
            var form = document.createElement("form");
            form.target='_self';
            form.method='POST';
            form.action='/coreData/getCoreDataByArea.do';
            var areaInput = document.createElement("input");
            areaInput.name="area";
            areaInput.value=p;
            // 附加到Form
            form.append(areaInput);
            document.body.appendChild(form);
            form.submit();
        }

        /*根据朝向分段搜索功能*/
        function getCoreDataByToward(toward) {
            var p = toward;
            /*$.post("/coreData/getCoreDataByToward.do",{
                toward:p
            },function (data,status) {
                document.write(data);
                document.close();
            });*/
            var form = document.createElement("form");
            form.target='_self';
            form.method='POST';
            form.action='/coreData/getCoreDataByToward.do';
            var towardInput = document.createElement("input");
            towardInput.name="toward";
            towardInput.value=p;
            // 附加到Form
            form.append(towardInput);
            document.body.appendChild(form);
            form.submit();
        }

        /*设置排序下拉框的当前值*/
        $(function () {
            $('#sort').val(${querySort});
            $("a").css("color","grey");
            $('#price${queryPrice}').css("color","#007bff");
            $('#area${queryArea}').css("color","#007bff");
            $('#toward${queryToward}').css("color","#007bff");

        });

        /*排序下拉框功能*/
       function sortOnChange() {
           var value = $('#sort').val();
           /*$.post("/coreData//getCoreDataSort.do",{
               sort:value
           },function (data,status) {
               document.write(data);
               document.close();
           })*/
           var form = document.createElement("form");
           form.target='_self';
           form.method='POST';
           form.action='/coreData//getCoreDataSort.do';
           var sortInput = document.createElement("input");
           sortInput.name="sort";
           sortInput.value=value;
           // 附加到Form
           form.append(sortInput);
           document.body.appendChild(form);
           form.submit();
       }

       function goDetails(id) {
           var value = id;
           var path = "<%=basePath%>";
           window.open(path+"coreData/goDetails.do?id="+id);
       }

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
                    <a class="navbar-brand">
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
<section id="show" class="section-sm">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="category-sidebar">
                    <div class="widget category-list">
                        <h4 class="widget-header">价格区间：</h4>
                        <ul class="category-list">
                            <li><a id="price1000" style="cursor: pointer" onclick="getCoreDataByPrice(1000)"><=1000元 </a></li>
                            <li><a id="price2000" style="cursor: pointer" onclick="getCoreDataByPrice(2000)"><=2000元 </a></li>
                            <li><a id="price3000" style="cursor: pointer" onclick="getCoreDataByPrice(3000)"><=3000元 </a></li>
                            <li><a id="price0"style="cursor: pointer" onclick="getCoreDataByPrice(0)">不限 </a></li>
                        </ul>
                    </div>

                    <div class="widget category-list">
                        <h4 class="widget-header">房间朝向：</h4>
                        <ul class="category-list">
                            <li><a id="toward1" style="cursor: pointer" onclick="getCoreDataByToward(1)">南 </a></li>
                            <li><a id="toward2" style="cursor: pointer" onclick="getCoreDataByToward(2)">北 </a></li>
                            <li><a id="toward3" style="cursor: pointer" onclick="getCoreDataByToward(3)">东 </a></li>
                            <li><a id="toward4" style="cursor: pointer" onclick="getCoreDataByToward(4)">西 </a></li>
                            <li><a id="toward0" style="cursor: pointer" onclick="getCoreDataByToward(0)">不限 </a></li>
                        </ul>
                    </div>

                    <div class="widget category-list">
                        <h4 class="widget-header">房间面积：</h4>
                        <ul class="category-list">
                            <li><a id="area10" style="cursor: pointer" onclick="getCoreDataByArea(10)">>=10 m²</a></li>
                            <li><a id="area20" style="cursor: pointer" onclick="getCoreDataByArea(20)">>=20 m²</a></li>
                            <li><a id="area30" style="cursor: pointer" onclick="getCoreDataByArea(30)">>=30 m²</a></li>
                            <li><a id="area0" style="cursor: pointer" onclick="getCoreDataByArea(0)">不限 </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="category-search-filter">
                    <div class="row">
                        <div class="col-md-6">
                            <strong>排序：</strong>
                            <select id="sort" onchange="sortOnChange()">
                                <option value="1">综合排序</option>
                                <option value="2">价格升序</option>
                                <option value="3">价格降序</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <div class="view">
                                <a style="font-size: small">共${page.pages}页 ${page.total}条记录</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="product-grid-list">
                    <div class="row mt-30">
                        <c:if test="${fn:length(coreDatas)>0}" >
                            <c:forEach var="coreData" items="${coreDatas}">

                            <div class="col-sm-12 col-lg-4 col-md-6">
                                <div class="product-item bg-light">
                                    <div class="card">
                                        <div class="thumb-content">
                                            <a onclick="goDetails(${coreData.id})" style="cursor: pointer">
                                                <img class="card-img-top img-fluid"
                                                     src="${coreData.pictureUrl}">
                                            </a>
                                        </div>
                                        <div class="card-body">
                                            <h4 class="card-title" onclick="goDetails(${coreData.id})" style="cursor: pointer"><span>${coreData.district}&nbsp;${coreData.community}&nbsp;${coreData.houseModel}</span></h4>
                                            <ul class="list-inline product-meta">
                                                <li class="list-inline-item">
                                                    <a>小区：${coreData.community}</a>
                                                </li>
                                                <li class="list-inline-item">
                                                    <a>面积：约${coreData.area}㎡</a>
                                                </li>
                                            </ul>
                                            <ul class="list-inline product-meta">
                                                <li class="list-inline-item">
                                                    <a>朝向：${coreData.toward}</a>
                                                </li>
                                                <li class="list-inline-item">
                                                    <a>户型：${coreData.houseModel}</a>
                                                </li>
                                            </ul>
                                            <p class="card-text">${coreData.price} 元/月</p>
                                            <p class="card-text">来源：蛋壳</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        </c:if>
                        <c:if test="${fn:length(coreDatas)<=0}">
                            <p>&nbsp;&nbsp;&nbsp;&nbsp;抱歉！！您的搜索没有结果哦！！</p>
                        </c:if>
                    </div>
                </div>
                <div class="pagination justify-content-center">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" id="prePage" style="cursor: pointer" onclick="getCoreDataByPage(1)" >首页</a></li>
                            <li class="page-item">
                                <a class="page-link" style="cursor: pointer" onclick="getCoreDataByPage(${page.prePage})" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <li class="page-item active"><a id="pageNum" class="page-link" style="cursor: pointer">${page.pageNum}</a></li>
                            <li class="page-item">
                                <a class="page-link" style="cursor: pointer" onclick="getCoreDataByPage(${page.nextPage})" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" style="cursor: pointer" onclick="getCoreDataByPage(${page.pages})">尾页</a></li>
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
</footer>
</body>

</html>
