package pack4;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex28ListTest {
	public static void main(String[] args) {
		// List류의 ArrayList로 연습 : Set과 다르게 중복이 가능하고 순서가 있다.
		ArrayList<String> list = new ArrayList<String>();
		list.add("Lee"); //list가 hashset이라 중복 불가이므로 Lee는 3개지만 1개만 출력된다.
		list.add("Lee");
		list.add("Lee");
		list.add("Park");
		list.add("Hong");
	//	list.remove("park"); // collection에 들어간 내용을 지움
		list.remove(0); 
	//	인덱스 번호로 지우는건 순서가 있는 List는 되지만 순서가 없는 set에서는 불가하다.
	//	list.clear(); //collection에 들어간 모든 자료를 지움
		
		System.out.println("크기 : " + list.size());
		
		for(Object obj:list) {
			System.out.println(obj);
		}
		
		System.out.println();
		Iterator iter = list.iterator();
		//Iterator 반복자 함수를 이용하여 for 반복 구문을 대체할 수 있다.
		while (iter.hasNext()) { 
//iter.hasNext()는 iter라는 list에 자료가 있으면 true가 되어 { } 내용을 false가 될때까지 계속 실행한다.
			String ss = (String)iter.next();
			//타입 미스매치를 방지하기 위해 (String)으로 강제 형변환
				System.out.println(ss);
				
		
	}
}
	}
