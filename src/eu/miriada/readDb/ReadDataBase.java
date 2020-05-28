package eu.miriada.readDb;

import eu.miriada.Player;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ReadDataBase {
    private static String getAllBanedGuid = ("SELECT guid FROM players WHERE ban=true");

    public static Set<String> getAllBanedGuids(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getAllBanedGuid);
        Set<String> banedGuids = new HashSet<>();

        while (resultSet.next()){
            banedGuids.add(resultSet.getString("guid"));
        }
        return banedGuids;
    }



   public static Set<Player> getPlayersByName(Connection connection, String name) throws SQLException {
        String getPlayer = ("SELECT name, guid, ban, ip, suspect_ip FROM names JOIN players ON names.player_id=players.id JOIN ips " +
               "ON names.player_id=ips.player_id WHERE name LIKE " + "\"%"+ name+"%\"" +"");

        Statement statement = connection.createStatement();
        //PreparedStatement getPlayers = connection.prepareStatement(getPlayer);
        //getPlayers.setString(0, name );
       System.out.println(getPlayer);
        ResultSet resultSet = statement.executeQuery(getPlayer);

        Set<Player> playersList = new HashSet<>();
        while (resultSet.next()){
           Player player = new Player();
           player.setName(resultSet.getString("name"));
           player.setGuid(resultSet.getString("guid"));
           player.setBan(resultSet.getString("ban"));
           player.setIp(resultSet.getString("ip"));
           playersList.add(player);
        }
   return playersList;
   }
}