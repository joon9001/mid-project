<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/mainpage.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<script src="../js/voiceRec.js"></script>

<jsp:useBean id="searchDB" class="search.searchBookFilterDB" />
</head>
<body>
	<div class="head_wrapper">
		<div class="header_menu"></div>
		<div class="header_logo"></div>
		<div class="header_search">
		
		<div class="container">
			<form class="search_box" id="searchForm" method="get">

				<input type="text" id="searchInput" class="search_txt"
					placeholder="  책 제목, 작가, 출판사, 출판일"> <br>
				<div class="record_btn">
					<button type="button" onclick="startRecord()">⏺️</button>
					<button type="button" onclick="endRecord()">🛑</button>
					<button type="button"
						onclick="performSearch(); location.href='../search/searchResult.jsp';">검색</button>
				</div>
	
			
				<button class="search_detailbtn" type="button"
					onclick="location.href='../search/searchFilterResult.jsp'">상세검색</button>
			</form>
				<div class="results" id="results">
						<!-- 검색 결과가 여기에 표시됩니다. -->
					</div>
			</div>
		</div>
		<div class="header_login">
			<%
			String id = (String) session.getAttribute("idkey");
			String log = "";

			if (id == null) {
			%>
			<form action="../login/loginpage.jsp" method="post">
				<button class="login_btn" type="submit">로그인</button>
			</form>
			<%
			} else {
			%>
			<form action="../mypage/mypage.jsp" method="post">
				<button class="login_btn" type="submit">마이페이지</button>
			</form>
			<%
			}
			%>
		</div>

	</div>
</body>
</html>