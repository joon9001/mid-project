<%@page import="likefav.LikeFavDTO"%>
<%@page import="book.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="likeFavMgr" class="likefav.LikeFavMgr" />
<jsp:useBean id="bookMgr" class="book.BookMgr" />
<%
//String id = (String)session.getAttribute("id"); // 세션유지?
String id = "aa"; //임시 아이디
ArrayList<LikeFavDTO> list = likeFavMgr.getLikeBookAll(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜한 도서</title>
</head>
<body>
	<h1>*찜한 도서*</h1>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".likeBtn").click(function() {
				let like_no = $(this).attr("dataLikeNo"); //dataLikeNo 값 가져온다
				$.ajax({
					type : "POST",
					url : "likeFavproc.jsp",
					data : {
						like_no : like_no //서버로 전송하는 데이터 설정. like_no 변수의 값 전송
					},
					success : function(response) {
						//alert(response + " : 성공!");
						window.location.reload(); // 성공 시 페이지 새로고침
					},
					error : function(xhr, status, error) { //요청 실패시 콜백 함수
						alert("에러 발생 : "+ status);
						console.log(error);
					}
				});
			});
		});
	</script>
	<table border="1">
		<%
		for (LikeFavDTO li : list) {
			BookDTO dto = bookMgr.getfavBook(li.getLike_book_no());
		%>
		<tr>
			<td><%=li.getLike_no()%></td>
			<td><img src="../img/<%=dto.getThumb_nail()%>" alt="책 이미지"></td>
			<td><%=dto.getTitle()%></td>
			<td><button class="likeBtn" dataLikeNo="<%=li.getLike_no()%>">♥</button></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>