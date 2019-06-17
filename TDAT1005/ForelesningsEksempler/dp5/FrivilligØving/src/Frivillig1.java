import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static javax.swing.JOptionPane.*;

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

        int svar;
        do{
            String isbn = showInputDialog("Oppgi ISBN: ");

            result1 = statement1.executeQuery(sqlSetning1 + isbn.trim() + "'");

            if(result1.next()) {
                result2 = statement2.executeQuery(sqlSetning2 + isbn.trim() + "'");
                result2.next();
                showMessageDialog(null, "Forfatter: " + result1.getString("forfatter") +
                        ", Tittel: " + result1.getString("tittel") +
                        ", Antall eksemplarer: " + result2.getInt("antall"));
            } else {
                showMessageDialog(null, "Oppgitt ISBN (" + isbn + ") ikke funnet.");
            }
            svar = showConfirmDialog(null, "Skal flere titler søkes opp?", "Database", YES_NO_OPTION);
        } while (svar == YES_OPTION);

        result1.close();
        result2.close();
        statement1.close();
        statement2.close();
        con.close();

    }
}
