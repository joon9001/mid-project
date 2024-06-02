package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/post.do")
public class ServletEx5Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 수신 자료 한글 깨짐 방지
		response.setContentType("text/html;charset=utf-8"); // Mime type과 문자 코드
		PrintWriter out = response.getWriter(); 
		//response 객체를 썼으므로 printwriter는 단순 출력이 아니라 
		//웹용으로 서버에서 클라이언트 쪽으로 데이터를 전송해주는 역할을 한다.
		out.println("<html><body>");
		out.println("<h2>post 요청 결과</h2>");
		
		String irum = request.getParameter("name");
		String []juso = request.getParameterValues("addr"); // 매개변수가 중복인 경우 배열 처리
		
		out.println("이름은 " + irum + ", 주소는 " + juso[0] + " " + juso[1]);
		
		//checkbox
		try {
			String sports[] = request.getParameterValues("sports"); // 매개변수가 중복인 경우 배열 처리
			out.println("<br>선택한 종목은 ");		
			for(String s:sports) {
				out.println(s + " ");
			}
		} catch (Exception e) {
			out.println("<br>종목 하나 이상을 선택하면 어떨지...");
			return;
		}
		
		//radio
		String language = request.getParameter("lan");
		out.println("<br>자신 있는 언어는 " + language);
		
		//select
		String tr = request.getParameter("tr");
		out.println("<br>교통 수단은 " + tr);
		// hidden
		String edu = request.getParameter("edu");
		out.println("<br>교육센터는 " + edu);
		
		out.println("<br><br><br><a href='postdata.html'>자료 다시 입력</a>");
		out.println("</body></html>");
		out.close();
		//자바 문법을 써서 html 태그를 클라이언트(웹 브라우저)에 보내줬다.
	}

}

