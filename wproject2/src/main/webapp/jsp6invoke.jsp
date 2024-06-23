<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 이jsp파일은 비즈니스 로직(db, 연산 등) 처리용. 출력에는 불참.
String data= request.getParameter("data");
String msg= "Mr."+data;

//1. redirect 방식으로 파일 호출
//컬랙션 안됨. 스트링 객체만 ?뒤에 이어붙이는 형식으로만 가.
//response.sendRedirect("jsp6invoked.jsp?data="+msg);
//response.sendRedirect("jsp6invoked.jsp?data="+msg+"&data2="+msg2);

//2. forward방식으로 파일호출
request.setAttribute("dd", msg);

//컬랙션 담아보자
ArrayList<String> list= new ArrayList<String>();
list.add("mouse");
list.add("pen");
list.add("book");
request.setAttribute("product", list); 

//request.getRequestDispatcher("jsp6invoked.jsp").forward(request, response);
//우리눈엔 안보이지만 서비스메소드오버라이딩이므로 리퀘스트 리스펀스 반드시넘겨줘야한다
// 이 문장은 하단예시처럼 자바 밖에서 액션태그로 부를수있다. 
%>
<jsp:forward page="jsp6invoked.jsp"></jsp:forward>