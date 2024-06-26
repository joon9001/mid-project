package pack;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProcessDao {
	private static ProcessDao dao = new ProcessDao();
	public static ProcessDao getInstance() {
		return dao;
	}
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectDataAll() throws SQLException{
		SqlSession sqlSession = factory.openSession(); // 세션 열기 
		List list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		return list;
	}
	
	public DataDto selectPart(String para) throws SQLException{
		SqlSession sqlSession = factory.openSession(); // 세션 열기 
		DataDto dto = sqlSession.selectOne("selectDataById", para);
		sqlSession.close();
		return dto;
	}
	
	public void insData(DataDto dto) throws SQLException{
		SqlSession sqlSession = factory.openSession(); // transaction 수동 처리 (commit 처리 해줘야 함)
		sqlSession.insert("insertData", dto);
		sqlSession.commit();
		sqlSession.close();
	}
	public void upData(DataDto dto) throws SQLException{
		SqlSession sqlSession = factory.openSession(true); // transaction 자동 처리 (commit 처리 안해줘도 됨)
		sqlSession.update("updateData", dto);
		sqlSession.close();
	}
	public boolean delData(int para) {
		boolean result = false;
		SqlSession sqlSession = factory.openSession(); 
		
		try {
			int cou = sqlSession.delete("deleteData", para); //cou에 0또는 1이상의 값이 넘어가는데 0일 경우 삭제 성공, 1이상이면 삭제 실패다.
			if (cou > 0) result = true;
			
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("delData err : " + e);
			sqlSession.rollback();
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return result;
	}
	
	
}
