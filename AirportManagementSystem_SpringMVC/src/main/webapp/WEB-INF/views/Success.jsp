<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Success Page</title>
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
		<h1 style="color: green; margin-top: 70px">Information Provided
			by you saved in Database! Hola</h1>
	</div>
	<jsp:include page="Footer.jsp" />
</body>
</html>