/*
* Oppgave 3
*/
import java.util.StringTokenizer;

class TekstBehandling {

    private String tekst;
    private double avg;

    public TekstBehandling(String tekst) {
        this.tekst = tekst;
    }
    //antall ord i teksten
    public int getCount() {
        String[] ord = tekst.split(" ");
        int wordCount = ord.length;
        return wordCount;
    }
    //gjennomsnittlig ordlengde
    public double getAvg() {
        StringTokenizer analyse = new StringTokenizer(tekst);
        int wordCount = analyse.countTokens();
        int letterCount = 0;
        while (analyse.hasMoreTokens()) {
            String word = analyse.nextToken();
            letterCount += word.length();
        }
        double avg = (double) letterCount / (double) wordCount;
        return avg;
    }
    //gjennomsnittlig antall ord per periode
    public double getPeriod() {
        StringTokenizer periode = new StringTokenizer(tekst, ".!:?");
        int periodCount = periode.countTokens();
        int wordCount = 0;
        while (periode.hasMoreTokens()) {
            String ord = periode.nextToken();
            StringTokenizer counter = new StringTokenizer(ord);
            wordCount += counter.countTokens();
        }
        double avgPeriod = (double) wordCount / (double) periodCount;
        return avgPeriod;
    }
    //skifte ut et ord med et annet gjennom hele teksten.
    public String getReplace(String old, String replacement) {
        String newString = tekst.replaceAll(old, replacement);
        return newString;
    }
    //hente ut teksten slik den er
    public String getText(){
        return tekst;
    }
    //hente ut teksten i bare store bokstaver
    public String getUpper() {
        return tekst.toUpperCase();
    }
}
