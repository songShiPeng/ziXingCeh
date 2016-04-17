<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>

    <!-- Bootstrap -->
    <link href="../support/css/bootstrap.min.css" rel="stylesheet">
	<link href="../support/css/bootstrap-theme.min.css" rel="stylesheet">
	<script src="../support/js/jquery-1.10.0.min.js" type="text/javascript"></script>
	<script src="../support/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<style type="text/css">
html {
	width:100%;
	height:100%;
	margin:0px;
	padding:0px;
}
body {
	width:100%;
	height:100%;
	margin:0px;
	padding:0px;
	background:url(../support/images/home_back.jpg);
	background-size:100% 100%;
	background-repeat:no-repeat;
}
a {  
	color: #000000;
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
.cover {
	z-index:-1;
	position:absolute;
	width:100%;
	height:100%;
	opacity:0.2;
	background-color:#000;
}
.select_bar {
	width:500px;
	height:310px;
	background-color:#fff;
	-moz-border-radius:4px;      /* Gecko browsers */
    -webkit-border-radius:4px;   /* Webkit browsers */
    border-radius:4px;            /* W3C syntax */
	position:absolute;
	bottom:0px;
	left:50%;
	margin-left:-250px;
	font-size:15px;
	font-weight:100;
}
.word_bar {
	width:500px;
	height:auto;
	position:absolute;
	bottom:330px;
	left:50%;
	margin-left:-250px;
	font-size:23px;
	font-family: Arial,Helvetica,sans-serif,SimSun;
	font-weight:lighter;
	color:#fff;
	text-align:center;
	letter-spacing:20px;
}
.content {
	padding-left:100px;
	padding-right:100px;
	padding-top:20px;
}
</style>
  <body>
<div class="cover"></div>
<div class="word_bar">
图书管理系统
</div>
<div role="tabpanel" class="select_bar">
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active" style="width:249px;text-align:center;"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">登陆</a></li>
    <li role="presentation" style="width:249px;text-align:center;"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">注册</a></li>
  </ul>
  <!-- Tab panes -->
  <div class="tab-content">
<div role="tabpanel" class="tab-pane active content" id="home">
	<form action="login" method="post" class="form-inline">
	  <div class="form-group">
	    <div class="input-group" style="margin-top:10px;">
	      <div class="input-group-addon"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></div>
	      <form:input path="user.username" value="${user.username}" type="text" class="form-control" style="width:260px;" id="exampleInputAmount" placeholder=""/>
	    </div>
	    <div class="input-group" style="margin-top:20px;">
	      <div class="input-group-addon"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></div>
	      <form:password path="user.password" value="${user.password}" type="password" class="form-control ipt" style="width:260px;" id="exampleInputAmount" placeholder=""/>
	    </div>
	    <button type="submit" style="margin-top:20px;" class="btn btn-success btn-lg btn-block">登陆</button>
		<div class="checkbox" style="margin-top:4px;">
		  <label>
		    <input type="checkbox" name="rem">&nbsp;&nbsp;&nbsp;记住密码
		  </label>
		</div>
		<a href="#" style="position:absolute;right:100px;margin-top:4px;">忘记密码？</a>
	  </div>
	</form>
</div>
    <div role="tabpanel" class="tab-pane" id="profile"></div>
  </div>
</div>

<script type="text/javascript">
$(document).ready(function(){
$('#myTab a').click(function (e) {
  e.preventDefault()
  $(this).tab('show')
})
});
</script>
  </body>
</html>