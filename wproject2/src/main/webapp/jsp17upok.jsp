<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="bean" class="pack.SangpumBean"/>
<jsp:setProperty property="*" name="bean" />
<jsp:useBean id="connP" class="pack.ConnPooling" scope="page"/> <!-- scope 기본.생략가. 현페이지에서유효. -->

<%
//boolean b = connP.updateDataOk(bean);
//if(b)
if(connP.updateDataOk(bean))
	response.sendRedirect("jsp17dbcp.jsp"); //수정 후 목록보기
	else
	response.sendRedirect("jsp17fail.html");

%>