<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--상단의 import부분도 include파일에 적고, 여기서 지워도 된다. -->
<!-- 이클립스에서는 단일파일로 보기에, 지울시 에러뜸. 그러나 메모장작성후 구동시ok. -->
<hr>
<%
LocalTime sigan= LocalTime.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
out.println(sigan.format(formatter));
%>