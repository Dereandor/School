import java.util.ArrayList;

public class Konferansesenter {
    
    private String navn;
    private int antall;
    private int romNr;
    
    
    
    public Konferansesenter(String navn) {
        this.navn = navn;
        ArrayList<Rom> rom = new ArrayList<Rom>();
    }
    
    //reservere et rom
    public boolean reserverRom(int romNr) {
        for ( Rom romtest : rom) {
            if (romtest.getRomNr().equals(romNr)) {
                return false
            }
        }
        Rom romNr = new Rom(romNr);
        return true;
    }
    
    //registrere nytt rom, går ikke hvis romnummer finnes fra før
    
    //finn antall rom
    
    //finn et bestemt rom, gitt indeks
    
    //finn et bestemt rom, gitt romnr
}
