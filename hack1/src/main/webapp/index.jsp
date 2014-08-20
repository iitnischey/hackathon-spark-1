<!DOCTYPE html>
<html>
<head>
<%@ page import="sparkworkbench.helloworld" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
helloworld hw =  new helloworld();
String name = hw.getName();
int j = hw.job();
%>
hello <%= name %> <%= j %>
</body>
</html>