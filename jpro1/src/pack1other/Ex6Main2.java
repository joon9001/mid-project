package pack1other;
import pack1.Ex6Bank; //다른 패키지에 있는 클래스 읽기
// import pack1.*; //pack1의 모든 클래스를 읽어오는데 메모리 낭비가 심해서 비권장한다.

public class Ex6Main2 {

	public static void main(String[] args) {
//프로젝트는 같으나 다른 패키지에 있는 Ex6Bank 클래스를 사용하려면 pack1.Ex6Bank를 import해야함
		Ex6Bank kildong = new Ex6Bank();
		// System.err.println("a:" + kildong.a);
		//a가 default일 경우 패키지가 달라서 사용 불가하다, a = Pack1의 Ex6Bank 클래스 안의 변수
		System.err.println("b:"+ kildong.b);
		//b가 public이라 타패키지에서도 불러올 수 있다, b = Pack1의 Ex6Bank 클래스 안의 변수
}
}
