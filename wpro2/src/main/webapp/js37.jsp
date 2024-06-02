<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String irum = request.getParameter("name");
String nai = request.getParameter("age");
%>
<!-- 위의 내용은 서버에 요청하여 데이터를 받아와서 변수에 저장한것 -->

<%=irum + "님의 나이는 " + nai + "살" %>
<!-- 위의 내용은 변수에 저장된 내용을 클라이언트(html)로 출력하라는 것 -->
