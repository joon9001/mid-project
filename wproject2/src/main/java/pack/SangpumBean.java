package pack;
//dto랑 똑같으나, 역할이 다르다. 그러기에 폼빈으로 또 만들어주는것이 좋다.
public class SangpumBean { // 폼빈역할 
	private String code, sang, su, dan;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSang() {
		return sang;
	}

	public void setSang(String sang) {
		this.sang = sang;
	}

	public String getSu() {
		return su;
	}

	public void setSu(String su) {
		this.su = su;
	}

	public String getDan() {
		return dan;
	}

	public void setDan(String dan) {
		this.dan = dan;
	}
	
}
