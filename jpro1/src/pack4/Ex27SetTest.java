package pack4;

import java.util.HashSet;
import java.util.Iterator;

//collection : 다수의 객체를 담을 수 있는 집합형 자료구조
public class Ex27SetTest {

	public static void main(String[] args) {
		// Set류의 HashSet으로 연습 : 중복 불가, 순서x
		
		Ex27SetTest test = new Ex27SetTest();
	//	HashSet<Ex27SetTest> list  = new HashSet<Ex27SetTest>();
	//	list.add(1);
	//	list.add(test);
		HashSet<String> list  = new HashSet<String>();
		list.add("Lee"); //list가 hashset이라 중복 불가이므로 Lee는 3개지만 1개만 출력된다.
		list.add("Lee");
		list.add("Lee");
		list.add("Park");
		list.add("Hong");
	//	list.remove("park"); // collection에 들어간 내용을 지움
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
