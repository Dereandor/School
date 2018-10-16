import static javax.swing.JOptionPane.*;

class ArbTaker {

    java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();

    private int ansattnummer;
    private int ansettelse;
    private int manedslonn;
    private int skatteprosent;
    private Person personalia;

    public ArbTaker(Person personalia, int ansattnummer,
        int ansettelse, int mandeslonn, int skatteprosent){

        this.personalia = personalia;
        this.ansattnummer = ansattnummer;
        this.ansettelse = ansettelse;
        this.manedslonn = mandeslonn;
        this.skatteprosent = skatteprosent;
    }
    //oprette ny person i Person-klassen
    public Person getPersonalia() {
        return new Person(personalia.getFirstName(),
            personalia.getLastName(), personalia.getBirthYear());
    }
    //hente ut ansatts fornavn
    public String getFornavn() {
        return personalia.getFirstName();
    }
    //hente ut ansatts etternavn
    public String getEtternavn() {
        return personalia.getLastName();
    }
    //hente ut ansatts fødselsår
    public int getFdato() {
        return personalia.getBirthYear();
    }
    //hente ut ansattnummer
    public int getAnsattnummer() {
        return ansattnummer;
    }
    //hente ut ansettelsesår
    public int getAnsettelse() {
        return ansettelse;
    }
    //hente ut månedslønnen
    public int getLonn() {
        return manedslonn;
    }
    //hente ut skatteprosent
    public int getSkatteprosent() {
        return skatteprosent;
    }
    //hente ut skattetrekk per måned
    public int getSkattetrekkMnd() {
        int skattetrekk = manedslonn * (skatteprosent / 100);
        return skattetrekk;
    }
    //hente ut bruttolønn per år
    public int getBruttolonn() {
        int bruttolonn = manedslonn * 12;
        return bruttolonn;
    }
    //hente ut skattetrekk per år
    public int getSkattetrekkAr() {
        int arTrekk = getBruttolonn();
        int skatt = getSkattetrekkMnd();
        arTrekk -= (skatt * 10.5);
        return arTrekk;
    }
    //hente ut navn på formen Etternavn, Fornavn
    public String getNavn() {
        return getEtternavn() + getFornavn();
    }
    //hente alder på ansatt.
    public int getAlder() {
        int ar = kalender.get(java.util.Calendar.YEAR);
        int alder = (ar - getFdato());
        return alder;
    }
    //hente ut tid ansatt har vært i bedriften
    public int getTidAnsatt() {
        int ar = kalender.get(java.util.Calendar.YEAR);
        int arAnsatt = (ar - getAnsettelse());
        return arAnsatt;
    }
    //sjekke om ansatt lengre enn gitt antall år
    public boolean getAnsattLengreEnn(int tall) {
        if(getTidAnsatt() >= tall) {
            return true;
        } else {
            return false;
        }
    }
    //sette ny skatteprosent
    public void setSkatteprosent(int tall) {
        skatteprosent = tall;
    }
    //sette ny månedslønn
    public void setManedslonn(int tall) {
        manedslonn = tall;
    }

    public String toString() {
        return personalia + " " + ansattnummer + " " + ansettelse + " " + manedslonn + " " + skatteprosent;
    }
}
