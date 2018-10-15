/**
* Klasse for valutaregning
* setter verdier for EUR, USD, SEK og NOK
* valuta verdier á 15.09.2018
*
*/

public class ValutaKalkulator {

	private double nok;
	private double dollar, euro, sek;
	private double valuta;

	public static final double DOLLAR = 0.1211;
	private static final double EURO = 0.1041;
	private static final double SEK = 1.0989;


	public ValutaKalkulator()
	{
		nok = 0;
	}

	public ValutaKalkulator(double norske)
	{
		nok = norske;
	}

	public void setDollar (double norske)
	{
		dollar = norske * DOLLAR;
	}

	public double getDollar()
	{
		return dollar;
	}

	public void setEuros (double norske)
	{
		euro = norske * EURO;
	}

	public double getEuros()
	{
		return euro;
	}

	public void setSek (double norske)
	{
		sek = norske * SEK;
	}

	public double getSek()
	{
		return sek;
	}

	public double getValuta()
	{
		return valuta;
	}

}