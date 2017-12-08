package struts2;

import DVOFactory.PersonDAOFactory;
import DVOFactory.PersonDAOFactory1;
import VO.geren;
import VO.quanbu;
import VO.user;

public class adddata {
    private quanbu qb;

    public void setQb(quanbu qu) {
        this.qb = qu;
    }

    public quanbu getQb() {
        return this.qb;
    }

    public String execute() {


        String user = qb.getName();
        String password = qb.getPassword();
        String power = qb.getPower();

        String phone = qb.getPhone();
        String adress = qb.getAdress();
        String pro = qb.getPorfession();
        String sex = qb.getSex();


        geren G = new geren();
        user U = new user();

        G.setNmae(user);
        G.setPhone(phone);
        G.setAdress(adress);
        G.setProfession(pro);
        G.setSex(sex);

        U.setName(user);
        U.setPassword(password);
        U.setPower(power);
        try {
            PersonDAOFactory1.getPersonDAOlnstance().insert(G);//��geren���ݿ������������
            PersonDAOFactory.getPersonDAOlnstance().insert(U);//��yonhu���ݿ������������
            //  response.sendRedirect("xinxi");
            return "seccess";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "power";
    }


}
