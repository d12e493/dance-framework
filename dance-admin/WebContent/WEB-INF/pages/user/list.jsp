<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/js/user/list.js"/>"></script>
<div id="query_div" class="col-md-offset-2 col-md-8">
	<form id="query_form">
		<table class="table table-hover">
			<tbody>
				<tr>
					<th><label for="exampleInputEmail2">Email</label></th>
					<td><input type="text" class="form-control" name="email"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="center">
						<jsp:include page="/WEB-INF/pages/button/query.jsp"/> 
						<jsp:include page="/WEB-INF/pages/button/reset.jsp"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>
<div id="action_div" class="col-md-12">
	<jsp:include page="/WEB-INF/pages/button/add.jsp"/> 
</div>
<div id="list_div">
	<table id="list_table" class="table table-hover">
		<thead>
			<tr>
				<th>USID</th>
				<th>Email</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>USID</th>
				<th>Email</th>
			</tr>
		</tfoot>
	</table>
</div>
<form id="action_form">
	
</form>