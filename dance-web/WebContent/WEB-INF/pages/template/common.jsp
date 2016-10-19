<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/font-awesome.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/dataTables/css/jquery.dataTables.min.css"/>">

<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/dataTables/datatables.min.js"/>"></script>
<script
	src="<c:url value="/dataTables/js/dataTables.bootstrap.min.js"/>"></script>

<!-- custom javasscript -->
<script src="<c:url value="/js/common/button.js"/>"></script>

<script type="text/javascript">
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
</script>
