<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");

//request.setAttribute("idkey", id); // 현재 jsp 파일에서만 유효 (다른 파일에서 참조할 경우 request 값도 넘겨줘야함)
//application.setAttribute("idkey", id); //현재 서비스 중 모두에게 유효

//Servlet인 경우 HttpSession session = request.getSession(true) 로 객체부터 생성해야함
//jsp의 경우 session.setAttribute("idkey", id)로 객체 생성없이 바로 session 생성 
session.setAttribute("idkey", id); //세션을 참조하는 파일에서만 유효(클라이언트 별로 값이 달라짐)
session.setMaxInactiveInterval(10);
//서버가 클라이언트 컴에 sessionid를 쿠키에 저장해둠.
//다음부터는 클라이언트가 서버에 정보 요청 시 sessionid가 담긴 쿠키를 들고 감.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>* 세션 연습 *</h2>
<form action="jsp7session2.jsp">
보고 싶은 영화 선택 : <br>
<input type="radio" name="movie" value="원더랜드" checked="checked">원더랜드
&nbsp;&nbsp;
<input type="radio" name="movie" value="퓨리오사">퓨리오사
&nbsp;&nbsp;
<input type="radio" name="movie" value="설계자">설계자
<input type="submit" value="결과보기">
</form>
</body>
</html>