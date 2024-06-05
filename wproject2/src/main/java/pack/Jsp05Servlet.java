package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jsp05Servlet")
public class Jsp05Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String data = request.getParameter("data");
		
		System.out.println("수신 데이터 : " + data);
		
		// 서버가 다른 파일 호출 방법 1 : redirect 방식 - client를 통해 server에게 파일을 요청
		//response.sendRedirect("aaa.html?data=" + data);	// html을 호출할 경우 값을 넘길 수 없다. 
		//response.sendRedirect("jsp05called.jsp?data=" + data);
		// jsp을 호출할 경우 값을 넘길 수 있다. 값은 String만 가능하다.
		
		
		// 서버가 다른 파일 호출 방법 2 : forward 방식 - server가 직접 server에 있는 파일 호출
		request.setAttribute("datas", data);
//		request.setAttribute("datas2", data2);
//		request.setAttribute("jikwons", jiklist);
//		request에 이름, 값의 형태로 String 또는 자바의 어떤 객체이든 전달이 가능
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp05called.jsp");
//		dispatcher.forward(request, response);
		request.getRequestDispatcher("jsp05called.jsp").forward(request, response);	// 위 두 줄과 같은 뜻
		
		// 시스템(session, db)에 변화가 생기는 요청(로그인, 회원가입, 글쓰기)의 경우 redirect 방식으로 응답하는 것이 바람직
		// 시스템에 변화가 생기지 않는 단순 조회(리스트보기, 검색)의 경우 forward 방식으로 응답하는 것이 바람직
		// https://doublesprogramming.tistory.com/63
		
		
		
	}

}


