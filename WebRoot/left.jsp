<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js">
<div class="span3" id="sidebar">
    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
	    	<li id="li1">
	            <a href="../book/searchBook"><i class="icon-chevron-right"></i>书目检索</a>
	        </li>
    	<%
    		if(session.getAttribute("role").equals("0")) {
    	%>
        <li id="li2">
            <a href="#"><i class="icon-chevron-right"></i>书目管理</a>
        </li>
        <li id="li3">
            <a href="../clsf/showClsf"><i class="icon-chevron-right"></i>分类管理</a>
        </li>
        <li id="li7">
            <a href="../admin/show"><i class="icon-chevron-right"></i>审核管理</a>
        </li>
    	<%
    		}
    	 %>

    	<%
    		if(session.getAttribute("role").equals("3")) {
    	%>
        <li id="li4">
            <a href="../user/show"><i class="icon-chevron-right"></i>借阅管理</a>
        </li>
    	<%
    		}
    	 %>

        <li id="li6">
            <a href="../info/showInfo"><i class="icon-chevron-right"></i>个人信息管理</a>
        </li>
    </ul>
</div>
</html>