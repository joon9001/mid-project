<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="reply.ReplyBean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="replyMgr" class="reply.ReplyMgr"/>
<%request.setCharacterEncoding("utf-8");%>
<%
bean.setReply_ip(request.getRemoteAddr()); //클라이언트의 ipaddress 
bean.setReply_create_date(bean.getReply_create_date());//클라이언트의 작성날짜등록

int newNo= replyMgr.currentMaxNo()+1; 
bean.setReply_no(newNo);
bean.setReply_gnum(newNo);

replyMgr.saveData(bean); 

response.sendRedirect("../bookview/view.jsp"); 
%>