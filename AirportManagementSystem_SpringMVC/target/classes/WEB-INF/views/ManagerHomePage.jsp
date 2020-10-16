<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Manager Home Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>"
	type="text/css">
</head>
<body>
	<jsp:include page="Header.jsp" />
	<div class="sidebar">
		<a href="addPlane?newPlane">Add Planes</a> <a href="addPlane?newPilot">Add
			Pilots</a> <a href="addPlane?newHanger">Add Hangers</a> <a
			href="allotHanger">Allot Hanger</a>
		<!-- <a href="updateHanger">Update Hanger</a> -->
		<a href="fetchPilots">View Pilots</a> <a href="viewHangers">View
			Hanger Status</a> <a href="managerLogout">Logout</a>
	</div>
	<div class="content" style="margin-left: 450px">
		<div>
			<h1 style="padding: 60px 0">Welcome ${managerName}(${managerId})</h1>
			<p style="text-align: justify; font-size: 25px">"Manage all the
				services of AMS from this page, You have access to all the data from
				AMS but we request you to maintain the data privacy".</p>
		</div>
	</div>
	<jsp:include page="Footer.jsp" />
</body>
</html>