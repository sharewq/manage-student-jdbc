package DVO;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import date.DBManager;
import VO.geren;

public class persondaolmpl1 implements persiondao1 {
	
	DBManager Db= new DBManager();
	public void delete(String id) throws Exception {
		
	      
	       String str1="delete from gerendate where id='"+id+"'";
	       System.out.println(str1);
	       
	       try{
	    	   int rs=Db.executeUpdate(str1);
	    	   System.out.println("成功：：："+rs); 

	       }catch(Exception e)
	        {
	            System.out.println(e.toString());    
	        }
	       
	    
		// TODO Auto-generated method stub
		
	}

	public void insert(geren vo) throws Exception {
		
	     String sql="insert into member (id,usename,phone,adress,profession,sex)values(?,?,?,?)"; 		    
	       String str1="SELECT * FROM gerendate ";
	       ResultSet rs1=Db.executeQuery(str1);
	       int Count1=1;
	       System.out.println(str1);
	   try{
	         while(rs1!=null&&rs1.next())
	       {
	           Count1++;
	       }
	         	System.out.println(Count1+"表");
	         //添加数据 
	               str1="insert into gerendate values('"+Count1+"','"+vo.getName()+"','"+vo.getPhone()+"','"+vo.getAdress()+"','"+vo.getPorfession()+"','"+vo.getSex()+"')";
	               int up1=Db.executeUpdate(str1); 
	               System.out.println(str1);
	               
	        }catch(Exception e)
	        {
	        	System.out.println(e.toString());
	         }
	          
	        
		// TODO Auto-generated method stub
		
	}

	public ArrayList queryAll() throws Exception {
		
			System.out.println("查询新型");
			String sql="select * from gerendate";
		    ArrayList jbs=new ArrayList();
		    ResultSet rs=Db.executeQuery(sql);
		    try {
				while(rs!=null&&rs.next()){
				System.out.print(rs.getString(1));
				 System.out.println(rs.getString(2));
				  System.out.println(rs.getString(3));
				   System.out.println(rs.getString(4));
				   
				   geren ge=new geren();
				   ge.setId(String.valueOf(rs.getInt(1)));
				   ge.setNmae(rs.getString(2));
				   ge.setPhone(rs.getString(3));
				   ge.setAdress(rs.getString(4));
				   ge.setProfession(rs.getString(5));
				   ge.setSex(rs.getString(6));
				   jbs.add(ge);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jbs;// TODO Auto-generated method stub

	}

	public List queryByLike(String cmd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public geren queryByid(String id) throws Exception {
		
		
		// TODO Auto-generated method stub
		return null;
	}

	public void update(geren vo) throws Exception {
		
		 DBManager Db= new DBManager();
	       String str1="select * from gerendate where id='"+vo.getId()+"'";
	       ResultSet rs=Db.executeQuery(str1);
	       System.out.println(str1+"这里是 update");
	         try{
	         if(rs!=null&&rs.next()){
	      	 	String str2="update gerendate set phone='"+vo.getPhone()+"', adress='"+vo.getAdress()+"' ,  profession='"+vo.getPorfession()+"' , sex='"+vo.getSex()+"'   , usename='"+vo.getName()+"' where id='"+vo.getId()+"'";  
	      		int rs1=Db.executeUpdate(str2);
	      		
	     	    System.out.println("查看更新记录："+str2); 
	     	    }
	        }catch(Exception e)
	        {
	            System.out.println(e);    
	        }      
	       }
		// TODO Auto-generated method stub
		
	}

