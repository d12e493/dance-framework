<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-fixed-top" role="navigation" id="header_nav"
	style="background: #00001a;">
	<div class="container" style="width:100%;">
		<div class="row" style="padding: 0px">
			<div id="header_left_div" class="col-md-3">
				<div id="icon_div"></div>
				<font color="red" size="6">Dance</font>&nbsp;<font>framework</font>
			</div>
			<div id="header_right_div" class="row col-md-9" align="right">
				<div id="time_div" class="col-md-4"
					style="height: 100%; display: table-cell; vertical-align: bottom;">
					<c:set var="now" value="<%=new java.util.Date()%>" />
					<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />
				</div>
				<div id="notify_div" class="col-md-6" role="group">
					<button class="btn btn-danger" type="button">
						Alert <span class="badge">4</span>
					</button>
					<button class="btn btn-primary" type="button">
						Message <span class="badge">2</span>
					</button>
					<button class="btn btn-info" type="button">
						Work <span class="badge">13</span>
					</button>
				</div>
				<div id="welcome_div" class="col-md-2" align="right">
					<i class="fa fa-user fa-2x" aria-hidden="true">&nbsp;<c:out
							value="${sessionWrapper.user.name}" /></i>
				</div>
			</div>
		</div>
	</div>
</nav>
