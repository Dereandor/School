import static javax.swing.JOptionPane.*;

class ValutaKalkulator
{
	public static void main (String[] args)
	{
		Valuta dollar = new Valuta("Dollar", Valuta.DOLLAR);
		Valuta euro = new Valuta("Euro", Valuta.EURO);
		Valuta svenske = new Valuta("Svenske", Valuta.SEK);

		String valutaLest = showInputDialog("Skriv inn valuta du ønsker å veksle fra: ");
		char response = valutaLest.charAt(0);

		String sumLest = showInputDialog("Tast inn summen du vil veksle: ");
		double sum = Double.parseDouble(sumLest);

		switch(response)
		{
			case 'd':
			System.out.println(dollar.getNok(sum));
			break;

			case 'e':
			System.out.println(euro.getNok(sum));
			break;

			case 's':
			System.out.println(svenske.getNok(sum));
			break;

			default: System.out.println("Ugyldig valuta");
		}
	}
}