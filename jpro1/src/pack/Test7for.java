package pack;

import java.util.Scanner;

public class Test7for {

	public static void main(String[] args) {
		// 반복문 for
		// for(초기치;조건;증감치){반복 처리 대상}
		//int a;
		int sum = 0;
		int a= 1;
		for (a = 1; a <= 5; a = a + 1) { //조건문 안에 int형 변수 a를 선언하는 동시에 초기값을 설정함으로써 지역변수로 for문이 사용 가능해졌다.
			//(int a = 1; a <= 5; a += 1) a=a+1과 같다
			//(int a = 1; a <= 5; a++) a=a+1과 같다
			System.out.println("a : " + a);
			// a = 4;
			sum += a;  // sum = 1부터 10까지 수행되어 55가 입력된다. 
		}
		System.out.println("반복문 수행 후 a:" + a);
		System.out.println("합은 " + sum);

		for (int i = 65; i <=90; i++) {
			System.out.println((char)i + " ");
		}
		
		System.out.println();
		
		for (int i = 'A'; i <='Z'; i++) {
			System.out.println(i + " ");
		}  // 문자는 ''로 문자열은 ""로 처리, A를 정수형으로 바꾸면 65고 Z는 95이므로 65부터 90까지 차례대로 출력됨
		System.out.println();
		for (int i =10; i > 1; i -= 2) {
			System.out.println(i + " ");
		}
		
		System.out.println();
		for (int ytn = 0, tvn=5; ytn <= 5; ytn++, tvn++) {
			System.out.println(ytn + "," + tvn + ":");
		};
		
		int aa = 1;
		for (; aa <= 5; aa++) {
			System.out.println(aa + " ");
		} // int aa를 for문 밖에서 미리 정의해줬기 때문에 초기값은 생략하고 ;만 남겨놔도 된다.
		
		for (int m=1; m <= 3; m++){
			System.out.println("m=" + m);
			for(int n=1; n<=4; n++) {
				System.out.println("n:" + n + " ");
			}
			System.out.println();
		}
		for (char i=65; i <= 90; i++){
			System.out.println(i + " : ");
			for(char j=i; j<='z'; j++) {
				System.out.println(j);
			}
		System.out.println();
		
	}
		System.out.println();
		//구구단 3단 출력
		for(int count = 1; count < 10; count++) {
			System.out.println("3 * " + count + "=" + (3 * count));
	}
		
		//문1: 키보드로 숫자를 받아 구구단 출력
		// 예) 몇 단? 3
		// 3*1=3 3*2=6 이런 식으로 구구단 출력 프로그램 짜기	
		   Scanner sc = new Scanner(System.in); 

	        System.out.print("구구단을 출력할 단을 입력하세요: ");
	        int dan = sc.nextInt(); //사용자가 입력한 숫자를 dan에 저장

	        // 입력받은 dan의 구구단 출력
	        System.out.println(dan + "단을 출력합니다:");
	        for (int i = 1; i <= 9; i++) {
	            System.out.println(dan + " x " + i + " = " + (dan * i)); 
	        }
	        // 1 X 1 = 1부터 시작하여 1단부터 9단까지 차례대로 출력한다. 
	      
		
		//문2 : 1 ~ 100 사이의 정수 중 3의 배수이면서 5의 배수의 개수와 그 합을 출력
		
	        int count = 0;
	        int sum1 = 0;
	        
	        for (int i = 1; i <= 100; i++) {
	            if (i % 3 == 0 && i % 5 == 0) { // i가 3의 배수이고 5의 배수일 때
	                count++; //count 값을 +1 올린다.
	                sum1 += i; // sum1에 3의 배수이고 5의 배수인 i값을 더해준다.
	            }
	        }
	        
	        System.out.println("1부터 100 사이의 정수 중 3의 배수이면서 5의 배수인 수의 개수: " + count);
	        System.out.println("해당 수들의 합: " + sum1);
		
		//문3: 2~ 2단까지 출력 (다중 for)
		//2*1=2 2*2=4...
		//...
		//9*1=9 9*2=18...
		

    	        for (int m=2; m <= 9; m++){
    				for(int n=1; n<=9; n++) { //각 단마다 1부터 2까지 곱해주며 총 9단까지 진행한다.
    					System.out.print(m + " * "+ n + " = "+ m*n + " ");
    				}
    				System.out.println(); // 이중 for문에서 줄바꿈역할, 각 단마다 엔터를 쳐서 보기 좋게 정렬해준다.
    			}
    	        
//    	        출력결과: 2 * 1 = 2 2 * 2 = 4 2 * 3 = 6 2 * 4 = 8 2 * 5 = 10 2 * 6 = 12 2 * 7 = 14 2 * 8 = 16 2 * 9 = 18 
//    	        		3 * 1 = 3 3 * 2 = 6 3 * 3 = 9 3 * 4 = 12 3 * 5 = 15 3 * 6 = 18 3 * 7 = 21 3 * 8 = 24 3 * 9 = 27 
//    	        		4 * 1 = 4 4 * 2 = 8 4 * 3 = 12 4 * 4 = 16 4 * 5 = 20 4 * 6 = 24 4 * 7 = 28 4 * 8 = 32 4 * 9 = 36 
//    	        		5 * 1 = 5 5 * 2 = 10 5 * 3 = 15 5 * 4 = 20 5 * 5 = 25 5 * 6 = 30 5 * 7 = 35 5 * 8 = 40 5 * 9 = 45 
//    	        		6 * 1 = 6 6 * 2 = 12 6 * 3 = 18 6 * 4 = 24 6 * 5 = 30 6 * 6 = 36 6 * 7 = 42 6 * 8 = 48 6 * 9 = 54 
//    	        		7 * 1 = 7 7 * 2 = 14 7 * 3 = 21 7 * 4 = 28 7 * 5 = 35 7 * 6 = 42 7 * 7 = 49 7 * 8 = 56 7 * 9 = 63 
//    	        		8 * 1 = 8 8 * 2 = 16 8 * 3 = 24 8 * 4 = 32 8 * 5 = 40 8 * 6 = 48 8 * 7 = 56 8 * 8 = 64 8 * 9 = 72 
//    	        		9 * 1 = 9 9 * 2 = 18 9 * 3 = 27 9 * 4 = 36 9 * 5 = 45 9 * 6 = 54 9 * 7 = 63 9 * 8 = 72 9 * 9 = 81
		
  }
}