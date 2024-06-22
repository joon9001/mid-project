<%@page import="reply.ReplyBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="adminMgr" class="admin.AdminMgr"></jsp:useBean>

<%
request.setCharacterEncoding("utf-8");
int report_reply_no = Integer.parseInt(request.getParameter("report_reply_no"));
//out.println(report_reply_no);

ReplyBean bean = adminMgr.getReply(report_reply_no);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 상세보기</title>
<link rel="stylesheet" href="../css/adminMain.css">
</head>
<body>
<div class="container">
<%@ include file="../admin_main/adminSidebar.jsp"  %>
<main class="main-content">
<h2>해당 글 보기</h2>
<div class="reply_cont">
<br>
<h3><%=bean.getReply_title() %></h3>
<br>
<p><%=bean.getReply_no() %>번 글</p>

<textarea style="width: 90%; height: 22em; resize: none;">
<%=bean.getReply_cont() %>
</textarea>
<br>
<p><%=bean.getReply_create_date()%>작성</p>


</div>

<input type="button" onclick="history.back()" value="뒤로가기">

</main>
<%@ include file="../admin_main/admin_foot.jsp" %>      
</div>
</body>
</html>