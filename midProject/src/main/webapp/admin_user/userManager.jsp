<%@page import="user.UserBean">
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="userMgr" class="user.UserMgr" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자-회원관리</title>
<link href="../css/adminMain.css" rel="stylesheet" type="text/css">
<script src="../js/adminMain.js"></script>
</head>
<body>
<h2>** 관리자 - 전체 회원관리 **</h2>
<div style="text-align: center;">
<%@ include file="admin_top.jsp" %>
</div>

<table style="width: 90%">
  <tr style="background-color: cyan">
  	<th>아이디</th><th>회원명</th><th>이메일</th><th>전화</th><th>수정</th>
  </tr>
  <%
  ArrayList<UserBean> list = UserMgr.getUserAll(); 
    for(UserBean m:list){
  %>
  <tr style="text-align: center;">
  	<td><%=m.getId() %></td>
  	<td><%=m.getName() %></td>
  	<td style="text-align: left;"><%=m.getEmail() %></td>
  	<td><%=m.getGender() %></td>
  	<td><a href="javascript:memUpdate('<%=m.getId()%>')">수정하기</a></td>
  </tr>
  <%	  
  }
  %>
</table>

<%@ include file="admin_bottom.jsp" %>

<form action="userUpdate.jsp" name="updateFrm" method="post">
  <input type="hidden" name="id">
</form>
</body>
</html>






