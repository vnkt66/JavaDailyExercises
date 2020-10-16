<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Manager Login Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>"
	type="text/css">
</head>
<body style="color: gray">
	<jsp:include page="Header.jsp" />
	<div class="sidebar">
		<a href="adminlogin">Admin login</a> <a href="managerlogin">Manager
			login</a> <a href="managerregister">Manager Register</a>
	</div>
	<c:url var="action" value="/fetchManager"></c:url>
	<form:form action="${action}" method="post"
		commandName="managerLoginForm" novalidate="true">
		<div class="content">
			<h4 style="text-align: center;">Manager Login Form</h4>
			<div class="container"
				style="border: none; width: 40%; margin: 50px auto; padding: 70px 10px; background: white; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
				<div class="row">
					<div class="col-md-4">Manager ID:</div>
					<div class="col-md-8">
						<form:input path="managerId" style="width: 100%" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-4">Password:</div>
					<div class="col-md-8">
						<form:password path="password" style="width: 100%" />
					</div>
				</div>
				<span style="color: red"><form:errors path="password" /><br /></span>
				<button class="btn btn-primary" type="submit">Submit</button>
			</div>
		</div>
	</form:form>
	<jsp:include page="Footer.jsp" />
</body>
</html>