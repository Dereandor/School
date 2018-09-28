import static javax.swing.JOptionPane.*;

public class BrokRegner {

	public static void main(String[]args) {

		Brok a = new Brok(1, 2);

		Brok b = new Brok(1, 3);

		String operasjonLest = showInputDialog("Velg operasjon ( + - * / )");
		char operasjon = operasjonLest.charAt(0);

		switch(operasjon){

			case '+' :
				a.addBrok(b); 
				System.out.println("addisjon: " + a.toString());
				break;	

			case '-' :
				a.subBrok(b);
				System.out.println("subtraksjon: " + a.toString());
				break;

			case '*' :
				a.multBrok(b);
				System.out.println("mulitplikasjon: " + a.toString());
				break;

			case '/' :
				a.divBrok(b);
				System.out.println("divisjon: " + a.toString());
				break;

			default: System.out.println("Ugyldig symbol");
		}
	}
}