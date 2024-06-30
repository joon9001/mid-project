<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="book.BookDTO" %>
<%@ page import="search.searchBookDB" %>

<%
String title2 = request.getParameter("title");


searchBookDB search2 = new searchBookDB();
ArrayList<BookDTO> result2 = search2.getResult(title2);

%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/searchBook.js"></script>

<h2 class="results-title">검색결과 </h2> <!-- 제목 추가 -->

<table class="results-table">
    <tr>
        <th>제목</th>
        <th>작가</th>
        <th>출판사</th>
        <th>출판일</th>
    </tr>
    <%--result2 리스트의 각 요소를 BookDTO 타입의 변수 t에 저장함. --%>
    <%
    for (BookDTO t : result2) {
    %>
    <tr>
    <%--t.getTitle() 메서드를 호출해 BookDTO 객체의 title, author, publisher, pyear를 가져와 테이블 셀에 삽입함. --%>
        <td><%= t.getTitle() %></td>
        <td><%= t.getAuthor() %></td>
        <td><%= t.getPublisher() %></td>
        <td><%= t.getPyear() %></td>
    </tr>
    <%
    }
    %>
</table>
