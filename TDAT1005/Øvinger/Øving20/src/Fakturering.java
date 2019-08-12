import java.sql.*;

/*
Du skal lage en del av et program som kan brukes ved den månedlige faktureringen, det vil si påløpte kostnader i tabellene prosjektkostnader og prosjektarbeid.

Regnskapssystemet er ikke integrert med det programmet du arbeider med.
Dataene skal overføres dit via tekstfiler. Tekstfilen har fire kolonner: prosjekt_id, kunde, tekst og beløp, atskilt med semikolon.
For prosjektarbeid skal alle timekostnadene for denne måneden og det aktuelle prosjektet summeres til én linje med tekst "timer",
for prosjektkostnader skal listen inneholde en linje pr linje i tabellen for denne måneden. Listen skal være sortert på kunde og prosj_id.

Programmet skal sette faktura_sendt lik dagens dato i de to tabellene.
 */

public class Fakturering {

    public static void main(String[] args)  {

        String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/torstehs?user=torstehs&password=Z601ltQ4";


        try(Connection con = DriverManager.getConnection(url)) {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM prosjektkostnader");

        }catch(SQLException sq) {
            System.out.println("SQL-feil" + sq);
        }
    }
}
