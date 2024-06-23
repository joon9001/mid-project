package pack;

public class Gugudan { //객체변수이름이 아닌 클래스명으로 부를수있다.
	private static Gugudan gugudan = new Gugudan();  //싱글톤패턴
	public static Gugudan getInstance() {
		return gugudan;
	}
	
	//구구단계산 비즈니스로직 구현 클래스
	public Gugudan() {
	// TODO Auto-generated constructor stub
	}
	
	public int[] computeGugu(int dan){
		int gu[]= new int[9];
		for(int i=1; i<10; i++) {
			gu[i-1] = dan*i;
		}
		return gu;
	}
}
