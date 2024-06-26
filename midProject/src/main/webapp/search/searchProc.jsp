<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="book.BookDTO" %>
<%@ page import="search.searchBookDB" %>

<%
String title2 = request.getParameter("title");
System.out.println("searchProc.jsp에서 title2 값 받음: " + title2);

searchBookDB search2 = new searchBookDB();
ArrayList<BookDTO> result2 = search2.getResult(title2);
System.out.println("searchProc.jsp에서 searchBookDB의 result2 값 받음: " + result2);
%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/searchBook.js"></script>
<table>
    <tr>
        <th>제목</th>
    </tr>
    <%
    for (BookDTO t : result2) {
    %>
    <tr>
        <td><%= t.getTitle() %></td>
    </tr>
    <%
    }
    %>
</table>
