/*
 * TittelLeter.java
 * Løsningsforslag, Øving 5b)
 *
 * Programmet leser inn ISBN fra brukeren og leter opp informasjon om aktuelle titler.
 *
 */
import static javax.swing.JOptionPane.*;
import mittBibliotek.DataLeser;
import java.sql.*;
class TittelLeter {
  public static void main(String[] args) throws Exception {
    String databasedriver = "org.apache.derby.jdbc.ClientDriver";
    Class.forName(databasedriver);  // laster inn driverklassen

    String databasenavn = "jdbc:derby://localhost:1527/ov5_vprg;user=vprg;password=vprg";
    Connection forbindelse = DriverManager.getConnection(databasenavn);

    String sqlSetning1 = "select forfatter, tittel from boktittel where isbn = '";
    String sqlSetning2 = "select count(*) antall from eksemplar where isbn = '";
    Statement setning1 = forbindelse.createStatement();
    Statement setning2 = forbindelse.createStatement();
    ResultSet res1 = null;
    ResultSet res2 = null;

    int svar;
    do {
      String isbn = DataLeser.lesTekst("Oppgi ISBN: ");

      res1 = setning1.executeQuery(sqlSetning1 + isbn.trim() + "'");

      if (res1.next()) {
        res2 = setning2.executeQuery(sqlSetning2 + isbn.trim() + "'");
        res2.next();
        showMessageDialog(null, "Forfatter: " + res1.getString("forfatter") + ", Tittel: " + res1.getString("tittel") +
                                                                ", Antall eksemplarer: " + res2.getInt("antall"));
      } else {
        showMessageDialog(null, "Oppgitt ISBN (" + isbn + ") ikke funnet.");
      }
      svar = showConfirmDialog(null, "Skal flere titler søkes opp? ", "Database", YES_NO_OPTION);
    } while (svar == YES_OPTION);

    res1.close();
    res2.close();
    setning1.close();
    setning2.close();
    forbindelse.close();
  }
}
