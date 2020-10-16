<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hanger Status Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>"
	type="text/css">
</head>
<body style="box-sizing: border-box;">
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
		<h1 style="text-align: center; color: gray">Hanger Status Records</h1>
		<hr />
		<h2>Available</h2>
		<hr />
		<div class="container">
			<div class="row">
				<c:forEach var="hanger" items="${availableHangers}">
					<div class="col-md-3"
						onclick="javascript:viewHanger(${hanger.hangerId})"
						style="box-shadow: 5px 10px 18px #888888;">
						<ul
							style="color: gray; list-style-type: none; padding: 0; cursor: pointer">

							<li>Id: ${hanger.hangerId}</li>
							<li>Name: ${hanger.name}</li>
							<li>Location: ${hanger.location}</li>
						</ul>
					</div>
				</c:forEach>
			</div>
		</div>
		<hr />
		<h2>Assigned</h2>
		<hr />
		<div class="container">
			<div class="row">
				<c:forEach var="hanger" items="${assignedHangers}">
					<div class="col-md-3"
						onclick="javascript:viewHanger(${hanger.hangerId})"
						style="box-shadow: 5px 10px 18px #888888;">
						<ul
							style="color: gray; list-style-type: none; padding: 0; cursor: pointer">

							<li>Id: ${hanger.hangerId}</li>
							<li>Name: ${hanger.name}</li>
							<li>Location: ${hanger.location}</li>
						</ul>
					</div>
				</c:forEach>
			</div>
		</div>
		<hr />
		<h2>Allocated</h2>
		<hr />
		<div class="container">
			<div class="row">
				<c:forEach var="hanger" items="${allocatedHangers}">
					<div class="col-md-3"
						onclick="javascript:viewHanger(${hanger.hangerId})"
						style="box-shadow: 5px 10px 18px #888888;">
						<ul style="color: gray; list-style-type: none; padding: 0;">

							<li>Id: ${hanger.hangerId}</li>
							<li>Name: ${hanger.name}</li>
							<li>Location: ${hanger.location}</li>
						</ul>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	 function viewHanger(hangerId) {
			var url = "/AirportManagementSystem_SpringMVC/fetchHangerById/"+hangerId;
			window.location=url;
	}
	 $(document).ready(function(){
		  $("a").hover(function(){
		    $(this).css("background-color", "#555");
		    }, function(){
		    $(this).css("color", "white");
		  });
		});
	</script>
	<jsp:include page="Footer.jsp" />
</body>
</html>