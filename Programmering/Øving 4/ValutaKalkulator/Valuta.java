/**
* Klasse for valutaregning
* setter verdier for EUR, USD, SEK og NOK
* valuta verdier á 15.09.2018
*
*/

public class Valuta {

	private double kurs;
	private String valuta;

	public static final double NOK = 1.0000;
	public static final double DOLLAR = 0.1211;
	public static final double EURO = 0.1041;
	public static final double SEK = 1.0989;


	public Valuta(String valuta, double kurs){
		this.valuta = valuta;
		this.kurs = kurs;
	}

	public String getValuta(){
		return valuta;
	}

	public double getkurs(){
		return kurs;
	}

	public double getNok(double sum){
		return sum / kurs;
	}

	public double getFromNok(double sum){
		return sum * kurs;
	}

}