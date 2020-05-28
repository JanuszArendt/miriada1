package eu.miriada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String url="jdbc:mysql://localhost:3306/miriada?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=utf8";
    private static String userName="admin";
    private static String password="admin";
    private static Connection conn;
/*
    //connection to the nazwa.pl

    private static String url = "jdbc:mysql://my_database.com:3306/my_database_name?serverTimezone=UTC&" +
            "allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8";
    private static String userName = "admin";
    private static String password = "admin";
*/


    public static Connection getConnection(){
        if(conn==null) {
            try {
                conn = DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }else{
            return conn;
        }
    }
}
