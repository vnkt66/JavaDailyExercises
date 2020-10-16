<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>New Pilot Page</title>
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
		<a href="addPlane?newPlane">Add Planes</a> <a href="addPlane?newPilot">Add
			Pilots</a> <a href="addPlane?newHanger">Add Hangers</a> <a
			href="allotHanger">Allot Hanger</a>
		<!-- <a href="updateHanger">Update Hanger</a> -->
		<a href="fetchPilots">View Pilots</a> <a href="viewHangers">View
			Hanger Status</a> <a href="managerLogout">Logout</a>
	</div>
	<c:url var="action" value="/savePilot"></c:url>
	<form:form action="${action}" method="post" commandName="addPilotForm"
		novalidate="true">
		<div class="content">
			<h4 style="text-align: center;">Add Pilot</h4>
			<div class="container"
				style="border: none; width: 40%; margin: 20px auto; padding: 50px 10px; background: white; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
				<%-- <div class="row">
				<div class="col-md-3">Id:</div>
				<div class="col-md-9">
					<form:input path="pilotId" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="pilotId" /><br /></span> --%>
				<div class="row">
					<div class="col-md-3">Name:</div>
					<div class="col-md-9">
						<form:input path="name" style="width: 100%" />
					</div>
				</div>
				<span style="color: red"><form:errors path="name" /><br /></span>
				<div class="row">
					<div class="col-md-3">Age:</div>
					<div class="col-md-9">
						<form:input path="age" style="width: 100%" />
					</div>
				</div>
				<span style="color: red"><form:errors path="age" /><br /></span>
				<div class="row">
					<div class="col-md-3">Gender:</div>
					<div class="col-md-9">
						<form:radiobuttons items="${genderList}" path="gender" />
					</div>
				</div>

				<div class="row">
					<div class="col-md-3">DOB:</div>
					<div class="col-md-9">
						<form:input type="date" path="dob" min="1820-01-01"
							max="2000-01-01" style="width: 100%" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-3">PlaneId's:</div>
					<div class="col-md-9">
						<form:select path="planeIdRef" style="width: 100%">
							<form:option value="${0}" label="Select" />
							<form:options items="${planeIdList}" />
						</form:select>
					</div>
				</div>
				<span style="color: red"><form:errors path="planeIdRef" /><br /></span>

				<button class="btn btn-primary" type="submit">Submit</button>
			</div>
		</div>
	</form:form>
	<jsp:include page="Footer.jsp" />
</body>
</html>