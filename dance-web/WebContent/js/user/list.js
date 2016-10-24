$(function() {
	list_table = $('#list_table').DataTable({
		"ajax" : {
			"url" : "query",
			"type" : "POST",
			"dataType" : "json",
			"data" : function(d) {
				d.email = $('#query_form input[name="email"]').val();
				resetDataTablesOrder(d);
			},
			"dataSrc" : function(json) {
				return json.list;
			},
			dataFilter : function(data) {
				var json = jQuery.parseJSON(data);
				json.recordsTotal = json.total;
				json.recordsFiltered = json.total;
				json.data = json.list;

				return JSON.stringify(json); // return JSON string
			}
		},
		"columns" : [ {
			"data" : "usid",
			"name" : "u.usid"
		}, {
			"data" : "email",
			"name" : "u.email"
		} ],
		"bLengthChange" : false,
		"processing" : true,
		"serverSide" : true,
		"deferLoading" : 0,
		"bFilter" : false,
		"bPaginate" : true
	});
});