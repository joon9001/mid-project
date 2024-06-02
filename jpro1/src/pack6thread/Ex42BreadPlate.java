package pack6thread;

public class Ex42BreadPlate {
	private int breadCount = 0; // 스레드 간 자원 공유 대상 
	
	public Ex42BreadPlate() {
		// TODO Auto-generated constructor stub
	}
	//현재 메소드를 스레드로 호출하면 해당 스레드의 처리가 진행되는 동안 락이 걸린다.
	public synchronized void makeBread() {
		if(breadCount >= 10) {
			
			
			//wait()가 예외처리를 강제한다.
			try {
				System.out.println("빵 생산을 목표 초과");
				wait(); //thread를 not runnable 상태로 만듬
			} catch (Exception e) {
				
			}
			
		}
		
		breadCount++; // 빵을 만듬
		System.out.println("빵 생산 총 수 : " + breadCount + "개");
		notify(); // thread를 runnable 상태로 되돌림
//synchronized로 인해 스레드를 공유하므로 eatBread()도 다시 runnable 상태가 되고 
//makeBread()의 작업이 끝날때까지 기다렸다가 
//makeBread()가 wait()가 되면 바로 eatBread()가 실행된다.
		
	}
	public synchronized void eatBread() {
		if(breadCount < 1) {
			
		
		try {
			System.out.println("빵이 없어 기다림");
			wait(); //thread를 not runnable 상태로 만듬
		} catch (Exception e) {
			
		}
		}
		breadCount--; // 빵을 소비
		System.out.println("빵 소비 후 총 수 : " + breadCount + "개");
		notify(); // thread를 runnable 상태로 되돌림
		//synchronized로 인해 스레드를 공유하므로 makeBread()도 다시 runnable 상태가 되고 
		//eatBread()의 작업이 끝날때까지 기다렸다가 
		//eatBread()가 wait()가 되면 바로 makeBread()가 실행된다.
	}
}
