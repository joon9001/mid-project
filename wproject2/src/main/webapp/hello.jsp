<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("클라이언트에 의해 호출됨");
System.out.println("서버에서 WEB-INF 영역 내의 jsp 호출 시도");
// 주의 : redirect로는 WEB-INF 영역 내 jsp 호출 불가
// 아래 forward 방식으로만 호출 가능
%>
<jsp:forward page="WEB-INF/hi.jsp"></jsp:forward>