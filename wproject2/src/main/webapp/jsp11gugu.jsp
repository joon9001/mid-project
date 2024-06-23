<%@page import="pack.Gugudan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 지금까지 배운 방법 사용 <br>
<%
int dan = Integer.parseInt(request.getParameter("dan"));
out.println(dan+ "단 출력<br>");

//Gugudan gugudan= new Gugudan(); //클래스포함관계. 호출할때마다 new 그때마다 인스턴스생성! NO!
//객체가 요청수만큼 생성됨.> 해결방법: 싱글톤패턴.
Gugudan gugudan= Gugudan.getInstance(); //클래스포함관계. 싱글톤 패턴. 1개만인스턴스.

int re[] = gugudan.computeGugu(dan); //클래스의 포함관계

for(int a=0; a<9; a++){
	out.println(dan + "*"+ (a+1) + "=" + re[a]+"&nbsp;&nbsp;");
}
%>
<hr>
JSP 액션태그중 useBean을 사용<br>
<jsp:useBean id="gugu" class="pack.Gugudan" scope="page"/> <!--Gugudan gugu= new Gugudan(); 와 비슷한뜻 -->
<%--
scope. page가 디폴트.  
Page : 페이지 내에서 지역변수처럼 사용. 매번 객체 생성. 현재 페이지에서만 유효하다는 뜻.
Request : http요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수가 유지되는 경우 사용. 매번 객체생성.
Session : 웹 브라우저 별로 변수가 관리되는 경우 사용. 객체1회만 생성.
Application : 웹 어플리케이션이 시작되고 종료될 때까지 변수가 유지되는 경우 사용. 객체1회만생성. 
               (모든 클라이언트에게공통적으로 무언가를 보여 줄때 사용)
 --%>

<%
int re2[] = gugu.computeGugu(dan); //클래스의 포함관계

for(int a=0; a<9; a++){
	out.println(dan + "*"+ (a+1) + "=" + re[a]+"&nbsp;&nbsp;");
}%>
</body>
</html>