package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// MariaDB(원격 DB 서버 )연동 프로그래밍
public class DBTest1 {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public DBTest1() {
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
		
		
		// 3. 연결된 DB server에 sql 실행
		try {
			//sangdata 테이블 자료 읽기
//			result set, connection, statment 객체를 각각 만들어 데이터를 받아오고 연결하고 실행하는데 
//			쓰는데 result set과 statement는 객체를 여러개 만들어 복수의 데이터를 다루는데 사용할 수 있지만 
//			connection 객체는 1개밖에 생성할 수 없다.
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from sangdata");
			//rs = stmt.executeQuery("select code, sang, su, dan from sangdata");
			//위에처럼 칼럼명을 다 쓰기 귀찮으면 *로 대체해도 된다.
//			rs.next(); //커서 (레코드 포인터), 출력할 레코드 앞으로 이동, 첫번쨰 데이터 출력
//			rs.next(); //테이블의 두번째 데이터가 찍힌다., 자료가 있으면 true를 반환한다.
//			System.out.println(rs.next()); // rs 포인터가 가리키는 내용을 출력
//			System.out.println(rs.getString("sang")); // 문자를 읽으므로 getString()
			while(rs.next() /* 뒤에 == true가 생략됨 */) { 
				//rs.next()가 반복되면서 포인터로 가리킬 데이터가 있는 동안에는 true였다가 
				//포인터로 가리킬 데이터가 없을 경우 false를 반환하고 반복문을 빠져나온다.
//				int a = rs.getInt("code"); // 나중에 연산을 위해 문자형을 int형으로 받을 수 있다.
				String code = rs.getString("code"); 
				String sangname = rs.getString("sang"); 
				int su = rs.getInt("su");
				int dan = rs.getInt("dan");
				System.out.println(code + " " + sangname + 
						" " + su + " " + dan);
			}
			System.out.println("------------");
			rs.close();
			rs = stmt.executeQuery("select code as 코드, sang as 상품명, su, dan from sangdata");
			// stmt.executeQuery가 인스턴스를 생성하여 rs에 저장한다.	
			while(rs.next()) {
						String code = rs.getString("코드"); 
						String sangname = rs.getString(2); 
						int su = rs.getInt("su");
						int dan = rs.getInt("dan");
						System.out.println(code + " " + sangname + 
								" " + su + " " + dan);
					}// 별명이 있으므로 code 대신 코드로 불러와야 한다.
// 또는 executeQuery에서 쿼리문을 읽어올 때의 칼럼명 순서대로 번호를 부여하여 불러올 수도 있다.
			
			String sql = "select count(*) as cou from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println("건수 : " + rs.getString("cou"));
			System.out.println("건수 : " + rs.getString("count(*)"));
			System.out.println("건수 : " + rs.getString(1));
			//sql문을 자바 string 변수에 저장 후 자바에서 sql문을 읽어오기 위해 stmt.executeQuery로 읽은 후
			//rs로 받아오고 rs.next() 받아온 sql문을 실행할 수 있도록 포인터 이동 후 rs.getstring("별명")으로 
			//count(*) 값을 가져와 건수: 4가 출력된다. 만약 쿼리문에 별명이 없으면 "cou"대신 "count(*)"을 쓰면 된다.
			//count(*) 값처럼 1개가 아닌 칼럼명이 여러개일 경우 인덱스 순번처럼 번호로 가져올 수도 있다.
			
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		} finally { // rs.close()를 
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
		// TODO Auto-generated method stub
		new DBTest1();
	}

}
