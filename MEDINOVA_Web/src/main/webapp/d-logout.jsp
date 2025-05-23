<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Logout</title>
</head>
<body>
<%
session.removeAttribute("data");
session.invalidate();
response.sendRedirect("d-login.jsp");
%>
</body>
</html>