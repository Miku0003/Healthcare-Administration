<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Header</title>
</head>
<body>
<%
String email = null;
if(session.getAttribute("email")!=null){
	email  = (String)session.getAttribute("email");
}
else{
	response.sendRedirect("a-login.jsp");
}
%>
<div class="wrapper">
	<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"><%=email %></a>
			</div>
			<div
				style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
				 <a href="#"
					class="btn btn-danger square-btn-adjust">Logout</a>
			</div>
		</nav><%@include file="a-sidebar.jsp"%>
<!DOCTYPE html>
<html lang="en">

<!-- index.html  21 Nov 2019 03:44:50 GMT -->
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no"
	name="viewport">
<title>admin medinova</title>
<!-- General CSS Files -->
<link rel="stylesheet" href="assets/css/app.min.css">
<!-- Template CSS -->
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/components.css">
<!-- Custom style CSS -->
<link rel="stylesheet" href="assets/css/custom.css">
<link rel='shortcut icon' type='image/x-icon'
	href='assets/img/favicon.ico' />
</head>

<body>

	<div class="loader"></div>
	<div id="app">
		<div class="main-wrapper main-wrapper-1">
			<div class="navbar-bg"></div>
			<nav class="navbar navbar-expand-lg main-navbar sticky">
				<div class="form-inline mr-auto">
					<ul class="navbar-nav mr-3">
						<li><a href="#" data-toggle="sidebar"
							class="nav-link nav-link-lg
									collapse-btn"> <i
								data-feather="align-justify"></i></a></li>
						<li><a href="#" class="nav-link nav-link-lg fullscreen-btn">
								<i data-feather="maximize"></i>
						</a></li>
						<li>
							<form class="form-inline mr-auto">
								<div class="search-element">
									<input class="form-control" type="search" placeholder="Search"
										aria-label="Search" data-width="200">
									<button class="btn" type="submit">
										<i class="fas fa-search"></i>
									</button>
								</div>
							</form>
						</li>
					</ul>
				</div>
				<ul class="navbar-nav navbar-right">
					<li class="dropdown dropdown-list-toggle"><a href="#"
						data-toggle="dropdown" class="nav-link nav-link-lg message-toggle"><i
							data-feather="mail"></i> <span class="badge headerBadge1">
						</span> </a>
						<div
							class="dropdown-menu dropdown-list dropdown-menu-right pullDown">
							<div class="dropdown-header">
								Messages
								<div class="float-right">
									<a href="#">Mark All As Read</a>
								</div>
							</div>

							<div class="dropdown-footer text-center">
								<a href="#">View All <i class="fas fa-chevron-right"></i></a>
							</div>
						</div></li>
					<li class="dropdown dropdown-list-toggle"><a href="#"
						data-toggle="dropdown"
						class="nav-link notification-toggle nav-link-lg"><i
							data-feather="bell" class="bell"></i> </a>
						<div
							class="dropdown-menu dropdown-list dropdown-menu-right pullDown">
							<div class="dropdown-header">
								Notifications
								<div class="float-right">
									<a href="#">Mark All As Read</a>
								</div>
							</div>

							<div class="dropdown-footer text-center">
								<a href="#">View All <i class="fas fa-chevron-right"></i></a>
							</div>
						</div></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="nav-link dropdown-toggle nav-link-lg nav-link-user"> <img
							alt="image" src="assets/img/users/user.jpg"
							class="user-img-radious-style"> <span
							class="d-sm-none d-lg-inline-block"></span></a>
						<div class="dropdown-menu dropdown-menu-right pullDown">
							<div class="dropdown-title">Hello Admin</div>
							
							<div class="dropdown-divider"></div>
							<a href="a-logout.jsp"
								class="dropdown-item has-icon text-danger"> <i
								class="fas fa-sign-out-alt"></i> Logout
							</a>
						</div></li>
				</ul>
			</nav>
		</div>
	</div>
	<!-- General JS Scripts -->
	<script src="assets/js/app.min.js"></script>
	<!-- JS Libraies -->
	<script src="assets/bundles/apexcharts/apexcharts.min.js"></script>
	<!-- Page Specific JS File -->
	<script src="assets/js/page/index.js"></script>
	<!-- Template JS File -->
	<script src="assets/js/scripts.js"></script>
	<!-- Custom JS File -->
	<script src="assets/js/custom.js"></script>
</body>
</html>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><img src="assets/img/find_user.png"
						class="user-image img-responsive" /></li>


					<li><a class="active-menu" href="index.html"><i
							class="fa fa-dashboard fa-3x"></i> Dashboard</a></li>
					<li><a href="ui.html"><i class="fa fa-desktop fa-3x"></i>
							Doctors</a></li>
					<li><a href="tab-panel.html"><i class="fa fa-qrcode fa-3x"></i>
							Patients</a></li>
					<li><a href="chart.html"><i
							class="fa fa-bar-chart-o fa-3x"></i>Packages</a></li>
					<li><a href="table.html"><i class="fa fa-table fa-3x"></i>
							Appointments</a></li>
					<li><a href="form.html"><i class="fa fa-edit fa-3x"></i>
							Forms </a></li>


					<li><a href="#"><i class="fa fa-sitemap fa-3x"></i>
							Multi-Level Dropdown<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="#">Second Level Link</a></li>
							<li><a href="#">Second Level Link</a></li>
							<li><a href="#">Second Level Link<span class="fa arrow"></span></a>
								<ul class="nav nav-third-level">
									<li><a href="#">Third Level Link</a></li>
									<li><a href="#">Third Level Link</a></li>
									<li><a href="#">Third Level Link</a></li>

								</ul></li>
						</ul></li>
					<li><a href="blank.html"><i class="fa fa-square-o fa-3x"></i>
							Blank Page</a></li>
				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->
</div>

<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assets/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- MORRIS CHART SCRIPTS -->
	<script src="assets/js/morris/raphael-2.1.0.min.js"></script>
	<script src="assets/js/morris/morris.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>
</body>
</html>