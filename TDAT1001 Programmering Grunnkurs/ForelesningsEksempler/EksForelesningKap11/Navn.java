/*
 * Navn.java  E.L. 2002-07-22
 * Klassen er mutabel. Både fornavn og etternavn kan endres.
 */

class Navn {
  private String fornavn;
  private String etternavn;

  public Navn(String startFornavn, String startEtternavn) {
    fornavn = startFornavn;
    etternavn = startEtternavn;
  }

  public void settFornavn(String nyttFornavn) {
    fornavn = nyttFornavn;
  }

  public void settEtternavn(String nyttEtternavn) {
    etternavn = nyttEtternavn;
  }

  public String finnFornavn() {
    return fornavn;
  }

  public String finnEtternavn() {
    return etternavn;
  }


  public String toString() {
    return fornavn + " " + etternavn;
  }
}