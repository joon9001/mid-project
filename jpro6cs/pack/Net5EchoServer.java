package pack;
// Echo Server : 클라이언트의 요청에 계속 반응을 보이는 서버

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net5EchoServer {
	ServerSocket ss;
	PrintWriter out;
	BufferedReader reader;
	Socket socket;

	public Net5EchoServer() {
		try {
			ss = new ServerSocket(8888);
			System.out.println("서버 서비스 중 ...");

			this.socket = ss.accept(); // 클라이언트 접속 대기 후 소켓 객체 생성

			this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
		} catch (Exception e) {
			System.out.println("Net5EchoServer err : " + e);
			System.exit(0);
		}

	}

	public void receiveSendData() {
		try {
			String msg = reader.readLine(); // 클라이언트의 자료 수신
			System.out.println("수신된 메세지 : " + msg);

			out.println("서버가 보낸 메세지 : " + msg + "잘 봤어~"); // 자료 전송
			// 위에 메세지를 보낸 후 다시 한번 같은 메세지 + 잘봤다는 응답 메세지 전송
		} catch (Exception e) {
			System.out.println("receiveSendData err : " + e);
		} finally {
			try {
				reader.close();
				out.close();
				socket.close();
				ss.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	public static void main(String[] args) {
		while (true) {
			Net5EchoServer server = new Net5EchoServer();
			server.receiveSendData(); // 무한 루프에 빠뜨려서 서버가 죽지 않도록 함
		}

	}

}
