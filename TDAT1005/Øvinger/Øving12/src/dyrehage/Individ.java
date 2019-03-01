package dyrehage;

public class Individ implements SkandinaviskeRovdyr {
    private final String navn;
    private final int fDato;
    private final boolean hanndyr;
    private final boolean farlig;

    public Individ(String navn, int fDato, boolean hanndyr, boolean farlig) {
        this.navn = navn;
        this.fDato = fDato;
        this.hanndyr = hanndyr;
        this.farlig = farlig;
    }

    public String getNavn() {
        return navn;
    }

    public int getfDato() {
        return fDato;
    }

    public boolean isHanndyr() {
        return hanndyr;
    }

    public boolean isFarlig() {
        return farlig;
    }

    @Override
    public int getFdato() {
        return fDato;
    }

    @Override
    public int getAlder() {
        return 0;
    }

    @Override
    public String getAdresse() {
        return null;
    }

    @Override
    public void flytt(String nyAdresse) {

    }

    @Override
    public String skrivUtInfo() {
        return null;
    }
}
