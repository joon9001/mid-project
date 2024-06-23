<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
/*
//전부다 값을 담을 수 있는 컨테이너. 내장객체들. 
request.setAttribute("idkey", id); // 현jsp파일에서만 유효(like private)
//따라서 다른 jsp파일에서는 값을 받으려면, request response를 다 해줘야함.
application.setAttribute("idkey", id);// 현서비스중 모두에게 유효(like public)
//어디서든 통한다. 그래서 오히려 잘 안 쓰인다.
*/
//Servlet인 경우, 
//HttpSession session= request.getSession(true);
//session.setAttribute("idkey", id); 이렇게 씀. 밑은 jsp의 경우.

session.setAttribute("idkey", id); // 세션을 참조하는 파일에서만 유효
session.setMaxInactiveInterval(10);
//클라이언트가 누구냐가 중요. 갑이 세션만들어, idkey 만들고 갑넣어준뒤, 다른 jsp파일에서 부르면 불린다.
//을이 와서 세션만들어, idkey 만들고 을넣어준뒤, 다른 jsp에서 불러도 을이 불린다. 
//클라이언트별로 영역이 설정되어 나뉘기에, value가 달라진다.
//서버가 클라이언트컴에 session id를 쿠키에 저장해둔다. 이후에는 클라이언트가 서버에 정보요청시 sessionid가 담긴 쿠키를 들고감.
%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>세션 연습</h2>
<form action="jsp7session2.jsp">
보고 싶은 영화선택: <br>
<input type="radio" name="movie" value="원더랜드" checked="checked">원더랜드&nbsp;&nbsp;
<input type="radio" name="movie" value="퓨리오사" checked="checked">퓨리오사&nbsp;&nbsp;
<input type="radio" name="movie" value="설계자" checked="checked">설계자&nbsp;&nbsp;
<input type="submit" value="결과보기">

</form>
</body>
</html>