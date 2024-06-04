<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
    <!-- 원래 기본 jsp 페이지는 isErrorPage가 false로 되있는데 에러처리파일이므로 true로 설정해줌 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 jsp 문서는 예기치 않은 에러가 발생한 경우 대처용
<br>
고객님 릴렉스~
<br>
<%= "에러 원인은 " + exception.getMessage() %> <!-- exception 내장 객체 중 하나, 에러가 났을 경우 에러를 출력함 -->
</body>
</html>