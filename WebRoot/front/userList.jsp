<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html class="no-js">
<head>
    <title>图书管理系统</title>
  
	<link href="../support/assets/styles.css" rel="stylesheet" media="screen">
	<!-- HTML5 shim, for IE6-8 ../support of HTML5 elements -->
	<!--[if lt IE 9]>
	    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="../support/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<style type="text/css">
	html body {
		font-family:微软雅黑;
		font-size:14px;
	}
	html a{
		color:black;
		cursor: pointer;
	}
	.bor {
		width:96%;
		margin-left:2%;
		height:auto;
	}
	.book {
		width:250px;
		height:300px;
		margin-left:40px;
		margin-top:10px;
		border:1px solid #ededed;
		float:left;
	}
	.pic {
		text-align:center;
	}
	.pic img {
		height:230px;
		width:auto;
		margin-top:20px;
	}
	.bookname {
		text-align:center;
		width:90%;
		margin-left:5%;
		margin-top:5px;
	}
	.bookname span {
		color:ddd;
	}
	.mainList{
		position:relative;  
 		top:50px;  
 		left:0px;
	}
</style>
</head>
    
    <body>
   
<jsp:include page="../top.jsp"/>

      
<div class="mainList"  >        
<c:if test="${userList != null}">
	<div class="table-responsive">
	<table class="table table-hover">
	<tr>
	<td colspan="7">
	<font size="4">用户列表</font>
	</td>
	</tr>
	<tr>
	<td colspan="7">
	<input type="button" onclick="location='userEdit.html'" value="增加" class="btn btn-primary btn-lg btn-block"></input>
	</td>
	</tr>
	<tr>
	<td>用户名</td>
	<td>姓名</td>
	<td>借车次数</td>
	<td>账户类型</td>
	<td>操作</td>
	</tr>
		<c:forEach items="${userList}" var="userList" varStatus="st">
			<tr>
				<td>${userList.userName}</td>
				<td>${userList.realName}</td>
				<td>${userList.realName}</td>
				<td>
				<c:if test="${userList.userType==1}">管理员</c:if>
				<c:if test="${userList.userType==0}">用户</c:if>
				</td>
				<td><a href="borrowrecordEdit.html?bicycleId=0&userId=${userList.id}">借车</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
</c:if>
                           
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