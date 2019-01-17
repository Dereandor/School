import java.io.*;
import static javax.swing.JOptionPane.*;

class Navneregister{
	public static void main(String[] args) throws IOException{
		String filnavn = "navnefil.txt";
		/* 1. Les inn navn fra fil, vi mellomlagrer dataene i et buffer */
		FileReader leseforbindelse = new FileReader(filnavn);
		BufferedReader leser = new BufferedReader(leseforbindelse);

		String utskrift = "Folgende navn er registrert: ";
		String lestNavn = leser.readLine(); // initiere lokkebetingelse

		while(lestNavn != null){
			utskrift += "\n" + lestNavn;
			lestNavn = leser.readLine();  // oppDATER lokkebetingelse
		}
		leser.close();
		showMessageDialog(null, utskrift);

		/* 2. Skrive nye navn til fila */
		int svar = showConfirmDialog(null, "Registrere flere navn?", "Navneregister", YES_NO_OPTION);
		FileWriter skriveforbindelse = new FileWriter(filnavn, true);  // 
		PrintWriter skriver = new PrintWriter(new BufferedWriter(skriveforbindelse));
		while (svar == YES_OPTION){
			String nyttNavn = showInputDialog("Oppgi navn: " );
			skriver.println(nyttNavn);
			svar = showConfirmDialog(null, "Registrere flere navn?", "Navneregister", YES_NO_OPTION);
		}
		skriver.close();
	}
}
