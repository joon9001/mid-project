<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="replyBean" class="reply.ReplyBean" scope="request"/>
<jsp:setProperty property="*" name="replyBean"/>
<jsp:useBean id="replyMgr" class="reply.ReplyMgr"/>
<%
//진짜.. 안넘어 오는 이유좀..누가 알려줘..ㅠㅜ
System.out.print(request.getParameter("reply_title"));
System.out.print(request.getParameter("reply_point"));
System.out.print(request.getParameter("reply_cont"));
System.out.print(request.getParameter("reply_title"));
System.out.print(request.getParameter("reply_image"));
System.out.print(" + dfsfdf : " + replyBean.getReply_image());
System.out.print(" + d1111 : " + replyBean.getReply_cont());
System.out.print(" + df2222 : " + replyBean.getReply_cont());
System.out.print(" + df3333 : " + replyBean.getReply_del_is());
System.out.print(" + df4444 : " + replyBean.getReply_like_cnt());
//int reply_no= Integer.parseInt(request.getParameter("reply_no"));
//int reply_book_no= Integer.parseInt(request.getParameter("reply_book_no"));
/*

	replyMgr.saveEdit(replyBean);
	response.sendRedirect("../bookview/view.jsp?reply_book_no=" + reply_book_no);
*/
%> 
