class KlientStudent3{
	public static void main(String[] args){
		Navn navn = new Navn("Grethe", "Olsen");
		if (2 == 2){

			Student a = new Student(navn, 19801010);
			a.setFnavn("Oskar");
			System.out.println("navn: " + navn);
			System.out.println("a.navn: " + a);
			navn = a.getNavn();
			navn.settFornavn("Stine");
			System.out.println("a.navn: " + a);
			System.out.println("navn: " + navn);

		}


		navn.settFornavn("Roger");
		System.out.println("navn: " + navn);

		Navn b = new Navn("Roger","Olsen");
		System.out.println(b.equals(navn));
	}

}

class Student{
	private Navn navn;
	private int fdato;

	public Student(Navn navn, int fdato){
		// this.navn = navn;

		this.navn = new Navn(navn.finnFornavn(), navn.finnEtternavn());
		this.fdato = fdato;
	}

	public Navn getNavn(){
		return new Navn(navn.finnFornavn(), navn.finnEtternavn());
		// return navn;
	}

	public String getFnavn(){
		return navn.finnFornavn();
	}

	public String getEnavn(){
		return navn.finnEtternavn();
	}

	public int getFdato(){
		return fdato;
	}

	public  void setFDato(int fdato){
		this.fdato = fdato;
	}

	public void setEnavn(String enavn){
		navn.settEtternavn(enavn);
	}

	public void setFnavn(String fnavn){
			navn.settFornavn(fnavn);
	}

	public String toString(){
		return navn + " " + fdato;
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