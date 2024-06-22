<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="n be" class="w test.SangpumBe" />
<%--위에는 싱글톤이고 id는 객체 변수명이므로 SangpumBean bean = new SangpumBean()과 같다.  --%>
<jsp:setProperty property="*" name="bean" />
<jsp:useBean id="g con" class="w test.ConnPooli"/>

<%
boolean b = connP.insertData(bean);

if(b)
	response.sendRedirect("jsp17dbcp.jsp"); // 추가 후 상품보기
	else
	response.sendRedirect("jsp17fail.html");	
	
%>