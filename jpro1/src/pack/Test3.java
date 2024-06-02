package pack;

public class Test3 {
	public static void main(String[] args) {
		//관계, 논리 연산자
		int a = 5;
		int b = 3;
		System.out.println(a>3);
		boolean bo = a >3;
		System.out.println(bo);
		boolean bb = a < 3  || b <= 1 + 1 * 1; 
		// 연산자 우선순위: ()소괄호 > 산술(*,/,+,-)연산자 > 관계 연산자 > 논리 연산자 > 치환 연산자
		
		int ii = 8, ij = 0;
		System.out.println("ii:" + Integer.toBinaryString(ii)); // 8을 2진수로 바꾸므로 1000이 된다.
		
		ij = ii << 1; // << 좌측으로 1bit 이동, 남는 우측은 0으로 채움. 1000에서 10000이 된다.
		System.out.println("ii:" + ii + ", ij:" + ij); //지역변수 ij 초기화 // ii:8, ij: 16
		
		ij = ii >>> 2;  // >> 우측으로 2bit 이동, 2^3에서 2^1이 되므로 2가 된다.
		System.out.println("ii:" + ii + ", ij:" + ij); // ii:8, ij:2
		
		int sbs = 3;
		int mbc = (sbs > 5)?100:10 + 20 * 2; // 삼항연산자,( )안에 조건식이 참이면 : 앞이 실행되고 거짓이면 : 뒤가 실행됨
		System.out.println(mbc); // 출력결과 50, (sbs > 5)가 false이므로 100이 아닌 10이 되고 뒤에 40과 합쳐져서 50이 된다.
		aa(); //static void main 함수에서 aa ()함수를 호출하였으므로 바깥의 boolean aa ()함수가 실행되어 "aa 출력"이 출력된다.
		
		System.out.println("프로그램 종료");
		
		
		//b2 = bb() || aa(); // or 연산이라 둘 중에 하나만 참이어도 참이므로 bb() 수행 결과가 참이면 aa ()를 실행하지 않고 bb()수행 결과가 거짓이면 aa()까지 실행한다.
		//b2 = aa() | bb(); // or 연산이지만 모든 메소드를 호출한다.
		//b3 = bb() && aa(); // and 연산이라 둘다 참이어야 하므로 bb()가 참이면 aa()까지 실행하지만 bb()가 거짓이면 aa()는 실행하지 않는다.
		
	}
	public static boolean aa() {
		System.out.println("aa 출력");
		return true; //class가 boolean 타입이므로 return 유형도 true 또는 false가 되어야 한다. return true는 정상적으로 종료하고 aa ()함수로 돌아간다는 의미
	}
}
