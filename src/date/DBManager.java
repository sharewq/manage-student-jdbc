package date;

import java.sql.*;

//���ݿ������
public class DBManager {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String DBDriver = "com.mysql.jdbc.Driver";
    String ConnStr = "jdbc:mysql://localhost:3306/guanli";
    String MyUser = "root";   //�û���
    String MyPassword = "admin";

    public DBManager() {
        try {
            Class.forName(DBDriver);
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    /***************************************************
     *method name:	executeQuery()
     *����:ִ�в�ѯ����
     *return value: ResultSet
     *2005-12-05
     ****************************************************/
    public ResultSet executeQuery(String sql) {
        try {
            conn = DriverManager.getConnection(ConnStr, MyUser, MyPassword);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return rs;
    }

    /***************************************************
     *method name:	executeUpdate()
     *����:ִ�и��²���
     *return value: int
     *2005-12-05
     ****************************************************/

    public int executeUpdate(String sql) {
        int result = 0;
        try {
            conn = DriverManager.getConnection(ConnStr, MyUser, MyPassword);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            result = 0;
        }
        return result;
    }

    /***************************************************
     *method name:	close()
     *����:�ر����ݿ�����
     *return value: 	void
     *2005-12-05
     ****************************************************/
    public void close() {
        try {
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        try {
            if (stmt != null) stmt.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}