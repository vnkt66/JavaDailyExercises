<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Pilot Records Page</title>
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
		<h1 style="text-align: center; color: gray">Pilot Records</h1>
		<hr />
		<div class="container">
			<div class="row">
				<c:forEach var="pilot" items="${pilotList}">
					<div class="col-md-3"
						onclick="javascript:viewPilot(${pilot.pilotId})"
						style="box-shadow: 5px 10px 18px #888888;">
						<ul
							style="color: gray; list-style-type: none; padding: 0; cursor: pointer">

							<li>Id: ${pilot.pilotId}</li>
							<li>Name: ${pilot.name}</li>
							<li>Age: ${pilot.age}</li>
							<li>Gender: ${pilot.gender}</li>
							<li>DOB: ${pilot.dob}</li>
						</ul>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	 function viewPilot(pilotId) {
			var url = "/AirportManagementSystem_SpringMVC/fetchPilotById/"+pilotId;
			window.location=url;
	}
	</script>
	<jsp:include page="Footer.jsp" />
</body>
</html>