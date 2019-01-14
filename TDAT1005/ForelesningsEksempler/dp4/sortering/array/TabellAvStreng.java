package dp4.sortering.array;

import static lib.Out.out;

import java.util.Arrays;

public class TabellAvStreng {

	public static void main(String[] args) {
		String[] navneliste = new String[7];

		navneliste[0] = "Hanne";
		navneliste[1] = "Berit";
		navneliste[2] = "Hans";
		navneliste[3] = "Olav";
		navneliste[4] = "Morten";
		navneliste[5] = "Janne";
		navneliste[6] = "Kristian";
		
		out("\nUtskrift 1:");
		out(navneliste);

		out("\nUtskrift 2:");		
		Arrays.sort(navneliste);
		out(navneliste);
		
		out("\nUtskrift 3:");		
		int i = Arrays.binarySearch(navneliste, "Janne");
		out(i);			
	}
}

