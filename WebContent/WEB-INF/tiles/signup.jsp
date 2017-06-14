<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<div id="alertsSignup">
			<c:if test="${errors == 0}">
				<div class="alert alert-success" role="alert">
					<span class="glyphicon glyphicon-ok"
						aria-hidden="true"></span> <span class="sr-only">Success:</span> Account Successfully Created.
				</div>
			</c:if>
			<c:if test="${errors == 1}">
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span> Sign up failed. Check the data you input.
				</div>
			</c:if>
			<c:if test="${errors == 2}">
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span> Sign
					up failed. Username already exists.
				</div>
			</c:if>
		</div>
		
		<form:form id="signupForm" action="createaccount" method="post"
			class="form-signup" data-toggle="validator" role="form" modelAttribute="user">
			<div class="row">
				<h2 class="form-signup-heading">Sign up here</h2>
			</div>
			<div class="row">
				<div class="form-group">
					<div class="form-inline row">
						<div class="form-group col-sm-4">
							<form:input type="text" id="inputFirstName" name="firstName"
								class="form-control" data-minlength="3" maxlength="30"
								placeholder="First Name" pattern="^[a-zA-Z ]*$" path="firstName"
								required="required" />
						</div>
						<div class="form-group col-sm-4">
							<form:input type="text" id="inputMiddleName" name="middleName"
								class="form-control" maxlength="30" placeholder="Middle Name"
								pattern="^[a-zA-Z ]*$" path="middleName" />
						</div>
						<div class="form-group col-sm-4">
							<form:input type="text" id="inputLastName" name="lastName"
								class="form-control" data-minlength="3" maxlength="30"
								placeholder="Last Name" pattern="^[a-zA-Z ]*$"
								required="required" path="lastName" />
						</div>
						<div class="help-block with-errors"></div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<form:input type="email" id="inputEmail" name="email"
						class="form-control" placeholder="Email address"
						required="required" path="email" />
					<div class="help-block with-errors"></div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<form:input type="text" id="inputUsername" name="username"
						class="form-control" placeholder="Username" data-minlength="3"
						maxlength="30" pattern="^[a-zA-Z0-9_]*$" required="required"
						path="username" />
					<div class="help-block with-errors"></div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<div class="form-inline row">
						<div class="form-group col-sm-6">
							<form:input type="password" id="inputPassword" name="password"
								class="form-control" placeholder="Password"
								pattern="^[a-zA-Z0-9]*$" data-minlength="7" maxlength="30"
								required="required" path="password" />
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group col-sm-6">
							<input type="password" id="inputConfirmPassword"
								name="passwordConfirm" class="form-control"
								placeholder="Confirm Password" data-match="#inputPassword"
								required="required" data-match-error="Password not match!" />
							<div class="help-block with-errors"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						up</button>
				</div>
			</div>

		</form:form>
	</div>

</div>
