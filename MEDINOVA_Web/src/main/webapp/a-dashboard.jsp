<%@page import="dao.DoctorDao"%>
<%@page import="model.Doctor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="a-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
</head>
<body>

<div class="main-content">
       
          
	
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-header">
					<h4 class="align-center">All Doctors</h4>
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
								<th>Doctor Name</th>
								<th>Contact</th>
								<th>Address</th>
								<th>Specialization</th>
								<th>Email</th>	
							</tr>	
							<tr>
							<%int srno = 1;%>
							<%List<Doctor> list = DoctorDao.getAllDoctors();%>
							<%for (Doctor a : list) {%>
                        <td class="p-0 text-center">
                          <%=srno %>
                        </td>
                        <td><%=a.getName() %></td>
                        <td class="text-truncate">
                          <%=a.getContact() %>
                        </td>
                        <td class="align-middle">
                          <%=a.getAddress() %>
                        </td>
                        <td><%=a.getSpecialization() %></td>
                        <td><%=a.getEmail() %></td>
                        
                        
                      </tr>
                      <tr>
                      <%
									srno++;
								%>
								<%
									}
								%>
                      
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>