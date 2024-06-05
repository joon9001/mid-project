<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import=""%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String name = (String)session.getAttribute("name");
String price = (String)session.getAttribute("price");

ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");

if(list == null) {
	list = new ArrayList<String>();
}



%>
</body>
</html>