<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="userBean" class="user.UserBean" scope="page" />
<jsp:setProperty property="*" name="userBean" />
<jsp:useBean id="userMgr" class="user.UserMgr" />

<%
String id = (String)session.getAttribute("idKey");
boolean b = userMgr.userUpdate(userBean, id); 

if(b){
%>
	<script>
	alert("수정 성공");
	location.href="../guest/guest_index.jsp";
	</script>
<%}else{%>
	<script>
	alert("수정 실패\n관리자에게 문의 바람");
	history.back();
	</script>
<%	
}
%>






