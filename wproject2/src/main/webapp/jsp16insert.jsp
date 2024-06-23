<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//입력자료를 전송받아 insert하는 로직. 출력용x. 그러니 서블릿으로 만들어도됨.
request.setCharacterEncoding("utf-8");
//String sang = request.getParameter("sang"); //이거 대신 폼빈써보자

%>
<jsp:useBean id="sangpumBean" class="pack.SangpumBean"/>
<jsp:setProperty property="*" name="sangpumBean"/>
<%
//수신 데이터 검증 필요: 그 화면을 바로 들어오는 사람이 잇을수 있기에
%>
<jsp:useBean id="connClass3" class="pack.ConnClass3"/>
<% 
connClass3.insertData(sangpumBean);

//상품 추가 후 상품 목록보기로 이동
response.sendRedirect("jsp16paging.jsp");//리다이렉팅(클라이언트를 통해 목록보기)
//새로고침버튼 계속 눌러도 입력한 상품정보가 무한 입력되지 않는다

//request.getRequestDispatcher("jsp16paging.jsp").forward(request, response);//포워드
//새로고침할경우 주소는 여전히 insert.jsp이기에 입력한 정보가 계속 들어간다. 따라서 이럴경우 포워드가 아닌, 
//리다이렉팅의 방법으로 해야한다.
//즉, 추가 수정 삭제 후 목록보기할때는 forward 하지 않는다. URL주소가 바뀌어야하기에. 
%>
