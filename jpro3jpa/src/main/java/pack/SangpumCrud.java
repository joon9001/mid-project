// https://cafe.daum.net/flowlife/HrhB/79
// https://cafe.daum.net/flowlife/HqLo/62


package pack;

import java.util.List;

import domain.SangpumTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class SangpumCrud {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa");
		
		// EntityManager : thread 단위로 작업
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
//		// 자료 추가 
//		try {
//			transaction.begin(); // auto commit 해제
//			SangpumTable sangtab = new SangpumTable(7, "도시락", 3, 6000);
//			em.persist(sangtab);
//			transaction.commit();
//		} catch (Exception e) {
//			System.out.println("ins err : " + e);
//			transaction.rollback();
//			return;
//		}
		
		// 자료 수정
//		try {
//			transaction.begin();
//			SangpumTable sangtab = em.find(SangpumTable.class, "7"); //7번 자료를 찾아 sangtab에 저장
//			if(sangtab == null) {
//				System.out.println("해당 자료 없음");
//			}else { // 자료가 있을 경우 sang 이름을 마스크로 변경
//				String newName = "마스크";
//				sangtab.setSang(newName);
//				transaction.commit();
//			}
//		} catch (Exception e) {
//			System.out.println("up err : " + e);
//			transaction.rollback();
//			return;
//		}
		
		// 자료 삭제
		try {
			transaction.begin();
			
			int findcode = 6;
			SangpumTable sangtab = em.find(SangpumTable.class, findcode); //6번 자료 읽은 후 sangtab에 저장
			if(sangtab == null) {
				System.out.println("해당 자료 없음");
			}else {
				em.remove(sangtab); // 자료가 저장되어있는 sangtab 삭제
				System.out.printf("자료 삭제됨 : %s", findcode);
				transaction.commit();
			}
		} catch (Exception e) {
			System.out.println("del err : " + e);
			transaction.rollback();
			return;
		}
		
		// JPA를 사용한 DML 처리 
		try {
			System.out.println("전체 자료 읽기 1");
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<SangpumTable> query = cb.createQuery(SangpumTable.class);
			
			// 조회의 시작점을 의미하는 root 객체 생성
			Root<SangpumTable> root = query.from(SangpumTable.class);
			query.select(root); // jpa 함수로 쿼리 조회
			List<SangpumTable> resultList = em.createQuery(query).getResultList();
			
			for(SangpumTable st:resultList) {
				System.out.println(st.getCode() + " " + st.getSang() + " " +
						st.getSu() + " " + st.getDan());
			}
			System.out.println("\n전체 자료 읽기 2");
			// TypedQuery을 이용하여 JPQL 사용 
//			TypedQuery<SangpumTable> queryql = em.createQuery(
//					"select s from SangpumTable s", SangpumTable.class);
//			List<SangpumTable> list = queryql.getResultList();
			// 위 두 줄을 아래와 같이 한 줄로 표현
			List<SangpumTable> list  = em.createQuery(
					"select s from SangpumTable s", SangpumTable.class).getResultList();

			for(SangpumTable st:list) {
				System.out.println(st.getCode() + " " + st.getSang() + " " +
						st.getSu() + " " + st.getDan());
			}
			
			System.out.println("\n부분 자료 읽기 1");
			int findId = 1;  // String findId = "1";  pk 칼럼이 대상, primary key일 경우 find로 조회
			SangpumTable sangtab = em.find(SangpumTable.class, findId);
			if(sangtab == null) {
				System.out.println("자료 없음");
			}else {
				System.out.printf("%s %s %s %s \n",
						sangtab.getCode(), sangtab.getSang(),
						sangtab.getSu(),sangtab.getDan());
			}
			
			System.out.println("\n부분 자료 읽기 2");
			TypedQuery<SangpumTable> typedQuery = em.createQuery(
					query.where(cb.equal(root.get("sang"), "장갑")));
			List<SangpumTable> resultList2 = typedQuery.getResultList();
			
			for(SangpumTable sangtab2: resultList2) {
				System.out.printf("%s %s %s %s\n",
						sangtab2.getCode(), sangtab2.getSang(),
						sangtab2.getSu(), sangtab2.getDan());
			}
		} catch (Exception e) {
			System.out.println("err : " + e);
		}finally {
			em.close();
			emf.close();
		}

	}

}
