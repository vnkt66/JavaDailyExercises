<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Error Page</title>
<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>"
	type="text/css">
</head>
<body>
	<jsp:include page="Header.jsp" />
	<div class="sidebar">
		<a href="adminlogin">Admin login</a> <a href="managerlogin">Manager
			login</a> <a href="managerregister">Manager Register</a>
	</div>
	<div class="content"
		style="margin-left: 500px; padding-top: 60px; color: red; font-size: 28px">
		<h1>Something Went Wrong</h1>
		<p>Application has encountered an error. Please contact support</p>
	</div>
	<jsp:include page="Footer.jsp" />
</body>
</html>