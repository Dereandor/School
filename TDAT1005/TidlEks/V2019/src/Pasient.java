public class Pasient extends Person {
    private String diagnose="";
    
    protected String getDiagnose() {
        return diagnose;
    }
    
    protected void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
    
    public Pasient(String fornavn, String etternavn, String personnummer) {
        super(fornavn, etternavn, personnummer);
    }
    
    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + ": " + super.toString() + ", " + diagnose + "]";
    }
}
