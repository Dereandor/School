import java.time.LocalDate;

class BasicMedlem extends BonusMedlem {

    public BasicMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato) {
        super(medlNr, pers, innmeldtDato);
    }

    @Override
    public void registrerPoeng(double poengTjent) {
        super.registrerPoeng(poengTjent);
    }
}
