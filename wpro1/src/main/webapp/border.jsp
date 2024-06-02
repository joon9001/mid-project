<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 자바 영역 
String irum = request.getParameter("writer");
String jemok = request.getParameter("subject");
String nai = request.getParameter("age");
String email = request.getParameter("email");
String content = request.getParameter("content");
//test5.html에서 form으로 보내는 양식의 name 값을 모두 받아줘야함, 1개라도 누락되면 에러
System.out.println(irum + " " + jemok + " " + nai + " " + email + " " + content);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html 영역 -->
작성자 이름은 <%=irum %> <br>
제목은 <%=jemok %>
</body>
</html>