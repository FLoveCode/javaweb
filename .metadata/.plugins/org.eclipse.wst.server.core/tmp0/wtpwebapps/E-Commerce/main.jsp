<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
<%--点击账号 --%>
<%
	String username=(String)session.getAttribute("username");
	if(username==null){
		out.print("<a href='login.jsp'>");
		out.print("请登录！");
		out.print("</a>");
	}else{
		out.print("<a href='customer.jsp'>");
		out.print(username);
		out.print("</a>");
	}
%>
<%--点击退出 --%>
<a href="Logout">退出</a><br/>

<a href="IndShow">我的订单</a><br/>

<%--展示商品 --%>

<a href="ComShow">展示商品</a><br/>

<a href="ViewCart">我的购物车</a><br/>

<a href="Payment">支付</a><br/>

<%--购买商品 --%>
<a href="CreateInd">购买商品</a><br/>
</body>
</html>