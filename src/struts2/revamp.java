package struts2;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DVOFactory.PersonDAOFactory1;
import VO.geren;

public class revamp {
	
	
	private geren ren;
	public void setRen(geren ren){
		this.ren=ren;
	}
	public geren getRen(){
		return this.ren;
	}
	 public String execute()
	 {
		 
	
    HttpServletRequest request=ServletActionContext.getRequest();  //���HttpServletRequest����
	//HttpServletResponse response =ServletActionContext.getResponse();  //���HttpServletResponse����
	HttpSession session=request.getSession();
	

	System.out.println("���²���01"); 
		
	  String  id=ren.getId();
      String  user=ren.getName();
      String  phone=ren.getPhone();
      String  adress=ren.getAdress();
      String  pro=ren.getPorfession();
      String  sex=ren.getSex();
      // String  Sex=null;
      
      System.out.println("�Ա�"+id);
      System.out.println("yonghu"+user);
      System.out.println("dinahua"+phone);
     
      
      geren G=new geren();
      
      G.setId(id);
      G.setNmae(user);
      G.setPhone(phone);
      G.setAdress(adress);
      G.setProfession(pro);
      G.setSex(sex);
      
      
     try{
    	 PersonDAOFactory1.getPersonDAOlnstance().update(G);//��geren���ݿ������������
    	// response.sendRedirect("xinxi");
    	 return "success";
        }catch(Exception e)
     {
   	  e.printStackTrace();
     }
	 
     
	 return "error";

}
	 
}
