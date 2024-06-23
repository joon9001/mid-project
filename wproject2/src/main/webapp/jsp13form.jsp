<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

//String name=request.getParameter("name"); // 전에는 이렇게 함.

%>

<jsp:useBean id="bean" class="pack.ExamBean"/>
<!--  
<jsp:setProperty property="name" name="bean"/> 수신값이 1개일때
-->
<!-- 수신값이 복수개일때는 하단과 같다. 수신된값이 ExamBean클래스의 멤버필드로 자동으로 들어간다. 이름은 꼭 맞춰줘야하는거 잊지말자. -->
<jsp:setProperty property="*" name="bean"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
FormBean에 등록된 자료 출력하기<br>
(세터에만 * 가. 게터는 *불가 제대로 지정요.)<br>
이름은 <jsp:getProperty property="name" name="bean"/><br>
국어: <jsp:getProperty property="kor" name="bean"/>&nbsp;&nbsp;
영어: <jsp:getProperty property="eng" name="bean"/>&nbsp;&nbsp;
수학: <jsp:getProperty property="mat" name="bean"/><br>

<jsp:useBean id="process" class="pack.ExamProcess"/>
<jsp:setProperty property="bean" name="process" value="<%=bean %>"/>
총점은 <jsp:getProperty property="tot" name="process"/>
<br>
평균은 <jsp:getProperty property="avg" name="process"/>
</body>
</html>