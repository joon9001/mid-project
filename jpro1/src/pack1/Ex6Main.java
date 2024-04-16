package pack1;

public class Ex6Main {

	public static void main(String[] args) {
		//같은 패키지에 있는 Ex6Bank 클래스를 사용
		Ex6Bank kildong = new Ex6Bank();
		kildong.dePosit(5000);
		kildong.withDraw(2000);
		System.out.println("kildong 예금액 : " + kildong.getMoney());
		//kildong.Money; // 에러, private money를 다른 클래스에서 바로 사용할 수 없다.
		System.err.println("a:" + kildong.a);//a가 default라 타클래스에서 불러올 수 있다.
		System.err.println("b:"+ kildong.b);//b가 public이라 타클래스에서 불러올 수 있다.
		
		System.out.println();
		Ex6Bank dajeong = new Ex6Bank(2000);
		dajeong.dePosit(5000);
		dajeong.withDraw(2000);
		System.out.println("dajeong 예금액 : " + dajeong.getMoney());
		
		System.out.println("객체 주소 관련 ---------");
		System.out.println("kildong 주소 : " + kildong + " " + kildong.hashCode());
		System.out.println("dajeong 주소 : " + dajeong);
		
		Ex6Bank tom = null; // Ex6Bank tom; 과 같다.
		//출력결과
//		객체 주소 관련 ---------
//		kildong 주소 : pack1.Ex6Bank@e6ea0c6 242131142 
//		dajeong 주소 : pack1.Ex6Bank@6d86b085
//		객체 주소를 나타내는 16진수 e6ea0c6를 hashCode를 써서 10진수 232131142로 변환하여 추가하였다.
		System.out.println("tom 주소 : " + tom);
		// 출력결과: tom 주소 : null
		// tom instance를 생성하지 않았으므로 주소를 찾을 수 없다. 
		// System.out.println("tom 예금액 : " + tom.getMoney()); 
		// 위의 코드를 실행하면 NullpointerException 에러가 난다
		// 왜냐하면 tom instance를 생성하지 않았으므로 주소를 찾을 수 없기 때문이다. 
		tom = dajeong; // 주소 치환 (dajeong의 주소를 tom의 주소에 대입한다)
		System.out.println("tom 예금액 : " + tom.getMoney()); 
		// dajeong의 주소를 tom과 공유하고 있기 때문에 dajeong의 예금액과 tom의 예금액은 같다.
		
		if(dajeong == tom) {
			System.out.println("둘은 같은 주소");
		}else {
			System.out.println("둘은 다른 주소");
		}
		if(dajeong == kildong) {
			System.out.println("둘은 같은 주소임을 알림");
		}else {
			System.out.println("둘은 다른 주소야~~~");
		}
		
		if(dajeong instanceof Ex6Bank) {
			//instance of: 객체 타입 비교 연산자
			System.out.println("Ex6Bank 타입이 맞아요");
		}else {
			System.out.println("ㅠㅠ Ex6Bank 타입이 아니군요");
		}
		System.out.println("\n스트링(String) 타입의 값 비교 ---");
		String ss1 = "kor";
		String ss2 = new String();
		ss2 = "kor";
		String ss3 = new String("kor");
		
		System.out.println(ss1 + " " + ss2 + " " + ss3);
		
		if(ss1 == ss2) // 주소를 비교함
			System.out.println("같음1");
		else
			System.out.println("다름1");
		if(ss1 == ss3)
			System.out.println("같음2");
		else
			System.out.println("다름2");
	
	// String은 주소 비교가 아니라 값을 비교하는 것이 
	// 목적이므로 equals()를 사용해야 한다. 위에처럼 사용하면 안됨
	if(ss1.equals(ss2)) //값을 비교함 (영문 대소문자 구분을 함)
		System.out.println("같음3");
	else
		System.out.println("다름3");
		
		if(ss1.equals(ss3)) //값을 비교함 (영문 대소문자 구분을 함)
			System.out.println("같음4");
		else
			System.out.println("다름4");
		
		if(ss1.equalsIgnoreCase(ss3)) 
			//값을 비교하나 (영문 대소문자 구분을 안함)
			System.out.println("같음4");
		else
			System.out.println("다름4");

}
}