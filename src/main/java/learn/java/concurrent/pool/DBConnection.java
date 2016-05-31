package learn.java.concurrent.pool;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接类
 * Created by Vigo on 16/5/31.
 */
public class DBConnection {

    private final static String DBDRIVER = "com.mysql.jdbc.Driver";
    private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/test";
    private final static String DBUSER = "root";
    private final static String DBPASSWORD = "";

    public static Connection createConnection()
    {
        Connection connect = null;
        try
        {
            Class.forName(DBDRIVER) ;
            connect = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD) ;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("数据库连接失败，请检查网络！");
        }
        return connect;
    }

    public static void main(String[] args) {
        DBConnection.createConnection();
    }
}
