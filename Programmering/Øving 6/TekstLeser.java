/*
*   Leser inn en tekst.
*   Sender teksten til TekstAnalyse.java
*   returnerer verdier for hver hendelse av hvert tegn.
*   0 = aA, 1 = bB, 2 = cC... 25 = zZ, 26 = æÆ, 27 = øØ, 28 = åÅ, 29 = tegn(,.- space etc.)
*/
import static javax.swing.JOptionPane.*;
import java.util.Arrays;
class TekstLeser {

    public static void main(String[]args) {

        TekstAnalyse tekst = new TekstAnalyse("ABBA hai");

        //selve tabellen med verdier.
        tekst.getUnicode();
        System.out.println("Array: " + tekst.toString());

        //antall forskjellige bokstaver
        int bokst = tekst.getSumDiff();
        System.out.println("antall forskjellige bokstaver: " + bokst);

        //totalt antall bokstaver i teksten
        int sum = tekst.getSum();
        System.out.println("antall bokstaver i teksten: " + sum);

        //hvilken bokstav forekommer oftest i teksten
        String maxLett = tekst.getMaxLetters();
        System.out.println("bokstaven(e): " + maxLett + " forekommer oftest i teksten.");

        //prosent som ikke er bokstaver
        double perct = tekst.getPerct();
        perct *= 100;
        System.out.println("prosent som ikke er bokstaver: " + perct);

        //hvor mange ganger en viss bokstav forekommer
        int letter = tekst.getLetter("a");
        System.out.println( "bokstaven a forekommer " + letter + " ganger");

    }

}
