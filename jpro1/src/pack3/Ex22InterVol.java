package pack3;

public interface Ex22InterVol extends Ex22VolEtc {
	//interface끼리 상속이 가능하다 
	//Ex22InterVol의 추상 메소드는 Ex22VolEtc인터페이스의 추상메소드까지 합쳐 총 4개가 된다.
	String vol = "볼륨";
	
	void volUp(int v);
	void volDown(int v);
	
}
