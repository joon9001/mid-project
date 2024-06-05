package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class connClass {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public connClass() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
		} catch (Exception e) {
			System.out.println("ConnClass err : " + e);
		}
	}
	
	public ArrayList<sangpumDto> getDataAll(){
		ArrayList<sangpumDto> list = new ArrayList<sangpumDto>();
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			pstmt = conn.prepareStatement("select * from sangdata");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sangpumDto dto = new sangpumDto();
				dto.setCode(rs.getString("code"));	// rs.getString(1)
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("getDataAll err : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return list;
	}
	
}
