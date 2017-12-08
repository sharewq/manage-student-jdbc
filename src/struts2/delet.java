package struts2;

import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DVOFactory.PersonDAOFactory;
import DVOFactory.PersonDAOFactory1;
import date.DBManager;


public class delet {
    public String execute() {

        HttpServletRequest request = ServletActionContext.getRequest();  //获得HttpServletRequest对象
        HttpServletResponse response = ServletActionContext.getResponse();  //获得HttpServletResponse对象
        HttpSession session = request.getSession();
        String id = session.getAttribute("Id").toString();
        System.out.println("id2=" + id);
        //修改数据


        System.out.println(id);
        //id=new String(id.getBytes("ISO-8859-1"),"utf-8");	//改字体编码 很主要
        DBManager Db = new DBManager();

        String str1 = "delete from gerendate where id='" + id + "'";
        String str2 = null;
        String id2 = null;
        String sql = "select * from gerendate where id='" + id + "'";
        String name = null;
        try {
            ResultSet rs = Db.executeQuery(sql);
            while (rs != null && rs.next()) {
                name = rs.getString(2);
            }
            str2 = "select * from yonhu where usename='" + name + "'";
            ResultSet rs1 = Db.executeQuery(str2);
            while (rs1 != null && rs1.next()) {
                id2 = rs1.getString(1);
            }
            System.out.println("user shujukuid2= " + id2);

            PersonDAOFactory1.getPersonDAOlnstance().delete(id);
            PersonDAOFactory.getPersonDAOlnstance().delete(id2);
            return "success";
            // response.sendRedirect("xinxi");
        } catch (Exception e) {

            e.printStackTrace();
        }


        return "error";
    }

}
