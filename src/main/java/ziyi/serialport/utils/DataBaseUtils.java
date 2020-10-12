package ziyi.serialport.utils;

import java.sql.*;

public class DataBaseUtils {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/sptdatabase"; //数据库名
    static final String USER = "root";        // 数据库的用户名与密码，需要根据自己的设置
    static final String PASS = "123";

    public static boolean saveToDB(String str) {
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(JDBC_DRIVER);// 1.注册 JDBC 驱动
            conn = DriverManager.getConnection(DB_URL, USER, PASS); // 2.获取链接
            statement = conn.createStatement();   // 3.获取数据库操作对象
            String sql = "insert into test (name) values(?)";//4.编辑sql语句
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,str);
            pst.executeUpdate();//5.执行sql语句
            pst.close();// 完成后关闭
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();  // 处理 JDBC 错误
        } catch (Exception e) {
            e.printStackTrace(); // 处理 Class.forName 错误
        } finally {
            try { // 关闭资源
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException se2) {
                return false;
            }
        }
        return true;
    }




    public static void main(String[] args) throws InterruptedException {
        DataBaseUtils.saveToDB("cww");
        Thread.sleep(1000);
        DataBaseUtils.saveToDB("cw232w");
        Thread.sleep(1000);
        DataBaseUtils.saveToDB("cw4w");
        Thread.sleep(1000);
        DataBaseUtils.saveToDB("cw32w");
        Thread.sleep(1000);
        DataBaseUtils.saveToDB("cw111w");
    }

}
