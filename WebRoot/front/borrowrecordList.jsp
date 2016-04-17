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
 		top:30px;  
 		left:0px;
	}
</style>
</head>
    
    <body>
   
<jsp:include page="../top.jsp"/>

      
<div class="mainList"  >        
<c:if test="${borrowrecordList != null}">
	<div class="table-responsive">
	<table class="table table-hover">
	<tr>
	<td colspan="7">
	<font size="4"></font>
	</td>
	</tr>
	<tr>
	<td colspan="7">
	<font size="4">借车记录列表</font>
	</td>
	</tr>
	<tr>
	<td colspan="7">
	<button type="button" class="btn btn-primary btn-lg btn-block" onclick="location='borrowrecordEdit.html?bicycleId=0&userId=0'" value="增加" >增  加</button>
	</td>
	</tr>
	<tr>
	<td>用户</td>
	<td>车编号</td>
	<td>时间</td>
	<td>状态</td>
	<td>操作</td>
	</tr>
		<c:forEach items="${borrowrecordList}" var="userList" varStatus="st">
			<tr>
				<td>${userList.userName}</td>
				<td>${userList.bicycleName}</td>
				<td>${userList.borrowTime}</td>
				
				<td>
				<c:if test="${userList.isReturn==1}">已归还</c:if>
				<c:if test="${userList.isReturn==0}">未归还</c:if>
				</td>
				<td><a href="returnBicycle.html?id=${userList.id}">归还</a></td>
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