package dp3.komposisjon;

import static lib.Out.out;

import dp3.Navn;

/**
 * EksempelStudent3.java - "Programmering i Java", 4.utgave - 2011-01-12
 *
 * Komposisjon: Navneobjektet er gjemt inne i studentobjektet. Klienten
 * forholder seg ikke til klassen Navn i det hele tatt.
 */

class Student3 {
	private Navn navn;
	private final int fdato;

	public Student3(String fornavn, String etternavn, int fdato) {
		this.navn = new Navn(fornavn, etternavn);
		this.fdato = fdato;
	}

	public String getEtternavn() {
		return navn.getEtternavn();
	}

	public String getFornavn() {
		return navn.getFornavn();
	}

	public int getFdato() {
		return fdato;
	}

	public void setFornavn(String fornavn) {
		navn.setFornavn(fornavn);
	}

	public void setEtternavn(String etternavn) {
		navn.setEtternavn(etternavn);
	}

	public String toString() {
		return navn + ", f�dt: " + fdato;
	}
}

/**
 * Enkel klient som pr�ver metodene i klassen Student. Alle metodene samarbeider
 * med navneobjektet for � l�se oppgavene sine.
 */
class EksempelStudent3 {
	public static void main(String[] args) {
		Student3 studenten = new Student3("Ingrid", "Hansen", 19851210);
		/* Kontrollerer at navnet ble rett registrert. */
		out("A: Student " + studenten.toString());

		/* Endrer b�de fornavn og etternavn (!) */
		studenten.setFornavn("�se");
		studenten.setEtternavn("Li");

		/* Skriver ut resultatet etter endringen ved � bruke get-metodene. */
		out("B: Student " + studenten.getFornavn() + " " + studenten.getEtternavn() + ", " + studenten.getFdato());
		/* Skriver ut resultatet etter endringen ved � bruke toString(). */
		out("C: Student " + studenten.toString());
	}
}

/*
 * Kj�ring av programmet: A: Student Ingrid Hansen, f�dt: 19851210 B: Student
 * �se Li, 19851210 C: Student �se Li, f�dt: 19851210
 */