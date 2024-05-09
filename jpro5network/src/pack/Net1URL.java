package pack;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

// URL 클래스로 특정 웹 서버 컴의 문서 읽기
// 인터넷이 가능한 서버들의 자원에 접근하여 주소 및 기타 정보를 다루는 클래스

public class Net1URL {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.daum.net");
			// https://www.naver.com:80/index.html 포트번호 80, 메인페이지인 index.html은 생략가능
			// http 보안용 서버 ==> https. tcp 프로토콜 기반 응용프로그램 계층에서 사용
			InputStream is = url.openStream();
			//URL에서 입력 스트림을 엽니다. 이를 통해 해당 URL의 데이터를 읽을 수 있습니다.
			BufferedReader br = new BufferedReader
					(new InputStreamReader(is, "UTF-8"));
			// URL 데이터가 저장된 is를 UTF-8 인코딩으로 설정하고 inputStreamReader 객체의 인스턴스 매개변수로
			//설정합니다. 이를 통해 URL에서 읽은 데이터를 문자열로 읽을 수 있습니다.
			System.out.println(br.read());//문자를 읽어들여서 콘솔에 출력합니다.
			PrintWriter pw = new PrintWriter(System.out, true);
			//콘솔에 출력하기 위한 PrintWriter를 생성합니다. 이 PrintWriter는 표준 출력 스트림(System.out)을 사용합니다.
			//위에는 자료를 출력한 후 메모리 상에 데이터를 삭제하라는 명령
			//읽은 문서 파일로 저장
			PrintWriter fw = new PrintWriter(new FileOutputStream("c:/work/ok.html"), true);
			//파일에 출력하기 위한 PrintWriter를 생성합니다. 
			//이 PrintWriter는 "c:/work/ok.html" 경로에 파일을 생성하고, 파일 출력 스트림을 사용하여 출력합니다.
			//file 입출력을 통해 내보내서 설정 경로에 저장
			String line = "";
			while((line = br.readLine()) != null) {
				pw.println(line); // console로 출력
				fw.println(line); // file로 저장
				fw.flush(); // 버퍼 비우기
			};
			br.close();
			is.close();
			pw.close();
			fw.close();
		
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
	}

}
