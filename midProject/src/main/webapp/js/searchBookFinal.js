
        $(document).ready(function() {
            var urlParams = new URLSearchParams(window.location.search);
           /*
           window.location.search는 현재 페이지 URL의 쿼리 문자열 부분을 반환. 
           예를 들어, URL이 http://example.com?title=Java인 경우 window.location.search는 
           ?title=Java를 반환.
           이 쿼리 문자열을 파싱하여 쿼리 파라미터를 쉽게 읽을 수 있는 URLSearchParams 객체를 만든 후 urlParams 변수에 저장.
           */
            var title = urlParams.get('title');
			/*
			URLSearchParams 객체 변수 urlParams에서 title이라는 이름의 쿼리 파라미터 값을 추출합니다. 
			예를 들어, URL이 http://example.com?title=Java인 경우, title 변수는 "Java" 값을 가집니다.
			*/
            if (title) {
                fetchResults(title);
            }
			//title에 값이 있을 경우에만 fetchResult(title) 실행
			
			//아래는 가져온 title 값을 searchProc.jsp에 { title: title }와 같은 json 형식으로 보낸 후
			//반환된 html 부분을 data 인수로 받아와 searchResult.jsp 파일의 results 아이디를 가진 태그 사이에 출력함 
            function fetchResults(title) {
                $.ajax({
                    url: "searchProc.jsp",
                    type: "GET",
                    data: { title: title },
                    success: function(data) {
                        $("#results").html(data);
                    },
                    error: function() {
                        alert("검색 중 오류가 발생했습니다.");
                    }
                });
            }
        });
  