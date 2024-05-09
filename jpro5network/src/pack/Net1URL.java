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
			BufferedReader br = new BufferedReader
					(new InputStreamReader(is, "UTF-8"));
			System.out.println(br.read());
			PrintWriter pw = new PrintWriter(System.out, true);
			//위에는 자료를 출력한 후 메모리 상에 데이터를 삭제하라는 명령
			//읽은 문서 파일로 저장
			PrintWriter fw = new PrintWriter(new FileOutputStream("c:/work/ok.html"), true);
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
