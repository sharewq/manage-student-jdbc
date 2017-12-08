package date;

import java.sql.*;

//数据库操作类
public class DBManager {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String DBDriver = "com.mysql.jdbc.Driver";
    String ConnStr = "jdbc:mysql://localhost:3306/guanli";
    String MyUser = "root";   //用户名
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
     *功能:执行查询操作
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
     *功能:执行更新操作
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
     *功能:关闭数据库链接
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