package dp3.tabell;

import static lib.Out.out;

public class TabellAvStrengA {

	public static void main(String[] args) {
		String[] navneliste = new String[4];

		navneliste[0] = "Hanne";
		navneliste[1] = "Berit";
		navneliste[2] = "Hans";
		navneliste[3] = "OLAV";
		
		
		for (int i=0;i<navneliste.length;i++) {
			String navn=navneliste[i];
			if (navn == navn.toUpperCase()) {
				out(navn + " er allerede konvertert til storebokstaver");
			} else {
				out("Konverterer "+navneliste[i]+" til storebokstaver");
				navneliste[i] = navneliste[i].toUpperCase();
			}
		}
		out(navneliste);
	}
}
