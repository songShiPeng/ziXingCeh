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
<c:if test="${bicycleList != null}">
	<div class="table-responsive">
	<table class="table table-hover">
	<tr>
	<td colspan="4">
	<font size="4"></font>
	</td>
	</tr>
	<tr>
	<td colspan="4">
	<font size="4">自行车列表</font>
	</td>
	</tr>
	<tr>
	<td colspan="4">
	<input type="button" class="btn btn-primary btn-lg btn-block"  onclick="location='bicycleEdit.html'" value="增加"></input>
	</td>
	</tr>
	<tr>
	<td>序号</td>
	<td>自行车编号</td>
	<td>状态</td>
	<td>操作</td>
	</tr>
		<c:forEach items="${bicycleList}" var="bicycle" varStatus="st">
			<tr>
				<td><c:out value="${st.count}"/></td>
				<td>${bicycle.bicycleNumber}</td>
				<td>
				<c:if test="${bicycle.bicycleState==1}">借出</c:if>
				<c:if test="${bicycle.bicycleState==0}">正常</c:if>
				</td>
				<td><a href="borrowrecordEdit.html?bicycleId=${bicycle.id}&userId=0">借出</a></td>
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