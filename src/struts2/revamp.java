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
		 
	
    HttpServletRequest request=ServletActionContext.getRequest();  //获得HttpServletRequest对象
	//HttpServletResponse response =ServletActionContext.getResponse();  //获得HttpServletResponse对象
	HttpSession session=request.getSession();
	

	System.out.println("更新操作01"); 
		
	  String  id=ren.getId();
      String  user=ren.getName();
      String  phone=ren.getPhone();
      String  adress=ren.getAdress();
      String  pro=ren.getPorfession();
      String  sex=ren.getSex();
      // String  Sex=null;
      
      System.out.println("性别"+id);
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
    	 PersonDAOFactory1.getPersonDAOlnstance().update(G);//向geren数据库里面添加数据
    	// response.sendRedirect("xinxi");
    	 return "success";
        }catch(Exception e)
     {
   	  e.printStackTrace();
     }
	 
     
	 return "error";

}
	 
}
