<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="connClass" class="pack.ConnClass3"></jsp:useBean>
<%
// 입력자료를 전송 받아 insert하는 로직
request.setCharacterEncoding("utf-8");
// String sang = request.getParameter("sang"); 이것 대신 폼빈 사용
//...
%>
<jsp:useBean id="sangpumBean" class="pack.SangpumBean"/>
<jsp:setProperty property="*" name="sangpumBean"/>
<%
//수신 데이터 검증 필요...
%>
<jsp:useBean id="ConnClass3" class="pack.ConnClass3"/>

<%
ConnClass3.insertData(sangpumBean);

//상품 추가 후 상품목록 보기로 이동
response.sendRedirect("jsp16paging.jsp");

//주의 : 추가, 수정, 삭제 후 목록보기 할 떄는 forwarding 하지 않는다. 
//url이 jsp16paging.jsp로 바뀌지 않고 jsp16insert.jsp 페이지로 고정되어있어서
//새로고침할 때마다 추가, 수정, 삭제되는 문제가 발생하기 때문
//request.getRequestDispatcher("jsp16paging.jsp").forward(request, response);
%>