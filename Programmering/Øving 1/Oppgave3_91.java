/*
* Oppgave 3 side 91
*
*/

class Oppgave3_91 {
	public static void main (String[]args) {
		if(a>10) { // start blokk 1
			int tall1 = 60;
			int tall2 = 50;
			System.out.println("tall1 = " + tall1 + ", tall2 = " + tall2);

			if(b<20) { // start blokk 2
				int tall3 = 20;
				tall1 = 30;
				tall2 = 100;
				int tall4 = tall1 + tall2 + tall3;
				System.out.println("tall1 = " + tall1 + ", tall2 = " + tall2);
				System.out.println("tall3 = " + tall3 + ", tall4 = " + tall4);

			} else { // slutt blokk 2, start blokk 3
				int tall3 = 65;
				System.out.println("tall3 = " + tall3);
			} //slutt blokk 3
			System.out.println("tall1 = " + tall1 + ", tall2 = " + tall2);
		} //slutt blokk 1