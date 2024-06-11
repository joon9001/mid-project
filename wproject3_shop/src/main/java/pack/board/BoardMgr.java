package pack.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardMgr {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	private int recTot; // 전체 레코드 수
	private int pList = 10; // 페이지 당 출력 행 수
	private int pageSu; // 전체 페이지 수 
	
	public BoardMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("db 연결 실패 : ");
		}
	}
	//public ArrayList<BoardDto> getDataAll(int page)
	public ArrayList<BoardDto> getDataAll(int page, String stype, String sword){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		
		String sql = "select * from board";// order by gnum desc, onum asc";
		try {
			conn = ds.getConnection();
			
			if(sword == null) { //검색이 없는 경우
				sql += " order by gnum desc, onum asc";
				pstmt = conn.prepareStatement(sql);
			}else { // 검색이 있는 경우
				sql += " where " + stype + " like ?";
				sql += " order by gnum desc, onum asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + sword + "%");
			}

			rs = pstmt.executeQuery();
			
			//paging 
			for(int i=0; i < (page - 1) * pList; i++) {
				rs.next(); //레코드 포인터 이동 0, 9, 19 ...
			}
			
			int k = 0;
			while(rs.next() && k < pList) {
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setBdate(rs.getString("bdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setNested(rs.getInt("nested"));
				list.add(dto);
				k++;
			}
		} catch (Exception e) {
			System.out.println("getDataAll err : " + e);
		} finally {
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
	
	public int currentMaxNum() { // board 테이블의 최대 번호 반납
		String sql = "select max(num) from board";
		int num = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) num = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("currentMaxNum err : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	
	return num;
	}
	
	public void saveData(BoardFormBean bean) { // board insert
		String sql = "insert into board values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getNum());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPass());
			pstmt.setString(4, bean.getMail());
			pstmt.setString(5, bean.getTitle());
			pstmt.setString(6, bean.getCont());
			pstmt.setString(7, bean.getBip());
			pstmt.setString(8, bean.getBdate());
			pstmt.setInt(9, 0); // readcnt
			pstmt.setInt(10, bean.getGnum()); 
			pstmt.setInt(11, 0); // onum
			pstmt.setInt(12, 0); // nested
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("saveData err : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		
		}
	}
	
	public void totalList() { // 전체 레코드 수 구하기
		String sql = "select count(*) from board";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			recTot = rs.getInt(1); 
			//SQL 쿼리 결과의 첫 번째 열이 board 테이블의 전체 레코드 수를 나타내는 count(*) 값이므로
			//rs.getInt(1)은 전체 레코드 수를 가져오게 된다.
			System.out.println("전체 레코드 수 : " + recTot);
		} catch (Exception e) {
			System.out.println("totalList err : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		
		}
		
	}
	
	public int getPageSu() { // 전체 페이지 수 반환
		pageSu = recTot / pList;
		if(recTot % pList > 0) pageSu++;
		return pageSu;
	}
}