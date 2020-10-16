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
<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>" type="text/css">
</head>
<body>
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
    <div class="content" style="margin-left: 450px">
    <div>
    <h1 style="padding: 50px 0">Welcome Back</h1>
    <p style="text-align: justify;">
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum".
    </p>
    </div>
    </div>
    <jsp:include page="Footer.jsp" />
</body>
</html>