<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="d-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Add Packages</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	%>
	<!-- Contact Start -->
	<div class="container-fluid pt-5">
		<div class="container">
			<div class="text-center mx-auto mb-5" style="max-width: 500px;">
				<h5
					class="d-inline-block text-primary text-uppercase border-bottom border-5">Any
					Questions?</h5>
				<h1 class="display-4">Doctor Add Pcakages</h1>
			</div>
			<div class="row">
				<div class="col-12" style="height: 500px;"></div>
			</div>
			<div class="text-center mx-auto mb-5" style="max-width: 500px;">
				<%
				if (msg != null) {
				%>
				<h5
					class="d-inline-block text-primary text-uppercase border-bottom border-5">
					<%
					out.print(msg);
					%>
				</h5>
				<%
				}
				%>
			</div>
			<div class="row justify-content-center position-relative"
				style="margin-top: -200px; z-index: 1;">
				<div class="col-lg-8">
					<div class="bg-white rounded p-5 m-5 mb-0">
						<form action="PackageController" method="post">
							<div class="row g-3">
								<input type="hidden" name="did" value="<%=d.getDid()%>">
								<div class="col-12">
									<input type="text" class="form-control bg-light border-0"
										name="p_name" placeholder="Package Name" style="height: 55px;">
								</div>
								<div class="col-12">
									<input type="text" class="form-control bg-light border-0"
										name="p_amount" placeholder="Package Price"
										style="height: 55px;">
								</div>
								<div class="col-12">
									<input type="text" class="form-control bg-light border-0"
										name="p_test" placeholder="Test Name" style="height: 55px;">
								</div>
								<div class="col-12">
									<button class="btn btn-primary w-100 py-3" name="action"
										value="add" type="submit">Add</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Contact End -->



	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="lib/tempusdominus/js/moment.min.js"></script>
	<script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>

</body>
</html>