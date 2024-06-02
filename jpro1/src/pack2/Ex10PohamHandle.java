package pack2;

public class Ex10PohamHandle {//부품 클래스
	int quantity;  // 자동차의 회전량
	
	public Ex10PohamHandle() {
		quantity = 0;
	}
	String leftTurn(int q) { //quantity 값이 음수
		quantity = q;
		return "좌회전";
	}
	String rightTurn(int quantity) {
		this.quantity = quantity; //quantity 값이 양수
		return "우회전";
	}
	String straight(int quantity) { //quantity 값이 0
		this.quantity = quantity;
		return "직진";
	}
}
