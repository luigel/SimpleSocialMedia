<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row">
	<c:if test="${error } eq 'badCredentials'">
	<strong>BAD CREDENTIALS</strong>
	</c:if>
		<div class="alert alert-danger" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span> Sign in failed. Check username and password.
				</div>
		<form id="signupForm" action="<c:url value='/login' />" method="post" class="form-signup" data-toggle="validator" role="form">
			<div class="row">
				<div class="form-group">
					<input type="text" name="username" class="form-control" placeholder="Username" data-minlength="3" maxlength="30" pattern="^[a-zA-Z0-9_]*$" required>
					<div class="help-block with-errors"></div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<div class="form-group">
						<input type="password" name="password" class="form-control" placeholder="Password" pattern="^[a-zA-Z0-9]*$" data-minlength="7" maxlength="30" required>
						<div class="help-block with-errors"></div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				</div>
			</div>
		</form>
	</div>

</div>
