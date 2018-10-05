
/* Oppgaves119.java, GS 2011

	Eksempel på løkke som skriver ut verdi av teller og en tekst.
	a) Skriv ut 5 ganger
	b) Skriv ut 0 ganger
	c) Skriv ut uendelig antall ganger

*/
class Oppg_411_s119{
	public static void main(String[] args){
		int teller = 0;

		while (teller < 5){
			System.out.println(teller + ": Dette er en linje");
			teller++;
		}

		System.out.println(teller + ": Tellers verdi når løkka avbrytes");
	}
}
