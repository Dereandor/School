

public class Konto {
	private final long kontonr;
	private final String navn;
	private double saldo;

	public Konto(long kontonr, String navn, double saldo){
		this.kontonr = kontonr;
		this.navn = navn;
		this.saldo = saldo;
	}

	public long getKontonr(){
		return kontonr;
	}

	public String getNavn(){
		return navn;
	}

	public double getSaldo(){
		return saldo;
	}

	public void utforTransaksjon(double belop) {
		saldo += belop;
	}

	public String toString(){
		return kontonr + " " + navn + " " + saldo;
	}
}