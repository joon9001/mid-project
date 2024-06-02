package pack;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class DbTest2CRUD {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	Properties prop = new Properties();
	
	public DbTest2CRUD() {// secure coding의 하나로 연결정보 별도 저장 후 읽기
		try {
			prop.load(new FileInputStream("C:\\work\\jsou\\jpro2\\src\\pack\\dbtest2.properties"));
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("passwd"));
			stmt = conn.createStatement();
			
			String sql = "";
			
			//자료 추가
			//sql = "insert into sangdata values(5,'새우깡',55,3000)";
			//stmt.executeUpdate(sql); 
			// insert, update, delete는 executeupdate를 쓰지만 
			// select는 executequery를 쓴다.
			// auto commit은 기본값이므로 DB저장소인 command prompt 창에서도 바로 적용된다.
			// auto commit을 수동으로 전환해 작업 : transanction 처리가 필요
			/*
			conn.setAutoCommit(false); // auto commit 해제 후 수동 모드로 전환
			sql = "insert into sangdata values(6,'감자깡',7,3000)";
			stmt.executeUpdate(sql); //transaction 시작
			sql = "insert into sangdata values(7,'gokuma깡',17,2000)";
			stmt.executeUpdate(sql);
			//conn.rollback(); // transaction 끝, commit 전 rollback이므로 6,7번 입력은 취소됨
			conn.commit(); // Transaction 끝 - 클라이언트에서 입력한 자료를 원격 DB에 저장
			conn.setAutoCommit(true); // 자동으로 전환
			*/
			//자료 수정
//			sql = "update sangdata set sang='데일리 콤부차', su=12, dan=8000 where code=5";
//			stmt.executeUpdate(sql);
			
			//자료 삭제
			sql = "delete from sangdata where code >= 5";
			//stmt.executeUpdate(sql);
			// insert, update, delete는 수행 후 처리 수만큼 행의 갯수를 반환
			//insert, update, delete는 처리 성공 시 1, 실패시 0을 반환한다. 
			//예를 들어 삭제할 데이터가 2개면 2를 반환, 삭제할 데이터가 1개도 없으면 0을 반환함
			int result = stmt.executeUpdate(sql); 
			System.out.println("result : " + result);
			if(result == 0) System.out.println("삭제 실패");
			
			// 모든 자료 읽기
			sql = "select * from sangdata order by code desc";
			rs = stmt.executeQuery(sql);
			int cou = 0;
			while(rs.next()) {
				System.out.println(rs.getString("code") + " " +
			//rs로 sql문을 가져옴과 동시에 바로 code 데이터를 가져온다.
						rs.getString("sang") + " " + 
						rs.getString("su") + " " + 
						rs.getString("dan") );
			cou++;	
				
			}
			System.out.println("전체 자료 수 : " +cou);
			
			//부분 자료 읽기
			sql = "select * from sangdata where code=1";
			// 위에 sql에 값을 다르게 줬으므로 close()를 안하고 다시 시작해도 된다.
			rs = stmt.executeQuery(sql);
			if(rs.next()) { //결과가 1개이므로 while 대신 if문을 썼다.
				System.out.println(rs.getString("code") + " " +
						//rs로 sql문을 가져옴과 동시에 바로 code 데이터를 가져온다.
									rs.getString("sang") + " " + 
									rs.getString("su") + " " + 
									rs.getString("dan") );
						cou++;		
			}else {
				System.out.println("해당 자료는 없어요");
			}
		
		} catch (Exception e) {
			System.out.println("err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) rs.close();
				if(conn != null) rs.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DbTest2CRUD();
	}

}
