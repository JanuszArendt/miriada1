package eu.miriada;

import eu.miriada.updateDB.AddToDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {

    public static String readFile(String fileName) {
        Player player1 = new Player();
        File file = new File("../../aapg/logs/"+fileName);
       // Set<eu.miriada.Player> players = new HashSet<>();
        String kickFile="";
        Pattern ip = Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
        Pattern guid = Pattern.compile(" \\d{32}");
        Pattern name = Pattern.compile(" \\S{1,32}$");
        Pattern kick = Pattern.compile("Kick");
        String a = "", b = "", c = "";

        try {
            Scanner scan = new Scanner(file);

            Pattern test = Pattern.compile("^(\\S{11}\\s\\S{8}\\S\\s)(\\S{1,22})"); //  pierwszy wyzaz po dacie i godzinie od 1 do 22 znaków do spacji
            while (scan.hasNext()) {
                String line = scan.nextLine();
                Matcher matcher = test.matcher(line);

                while (matcher.find()) {
                    List<String> skip = new ArrayList<>();
                    skip.add("New");
                    skip.add("Running");


                    List<String> read = new ArrayList<>();
                    read.add("Player");
                    //read.add("Lost");
                    read.add("Kick");


                    if (!skip.contains(matcher.group(2)) && !read.contains(matcher.group(2))) {
                      /* try {
                            FileWriter fw = new FileWriter("pominiete.txt", true);
                            fw.append(line + "\n");
                            fw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/
                    } else if (read.contains(matcher.group(2))) {

                        //try {
                            Matcher getName = name.matcher(line);
                            Matcher getIp = ip.matcher(line);
                            Matcher getGuid = guid.matcher(line);
                            Matcher getKick = kick.matcher(line);

                            while (getName.find()) {
                                a = getName.group();

                            }
                            player1.setName(a);
                            while (getIp.find()) {
                                b = getIp.group();
                            }
                            player1.setIp(b);
                            while (getGuid.find()) {
                                c = getGuid.group();
                            }
                            player1.setGuid(c);

                            player1.setDescription("");

                            while (getKick.find()) {

                                player1.setDescription(line);

                                System.out.println("kick found " + player1.getName() + "--" + player1.getDescription());
                            }


                            AddToDatabase.addToDatabase(player1, ConnectionManager.getConnection());

/*
                            FileWriter out = new FileWriter("kick.txt", true);
                            out.append(kickFile + "\n");
                            out.close();
                        } catch (IOException ex) {
                            System.out.println("nie można zapisać danych do pliku");
                        }
           */         }
                }
            }

        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("brak pliku do odczytu !!");
        }

        // eng loop
return null;
    }
}
//todo guid number is to long