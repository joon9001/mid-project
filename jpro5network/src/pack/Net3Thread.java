package pack;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// 멀티 스레드로 멀티 태스킹 : 복수 개의 문서 읽기
public class Net3Thread implements Runnable {
	private String url;
	private String title;

	public Net3Thread(String url, String title) {
		this.url = url;
		this.title = title;
	}
// 소켓은 내부적으로 돌고 있음
	public void run() { // 아래 thread()가 실행되면서 run()이 실행된다.
		try {
			Document doc = Jsoup.connect(url).get();
			// Jsoup을 사용하여 해당 URL에서 HTML 문서를 가져옵니다.
			//네트워크를 통해 다른 컴에 접속 후 자료 읽기
			String text = doc.text();
			//HTML 문서에서 텍스트 부분만 추출합니다.
			System.out.println("---------------------");
			System.out.println("문서 제목 : " + title);
			
			printKoreanText(text);
			//printKoreanText() 메서드를 호출하여 한글 텍스트를 출력합니다.
		} catch (Exception e) {
			System.out.println("read err : " + e);
		}

	}

	private static void printKoreanText(String text) {
		// 정규 표현식 사용
		// 한글과 공백만 얻기
		Pattern pattern = Pattern.compile("[가-힣\\s]+");
		//"[가-힣\\s]+"는 한글과 공백 문자(\\s)로 이루어진 패턴을 나타냅니다. 여기서 []는 문자 클래스를 나타내며, 
		//가에서 힣까지의 한글 문자와 \s는 공백 문자를 의미합니다. +는 하나 이상의 이전 패턴이 반복됨을 나타냅니다.
		Matcher matcher = pattern.matcher(text);
		//정규 표현식을 사용하여 한글과 공백 문자에 대한 패턴을 정의하고, 이 패턴을 텍스트와 매칭시킵니다.
		while(matcher.find()) { // 매칭되는 부분이 있을 때까지 반복합니다.
			String line = matcher.group().trim();
			//일치하는 부분은 matcher.group()을 호출하여 가져올 수 있다, trim은 공백제거
			if(!line.isEmpty() && line.length()>1) { // 빈 줄, 1글자는 제외
				//매칭된 부분을 공백을 제거한 후, 비어있지 않고 길이가 1보다 큰지 확인합니다.
				System.out.println(line);
			}
		}
	
}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String[] titles = { "백설공주", "인어공주" };
		//두 개의 동화 제목을 포함하는 문자열 배열을 정의합니다.
		String[] urls = { "https://ko.wikipedia.org/wiki/" + 
		URLEncoder.encode(titles[0], "UTF-8"), 
		// 배열에 들어있는 문자 "백설공주"를 주소창에 쓰이는 암호화된 문장으로 바꿔 wiki/ 뒤에 추가해줌
				"https://ko.wikipedia.org/wiki/" + 
		URLEncoder.encode(titles[1], "UTF-8") 
	  // 배열에 들어있는 문자 "인어공주"를 주소창에 쓰이는 암호화된 문장으로 바꿔 wiki/ 뒤에 추가해줌
				};
		//두 개의 동화 제목에 대한 위키피디아 페이지 URL을 생성합니다. 
		//URLEncoder.encode()를 사용하여 한글 제목을 UTF-8로 인코딩합니다.
		for (int i = 0; i < urls.length; i++) {
			Thread thread = new Thread(new Net3Thread(urls[i], titles[i]));
			thread.start();
		}// 백설공주와 인어공주 주소가 배열 urls에 각각 저장된 후 for문을 통해 각 주소를 1개씩 스레드로 실행된다.
		System.out.println("프로그램 종료");
// 사용자 정의 스레드가 시간이 걸리기 때문에 메인 스레드가 먼저 실행되어 
// "프로그램 종료"가 가장 먼저 출력된다.
// 메인 스레드가 종료되면 백설공주 스레드와 인어공주 스레드가 순서대로 실행되기는 하지만 스레드의 병렬처리 특성으로 인해
// 작업 처리 순서는 불규칙하며 예측하기 어렵다.
	}
}
