package DVOFactory;

import DVO.persiondao1;
import DVO.persondaolmpl1;

public class PersonDAOFactory1 {
	public static persiondao1 getPersonDAOlnstance(){
		return new persondaolmpl1();
	}

}
