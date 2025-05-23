<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Sidebar</title>
</head>
<body>
	<div class="main-sidebar sidebar-style-2">
        <aside id="sidebar-wrapper">
          <div class="sidebar-brand">
            <a href="index.html"> <img alt="image" src="assets/img/logo.png" class="header-logo" /> <span
                class="logo-name">MEDINOVA</span>
            </a>
          </div>
          <ul class="sidebar-menu">
            <li class="menu-header">Main</li>
            <li class="dropdown active">
              <a href="a-home.jsp" class="nav-link"><i data-feather="monitor"></i><span>Dashboard</span></a>
            </li>
            <li class="dropdown active">
              <a href="a-doctors.jsp" class="nav-link"><i
                  data-feather="briefcase" ></i><span>Doctors</span></a>
            </li>
            <li class="dropdown active">
              <a href="a-package.jsp"class="nav-link"><i data-feather="command"></i><span>Packages</span></a>
              
            </li>
            <li class="dropdown active">
              <a href="a-patient.jsp" class="nav-link"><i data-feather="mail"></i><span>Patients</span></a>
            </li>
            <li class="dropdown active">
              <a href="a-appointment.jsp" class="nav-link"><i data-feather="mail"></i><span>Appointments</span></a>
            </li>
              </ul>
            </li>
          </ul>
        </aside>
      </div>
</body>
</html>