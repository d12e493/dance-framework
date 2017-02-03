<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="<c:url value="/bootstrap/css/bootstrap.min.css"/>">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="<c:url value="/plugins/jvectormap/jquery-jvectormap-1.2.2.css"/>">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value="/dist/css/AdminLTE.min.css"/>">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<c:url value="/dist/css/skins/skin-purple.min.css"/>">

<link rel="stylesheet"
	href="<c:url value="/plugins/datatables/dataTables.bootstrap.css"/>">
<style>
table.dataTable.table-hover tbody tr:hover {
  background-color: #e6ffff;
}
</style>
<!-- jQuery 2.2.3 -->
<script src="<c:url value="/plugins/jQuery/jquery-2.2.3.min.js"/>"></script>
<!-- Bootstrap 3.3.6 -->
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
<!-- FastClick -->
<script src="<c:url value="/plugins/fastclick/fastclick.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/dist/js/app.min.js"/>"></script>
<!-- Sparkline -->
<script
	src="<c:url value="/plugins/sparkline/jquery.sparkline.min.js"/>"></script>
<!-- jvectormap -->
<script
	src="<c:url value="/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/>"></script>
<script
	src="<c:url value="/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/>"></script>
<!-- SlimScroll 1.3.0 -->
<script
	src="<c:url value="/plugins/slimScroll/jquery.slimscroll.min.js"/>"></script>
<!-- ChartJS 1.0.1 -->
<script src="<c:url value="/plugins/chartjs/Chart.min.js"/>"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<c:url value="/dist/js/pages/dashboard2.js"/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/dist/js/demo.js"/>"></script>

<script
	src="<c:url value="/plugins/datatables/jquery.dataTables.min.js"/>"></script>
<script
	src="<c:url value="/plugins/datatables/dataTables.bootstrap.min.js"/>"></script>

<script type="text/javascript">
	function resetDataTablesOrder(data) {
		var orderArray = new Array();
		for (var i = 0; i < data.order.length; i++) {
			var order = data.order[i];
			order.column = data.columns[order.column].name;
			orderArray[i] = order;
		}
		data.order = orderArray;
	}
	
	// datatable init setting
	$.extend( true, $.fn.dataTable.defaults, {
		"bLengthChange" : false,
		"processing" : true,
		"serverSide" : true,
		"bFilter" : false,
		"bPaginate" : true,
		"deferLoading": 0,
		"order": [],
		"language" : {
			"processing" : "處理中...",
			"loadingRecords" : "載入中...",
			"lengthMenu" : "顯示 _MENU_ 筆結果",
			"zeroRecords" : "沒有符合的結果",
			"info" : "顯示第 _START_ 至 _END_ 筆結果，共 _TOTAL_ 筆",
			"infoEmpty" : "顯示第 0 至 0 筆結果，共 0 筆",
			"infoFiltered" : "",
			"infoPostFix" : "",
			"emptyTable" : "無資料",
			"search" : "搜尋:",
			"paginate" : {
				"first" : "第一頁",
				"previous" : "上一頁",
				"next" : "下一頁",
				"last" : "最後一頁"
			},
			"aria" : {
				"sortAscending" : ": 升冪排列",
				"sortDescending" : ": 降冪排列"
			}
		}
	} );
</script>