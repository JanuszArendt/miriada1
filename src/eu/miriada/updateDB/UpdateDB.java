package eu.miriada.updateDB;
import eu.miriada.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDB {
    private String addBan = ("UPDATE players SET ban=true WHERE id= ?");
    private String remBan = ("UPDATE players SET ban=false WHERE id=?");
    private String addSuspect =("UPDATE ips SET suspect_ip=true WHERE player_id=?");

    public void addBan(Player player, Connection conn) throws SQLException {
        PreparedStatement ban = conn.prepareStatement(addBan);
        ban.setString(1, player.getId());
        ban.executeUpdate();
    }
    public void removeBan(Player player, Connection conn) throws SQLException {
        PreparedStatement removeBan = conn.prepareStatement(remBan);
        removeBan.setString(1, player.getId());
        removeBan.executeUpdate();
    }
    public void addSuspectIp(Player player, Connection conn) throws SQLException{
        PreparedStatement addSuspectIp = conn.prepareStatement(addSuspect);
        addSuspectIp.setString(1, player.getId());
        addSuspectIp.executeUpdate();
    }
}
