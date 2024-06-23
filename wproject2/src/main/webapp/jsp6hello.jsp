<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("클라이언트에 의해 호출됨");
System.out.println("서버에서 WEB-INF 영역 내의 jsp 호출 시도");
// 주의: Redirect 불가. Forward만 가.
%>
<jsp:forward page="WEB-INF/jsp6hi.jsp"></jsp:forward>