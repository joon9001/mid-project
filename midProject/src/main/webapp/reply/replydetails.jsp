<%@page import="reply.ReplyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="replyMgr" class="reply.ReplyMgr"/>
<jsp:useBean id="dto" class="reply.ReplyDto"/>
<%
int reply_no= Integer.parseInt(request.getParameter("reply_no"));
int reply_book_no = Integer.parseInt(request.getParameter("reply_book_no"));
String reply_id = request.getParameter("reply_id");

//리뷰 조회수 증가--------
replyMgr.replyLikecnt(reply_no);
dto = replyMgr.getData(reply_no);
//-------


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세보기</title>
</head>
<body>
리뷰 상세보기
<table>
<tr>
	<td colspan ="3" style="text-align: right;">
   <input type="button" class="btnLik" value="좋아요" onclick=""/>
   <input type="button" class="btnRep" value="신고" onclick="location.href='../report/report.jsp?reply_no=<%=reply_no%>'"/>
   </td>

</tr>
	<tr>
	<td>작성자 id: <%=dto.getReply_id() %></td>
	<td>작성일: <%=dto.getReply_create_date() %></td>
	<td>좋아요 수: <%=dto.getReply_like_cnt() %></td>
</tr>
<tr>
	 <td colspan="3" >제목: <%=dto.getReply_title() %></td>
</tr>
<tr>
	<td colspan="3">
	<img src="../upload/<%=dto.getReply_image()%>" width="150" />
	</td>
</tr>
<tr>
	<td colspan="3">
	<textarea rows= "10" style="width:99%" readonly><%=dto.getReply_cont() %></textarea>
	</td>
</tr>
<tr>
<td colspan ="3" style="text-align: right;">
	<a href="../comment/comment.jsp">
	댓글쓰기</a>
	<a href="../replycontrol/edit.jsp?reply_no=<%=reply_no%>&id=<%=reply_id%>&reply_book_no=<%=reply_book_no%>">
	<%
	//if(reply_id != null) //세션(이게 맞음, 넘어온 id와 글쓴사람이 맞는 경우이기에)
	//if(reply_id.equals(dto.getReply_id())){
	%>
		수정하기</a>
		<a href="../replycontrol/delete.jsp?reply_no=<%=reply_no%>&id=<%=reply_id%>&reply_book_no=<%=reply_book_no%>">
		삭제하기</a>
		<a href="../bookview/view.jsp?reply_no=<%=reply_no%>&id=<%=reply_id%>&reply_book_no=<%=reply_book_no%>">
	<%
	//}
	%>
	목록으로</a>
</td>
</tr>

</table>
</body>
</html>