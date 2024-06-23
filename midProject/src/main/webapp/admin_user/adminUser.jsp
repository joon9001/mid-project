<%@page import="user.UserBean"%>
<%@page import="java.io.Console"%>
<%@page import="report.ReportBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="adminMgr" class="admin.AdminMgr"></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>admin page(user)</title>
<link rel="stylesheet" href="../css/userModal.css">
<script src="../js/adminUserDetail.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script>


</head>
<body>

<div class="container">
<%@ include file="../admin_main/adminSidebar.jsp"  %>
<main class="main-content">
<h2>유저관리</h2>

<div class="table">
<table style="width:90%;">
	<tr>
		<th>번호</th><th>유저 id</th><th>보기</th>
	</tr>

	<c:forEach items="<%=adminMgr.getUserAll() %>" var="users">
        <tr style="text-align: center;">
            <td>${users.no}</td>
            <td>${users.id}</td>
            <td><button onclick="javascript:adUserDetail(${users.no})">상세보기</button></td>
        </tr>
    </c:forEach>
</table>




</div>
</main>


<%@ include file="../admin_main/admin_foot.jsp" %>



</div>

	
<!-- 모달 창 -->
<div id="userDetailModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <div id="modal-body">
            <!-- AJAX를 통해 로드된 사용자 세부 정보가 여기에 표시됩니다 -->
        </div>
    </div>
</div>
</div>
</body>
</html>