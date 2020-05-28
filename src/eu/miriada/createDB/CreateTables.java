package eu.miriada.createDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

    public static void createTables(Connection conn) throws SQLException {

        final String PALYERS = "CREATE TABLE players(id BIGINT NOT NULL AUTO_INCREMENT,\n" +
                "\tguid VARCHAR(33) NOT NULL, \n" +
                "\tban BOOLEAN DEFAULT false, \n" +
                "\tPRIMARY KEY (id)\n" +
                "\t);";
        final String IP = "CREATE TABLE ips(\n" +
                "\tid BIGINT NOT NULL AUTO_INCREMENT, \n" +
                "\tplayer_id BIGINT NOT NULL, \n" +
                "\tip VARCHAR(16), \n" +
                "\tsuspect_ip BOOLEAN DEFAULT false, \n" +
                "\tPRIMARY KEY (id), \n" +
                "\tFOREIGN KEY(player_id) REFERENCES players(id)\n" +
                "\tON DELETE CASCADE\n" +
                "\t);";
        final String NAMES = "CREATE TABLE names(\n" +
                "\tid BIGINT NOT NULL AUTO_INCREMENT,\n" +
                "\tplayer_id BIGINT NOT NULL,\n" +
                "\tname VARCHAR(50) NOT NULL,\n" +
                "\tPRIMARY KEY(id),\n" +
                "\tFOREIGN KEY(player_id) REFERENCES players(id)\n" +
                "\tON DELETE CASCADE\n" +
                "\t);";
        final String DESCRIPTINS = "CREATE TABLE descriptions(\n" +
                "\tid BIGINT AUTO_INCREMENT,\n" +
                "\tplayer_id BIGINT NOT NULL,\n" +
                "\tdescription VARCHAR(255),\n" +
                "\tPRIMARY KEY(id),\n" +
                "\tFOREIGN KEY(player_id) REFERENCES players(id)\n" +
                "\tON DELETE CASCADE\n" +
                "\t);";

        Statement statement = conn.createStatement();
            statement.executeUpdate(PALYERS);
            statement.executeUpdate(IP);
            statement.executeUpdate(NAMES);
            statement.executeUpdate(DESCRIPTINS);
        }
    }