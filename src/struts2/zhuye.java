package struts2;


import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import VO.denlu;
import date.DBManager;

public class zhuye extends ActionSupport {

    private denlu dl;

    public void setDl(denlu ge) {
        this.dl = ge;
    }

    public denlu getDl() {
        return this.dl;
    }

    public String execute() {


        System.out.println("zhuye");
        String user = dl.getName();
        String pass = dl.getPassword();
        //  String power=dl.getPower();
        System.out.println(user + pass);

        //数据库的访问
        int a = 0;
        DBManager Db = new DBManager();
        String sql = "select * from yonhu where usename='" + user + "' and possword='" + pass + "' ";
        System.out.println(sql);
        try {
            ResultSet rs = Db.executeQuery(sql);
            if (rs != null && rs.next()) {
                System.out.println("dui le");
                a = 1;
                //this.getServletContext().getRequestDispatcher("/MyJsp.jsp").forward(request, response);//正确时页面跳转
                //response.sendRedirect("MyJsp.jsp");
            } else {
                //System.out.println("wu shu ju ");
                //response.sendRedirect("wu.jsp");
                a = 0;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println(a);
        if (a == 1)
            return SUCCESS;
        else
            return ERROR;
    }


}
