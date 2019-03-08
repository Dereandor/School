/*
 * Laantaker.java
 * Løsningsforslag, øving 5c)
 *
 * Programmet leser inn navn, ISBN og eksemplarnr fra brukeren og registrerer utlån på dette navnet.
 *
 */
import static javax.swing.JOptionPane.*;
import mittBibliotek.DataLeser;
import java.sql.*;
class Laantaker {
  public static void main(String[] args) throws Exception {
    String databasedriver = "org.apache.derby.jdbc.ClientDriver";
    Class.forName(databasedriver);  // laster inn driverklassen

    String databasenavn = "jdbc:derby://localhost:1527/ov5_vprg;user=vprg;password=vprg";
    Connection forbindelse = DriverManager.getConnection(databasenavn);

    Statement setning = forbindelse.createStatement();

    int svar;
    do {
      String isbn = DataLeser.lesTekst("Oppgi ISBN: ");
      String navn = DataLeser.lesTekst("Oppgi navn: ");
      int eksNr = DataLeser.lesHeltall("Oppgi eksemplarnr: ");

      String sql = "update eksemplar set laant_av = '" + navn + "' where isbn = '" + isbn + "' and eks_nr = " +
                          eksNr + " and laant_av is null";
      int ant = setning.executeUpdate(sql);
      if (ant > 0) {
        showMessageDialog(null, "Utlån registrert");
      } else {
        showMessageDialog(null, "Utlån ikke registrert pga feil i input");
      }
      svar = showConfirmDialog(null, "Skal flere utlån registreres? ", "Database", YES_NO_OPTION);
    } while (svar == YES_OPTION);

    setning.close();
    forbindelse.close();
  }
}
