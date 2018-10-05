import static javax.swing.JOptionPane.*;

class ValutaKalkulatorKlient
{
	public static void main (String[] args)
	{
		//ValutaKalkulator dollar = new ValutaKalkulator("Dollar", ValutaKalkulator.DOLLAR);
		String norskLest = showInputDialog("Tast inn beløp i NOK: ");
		double norske = Double.parseDouble(norskLest);

		String valutaLest = showInputDialog("Tast inn valuta du ønsker å veksle til: Dollar, Euro eller Svenske: ");
		char response = valutaLest.charAt(0);

		ValutaKalkulator valutaKalkulator = new ValutaKalkulator(norske);


		if (response == 'd' || response == 'e' || response == 's')

		switch(response)
		{
			case 'd':
			valutaKalkulator.setDollar(norske);
			System.out.println("Dette blir " + valutaKalkulator.getDollar() + " Dollar.");
			break;

			case 'e':
			valutaKalkulator.setEuros(norske);
			System.out.println("Dette blir " + valutaKalkulator.getEuros() + " Euro");
			break;

			case 's':
			valutaKalkulator.setSek(norske);
			System.out.println("Dette blir " + valutaKalkulator.getSek() + " Svenske");
			break;

			default: System.out.println("Ugyldig valuta");
		}
		else {
			System.out.println("Ugyldig Valuta.");
		}
	}
}