<%@page import="model.Packages" %>
<%@page import="dao.PackageDao" %>
<%@page import="model.Patient" %>
<%@page import="dao.PatientDao" %>
<%@page import="model.Appointment" %>
<%@page import="dao.AppointmentDao" %>
<%@page import="java.util.List"%>
<%@include file="a-header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin All Appointment_List</title>
</head>
<body>


<div class="main-content">
    
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-header">
					<h4 class="align-center">All Appointment</h4>
					<div class="card-header-form">
						<form>
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Search">
								<div class="input-group-btn">
									<button class="btn btn-primary">
										<i class="fas fa-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="card-body p-0">
					<div class="table-responsive">
						<table class="table table-striped">
							<tr>
									<th>Sr. No.</th>
									<th>Patient id</th>
									<th>Patient Name</th>
									<th>Package id</th>
									<th>package Name</th>
									<th>Package amount</th>
									<th>Test</th>
									<th>Appointment Date</th>
									<th>Appointment Status</th>
							</tr>
								
							<tr>
							
							<%int srno = 1;%>
							
							<%List<Appointment> list = AppointmentDao.getAllAppoinements();%>
							<%for (Appointment a : list) {
								Appointment appointment = AppointmentDao.getAppoinementsByAid(a.getAid());
								Patient pt  = PatientDao.getpatientByPid(appointment.getPid());
								Packages p = PackageDao.getPackageByPid(appointment.getPack_id());
							%>
                        <td><%=srno %></td>
                        <td><%=a.getPid() %></td>
                        <td><%=pt.getName() %></td>
                        <td><%=a.getPack_id()%></td>
                        <td><%=p.getP_name() %></td>
                        <td><%=p.getP_amount() %></td>
                        <td><%=p.getP_test() %></td>
                        <td><%=a.getDate() %></td>
                        <td><%=a.getStatus() %></td>
                        
                        
                      </tr>
                     
                      <%srno++;%>
								<% } %>
                      		
						</table>
					</div>
				</div>
			</div>
		</div>
		
	</div>
		
</body>
</html>