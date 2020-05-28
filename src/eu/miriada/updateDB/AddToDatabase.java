package eu.miriada.updateDB;
import eu.miriada.Player;

import java.sql.*;

public class AddToDatabase {

    public static void addToDatabase(Player player, Connection conn) throws SQLException {

        String isPlayerExist = ("SELECT id FROM players WHERE guid='"+player.getGuid()+"'");
        String guidToDatabase =("INSERT INTO players (id, guid, ban) VALUES (null , ? , false )");
        String ipToDatabase = ("INSERT INTO ips (ip, player_id) VALUES ( ? , ? )");
        String nameToDatabase = ("INSERT INTO names (name, player_id) VALUES ( ? , ?)");
        String descriptionToDatabase = ("INSERT INTO descriptions (description, player_id) VALUES ( ? , ?)");

        String isIpExisting = ("SELECT ips.id FROM ips JOIN players ON players.id=ips.player_id WHERE ips.ip="+"'"+player.getIp()+"'");
        String isNameExisting = ("SELECT names.id FROM names WHERE names.player_id= ? AND names.name= ?");
        String isDescriptionExisting = ("SELECT descriptions.id FROM descriptions WHERE descriptions.player_id= ? AND descriptions.description= ?");

        Statement statm = conn.createStatement();
        PreparedStatement guidStat = conn.prepareStatement(guidToDatabase);
        PreparedStatement ipStat = conn.prepareStatement(ipToDatabase);
        PreparedStatement nameStat = conn.prepareStatement(nameToDatabase);
        PreparedStatement descriptionStat = conn.prepareStatement(descriptionToDatabase);
        PreparedStatement isName = conn.prepareStatement(isNameExisting);
        PreparedStatement isDescription = conn.prepareStatement(isDescriptionExisting);
        ResultSet resultSet = statm.executeQuery(isPlayerExist);
        String actualPlayerId="";

        if (!resultSet.next()){
            guidStat.setString(1, player.getGuid());
            guidStat.executeUpdate();

            resultSet = statm.executeQuery(isPlayerExist);

            while (resultSet.next()){
                actualPlayerId=""+resultSet.getLong("id");
            }
            ipStat.setString(1, player.getIp());
            ipStat.setString(2, actualPlayerId);
            ipStat.executeUpdate();
            nameStat.setString(1, player.getName());
            nameStat.setString(2, actualPlayerId);
            nameStat.executeUpdate();
            descriptionStat.setString(1,player.getDescription());
            descriptionStat.setString(2,actualPlayerId);
            descriptionStat.executeUpdate();

        }else{
            String existingPlayerId = String.valueOf(resultSet.getLong("id"));
            ResultSet isIpExist = statm.executeQuery(isIpExisting);
            if(!isIpExist.next()){
                ipStat.setString(1, player.getIp());
                ipStat.setString(2, existingPlayerId);
                ipStat.executeUpdate();
            }
            isName.setString(1, existingPlayerId);
            isName.setString(2, player.getName());
            ResultSet resultSetName = isName.executeQuery();
            if (!resultSetName.next()){
                nameStat.setString(1, player.getName());
                nameStat.setString(2, existingPlayerId);
                nameStat.executeUpdate();
            }
            isDescription.setString(1, existingPlayerId);
            isDescription.setString(2, player.getDescription());
            ResultSet isDescriptionExist = isDescription.executeQuery();
            if (!isDescriptionExist.next()){
                descriptionStat.setString(1,player.getDescription());
                descriptionStat.setString(2,existingPlayerId);
                descriptionStat.executeUpdate();
            }
        }
    }
}

