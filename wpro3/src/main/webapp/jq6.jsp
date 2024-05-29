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
PreparedStatement pstmt2 = null;
ResultSet rs = null;
ResultSet rs2 = null;

String bname = request.getParameter("bname");
//bname은 임의로 정해준 변수명이고 밑에 setString에서 사용된다.
try{
	Class.forName("org.mariadb.jdbc.Driver");
	String Url ="jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(Url, "root", "123");
	pstmt = conn.prepareStatement("select * from jikwon inner join buser on buser_num=buser_no where buser_name like ?");
	pstmt.setString(1, bname +"%");
	rs = pstmt.executeQuery();
	
	String result = "";
	
	while(rs.next()){
		result += "{"; //""를 "" 사이에 json 형식으로 넣으려면 이스케이프 문자 \을 "앞에 추가해줘야 함
		result += "\"jikwon_no\":" + "\"" + rs.getString("jikwon_no") + "\",";
		result += "\"jikwon_name\":" + "\"" + rs.getString("jikwon_name") + "\",";
		result += "\"jikwon_jik\":" + "\"" + rs.getString("jikwon_jik") + "\",";
		
		//담당 고객수 구하기
		String sql = "select count(*) as cou from jikwon inner join gogek on jikwon_no=gogek_damsano where jikwon_no=?";
		pstmt2 = conn.prepareStatement(sql);
		pstmt2.setString(1, rs.getString("jikwon_no"));
		rs2 = pstmt2.executeQuery();
		rs2.next();
		
		result += "\"jikwon_gogek\":" + "\"" + rs2.getString("cou") + "\"";
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
		rs2.close();
		pstmt.close();
		pstmt2.close();
		conn.close();
	}catch (Exception e){
		
	}
}
%>
]
