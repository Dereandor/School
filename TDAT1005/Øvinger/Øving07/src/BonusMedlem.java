public class BonusMedlem {

    private final int medlNr;
    private final int innmeldtDato;
    private int poeng;

    public BonusMedlem(int medlNr, int innmeldtDato) {
        this.medlNr = medlNr;
        this.innmeldtDato = innmeldtDato;
        poeng = 0;
    }

    public int getMedlNr() {
        return medlNr;
    }

    public Personalia getPersonalia(){

    }

    public int getInnmeldtDato() {
        return innmeldtDato;
    }

    public int getPoeng() {
        return poeng;
    }
}
