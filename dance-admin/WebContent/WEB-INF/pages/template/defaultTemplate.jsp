<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title><tiles:getAsString name="title" /></title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<tiles:insertAttribute name="header" />

		<tiles:insertAttribute name="menu" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<tiles:insertAttribute name="contentHeader" />
			<tiles:insertAttribute name="body" />
		</div>
		<!-- /.content-wrapper -->
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- ./wrapper -->
</body>
</html>
