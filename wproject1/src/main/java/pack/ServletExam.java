package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletExam")
public class ServletExam extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	  // 세션에서 데이터를 가져옴
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String kor = request.getParameter("kor");
        String eng = request.getParameter("eng");
    	
    	
    	HttpSession session = request.getSession(true);
        if (session == null) {
            System.out.println("request.session이 null입니다.");
            return;
        }
        
        ArrayList<Score> glist = (ArrayList<Score>)session.getAttribute("list");
		//list(키)가 이미 존재하는 것이 있다면 session으로 불러와서 glist에 저장한다 
		if(glist == null) glist = new ArrayList<Score>(); // 
		//glist(객체)가 비어있을 경우 Goods 객체를 새로 생성하여 glist에 저장
		glist.add(new Score(number, name, kor, eng));
		//glist(객체)가 비어있지 않을 경우 Goods의 생성자 리턴 값을 추가
		session.setAttribute("list", glist); 
		//키와 값, 세션에는 변수, 값, 객체, 컬렉션 등 모든 형태의 데이터를 저장할 수 있다. 
		//유효시간을 따로 안주면 30분간 세션 유효 (상대적 시간, 서버에서 세션 활동이 일어나는 기준)
		
		
//        ArrayList<Score> glist = (ArrayList<Score>) session.getAttribute("list");
//        if (glist == null) {
//            System.out.println("세션에서 데이터를 가져오는 중 오류가 발생했습니다.");
//            return;
//        }

      

        // 응답 데이터 타입 및 인코딩 설정
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // HTML 출력
        out.println("<html><body>");
        out.println("<p><table width='80%'>");
        out.println("<tr><th>번호</th><th>이름</th><th>국어</th><th>영어</th></tr>");

        // 데이터 출력
        out.println("<tr>");
        out.println("<td>" + "\t"+ number + "</td>");
        out.println("<td>" + "\t" + name + "</td>");
        out.println("<td>" + "\t" + kor + "</td>");
        out.println("<td>" + "\t" + eng + "</td>");
        out.println("</tr>");

        out.println("</table></p>");
        out.println("<input type='button' value='홈으로 이동' onclick='history.back()'>");
        out.println("</body></html>");

        out.close();
    }
}
