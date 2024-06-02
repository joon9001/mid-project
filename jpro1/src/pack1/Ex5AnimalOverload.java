package pack1;

// method overload : 한 개의 클래스에 이름이 같은 메소드를 여러 개 선언
// 성립 조건 : 매개변수의 개수, 타입, 순서가 다르면 된다, 변환형과는 관계없다.
public class Ex5AnimalOverload {
	private int leg = 4;
	private int age;
	private String name;
	public final static int MOUTH = 1; // final 멤버필드는 대문자로 적자
	
	public Ex5AnimalOverload() {
	// 생성자는 내용이 없는 경우 생략 가능
		this(10); // 생성자가 다른 생성자를 호출 가능하나 맨 위에 항상 위치해야함.
    //this(10); 이 System.out.println("비어있는 생성자");보다 아래에 위치하면 에러
    //this의 매개변수 타입,개수, 순서를 보고 아래 Ex5AnimalOverload 함수 중 하나를 찾아감
		System.out.println("비어있는 생성자");
	}
	
	public Ex5AnimalOverload(int leg) {
	// 생성자 오버로딩으로 위의 생성자와 다르게 인수 int leg가 들어감으로써 중복에러가 나지 않는다.
	// 생성자 오버로딩으로 준 인수를 통해 바뀐 변수의 값은 1회용이다.
		this.leg = leg;
	}
	
	public Ex5AnimalOverload(String name) {
	// 타입이 다른 매개변수를 줌으로써 생성자 오버로딩 성립
		this.name = name;
	}
	
	public Ex5AnimalOverload(String name, int age, int leg) {
	// 타입과 개수가 다른 매개변수를 줌으로써 생성자 오버로딩 성립
		this.name = name;
		this.age = age;
		this.leg = leg;
	}
	
	public void display () { 
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	public void display (int age) { 
		//함수를 위와 똑같이 선언하면 중복으로 에러가 나지만 
		//매개 변수(parameter)의 개수가 다르므로 에러가 안뜬다.
		//이것을 오버로딩이라고 한다. 
		this.age=age;//지역변수 age를 멤버필드 age에 기억
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
		//위의 age는 지역변수 age로 인수를 통해 받아온 age이기 때문에 멤버필드인 this.age와는 다르다.
		//따라서 만약 this.age=age+10으로 하고 인수로 age 값에 5를 받아오면 지역변수 age는 5이지만
		//맨 위에 선언한 멤버필드 this.age는 15가 된다.
	}
	public void display (String name) {  
		// 위의 display()와 타입이 다르므로 오버로딩 성립
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	public void display (String name, int age) { 
		// 위의 display()와 개수가 다르므로 오버로딩 성립
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
	public void display (int age, String name) {  
		// 매개변수의 순서가 다르므로 오버로딩 성립
		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
	}
//	public void display (int leg) {  
		// 에러, 첫번째 display()와 타입, 매개변수, 순서 모두 똑같으므로 중복 에러가 발생한다.
//		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
//	}
//	public String display (int leg) {  
		// 에러, 오버로딩의 성립 조건은 반환형과는 관계없고 인수하고만 관계있다.
//		System.out.println("leg:" + leg + ", age:" + age + ", name:" + name);
//	}
}
