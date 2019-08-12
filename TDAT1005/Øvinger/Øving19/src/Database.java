import java.sql.*;

public class Database {

    String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/torstehs?user=torstehs&password=Z601ltQ4";

    //Her skal en databaseforbindelse settes opp. Dette skal være en objektvariabel som kan brukes i alle metodene i klassen.
    public Database() {
        try(Connection con = DriverManager.getConnection(url)) {
            Statement stmt = con.createStatement();

        }catch(SQLException sq) {
            System.out.println("SQL-feil" + sq);
        }
    }

    //Denne metoden skal lukke forbindelsen som ble satt opp i konstruktøren.
    public void lukkForbindelse(){

    }

    /*
    Denne metoden skal registrere en ny tittel og samtidig eksemplar nummer 1 av denne tittelen.
    SQL-setninger:
    insert into boktittel(isbn, forfatter, tittel) values(<isbn>, <forfatter>, <tittel>)
    insert into eksemplar(isbn, eks_nr) values (<isbn>, 1);
    Metoden skal returnere false dersom bok med dette ISBN er registrert fra før. Da skal ingen oppdatering skje.
     */
    public boolean regNyBok(Bok nyBok){

    }

    /*
    Denne metoden skal registrere et nytt eksemplar av en tittel som allerede skal være registrert i databasen.
    Eksemplarnummeret skal være 1 høyere enn hittil største eksemplarnummer. For å være sikret dette, kan ikke sekvenser/autonummerering brukes.
    (Du har ikke noen garanti for at slike sekvenser er ubrutt).
    Du må i stedet bruke teknikken som er brukt i metoden registrerNyPerson(), se leksjonen, eventuelt 4.utgave av boka, side 829.
    Metoden skal returnere 0 hvis ingen tittel med dette ISBN eksisterer, ellers skal metoden returnere eksemplarnummeret.
    SQL-setning:
    insert into eksemplar(isbn, eks_nr) values (<isbn>, <eks_nr>);
     */
    public int regNyttEksemplar(String isbn){

    }

    /*
    Denne metoden skal registrere at ei bok er utlånt. Kolonnen utlånt for det aktuelle eksemplaret skal settes lik navnet til låneren.
    Du trenger ikke ta hensyn til om dette feltet allerede er utfylt (vi har ingen metode for å returnere ei bok).
    Metoden skal returnere false dersom ISBN og/eller eksemplarnummer er ugyldig. (Tips: Det er nok å sjekke at update-setningen returnerer 0, det vil si at ingen rader er oppdatert).
    update eksemplar set laant_av = <navn> where isbn = <isbn> and eks_nr = <eks_nr>
     */
    public boolean lånUtEksemplar(String isbn, String navn, int eksNr){

    }

    public static void main(String[] args) {


    }
}
