class Vare {

   public static final double MOMS = 24.0;
   public static final double MOMSFAKTOR = 1.0 + MOMS / 100.0;
   private final String varenavn;
   private final int varenr ;
   private double pris; // pris pr. kilo, alltid uten moms

  public Vare( String varenavn, int varenr , double pris) {
    this.varenavn = varenavn;
    this.varenr = varenr ;
    this.pris = pris;
 }
  public Vare( String varenavn, int varenr ) {
    this.varenavn = varenavn;
    this.varenr = varenr ;
    this.pris = 0.0;
 }
  public String getVarenavn () {
    return varenavn;
 }



 publicintgetVarenr() {

    return varenr ;
 }
  public double getPris () {
    return pris;
 }
  public void setPris (double pris) {
    this.pris = pris;
 }
  public String toString () {
    java.util.Formatter f = new java.util.Formatter ();
    f.format ("%.2f", pris);
    return varenr + ": " + varenavn + ", pris pr. kg kr " +
    f.toString () + " u.moms .";
 }
}

class Prisberegning {
  public static void  main ( String [] args) {
    Vare vare = new Vare("Norgesost", 124, 79.50);
    System.out.println ( vare.toString ());
 }
}
