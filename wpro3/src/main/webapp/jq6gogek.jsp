<<<<<<< HEAD
<%@page import="javax.servlet.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"

    pageEncoding="UTF-8"%>
  

[
<%
/* 
JSP 파일에서 DB 자료를 읽어와서 JSON 파일 형태로 변환하는 방법 (.jsp 파일 초기 세팅)

1. 위의 contentType을 text/html에서 text/plain으로 바꿔줘야 함 

2. 아래 HTML 태그들은 모두 삭제 */
//HTML에서 자바 문장을 쓰기 위해 지시어 를 붙여줌
//직원 테이블을 읽어 XML 형식으로 출력 
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String arg = request.getParameter("arg");

try{
	Class.forName("org.mariadb.jdbc.Driver");
	String Url ="jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(Url, "root", "123");
	pstmt = conn.prepareStatement("select gogek_name,gogek_tel from gogek inner join jikwon on jikwon_no=gogek_damsano where jikwon_no=?");
	pstmt.setString(1, arg);
	rs = pstmt.executeQuery();
	
	String result = "";
	
	while(rs.next()){
		result += "{"; //""를 "" 사이에 json 형식으로 넣으려면 이스케이프 문자 \을 "앞에 추가해줘야 함
		result += "\"gogek_name\":" + "\"" + rs.getString("gogek_name") + "\",";
		result += "\"gogek_tel\":" + "\"" + rs.getString("gogek_tel") + "\"";
		result += "},";
	}
	if(result.length() > 0){
		result = result.substring(0,result.length() - 1);
		// 전체 길이 - 1만큼만 반환 , 위의 result에 마지막 , 제거하기 위함
	}
	out.print(result);
}catch(Exception e){
	System.out.println("에러 : " + e);
	
}finally{
	try {
		rs.close();
		pstmt.close();
		conn.close();
	}catch (Exception e){
		
	}
}
%>
]
=======
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"

    pageEncoding="UTF-8"%>
  

[
<%
/* 
JSP 파일에서 DB 자료를 읽어와서 JSON 파일 형태로 변환하는 방법 (.jsp 파일 초기 세팅)

1. 위의 contentType을 text/html에서 text/plain으로 바꿔줘야 함 

2. 아래 HTML 태그들은 모두 삭제 */
//HTML에서 자바 문장을 쓰기 위해 지시어 를 붙여줌
//직원 테이블을 읽어 XML 형식으로 출력 
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String arg = request.getParameter("arg");

try{
	Class.forName("org.mariadb.jdbc.Driver");
	String Url ="jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(Url, "root", "123");
	pstmt = conn.prepareStatement("select gogek_name,gogek_tel from gogek inner join jikwon on jikwon_no=gogek_damsano where jikwon_no=?");
	pstmt.setString(1, arg);
	rs = pstmt.executeQuery();
	
	String result = "";
	
	while(rs.next()){
		result += "{"; //""를 "" 사이에 json 형식으로 넣으려면 이스케이프 문자 \을 "앞에 추가해줘야 함
		result += "\"gogek_name\":" + "\"" + rs.getString("gogek_name") + "\",";
		result += "\"gogek_tel\":" + "\"" + rs.getString("gogek_tel") + "\"";
		result += "},";
	}
	if(result.length() > 0){
		result = result.substring(0,result.length() - 1);
		// 전체 길이 - 1만큼만 반환 , 위의 result에 마지막 , 제거하기 위함
	}
	out.print(result);
}catch(Exception e){
	System.out.println("에러 : " + e);
	
}finally{
	try {
		rs.close();
		pstmt.close();
		conn.close();
	}catch (Exception e){
		
	}
}
%>
]
>>>>>>> branch 'main' of https://github.com/joon9001/java_source.git
