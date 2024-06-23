<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>음성 인식 도서 검색</title>


</head>
<body>
    <article class="form">
        <input type="text" id="search_console" />
        <button type="button" id="search_btn">🔎</button>
        <div class="record_btn">
            <button type="button" onclick="startRecord()">⏺️</button>
            <button type="button" onclick="endRecord()">🛑</button>
        </div>
    </article>
</body>
</html>