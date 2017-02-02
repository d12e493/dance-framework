$(function() {
	$('#list_table').DataTable({
		"ajax" : {
			"url" : "query",
			"type" : "POST",
			"dataType" : "json",
			"data" : function(d) {
				resetDataTablesOrder(d);
			}
		},
		"columns" : [ {
			"data" : "userId",
			"name" : "u.usid"
		}, {
			"data" : "name",
			"name" : "u.email"
		}, {
			"data" : "email",
			"name" : "u.email"
		}, {
			"data" : "status",
			"name" : "u.email"
		} ],
		"bLengthChange" : false,
		"processing" : true,
		"serverSide" : true,
		"bFilter" : false,
		"bPaginate" : true,
		"iDisplayLength" : 10
	});
});