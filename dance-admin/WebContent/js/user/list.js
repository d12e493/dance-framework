var list_table;
$(function() {
	list_table = $('#list_table')
			.DataTable(
					{
						"ajax" : {
							"url" : "query",
							"type" : "POST",
							"dataType" : "json",
							"data" : function(d) {
								return buildData(d);
							}
						},
						"columns" : [
								{
									"data" : "no",
									"render" : function(data, type, row, meta) {
										return meta.row
												+ meta.settings._iDisplayStart
												+ 1;
									},
									orderable : false
								},
								{
									"data" : "userId",
									"name" : "u.usid"
								},
								{
									"data" : "name",
									"name" : "u.email"
								},
								{
									"data" : "email",
									"name" : "u.email"
								},
								{
									"data" : "status",
									"render" : function(data, type, row, meta) {
										if (data == 1) {
											return '<i class="fa fa-lg fa-check" style="color:green" title="啟用"></i>';
										} else if (data == -1) {
											return '<i class="fa fa-lg fa-times" style="color:red"></i>';
										}
									},
									"orderable" : false
								},
								{
									"defaultContent" : '<button type="button" class="btn btn-info"><i class="fa fa-pencil fa-lg">&nbsp;修改</i></button> '
											+ '<button type="button" class="btn btn-danger"><i class="fa fa-trash-o fa-lg">&nbsp;刪除</i></button>',
									orderable : false
								} ]
					});
	$('button[name="form_query"]').click(function() {
		list_table.ajax.reload();
	})
});

function buildData(d) {
	resetDataTablesOrder(d);
	d.name = $('#name').val()
	return d;
}