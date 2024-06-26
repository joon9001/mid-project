<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="replyMgr" class="reply.ReplyMgr"/>

<%
String reply_no= request.getParameter("reply_no");
String reply_book_no= request.getParameter("reply_book_no");

// 조건을 어떻게 주지...
	replyMgr.delData(reply_no);
	response.sendRedirect("../bookview/view.jsp?page=" + reply_book_no);

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>