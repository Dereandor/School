package dp12.register;

/**
 * KLASSEN PERSONREGISTER. Klassen Personregister administrerer en oversikt over
 * ansatte og studenter. Det er mulig å registrere nye personer og å søke opp
 * registrerte personer.
 *
 * Bare for studenter: Mulig å registrere fag og karakterer samt å søke opp
 * karakterer. Bare for ansatte: Det er mulig å endre lønnen.
 */

class Personregister {
	public static final char PERSON_FINS_IKKE = 'X';

	private java.util.ArrayList<Person> allePersonene = new java.util.ArrayList<Person>();

	/**
	 * Metoden registrerer ny person dersom person med det oppgitte nummer ikke fins
	 * fra før. I siste tilfelle returnerer metoden false.
	 */
	public boolean registrerNyPerson(Person nyPerson) {
		Person p = finnPerson(nyPerson.getFnr());
		if (p == null) { // ingen person med dette fnr er registrert fra før
			allePersonene.add(nyPerson);
			return true;
		}
		return false;
	}

	/**
	 * Metoden søker opp person, gitt nummer. Metoden returnerer null dersom person
	 * ikke fins.
	 */
	public Person finnPerson(long fnr) {
		for (Person p : allePersonene) {
			if (p.getFnr() == fnr) {
				return p;
			}
		}
		return null; // har gått gjennom alle og ikke funnet personen
	}

	/**
	 * Metoden endrer lønnen til en bestemt person. Returnerer false hvis ingen
	 * ansatt med det oppgitte nummeret er registrert.
	 */
	public boolean endreLønn(long fnrAns, int nyttLønnstrinn) {
		Person p = finnPerson(fnrAns);
		if (p != null && p instanceof Ansatt) {
			Ansatt ans = (Ansatt) p;
			ans.setLønnstrinn(nyttLønnstrinn);
			return true;
		}
		return false;
	}

	/**
	 * Metoden registrerer nytt fag for en bestemt student. Returnerer false hvis
	 * ingen student med det oppgitte nummeret er registrert.
	 */
	public boolean registrerNyttFag(long fnrStud, String nyttFag) {
		Person pers = finnPerson(fnrStud);
		if (pers != null && pers instanceof Student) {
			Student stud = (Student) pers;
			stud.registrerNyttFag(nyttFag);
			return true;
		}
		return false; // ugyldig studentnr
	}

	/**
	 * Metoden setter karakter i et bestemt fag for en bestemt student. Returnerer
	 * false hvis ingen student med det oppgitte nummeret er registrert.
	 */
	public boolean settKarakter(long fnrStud, String fagnr, char nyKarakter) {
		Person pers = finnPerson(fnrStud);
		if (pers != null && pers instanceof Student) {
			Student stud = (Student) pers;
			stud.settKarakter(fagnr, nyKarakter);
			return true;
		}
		return false; // ugyldig studentnr
	}

	/**
	 * Metoden returnrerer karakteren i et bestemt fag for en bestemt student.
	 * Returnerer konstanten Personregister.PERSON_FINS_IKKE hvis ingen student med
	 * det oppgitte nummeret er registrert.
	 */
	public char finnKarakter(long fnrStud, String fagnr) {
		Person pers = finnPerson(fnrStud);
		if (pers != null && pers instanceof Student) {
			Student stud = (Student) pers;
			return stud.finnKarakter(fagnr);
		}
		return PERSON_FINS_IKKE;
	}
}