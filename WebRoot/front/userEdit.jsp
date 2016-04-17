<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js">
<head>
    <title>自行车编辑</title>
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
	a {  
		text-decoration:none;
	}  
	a:link {  
		text-decoration:none;
	}  
	a:visited {  
		text-decoration:none;
	}  
	a:hover {  
		text-decoration:none;
	}  
	a:active {  
		text-decoration:none;
	}  
	.bor {
		width:96%;
		margin-left:2%;
		height:auto;
		border:1px solid #ededed;
		padding:20px 20px 40px;
	}
	.pic {
		width:50%;
		float:left;
	}
	.pic img {
		width:60%;
		margin-left:20%;
		height:auto;
	}
	.content {
		padding:30px 0px;
	}
	.opt {
		width:60%;
		margin-left:20%;
		text-align:center;
	}
	.opt button {
		margin-left:20px;
	}
	.main{
		position:relative;  
 		top:60px;  
 		left:0px;
	}
	td {
		font-size:medium ;
		height:50px;
	}
	table{
		padding:15px;
		border-spacing:20px;
	}
</style>
</head>
    
    <body>
<jsp:include page="../top.jsp" flush="true" />
        <!-- 左侧菜单 -->
       
	<div class="main">
	<form action="saveUser.html" method="post">
	<table class=".table-bordered" width="100%">
	<tr><td  align="center" colspan="2" >用户添加</td></tr>
	<tr>
	<td align="right">
	 用户名：
	</td>
	<td align="left">
		
   <form:input path="userInfo.userName"   value="${userInfo.userName}"/>（初始密码123456）
   </td></tr>
   <tr>
	 <td align="right" width="50%">
	 姓名  ：
	</td>
	<td align="left">
		

 <form:input path="userInfo.realName"   value="${userInfo.realName}"/>
   </td></tr>
   <tr>
	
	</tr>
   
   
    
     <tr><td colspan="2" align="center"> <button type="submit">确定</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.history.back();"></input></td></tr>
    </table>
     </form>
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