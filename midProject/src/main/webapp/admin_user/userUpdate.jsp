<%@page import="admin.AdminMgr"%>
<%@page import="admin.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="adminMgr" class="admin.AdminMgr" />
<jsp:useBean id="userBean" class="user.UserBean" />
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
//out.print(id);
adminMgr bean = adminMgr.getUser(id); 

if(bean == null){
	response.sendRedirect("../admin_user/adminUser.jsp");
	return;  //service 메소드를 탈출
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<link href="../css/adminMain" rel="stylesheet" type="text/css">
<script src="../js/adminMain.js"></script>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnUpdateOk").onclick=memberUpdateOk;
	document.getElementById("btnUpdateCancel").onclick=memberUpdateCancel;
	document.getElementById("btnDelete").onclick=memberDelete;
}
</script>
</head>
<body>
<form action="userUpdateproc.jsp" name="updateForm" method="post">
<table>
  <tr style="background-color: navy;">
  	<td colspan="2" style="color: white">
  		<b><%=bean.getUname() %></b> 회원님의 정보를 수정합니다 
  	</td>
  </tr>
  <tr>
  	<td>아이디</td>
  	<td><%=bean.getId() %></td>
  </tr>
  <tr>
  	<td>비밀번호</td>
  	<td>
  		<input type="password" name="pw" 
  			value="<%=bean.getPw()%>">
  	</td>
  </tr>
  <tr>
  	<td>회원명</td>
  	<td>
  		<input type="text" name="uname" value="<%=bean.getUname()%>">
  	</td>
  </tr>
  <tr>
  	<td>이메일</td>
  	<td>
  		<input type="text" name="email" value="<%=bean.getEmail()%>">
  	</td>
  </tr>
  <tr>
  	<td>성별</td>
  	<td>
  		<input type="text" name="gender" value="<%=bean.getGender()%>">
  	</td>
  </tr>
  <tr>
  	<td>상태</td>
  	<td>
  		<input type="text" name="user_stat" value="<%=bean.getUser_stat()%>">
  	</td>
  </tr>
  <tr>
  	<td>탈퇴여부</td>
  	<td>
  		<input type="text" name="signout_is" 
  			value="<%=bean.getSignout_is()%>" size="50">
  	</td>
  </tr>
  <tr>
  	<td>가입날짜</td>
  	<td>
  		<input type="text" name="sign_up_date" 
  			value="<%=bean.getSign_up_date()%>" size="50">
  	</td>
  </tr>
 
  <tr>
  	<td colspan="2" style="text-align: center;">
  		<input type="button" value="수정완료" id="btnUpdateOk">
  		<input type="button" value="수정취소" id="btnUpdateCancel">
  		<input type="button" value="회원탈퇴" id="btnDelete">
  	</td>
  </tr>
</table>
</form>
</body>
</html>





