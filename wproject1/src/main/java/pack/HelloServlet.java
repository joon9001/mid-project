package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/HelloServlet") //요청이 1개일 때
@WebServlet(name = "HelloServlet", urlPatterns = {"/HelloServlet","/good.kor","/dajeong"},loadOnStartup = 1) 
//요청이 여러개일 때
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get 요청 성공");
		
		// 서블릿(웹용 자바)으로 클라이언트 브라우저에 데이터 전송
		response.setContentType("text/html;charset=utf-8"); // Mime type과 문자 코드
		PrintWriter out = response.getWriter(); 
		//response 객체를 썼으므로 printwriter는 단순 출력이 아니라 
		//웹용으로 서버에서 클라이언트 쪽으로 데이터를 전송해주는 역할을 한다.
		out.println("<html><body>");
		out.println("<h1>서블릿 문서</h1>");
		out.println("안녕 반가워");
		out.println("</body></html>");
		out.close();
		//자바 문법을 써서 html 태그를 클라이언트(웹 브라우저)에 보내줬다.
	}

}
