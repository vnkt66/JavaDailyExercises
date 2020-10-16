<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Manager Registration Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>" type="text/css">
</head>
<body style="color: gray">
    <jsp:include page="Header.jsp" />
    <div class="sidebar">
    <a href="adminlogin">Admin login</a>
    <a href="managerlogin">Manager login</a>
    <a href="managerregister">Manager Register</a>
    </div>
	<c:url var="action" value="/saveManager"></c:url>
	<form:form action="${action}" method="post" commandName="managerRegisterForm"
		novalidate="true">
		<div class="content">
		<h4 style="text-align: center; padding: 10px 0 0 0">Manager Registration Form</h4>
		<div class="container"
			style="border: none; width: 40%; margin: 30px auto; padding: 10px 10px; background: white; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
			<%-- <div class="row">
				<div class="col-md-3">ID:</div>
				<div class="col-md-9">
					<form:input path="managerId" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="managerId" /><br /></span> --%>
			<div class="row">
				<div class="col-md-4">FirstName:</div>
				<div class="col-md-8">
					<form:input path="firstName" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="firstName" /><br /></span>
			<div class="row">
				<div class="col-md-4">LastName:</div>
				<div class="col-md-8">
					<form:input path="lastName" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="lastName" /><br /></span>
			<div class="row">
				<div class="col-md-4">Password:</div>
				<div class="col-md-8">
					<form:password path="password" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="password" /><br /></span>
			<div class="row">
				<div class="col-md-4">Age:</div>
				<div class="col-md-8">
					<form:input path="age" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="age" /><br /></span>
			<div class="row">
				<div class="col-md-4">Gender:</div>
				<div class="col-md-8">
					<form:radiobuttons items="${genderList}" path="gender" />
				</div>
			</div>
			<%-- <span style="color: red"><form:errors path="gender" /><br /></span> --%>
			<div class="row">
				<div class="col-md-4">Contact Number:</div>
				<div class="col-md-8">
					<form:input path="contactNumber" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="contactNumber" /><br /></span>
			
			<button class="btn btn-primary" type="submit">Submit</button>
		</div>
		</div>
		<jsp:include page="Footer.jsp" />
	</form:form>
</body>
</html>