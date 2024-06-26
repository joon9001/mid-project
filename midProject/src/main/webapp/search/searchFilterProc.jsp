<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="book.BookDTO" %>
<%@ page import="search.searchBookFilterDB" %>
<%
String title = request.getParameter("title");
String author = request.getParameter("author");
String publisher = request.getParameter("publisher");
String pyearStr = request.getParameter("pyear");
Integer pyear = null;

System.out.println("searchFilterProc.jsp에서 title 값 받음: " + title);
System.out.println("searchFilterProc.jsp에서 author 값 받음: " + author);
if (pyearStr != null && !pyearStr.isEmpty()) {
    try {
        pyear = Integer.parseInt(pyearStr);
    } catch (NumberFormatException e) {
        // Handle the case where pyearStr is not a valid integer
        // You may want to set pyear to null or handle this scenario appropriately
        pyear = null;
    }
}

searchBookFilterDB search = new searchBookFilterDB();
ArrayList<BookDTO> result = search.getResult(title, author, publisher, pyear);
System.out.println("searchProc.jsp에서 searchBookDB의 result 값 받음: " + result);
%>


<table>
    <tr>
        <th>제목</th>
        <th>작가</th>
        <th>출판사</th>
        <th>출판일</th>
    </tr>
    <%
    for (BookDTO s : result) {
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
