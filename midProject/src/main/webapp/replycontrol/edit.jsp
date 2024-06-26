<%@page import="reply.ReplyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="replyMgr" class="reply.ReplyMgr"/>
<%
String reply_book_no= request.getParameter("reply_book_no");
String id = request.getParameter("id");

//수정할 자료 읽기
ReplyDto dto= replyMgr.getData(Integer.parseInt(request.getParameter("reply_no")));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
<script type="text/javascript">
window.onload=()=>{
	document.querySelector("#btnUpOk").onclick = function(){
		if(confirm("정말 수정하시겠습니까?")){
			frm.submit();
		};
	}
}
</script>
</head>
<body>
	<h2 style="text-align: center;">리뷰수정하기</h2>
	<form action="editsave.jsp" method="post" name="frm" enctype="multipart/form-data">
		<input type="hidden" name="reply_no" value="<%=dto.getReply_no() %>">
		
		리뷰 수정하기
		
		<div class ="star_rating" name="reply_point" value="<%=dto.getReply_point()%>"><!-- 원래 평점 들어가야한다. -->
		  	<input type="radio" class="star" value="1">
		    <input type="radio" class="star" value="2">
		    <input type="radio" class="star" value="3">
		    <input type="radio" class="star" value="4">
		    <input type="radio" class="star" value="5">
		</div>
		<br>
		
		리뷰 제목<br>
		<input type="text" name="reply_title" value="<%=dto.getReply_title() %>">
		<br><br>
		리뷰 내용<br>
		 <textarea rows="10" name="reply_cont"><%=dto.getReply_cont() %></textarea> 
		<br><br>
		첨부파일 : <input type="file" name="reply_image" size="30"<%=dto.getReply_image()%>><br>
		
		<br>
		
		<input type="button" value="수정 완료" id="btnUpOk"> &emsp;
		<input type="button" value="목록 보기" onclick="location.href='../bookview/view.jsp?reply_book_no=<%=reply_book_no%>'">
	</form>
</body>
</html>