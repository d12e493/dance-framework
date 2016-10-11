$(function() {
	$('#list_table').DataTable({
		"ajax" : {
			"url" : "query",
			"type" : "POST",
		},
		"processing" : true,
		"serverSide" : true,
		"deferLoading" : 0,
		bFilter : false
	});
});