package pack;

import java.util.Scanner;

public class Test4inputData {

	public static void main(String[] args) {
		// 프로그램 진행 도중에 외부에서 값 얻기
		System.out.println("뭔가를 하다가...");
		// args 매개변수를 통해 값 얻기
		System.out.println(args.length); // 1 출력
		System.out.println("args : " + args[0]); //여러개의 args index 중에 0번째 run configurtion - arguments에서 넣어준 안녕 이 출력된다.
		
		System.out.println();
		// 프로그램 진행 도중에 외부에서 값 얻기
		Scanner sc = new Scanner(System.in); //표준 입력장치(키보드)로 값 얻기
		System.out.print("이름입력:");//이름입력: 뒤에 커서가 깜빡이면서 값이 입력되기 전까지 대기한다.
		String irum = sc.next();
		System.out.println("나이 입력:");
		int nai = sc.nextInt();
		System.out.println("이름은" + irum + ", 나이는 " + nai + "살"); //irum에 내가 키보드로 입력한 값이 들어가서 출력되므로 이름 입력 후 엔터를 치면 이름은 입력값이 출력된다.
	
	
	
	
	}

}
