package pack1;

public class ClassPre2 {
	// 다른 클래스에서 필요한 자원 담아둔 저장소 역할
	
	// 방법3: 합 구하기 코드 별도 클래스에서 작성
	public static void hap(int su1, int su2) { //방법 2: 합구하기 코드 별도 작성
		System.out.println("방법3 합은 " + (su1 + su2));
	}
	public static void cha(int su1, int su2) {
		System.out.println("방법3 차는 " + (su1 - su2));
	}

}
