<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- top nav -->
<div class="navbar navbar-blue navbar-static-top">
	<div class="navbar-header">
		<button class="navbar-toggle" type="button" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle</span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a href="#" class="navbar-brand logo">s</a>
	</div>
	<nav class="collapse navbar-collapse" role="navigation">
		<form class="navbar-form navbar-right" method="POST" name='f'
			action="<c:url value="/login" />" id="form_login">
			<div class="form-group">
				<input type="text" class="form-control" name="username"
					placeholder="Username">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="password"
					placeholder="Password">
			</div>
			<!--  <div class="form-group" id="div-checkbox">
				<label><input name="remember-me" class="form-control" type="checkbox">Remember me</label>
			</div> -->
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit" name="submit" class="btn btn-default">Sign
				In</button>
		</form>
	</nav>
</div>

<!-- /top nav -->