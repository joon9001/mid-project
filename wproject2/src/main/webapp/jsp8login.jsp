<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
//로그인 성공하면 loginok. 실패하면 loginfail로 이동하는 로직 처리.
String id= request.getParameter("id");
String pwd= request.getParameter("pwd");

if((id.equals("admin") && pwd.equals("111")) ||
		(id.equals("user") && pwd.equals("222"))){
	session.setAttribute("id", id); //세션생성
	response.sendRedirect("jsp8loginok.jsp");// 클라이언트마다 다른값줄수있다. 세션이기에.
	//단점. 클라이언트마다 세션생성. 서버부담증가. 세션대신 jdt씀. 
	
	//서블릿에서 연습했던 장바구니 문제 > jsp로 만들어보기. 
	
	/*
	//세션말고 request쓸경우 
	request.setAttribute("id", id);
	request.getRequestDispatcher("jsp8loginok.jsp").forward(request, response); //forward로 해야 넘어옴.
	*/
	
}else{
	response.sendRedirect("jsp8loginfail.html");
}
%>