<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mbc = request.getParameter("msg");
   
%>

<jsp:useBean id="my" class="pack.Para1Class"></jsp:useBean>
<!--패키지명 찍고 클래스들어가야한다. 형식. -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Beans 연습: 빈즈에 값 전달</b>
<%
// 우리가 현재까지 알고 있는 기술 사용.
my.setMsg(mbc); //html에서 값넣어 전달했기에 good찍힘
out.println("<br>메세지 출력(비추): "+ my.getMsg());
%>
<br>
<!-- String msg= req.getp(): 내부적으로 자동처리됨. 
파라미터의 이름과 셋프로퍼티의 이름과 같고, 셋프로터피를 가진 클래스의 멤버필드와도 같아야함. -->
<jsp:setProperty property="msg" name="my" value="kbs"/> 
<br>메세지출력(액션태그사용.강추!) : <jsp:getProperty property="msg" name="my"/>
msg는 사실 setmsg, getmsg임. 밸류값 따로 넣어주면 그 밸류가 넘어간다
클라이언트에서 변수명은 클래스의 멤버필드명과 같게 만든다.
게터세터는 권고하는 그약속에 맞게 쓴다.
jsp에서 받을때 
</body>
</html>