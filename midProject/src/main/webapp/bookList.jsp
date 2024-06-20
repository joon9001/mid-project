<%@page import="pack.searchFilter.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//Connection conn = null;	// 예전 방법
%>

<jsp:useBean id="connClass" class="pack.searchFilter.DBOutput"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>* 상품 정보(jsp Beans 사용) *</h2>
<table border="1">
	<tr>
		<th>번호</th><th>서명</th><th>저자</th><th>출판사</th><th>출판일</th><th>썸네일</th>
		<%
		ArrayList<BookDto> list = connClass.getDataAll();
				for(BookDto s:list){
		%>
			<tr>
				<td><%=s.getBnum() %></td>
				<td><%=s.getTitle() %></td>
				<td><%=s.getAuthor() %></td>
				<td><%=s.getPublisher() %></td>
				<td><%=s.getPyear() %></td>
				<td><%=s.getThumb_nail() %></td>
			</tr>
			<%
		}
		%>
	</tr>
</table>

</body>
</html>