import static javax.swing.JOptionPane.*;
class Nedbor2{
	public static void main(String[] args){

		/* Oppgave side 226 */
		int[] nedb�r1 = {3,4,2,0,0};

		Maned2 enMnd = new Maned2("M�nedX", nedb�r1);
		System.out.println("Utskrift 1: maksimum: " + enMnd.finnMaksimum() + ", ant t�rre dager: " + enMnd.finnAntT�rreDager());

		nedb�r1 = enMnd.getNedb�r();
		nedb�r1[2] = 10;
		System.out.println("Utskrift 2: maksimum: " + enMnd.finnMaksimum() + ", ant t�rre dager: " + enMnd.finnAntT�rreDager());

		int[] nedb�r2 = enMnd.getNedb�r();
		nedb�r2[0] = 0;
		System.out.println("Utskrift 3: maksimum: " + enMnd.finnMaksimum() + ", ant t�rre dager: " + enMnd.finnAntT�rreDager());

	}
}