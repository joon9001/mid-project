<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"

    pageEncoding="UTF-8"%>
    
    <!-- 
    JSP 파일에서 DB 자료를 읽어와서 XML 파일 형태로 변환하는 방법 (.jsp 파일 초기 세팅)
    
    1. 맨 위에 <?xml version="1.0" encoding="UTF-8"?>를 넣어주고
    
    2. 위의 contentType을 text/html에서 text/xml로 바꿔줘야 함 
    
    3. 아래 HTML 태그들은 모두 삭제-->

<sangpums>
<% //HTML에서 자바 문장을 쓰기 위해 지시어 <% 를 붙여줌
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
	
	//rs.next();
	//out.print(rs.getString("sang"));
	while(rs.next()){
%>  <!-- 자바 영역 끝, 이런 식으로 % 지시자를 통해 자바 영역을 시작하고 끝내는것이 
자유롭기 때문에 부분데이터 삽입이 가능한 것이 JSP이다-->
	<sangpum>
		<code><% out.print(rs.getString("code")); %></code>
		<sangirum><%= rs.getString("sang") %></sangirum> 
		<!-- out.print를 위와 같이 생략도 가능, ; 없어지는것에 주의 -->
		<su><%= rs.getString("su") %></su>
		<danga><%= rs.getString("dan") %></danga>
	</sangpum>
<% // 자바 영역 시작
	}
}
catch(Exception e){
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

</sangpums>


    
   