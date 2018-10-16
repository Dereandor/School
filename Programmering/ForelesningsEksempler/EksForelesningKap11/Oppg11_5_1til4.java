class Person {
	private final String navn;
	private final int fødselsår;

	public Person(String navn, int fødselsår) {
		this.navn = navn;
		this.fødselsår = fødselsår;
	}
	public String getNavn() {
		return navn;
	}
	public int getFødselsår() {
		return fødselsår;
	}
	public boolean likeGammel(Person p) { // oppgave 1
		return (p.fødselsår == fødselsår); // kan også bruke p.getFødselsår()
	}
	public int sammenliknAlder(Person p) { // oppgave 2
		if (fødselsår < p.fødselsår) {
			return -1;
		} else if (fødselsår > p.fødselsår) {
			return +1;
		} else {
			return 0;
		}
	}
	public boolean flereÅrEldreEnn(Person p, int antÅr) { // oppgave 3
		return (fødselsår - antÅr > p.fødselsår);
	}
	public boolean equals(Object obj) { // oppgave 4
		if (!(obj instanceof Person)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Person p = (Person) obj;
		return navn.equals(p.getNavn());
	}
}
/* *
*
* Klientprogram
*
*/
class Oppg11_5_1til4 {
	public static void main(String[] args) {
		Person p1 = new Person("Ole", 1980);
		Person p2 = new Person("Kari", 1984);
		if (p1.likeGammel(p2)) {
			System.out.println("Like gamle");
		} else {
			System.out.println("Ikke like gamle");
		}
		if (p1.sammenliknAlder(p2) < 0) {
			System.out.println("p1 er yngst");
		} else if (p1.sammenliknAlder(p2) > 0) {
			System.out.println("p1 er eldst");
		} else {
			System.out.println("p1 og p2 er like gamle");
		}
		if (p1.flereÅrEldreEnn(p2, 3)) {
			System.out.println("p1 er mer enn 3 år eldre enn p2");
		}
		if (p1.equals(p2)) {
			System.out.println("Her er det noe feil");
		} else {
			System.out.println("Ikke likhet.");
		}
		if (p1.equals(p1)) {
			System.out.println("Likhet");
		} else {
			System.out.println("Feil.");
		}
	}
}
/*
Ikke like gamle
p1 er yngst
Ikke likhet.
Likhet
*/