package DVO;

import java.awt.List;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import date.DBManager;

import VO.user;

public class persondaolmpl implements persiondao {

	public void delete(String id) throws Exception {
		
			System.out.println(id);
	       DBManager Db= new DBManager();
	       try{
	       String str2="delete from yonhu where id='"+id+"'";//�ڶ������ݱ����������ɾ��   
	       int rs=Db.executeUpdate(str2);
	       System.out.println("�ɹ�user����"+rs); 
	       
	       }catch(Exception e)
	        {
	            System.out.println(e.toString());    
	        }
	     
	    // TODO Auto-generated method stub
		
	}

	public void insert(user vo) throws Exception {
		
		// String sql="insert into member (id,usename,phone,adress,profession,sex)values(?,?,?,?)";
		 DBManager Db= new DBManager();
		    
	       String str1="SELECT * FROM yonhu ";
	       ResultSet rs1=Db.executeQuery(str1);
	       int Count1=1;
	       System.out.println(str1);
	   try{
	         while(rs1!=null&&rs1.next())
	       {
	           Count1++;
	       }
	         	System.out.println(Count1+"��");
	         //������� 
	               str1="insert into gerendate values('"+Count1+"','"+vo.getName()+"','"+vo.getPassword()+"','"+vo.getPower()+"')";
	               int up1=Db.executeUpdate(str1); 
	               System.out.println(str1);
	               
	        }catch(Exception e)
	        {
	        	System.out.println(e.toString());
	         }
		// TODO Auto-generated method stub
		
	}

	public List queryAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryByLike(String cmd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public user queryByid(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(user vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
