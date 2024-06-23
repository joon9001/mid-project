<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서버가 넘겨준 자료 출력</h2>
<%
//redirect 
String mydata=request.getParameter("data");
out.println("전송된 data(리다이렉트방식)는 "+ mydata);
out.println("<br>");

//forward 방식
String ourdata= (String)request.getAttribute("dd");
out.println("전송된 data(포워드방식)는 "+ ourdata);
out.println("<br>");
ArrayList<String> plist= (ArrayList<String>)request.getAttribute("product");
for(String p:plist){
	out.print(p+" ");
}
%>
</body>
</html>