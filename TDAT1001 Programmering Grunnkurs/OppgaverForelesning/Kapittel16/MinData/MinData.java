import java.io.*;
import static javax.swing.JOptionPane.*;

class MinData {

    public static void main(String[]args) {

        String minedata = "D:/Skole/GitHub/School/Programmering/OppgaverForelesning/Kapittel16/MinData/MineData/mindata.txt";
        String dinedata = "dinedata.txt";
        int antallLinjer = 0;

        try{

            FileReader leseForbindelse = new FileReader(minedata);
            BufferedReader leser = new BufferedReader(leseForbindelse);

            FileWriter skriveForbindelse = new FileWriter(dinedata, true);
            PrintWriter skriver = new PrintWriter(new BufferedWriter(skriveForbindelse));

            String data = leser.readLine();
            String overskrift = "Antall linjer lest:";
            String innlesteLinjer = "";
            while (data != null) {
                antallLinjer++;
                innlesteLinjer = data.toUpperCase();
                skriver.println(innlesteLinjer);
                data = leser.readLine();
            }
            showMessageDialog(null, overskrift + "\n" + antallLinjer);
            leser.close();
            skriver.close();

        } catch (FileNotFoundException e) {
            showMessageDialog(null, "Fil ikke funnet: " + minedata);

        } catch (IOException e) {
            showMessageDialog(null, "IO.Feil ved Åpning/lukking av fil");

        }
    }
}
