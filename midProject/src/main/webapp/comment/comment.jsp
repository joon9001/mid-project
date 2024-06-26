<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="replyMgr" class="reply.ReplyMgr"/>    
<jsp:useBean id="dto" class="reply.ReplyDto"/>

<%
String reply_no = request.getParameter("reply_no");
dto = replyMgr.getCommentData(reply_no);
System.out.println(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글쓰기</title>
<script>
function check(){
	if(frm.id.value=""){
		confirm("id를 입력하세요");
		frm.id.focus();
	}
	if(frm.title.value=""){
		confirm("제목을 입력하세요");
		frm.title.focus();
	}if(frm.cont.value=""){
		confirm("내용을 입력하세요");
		frm.cont.focus();
	}else
		frm.submit();
}



</script>

</head>

<body>
<h2 style="text-align: center;">댓글 쓰기</h2>
<form name="frm" method="post" action="commentsave.jsp">
<input type="hidden" name="reply_no" value="reply_no">
<input type="hidden" name="reply_book_no" value="<%=dto.getReply_book_no()%>">
<input type="hidden" name="reply_gnum" value="<%=dto.getReply_gnum() %>">
<input type="hidden" name="reply_onum" value="<%=dto.getReply_onum() %>">
<table>
<tr>
	<td align="center" width="100">I D</td>
	<td width="430"><input name="id" style="width:99%"></td>
</tr>
<tr>
	<td align="center">제 목</td>
	<td><input name="title" style="width:99%"
		value="[댓글]:<%=dto.getReply_title().substring(0,4) %>"></td>
</tr>
<tr>
	<td align="center">내 용</td>
	<td><textarea name="cont" rows="10" style="width:99%"></textarea></td>
</tr> 
<tr>
	<td colspan="2" align="center" height="30">
	<input type="button" value="작  성" onClick="check()">&nbsp;
	<input type="button" value="목  록"
		 onClick="location.href='../bookview/view.jsp'"></td>
		</tr>
</table>
</form>

</body>
</html>