<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버에 의해 호출(Servlet이 호출)된 파일<br>
<% 
// redirect 방식<br>
String mydata = request.getParameter("data");
out.println("redirect로 전송된 데이터는 " + mydata);
out.println("<hr>");
// forward 방식
String ourdata = (String)request.getAttribute("datas");
out.println("forward로 전송된 데이터는 " + ourdata);

%>

</body>
</html>