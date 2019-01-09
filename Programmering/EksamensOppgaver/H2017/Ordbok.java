import java.io.*;

class Ordbok implements java.io.Serializable {

    private String ordbokNavn;
    private Ord[] ordbok;
    private int antallReg;
    private final int MAKS_ANTALL_ORD = 10;
    private String filnavn = "ordliste.ser";

    public Ordbok(String ordbokNavn, int antallReg) {
        this.ordbokNavn = ordbokNavn;
        boolean status = lesOrdbokFraFil(filnavn);
        this.antallReg = antallReg;

        if(!status) {
            ordbok = new Ord[MAKS_ANTALL_ORD];
            antallReg = 0;
        }
    }

    public boolean regNyttOrd(Ord ord) {
        //sjekker om det er plass eller om noe ikke er skrevet inn
        if(ordbok.length == antallReg || ord == null) {
            return false;
        }

        //sjekker om ordet er registrert fra før
        for(int i = 0; i<ordbok.length; i++) {
            if(ordbok[i].equals(ord)) {
                return false;
            }
        }

        //registrerer nytt ord
        ordbok[antallReg] = new Ord(ord.getOrd());
        antallReg++;
        return true;
    }

    public boolean leggTilDef(String ord, String nyDef) {
        Ord o = null;
        //sjekker om finner ordet uavhengig av små/store bokstaver
        for (int i = 0; i<ordbok.length; i++) {
            if(ordbok[i].getOrd().toLowerCase().equals(ord.toLowerCase())) {
                o = ordbok[i];
                break;
            }
        }
        //sjekker om fant ordet
        if(o == null) {
            return false;
        }

        return o.leggTilDef(nyDef);
    }

    public Ord[] sorter() {
        Ord[] kopi = new Ord[ordbok.length]
        for(int i = 0; i<ordbok.length; i++) {
            kopi[i] = new Ord(ordbok[i].getOrd());
        }
    }
}
