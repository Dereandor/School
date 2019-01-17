// https://docs.oracle.com/javase/8/docs/api/java/io/OutputStreamWriter.htm
import java.io.*;
import static javax.swing.JOptionPane.*;

class Navneregister_m_Exceptionhandling{
	public static void main(String[] args) {
		String filnavn = "navnefil.txt";

		/*
		Bruker Automatic Resource Block Management (java.lang.closable)
		Dette kan brukes på alle klasser som implementerer interfacet AutoClosable
		Vi oppretter ressursene i Try-blokka - autocloseable sørgerda for å lukke/ frigjøre ressurser uavhengig av om programmet avsluttes
		på normalt vis eller ikke
		*/
		try(FileReader leseforbindelse = new FileReader(filnavn); BufferedReader leser = new BufferedReader(leseforbindelse);
		    FileWriter skriveforbindelse = new FileWriter(filnavn, true);PrintWriter skriver = new PrintWriter(new BufferedWriter(skriveforbindelse))){
			/* 1. Les inn navn fra fil, vi mellomlagrer dataene i et buffer */
			String utskrift = "Følgende navn er registrert: ";
			String lestNavn = leser.readLine();

			while(lestNavn != null){
				utskrift += "\n" + lestNavn;
				lestNavn = leser.readLine();
			}
			showMessageDialog(null, utskrift);

			/* 2. Skrive nye navn til fila */
			int svar = showConfirmDialog(null, "Registrere flere navn?", "Navneregister", YES_NO_OPTION);
			while (svar == YES_OPTION){
				String nyttNavn = showInputDialog("Oppgi navn: " );
				skriver.println(nyttNavn);
				svar = showConfirmDialog(null, "Registrere flere navn?", "Navneregister", YES_NO_OPTION);
			}
		}catch(EOFException eofe){
			System.out.println("Uventet slutt på fila");
		} catch (IOException ioe){
			System.out.println("IO-feil: " + ioe);
		}

	}
}
