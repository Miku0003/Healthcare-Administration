<%@page import="model.Patient" %>
<%@page import="dao.PatientDao" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="a-header.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin All Patient_List</title>
</head>
<body>
	<div class="main-content">
       
          
	
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-header">
					<h4 class="align-center">All Patient</h4>
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
								<th>Patient Name</th>
								<th>Contact</th>
								<th>Address</th>
								<th>Email</th>	
							</tr>	
							<tr>
							<%int srno = 1;%>
							<%List<Patient> list = PatientDao.getAllPatient();%>
							<%for (Patient p : list) {%>
                        <td class="p-0 text-center">
                          <%=srno %>
                        </td>
                        <td><%=p.getName() %></td>
                        <td class="text-truncate">
                          <%=p.getContact() %>
                        </td>
                        <td class="align-middle">
                          <%=p.getAddress() %>
                        </td>
                        <td><%=p.getEmail() %></td>
                        
                        
                        
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