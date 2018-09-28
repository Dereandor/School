import static javax.swing.JOptionPane.*;
class Oppg_461_s132 {
  public static void main(String[] args) {
    String setning = "";
    String ord = "";
     do {

		ord = showInputDialog ("Skriv ett ord, avslutt med Esc: ");
		if (ord != null){
			setning += (ord + " ");
		}
    } while (ord != null);
    showMessageDialog (null, setning);
  }
}
