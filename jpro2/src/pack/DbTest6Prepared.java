package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// PreparedStatement : 선처리 방식이 가능, SQL문에 입력자료 적용시 ? 연산자 가능
public class DbTest6Prepared {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public DbTest6Prepared() {
		try {
		Class.forName("org.mariadb.jdbc.Driver");
		String url ="jdbc:mariadb://localhost:3306/mydb";
		conn = DriverManager.getConnection(url, "root", "123");
		
		String sql = "";
		// 자료 추가
//		sql = "insert into sangdata values(?,?,?,?)";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, "10");
//		pstmt.setString(2, "신상품");
//		pstmt.setInt(3, 12);
//		pstmt.setString(4, "5000");
//		pstmt.executeUpdate();
//		int re = pstmt.executeUpdate();
//		System.out.println("insert 반환 값 : "  + re);
		
		// 자료 수정
//		sql = "update sangdata set sang=?, su=? where code=?";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, "아메리카노");
//		pstmt.setInt(2, 33);
//		pstmt.setInt(3, 7000);
		
//		int re = pstmt.executeUpdate();
//		System.out.println("update 반환 값 : "  + re);
		
		// 자료 삭제
		sql = "delete from sangdata where code=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 10);
		if(pstmt.executeUpdate() >= 1) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
	
		// 전체 자료 읽기
			sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + 
			rs.getString(2) + " " + 
				rs.getString(3) + " " +
				rs.getString(4));
				
			}
			//
			System.out.println();
			// 부분 자료 읽기
			String no = "2"; // 외부에서 받았다고 가정
			sql = "select * from sangdata where code=" + no;  
			// 실행은 가능하지만 SQL injection 공격 대상이 되므로 사용 x
			// 문자열 더하기 사용은 해킹에 취약함
			sql = "select * from sangdata where code=?";
			// secure coding guideline에 맞춰서 코딩한다면 위와 같이 바인딩변수(?)를 사용하여 sql문을 작성해야함
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no); // 첫번째 ?에 no가 대응
			//setInt를 쓰려면 위에 no = "2"를 정의한 부분의 타입도 int로 바꿔야 한다.
			
			rs = pstmt.executeQuery();
			if(rs.next()) { //레코드가 1개만 넘어오기 때문에 while문이 아닌 if문으로 처리
				System.out.println(rs.getString("code") + " " + 
			rs.getString("sang") + " " + 
				rs.getString("su") + " " +
				rs.getString("dan"));
				
			}
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
	}
	public static void main(String[] args) {
		new DbTest6Prepared();

	}

}
