/*
[문항15] 키보드로 부서명을 입력해 해당 부서에 근무하는 직원을 표준출력장치로 출력하시오.
참고 :
1) PreparedStatement를 사용합니다.
2) 연봉 평균은 group by를 사용합니다. 평균은 정수만 출력(소수 이하 버림)
3) 인원수와 연봉은 해당 부서를 대상으로 작업합니다. 
입력 예)
부서명 : 총무부

출력 예)
총무부 전화번호는 02-111-1111

사번  이름    직급  성별 
5    신기해  대리    남
...

인원수는 남직원 : 2명, 여직원 : 3명
연봉 평균은 남직원: 3456, 여직원: 3500

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

public class student {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private Properties prop = new Properties();
	
	
	
	public student() {
		// 1. Driver File Loading
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
			return;
		}
		
		//
		// 2. DB server와 연결
		try {String Url ="jdbc:mariadb://localhost:3306/mydb";
			conn = DriverManager.getConnection(Url, "root", "123");
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}
		
		
		try{
	    // 부서명 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("부서명을 입력하세요(총무부, 영업부, 전산부, 관리부): ");
        String buser_irum = scanner.nextLine();
        
        // SQL 쿼리 준비
        String sql = "select buser_tel as 전화번호, jikwon_no as 사번, jikwon_name as 이름"
        		+ "jikwon_jik as 직급, jikwon_gender as 성별, avg(jikwon_pay) as 연봉평균 from jikwon inner join buser ON jikwon.buser_num = buser.buser_no where buser_name=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, buser_irum);
        //숫자 1은 위의 sql 쿼리문의 ?를 지정하고 뒤에 buser_bunho는 ? 안에 들어갈 값이 된다.
        // SQL 쿼리 실행 및 결과 처리
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
        	int buser_tel = rs.getInt("전화번호");
        	int jikwon_no = rs.getInt("사번");
        	String jikwon_name = rs.getString("이름");
        	
        	String buser_name = rs.getString("부서명");
        	String jikwon_jik = rs.getString("직급");
        	String jikwon_gender = rs.getString("성별");
        	int jikwon_pay = rs.getInt("연봉평균");
        	
        	System.out.println(buser_name + "전화 번호는 " + buser_tel);
        	System.out.println(jikwon_no + " " + jikwon_name + 
					" "  +  jikwon_jik + " " + jikwon_gender);
        	System.out.println(jikwon_pay);
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
		new student();
}
}
