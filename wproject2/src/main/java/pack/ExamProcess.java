package pack;
//연산을 목적으로 하는 클래스(Business logic용)
public class ExamProcess {
	private ExamBean bean;
	
	public void setBean(ExamBean bean) {
		this.bean = bean;
	}
	
	public int getTot() { //반드시 겟으로 적어줘야
		return bean.getKor() + bean.getEng()+ bean.getMat();
	}
	
	public double getAvg() {
		return getTot() / 3.0;
	}
}
