<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/js/user/list.js"/>"></script>
<script type="text/javascript">
	var addUrl = '<c:url value="/user/prepareAdd"/>';
</script>
<div id="action_div" class="col-md-12">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">使用者列表</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<div class="col-md-12">
				<jsp:include page="/WEB-INF/pages/button/add.jsp" />
			</div>
			<div class="col-md-10 col-md-offset-1">
				<form id="query_form" class="form-horizontal">
					<div class="form-group">
						<label for="inputName" class="col-md-2 control-label">Name</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="name"
								id="inputName">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-md-2 control-label">Email</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="email"
								id="inputEmail">
						</div>
					</div>
					<div class="form-group">
						<label for="inputStatus" class="col-md-2 control-label">Status</label>
						<div class="col-md-10">
							<label class="radio-inline"> <input type="radio"
								name="inlineRadioOptions" id="inlineRadio1" value="option1">
								啟用
							</label> <label class="radio-inline"> <input type="radio"
								name="inlineRadioOptions" id="inlineRadio2" value="option2">
								停用
							</label>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-12 text-center">
				<jsp:include page="/WEB-INF/pages/button/query.jsp" />
				<jsp:include page="/WEB-INF/pages/button/reset.jsp" />
			</div>
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