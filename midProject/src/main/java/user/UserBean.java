package user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserBean {
	private int no, gender, user_stat, signout_is;
	private String id, pw, uname, email, sign_up_date;
	
}
