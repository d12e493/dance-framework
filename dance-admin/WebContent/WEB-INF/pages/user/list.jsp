<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/js/user/list.js"/>"></script>
<div id="action_div" class="col-md-12">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">使用者列表</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<form id="query_form">
				<table class="table table-hover">
					<thead>
						<tr>
							<th colspan="2"><jsp:include
									page="/WEB-INF/pages/button/add.jsp" /></th>
						</tr>
					</thead>
					<tbody>
					<tr>
							<th><label for="">Name</label></th>
							<td><input type="text" class="form-control" name="name" id="name"></td>
						</tr>
						<tr>
							<th><label for="">Email</label></th>
							<td><input type="text" class="form-control" name="email" id="email"></td>
						</tr>
						<tr>
							<th><label for="">Status</label></th>
							<td><label class="radio-inline"><input type="radio" name="status" value="1" checked>啟用</label>
							<label class="radio-inline"><input type="radio" name="status" value="-1">停用</label></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2" align="center"><jsp:include
									page="/WEB-INF/pages/button/query.jsp" /> <jsp:include
									page="/WEB-INF/pages/button/reset.jsp" /></td>
						</tr>
					</tfoot>
				</table>
			</form>
			<table id="list_table" class="table table-bordered table-hover">
				<thead class="bg-black disabled color-palette">
					<tr>
						<th>No.</th>
						<th>User ID</th>
						<th>Name</th>
						<th>E-Mail</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<form id="action_form"></form>