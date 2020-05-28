package eu.miriada;

import eu.miriada.readDb.ReadBans;
import eu.miriada.readDb.ReadDataBase;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws SQLException {

        String name = "oldmen";
        Set<Player> data = new HashSet<>();

       data = ReadDataBase.getPlayersByName(ConnectionManager.getConnection(),name);
        int i =1;
        for(Player player: data){

            System.out.println(i+"\t"+player.getName()+ "\t "+player.getGuid()+"\t "+player.getBan() + "\t "+player.getIp());
        i++;
        }




     //  eu.miriada.CreateDatabase.create();
      //eu.miriada.createDB.CreateTables.createTables();

       //eu.miriada.ReadFile.readFile();
/*
    eu.miriada.Player player = new eu.miriada.Player();
    player.setId("231");
    eu.miriada.Test.UpdateDB ban = new eu.miriada.Test.UpdateDB();
    ban.addBan(player,eu.miriada.ConnectionManager.getConnection());
        ban.removeBan(player, eu.miriada.ConnectionManager.getConnection());
      */
/*

       Set<String> allBans = new HashSet<>();
       allBans = ReadBans.readAllBans(ConnectionManager.getConnection());
        Player player = new Player();
        int n=0;
       for (String str : allBans){
           System.out.println(str + " - " + n);
           player.setId(str);
           Test.UpdateDB ban = new Test.UpdateDB();
           ban.addSuspectIp(player, ConnectionManager.getConnection());
           n++;
      }
*/

    }}




