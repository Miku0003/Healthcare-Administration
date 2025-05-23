<%@page import="model.Packages" %>
<%@page import="dao.PackageDao" %>
<%@page import="java.util.List"%>
<%@include file="a-header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin All Package_List</title>
</head>
<body>
	<div class="main-content">
       
          
	
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-header">
					<h4 class="align-center">All Package</h4>
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
								<th>Package Name</th>
								<th>Package Amount</th>
								<th>Test</th>
								
							</tr>	
							<tr>
							<%int srno = 1;%>
							<%List<Packages> list = PackageDao.getAllPackages();%>
							<%for (Packages p : list) {%>
                        <td class="p-0 text-center">
                          <%=srno %>
                        </td>
                        <td><%=p.getP_name() %></td>
                        <td class="text-truncate">
                          <%=p.getP_amount() %>
                        </td>
                        <td class="align-middle">
                          <%=p.getP_test() %>
                        </td>
                        
                        
                        
                        
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