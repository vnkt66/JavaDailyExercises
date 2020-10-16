<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<c:url value="/resources/css/welcome.css"/>" type="text/css">
</head>
<body>
	<jsp:include page="WEB-INF/views/Header.jsp" />
	<div class="sidebar">
		<a href="adminlogin">Admin login</a> <a href="managerlogin">Manager
			login</a> <a href="managerregister">Manager Register</a>
	</div>
	<div class="content">
		<div>
			<h1 class="ams">AMS</h1>
			<p class="lorem" style="text-align: justify;">"AMS is a leading
				supplier of Integrated Airport Management Systems, successfully
				providing solutions for 30 years. Our products represent the very
				latest in airport management software and consist of a set of
				integrated modules to fully provide for an airport’s operational
				data management needs. Our prime mission is to work in true
				partnership with our airport customers, through the ALDIS User Group
				(AUG) and to continuously strive to enhance our products and
				services to ensure we meet our customers’ evolving requirements.".</p>
		</div>
	</div>
	<!-- Admin <a href="adminlogin">login</a> / <a href="adminregister">Registration</a><br />
	Manager <a href="managerlogin">login</a> / <a href="managerregister">Registration</a><br /> -->
	<jsp:include page="WEB-INF/views/Footer.jsp" />
</body>
</html>