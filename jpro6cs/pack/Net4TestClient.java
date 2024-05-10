package pack;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestClient {

	public static void main(String[] args) {
		try {
//			InetAddress ia = InetAddress.getByName("192.168.0.29");
			//System.out.println(ia);
			//ip address를 얻을 수 있는 객체 생성 후 출력
			// Socket socket = new Socket(ia, 9999);
			//위와 같이 쓴 것을 줄여서 아래와 같이 쓸수 있다.
			Socket socket = new Socket("192.168.0.29", 9999);
			//객체가 만들어지면서 인수 안에 내용으로 연결 요청이 들어간다. 이때 서버와 접속시도를 하면
			//서버쪽 클래스 파일의 함수에서 accept()로 요청을 받으면 연결된다. 
			PrintWriter writer = new PrintWriter(
			//서버 클래스 파일
				new OutputStreamWriter(socket.getOutputStream(),
						StandardCharsets.UTF_8), true);
			writer.print("안녕 난 pyk야" + "\n"); 
			
			writer.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("client err : " + e);
			
		}
		// 특정 컴의 접속 후 메세지 전달용

	}

}
