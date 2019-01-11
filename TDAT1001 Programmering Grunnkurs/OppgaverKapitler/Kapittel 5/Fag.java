/**
* Fag.java
*
* Klassen Fag med attributtene fagkode og antall studenter.
* Antall Studenter kan endres.
*/

class Fag {
	private final String fagkode;
	private int antStud;

	public Fag(String fagkode, int antStud) {
		this.fagkode = fagkode;
		this.antStud = antStud;
	}

	public String getFagkode() {
		return fagkode;
	}

	public int getAntStud() {
		return antStud;
	}

	public void setAntStud(int antStud) {
		this.antStud = antStud;
	}
}