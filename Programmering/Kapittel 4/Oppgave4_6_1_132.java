import static javax.swing.JOptionPane.*;

class Oppgave4_6_1_132 {
	
	public static void main(String[]args) {
	
		String setning = "";
	
		do {
			String ord = showInputDialog("Skriv ett ord, avslutt med Esc.");
			setning += (ord + " ");
		} while (ord != null);
		showMessageDialog(null, setning);
	}
}