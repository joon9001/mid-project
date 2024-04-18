// https://cafe.daum.net/flowlife/HqLo/22 몸풀기 문제

package pack4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Data

public class Ex31StudentDTO {
		
	
	    private String name;
	    private int koreanScore;
	    private int englishScore;

	    public Ex31StudentDTO(String name, int koreanScore, int englishScore) {
	        this.name = name;
	        this.koreanScore = koreanScore;
	        this.englishScore = englishScore;
	    }
	  
	    
//	    public String getName() {
//	        return name;
//	    }
//
//	    public int getKoreanScore() {
//	        return koreanScore;
//	    }
//
//	    public int getEnglishScore() {
//	        return englishScore;
//	    }
//
	    public int getTotalScore() {
	        return koreanScore + englishScore;
	    }
	}

	

