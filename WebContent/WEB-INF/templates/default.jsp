<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>

<head>
<link
	href="${pageContext.request.contextPath}/static/vendor/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/static/css/style.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
<tiles:insertAttribute name="includes"></tiles:insertAttribute>
</head>

<body>
	<div class="wrapper">
		<div class="box">
			<div class="row row-offcanvas row-offcanvas-left">
				<!-- main right col -->
				<div class="column col-sm-12 col-xs-12 col-md-12" id="main">
					<tiles:insertAttribute name="header"></tiles:insertAttribute>
					<div id="content">
						<tiles:insertAttribute name="content"></tiles:insertAttribute>
					</div>
					<hr />
					<tiles:insertAttribute name="footer"></tiles:insertAttribute>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/BootstrapValidation/validator.min.js"></script>
</body>
</html>