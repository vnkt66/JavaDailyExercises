<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center; color: lightgreen">Student Data</h1><br />
<hr />
<div>
<h5>ID: ${student.id}</h5>
<h5>Name: ${student.name}</h5>
<h5>Email: ${student.email}</h5>
<h5>Gender: ${student.gender}</h5>
<h5>Subjects:</h5>
<c:forEach var="subject" items="${student.subject}">
<ul >
<li style="font-size: 18px">${subject}</li>
</ul>
</c:forEach>
</div>
</body>
</html>