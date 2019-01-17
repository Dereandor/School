import java.io.*;
import static javax.swing.JOptionPane.*;

class MineData{
	public static void main(String[] args) throws IOException{
		String filnavn = "MineData/minedata.txt";
		//String filnavn = "minedata.txt";
		FileReader leseforbindelse = new FileReader(filnavn);
		BufferedReader leser = new BufferedReader(leseforbindelse);

		String filnavn2 = "MineData/dinedata.txt";
		FileWriter skriveforbindelse = new FileWriter(filnavn2, true);
		PrintWriter skriver = new PrintWriter(new BufferedWriter(skriveforbindelse));

		int antallinjer = 0;
		String lestData = leser.readLine();
		while(lestData != null){
			antallinjer++;
			skriver.println(lestData.toUpperCase());
			lestData = leser.readLine();
		}
		leser.close();
		skriver.close();
		showMessageDialog(null, "Antall linjer: " + antallinjer);
	}
}
