
import static javax.swing.JOptionPane.*;

class KlientSetup {
    private final String NYTT_ROM = "Nytt rom";
    private final String NY_RESERVASJON = "Ny reservasjon";
    private final String FINN_ANTALL_ROM = "Finn antall rom";
    private final String AVSLUTT = "Avslutt";
    private final String ROM_INDEKS = "Finn rom etter indeks";
    private final String ROM_ROMNR = "Finn rom etter romnummer";
    private String[] muligeValg = {NYTT_ROM, NY_RESERVASJON, FINN_ANTALL_ROM, ROM_INDEKS, ROM_ROMNR, AVSLUTT};



    private Konferansesenter ks;
    public KlientSetup(Konferansesenter ks) {
        this.ks = ks;
    }

    public String lesValg() {
        String valg = (String) showInputDialog(null, "Velg handling", "rom:", DEFAULT_OPTION, null, muligeValg, muligeValg[0]);
        if (AVSLUTT.equals(valg)) {
            valg = null;
        }
        return valg;
    }

    public void utforValgtOppgave(String valg) {
        if (valg != null && !valg.equals(AVSLUTT)) {
            if (valg.equals(NYTT_ROM)) {
                regNyttRom();
            }
            if(valg.equals(NY_RESERVASJON)) {
                reserverRom();
            }
            if (valg.equals(FINN_ANTALL_ROM)) {
                int rom = getRom();
                showMessageDialog(null, "Antall rom: " + rom);
            }
            if (valg.equals(ROM_INDEKS)) {
                showMessageDialog(null, getRomIndeks().toString());
            }
            if (valg.equals(ROM_ROMNR)) {
                showMessageDialog(null, getRomRom().toString());
            }
        }
    }

    /*
     * Reserver rom, gitt tidspunkt fra og til, antall personer samt navn og telefonnummer til kunden.
     * (Her skal romnummer ikke være parameter, metoden skal selv finne et rom som er ledig og med plass til det oppgitte antallet personer.)
     */
    public void reserverRom() {
        int antall = Integer.parseInt(showInputDialog("Tast inn antall personer: "));
        ks.reserverRom();
    }
    
    /*
     * Registrer et nytt rom med romnummer og størrelse (ikke tillatt dersom rom med dette nummer fins fra før)
     */
    public void regNyttRom() {
        int romNr = 0;
        do {
            romNr = Integer.parseInt(showInputDialog("Tast inn romnummer: "));
        } while (romNr == 0);
        int size = 0;
        do {
            size = Integer.parseInt(showInputDialog("Tast inn størrelse: "));
        } while (size == 0);

        ks.regNyttRom(romNr, size);
    }
    
    /*
     * Finn antall rom
     */
    public int getRom() {
        int rom = ks.getAntall();
        return rom;
    }
    
    /*
     * Finn et bestemt rom, gitt indeks
     */
    public Rom getRomIndeks() {
        int indeks = Integer.parseInt(showInputDialog("Tast inn indeks: "));
        return ks.getRomIndeks(indeks);
    }
    
    /*
     * Finn et bestemt rom, gitt romnr
     */
    public Rom getRomRom() {
        int rom = Integer.parseInt(showInputDialog("Tast inn romnummer: "));
        return ks.getRomRom(rom);
    }

}


public class Klient {
    
    public static void main(String[]args) {
        // @TODO: 16-Jan-19  insert variables here:

        Konferansesenter ks = new Konferansesenter("Alpha");
        KlientSetup k = new KlientSetup(ks);

        String valg = k.lesValg();
        while (valg != null) {
            k.utforValgtOppgave(valg);
            valg = k.lesValg();
        }
    }
}