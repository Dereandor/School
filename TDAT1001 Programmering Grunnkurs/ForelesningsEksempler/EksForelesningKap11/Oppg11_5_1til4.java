class Person {
	private final String navn;
	private final int f�dsels�r;

	public Person(String navn, int f�dsels�r) {
		this.navn = navn;
		this.f�dsels�r = f�dsels�r;
	}
	public String getNavn() {
		return navn;
	}
	public int getF�dsels�r() {
		return f�dsels�r;
	}
	public boolean likeGammel(Person p) { // oppgave 1
		return (p.f�dsels�r == f�dsels�r); // kan ogs� bruke p.getF�dsels�r()
	}
	public int sammenliknAlder(Person p) { // oppgave 2
		if (f�dsels�r < p.f�dsels�r) {
			return -1;
		} else if (f�dsels�r > p.f�dsels�r) {
			return +1;
		} else {
			return 0;
		}
	}
	public boolean flere�rEldreEnn(Person p, int ant�r) { // oppgave 3
		return (f�dsels�r - ant�r > p.f�dsels�r);
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
		if (p1.flere�rEldreEnn(p2, 3)) {
			System.out.println("p1 er mer enn 3 �r eldre enn p2");
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