package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestServer {

	public static void main(String[] args) {
		// 단순 서버
		ServerSocket ss = null;
		
		//내 컴퓨터가 사용 중인 port number 확인
//		for (int i = 0; i < 65536; i++) {
//			try {
//				ss = new ServerSocket(i);
//				ss.close();
//			} catch (Exception e) {
//				System.out.println(i + "번 port는 사용중");
//			}
//			
//		}
//		System.out.println("확인 종료");
		
		Socket socket = null; // TCP/IP 기반의 통신용 클래스 파일
		try {
			ss = new ServerSocket(9999);  
			// 서버 소켓, 9999는 현재 내컴퓨터가 안쓰는 포트번호
			// 9999번 포트에서 대기하는 ServerSocket을 생성하여 변수 ss에 저장.
			System.out.println("서버 서비스 시작...");
			socket = ss.accept(); 
			//서버는 대기중이다가 클라이언트가 접속하면 new socket이 생성되어 socket에 저장됨
			//서버 소켓으로부터 클라이언트 컴과 통신하기 위한 개별 소켓 생성
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			//한글 깨짐 방지를 위해 StandardCharsets.UTF_8로 데이터를 받았다.
			//소켓으로 클라이언트의 데이터를 받기 위한 inputstreamReader
			String data = reader.readLine();
			System.out.println("수신 자료 : " + data);
			
			reader.close();
			socket.close();
			ss.close();
		} catch (Exception e) {
			System.out.println("server err: " + e);
		}
	}
	

}
