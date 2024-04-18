package pack6thread;
//runnable 인터페이스를 구현하여 스레드 만들기
public class Ex38Thread2 implements Runnable{ 
	//runnable 인터페이스는 메소드가 run() 1개밖에 없다.
	
public Ex38Thread2() {
	
}
public Ex38Thread2(String name) {
		Thread tt = new Thread(this, name);
		tt.start();
}
public void run() {
	for(int i=1; i <=50; i++) {
//		System.out.println(i);
		System.out.println(i + ":" + Thread.currentThread().getName());
		
		try {
			Thread.sleep(100); 
			//thread를 일정 시간 동안 비활성화
			//천천히 실행됨
		} catch (Exception e) {
			
		}
		
	}
}

	public static void main(String[] args) {
//		Ex38Thread2 my1 = new Ex38Thread2();
//		Ex38Thread2 my2 = new Ex38Thread2();
//		Thread t1 = new Thread();
//		t1.start();
//		Thread t2  = new Thread();
//		t2.start();
		
		new Ex38Thread2("하나");
		new Ex38Thread2("둘");
		//객체 생성을 하면 실행되는 생성자 안에  
		//스레드를 실행시키는 start()가 있다.
		
		System.out.println("프로그램 종료");
		
}
	
	
}