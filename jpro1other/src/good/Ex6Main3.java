package good;

import pack1.Ex6Bank;

public class Ex6Main3 {

	public static void main(String[] args) {
		// 프로젝트가 다른 곳에서 Ex6Bank를 사용하려면 어떻게 해야할까?
		// jpro1 - pack1 - Ex6Bank 클래스 객체를 사용하려면?
		//Ex6Bank를 jar로 만들어 export 사용하고자 하는 프로젝트에서 import 하면 된다
		Ex6Bank kildong = new Ex6Bank();
		kildong.dePosit(5000);
		kildong.withDraw(2000);
		System.out.println("kildong 예금액 : " + kildong.getMoney());
		//public도 다른 프로젝트의 클래스는 사용 못하는데 타 프로젝트의 클래스 파일을 
		// jar 파일로 export 후 사용하고자 하는 프로젝트에 import할 경우엔 위에처럼 사용이 가능하다. 
	}

}
