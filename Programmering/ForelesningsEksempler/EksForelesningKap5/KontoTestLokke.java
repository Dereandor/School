
import static javax.swing.JOptionPane.*;

class KontoTestLokke {
  public static void main(String[] args) {

    /* Oppretter et objekt av klassen Konto. */
    Konto olesKonto = new Konto(123456676756L, "Ole Olsen", 2300.50);

    int teller = 1;
    while (teller !=0){ // avslutter dersom bruker skriver inn 0
    	String lestTransaksjon = showInputDialog("Velg transaksjon (avslutt, innskudd, uttak, saldo: ");
		char transaksjon = lestTransaksjon.charAt(0);

  		switch (transaksjon){
			case 'a':
				teller =0;
				break;
			case 'i':
				String lestInnskudd = showInputDialog("Hvor mye skal du sette inn på konto: ");
				int innskudd = Integer.parseInt(lestInnskudd);
				olesKonto.utførTransaksjon(innskudd);
				if (olesKonto.getSaldo() < 0) showMessageDialog(null, "Etter innskudd har kontoen alikevel negativ saldo " + olesKonto.getSaldo());
				else showMessageDialog(null, "Etter innskudd er saldoen lik " + olesKonto.getSaldo());
				break;
			case 'u':
				String lestUttak = showInputDialog("Hvor mye skal du ta ut fra konto: ");
				int uttak = -Integer.parseInt(lestUttak);
				olesKonto.utførTransaksjon(uttak);
				if (olesKonto.getSaldo() < 0) showMessageDialog(null, "Etter uttak har kontoen negativ saldo " + olesKonto.getSaldo());
				else showMessageDialog(null, "Etter uttak er saldoen lik " + olesKonto.getSaldo());
				break;
			case 's':
				showMessageDialog(null, "Din saldo er " + olesKonto.getSaldo());
				break;
		} // end switch
	} // end while
  } // end main
} // end class

