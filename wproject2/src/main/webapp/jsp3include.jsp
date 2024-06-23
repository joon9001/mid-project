<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file ="jsp3top.jsp" %> 
<!-- 이 파일의 소스가 들어와서 실행되는것. -->
<h1>include 연습</h1>
include 지시어: 여러 jsp파일에서 공통으로 사용할 부분을 
별도 파일로 작성후 필요할 때 포함시킨다.
<pre>
여기는 
본---- 문
입니다.
</pre>
++ 여기는 include action tag포함파일 결과출력지역 ++<br>
<jsp:include page="jsp3tag1.jsp" />
<br>
작~~ 업~~ 중~~
<br>
<div style="color: pink; font-size: 30px"> 
	<jsp:include page="jsp3tag2.jsp"> 
	<jsp:param value="good" name="msg"/>
	</jsp:include>
</div>
<%@include file ="jsp3bottom.jsp" %> 
</body>
</html>