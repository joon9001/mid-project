<%@page import="user.UserBean"%>
<%@page import="admin.AdminMgr"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="adminMgr" class="admin.AdminMgr" />
<%
request.setCharacterEncoding("utf-8");
int no = Integer.parseInt(request.getParameter("no"));
UserBean user = adminMgr.getUser(no);
request.setAttribute("user", user);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 상세페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<div class="container2">
		<main class="main-content2">
		<br>
		<h3>회원 상세 정보</h3><br>
			<span class="close">&times;</span>
		<tr style="text-align: center;">
		
		 		<td>번호: ${user.no}</td><br><br>
				<td>아이디: ${user.id}</td><br><br>
				<td>비밀번호: ${user.pw}</td><br><br>
				<td>이름: ${user.uname}</td><br><br>
				<td>이메일: ${user.email}</td><br><br>
				<td>성별: ${user.gender}</td><br><br>
				<td>탈퇴 여부: ${user.signout_is}</td><br><br>
				<td>가입일: ${user.sign_up_date}</td><br>
				<br>
		 	</tr>
				
			<div id="userDetailModal" class="modal2">
			
			
			</div>
		</main>
	</div>
	

	
</body>
</html>
