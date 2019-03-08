import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Frivillig1 {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/torstehs?user=torstehs&password=Z601ltQ4";
        Connection con = DriverManager.getConnection(url);

        String sqlSetning1 = "select forfatter, tittel from boktittel where isbn = '";
        String sqlSetning2 = "select count(*) antall from eksemplar where isbn = '";

        Statement statement1 = con.createStatement();
        Statement statement2 = con.createStatement();

        ResultSet result1 = null;
        ResultSet result2 = null;



    }
}
