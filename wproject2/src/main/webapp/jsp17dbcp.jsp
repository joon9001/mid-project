<%@page import="pack.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="connP" class="pack.ConnPooling" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function funcUp(){
	//alert("u"); 
	let code= prompt("수정할 코드 입력", "");
	if(code !== "" && code !== null){
		location.href="jsp17up.jsp?code="+code;
	}
}
function funcDel(){
	//alert("d"); //삭제는 꼭 다시 한번 확인하는 알람을 뜨게 해줘야한다. 정말 삭제?? 이를 위해 하단에 confirm씀.
	let code= prompt("삭제할 코드 입력", "");
	if(code !== "" && code !== null){
		if(confirm("정말삭제할까요??")){ 
		location.href="jsp17del.jsp?code="+code;	
		}
	}
}

</script>
</head>
<body>
<h2>상품 정보(DBCP)</h2>

<hr>
<a href="jsp17ins.html">추가</a>&nbsp;&nbsp;
<a href="javascript:funcUp()">수정</a>&nbsp;&nbsp;
<a href="javascript:funcDel()">삭제</a>&nbsp;&nbsp;
<br><br>
<table border="1">
<tr>
<td>코드</td><td>품명</td><td>수량</td><td>단가</td>
</tr>
<%
ArrayList<SangpumDto> slist= (ArrayList)connP.getDataAll();
//out.print(slist.size());
for(SangpumDto s:slist){
%>
<tr>
<td><%=s.getCode() %></td>
<td><%=s.getSang() %></td>
<td><%=s.getSu() %></td>
<td><%=s.getDan() %></td>
</tr>
<%

}
%>
</table>
</body>
</html>