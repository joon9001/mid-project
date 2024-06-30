package pack.business;

import java.util.List;

public interface Processinter {
	List<DataDto> selectDataAll();
	DataDto selectPart(String para);
	boolean insertData(DataFormBean form);
	boolean updateData(DataFormBean form);
	boolean deleteData(String id);
}
