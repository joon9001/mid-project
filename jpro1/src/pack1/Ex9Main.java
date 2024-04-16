package pack1;

public class Ex9Main {

	public static void main(String[] args) {
		// 메소드 호출 시 매개변수를 통한 자료 전달 (타입이 기본형, 참조형)
		Ex9Callby1 myData = new Ex9Callby1();
		Ex9Callby2 myMethod = new Ex9Callby2();
		
		System.out.println("원래 a:" + myData.a + ",b:" + myData.b);
		myMethod.ex(myData.a, myData.b);
		//Ex9Callby1 변수의 기본형 값을 인수로 Ex9Callby2 클래스 내 ex 함수에 전달한다.
		System.out.println("1. 수행 후: " + myData.a + ",b:" + myData.b);
		//출력결과: 1. 수행 후: 10,b:20
		//Ex9Callby1객체와 Ex9Callby2객체의 메모리 주소가 다르므로 Ex9Callby2객체의 a,b값이 바뀌어도 
		//Ex9Callby1객체의 a,b값은 안바뀌므로 수행 후 값이 원래 값과 같다.
		
		System.out.println();
		myMethod.ex(myData);//Ex9Callby1 객체 타입의 주소를 전달
		//Ex9Callby2 클래스 파일의 ex 함수 중에서 인수가 하나인 public void ex(Ex9Callby1 data){}함수로 
		//myData 객체 주소가 전달된 상태로 a와 b의 값을 바꾼 후 출력되는 블럭이 실행된다.
		
		System.out.println("2. 수행 후 a:" + myData.a + ",b:" + myData.b );
		//위에서 객체 주소를 전달하였으므로 Ex9Callby1객체 값이 Ex9Callby2값으로 아예 바뀌어서 출력된다.
//객체는 참조에 의한 전달이기 때문에 복사 할 시에 메모리 주소가 복사된다. 그래서 복사본을 변경할 경우 원본도 같이 훼손된다. (얕은 복사)
//원시값은  값에 의한 전달이기 때문에 복사 할 시에 새 메모리에 값을 할당하게 된다. 그래서 복사본을 변경하여도 원본은 변경되지 않는다. (깊은 복사)
		System.out.println();
		System.out.println("배열의 대표명 c : " + myData.c); 
		// c[]배열의 대표명 c만 부르면 배열 c[]의 주소를 불러온다.
		int kbs[] = (myData.c); // myData.C 배열의 주소를 kbs[] 배열에 준다.
		System.out.println(myData.c[0]);
		System.out.println(kbs[0]);
		myMethod.ex(myData.c); 
		// myData.C 배열의 주소를 Ex9Callby2 클래스 파일로 전달해야하는데 
		// 개수 1개의 배열 인수를 가진 ex 함수는 public void ex(int[] ar) {} 함수밖에 없으므로 여기에
		// 배열 주소가 인수로 전달되고 블럭에서 배열 0번째값과 배열 1번째 값을 바꿔준다.
		System.out.println("3. 배열 수행 후 c[0]: " + myData.c[0] + ", c[10]: "+ myData.c[1]);
	}

}
