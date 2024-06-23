<%@page import="java.util.Base64"%>
<%@page import="java.util.Date"%>
<%@page import="io.jsonwebtoken.Jwts"%>
<%@page import="javax.servlet.*"%>
<%@page import="io.jsonwebtoken.security.Keys"%>
<%@page import="java.security.Key"%>
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
	//순서대로 확인하고 넘어가려고 굳이 id != null 같은 부분을 앞에 적어준것. 여기서 조건충족이 되면 뒷부분 넘어가버림 
	//인증이되면 jwt를 생성(비밀키, 서명, 만료시간등을 설정)
	//생성된 jwt를 클라이언트 storage에 넣으면 xss 보안위험있다. 따라서 cookie에 넣는다.
	//그 후 성공 페이지로 이동
	// 고정된 비밀 키 사용 (예제용)  최소 256비트 길이의 비밀 키
//String secretKeyString = "mySuperSecretKey12345678901234567890123456789012";
//Key secretKey = Keys.hmacShaKeyFor(secretKeyString.getBytes());
//Keys.hmacShaKeyFor() 메서드: key byte array를 기반으로 적절한 HMAC 알고리즘을 적용한 Key(java.security.Key) 객체를 생성

// 위의 작업을 주석 처리하고 아래 내용으로 변경하자.
    // 서블릿 컨텍스트에서 Base64로 인코딩된 비밀 키 가져오기  java.util.Base64
    // 사용법. 그냥알려주는것 따라쓰는것. 
    String encodedKey = (String) getServletContext().getAttribute("secretKey");
    byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
    Key secretKey = Keys.hmacShaKeyFor(decodedKey);
    //서버실행시 콘솔창에 encodedKey가 뜬다. 

long expirationTime= 3600000;// 1시간. 밀리초 단위로 기입.

//JWT 생성: 문자열로 반환되며, 인증및권한부여. 메커니즘에서 주로사용.
String jwt= Jwts.builder()
	.setSubject(id) //id, 사용자 식별자, 주제 등이 포함된 클레임 설정
	.setIssuedAt(new Date())//클레임내용 중 lat: 발행시간
	.setExpiration(new Date(System.currentTimeMillis() + expirationTime))//클레임내용 중 exp:만료시간. 1시간
	.signWith(secretKey) //서명알고리즘, 비밀키설정. 무결성 보장이목적.
	.compact();//jwt 생성

//클라이언트쿠키에 jwt를 저장
	Cookie jwtCookie = new Cookie("jwt", jwt);
	jwtCookie.setHttpOnly(true);
	jwtCookie.setPath("/"); // /:모든경로에서 쿠키접근가.
	response.addCookie(jwtCookie);
	
	//성공한 경우 보여줄 페이지로 이동
	response.sendRedirect("jsp10success.jsp");//jsp파일말고 html파일로도 만들수있다. 
		
}else{
	//인증에 실패한경우
	out.println("<html><body>");
	out.println("<h3>로그인실패</h3>");
	out.println("<a href='jsp10jwtlogin.html'>다시 시도</a>");
	out.println("</body></html>");
}
	

%>