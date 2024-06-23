<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 출력용X. 로직용 파일. --%>
<%
String id= request.getParameter("id");
String pwd= request.getParameter("pwd");

//인증 authentication: 실제는 DB정보를 읽어 확인. 지금은 하나로 고정.
String validId= "ok";
String validPwd= "123";

if(id != null && pwd != null & id.equalsIgnoreCase(validId) && pwd.equalsIgnoreCase(validPwd)){
	//인증이 유효한경우
	HttpSession ses= request.getSession();
	ses.setAttribute("userid", id); //세션 생성 후 sessionid를 클라이언트컴 쿠키에 저장
	
	//성공한 경우 보여줄 페이지로 이동
	response.sendRedirect("jsp9success.jsp");//jsp파일말고 html파일로도 만들수있다. 
		
}else{
	//인증에 실패한경우
	out.println("<html><body>");
	out.println("<h3>로그인실패</h3>");
	out.println("<a href='jsp9sessionlogin.html'>다시 시도</a>");
	out.println("</body></html>");
}
	

%>