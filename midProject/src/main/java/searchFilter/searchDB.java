package searchFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class searchDB {
    private DataSource ds;
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public searchDB() {
        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");
        } catch (Exception e) {
            System.out.println("Db 연결 실패:" + e);
        }
    }

    public ArrayList<BookDto> getResult(String title, String author, String publisher, Integer pyear) {
        ArrayList<BookDto> result = new ArrayList<BookDto>();
        try {
            conn = ds.getConnection();
            StringBuilder sql = new StringBuilder("SELECT * FROM book WHERE title LIKE ? AND author LIKE ? AND publisher LIKE ?");
            if (pyear != null) {
                sql.append(" AND pyear = ?");
            }
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, "%" + title + "%");
            pstmt.setString(2, "%" + author + "%");
            pstmt.setString(3, "%" + publisher + "%");

            if (pyear != null) {
                pstmt.setInt(4, pyear);
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                BookDto book = new BookDto();
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPyear(rs.getInt("pyear"));
                result.add(book);
            }
        } catch (Exception e) {
            System.out.println("검색 실패: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println("자원 해제 실패: " + e);
            }
        }

        return result;
    }
}
