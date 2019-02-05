import com.sun.java.accessibility.util.AccessibilityEventMonitor;

public abstract class Tribune {

    private final String tribunenavn;
    private final int kapasitet;
    private final int pris;

    public Tribune(String tribunenavn, int pris, int kapasitet) {
        if (tribunenavn == null || tribunenavn.trim().equals("")) {
            throw new IllegalArgumentException("Tribunenavn må oppgis.");
        }
        this.tribunenavn = tribunenavn.trim();
        this.pris = pris;
        this.kapasitet = kapasitet;
    }

    public String getTribunenavn() {
        return tribunenavn;
    }

    public int getKapasitet() {
        return kapasitet;
    }
    public int getPris() {
        return pris;
    }

    public abstract int finnAntallSolgte();

    public abstract int finnInntekt();

    //parameter antall billetter som ønskes
    public abstract Billett[] kjopBilletter(int antallBilletter);

    //parameter en tabell av tekststrenger (navnet på de som skal ha billettene).
    public abstract Billett[] kjopBilletter(String[] navn);
}
