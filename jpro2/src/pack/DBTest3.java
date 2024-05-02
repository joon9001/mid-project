/*
 연습문제
 
 키보드로 부서번호를 입력받아 해당 부서에 근무하는 직원자료 출력

부서번호: 10 <==

사번 이름 부서 직급 연봉
...
건수:*

secure 사용 x 
 
 */

package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class DBTest3 {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private Properties prop = new Properties();
	
	
	
	public DBTest3() {
		// 1. Driver File Loading
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
			return;
		}
		
		
		// 2. DB server와 연결
		try {String Url ="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(Url, "root", "123");
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}
		
		
		try{
	    // 부서번호 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("부서번호를 입력하세요: ");
        int buser_bunho = scanner.nextInt();
        
        // SQL 쿼리 준비
        String sql = "select jikwon_no as 사번, jikwon_name as 직원명,buser_num as 부서번호, buser_name as 부서명, "
        		+ "jikwon_jik as 직급, jikwon_pay as 연봉 from jikwon inner join buser ON jikwon.buser_num = buser.buser_no where buser_num=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, buser_bunho);
        //숫자 1은 위의 sql 쿼리문의 ?를 지정하고 뒤에 buser_bunho는 ? 안에 들어갈 값이 된다.
        // SQL 쿼리 실행 및 결과 처리
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
        	int jikwon_no = rs.getInt("사번");
        	String jikwon_name = rs.getString("직원명");
        	int buser_num = rs.getInt("부서번호");
        	String buser_name = rs.getString("부서명");
        	String jikwon_jik = rs.getString("직급");
        	int jikwon_pay = rs.getInt("연봉");
        	
        	System.out.println(jikwon_no + " " + jikwon_name + 
					" " + buser_num + " " + buser_name + " " + jikwon_jik + " " + jikwon_pay);
                      // 이하 필요한 컬럼들 출력
        }
        
        // 연결 및 리소스 해제
        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        
    }finally { // rs.close()를 
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		// 객체 사용 후 close()를 안했을 경우를 위해 finally 구문에서 
		// 모든 인터페이스 객체의 close()를 해준다.
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
    }
		
	}
	
	public static void main(String[] args) {
		new DBTest3();
}
}
