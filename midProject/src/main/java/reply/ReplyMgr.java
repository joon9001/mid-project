package reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import reply.ReplyBean;
import reply.ReplyDto;


public class ReplyMgr {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public ReplyMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("Db 연결 실패:"+e);
		}
	}
	
	// 해당 책번호의 상세정보출력
	public ArrayList<ReplyDto> getDataAll(int bno){
		ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();
		
		
		try {
			conn = ds.getConnection();
			String sql = "select * from reply where reply_book_no = ? order by reply_gnum desc, reply_onum asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs= pstmt.executeQuery();
			
			
		while(rs.next()) {
			ReplyDto dto= new ReplyDto();
			dto.setReply_no(rs.getInt(1));
			dto.setReply_book_no(rs.getInt(2));
			dto.setReply_id(rs.getString(3));
			dto.setReply_cont(rs.getString(4));
			dto.setReply_create_date(rs.getString(5));
			dto.setReply_title(rs.getString(6));
			dto.setReply_point(rs.getInt(7));
			dto.setReply_image(rs.getString(8));
			dto.setReply_like_cnt(rs.getInt(9));
			dto.setReply_del_is(rs.getInt(10));
			dto.setReply_del_date(rs.getString(11));
			dto.setReply_ip(rs.getString(12));
			dto.setReply_blocked(rs.getInt(13));
			dto.setReply_blocked_cnt(rs.getInt(14));
			dto.setReply_gnum(rs.getInt(15));
			dto.setReply_onum(rs.getInt(16));
			list.add(dto);
		}
			
		} catch (Exception e) {
			System.out.println("getDataAll() err:"+e);
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
	public boolean insertReply(HttpServletRequest request, int newNo, ReplyBean bean){
		boolean b = false;
		
		try {
			//업로드할 이미지 경로: upload 폴더(절대경로)
			String uploadDir= "C:/work/jsou/group_work/src/main/webapp/upload";
			
			// MultipartRequest 생성
			MultipartRequest multi= new MultipartRequest(request, uploadDir, 
					5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			conn = ds.getConnection();
			String sql= "insert into reply(reply_no, reply_point, reply_title, reply_cont, "
					+ "reply_create_date, reply_image, reply_book_no, reply_ip) " +
	                 "values (?, ?, ?, ?, now(), ?, ?, ?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, newNo);
			pstmt.setInt(2, Integer.parseInt(multi.getParameter("reply_point")));
			pstmt.setString(3, multi.getParameter("reply_title"));
			pstmt.setString(4, multi.getParameter("reply_cont"));
			
			//이미지 파일명. 파일 업로드 안할수도 있다.
			if(multi.getFilesystemName("reply_image") == null) {//상품등록시 이미지를 선택하지 않은 경우
				pstmt.setString(5, "cookiecharc.jpg");
			}else {
				pstmt.setString(5, multi.getFilesystemName("reply_image"));
			}
			 pstmt.setInt(6, bean.getReply_book_no());
			 pstmt.setString(7, bean.getReply_ip());
			
			if(pstmt.executeUpdate() > 0) b= true;
		
		}catch (Exception e) {
			System.out.println("insertReply err:"+e);
			//Field 'reply_no' doesn't have a default value //기본키. 꼭 불러서 값을 넣어주자.
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return b;
	}
	//int newNo= replyMgr.currentMaxNo()+1;
	public int currentMaxNo() { //reply 테이블의 최대 번호 반납
		String sql ="select max(reply_no) from reply";
		int no=0;
		
		try {
			conn=ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			if(rs.next()) no = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("currentMaxno err: "+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
		return no;
		
	}
	public int avgPoint() {
		String sql= "select avg(reply_point) from reply";
		int a =0;
		
		try {
			conn=ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			if(rs.next()) a = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("currentMaxno err: "+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
		return a;
		
		
	}
	
	//replyMgr.saveData(bean);
	public void saveData(ReplyBean bean) {
		String sql= "insert into reply values(?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn=ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getReply_no());
			pstmt.setInt(2, bean.getReply_book_no());
			pstmt.setString(3, bean.getReply_id());
			pstmt.setString(4, bean.getReply_cont());
			pstmt.setString(5, bean.getReply_create_date());
			pstmt.setInt(6, bean.getReply_point());
			pstmt.setInt(7, 0);//Reply_like_cnt. 누적용 0.
			pstmt.setInt(8, 0);//bean.getReply_del_is()
			pstmt.setString(9, bean.getReply_del_date());
			pstmt.setString(10, bean.getReply_ip());
			pstmt.setInt(11, bean.getReply_blocked());
			pstmt.setInt(12, bean.getReply_blocked_cnt());
			pstmt.setInt(13, bean.getReply_gnum());
			pstmt.setInt(14, 0);//Reply_onum
			pstmt.setString(15, bean.getReply_title());
			pstmt.setString(16, bean.getReply_image());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("saveData err: "+e);
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
	//
	
	//replyMgr.replyLikecnt(reply_no);
	public void replyLikecnt(int reply_no) { // 좋아요수 // 좋아요 조건을 어떻게 줘야할지?
		String sql= "update reply set reply_like_cnt = reply_like_cnt +1";
		
		try {
			conn=ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			//pstmt.setString(1, );
			pstmt.executeUpdate(); // 0 - 1
			
		} catch (Exception e) {
			System.out.println("replyLikecnt err: "+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
		
	}
	
	//dto = ReplyMgr.getData(reply_no);
	public ReplyDto getData(int reply_no){
		String sql = "select * from reply where reply_no=?";
		ReplyDto dto = null;
		
		try {
			conn=ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, reply_no);
			rs= pstmt.executeQuery(); 
			
			//글을 눌러서 보도록유도. url접근 막기. 
			if(rs.next()) { //포인터이동시켜 자료있을경우 자료보여주기.
				dto = new ReplyDto();
				dto.setReply_id(rs.getString("reply_id"));
				dto.setReply_create_date(rs.getString("reply_create_date"));
				dto.setReply_like_cnt(rs.getInt("reply_like_cnt"));
				dto.setReply_title(rs.getString("reply_title"));
				dto.setReply_image(rs.getString("reply_image"));
				dto.setReply_cont(rs.getString("reply_cont"));
				
			}
			
		} catch (Exception e) {
			System.out.println("getData err: "+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
		return dto;
	}
//dto = replyMgr.getReplyData(reply_no);
	public ReplyDto getCommentData(String reply_no) {
		String sql = "select * from reply where reply_no=?";
		ReplyDto dto = null;
		
		try {
			conn=ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, reply_no);
			rs= pstmt.executeQuery(); 
			
		 
			if(rs.next()) { 
				dto =new ReplyDto();
				dto.setReply_book_no(rs.getInt("reply_book_no"));
				dto.setReply_title(rs.getString("reply_title"));
				dto.setReply_gnum(rs.getInt("reply_gnum"));
				dto.setReply_onum(rs.getInt("reply_onum"));
			}
	
			
		} catch (Exception e) {
			System.out.println("getCommentData err: "+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
		
		return dto;
		
	}
	
	//replyMgr.saveEdit(bean);
	public void saveEdit(ReplyBean bean) {
		String sql="update reply set reply_point=?, reply_title=?, reply_cont=? where reply_no=?";
		
		try {
			conn= ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getReply_point());
			pstmt.setString(2, bean.getReply_title());
			pstmt.setString(3, bean.getReply_cont());
			pstmt.setInt(4, bean.getReply_no());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("saveEdit err: "+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
		
		
	}
	
	//ReplyMgr.delData(reply_no);
	public void delData(String reply_no) {
		String sql= "delete from reply where reply_no=?";
		try {
			conn= ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, reply_no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("delData err: "+e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	
	

	
}
