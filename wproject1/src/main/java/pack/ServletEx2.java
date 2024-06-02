<<<<<<< HEAD
package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.other.ServletEx2Other;


@WebServlet("/ServletEx2")
public class ServletEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletEx2Other other; //전역변수 other

	public void init(ServletConfig config) throws ServletException {
		// 서버는 init() 메소드를 호출해서 Servlet을 초기화합니다.
		other = new ServletEx2Other("홍길동");
		//init() 안의 내용은 최초 1번만 실행한다.
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿(웹용 자바)으로 클라이언트 브라우저에 데이터 전송
		response.setContentType("text/html;charset=utf-8"); // Mime type과 문자 코드
		PrintWriter out = response.getWriter(); 
		//response 객체를 썼으므로 printwriter는 단순 출력이 아니라 
		//웹용으로 서버에서 클라이언트 쪽으로 데이터를 전송해주는 역할을 한다.
		out.println("<html><body>");
		out.println("<h1>서블릿 문서 Ex2</h1>");
		
		//지역변수 출력
		int a = 10, b = 20;
		out.println("a: " + a + ", b:" + b);
		
		//현재 클래스의 메소드 호출
		int tot = calcData(a, b);
		out.println("<br>두 수의 합은" + tot);
		
		//클래스 호출
		//ServletEx2Other other = new ServletEx2Other("홍길동");
		//위에처럼 쓰면 사용자가 많아져도 계속 new 객체 인스턴스를 생성하므로 서버가 다운된다.
		//따라서 위의 new 객체 생성 문장은 init()메소드 안에 넣어줘서 최초 한번만 실행되도록 한다.
		String ir = other.getIrum();
		out.println("<br>이름은 " + ir);
		
		out.println("</body></html>");
		out.close();
		//자바 문법을 써서 html 태그를 클라이언트(웹 브라우저)에 보내줬다.
		
	}
	
	private int calcData(int a, int b) {
		int imsi = a + b;
		return imsi;
	}

}
=======
package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.other.ServletEx2Other;


@WebServlet("/ServletEx2")
public class ServletEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletEx2Other other; //전역변수 other

	public void init(ServletConfig config) throws ServletException {
		// 서버는 init() 메소드를 호출해서 Servlet을 초기화합니다.
		other = new ServletEx2Other("홍길동");
		//init() 안의 내용은 최초 1번만 실행한다.
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿(웹용 자바)으로 클라이언트 브라우저에 데이터 전송
		response.setContentType("text/html;charset=utf-8"); // Mime type과 문자 코드
		PrintWriter out = response.getWriter(); 
		//response 객체를 썼으므로 printwriter는 단순 출력이 아니라 
		//웹용으로 서버에서 클라이언트 쪽으로 데이터를 전송해주는 역할을 한다.
		out.println("<html><body>");
		out.println("<h1>서블릿 문서 Ex2</h1>");
		
		//지역변수 출력
		int a = 10, b = 20;
		out.println("a: " + a + ", b:" + b);
		
		//현재 클래스의 메소드 호출
		int tot = calcData(a, b);
		out.println("<br>두 수의 합은" + tot);
		
		//클래스 호출
		//ServletEx2Other other = new ServletEx2Other("홍길동");
		//위에처럼 쓰면 사용자가 많아져도 계속 new 객체 인스턴스를 생성하므로 서버가 다운된다.
		//따라서 위의 new 객체 생성 문장은 init()메소드 안에 넣어줘서 최초 한번만 실행되도록 한다.
		String ir = other.getIrum();
		out.println("<br>이름은 " + ir);
		
		out.println("</body></html>");
		out.close();
		//자바 문법을 써서 html 태그를 클라이언트(웹 브라우저)에 보내줬다.
		
	}
	
	private int calcData(int a, int b) {
		int imsi = a + b;
		return imsi;
	}

}
>>>>>>> branch 'main' of https://github.com/joon9001/java_source.git
