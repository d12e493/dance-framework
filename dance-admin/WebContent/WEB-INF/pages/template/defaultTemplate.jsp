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
<style type="text/css">
table#list_table {
	border-collapse: collapse;
}

table#list_table, table#list_table th, table#list_table td {
	border: 1px solid black;
}
</style>
</head>
<body class="hold-transition skin-purple sidebar-mini">
	<div class="wrapper">
		<tiles:insertAttribute name="header" />

		<tiles:insertAttribute name="menu" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<tiles:insertAttribute name="contentHeader" />
			<!-- Main content -->
			<section class="content">
				<!-- Info boxes -->
				<div class="row">
					<tiles:insertAttribute name="body" />
				</div>
			</section>
		</div>
		<!-- /.content-wrapper -->
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- ./wrapper -->
</body>
</html>
