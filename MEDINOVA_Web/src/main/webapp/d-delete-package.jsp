<%@page import="dao.PackageDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Delete Packages</title>
</head>
<body>
<% 
int pid = Integer.parseInt(request.getParameter("pid"));
PackageDao.deletPackage(pid);
response.sendRedirect("d-manage-package.jsp");
%>
</body>
</html>