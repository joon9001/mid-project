package pack4;

public class Ex30StudentDto {
	//레코드 단위 기억장소
	//DTO: 아래처럼 type이 다른 여러 개의 기억장소를 하나의 묶음으로 만들어 collection에 자료 전송
	private String hakbun, irum;
	private int jumsu;
	
	public Ex30StudentDto() {
		
	}
	
	public Ex30StudentDto(String hakbun, String irum, int jumsu) {
		//생성자의 인수로 멤버필드에 값을 줄 경우 아래처럼 setter 함수 안써도 된다.
		this.hakbun = hakbun;
		this.irum = irum;
		this.jumsu = jumsu;
	}

	//아래는 hakbun, irum, jumsu의 getter/setter 함수들이다.
	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public int getJumsu() {
		return jumsu;
	}

	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}
	
}
