<!-- 
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
소스코드를 들여다보면 하단의내용은 이 영역내에 기술된다. 
 -->
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 출력용 자바:jsp, 내부처리용 자바: Servlet -->
<h1>JSP의 이해</h1>
<% // scriptlet: 이 안은 자바. 자바코드를 입력할 수 있는 영역.
//''작은따옴표 불가. ""큰따옴표 사용. 
String irum= "한국인"; //service 메소드 내에 선언된 지역변수
System.out.println(irum);//서버컴의 콘솔로 출력(개발자가 뭔가 출력하고자할때 사용)
// out: PrintWriter 객체타입의 내장객체 중 하나.
out.println(irum+"님의 홈페이지입니다");//클라이언트 브라우져로 출력
%>
<br>
<%= irum+"님의 홈페이지입니다" %><!-- 상동. 표현식 expression. 출력문 1개만 가. 출력문뒤 ; 안적음-->
<br>
<h1>자바 만세</h1>
<h2>자바 만세</h2>
<h3>자바 만세</h3>
<h4>자바 만세</h4>
<h5>자바 만세</h5>
<h6>자바 만세</h6>
<%
for(int i=1; i< 7; i++){
	out.print("<h"+ i + ">");
	out.print("자바 빠샤");
	out.println("</h"+ i + ">");
}
%>
현재 날짜 및 시간<%= new Date() %>
<br>
<%
int a=0, sum=0;
do{
	a++;
	sum +=a;
}while(a<10);

out.println("10까지의 합은 "+sum);
%>
<br>
<%= "10까지의 합은 "+sum %>
<hr>
<%= irum+"님의 전화번호는 "+ junhwa %>
<%! 
// js는 호이스팅 기능있어서 선언순서무관. 
// 자바는 선 선언, 후 사용이 일반적. 
// <%!: 전역변수. 그래서 선언순서와 무관해진다. 
String junhwa= "111-1234";

//클래스 멤버 메소드
public int dataAdd(int su1, int su2){
	return su1+su2;
}
%>
<%
/*err. service메소드안에서 또 메소드를 쓰는격. 
public int dataAdd(int su1, int su2){
	return su1+su2;
}*/
%>
<br>
<%=dataAdd(10, 20)
%>



</body>
</html>