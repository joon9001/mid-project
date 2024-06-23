<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8"); // 내장객체 request: 클라이언트로부터 요청처리
String id= request.getParameter("id");
String pwd= request.getParameter("pwd");

if(!(id.equals("aa") && pwd.equals("11"))){// aa&11이 아닌 값이 들어옴.
	response.sendRedirect("jsp4member.html");//내장객체 response: 클라이언트로부터 결과출력
}

String[] names= request.getParameterValues("name");
String job= request.getParameter("job");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
++ 전송된 입력 자료 확인 ++ <br>
아이디는 <% out.println(id+"<br>");//내장객체 out: 출력 스트림 객체 %>
이름은 <% out.println(names[0]+", 별명은 "+names[1]+"<br>"); //name은 여러개. 배열로 넘어오고받음.%>
직업은 
<% 
//어떠한 비즈니스 로직 처리.. 계속해서 여러 실행문을 적을수있다.
out.println(job);
//그러나 출력할실행문 하나인경우, 아래와같이 적을수있다.
%>
<%=job %>
<hr><br>
기타 정보: <br>
client ip: <%= request.getRemoteAddr() %><br>
client domain: <%= request.getRemoteHost() %><br>
Protocol: <%= request.getProtocol() %><br>
Method: <%= request.getMethod() %><br>
Server domain:  <%= request.getServerName() %><br>
<br>
Server buffer size= <%= response.getBufferSize() %><br>
Server CharacterEncoding= <%= response.getCharacterEncoding() %><br>
<br>
Context path: <%= application.getContextPath() %>
Session: <%= pageContext.getSession() %>

</body>
</html>