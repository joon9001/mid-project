<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>전국 도서관 정보 일부 DB에 저장하기</title>
</head>
<body>

<h2>전국 도서관 정보 파일 일부 DB에 저장하기</h2>

<div>
    <%
        Connection conn = null;
        PreparedStatement pstmtInsert = null;
        PreparedStatement pstmtCheck = null;
        BufferedReader br = null;
        int count = 0;
        
        try {
            // JDBC 연결 설정
            Context initcontext = new InitialContext();
            DataSource ds = (DataSource)initcontext.lookup("java:comp/env/jdbc/maria"); // 데이터베이스 리소스 이름으로 변경 필요
            conn = ds.getConnection();

            // 파일 경로
            String filePath = "c:/work/bookie.csv";
            // UTF-8 인코딩으로 파일 읽기
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

            String line;
            String insertQuery = "INSERT INTO book(bnum, title, author, publisher, pyear) VALUES(?, ?, ?, ?, ?)";
            String checkQuery = "SELECT * FROM book WHERE bnum = ?";

            // 줄 단위로 읽어서 데이터베이스에 삽입
            pstmtInsert = conn.prepareStatement(insertQuery);
            pstmtCheck = conn.prepareStatement(checkQuery);

            // 첫 줄은 제목이므로 건너뛰기
            br.readLine();

            while ((line = br.readLine()) != null && count < 3) {
                count++;
                // CSV 파일에서 데이터 추출
                String[] tokens = line.split(",");
                
                int s1 = Integer.parseInt(tokens[0].trim()); // 번호 (정수형으로 변환)
                String s2 = tokens[1]; // 서명
                String s3 = tokens[2]; // 저자
                String s4 = tokens[3]; // 출판사
                int s5 = Integer.parseInt(tokens[4].trim()); // 출판일

                // 중복 체크
                pstmtCheck.setInt(1, s1);
                ResultSet rs = pstmtCheck.executeQuery();
                
                if (!rs.next()) {
                    // 데이터베이스에 데이터 삽입
                    pstmtInsert.setInt(1, s1);
                    pstmtInsert.setString(2, s2);
                    pstmtInsert.setString(3, s3);
                    pstmtInsert.setString(4, s4);
                    pstmtInsert.setInt(5, s5);
                    pstmtInsert.executeUpdate();
                }
                rs.close(); // ResultSet 닫기
            }

            out.println("<p>건수 : " + count + "</p>");

        } catch (Exception e) {
            out.println("데이터베이스 처리 오류: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 자원 해제
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pstmtCheck != null) {
                try {
                    pstmtCheck.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmtInsert != null) {
                try {
                    pstmtInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    %>
</div>

</body>
</html>

