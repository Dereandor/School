/**
 * Regner om Timer, Minutter og Sekunder til Sekunder
 *
 */

 import static javax.swing.JOptionPane.*;

 class TimerTilSekunder {

	 public static void main(String[] args) {

		 String timerLest = showInputDialog("Antall timer: ");
		 String minutterLest = showInputDialog("Antall minutter: ");
		 String sekunderLest = showInputDialog("Antall sekunder: ");

		 double timer = Double.parseDouble(timerLest);
		 double minutter = Double.parseDouble(minutterLest);
		 double sekunder = Double.parseDouble(sekunderLest);
		 double sekunderTotal =  timer * 3600 + minutter * 60 + sekunder ;

		 String utskrift = sekunderTotal + " sekunder til sammen";
		 showMessageDialog(null, utskrift);
	 }
 }