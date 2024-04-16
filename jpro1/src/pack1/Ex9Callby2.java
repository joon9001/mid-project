package pack1;

public class Ex9Callby2 {
	public void ex(int a, int b) { // 매개변수(parameter)로 기본형 사용
		int imsi = a;
		a = b;
		b = imsi;
		//위의 코드는 a와 b의 값 치환 작업을 나타낸다.
		System.out.println("메소드 내의 a: " + a + ",b:" + b);
	}
	public void ex(Ex9Callby1 data) { //매개변수(parameter)로 참조형 사용
		//Ex9Callby1 data 객체를 인수로 받음으로써 data.a와 data.b는 변수값이 아니라 변수가 저장된 주소를 의미한다
		//Ex9Callby1 클래스의 어떠한 변수도 가져올 수 있다.
		int imsi = data.a;
		data.a = data.b;
		data.b = imsi;
		System.out.println("메소드 내의 a: " + data.a + ",b:" + data.b);
	}
	public void ex(int[] ar) {
		int imsi = ar[0];
		ar[0] = ar[1];
		ar[1] = imsi;
		System.out.println("메소드 내의 a: " + ar[0] + ",b:" + ar[1]);
	}
}

