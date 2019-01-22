import java.util.ArrayList;

import static javax.swing.JOptionPane.showInputDialog;

public class Konferansesenter {
    
    private String navn;
    private int antall;
    private int romNr;

    ArrayList<Rom> rom = new ArrayList<Rom>();
    
    public Konferansesenter(String navn) {
        this.navn = navn;

    }
    
    //reservere et rom
    public boolean reserverRom() {

        Long fraTid = Long.parseLong(showInputDialog("tast inn tidspunkt fra(yyyyMMddHHmm): "));
        Long tilTid = Long.parseLong(showInputDialog("Tast inn tidspunkt til(yyyyMMddHHmm): "));
        String kunde = showInputDialog("Tast inn navn: ");
        String tlf = showInputDialog("Tast inn telefonnummer: ");
        rom.get(romNr).nyReservasjon(fraTid, tilTid, kunde, tlf);
        return true;
    }
    
    //registrere nytt rom, går ikke hvis romnummer finnes fra før
    public boolean regNyttRom(int romNr, int size) {
        for (Rom romtest : rom) {
            if (romtest.getRomNr() == romNr) {
                throw new IllegalArgumentException("Rommet finnes fra før");
            }
        }

        rom.add(new Rom(romNr, size));
        return true;
    }

    //finne stort nok rom gitt antall personer:
    public int getRom(int antall) {
        for (Rom test : rom) {
            if (test.getRomstr() >= antall) {
                return test.getRomNr();
            }
        }
        return -1;
    }
    
    //finn antall rom
    public int getAntall() {
        return rom.size();
    }

    public String[] getAlleRom() {
        String[] alleRom = new String[rom.size()];
        for (int i = 0; i < alleRom.length; i++){
            alleRom[i] = Integer.toString(rom.get(i).getRomNr());
        }
        return alleRom;
    }
    
    //finn et bestemt rom, gitt indeks, returner objektet
    public Rom getRomIndeks(int indeks) {
        Rom echo = new Rom(000, 0);
        if (indeks <= rom.size()) {
            return rom.get(indeks);
        }
        return echo;
    }
    
    //finn et bestemt rom, gitt romnr, returner objektet
    public Rom getRomRom(int romNr) {
        Rom echo = new Rom(000, 0);
        for (Rom testrom : rom) {
            if (testrom.getRomNr() == romNr) {
                return testrom;
            }
        }
        return echo;
    }
}
