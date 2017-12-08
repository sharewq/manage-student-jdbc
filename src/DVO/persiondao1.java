package DVO;

import java.awt.List;
import java.util.ArrayList;

import VO.geren;
import VO.user;

public interface persiondao1 {
	public void insert(geren vo)throws Exception;
	public void update(geren vo)throws Exception;
	public void delete(String id)throws Exception;
	public geren  queryByid(String id)throws Exception;
	public ArrayList queryAll()throws Exception;
	public List queryByLike(String cmd)throws Exception;
}
