<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"

    pageEncoding="UTF-8"%>
  
   
{"sangpum":[
<%
/* 
JSP 파일에서 DB 자료를 읽어와서 JSON 파일 형태로 변환하는 방법 (.jsp 파일 초기 세팅)

1. 위의 contentType을 text/html에서 text/plain으로 바꿔줘야 함 

2. 아래 HTML 태그들은 모두 삭제 */
//HTML에서 자바 문장을 쓰기 위해 지시어 를 붙여줌
//sangdata 테이블을 읽어 XML 형식으로 출력 
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
	Class.forName("org.mariadb.jdbc.Driver");
	String Url ="jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(Url, "root", "123");
	pstmt = conn.prepareStatement("select * from sangdata");
	rs = pstmt.executeQuery();
	
	Thread.sleep(5000);
	
	//rs.next();
	//out.print(rs.getString("sang"));
	String result = "";
	
	while(rs.next()){
		result += "{";
		result += "\"code\":" + "\"" + rs.getString("code") + "\",";
		result += "\"sang\":" + "\"" + rs.getString("sang") + "\",";
		result += "\"su\":" + "\"" + rs.getString("su") + "\",";
		result += "\"dan\":" + "\"" + rs.getString("dan") + "\"";
		result += "},";
	}
	if(result.length() > 0){
		result = result.substring(0,result.length() - 1);
		// 전체 길이 - 1만큼만 반환 
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
}


    
   