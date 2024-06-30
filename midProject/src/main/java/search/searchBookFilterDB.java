package search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import book.BookDTO;

public class searchBookFilterDB {
    private DataSource ds;
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public searchBookFilterDB() {
        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");
        } catch (Exception e) {
            System.out.println("Db 연결 실패:" + e);
        }
    }

    public ArrayList<BookDTO> getResult(String title, String author, String publisher, Integer pyear, Integer bnum) {
        ArrayList<BookDTO> result = new ArrayList<BookDTO>();
        try {
            conn = ds.getConnection();
            String sql = "SELECT * FROM book WHERE title LIKE ? AND author LIKE ? AND publisher LIKE ?";
            
            //pyear와 bnum은 int형이여서 Like 연산자를 쓰지 않으므로 null 값이 들어갈 경우 검색이 되지 않는다.
            //따라서 null이 아닐 때만 sql 구문에 추가해주는 조건문을 써야한다.
            
            //sql문 작성 시 pyear가 4번째 bnum이 5번째 순서로 pyear가 bnum보다 반드시 앞에 와야되므로 
            //경우의 수를 아래와 같이 3가지로 나눠서 조건문을 정리함
            
          //1. pyear가 4번째 오고, bnum은 null인 경우
          //2. pyear가 null이어서, bnum이 4번째로 오는 경우
          //3. pyear가 4번째, bnum이 5번째 올 때
            if (pyear != null && bnum == null) {
                sql += " AND pyear = ?";
            }
            if (pyear == null && bnum != null) {
                sql += " AND bnum = ?";
            }
            if (pyear != null && bnum != null) {
                sql += " AND pyear = ?";
                sql += " AND bnum = ?";
                
            }
            
            //위에서 like ?를 썼으므로 변수 앞,뒤로 %기호를 써서 변수 값이 포함된 데이터를 검색하게 한다.
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + title + "%");
            pstmt.setString(2, "%" + author + "%");
            pstmt.setString(3, "%" + publisher + "%");
            
            if (pyear != null && bnum == null) {
                pstmt.setInt(4, pyear);
            }
            if (pyear == null && bnum != null) {
                pstmt.setInt(4, bnum);
            }
            if (pyear != null && bnum != null) {
                pstmt.setInt(4, pyear);
                pstmt.setInt(5, bnum);
            }
            //위에서는 경우의 수 3가지를 조건문 3개로 정리함
           
            //pyear가 null이 아니고 bnum이 null이면 pyear가 4번째
            //pyear가 null이고 bnum이 null이 아니면 bnum이 4번째
            //pyear와 bnum이 null이 아니면 pyear가 4번째, bnum이 5번째 순서로 옴
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	BookDTO book = new BookDTO();
            	
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPyear(rs.getInt("pyear"));
                book.setBnum(rs.getInt("bnum"));
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
