package pack;

public class Test2 {
	public static void main(String[] args) {
		// 응용 프로그램의 시작 메소드(method)
		
		String ss4 = "5" + 6; // 문자형 5가 있으므로 6도 문자형으로 자동형변환되어 56이 된다.
		String ss5 = Integer.toString(5) + 6; // 위와 같이 문자형 5로 인해 6도 문자형 6으로 자동변환되어 56이 된다.
		//String ss5 = Double.toString(5.5) + 6; //실수형 5.5를 문자형으로 강제형변환하므로 버림이 되어 5가 되고 문자형 5가 있으므로 뒤에 6도 문자형으로 바뀌어 56이 출력된다. 
		
		//int abc = 5 + "6" // type 에러, 문자형 6으로 인해 5도 문자형으로 바뀌어 문자형 56이 int abc에 입력되어야 하는데 abc는 정수형이므로 타입 에러
		int abc = 5 + Integer.parseInt("6"); //문자형 6을 정수형으로 강제 형변환하여 11이 정수형 저장소 abc에 입력되므로 에러가 나지 않는다.
		double abc2 = 5 + Double.parseDouble("6.7"); // 실수형으로 형변환된 6.7과 실수형으로 형변환된 5.0이 더해져서 11.7이 저장된다.
	
		int imsi = 5;
		int result = ++imsi + 1; //imsi: 6, result: 7 //imsi가 + 연산 전에 1증가
		
		int imsi2 = 5;
		int result2 = imsi2++ + 1; // imsi: 6, result: 6 //imsi가 + 연산 후 result에 6을 넘겨준 뒤 1증가
		
		//주의: 증감연산자는 다른 연산자와 함께 쓰지 않는게 좋다.
	}
}
