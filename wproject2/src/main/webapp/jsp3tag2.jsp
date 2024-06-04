<!-- 
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
소스코드를 들여다보면 하단의내용은 이 영역내에 기술된다. 
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = request.getParameter("msg");
//jsp는 맨 윗줄의 httprequest 객체를 service()메소드가 선언한 부분이 생략되어있으므로 따로 객체 생성없이 바로 request를 써도 된다.
out.println("msg는 " + msg);
%>