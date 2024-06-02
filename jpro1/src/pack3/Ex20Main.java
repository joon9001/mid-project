package pack3;

public class Ex20Main {

	public static void main(String[] args) {
		// Ex20Volume volume = new Ex20Volume(); 인터페이스는 new 객체 생성 불가
		Ex20Volume volume; //인터페이스도 변수는 선언 가능하므로 실행 가능
		Ex20Radio radio = new Ex20Radio();
		Ex20Tv tv = new Ex20Tv();
		Ex20HandPhone phone = new Ex20HandPhone();
		
		radio.volumeUp(5);
		radio.volumeDown(2);
		tv.volumeUp(10);
		tv.volumeDown(7);
		phone.volumeUp(7);
		phone.volumeDown(1);
		
		System.out.println("-----------");
		volume = radio;
		volume.volumeUp(1);
		volume = tv;
		volume.volumeUp(2);
		volume = phone;
		volume.volumeUp(3);
		
		System.out.println("-----------");
		Ex20Volume volArr[] = new Ex20Volume[3];
		volArr[0] = radio;
		volArr[1] = tv;
		volArr[2] = phone;
		
		for(int a = 0; a < volArr.length; a++) {
			volArr[a].volumeDown(1);
		}
		for(Ex20Volume mbc:volArr) {
			mbc.volumeDown(1);
		}
	}

}
