<%@ page import="java.util.ArrayList" %>
<%@ page import="reply.ReplyDto" %>
<%@ page import="book.BookDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="replyMgr" class="reply.ReplyMgr" />
<jsp:useBean id="dto" class="reply.ReplyDto" />
<jsp:useBean id="bdto" class="book.BookDTO" />
<jsp:useBean id="bookMgr" class="book.BookMgr" />

<%
int bno = 12233485; //책번호

// bno를 request로부터 받습니다.
if (request.getParameter("bnum") != null) {
    try {
        bno = Integer.parseInt(request.getParameter("bnum"));
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
}

System.out.println("Debug: bno in view.jsp = " + bno);  // 디버깅 출력
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세 정보 출력</title>
</head>
<body>

<h2>책 상세 정보 출력</h2>

<%
BookDTO bookdto = bookMgr.getBook(bno);
%>
<table>
    <tr>
        <td rowspan="2"><img src="../images/<%= bookdto.getThumb_nail() %>"></td>
        <td style="vertical-align: top;">
            <table style="width: 100%">
                <tr>
                    <td>책 제목:</td>
                    <td><%= bookdto.getTitle() %></td>
                </tr>
                <tr>
                    <td>저자:</td>
                    <td><%= bookdto.getAuthor() %></td>
                </tr>
                <tr>
                    <td>출판사:</td>
                    <td><%= bookdto.getPublisher() %></td>
                </tr>
                <tr>
                    <td>발행년도:</td>
                    <td><%= bookdto.getPyear() %></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>평점 / 리뷰수</td>
    </tr>
    <tr>
        <td colspan="2" align="right" height="30">
            <input type="button" value="리뷰 작성" onClick="location.href='../reply/replyinsert.jsp?bno=<%= bno %>'">
            <!-- 화면전환을 해주어서 작성페이지로 넘어가게 해야합니다. -->
        </td>
    </tr>
</table>

<form action="replydetails.jsp?reply_no=" name="detailForm" method="get">
    <!-- 해당 리뷰의 제목을 눌러서 상세보기로 넘어간다. 이때 리뷰번호 정보를 가지고 가야한다. -->
    <table style="width: 80%">
        <tr style="background-color: beige;">
            <th>번호</th>
            <th>제목</th>
            <th>작성자id</th>
            <th>작성일</th>
            <th>좋아요 수</th>
        </tr>
        <%
        // 책 상세페이지 보여줄 때 URL에 책 넘버가 적히게 된다. URL 접근 방법 제한 두기
        try {
            bno = Integer.parseInt(request.getParameter("bnum"));
        } catch (Exception e) {
            bno = 1;
        }
        if (bno <= 0) bno = 1;

        ArrayList<ReplyDto> list = replyMgr.getDataAll(bno);

        for (int i = 0; i < list.size(); i++) {
            dto = (ReplyDto) list.get(i);
        %>
        <tr style="text-align: center;">
            <td><%= dto.getReply_no() %></td>
            <td><a href="../reply/replydetails.jsp?reply_no=<%= dto.getReply_no() %>"><%= dto.getReply_title() %></a></td>
            <td><%= dto.getReply_id() %></td>
            <td><%= dto.getReply_create_date() %></td>
            <td><%= dto.getReply_like_cnt() %></td>
        </tr>
        <%
        }
        %>
    </table>
    <input type="hidden" name="reply_no">
</form>

</body>
</html>
