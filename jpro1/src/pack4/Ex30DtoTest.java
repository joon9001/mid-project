package pack4;

import java.util.ArrayList;

public class Ex30DtoTest {
	
		
		// DTO: type이 다른 여러 개의 기억장소를 하나의 묶음으로 만들어 자료 전송
		//DTO는 타입이 다른 유형의 자료 묶음(레코드)를 list에 바로 저장할 수 없으니깐
		//클래스에 미리 저장해놓고 이 클래스의 객체변수를 만들어 서로 다른 타입의 값을 
		//list에 저장할 때 쓰이는 클래스 객체라고 보면 된다.
	// VO
		ArrayList<Ex30StudentDto> list = new ArrayList<Ex30StudentDto>();
		Ex30StudentDto dto; // DTO: 레코드 단위의 기억장소
		//DTO 유추하기
		public void aa() {
			String[] persons = new String[3];
			persons[0] = "홍길동";
			persons[1] = "고길동";
			persons[2] = "신길동";
			
			for(String s:persons) {
				System.out.println(s);
			}
			
		}
		
		public void insertList() { // 레코드 단위(DTO)로 학생 정보 입력해 list에 저장
			dto = new Ex30StudentDto();
			dto.setHakbun("ks1");
			dto.setIrum("손오공");
			dto.setJumsu(90);
			list.add(dto);//첫번째 dto 학생 자료 list에 등록
		
			dto = new Ex30StudentDto();
			dto.setHakbun("ks2");
			dto.setIrum("저팔계");
			dto.setJumsu(50);
			list.add(dto);//두번째 dto 학생 자료 list에 등록			
			
			dto = new Ex30StudentDto();
			dto.setHakbun("ks3");
			dto.setIrum("사오정");
			dto.setJumsu(80);
			list.add(dto);//두번째 dto 학생 자료 list에 등록		
		}
		public void showList() { // list 컬렉션에 저장된 학생 자료를 출력
			System.out.println("학생 수는 " + list.size());
			System.out.println(list.get(0));//dto 타입의 0번째 자료의 주소 출력
			System.out.println(list.get(0).getIrum());//getter함수로 dto 객체의 0번째 자료에 입력된 이름 출력
			
			System.out.println("------------");
			for (int i=0; i < list.size(); i++) {
//				Ex30StudentDto sdto = new Ex30StudentDto();
//				sdto = list.get(i);
//				위의 2줄의 코드를 아래처럼 바꿀 수 있다.				
				Ex30StudentDto sdto = list.get(i);
				//list에 자료를 입력할때 (list.add) Ex30StudentDto 타입으로 넣어줬기 때문에
				//자료를 가져올 때도 Ex30StudentDto 타입으로 가져와야 한다.
				System.out.println(sdto.getHakbun() + " " +
						sdto.getIrum() + " " +
						sdto.getJumsu()
				);
				System.out.println("------------");
				for(Ex30StudentDto d: list) {
			//list에 담긴 값을 순서대로 객체 변수 d에 넣어준다.
			//위의 전통적인 for문보다 훨씬 간단하지만 순서가 없는 set은 
			//이러한 enhanced for문을 쓸 수 없으므로 배열이나 list 형태에 자주 쓰인다.
					System.out.println(d.getHakbun() + " " +
						d.getIrum() + " " +
						d.getJumsu() );
				}
				
			}
			
		}
		
		public static void main(String[] args) {
			Ex30DtoTest dtoTest = new Ex30DtoTest();
			dtoTest.aa();
			System.out.println();
			dtoTest.insertList();
			dtoTest.showList();
			
	}
}
