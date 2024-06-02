package pack1;

public class ClassPreceding {
	// 클래스 이해 전에 자원의 재활용에 대해 알아보기

	public static void main(String[] args) {
		int su1 = 6;
		int su2 = 3;

		System.out.println("합은 " + (su1 + su2)); // 방법1 "합은 9" 출력
		System.out.println("차는 " + (su1 - su2)); // "차는 3" 출력
		//뭔가를 하다가...
		System.out.println("방법 1 사용"); 
		// 합과 차 구하기가 또 필요
		System.out.println("합은 " + (su1 + su2)); // 방법1
		System.out.println("차는 " + (su1 - su2));
		
		System.out.println("\n방법 2 사용");
		//별도의 단위 프로그램을 작성 후 필요할 때마다 호출
		hap(su1, su2); // classpre2 클래스에서 정의한 함수를 이용하여 su1과 su2의 합을 구해 출력하므로 "합은 9"가 출력된다.
		cha(su1, su2); // 마찬가지 방법으로 "차는 3"이 출력된다.
		//뭔가를 하다가...
		System.out.println();
		// 합과 차 구하기가 또 필요
		hap(su1, su2);
		cha(su1, su2);
		
		System.out.println("\n방법 3 사용 - ClassPre2의 단위 프로그램을 호출");
		//별도의 단위 프로그램을 작성 후 필요할 때마다 호출
		ClassPre2 my = new ClassPre2();
		my.hap(su1, su2);
		my.hap(20, 5);
		my.cha(su1, su2);
		
	}
	
	public static void hap(int su1, int su2) { //방법 2: 합구하기 코드 별도 작성
		System.out.println("합은 " + (su1 + su2));
	}
	public static void cha(int su1, int su2) {
		System.out.println("차는 " + (su1 - su2));
	}
}
