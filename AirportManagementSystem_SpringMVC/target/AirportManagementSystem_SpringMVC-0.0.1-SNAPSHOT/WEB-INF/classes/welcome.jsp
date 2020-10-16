<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/welcome.css"/>" type="text/css">
</head>
<body>
    <jsp:include page="WEB-INF/views/Header.jsp" />  
    <div class="sidebar">
    <a href="adminlogin">Admin login</a>
    <a href="managerlogin">Manager login</a>
    <a href="managerregister">Manager Register</a>
    </div>
    <div class="content">
    <div>
    <h1 class="ams">AMS</h1>
    <p class="lorem">
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum".
    </p>
    </div>
    </div>
	<!-- Admin <a href="adminlogin">login</a> / <a href="adminregister">Registration</a><br />
	Manager <a href="managerlogin">login</a> / <a href="managerregister">Registration</a><br /> -->
    <jsp:include page="WEB-INF/views/Footer.jsp" /> 
</body>
</html>