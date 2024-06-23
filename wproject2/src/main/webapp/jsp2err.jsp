<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 jsp문서는 예기치 않은 에러가 발생하는경우 대처용. 그래서 isErrorPage="true"적어줌
<br>
고객님 놀라지마세요~
<br>
<%="에러원인은 "+exception.getMessage() %> <!-- expression 내장 객체 중 하나 -->

</body>
</html>