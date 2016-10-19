<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<style>
#header_div {
	color: #d9d9d9
}
</style>
</head>
<body style="background-color: #00001a;">
	<div id="header_div" class="row" style="height: 7%;">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="content_div" class="row" style="height: 88%;">
		<div id="menu_div" class="col-md-2" style="height: 100%;">
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="body_div" class="col-md-10"
			style="background-color: #e6e6e6; height: 100%;">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<div id="footer_div" style="height: 5%;">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>