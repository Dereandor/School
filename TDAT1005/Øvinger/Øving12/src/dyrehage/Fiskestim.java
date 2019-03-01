package dyrehage;

public class Fiskestim {

    private final int gjennomsnittligLengde;
    private final boolean kanDeleAkvarium;

    public Fiskestim(int gjennomsnittligLengde, boolean kanDeleAkvarium) {
        this.gjennomsnittligLengde = gjennomsnittligLengde;
        this.kanDeleAkvarium = kanDeleAkvarium;
    }

    public int getGjennomsnittligLengde() {
        return gjennomsnittligLengde;
    }

    public boolean isKanDeleAkvarium() {
        return kanDeleAkvarium;
    }
}
