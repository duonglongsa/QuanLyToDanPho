package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Hai
 */
public class MysqlConnection {
    public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException {
        String hostName = "127.0.0.1";
        String dbName = "quan_ly_nhan_khau";
        String userName = "root";
        String password = "";
        return getMysqlConnection(hostName, dbName, userName, password);
    }

    public static Connection getMysqlConnection(String hostName, String dbName, String userName, String password)
            throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        //jdbc:mysql://" + hostName + ":3306/" + dbName + "?autoReconnect=true&useSSL=false
        //jdbc:mysql://" + hostName + ":3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8
        Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
        return conn;
    }
}
