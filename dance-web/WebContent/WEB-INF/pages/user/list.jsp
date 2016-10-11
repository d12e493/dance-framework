<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="query_div" class="col-md-offset-2 col-md-8">
	<form id="query_form">
		<table class="table table-hover">
			<tbody>
				<tr>
					<th><label for="exampleInputEmail2">Email</label></th>
					<td><input type="text" class="form-control"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="center">
						<button type="button" class="btn btn-primary">
							<i class="fa fa-search fa-lg" aria-hidden="true">&nbsp;查詢</i>
						</button>
						<button type="button" class="btn btn-danger">
							<i class="fa fa-times fa-lg" aria-hidden="true">&nbsp;清除</i>
						</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>
<div id="list_div"></div>