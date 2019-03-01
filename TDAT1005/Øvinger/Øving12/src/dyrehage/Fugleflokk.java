package dyrehage;

public class Fugleflokk {

    private final int gjennomsnittligVekt;
    private final boolean svommer;

    public Fugleflokk(int gjennomsnittligVekt, boolean svommer) {
        this.gjennomsnittligVekt = gjennomsnittligVekt;
        this.svommer = svommer;
    }

    public int getGjennomsnittligVekt() {
        return gjennomsnittligVekt;
    }

    public boolean isSvommer() {
        return svommer;
    }
}
