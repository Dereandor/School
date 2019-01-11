class Navn {
    private String fornavn;
    private String etternavn;

    public Navn(String startFornavn, String startEtternavn) {
        fornavn = startFornavn;
        etternavn = startEtternavn;
    }

    public void setFornavn(String nyttFornavn) {
        fornavn = nyttFornavn;
    }

    public void setEtternavn(String nyttEtternavn) {
        etternavn = nyttEtternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String toString() {
        return fornavn + " " + etternavn;
    }

}
