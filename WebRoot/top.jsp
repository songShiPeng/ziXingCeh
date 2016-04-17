<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!-- Bootstrap -->
 
 	<script src="../support/js/jquery-1.8.2.min.js"></script>
	<link href="../support/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	
	
	<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
            </a>
            <a class="brand" href="../log/login">自行车图书馆系统</a>
            
<!-- bootstrap -->
 <div class="dropdown" align="right" >
  <button class="btn dropdown-toggle sr-only" type="button" id="dropdownMenu1" data-toggle="dropdown" style="width:100px;">
   <!--  <sec:authentication property="name"/> -->
  &nbsp;&nbsp;&nbsp;<c:out value="${userInfoSS.realName}"></c:out> 
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu1" style="width:80px ;margin:0px;padding:0px; ">
   	<li ><a  href="/ziXingChe/front/borrowrecordEdit.html?bicycleId=0&userId=0" style="height:30px;"><font size="3">办理借车</font></a></li>
   		<li ><a  href="/ziXingChe/front/returnBicycleByTop.html" style="height:30px;"><font size="3">办理还车</font></a></li>
   	<li ><a  href="/ziXingChe/front/borrowrecordList.html" style="height:30px;"><font size="3">借车记录</font></a></li>
   	<li ><a  href="/ziXingChe/front/bicycleList.html" style="height:30px;"><font size="3">自行车管理</font></a></li>
   	<li ><a  href="/ziXingChe/front/userList.html" style="height:30px;"><font size="3">用户管理</font></a></li>
    <li><a  tabindex="-1" href="ziXingChe/logout" style="height:30px;"><font size="3">退出</font></a></li>
  </ul>
</div>
<!-- bootstrap -->
</div>
    </div>
    </div>
</div>