<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
홀수 출력<br>
<%
for(int i=1; i<=10; i++){
	if(i % 2 == 1) out.print(i + " ");
}
%>

<br>
<%= "액션 태그 역할 : 각 페이지 간 제어 이동 또는 빈즈 사용 등" %>

<br>
<%= "종류 : include, forward, useBean ..." %>

<%
LocalDate now = LocalDate.now();
out.println(now);
%>