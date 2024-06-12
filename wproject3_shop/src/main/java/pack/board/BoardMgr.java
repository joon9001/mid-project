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
	private int pList = 5; // 페이지당 출력 행수
	private int pageSu; // 전페 페이지수

	public BoardMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("Db 연결 실패:" + e);
		}
	}

	// public ArrayList<BoardDto> getDataAll(int page){
	public ArrayList<BoardDto> getDataAll(int page, String stype, String sword) { // 반환값 배열묶음
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();

		String sql = "select * from board"; // order by gnum desc, onum asc
		try {
			conn = ds.getConnection();

			if (sword == null) { // 검색이 없는경우
				sql += " order by gnum desc, onum asc";
				pstmt = conn.prepareStatement(sql);
			} else { // 검색이 있는 경우
				sql += " where " + stype + " like ?";
				sql += " order by gnum desc, onum asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + sword + "%");
			}

			rs = pstmt.executeQuery();

			// 페이징처리
			for (int i = 0; i < (page - 1) * pList; i++) {
				rs.next(); // 레코드 포인터 이동 0, 4, 9, 14, 19..
			}

			int k = 0;
			while (rs.next() && k < pList) {
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
			System.out.println("getDataAll() err:" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
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
			if (rs.next())
				num = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("currentMaxNum err: " + e);
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
			pstmt.setInt(9, 0); // readcnt. 누적을 위해 O을 기본값으로 준다.
			pstmt.setInt(10, bean.getGnum());
			pstmt.setInt(11, 0); // onum
			pstmt.setInt(12, 0); // nested
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("currentMaxNum err: " + e);
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

	}

	public void totalList() { // 전체 레코드 수 구하기
		String sql = "select count(*) from board";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			recTot = rs.getInt(1);
			System.out.println("전체레코드수: " + recTot);
		} catch (Exception e) {
			System.out.println("totalList err: " + e);
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
	}

	public int getPageSu() { // 전체 페이지 수 반환
		pageSu = recTot / pList;
		if (recTot % pList > 0)
			pageSu++;
		return pageSu;
	}

	public void updateReadcnt(String num) { // 조회수증가 //boardMgr.updateReadcnt(num);
		String sql = "update board set readcnt= readcnt+1 where num=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate(); // 0 - 1

		} catch (Exception e) {
			System.out.println("updateReadcnt err: " + e);
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

	}

	public BoardDto getData(String num) {// dto = boardMgr.getData(num); //반환값한개 dto
		String sql = "select * from board where num=?";
		BoardDto dto = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery(); // select니까 -query. 나머지는 update.

			// 글을 눌러들어오는게 아니라 url에서 찍고 들어올수있으니 그걸 막기위해.
			if (rs.next()) { // 포인터를 이동했을때 자료가 있는지. 그래서 글이있는경우 해당글정보읽는다.
				dto = new BoardDto();
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("pass"));
				dto.setMail(rs.getString("mail"));
				dto.setTitle(rs.getString("title"));
				dto.setCont(rs.getString("cont"));
				dto.setBip(rs.getString("bip"));
				dto.setBdate(rs.getString("bdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (Exception e) {
			System.out.println("getData err: " + e);
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
		return dto;

	}

	public BoardDto getReplyData(String num) {// 댓글용
		String sql = "select * from board where num=?";
		BoardDto dto = null;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery(); // select니까 -query. 나머지는 update.

			// 글을 눌러들어오는게 아니라 url에서 찍고 들어올수있으니 그걸 막기위해.
			if (rs.next()) { // 포인터를 이동했을때 자료가 있는지. 그래서 글이있는경우 해당글정보읽는다.
				dto = new BoardDto();
				dto.setTitle(rs.getString("title"));
				dto.setGnum(rs.getInt("gnum"));
				dto.setOnum(rs.getInt("onum"));
				dto.setNested(rs.getInt("nested"));
			}
		} catch (Exception e) {
			System.out.println("getData err: " + e);
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
		return dto;

	}

	public void updateOnum(int gnum, int onum) { // 댓글용 : onum 갱신
		// 같은 그룹의 레코드는 모두 작업에 참여 - 같은 그룹의 onum 값 갱신
		// 댓글의 onum은 이미 db에 있는 onum 보다 크거나 같은 값을 변경함
		String sql = "update board set onum=onum + 1 where onum >= ? and gnum=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, onum);
			pstmt.setInt(2, gnum);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("getData err: " + e);
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
	}

	public void replySave(BoardFormBean bean) { // 댓글용 - 저장
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
			pstmt.setInt(9, 0); // readcnt. 누적을 위해 O을 기본값으로 준다.
			pstmt.setInt(10, bean.getGnum());
			pstmt.setInt(11, bean.getOnum()); // onum
			pstmt.setInt(12, bean.getNested()); // nested

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("currentMaxNum err: " + e);
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
	}
	public boolean checkPass(int num, String user_pass) { // 글수정에서 비번 비교
		boolean b = false;
		
		String sql = "select pass from board where num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(user_pass.equals(rs.getString("pass"))) {
					b = true;
				}
			}
		} catch (Exception e) {
			System.out.println("checkPass err: " + e);
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
		return b;
	}
	
	public void saveEdit(BoardFormBean bean) {
		String sql = "update board set name=?,mail=?,title=?,cont=? where num=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getMail());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getCont());
			pstmt.setInt(5, bean.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("saveEdit err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	public void delData(String num) {
		String sql = "delete from board where num=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("delData err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
}
