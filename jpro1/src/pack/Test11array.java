package pack;

public class Test11array {

	public static void main(String[] args) {
		// main 메소드의 매개변수(배열) 확인
		if(args.length == 0) { //메인함수의 매개변수가 없다면 아래 결과값을 출력한다.
			System.out.println("실행 시 값을 주세요");
			System.exit(0);
		}
		System.out.println(args.length); //run configuration에서 arguments를 길동 만세 라고 입력했기 때문에 arguments.length = 2로 출력 된다.
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		System.out.println();
		for(String imsi: args) { // 배열이나 컬렉션으로 들어가는 문자형 저장소 imsi
			System.out.println(imsi); // 배열에 저장된 값을 차례대로 반환 후 자동으로 종료된다.
		}
		
		System.out.println("응용프로그램 종료");
	}

}
