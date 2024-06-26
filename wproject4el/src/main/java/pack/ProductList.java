package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("아메리카노", 2000.0, "짱 시원해요", new Date()));
		products.add(new Product("카페라떼", 2500.0, "짱 부드러워요", new Date()));
		products.add(new Product("수박주스", 3000.0, "편하게 마셔요", new Date()));
		products.add(new Product("망고블랜디드", 4000.0, "짱 달콤해요", new Date()));
		
		request.setAttribute("products", products);
		request.getRequestDispatcher("/pshow.jsp").forward(request, response);
		
	}

}
