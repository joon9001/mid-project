<?xml version="1.0" encoding="UTF-8"?> <!-- js34.xml 맨 첫줄에 선언된 문장 복붙 -->
<!-- XML파일 내보내기 -->
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!-- pageEncoding은 자바에 가져와 해석할 때 형식, contentType은 웹서버로 보낼 때 형식 -->
<jikwons> 
<%
String gubun = request.getParameter("gubun");
String name = request.getParameter("name");

// jikwons 테이블을 읽어 XML 형식으로 출력 
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;


try{
	Class.forName("org.mariadb.jdbc.Driver");
	
	String url="jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(url, "root", "123");
	
	String sql = "select jikwon_no,jikwon_name,jikwon_jik,jikwon_pay from jikwon";
	if (gubun.equals("all")){
		pstmt = conn.prepareStatement(sql);
	}else{
		pstmt = conn.prepareStatement(sql += " where jikwon_name like ?");
		pstmt.setString(1, name + "%");
	//name + "%"는 사용자가 입력한 이름의 앞부분과 일치하는 모든 이름을 검색하기 위한 패턴을 나타냅니다. 
	//여기서 %는 SQL에서 사용되는 와일드카드 문자로, 0개 이상의 임의의 문자를 의미합니다.
	}
	
	rs = pstmt.executeQuery();
	
	// rs.next();
	// out.print(rs.getString("sang"));
	while(rs.next()){

%>
		<jikwon>
			<sabun><% out.print(rs.getString("jikwon_no"));%></sabun>
			<irum><%= rs.getString("jikwon_name") %></irum>
			<jik><%= rs.getString("jikwon_jik") %></jik>
			<pay><%= rs.getString("jikwon_pay") %></pay>
		</jikwon>
<%
	}
}catch(Exception e){
	System.out.println("에러 : " + e);
}finally{
	try{
		rs.close();
		pstmt.close();
		conn.close();
	}catch(Exception e){
		
	}finally{
		
	}
}
%>	
</jikwons>
