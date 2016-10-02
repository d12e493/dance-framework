<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../template/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body style="background-color: #404040;">
	<div style="height: 150px"></div>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-info">
				<div class="panel-heading text-center">
					<strong> <font size="5">Dance Framework Platform</font>
					</strong>
				</div>
				<div class="panel-body">
					<div class="col-md-10 col-md-offset-1">
						<form action="login" method="post" class="form-horizontal">
							<div class="form-group form-group-lg">
								<input type="email" name="email" class="form-control"
									placeholder="please enter your email" />
							</div>
							<div class="form-group form-group-lg">
								<input type="password" name="password" class="form-control"
									placeholder="please enter your password" />
							</div>
							<div class="form-group form-group-lg">
								<button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>