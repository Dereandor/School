import java.time.LocalDate;
import java.time.*;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.*;

import static java.time.temporal.ChronoUnit.DAYS;

class BonusMedlem {

    private final int medlNr;
    private final Personalia pers;
    private final LocalDate innmeldtDato;
    private int poeng;

    public BonusMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato) {
        this.medlNr = medlNr;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
        this.poeng = 0;
    }
    public BonusMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
        this.medlNr = medlNr;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
        this.poeng = poeng;
    }

    /*public BonusMedlem() {

    }*/

    public int getMedlnr() {
        return medlNr;
    }

    public Personalia getPers(){
        return pers;
    }

    public LocalDate getInnmeldtDato() {
        return innmeldtDato;
    }

    public int getPoeng() {
        return poeng;
    }

    public int finnKvalPoeng(LocalDate date) {
        int days = (int) innmeldtDato.until(date, DAYS);
        if (days > 365) {
            return 0;
        }
        return poeng;
    }

    public boolean okPassord(String passord) {
        if (passord != null) {
            return true;
        }
        return false;
    }

    public void registrerPoeng(double poengTjent) {
        if(poengTjent>0) {
            poeng += (int) poengTjent;
        }
    }


}


