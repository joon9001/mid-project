<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="searchFilter.BookDto" %>
<%@ page import="searchFilter.searchDB" %>

<%
String title = request.getParameter("title");
String author = request.getParameter("author");
String publisher = request.getParameter("publisher");
String pyearStr = request.getParameter("pyear");
Integer pyear = null;

if (pyearStr != null && !pyearStr.isEmpty()) {
    try {
        pyear = Integer.parseInt(pyearStr);
    } catch (NumberFormatException e) {
        // Handle the case where pyearStr is not a valid integer
        // You may want to set pyear to null or handle this scenario appropriately
        pyear = null;
    }
}

searchDB search = new searchDB();
ArrayList<BookDto> result = search.getResult(title, author, publisher, pyear);
%>
<table border="1">
    <tr>
        <th>제목</th>
        <th>작가</th>
        <th>출판사</th>
        <th>출판일</th>
    </tr>
    <%
    for (BookDto s : result) {
    %>
    <tr>
        <td><%= s.getTitle() %></td>
        <td><%= s.getAuthor() %></td>
        <td><%= s.getPublisher() %></td>
        <td><%= s.getPyear() %></td>
    </tr>
    <%
    }
    %>
</table>
