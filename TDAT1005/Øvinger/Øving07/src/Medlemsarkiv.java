import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public class Medlemsarkiv {

    private ArrayList<BonusMedlem> Medlemmer = new ArrayList<>();

    public Medlemsarkiv() {

    }
    //lager nytt basicmedlem, returnerer medlemsnr
    public int nyMedlem(Personalia pers, LocalDate innmeldt) {
        int medlNr = finnLedigNr();
        Medlemmer.add(new BasicMedlem(medlNr, pers, innmeldt));
        return medlNr;
    }
    //finner ledig medlemsnummer, Denne metoden skal hente ut et tilfeldig heltall (bruk klassen Random) som ikke allerede er i bruk som medlemsnr.
    private int finnLedigNr() {
        Random r = new Random();
        int medlNr = 0;
            for(BonusMedlem test : Medlemmer) {
                int temp = r.nextInt(1000);
                if(test.getMedlnr() != temp) {
                    medlNr = temp;
                }
            }
        return medlNr;
    }
    //skal ta medlemsnummer og passord som argument og returnere antall poeng denne kunden har spart opp.
    public int finnPoeng(int medlNr, String passord) {
        for(BonusMedlem test : Medlemmer) {
            if(test.getMedlnr() == medlNr) {
                if(test.okPassord(passord)) {
                    return test.getPoeng();
                }
            }
        }
        return -1;
    }
    //skal ta medlemsnummer og antall poeng som argument og sørge for at riktig antall poeng blir registrert for dette medlemmet.
    public boolean registrerPoeng(int medlNr, double poeng) {
        for (BonusMedlem test : Medlemmer) {
            if(test.getMedlnr() == medlNr) {
                test.registrerPoeng(poeng);
                return true;
            }
        }
        return false;
    }
    //skal gå gjennom alle medlemmene og foreta oppgradering av medlemmer som er kvalifisert for det.
    public boolean sjekkMedlemmer() {
        for(BonusMedlem test : Medlemmer) {
            if(test instanceof BasicMedlem) {
                if(test.finnKvalPoeng(LocalDate.now()) >= 75000) {
                    Medlemmer.set(Medlemmer.indexOf(test), new GullMedlem(test.getMedlnr(), test.getPers(), test.getInnmeldtDato(), test.getPoeng()));
                } else if(test.finnKvalPoeng(LocalDate.now()) >= 25000) {
                    Medlemmer.set(Medlemmer.indexOf(test), new SoelvMedlem(test.getMedlnr(), test.getPers(), test.getInnmeldtDato(), test.getPoeng()));
                }
            }
            if(test instanceof SoelvMedlem) {
                if(test.finnKvalPoeng(LocalDate.now()) >= 75000) {
                    Medlemmer.set(Medlemmer.indexOf(test), new GullMedlem(test.getMedlnr(), test.getPers(), test.getInnmeldtDato(), test.getPoeng()));
                }
            }
        }
        return true;
    }

    public String toString() {
        return Medlemmer.toString();
    }
}
