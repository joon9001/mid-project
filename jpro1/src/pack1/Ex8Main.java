package pack1;

import java.time.LocalDate;

public class Ex8Main {

	public static void main(String[] args) {
		// 싱글톤 패턴 연습
		Ex8SingletonClass s1 = new Ex8SingletonClass();
		System.out.println(s1.kor);
		//출력결과: 90
		Ex8SingletonClass s2 = new Ex8SingletonClass();
		System.out.println(s2.kor);
		//출력결과: 90
		System.out.println(s1 + " " + s2);
		//출력결과:pack1.Ex8SingletonClass@6504e3b2 pack1.Ex8SingletonClass@515f550a
		System.out.println(s1.hashCode() + " " + s2.hashCode());
		//출력결과: 1694819250 1365202186
		//s1과 s2를 new 객체로 만들었기 때문에 hashCode()를 찍어보면 
		//메모리 참조 주소가 서로 다르다는 것을 알 수 있다.
		System.out.println("-------------");
		Ex8SingletonClass s3 = Ex8SingletonClass.getInstance();
		//클래스명.함수() 형태로 불러와야 하므로 Ex8SingletonClass 파일의
		// Ex8SingletonClass를 static으로 선언한다
		System.out.println(s3.kor);
		//출력결과: 90
		Ex8SingletonClass s4 = Ex8SingletonClass.getInstance();
		System.out.println(s4.kor);
		//출력결과: 90
		System.out.println(s3.hashCode() + " " + s4.hashCode());
		//출력결과: 1330106945 1330106945
		//싱글톤 객체를 이용하여 메모리 참조 주소를 공유하므로 s3와 s4의 hashcode를 찍어보면 같다.
		System.out.println("날짜 출력 싱글톤 사용 예");
		//출력결과: 날짜 출력 싱글톤 사용 예
		LocalDate mynow = LocalDate.now(); 
		// now가 기울어져있으므로 localdate가 static임을 알 수 있다.
		LocalDate mynow2 = LocalDate.now();
		System.out.println(mynow.hashCode() + " " + mynow2.hashCode());
		//출력결과: 4145412 4145412
		//싱글톤 객체를 이용하여 메모리 참조 주소를 공유하므로 s3와 s4의 hashcode를 찍어보면 같다.
	}
		
}
