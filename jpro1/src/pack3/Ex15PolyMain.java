package pack3;

public class Ex15PolyMain {

	public static void main(String[] args) {
		Ex15PolyCar car1 = new Ex15PolyCar();
		Ex15PolyBus bus1 = new Ex15PolyBus();
		Ex15PolyTaxi taxi1 = new Ex15PolyTaxi();
		
		System.out.println();
		car1.displaySpeed();
		System.out.println(car1.getSpeed());
		
		System.out.println();
		bus1.displaySpeed();
		System.out.println(bus1.getSpeed());
		bus1.show();
		
		System.out.println();
		taxi1.displaySpeed();
		System.out.println(taxi1.getSpeed());
		
		System.out.println("\n--객체 주소 치환--");
		Ex15PolyCar car2 = new Ex15PolyBus(); //promotion(자동형변환) 발생, 자바에서는 자식 객체 인스턴스(주소)를 생성하여 부모 객체 변수에 저장 가능
		car2.displaySpeed(); //자식 객체 생성하여 부모 객체 변수에 저장하여 쓸 경우 오버라이딩된 메소드는 호출이 가능하다.
		System.out.println(car2.getSpeed());
		//car2.show(); //에러, 오버라이딩 하지 않은 자식 고유의 메소드는 간섭(호출) 불가
		//자식 bus 객체의 주소를 갖고 부모 객체 변수에 저장된 car2는 자식 클래스의 고유메소드인 show()를 쓸 수 없다.
		//자식 객체 생성을 부모 객체 변수에 저장하여 쓸 경우 부모에 있는 메소드와 똑같이 오버라이딩된 메소드는 사용 가능하지만
		// 자식 고유의 메소드는 사용 불가능하다.
		System.out.println();
		Ex15PolyCar car3 = taxi1; 
		// promotion, 위의 8번 행에서 Ex15PolyTaxi 객체의 주소를 갖고 있는 taxi1을  
		// Ex15PolyCar타입의 car3변수에 저장한다.
		System.out.println("주소 확인 :" + car3 + " " + taxi1);
		//출력결과: 주소 확인 :pack3.Ex15PolyTaxi@1c6b6478 pack3.Ex15PolyTaxi@1c6b6478
		//car3와 taxi1의 주소는 똑같으나 type이 다르다. car3는 Ex15PolyCar, taxi1은 Ex15PolyTaxi타입
		car3.displaySpeed();
		System.out.println(car3.getSpeed());
		
		System.out.println("\n========");
//		//Ex15PolyBus bus2 == new Ex15polyCar(); // x 
		//주소도 타입도 모두 다르기 때문에 부모 객체를 생성하면서 주소를 자식 변수에게 할당불가
		Ex15PolyBus bus3 = (Ex15PolyBus) car2; // casting의 도움으로 실행가능 
//		//car2는 부모객체 타입이지만 자식 객체인 bus의 주소를 갖고 있으므로 캐스팅(형변환)에 의해 주소 치환 가능
		bus3.displaySpeed();
		
		System.out.println();
	//	Ex15PolyTaxi taxi2 = new Ex15Polycar(); 타입 미스매치
		Ex15PolyTaxi taxi2 = (Ex15PolyTaxi)car3; // 32번 행에서 Ex15PolyCar타입이지만 taxi1의 주소를 갖고 있으므로 강제형변환 성립가능
		taxi2.displaySpeed();
		
		//Ex15PolyTaxi taxi3 = (Ex15PolyTaxi)car1;
		//런타임 에러, 실행오류, javac에서는 괜찮으나 실행하면 casting 오류가 난다.
		//car1은 Ex15PolyCar()의 주소를 갖고 있으므로 에러
		
		System.out.println("^^^^^^^^^^^^^");
		Ex15PolyCar mycar; 
		// 객체 변수를 선언하였지만 객체 생성을 안하였기 때문에 메모리 주소는 null인 상태
		mycar = bus1;  // promotion(자동형변환) 발생, 자식 객체 주소를 갖는 변수를 부모 객체 변수에 넣을 때 발생함
		//bus1이라는 자식객체의 주소를 갖고 있는 변수를 부모객체인 Ex15PolyCar 타입의 변수 mycar에 저장
		
		mycar.displaySpeed();
		//bus1의 displaySpeed()실행
		mycar = taxi1;
		mycar.displaySpeed();
		//taxi1의 displaySpeed()실행
		System.out.println();
		Ex15PolyCar p[] = new Ex15PolyCar[3];
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		for (Ex15PolyCar poly:p) {
			poly.displaySpeed();
			
		}
		//배열 for반복문을 이용한 출력
	}

}

//출력결과
//나는 자동차 원형 클래스~~~
//나는 자동차 원형 클래스~~~
//
//속도 : 50
//50
//
//버스 승객 수는 10
//버스의 속도는 50
//50
//--객체 주소 치환--
//나는 자동차 원형 클래스~~~
//버스 승객 수는 10
//버스의 속도는 50
//50
//========
//버스 승객 수는 10
//버스의 속도는 50

