<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<style>
#header_nav {
	color: #d9d9d9;
	left: 0;
	right: 0;
	top: 0;
}
</style>
</head>
<body style="background-color: #00001a; padding-top:50px;">
	<tiles:insertAttribute name="header" />
	<div class="container-fluid">
		<div id="content_div" class="row">
			<div id="menu_div" class="col-md-2">
				<tiles:insertAttribute name="menu" />
			</div>
			<div id="body_div" class="col-md-10"
				style="background-color: #e6e6e6; min-height: 100%;">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
</body>
</html>