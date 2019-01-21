import java.util.ArrayList;

public class Rom {
    private int romNr   ;
    private int size;
    private int bookinger;
    private int maxRes;

    ArrayList<Reservasjon> reservasjoner = new ArrayList<Reservasjon>();
    
    public Rom(int romNr, int size) {
        this.romNr = romNr;
        this.size = size;
    
    }
    
    public int getRomNr() {
        return romNr;
    }
    
    //lage ny reservasjon
    public boolean nyReservasjon() {


    }
    
    //sjekke størrelse på rom
    public int getRomstr() {
        return size;
    }
    
    //sjekke antall bookinger på gitt rom
    public int getBookinger() {
        bookinger = 0;
        for (Reservasjon res : reservasjoner) {
            bookinger++;
        }
        return bookinger;
    }
    
    //sjekke om rom er ledig i gitt tidsrom
    
}
