<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mbc = request.getParameter("msg");
%>

<jsp:useBean id="my" class="pack.Para1Class"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Beans 연습 : 빈즈에 값 전달</b>
<%
// 우리가 현재까지 알고있는 기술
my.setMsg(mbc);
out.println("<br>메세지 출력 : " + my.getMsg());
%>
<br>

<!-- String msg = request.getParameter("msg"); 이게 내부적으로 자동처리. 파라미터의 이름과 setProperty의 이름이 같아야함 -->
<jsp:setProperty property="msg" name="my"/>	<%-- setter 부르기 --%>
<br> 메세지 출력(action tag 사용) : 
<jsp:getProperty property="msg" name="my"/> <%-- getter 부르기 --%>


</body>
</html>