package struts2;


import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import date.DBManager;
import VO.geren;


public class update {

    public String execute() {
        //修改数据

        HttpServletRequest request = ServletActionContext.getRequest();  //获得HttpServletRequest对象
        HttpServletResponse response = ServletActionContext.getResponse();  //获得HttpServletResponse对象
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        System.out.println("id=" + id);


        DBManager Db = new DBManager();
        String sql = "select * from gerendate where id='" + id + "' ";

        System.out.println(sql);
        System.out.println("xiu gai ");
        try {
            ResultSet rs = Db.executeQuery(sql);
            geren G = new geren();


            ArrayList listcow = new ArrayList();
            while (rs != null && rs.next()) {
                G.setId(rs.getString(1));
                G.setNmae(rs.getString(2));
                G.setPhone(rs.getString(3));
                G.setAdress(rs.getString(4));
                G.setProfession(rs.getString(5));
                G.setSex(rs.getString(6));

                listcow.add(rs.getString(1));
                listcow.add(rs.getString(2));
                listcow.add(rs.getString(3));
                listcow.add(rs.getString(4));
                listcow.add(rs.getString(5));
                listcow.add(rs.getString(6));
            }
            request.setAttribute("Lis", listcow);
            session.setAttribute("G", G);
            return "success";
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        return "power";

    }
}
