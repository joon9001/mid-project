

$(document).ready(function() {
	// 폼의 submit 이벤트 처리
	$("#searchForm").on("submit", function(event) {
		event.preventDefault();
		performSearch();
	});
});

function performSearch() {
	var title = $('#title').val();
console.log("searchBook.js 파일에서 performSearch함수 수행하기 전 값 받음: " + title);

	$.ajax({
		url: "../search/searchProc.jsp",
		type: "GET",
		data: {title: title},
		success: function(data) {
			$("#results").html(data);
		},
		error: function() {
			alert("검색 중 오류가 발생했습니다.");
		}
	});
}
