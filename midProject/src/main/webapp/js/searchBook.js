$(document).ready(function() {
	//jQuery를 사용해 문서가 완전히 로드되고 준비되면 콜백 함수를 실행하게 함.
			
			
    // form의 submit 이벤트 처리
	//아래는 maintop.jsp 파일 내 searchForm 아이디를 가진 form 태그가 제출될 때마다 지정된 콜백 함수를 실행함.
			$("#searchForm").on("submit", function(event) {
				event.preventDefault();
				performSearch();
			});
		});
	// event.preventDefault()는 form의 기본 제출 동작을 막음으로써 페이지가 새로고침되거나 서버에 제출되는 것을 방지.
		function performSearch() {
			var title = $('#searchInput').val();
			window.location.href = `../search/searchBookFinal.js?title=${encodeURIComponent(title)}`;
		}
		
	//searchInput 아이디를 가진 검색창에서 입력된 데이터를 불러와 title 변수에 저장한다.
	//performSearch()가 실행되면 window.location.href를 이용하여 지정한 경로로 이동하는데 title값을 스트링 쿼리 값으로 가져간다.