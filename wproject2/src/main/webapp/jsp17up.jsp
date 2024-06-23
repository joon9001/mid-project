<%@page import="pack.SangpumDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String code= request.getParameter("code"); %>
<jsp:useBean id="connP" class="pack.ConnPooling"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
SangpumDto dto = connP.updateData(code);  
if(dto == null){ //자료가 없으면
%>
<script type="text/javascript">
alert("등록된 상품 코드가 아닙니다. \n 수정불가!");
//history.back();
location.href = "jsp17dbcp.jsp";
</script>
<%
return;
}
%>
<!-- 자료가있다면 -->
상품 수정
<form action="jsp17upok.jsp" method="post">
코드: <%=dto.getCode() %><br> <!-- 수정대상x. 보여만 주는것. -->
<!-- 그러나 자료수정 submit 할때 값이 넘어는가야한다. name 요. 그래서 hidden을 사용 -->
<input type="hidden" name="code" value="<%=dto.getCode() %>"> 
품명: <input type="text" name="sang" value="<%=dto.getSang() %>"><br>
수량: <input type="text" name="su" value="<%=dto.getSu() %>"><br>
단가: <input type="text" name="dan" value="<%=dto.getDan() %>"><br>
<br>
<input type="submit" value="자료수정"><!-- 자료검사는 생략했다.  -->
<input type="button" value="수정취소" onclick="javascript:location.href='jsp17dbcp.jsp'">
</form>
</body>
</html>