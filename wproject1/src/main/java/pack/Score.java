package pack;

//한 개 상품이 이름과 가격으로 구성됨. 이를 하나의 객체로 만들기 위한 DTO(VO) 클래스
public class Score {
	private int number;
	private String name;
	private int kor;
	private int eng;
	
	public Score(int number, String name, int kor, int eng) {
		this.number = number;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	
	public int getEng() {
		return eng;
	}

}
