<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>customer</title>
</head>
<body>
<%
	String username=(String)session.getAttribute("username");
	out.print(username);
%>
<a href="CusAlter">修改信息</a>
<a href="CusSelf">查看个人信息</a>

</body>
</html>