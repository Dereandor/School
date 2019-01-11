package dp3.utvidet_forloekke;

import java.util.ArrayList;
import static javax.swing.JOptionPane.*;



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
		
		for (Double tall:tallene) {
			System.out.println("Tall: "+tall);
		}
	}

}
