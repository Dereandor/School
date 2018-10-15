/*
* Klient som skal simulere to spillere som kaster terning for å få 100 først
*
*/

import static javax.swing.JOptionPane.*;

class TerningSpillerKlient
{

	public static void main(String[]args)
	{

		//input for å legge inn spillernavn på de to spillerne

		String spillerNavn1 = showInputDialog("Tast inn navn spiller 1: ");
		TerningSpiller spiller1 = new TerningSpiller(spillerNavn1);

		String spillerNavn2 = showInputDialog("Tast inn navn spiller 2: ");
		TerningSpiller spiller2 = new TerningSpiller(spillerNavn2);

		int antallKast = 0;
		//løkke som går fram til en av spillerne har opnådd 100 poeng, skriver ut poengsummer løpende
		//
		while (spiller1.getSumPoeng() < 100 && spiller2.getSumPoeng() < 100) //sjekker om poengsummen er mindre 100
		{
			antallKast++;
			//kjør terningsimulator her
			spiller1.kastTerningen();
			spiller2.kastTerningen();
			int poeng1 = spiller1.getSumPoeng();
			int poeng2 = spiller2.getSumPoeng();

			System.out.println(spiller1 + " har nå " + poeng1 + " poeng på " + antallKast + " kast");
			System.out.println(spiller2 + " har nå " + poeng2 + " poeng på " + antallKast + " kast");
		}


		System.out.println(spiller1.toString() + " " + antallKast);
		System.out.println(spiller2.toString() + " " + antallKast);
	}
}