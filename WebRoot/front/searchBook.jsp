<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html class="no-js">
<head>
    <title>图书管理系统</title>
    <!-- Bootstrap -->
	<link href="../support/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="../support/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
	<link href="../support/vendors/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
	<link href="../support/assets/styles.css" rel="stylesheet" media="screen">
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="../support/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<style type="text/css">
	html body {
		font-family:微软雅黑;
		font-size:14px;
	}
</style>
</head>
    
    <body>
<jsp:include page="../top.jsp" flush="true" />
        <!-- 左侧菜单 -->
        <div class="container-fluid">
            <div class="row-fluid">
<jsp:include page="../left.jsp" flush="true" />
                <!--/span-->
                <div class="span9" id="content">
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">书目检索</div>
                            </div>
                            <div class="block-content collapse in">
                            <!-- content start -->
<form action="./searchResult" class="form-inline" style="text-align:center;padding-top:150px;padding-bottom:200px;">
  <div class="form-group">
  	<select class="form-control" name="select" style="width:100px;">
	  <option value="0">书名</option>
	  <option value="1">作者</option>
	</select>
    <input name="search" type="text" style="width:300px;" class="form-control" id="exampleInputName2" placeholder="请输入图书相关内容">
    <button type="submit" style="width:70px;" class="btn btn-default">搜索</button>
  </div>
</form>
                            <!-- content end -->
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                </div>
            </div>
            <hr>
            <footer>
            </footer>
        </div>
        <!--/.fluid-container-->
        <script src="../support/vendors/jquery-1.9.1.min.js"></script>
        <script src="../support/bootstrap/js/bootstrap.min.js"></script>
        <script src="../support/vendors/easypiechart/jquery.easy-pie-chart.js"></script>
        <script src="../support/assets/scripts.js"></script>
        <script>
        $(function() {
            // Easy pie charts
            $('.chart').easyPieChart({animate: 1000});
            $('#li1').addClass('active');
        });
        </script>
    </body>

</html>