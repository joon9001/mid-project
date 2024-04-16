package pack;


public class Test1 {
		public static void main(String[] args) {
		System.out.print("자바");
		//주석. 실행;
		System.out.print("변수");
		System.out.println("연습");
		// 한 줄 주석
		/*
		System.out.println("나이스");
		System.out.println("단축키를 사용하자");
		 여러 줄 
		 */
		System.out.println("주석 연습"); // 한 줄 주석
		System.out.println("주석 연습"); // 한 줄 주석
		byte var1;
		var1 = 3;
		var1 = 5;
		System.out.println(var1);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		System.out.println("형변환에 대해 : 자동형변환(promotion), 강제형변환(casting)"); //자바에서 정수는 int로 인정
		short ss = 10; // 자동형변환(promotion)
		short ss2 = (short)10; // 강제형변환(casting)
		System.out.println(ss + " " + ss2); //문자 + 숫자는 문자
		// short ss3 = 50000; short의 숫자 범위 초과
		// System.out.println(ss3);
		
		int imsi = 123;
		short ss4 = 123; // 정수형 int 123이 ss4로 자동 형변환되어 입력
		// short ss4 = imsi;  에러 : 정수형 int imsi 변수인 21억 내의 숫자 범위가 숫자 3만의 범위를 가진 short형으로 들어갈 수 없기 때문
		// short ss4 = (short) imsi; 강제형변환으로 에러 해결
		double d1 = 1.2; // 실수형 double은 8byte
		d1 = 12.345;
		d1 = 12345; // 정수는 실수 기억장소에 기억될 때 실수로 자동형변환(promotion) 되므로 12345.0으로 자동 변환된다. 실수가 정수보다 우선순위가 높으므로 정수가 실수로 바뀌는것
		float f1 = 12.3F; // 12.3이 double형 실수이므로 float형에 맞게 12.3F로 강제 형변환 해줘야 한다.
		float f2 = (float)12.3;
		
		double result = 4.5 + 10; //연산자 우선순위는 실수 - 정수 - 문자 순이므로 정수 10이 10.0의 double형으로 자동 형변환
		result = 4.5 + (double)10;
		result = (int)4.5 + 10; //double형 4.5가 정수형으로 버림이 일어나 4가 되고 14에서 result가 위의 연산에 의해 double형이므로 14.0의 double형 값이 저장된다.
		System.out.println(result); // 14.0이 출력
		
		System.out.println("안녕" + 13 + "반가워"); //안녕13반가워 출력
		System.out.println("안녕" + (char)13 + "반가워"); // ----- 1번
		System.out.println("안녕\n반가워"); // ---- 2번 
		//안녕
		//반가워 1번과 2번이 똑같이 이렇게 출력되는 이유는 아스키 코드에 숫자 13이 CRLF인 엔터키를 친것과 같고 \n도 엔터 친 것과 똑같다.
		
		}
}



 