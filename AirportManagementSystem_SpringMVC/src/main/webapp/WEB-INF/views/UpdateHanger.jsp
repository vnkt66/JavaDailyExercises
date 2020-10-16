<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edit Hanger Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- <link rel="stylesheet" href="css/index.css"> -->
<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>"
	type="text/css">
</head>
<body style="color: gray">
	<jsp:include page="Header.jsp" />
	<div class="sidebar">
		<a
			href="http://localhost:9090/AirportManagementSystem_SpringMVC/addPlane?newPlane">Add
			Planes</a> <a
			href="http://localhost:9090/AirportManagementSystem_SpringMVC/addPlane?newPilot">Add
			Pilots</a> <a
			href="http://localhost:9090/AirportManagementSystem_SpringMVC/addPlane?newHanger">Add
			Hangers</a> <a
			href="http://localhost:9090/AirportManagementSystem_SpringMVC/allotHanger">Allot
			Hanger</a>
		<!-- <a href="updateHanger">Update Hanger</a> -->
		<a
			href="http://localhost:9090/AirportManagementSystem_SpringMVC/fetchPilots">View
			Pilots</a> <a
			href="http://localhost:9090/AirportManagementSystem_SpringMVC/viewHangers">View
			Hanger Status</a> <a
			href="http://localhost:9090/AirportManagementSystem_SpringMVC/managerLogout">Logout</a>
	</div>
	<c:url var="action" value="/editHanger"></c:url>
	<form:form action="${action}" method="post"
		commandName="updateHangerForm" novalidate="true">
		<div class="content">
			<h4 style="text-align: center;">Update Hanger</h4>
			<div class="container"
				style="border: none; width: 40%; margin: 30px auto; padding: 70px 10px; background: white; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
				<div class="row">
					<div class="col-md-3">Id:</div>
					<div class="col-md-9">
						<form:input path="hangerId" style="width: 100%" readonly="true" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-3">Name:</div>
					<div class="col-md-9">
						<form:input path="name" style="width: 100%" readonly="true" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-3">Location:</div>
					<div class="col-md-9">
						<form:input path="location" style="width: 100%" readonly="true" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-3">PlaneId's:</div>
					<div class="col-md-9">
						<%-- <form:select path="planeIdRef" items="${planeIdList}" style="width: 100%"/> --%>
						<form:select path="planeIdRef" style="width: 100%">
							<form:option value="0" label="Select" />
							<form:options items="${planeIdList}" />
						</form:select>
					</div>
				</div>
				<button class="btn btn-primary" type="submit">Save</button>
			</div>
		</div>
	</form:form>
	<jsp:include page="Footer.jsp" />
</body>
</html>