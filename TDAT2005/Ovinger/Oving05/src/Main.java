import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String navneListe = lesFraFil("C:\\School\\TDAT2005\\Ovinger\\Oving05\\src\\navn.txt");
        String[] navn = navneListe.split("\n");

        Hashtabell hashtabell = new Hashtabell(128);
        for (int i = 0; i < navn.length; i++) {
            if (hashtabell.leggInn(navn[i]) != -1) {

            } else {
                System.out.println("full?? " + navn[i] + " " + i);
            }
        }

        System.out.println("Lastfaktor: " + hashtabell.lastfaktor());
        System.out.println("Kollisjoner per person: " + hashtabell.getAntallKollisjoner());

        System.out.println(hashtabell.finnPos("Sundfær,Torstein Holmberget"));

    }



    private static String lesFraFil(String plassering) {
        String melding = "";

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(plassering));
            StringBuilder stringBuilder = new StringBuilder();
            String linje = buffReader.readLine();

            while (linje != null) {
                stringBuilder.append(linje);
                stringBuilder.append("\n");
                linje = buffReader.readLine();
            }

            return stringBuilder.toString();
        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return melding;
    }

    /*private static int hentAntallLinjer(String plassering) {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(plassering));
            StringBuilder stringBuilder = new StringBuilder();
            String linje = buffReader.readLine();

            int antallLinjer = 0;

            while (linje != null) {
                stringBuilder.append(linje);
                stringBuilder.append("\n");
                linje = buffReader.readLine();
                antallLinjer++;
            }

            return antallLinjer;
        } catch(FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return -1;
    }*/
}