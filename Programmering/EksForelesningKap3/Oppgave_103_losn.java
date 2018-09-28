/* Oppgave_103.java
Påpek feil og svakheter ved følgende switch-setning
Syntaksfeil: ikke lov å liste opp flere verdier i samme case-etikett
Logiske feil: break må legges inn etter hver case der programkontrollen skal
hoppe ut av switch blokka.

*/

class Oppgave_103_losn{
	public static void main(String[] args){

		int[] testTab = {1,2,3,4,5,6,7,8,-1,0};

		for (int i=0; i<testTab.length; i++){
			int ukedag = testTab[i];

			switch(ukedag){
			case 1:
			case 2:
				System.out.println("Begynnelsen av uka");
				break;
			case 3:
			case 4:
				System.out.println("Midt i uka");
				break;
			case 5:
				System.out.println("Slutten av uka");
				break;
			case 6:
			case 7:
				System.out.println("Helg");
				break;
			default:
				System.out.println("Ugyldig ukedag");
				break;
			}   // fjernet semikolon her
		}
	}
}

/* Kjøring
Begynnelsen av uka
Begynnelsen av uka
Midt i uka
Midt i uka
Slutten av uka
Helg
Helg
Ugyldig ukedag
Ugyldig ukedag
Ugyldig ukedag
*/