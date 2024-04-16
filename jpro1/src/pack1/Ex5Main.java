package pack1;

public class Ex5Main {

	public static void main(String[] args) {
		// 메소드 오버로딩 연습 
		Ex5AnimalOverload tiger = new Ex5AnimalOverload();
		tiger.display(5); // 인수(인자, argument)
		tiger.display("호랑이"); //
		tiger.display("호랭이", 2);
		tiger.display(3, "호돌이");
		
		System.out.println("\n생성자 오버로딩 ---");
		Ex5AnimalOverload dog = new Ex5AnimalOverload();
		//기본형 생성자 선택
		dog.display();//
		//멤버필드에 값이 display()함수의 변수로 입력되어 출력된다. 
//		출력결과
//		생성자 오버로딩 ---
//		leg:4, age:0, name:null
		Ex5AnimalOverload hen = new Ex5AnimalOverload(2);
		//int leg를 매개변수로 갖는 생성자 Ex5AnimalOverload에 인수 2를 준다.
		hen.display();
		Ex5AnimalOverload wolf = new Ex5AnimalOverload("늑대", 3, 5);
//		String name, int age, int leg를 매개변수로 갖는 생성자 Ex5AnimalOverload에
//		인수로 "늑대", 3, 5 를 준다.
		wolf.display();
	}

}
