package pack3;

public class Ex18FindUtil {
	public static void find(Ex18Animal ani) {//Ex18Animal타입의 객체 변수를 받는다. cow를 넘겨받을 경우 
		//Ex18Animal타입의 cow 객체 주소를 갖고있는 cow를 받게 되는것임 
		//static을 썻기 때문에 다른 클래스에서 new Ex18FindUtil() 객체생성을 하지 않고 
		// Ex18FindUtil.find로 바로 불러올 수 있다.
	  ani.animalPrint();
	  //instanceof : 객체 타입 비교 연산자:true/false 반환
	  if(ani instanceof Ex18Cow ) {//ani의 객체 타입이 Ex18Cow라면 아래 블럭 실행
		  Ex18Animal a = ani;
		  System.out.println(a.name());
		  System.out.println(a.eat());
	  }else if(ani instanceof Ex18Lion) {
		  System.out.println(ani.name());
	  }
		  
		  
	}
}
