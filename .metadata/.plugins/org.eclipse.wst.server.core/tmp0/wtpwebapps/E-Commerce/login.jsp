<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DoLogin" method="post">
账号：<input type="text" name="username"><br/>
密码：<input type="password" name="password"><br/>
用户<input type="radio" name="identity" value="1">&nbsp;
商家<input type="radio" name="identity" value="2">&nbsp;
管理员<input type="radio" name="identity" value="3"><br/>
<input type="submit" value="点击"><br/>
</form>
</body>
</html>