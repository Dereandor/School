import static javax.swing.JOptionPane.*;

public class TabellMnd {

	public static void main(String[]args) {

		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int svar = showConfirmDialog(null, "Er det skuddår?", "År", YES_NO_OPTION);

		if (svar == YES_OPTION) days[1] = 29;
		for (int i = 0; i < days.length; i++); {
			
		}


		showMessageDialog(null, days);
	}
}
