import java.util.ArrayList;

public class Konferansesenter {
    
    private String navn;
    private int antall;
    private int romNr;

    ArrayList<Rom> rom = new ArrayList<Rom>();
    
    public Konferansesenter(String navn) {
        this.navn = navn;

    }
    
    //reservere et rom
    public boolean reserverRom(int romNr) {
        for ( Rom romtest : rom) {
            if (romtest.getRomNr() == romNr) {
                return false;
            }
        }
        rom.get(romNr).nyReservasjon();
        return true;
    }
    
    //registrere nytt rom, går ikke hvis romnummer finnes fra før
    public boolean regNyttRom(int romNr, int size) {
        for (Rom romtest : rom) {
            if (romtest.getRomNr() == romNr) {
                return false;
            }
        }

        rom.add(new Rom(romNr, size));
        return true;
    }
    
    //finn antall rom
    public int getAntall() {
        return rom.size();
    }
    
    //finn et bestemt rom, gitt indeks, returner objektet
    public Rom getRomIndeks(int indeks) {
        if (indeks <= rom.size()) {
            return rom.get(indeks);
        }
    }
    
    //finn et bestemt rom, gitt romnr, returner objektet
}
