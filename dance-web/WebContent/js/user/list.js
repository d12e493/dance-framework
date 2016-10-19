$(function() {
	list_table = $('#list_table').DataTable({
		"ajax" : {
			"url" : "query",
			"type" : "POST",
			"data" : $("#query_form").serializeObject(),
			"dataSrc" : function(json) {

				console.log(json);

				return json.list;
			}
		},
		"columns" : [ {
			"data" : "usid"
		}, {
			"data" : "email"
		} ],
		"processing" : true,
		"serverSide" : true,
		"deferLoading" : 0,
		"bFilter" : false,
		"bPaginate" : true
	});
});