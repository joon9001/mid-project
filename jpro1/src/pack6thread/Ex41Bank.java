package pack6thread;

public class Ex41Bank {
	private int money = 10000; // 프로세스가 가진 자원(스레드 공유 자원)
//synchronized 없이 2개의 객체를 생성하여 run()를 실행할 경우 위의 공유자원은 공유되지 않는다.
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
// synchronized : 스레드의 동기화를 가능하게 함
// 공유 자원에 lock이 걸림, 하나의 스레드가 공유자원을 사용하는 동안 다른 스레드는 사용 대기
	public synchronized void saveMoney(int mon) { // 입금
		int m = this.getMoney();

		try {
			Thread.sleep(2000); // 은행에 입금 시 약간의 지연 시간을 설정
		} catch (Exception e) {
			// TODO: handle exception
		}
		setMoney(m + mon);
	}
	// synchronized : 스레드의 동기화를 가능하게 함
	// 공유 자원에 lock이 걸림, 하나의 스레드가 공유자원을 사용하는 동안 다른 스레드는 사용 대기
	public synchronized void minusMoney(int mon) { // 출금
		int m = this.getMoney();
		if (mon > m) {
			System.out.println("잔고액보다 출금액이 많아요");
			// System.exit(0);//응용 프로그램의 무조건 종료
			return; // 메소드 탈출
		}
		try {
			Thread.sleep(3000); // 은행에 출금 시 약간의 지연 시간을 설정
		//	synchronized 가 걸리면 savemoney의 sleep이 진행된 후 진행된다. 
		} catch (Exception e) {
			// TODO: handle exception
		}
		setMoney(m - mon);
	}
}
