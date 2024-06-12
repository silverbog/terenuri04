<%@page language="java"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is a JSP Page</title>
</head>
<body>
	<h1 style="background-color: burlywood;">This page displays the
		current date and time of the system</h1>
	<p style="background-color: graytext;"></p>
	
	<%!public String systemdt() {
		Date d = new Date();
		String current_time = d.toString();
		return current_time;
	}%>
	
	<h2 style="background-color: darkgoldenrod;"><%=systemdt()%></h2>
	<form>
		Customer ID: <input type="text" name="idc"><br> Customer
		Name: <input type="text" name="cusname"><br> Customer
		Gender: <input type="text" name="gc"><br> Customer
		Address: <input type="text" name="caddr"><br> Customer
		Profession: <input type="text" name="cprof"><br> <input
			type="submit" value="Create Record of Customer">
	</form>
	<p style="background-color: yellowgreen;" The entered input by the user
		include the following></p>
	<p style="background-color: highlight;" Customer ID=>
		<%=request.getParameter("idc")%>
	</p>
	<p style="background-color: highlight;" Customer Name=>
		<%=request.getParameter("cusname")%>
	</p>
	<p style="background-color: highlight;" Customer Gender=>
		<%=request.getParameter("gc")%>
	</p>
	<p style="background-color: highlight;" Customer Address=>
		<%=request.getParameter("caddr")%>
	</p>
	<p style="background-color: highlight;" Customer Profession=>
		<%=request.getParameter("cprof")%>
	</p>
	<%
		System.out.println("Work of this page has finished successfully");
	%>
</body>
</html>