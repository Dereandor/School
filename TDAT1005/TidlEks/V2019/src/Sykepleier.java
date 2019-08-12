public class Sykepleier extends Ansatt {
    public Sykepleier(String fornavn, String etternavn, String personnummer) {
        super(fornavn, etternavn, personnummer);
    }
    
    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + ": " + super.toString() + "]";
    }
}
