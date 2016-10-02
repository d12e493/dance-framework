<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<div id="header_div">header</div>
	<div id="content_div" class="row">
		<div id="menu_div">menu</div>
		<div id="body_div">body</div>
	</div>
	<div id="footer_div">footer</div>
</body>
</html>