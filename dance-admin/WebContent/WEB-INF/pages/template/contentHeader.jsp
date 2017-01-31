<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		<c:if test="${not empty contentHeader.icon}">
			<i class="${contentHeader.icon }"></i>
		</c:if>
		
		${contentHeader.title } <small>${contentHeader.subTitle }</small>
	</h1>
	<!-- bread
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Dashboard</li>
	</ol>
	 -->
</section>