package DVOFactory;

import DVO.persiondao;
import DVO.persondaolmpl;

public class PersonDAOFactory {
	public static persiondao getPersonDAOlnstance(){
		return new persondaolmpl();
	}

}
