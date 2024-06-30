<%@page import="book.BookDTO"%>
<%@page import="reply.ReplyDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="replyMgr" class="reply.ReplyMgr" />
<jsp:useBean id="dto" class="reply.ReplyDto" />
<jsp:useBean id="bookMgr" class="book.BookMgr" />

<%
int reply_book_no = Integer.parseInt(request.getParameter("reply_book_no")); //책번호(haha.jpg) (넘어오는 값)
String reply_id = "aa";
//String id = request.getParameter("id"); //세션?
//int bno = Integer.parseInt(request.getParameter("bnum")); //넘겨받는값

double avgPoint = replyMgr.avgPoint(reply_book_no); //총평점 계산(소수점1자리까지)
int totReply = replyMgr.totReply(reply_book_no);//총리뷰수 계산 메소드 호출 

BookDTO bookdto = bookMgr.getBook(reply_book_no);//해당 번호의 책정보 갖고오기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세 정보 출력</title>
</head>
<body>
	<h2>책 상세 정보 출력</h2>
	<!-- 책정보 start -->
	<div class="book">
		<img src="../image/book.jpg">
		<button class="zbtn" type="button"
			onclick="location.href='../likeFav/likeFavproc.jsp?reply_book_no=<%=reply_book_no%>'">찜버튼</button>
		<!-- 연결링크맞는지확인!! -->
	</div>

	<p>
		<br> 책 제목:
		<%=bookdto.getTitle()%>
		<br> 저자:
		<%=bookdto.getAuthor()%>
		<br> 출판사:
		<%=bookdto.getPublisher()%>
		<br> 발행년도:
		<%=bookdto.getPyear()%>
		<br> <br> 평균 평점:
		<%=avgPoint%>
		/ 총 리뷰수:
		<%=totReply%>
	</p>
	<div>
		<button class="reply" type="button"
			onclick="location.href='../reply/replyinsert.jsp?reply_book_no=<%=reply_book_no%>'">리뷰작성</button>
	</div>
	<!-- 책정보 end -->

	<!-- 리뷰 start -->
	<form action="replydetails.jsp" name="detailForm">
		<table style="width: 80%">
			<tr style="background-color: beige;">
				<th>번호</th>
				<th>제목</th>
				<th>작성자id</th>
				<th>작성일</th>
				<th>좋아요 수</th>
			</tr>
			<%
			//책 상세페이지보여줄때 url에 책 넘버가 적히게 된다. url접근 방법제한두기/*
			/*
			try {
				//bno = Integer.parseInt(request.getParameter("reply_book_no"));
				//System.out.print("reply_book_no : "+request.getParameter("reply_book_no"));
				
			} catch (Exception e) {
				bno = 1;
			}
			if (bno <= 0)
				bno = 1;
			*/
			ArrayList<ReplyDto> list = replyMgr.getDataAll(reply_book_no);

			for (int i = 0; i < list.size(); i++) {
				dto = (ReplyDto) list.get(i);
			%>
			<tr style="text-align: center;">
				<td><%=dto.getReply_no()%></td>
				<td><a
					href="../reply/replydetails.jsp?reply_no=<%=dto.getReply_no()%>&reply_book_no=<%=bookdto.getBnum()%>&reply_id=<%=dto.getReply_id()%>"><%=dto.getReply_title()%></a></td>
				<td><%=dto.getReply_id()%></td>
				<td><%=dto.getReply_create_date()%></td>
				<td><%=dto.getReply_like_cnt()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</form>
</body>
</html>