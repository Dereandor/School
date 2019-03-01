package dyrehage;

public class Dyregruppe {
    private final String gruppenavn;
    private int antIndivider;

    public Dyregruppe(String gruppenavn, int antIndivider) {
        this.gruppenavn = gruppenavn;
        this.antIndivider = antIndivider;
    }

    public String getGruppenavn() {
        return gruppenavn;
    }

    public int getAntIndivider() {
        return antIndivider;
    }

    public void setAntIndivider(int antIndivider) {
        this.antIndivider = antIndivider;
    }
}
