package dp12.register;

/**
 * KLASSEN PERSON. Et objekt av klassen Person inneholder informasjon om
 * fødselsnummer, navn og adresse. Det er ikke lagt inn kontroll av gyldighet av
 * data. Klassen er immutabel.
 */
class Person {
	private final long fnr;
	private final String navn;
	private final String adresse;

	public Person(long fnr, String navn, String adresse) {
		this.fnr = fnr;
		this.navn = navn;
		this.adresse = adresse;
	}

	public long getFnr() {
		return fnr;
	}

	public String getNavn() {
		return navn;
	}

	public String getAdresse() {
		return adresse;
	}
}