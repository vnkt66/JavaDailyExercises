<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>New Plane Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>" type="text/css">
</head>
<body style="color: gray">
    <jsp:include page="Header.jsp" />
    <div class="sidebar">
    <a href="addPlane?newPlane">Add Planes</a>
    <a href="addPlane?newPilot">Add Pilots</a>
    <a href="addPlane?newHanger">Add Hangers</a>
    <a href="allotHanger?">Allot Hanger</a>
    <!-- <a href="updateHanger">Update Hanger</a> -->
    <a href="viewHangers">View Hanger Status</a>
    <a href="managerLogout">Logout</a>
    </div>
	<c:url var="action" value="/savePlane"></c:url>
	<form:form action="${action}" method="post" commandName="addPlaneForm"
		novalidate="true">
		<div class="content">
		<h4 style="text-align: center; padding: 5px 0 0 0">Add Plane</h4>
		<div class="container"
			style="border: none; width: 40%; margin: 10px auto; padding: 40px 10px; background: white; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
			<%-- <div class="row">
				<div class="col-md-3">Plane Id:</div>
				<div class="col-md-9">
					<form:input path="planeId" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="planeId" /><br /></span> --%>
			<div class="row">
				<div class="col-md-4">Travel Speed:</div>
				<div class="col-md-8">
					<form:input path="travelSpeed" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="travelSpeed" /><br /></span>
			<div class="row">
				<div class="col-md-4">Fly Hours:</div>
				<div class="col-md-8">
					<form:input path="flyHours" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="flyHours" /><br /></span>
			<div class="row">
				<div class="col-md-4">Consumption:</div>
				<div class="col-md-8">
					<form:input path="consumption" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="consumption" /><br /></span>
			<div class="row">
				<div class="col-md-4">Max Fuel:</div>
				<div class="col-md-8">
					<form:input path="maxFuel" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="maxFuel" /><br /></span>
			<div class="row">
				<div class="col-md-4">Kerosin Storage:</div>
				<div class="col-md-8">
					<form:input path="kerosinStorage" style="width: 100%" />
				</div>
			</div>
			<span style="color: red"><form:errors path="kerosinStorage" /><br /></span>
			<button class="btn btn-primary" type="submit">Submit</button>
		</div>
		</div>
	</form:form>
	<jsp:include page="Footer.jsp" />
</body>
</html>