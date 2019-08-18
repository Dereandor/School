public class Person {
    
    private String fornavn;
    private String etternavn;
    private String personnummer;
    
    public String getpersonnummer() {
        return personnummer;
    }
    
    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }
    
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }
    
    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }
    
    public String getFornavn() {
        return fornavn;
    }
    
    public String getEtternavn() {
        return etternavn;
    }
    
    public String getFullNavn() {
        return fornavn + " " + etternavn;
    }
    
    public Person(String fornavn, String etternavn, String personnummer) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.personnummer = personnummer;
    }
    
    @Override
    public String toString() {
        return "[navn= " + fornavn + " " + etternavn + ", personnummer " + personnummer + "]";
    }
}
