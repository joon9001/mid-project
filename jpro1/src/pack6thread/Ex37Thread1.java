package pack6thread;
// Thread
// 하나의 응용 프로그램은 운영체제에 의해 process(작업단위)를 확보하고
// 응용 프로그램의 실행은 thread(실행단위)가 담당한다.
// 기본적으로 main thread에 의해 응용 프로그램은 실행된다.
// thread의 갯수 만큼 실행 단위를 늘리 수 있다.
// 즉, multi thread에 의한 multi tasking이 가능하다.
// 주로 네트워크 작업에서 많이 활용된다. 
// 자바에서 실행 파일 직접 실행
public class Ex37Thread1 extends Thread{ 
	//thread는 java.lang에 있지만 java.lang은 기본 패키지이므로 따로 import안해도 된다.
	public Ex37Thread1() {
		
	}
	
	public Ex37Thread1(String name) {
		super(name);
		
	}
	
	public void run() {
		for(int i=1; i <=50; i++) {
//			System.out.println(i + " ");
			System.out.println(i + " : " + super.getName() + " ");
			//생성자 인수 one, two를 name으로 전달받아 super를 이용하여
			//상위 클래스 thread에서 getName()으로 1번 스레드인지 2번 스레드인지 구분함
		}
	}

	public static void main(String[] args) { 
		// main 함수에서는 기본적으로 main thread가 항상 실행된다.

		
		try {
			//process 단위의 실행
			//Process p1 = Runtime.getRuntime().exec("calc.exe");
			
			//thread를 사용한 특정 메소드(run) 실행
			
			//위의 class Ex37Thread1 extends Thread에서 extends Thread를 뺐을 때 스레드가 실행되지 않는다.
			//아래 th1.run()과 th2.run()에서 Thread를 사용하지 않았다고 가정할 경우 함수는 순차적으로 실행된다.
//			
//			Ex37Thread1 th1 = new Ex37Thread1();
//			th1.run();
//			
//			Ex37Thread1 th2 = new Ex37Thread1();
//			th2.run();
			
			//사용자 정의 Thread를 사용한 경우 : 랜덤하게 실행
//			Ex37Thread1 th1 = new Ex37Thread1();
			Ex37Thread1 th1 = new Ex37Thread1("one");
			th1.start(); //start가 run()을 실행하고 스레드가 시작된다.
//			Ex37Thread1 th2 = new Ex37Thread1();
			Ex37Thread1 th2 = new Ex37Thread1("two");
			th2.start();
			
			// MAX_PRIORITY = 10 // 최대 우선 순위
			// MIN_PRIORITY = 1 // 최소 우선 순위
			th2.setPriority(MAX_PRIORITY); // 제일 빠른 처리 요청
			// 스레드 스케쥴러에게 우선 순위 요청
			// th2를 th1이나 main 스레드보다 우선 실행되도록 요청하는것이지만 
			// 반드시 먼저 실행되는건 아니다.
			
			th1.join();  //th1 스레드가 종료될 때까지 main스레드 종료를 대기
		//	th2.join();
			
			th1.yield(); //다른 스레드의 수행 요청이 들어오면 현재 스레드의 수행을 일시정지
			
			System.out.println();
			System.out.println("프로그램 종료");
			//메인 스레드에서 실행하므로 아래에 있어도 위의 숫자를 출력하는 
			//사용자 정의 스레드 th1, th2가 더 오래 걸리므로 먼저 출력된다.
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
	}

}
