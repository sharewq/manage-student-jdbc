package DVO;

import java.awt.List;
import VO.user;

public interface persiondao {
	public void insert(user vo)throws Exception;
	public void update(user vo)throws Exception;
	public void delete(String id)throws Exception;
	public user queryByid(String id)throws Exception;
	public List queryAll()throws Exception;
	public List queryByLike(String cmd)throws Exception;
}
