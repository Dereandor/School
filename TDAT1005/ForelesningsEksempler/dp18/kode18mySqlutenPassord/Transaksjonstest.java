/**
 * Transaksjonstest.java - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Programmet utfører en databasetransaksjon som består av to SQL-setninger.
 */

import java.sql.*;
import mittBibliotek.Opprydder;
class Transaksjonstest {
  public static void main(String[] args) throws Exception {

    //String databasedriver = "org.apache.derby.jdbc.ClientDriver";
    String databasedriver = "com.mysql.jdbc.Driver";
    Class.forName(databasedriver);
    String databasenavn
              //= "jdbc:derby://localhost:1527/personer;user=vprg;password=vprg";
                = "jdbc:mysql://mysql.stud.iie.ntnu.no:3306/xxxxxxx?user=xxxxxxx&password=xxxxxxx";
    Connection forbindelse =  null;
    Statement setningSelect = null;
    Statement setningUpdate = null;
    ResultSet res = null;
    try {
      forbindelse =  DriverManager.getConnection(databasenavn);
      setningSelect = forbindelse.createStatement();
      setningUpdate = forbindelse.createStatement();

      forbindelse.setAutoCommit(false);   // transaksjon starter
      skrivUt(setningSelect, "Innhold i databasen før endring: ");

      /* Overfører 1000 kroner fra konto 123456 til konto 678909 */
      setningUpdate.executeUpdate(
        "update konto set saldo = saldo - 1000 where kontonr = '123456'");

      skrivUt(setningSelect, "\nInnhold i databasen mellom endringene: ");

      setningUpdate.executeUpdate(
        "update konto set saldo = saldo + 1000 where kontonr = '678909'");

      /* Skriver ut alle dataene */
      skrivUt(setningSelect, "\nInnhold i databasen etter endringene: ");

      javax.swing.JOptionPane.showMessageDialog(null, "Alt ok. Fortsetter");
      forbindelse.commit();   // alt ok, endringer lagres i databasen

    } catch (SQLException e) {  // feil oppstått, alle endringer angres
      javax.swing.JOptionPane.showMessageDialog(null, "Feil oppstått. Angrer.");

      Opprydder.rullTilbake(forbindelse);
      Opprydder.skrivMelding(e, "Ruller tilbake");
    } finally {  // opprydding uansett utfall av transaksjonen
      Opprydder.settAutoCommit(forbindelse);
      Opprydder.lukkResSet(res);
      Opprydder.lukkSetning(setningSelect);
      Opprydder.lukkSetning(setningUpdate);
      Opprydder.lukkForbindelse(forbindelse);
    }
  }

  static void skrivUt(Statement stm, String ledetekst) throws SQLException {
      ResultSet res = stm.executeQuery("select * from konto");
      System.out.println(ledetekst);
      while (res.next()) {
        System.out.println(res.getString("kontonr") + ", "
          + res.getString("navn") + ", " + res.getBigDecimal("saldo"));
      }
      res.close();
  }
}