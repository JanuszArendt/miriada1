package eu.miriada.createDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    public static void create(Connection conn) throws SQLException {
        final String DATABASE = "CREATE DATABASE miriada;";

        Statement stat = conn.createStatement();
        stat.executeUpdate(DATABASE);
    }
}
