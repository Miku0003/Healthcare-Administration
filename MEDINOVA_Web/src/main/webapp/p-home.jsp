<%@page import="dao.DoctorDao"%>
<%@page import="model.Doctor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="p-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Home</title>
</head>
<body>


	<!-- Blog Start -->
	<div class="container-fluid py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5" style="max-width: 500px;">
				<h5
					class="d-inline-block text-primary text-uppercase border-bottom border-5">Blog
					Post</h5>
				<h1 class="display-4">Manage Packages</h1>
			</div>
			<div class="row g-5">
			<%
			List<Doctor> list = DoctorDao.getAllDoctors(); 
			%>
			<%
			for(Doctor d:list){
			%>
				<div class="col-xl-4 col-lg-6">
					<div class="bg-light rounded overflow-hidden">
						<img src="img/<%=d.getImage() %>" width="350"
									height="350" alt="">
						<div class="p-4">
							<a class="h3 d-block mb-3" href="#"><%=d.getName() %></a>
						</div>
						<div class="d-flex justify-content-between border-top p-4">
							<div class="d-flex align-items-center">
								<h3><%=d.getContact() %></h3>
							</div>
							<div class="d-flex align-items-center">
								<h3><%=d.getSpecialization() %></h3>
							</div>
						</div>
						
						<div class="d-flex justify-content-between border-top p-4">
							<div class="d-flex align-items-center">
								<a class="h3 d-block mb-3" href="p-doctor-packages.jsp?did=<%=d.getDid()%>">Show Packages</a>
							</div>
							
						</div>
						
						
							
					</div>
				</div>
				<%} %>
			</div>
		</div>
	</div>
	<!-- Blog End -->	

</body>
</html>