

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
    var bnum = $("#bnum").val();
      // 모든 필드가 비어 있는지 확인한 후 비어있을 경우 검색 조건을 하나 이상 입력하라는 경고창이 뜨고 검색 요청은 중단된다.
      
    if (!title && !author && !publisher && !pyear && !bnum) {
        alert("검색 조건을 하나 이상 입력해주세요.");
        return; // 검색 요청을 중단
    }
    
console.log("searchFilterBook.js 파일에서 ajax () 수행하기 전 title 값 받음: " + title);
    $.ajax({
        url: "searchFilterProc.jsp",
        type: "GET",
        data: {
			
            title: title,
            author: author,
            publisher: publisher,
            pyear: pyear,
            bnum: bnum
        },
        //통신에 성공할 경우 searchFilterProc.jsp에 보낸 데이터로 만든 html 테이블 구문을 아래 콜백 함수에서 data로 받아와
        //searchFilterResult.jsp의 results 아이디를 가진 태그 부분에 출력한다.
        
        // jQuery 선택자를 사용하여 HTML 문서의 최상단 요소인 <html>과 <body> 요소를 선택.
        //$("#results").offset().top으로 설정하면 페이지가 results 요소의 상단 위치로 1초 동안 스크롤된다는 뜻.
        success: function(data) {
            $("#results").html(data);
            $('html, body').animate({
                scrollTop: $("#results").offset().top
            }, 1000); // 1초 동안 부드럽게 스크롤
        },
        error: function() {
            alert("검색 중 오류가 발생했습니다.");
        }
    });
}
