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
<h2>* 서버가 넘겨준 자료 출력 *</h2>
<%
// redirect
String data = request.getParameter("data");
out.println("redirect로 전송된 데이터는 " + data);
out.println("<hr>");

String ourdata = (String)request.getAttribute("datas");
out.println("forward로 전송된 데이터는 " + ourdata);

ArrayList<String> plist = (ArrayList<String>)request.getAttribute("product");
out.println("<hr>");
for(String p:plist){
	out.println("forward로 전송된 ArrayList는 " + p + "<br>");
}


%>
</body>
</html>