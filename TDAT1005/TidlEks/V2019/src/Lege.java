public class Lege extends Ansatt implements IPasient{
    public Lege(String fornavn, String etternavn, String personnummer) {
        super(fornavn, etternavn, personnummer);
    }
    
    @Override
    public void setDiagnose(Pasient p, String diagnose) {
        p.setDiagnose(diagnose);
    }
}
