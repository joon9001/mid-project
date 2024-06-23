<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//세션 읽기
HttpSession ses = request.getSession(false);

if(ses!= null&& ses.getAttribute("userid") != null){ //?왜굳이?
	String userid= (String)ses.getAttribute("userid");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 성공 페이지</h2>
== 이 영역이 Authorization(인가)영역 ==
<p>환영합니다. <%=userid %>를 사용하시는 분!</p>
인증에 성공한 경우 처리할 뭔가를 작업<br>
예: 쇼핑, 게시판, 방명록, 회의참여 등등
<br>
<a href='jsp9logout.jsp'>로그아웃</a>
<%
}else{
//로그인 없이 호출된 경우
//로그인에 아이디비번 쳐서 들어오는 정통적방법이 아니라, url주소창에 입력해서 들어오는 야매방법으로 들어오는 걸 방지하고자
response.sendRedirect("jsp9.sessionlogin.html");
}
%>
</body>
</html>