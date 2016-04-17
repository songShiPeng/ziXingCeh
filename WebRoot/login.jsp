<%@ page language="java" pageEncoding="utf-8"%>

<%
	response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
	response.setHeader("Cache-Control",
			"no-store,no-cache,must-revalidate");
	response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	response.setHeader("Pragma", "no-cache");
	session.setMaxInactiveInterval(-1);
%>

<!DOCTYPE html>
<html class="no-js">
	<head>
	<!-- Bootstrap -->
	<link href="support/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="support/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
	<link href="../support/vendors/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
	<link href="../support/assets/styles.css" rel="stylesheet" media="screen">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>欢迎</title>
		<link href="./css/loginstyle1.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript">   
    function changeValidateCode(obj) {   
           //获取当前的时间作为参数，无具体意义  
        document.getElementById("username").select();
        var timenow = new Date().getTime();   
           //每次请求需要一个不同的参数，否则可能会返回同样的验证码         
         document.getElementById("img") .src="verifyCode.action?d="+timenow;    
    }   
    window.onload = function()
    {
        if(document.getElementById("username") != null)
        {
            document.getElementById("username").focus();
        }
        
    }
</script>

		<style type="text/css">
.searchinput {
	border-right-width: 0px;
	padding-left: 2px;
	width: 158px;
	/*	font-family: arial;*/
	float: left;
	border-top-width: 0px;
	border-bottom-width: 0px;
	color: #636365;
	margin-left: 1px;
	font-size: 8pt;
	vertical-align: middle;
	border-left-width: 0px;
	margin-right: 1px;
	background-color: #CFE8F5;
	height: 17px;
	padding-top: 3px;
}

.verinput {
	border-right-width: 0px;
	padding-left: 2px;
	width: 10px;
	/*	font-family: arial;*/
	float: left;
	border-top-width: 0px;
	border-bottom-width: 0px;
	color: #636365;
	margin-left: 1px;
	font-size: 8pt;
	vertical-align: middle;
	border-left-width: 0px;
	margin-right: 1px;
	background-color: #CFE8F5;
	height: 17px;
	padding-top: 3px;
}

.tab_search {
	border-bottom: #CFE8F5 1px solid;
	border-left: #CFE8F5 1px solid;
	height: 25px;
	border-top: #CFE8F5 1px solid;
	border-right: #CFE8F5 1px solid;
	valign:"middle";
}

.searchaction {
	width: 22px;
	float: left;
	height: 19px;
}

#apDiv1 {
	position: absolute;
	left: 432px;
	top: 524px;
	width: 353px;
	height: 20px;
	z-index: 1;
	font-size: 12px;
	color: #FFF;
}
.mainList{
		position:relative;  
 		top:100px;  
 		left:0px;
	}
</style>
	</head>

	<body onload="changeValidateCode()">
		
					<form action="${pageContext.request.contextPath}/ziXingChe"  method="post" theme="simple">
						
									<div class="mainList">
									<table  width="100%">
									<tr><td align="center"><font size="3">用户登陆</font></td></tr>
									<tr><td align="center">&nbsp;</td></tr>
										<tr>
											<td align="center"> 
											用户名:&nbsp;<input class="form-control" type="text" placeholder="用户名" name="username" autocomplete="off">
											</td>
										</tr>
									</table>
									
									<table width="100%">
										<tr>
											<td align="center">
												  
                &nbsp;密码:&nbsp;<input  type="password" class="form-control" type="text" placeholder="密码" name="password" >
											</td>
										</tr>
										<tr>
										<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-primary" style="width:300px;">登陆</button></td>
										</tr>
									</table>
								</div>

	</body>
</html>
