class Oppgave306 {
	public static void main(String[] args) {

		// Oppgave 1, Hva skrives ut?
		int tall1 = 3;
		int tall2 = 4;
		System.out.println("Før: " + tall1 + " " + tall2);

		int hjelp = tall1;
		tall1 = tall2;
		tall2 = hjelp;
		System.out.println("Etter: " + tall1 + " " + tall2);

		// oppgave 2 - Hva skrives ut?
		ToysOgTull etObjekt = new ToysOgTull();
		int a = 10;
		int b = 4;
		System.out.println("Før: " + a + " " + b);

		etObjekt.byttOmTall(a,b);
		System.out.println("Etter: " + a + " " + b);

		// Oppgave 3, Ingen av disse virker - hvorfor?
		Navn navn1 = new Navn("Ole", "Olsen");
		Navn navn2 = new Navn("Kari", "Karidotter");

		etObjekt.byttOmObjekter1(navn1, navn2);
		System.out.println("A " + navn1 + " " + navn2);

		etObjekt.byttOmObjekter2(navn1, navn2);
		System.out.println("B " + navn1 + " " + navn2);

		// Oppgave 4: Hvordan få til å bytte om på referansene
		etObjekt.byttOmObjekter3(navn1, navn2);
		System.out.println("C " + navn1 + " " + navn2);
}}

class ToysOgTull{

	// ingen av disse metodene virker, hvorfor?
	public  void byttOmObjekter1(Navn f1, Navn f2){
			Navn hjelp = f1;
			f1 = f2;
			f2 = hjelp;
	}
	public  void byttOmObjekter2(Navn f1, Navn f2){
			Navn hjelp = new Navn(f1.finnFornavn(), f1.finnEtternavn());
			f1 = new Navn(f2.finnFornavn(), f2.finnEtternavn());;
			f2 = hjelp;
	}
	public  void byttOmTall(int t1, int t2){
				int hjelp = t1;
				t1 = t2;
				t2 = hjelp;
		}

	// Oppgave 4: Hvordan få til å bytte om på referansene
	public void byttOmObjekter3(Navn f1, Navn f2) {
	  //???
		String fnavn = f1.finnFornavn();
		String enavn = f1.finnEtternavn();
		f1.settEtternavn(f2.getEtternavn());
		f1.settFornavn(f2.getFornavn());

		f2.settFornavn(fnavn);
		f2.settEtternavn(enavn);
	}
}


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