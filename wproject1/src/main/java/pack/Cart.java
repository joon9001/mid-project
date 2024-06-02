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


@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		HttpSession session = request.getSession(true); 
		//list는 김밥통, glist 김밥인데 냉장고에서 김밥통을 꺼내와서 
		//김밥을 저장 후 다시 김밥통을 냉장고에 넣는 프로세스라고 생각하면 이해하기 쉽다
		ArrayList<Goods> glist = (ArrayList<Goods>)session.getAttribute("list");
		//list 변수에 혹시 값이 있다면 glist 객체에 저장하는데 session의 데이터는 객체형태로 
		//저장되므로 ArrayList 형태로 강제형변환 후 저장해줘야 한다.
		if(glist == null) glist = new ArrayList<Goods>(); // 
		//glist(객체)가 비어있을 경우(list가 비었었단 의미) Goods 객체를 새로 생성하여 glist에 저장
		glist.add(new Goods(name, price));
		//glist(객체)가 비어있지 않을 경우 Goods의 생성자 인스턴스를 추가
		session.setAttribute("list", glist);
		//list라는 변수에 glist라는 데이터(값)가 저장됨
		//키와 값, 세션에는 json, 변수, 값, 객체, 컬렉션 등 모든 형태의 데이터를 저장할 수 있다. 
		//유효시간을 따로 안주면 30분간 세션 유효 (상대적 시간, 서버에서 세션 활동이 일어나는 기준)
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		out.println("<html><body>☞" + name + " 구입했습니다");
		out.println("<br>[<a href='myshop.html'>계속 쇼핑</a>] ");
		out.println("[<a href='Buy'>결제하기</a>]<br>");
		
		out.println("<p><table width='80%'>");
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		for(int i = 0; i < glist.size(); i++) {
			Goods goods = (Goods)glist.get(i);
			//위에 session의 setAttribute로 저장되어 object 형태가 된 glist를 다시 꺼내와서
			//Goods에 저장하기 위해 강제형변환을 해주었다.
			out.println("<tr><td>" + goods.getName() + "</td></tr>");	
			out.println("<td>" + goods.getPrice() + "</td>");
		}
		out.println("</table>");
		out.println("</body></html>");
		out.close();
		
	}

}
