// https://cafe.daum.net/flowlife/HrhB/79
// https://cafe.daum.net/flowlife/HqLo/62

package domain;

import org.hibernate.property.access.spi.Getter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//sangdata 테이블과 연결


@Entity // JPA를 사용해 테이블과 매핑할 클래스에 붙여주는 어노테이션
@Table(name="sangdata")
public class SangpumTable {
	@Id // pk 칼럼임을 의미
	@Column(name = "code") 
	private int code;
	@Column(name="sang", nullable = false)
	private String sang;
	private int su;
	private int dan;
	
	public SangpumTable() {
		// JPA에서는 빈 생성자라도 생성자를 반드시 적어줘야 함
	}
	public SangpumTable(int code, String sang, int su, int dan) {
		this.code = code;
		this.sang = sang;
		this.su = su;
		this.dan = dan;
		// 생성자 오버로딩
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getSang() {
		return sang;
	}
	public void setSang(String sang) {
		this.sang = sang;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	
}
