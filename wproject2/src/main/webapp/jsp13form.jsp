<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

//String name = request.getParameter("name");	// 과거에 사용한 방법
%>

<jsp:useBean id="bean" class="pack.ExamBean"></jsp:useBean>


<!-- 
<jsp:setProperty property="name" name="bean"/> // 수신 값이 적을 때
 -->
<jsp:setProperty property="*" name="bean"/> <!-- 자동으로 수신된 값이 ExamBean의 멤버 필드에 저장됨. -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
폼빈에 등록된 자료 출력하기<br>
이름은 <jsp:getProperty property="name" name="bean"/><br>
국어 점수는 <jsp:getProperty property="kor" name="bean"/><br>
영어 점수는 <jsp:getProperty property="eng" name="bean"/><br>
수학 점수는 <jsp:getProperty property="math" name="bean"/><br>

<jsp:useBean id="process" class="pack.ExamProcess"></jsp:useBean>
<jsp:setProperty property="bean" name="process" value="<%=bean %>"/>
총점은 <jsp:getProperty property="tot" name="process"/>
<br>
평균은 <jsp:getProperty property="avg" name="process"/>

</body>
</html>