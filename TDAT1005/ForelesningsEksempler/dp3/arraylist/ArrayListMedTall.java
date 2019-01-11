package dp3.arraylist;

import static javax.swing.JOptionPane.showInputDialog;
import static lib.Out.out;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMedTall {

	public static void main(String[] args) {
		ArrayList<Double> tallene = new ArrayList<Double>();

		String tallLest = "";

		while (tallLest != null) {
			tallLest = showInputDialog("Oppgi et tall: ");
			if (tallLest != null) {
				double tall = Double.parseDouble(tallLest);
				tallene.add(tall);
			}
		}

		out("\nTest 1");
		ArrayList<Object> o = new ArrayList<Object>(tallene);
		out(o);

		out("\nTest 2");
		Iterator<Double> tallIterator = tallene.iterator();
		while (tallIterator.hasNext()) {
			out(tallIterator.next());
		}
	}

}
