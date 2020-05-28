package eu.miriada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        for(int n =870; n<=871; n++) {
            String nr = String.valueOf(n);
            String zeros = "";
            for (int i = nr.length(); i < 8; i++) {
                zeros = zeros + "0";
            }
            String fileName = zeros + nr + ".log";
            System.out.println(fileName);
            ReadFile.readFile(fileName);
        }

    }


}
