<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Pilot Page</title>
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
    <div class="content">
<div class="col-md-3"
					style="box-shadow: 5px 10px 18px #888888;">
					<ul style="color: gray; list-style-type: none; padding: 0;">

						<li>Id: ${pilot.pilotId}</li>
						<li>Name: ${pilot.name}</li>
						<li>Age: ${pilot.age}</li>
						<li>Gender: ${pilot.gender}</li>
						<li>DOB: ${pilot.dob}</li>
						<button type="button" class="btn btn-primary btn-block"
							onclick="javascript:editPilot(${pilot.pilotId})">Update Details</button>
					</ul>
				</div>
				</div>
				<script type="text/javascript">
				
  function editPlane(pilotId) {
			var url = "/AirportManagementSystem_SpringMVC/fetchById/"+pilotId+"?pilot";
			window.location=url;
	}
	</script>
	<jsp:include page="Footer.jsp" />
</body>
</html>