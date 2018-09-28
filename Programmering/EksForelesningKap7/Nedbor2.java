import static javax.swing.JOptionPane.*;
class Nedbor2{
	public static void main(String[] args){

		/* Oppgave side 226 */
		int[] nedbør1 = {3,4,2,0,0};

		Maned2 enMnd = new Maned2("MånedX", nedbør1);
		System.out.println("Utskrift 1: maksimum: " + enMnd.finnMaksimum() + ", ant tørre dager: " + enMnd.finnAntTørreDager());

		nedbør1 = enMnd.getNedbør();
		nedbør1[2] = 10;
		System.out.println("Utskrift 2: maksimum: " + enMnd.finnMaksimum() + ", ant tørre dager: " + enMnd.finnAntTørreDager());

		int[] nedbør2 = enMnd.getNedbør();
		nedbør2[0] = 0;
		System.out.println("Utskrift 3: maksimum: " + enMnd.finnMaksimum() + ", ant tørre dager: " + enMnd.finnAntTørreDager());

	}
}