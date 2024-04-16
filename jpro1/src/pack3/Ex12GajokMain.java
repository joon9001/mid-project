package pack3;

public class Ex12GajokMain {

	public static void main(String[] args) {
		// 상속 연습 : 우리 가족 소개
		Ex12GrandFa gr1 = new Ex12GrandFa();
		System.out.println("가보: " + gr1.gabo);
		System.out.println("가훈 : " + gr1.gahun);
		System.out.println(gr1.say());
		gr1.eat();
		System.out.println("할아버지 나이:" + gr1.getNai());
		
		System.out.println();
		//매개변수가 있는 생성자 호출
		Ex12GrandFa gr2 = new Ex12GrandFa(77);
		System.out.println("가훈 : " + gr2.gahun);
		System.out.println("할아버지 나이: " + gr2.getNai());
		
		System.out.println("\n아버지에 대해....");
		Ex12Father father = new Ex12Father();
		//father의 생성자에서 생략된 매개변수가 없는 부모 생성자를 호출하는 super()를 먼저 실행하므로 
		//할아버지 생성자가 먼저 출력되고 그 후 아버지 생성자가 출력된다.
		System.out.println("가보: " + father.gabo);
		System.out.println("가훈 : " + father.gahun);
		System.out.println(father.say());
		father.eat();
		System.out.println("아버지 나이:" + father.getNai());
		System.out.println(father.getHouse());
		father.showData();
		
		System.out.println("\n나에 대해 -----------");
		Ex12Me me = new Ex12Me(); 
		//Ex12Me()생성자에 생략된 super()가 실행되어 father 클래스의 Ex12Father()생성자로 가게 되고 여기에 생략된 super()가 실행되어 grandfa클래스의 Ex12GrandFa()생성자가 실행되어
		//할아버지 생성자, 아버지 생성자, 내 생성자 가 차례대로 찍히게 된다.
		
		
		System.out.println("가보: " + me.gabo);
		System.out.println("가훈 : " + me.gahun);
		System.out.println(me.say());
		me.eat();
		System.out.println("아버지 나이:" + me.getNai());
		System.out.println(me.getHouse());
		me.biking();
	}

}

//출력결과 
//할아버지 생성자
//가보: 상감청자
//가훈 : 자바 모르면 인간도 아니다
//할아버지 말씀 : 자기주도 학습
//밥은 맛있게 ...
//할아버지 나이:80
//
//할아버지 생성자
//가훈 : 자바 모르면 인간도 아니다
//할아버지 나이: 77
//
//아버지에 대해....
//할아버지 생성자
//아버지 생성자
//가보: 꽃병
//가훈 : 자바 모르면 인간도 아니다
//아버지 말씀 : 에러 잡는 연습을 하거라
//밥은 맛있게 ...
//아버지 나이:80
//집 : 1채
//아버지 나이 55
//아버지 나이 55
//아버지 나이 80
//아버지 나이 80
//할아버지 나이 80
//
//가보 물병
//가보 꽃병
//가보 상감청자
//
//나에 대해 -----------
//할아버지 생성자
//아버지 생성자
//내 생성자
//가보: 꽃병
//가훈 : 자바 모르면 인간도 아니다
//아버지 말씀 : 에러 잡는 연습을 하거라
//밥은 맛있게 ...
//아버지 나이:80
//집 : 1채
//자전거로 전국일주~~~
