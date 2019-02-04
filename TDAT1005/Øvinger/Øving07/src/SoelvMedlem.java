import java.time.LocalDate;

class SoelvMedlem extends BonusMedlem {

    public SoelvMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng) {
        super(medlNr, pers, innmeldtDato, poeng);
    }

    @Override
    public void registrerPoeng(double poengTjent) {
        if (poengTjent > 0) {
            super.registrerPoeng(poengTjent * 1.2);
        }
    }
}
