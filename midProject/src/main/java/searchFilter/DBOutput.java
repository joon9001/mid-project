package searchFilter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBOutput {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	public DBOutput() {

		/*
		 * JNDI Java Naming and Directory Interface. 이름지정 및 디렉토리 서비스에서 제공하는 데이터 및 객체를
		 * 참조(lookup)하기 위한 자바 API이다.  일반적으로 자바 애플리케이션을 외부 디렉터리 서비스(DB server,LDAP
		 * server..)에 연결할 때 쓰이는데 그중에서도 데이터베이스 연결에 가장 많이 쓰인다. 
		 */

		try {
			// META-INF의 context.xml에 설정한 DB 연결 정보 읽기. pool에서 Connection 개체를 읽음
			Context context = new InitialContext();
			// ds: 데이터 소스 객체로, 데이터베이스 연결 풀을 관리합니다.
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("db 연결 실패:" + e);
		}

	}

	public ArrayList<BookDto> getDataAll() {
		ArrayList<BookDto> list = new ArrayList<BookDto>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select * from book");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookDto dto = new BookDto();
				dto.setBnum(Integer.parseInt(rs.getString(1)));
				dto.setTitle(rs.getString(2));
				dto.setAuthor(rs.getString(3));
				dto.setPublisher(rs.getString(4));
				dto.setPyear(Integer.parseInt(rs.getString(5)));
				dto.setThumb_nail(rs.getString(6));
				list.add(dto);
			}

		} catch (Exception e) {
			System.out.println("getdataAll err : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
		}
		return list;
	}
}
