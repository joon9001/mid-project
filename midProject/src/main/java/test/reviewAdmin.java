package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class reviewAdmin extends HttpServlet {
    private static final String FILE_PATH = "/path/to/reviews.txt";
//review를 관리자페이지에서 볼 수 있도록 해주는 서블릿 파일
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String review = request.getParameter("review");

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH, true)))) {
            writer.println(review);
        } catch (IOException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to save review.");
            return;
        }

        response.getWriter().println("Review added successfully");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Admin Page - Reviews</title></head><body>");
        out.println("<h1>Admin Page - Reviews</h1>");
        out.println("<ul>");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                out.println("<li>" + line + "</li>");
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to read reviews.");
            return;
        }

        out.println("</ul>");
        out.println("</body></html>");
    }
}
