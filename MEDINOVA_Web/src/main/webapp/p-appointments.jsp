
<%@page import="dao.DoctorDao"%>
<%@page import="model.Doctor"%>
<%@page import="model.Packages"%>
<%@page import="dao.PackageDao"%>
<%@page import="dao.AppointmentDao"%>
<%@page import="model.Appointment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="p-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Appointment</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Sr. No</th>
				<th scope="col">Doctor Name</th>
				<th scope="col">Specialization</th>
				<th scope="col">Package</th>
				<th scope="col">Amount</th>
				<th scope="col">Date</th>
				<th scope="col">Status</th>
			</tr>
		</thead>
		<tbody>
		<%int srno = 1; %>
		<%List<Appointment> list =AppointmentDao.getAppoinementsByPid(p.getPid()); %>
		<%for(Appointment a:list){ %>
		<%Packages pa = PackageDao.getPackageByPid(a.getPack_id()); %>
		<%Doctor d1 = DoctorDao.getDoctorByDid(pa.getDid()); %>
			<tr>
				<th scope="row"><%=srno %></th>
				<td><%=d1.getName() %></td>
				<td><%=d1.getSpecialization() %></td>
				<td><%=pa.getP_name() %></td>
				<td><%=pa.getP_amount() %></td>
				<td><%=a.getDate() %></td>
				<td><%=a.getStatus() %></td>
			</tr>
			<%srno++; %>
			<%} %>
		</tbody>
	</table>
</body>
</html>
