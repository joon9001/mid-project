package pack;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// 제3자가 제공하는 라이브러리(jsoup.jar)를 사용해 웹 스크래핑 
//HTML 문서 데이터 구문 분석, 추출 및 조작용 오픈 소스

public class Net2 {

	public static void main(String[] args) {
		// 위키백과 사이트에서 검색 결과 읽기
		//https://ko.wikipedia.org/wiki/백설공주
	try {
		System.out.println(URLEncoder.encode("백설공주", "UTF-8"));
//위에는 백설공주를 %EB%B0%B1%EC%84%A4%EA%B3%B5%EC%A3%BC로 인코딩(암호화)하여 출력하는 코드.
//디코딩(복호화)은 %EB%B0%B1%EC%84%A4%EA%B3%B5%EC%A3%BC를 백설공주로 바꾸어 사용자에게 보여주는것
		String url = "https://ko.wikipedia.org/wiki/";
		
		// Document : 웹페이지 문서
		Document doc = Jsoup.connect(url).get();
		//Jsoup을 사용하여 해당 URL에서 HTML 문서를 가져옵니다.
		String text = doc.text(); //웹 문서의 텍스트를 모두 읽어 text 변수에 저장
		//System.out.println(text);
		
		printKoreanText(text); // 한글만 추출
	} catch (Exception e) {
		System.out.println("err : " + e.getMessage());
	}
	}
		private static void printKoreanText(String text) {
			// 정규 표현식 사용
			// 한글과 공백만 얻기
			Pattern pattern = Pattern.compile("[가-힣\\s]+");
			Matcher matcher = pattern.matcher(text);
			//정규 표현식을 사용하여 한글과 공백으로 이루어진 패턴을 정의하고, 이 패턴을 텍스트와 매칭시킵니다.
			while(matcher.find()) { // 매칭되는 부분이 있을 때까지 반복합니다.
				String line = matcher.group().trim(); 
				//매칭된 부분을 공백을 제거한 후, 비어있지 않은지 확인합니다.
				if(!line.isEmpty()) { // 빈 줄은 제외
					System.out.println(line);
				}
			}
		
	}

}
