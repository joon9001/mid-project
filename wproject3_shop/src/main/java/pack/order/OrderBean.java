package pack.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class OrderBean {
	private String no, product_no, quantity, sdate, state, id;
	
}
