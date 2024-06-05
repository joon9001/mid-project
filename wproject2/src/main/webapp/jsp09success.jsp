<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 세션 읽기
HttpSession ses = request.getSession(false);
if(ses != null && ses.getAttribute("userid") != null){
	String userid = (String)ses.getAttribute("userid");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 성공 페이지</h2>
<p>환영합니다. <%=userid %> 님아 ㅋㅎ</p>
인증에 성공한 경우 처리 할 뭔가를 작업 여기서 인가(Authorization)
<br>
할거 할 수 있슴둥......... 쇼핑하시던지 글 쓰시던징
<br>
<a href="jsp09logout.jsp">로그아웃</a>
</body>
</html>
<%
}else{
	// 로그인 없이 호출된 경우
	response.sendRedirect("jsp09sessionlogin.html");
}

%>