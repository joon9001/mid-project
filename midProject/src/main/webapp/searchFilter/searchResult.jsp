<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상세 검색 페이지</title>
<jsp:useBean id="searchDB" class="searchFilter.searchDB" />

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    // 폼의 submit 이벤트 처리
    $("#searchForm").on("submit", function(event) {
        event.preventDefault();
        performSearch();
    });
});

function performSearch() {
    var title = $("#title").val();
    var author = $("#author").val();
    var publisher = $("#publisher").val();
    var pyear = $("#pyear").val();

    $.ajax({
        url: "search.jsp",
        type: "GET",
        data: {
            title: title,
            author: author,
            publisher: publisher,
            pyear: pyear
        },
        success: function(data) {
            $("#results").html(data);
        },
        error: function() {
            alert("검색 중 오류가 발생했습니다.");
        }
    });
}
</script>
</head>
<body>

    <div class="container">
        <h1>상세 검색</h1>
        <hr>
        <form class="search-form" id="searchForm">
            <label for="name">제목:</label> <input type="text" id="title" name="title"><br>

            <label for="author">작가:</label> <input type="text" id="author" name="author"><br>

            <label for="publisher">출판사:</label> <input type="text" id="publisher" name="publisher"><br>

            <label for="issueDate">출판일:</label> <input type="text" id="pyear" name="pyear"><br>
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
