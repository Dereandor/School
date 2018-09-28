/*
a) Hvor mange variabler deklareres?
b) Nummerer linjene. Hva er skopet til de ulike variablene
c) Hva skrives ut hvis både a>10 og b<20 er sann.
d) Hva skrive ut hvis a>10 er sann og b<20 er usann

*/
class Oppgave3_91{
	public static void main(String[] args){

		int a = 11;  // tatt med for testformål - står ikke i læreboka, SKAL IKKE TELLES MED I ANT VAR
		int b = 21;  // tatt med for testformål - står ikke i læreboka
		if(a>10){  // start blokk 1
			int tall1 = 60;
			int tall2 = 50;
			System.out.println("1. tall1= " + tall1 + ", tall2= " + tall2);

			if(b<20){  // start blokk 2
				int tall3 = 20;
				tall1 = 30;
				tall2 = 100;
				int tall4 = tall1 + tall2 + tall3;
				System.out.println("2. tall1= " + tall1 + ", tall2= " + tall2);
				System.out.println("3. tall3= " + tall3 + ", tall4= " + tall4);
			}else {  // slutt blokk 2, start blokk 3
				int tall3 = 65;
				System.out.println("4. tall3= " + tall3);
			} // slutt blokk 3
			System.out.println("5. tall1= " + tall1 + ", tall2= " + tall2);
		} // slutt blokk 1
	}
}