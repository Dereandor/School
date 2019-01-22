import java.util.ArrayList;

public class Rom {
    private int romNr   ;
    private int size;

    ArrayList<Reservasjon> reservasjoner = new ArrayList<Reservasjon>();
    
    public Rom(int romNr, int size) {
        this.romNr = romNr;
        this.size = size;
    
    }
    
    public int getRomNr() {
        return romNr;
    }
    
    //lage ny reservasjon
    public boolean nyReservasjon(Long fraTid, Long tilTid, String navn, String tlf) {
        Kunde kunde = new Kunde(navn, tlf);
        Tidspunkt fra = new Tidspunkt(fraTid);
        Tidspunkt til = new Tidspunkt(tilTid);
        for (Reservasjon reservasjon : reservasjoner) {
            if (reservasjon.overlapp(fra, til)) {
                return false;
            }
        }
        reservasjoner.add(new Reservasjon(fra, til, kunde));
        return true;
    }
    
    //sjekke størrelse på rom
    public int getRomstr() {
        return size;
    }
    
    //sjekke antall bookinger på gitt rom
    public int getBookinger() {
        return reservasjoner.size();
    }
    
    //sjekke om rom er ledig i gitt tidsrom
    @SuppressWarnings("Duplicates")
    public boolean getLedig(Long fraTid, Long tilTid) {
        Tidspunkt fraT = new Tidspunkt(fraTid);
        Tidspunkt tilT = new Tidspunkt(tilTid);
        for (Reservasjon testres : reservasjoner) {
            if (testres.overlapp(fraT, tilT)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return reservasjoner.toString();
    }


    public static void main(String[]args) {
        Rom r1 = new Rom(101, 50);
        Rom r2 = new Rom(102, 75);
        Rom r3 = new Rom(103, 40);
        Rom r4 = new Rom(104, 60);

        System.out.println(r1.nyReservasjon(200302021000L, 200302021100L, "Test", "12345678"));
        r2.nyReservasjon(200302021000L, 200302021100L, "Test", "12345678");
        r3.nyReservasjon(200302021000L, 200302021100L, "Test", "12345678");
        r4.nyReservasjon(200302021000L, 200302021100L, "Test", "12345678");

        int r1size = r1.getRomstr();
        int r2size = r2.getRomstr();
        int r3size = r3.getRomstr();
        int r4size = r4.getRomstr();

        System.out.println(r1size);
        System.out.println(r2size);
        System.out.println(r3size);
        System.out.println(r4size);

        int r1book = r1.getBookinger();
        int r2book = r2.getBookinger();
        int r3book = r3.getBookinger();
        int r4book = r4.getBookinger();

        System.out.println(r1book);
        System.out.println(r2book);
        System.out.println(r3book);
        System.out.println(r4book);

        System.out.println(r1.getLedig(200302021000L, 200302021100L));
    }
}
