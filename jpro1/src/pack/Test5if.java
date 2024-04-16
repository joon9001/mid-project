package pack;

import java.util.Scanner;

public class Test5if {
	public static void main(String[] args) {
		// 조건 판단문 if 연습
		int num = 2;
		if (num >= 3)
			System.out.println("크군요");// {} 중괄호 바운더리가 없으므로 첫문장인 "크군요" 만 if 조건문에 속한다.
		System.out.println("참일 때"); // "참일 때","출력"은 둘다 if문에 관계없는 문장이므로 출력된다.

		System.out.println("출력");

		// 문제: 키보드로 상품명, 수량, 단가를 각각 입력받아 금액(수량*단가)을 출력하시오.
		// 조건: 금액이 5만원 이상이면 금액에 10%를 세금으로 출력하고 아니면 금액에 5%를 세금으로 출력
		// 출력 모양은 상품명:*** 금액:*** 세금:***

		Scanner sc = new Scanner(System.in);
		System.out.print("상품명:");// 상품명: 이 뜨고 뒤에 커서가 깜빡이면서 값이 입력되기 전까지 대기한다.
		String sangpum = sc.next(); //입력받은 문자열을 sangpum에 저장
		System.out.println("수량:");  // 수량: 이 뜨고 뒤에 커서가 깜빡이면서 값이 입력되기 전까지 대기한다.
		int suryang = sc.nextInt(); // 입력받은 문자열을 suryang에 저장
		System.out.println("단가:"); // 단가: 가 뜨고 
		int danga = sc.nextInt();

		int geumaek = suryang * danga;
		double segeum = 0;
		if (geumaek >= 50000)
			segeum = geumaek * 0.1;

		else
			segeum = geumaek * 0.05;

		System.out.println("상품명:" + sangpum + ", 금액: " + geumaek + "세금: " + Math.round(segeum));
	}
}
