package dp3.tabell;

import static lib.Out.out;

public class TabellAvStrengB {

	public static void main(String[] args) {
		String[] navneliste = new String[4];

		navneliste[0] = new String("Hanne");
		navneliste[1] = new String("Berit");
		navneliste[2] = new String("Hans");
		navneliste[3] = new String("OLAV");
		
		
		for (int i=0;i<navneliste.length;i++) {
			String navn=navneliste[i];
			if (navn.equals(navn.toUpperCase())) {
				out(navn + " er allerede konvertert til storebokstaver");
			} else {
				out("Konverterer "+navneliste[i]+" til storebokstaver");
				navneliste[i] = navneliste[i].toUpperCase();
			}
		}
		out(navneliste);
	}
}
