<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div id="icon_div"></div>
	<div id="time_div">
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" />
	</div>
	<div id="notify_div"></div>
	<div id="welcome_div">
		<i class="fa fa-user fa-3x" aria-hidden="true"><c:out
				value="${sessionWrapper.user.name}" /></i>
	</div>
</div>
