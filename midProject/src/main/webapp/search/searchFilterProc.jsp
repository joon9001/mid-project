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

// searchFilterBook.js에서 ajax로 보내준 title, author, publishier, pyear 데이터를 
// request.getParameter로 받아 title, author, publishier, pyear 변수에 저장한다.

if (pyearStr != null && !pyearStr.isEmpty()) {
    try {
        pyear = Integer.parseInt(pyearStr);
    } catch (NumberFormatException e) {

        pyear = null;
    }
}
//출판일인 pyear는 int로 BookDto에서 선언했기 때문에 int로 받아야하지만 request.getParameter는 String만 받을 수 있으므로
//pyearStr 변수에 String으로 받아 저장 후 parseInt를 통해 int형으로 pyear에 저장한다.
//단, null 값을 int로 변환할 시 오류가 발생하므로 if 조건문을 줘서 pyearStr이 null 값이 아니거나 비어있지 않을 경우에만 int로 변환한다.

String bnumStr = request.getParameter("bnum");
Integer bnum = null;
if (bnumStr != null && !bnumStr.isEmpty()) {
    try {
    	bnum = Integer.parseInt(bnumStr);
    } catch (NumberFormatException e) {
    
        bnum = null;
    }
}

//bnum도 bookDto에서 int로 선언했기 때문에 pyear와 마찬가지로 string으로 데이터를 받은 후 조건문을 줘서 int로 변환하는 작업을 수행한다.
searchBookFilterDB search = new searchBookFilterDB();
ArrayList<BookDTO> result = search.getResult(title, author, publisher, pyear, bnum);
%>

<%--searchBookFilterDB의 객체 인스턴스를 생성하여 search 변수에 저장한 후 title, author, publisher, pyear, bnum변수를 인수로 넣어
getresult함수를 실행하면 return 되는 result 배열 값을 BookDto 타입의 result 배열 변수에 저장한다.  --%> 

<table>
    <tr>
    	<th>번호</th>
        <th>제목</th>
        <th>작가</th>
        <th>출판사</th>
        <th>출판일</th>
    </tr>
    <%--위에서 저장한 배열변수 result의 값을 enhanced for문의 s 변수에 차례대로 넣어준 후  
    아래 get함수로 꺼내 테이블 형식으로 차례대로 출력한다.--%>
    <%
    for (BookDTO s : result) {
    %>
    <tr>
    	<td><a href="../bookview/view.jsp?reply_book_no=<%= s.getBnum() %>"><%= s.getBnum() %></a></td>
        <td><%= s.getTitle() %></td>
        <td><%= s.getAuthor() %></td>
        <td><%= s.getPublisher() %></td>
        <td><%= s.getPyear() %></td>
    </tr>
    <%
    }
    %>
</table>
