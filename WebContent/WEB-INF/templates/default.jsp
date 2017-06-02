<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>

<head>
<link
	href="${pageContext.request.contextPath}/static/vendor/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/vendor/jquery/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">

<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
<tiles:insertAttribute name="includes"></tiles:insertAttribute>

</head>

<body>
	<div class="header">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div class="content">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>

	<hr />
	<div class="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/vendor/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</body>
</html>