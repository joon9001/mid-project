package pack3;

public class Ex23Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("속도 : " + Ex23Flyer.FAST);
		//Ex23Flyer가 인터페이스라 객체 생성을 못하므로 static처럼 
		//클래스명.변수명(Ex23Flyer.FAST) 형태로 바로 불러올 수 있다.
	
		Ex23Bird bird = new Ex23Bird();
		bird.fly();
		
		Ex23Airplane airplane = new Ex23Airplane();
		airplane.fly();
		
		System.out.println("------------");
		Ex23FlyerUtil.show(bird);
		System.out.println();
		Ex23FlyerUtil.show(airplane);
		
		System.out.println("------------");
		Ex23Ball ball = new Ex23Ball();
		ball.fly();
		
	
	}

}
