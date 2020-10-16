<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin Approvals Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>" type="text/css">
</head>
<body style="box-sizing: border-box;">
    <jsp:include page="Header.jsp" />
    <div class="sidebar">
    <a href="adminLogout">Logout</a>
    </div>
	<div class="content" style="margin-left: 450px">
	<h1 style="text-align: center; color: gray">Approval Records</h1>
	<div class="container">
		<div class="row">
			<c:forEach var="plane" items="${planeList}">
				<div class="col-md-3"
					style="border: none; box-shadow: 5px 10px 18px #888888;">
					<ul style="color: gray; list-style-type: none; padding: 0;">
						<li>Id: ${plane.planeId}</li>
						<li>Hanger Status: ${plane.status}</li>
						<button class="btn btn-success" type="button" onclick="javascript:approveRequest(${plane.planeId})">Approve</button>
					</ul>
				</div>
			</c:forEach>
		</div>
	</div>
	</div>
	<script type="text/javascript">
	 function approveRequest(planeId) {
			var url = "approveRequestById/"+planeId;
			window.location=url;
	}
	</script>
	<jsp:include page="Footer.jsp" />
</body>
</html>