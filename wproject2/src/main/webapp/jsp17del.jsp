<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String code= request.getParameter("code"); %>
<jsp:useBean id="connP" class="pack.ConnPooling" scope="page"/> <!-- scope 기본.생략가. 현페이지에서유효. -->

<%
//boolean b = connP.updateDataOk(bean);
//if(b)
if(connP.deleteData(code)) 
	response.sendRedirect("jsp17dbcp.jsp"); //수정 후 목록보기
	else
	response.sendRedirect("jsp17fail.html");

%>