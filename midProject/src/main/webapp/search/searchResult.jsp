<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상세 검색 페이지</title>
<jsp:useBean id="searchBookDB" class="search.searchBookDB" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../js/searchBook.js"></script>



</head>

<body>

   <div class="container">
        <h1>검색 결과</h1>
        <hr>
 <form class="search-form" id="searchForm">
            <label for="name">제목:</label> <input type="text" id="title" name="title">
            <br>
            <button type="button" onclick="performSearch()">Search</button>
            <br>
            <br>
        </form>
          <div class="results" id="results">
            <!-- 검색 결과가 여기에 표시됩니다. -->
        </div>
           </div>
      
 
</body>
</html>
