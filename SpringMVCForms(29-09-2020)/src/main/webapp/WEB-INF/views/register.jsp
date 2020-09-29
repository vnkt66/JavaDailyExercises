<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
<h1>Register</h1>
<c:url var="submit" value="/submit"></c:url>
<form:form action="${submit}" method="post" commandName="student" novalidate="true">
ID: <form:input path="id"/><br />
<span style="color: red"><form:errors path="id"/><br /></span>
Name: <form:input path="name"/><br />
<span style="color: red"><form:errors path="name"/><br /></span>
Password: <form:password path="password"/><br />
<span style="color: red"><form:errors path="password"/><br /></span>
Email: <form:input type="email" path="email"/><br />
<span style="color: red"><form:errors path="email"/><br /></span>
Gender: <form:radiobuttons items="${genderList}" path="gender"/><br />
<span style="color: red"><form:errors path="gender"/><br /></span>
Subject: <form:checkboxes items="${subjectList}" path="subject" /><br />
<span style="color: red"><form:errors path="subject"/><br /></span>
<input type="submit" value="Save"/>
</form:form>
</body>
</html>