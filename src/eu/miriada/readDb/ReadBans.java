package eu.miriada.readDb;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ReadBans {

    //private static String readDate = ("select * from descriptions where description like \"%(aimbot)%\"");
    private static String readDate = ("select * from players where ban=true");


    public static Set<String> readAllBans(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(readDate);
        Set<String> data = new HashSet<>();

        while (resultSet.next()){
            data.add(resultSet.getString("id"));
            System.out.println("id");
        }
        return data;
    }
}
