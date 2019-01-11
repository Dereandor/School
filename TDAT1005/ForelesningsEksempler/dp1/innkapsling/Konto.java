package dp1.innkapsling;

public class Konto {

	private final long kontonr;
	private final String navn;
	private long saldo;

	public Konto(long kontonr, String navn, long saldo) {
		this.kontonr = kontonr;
		this.navn = navn;
		this.saldo = saldo;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	public long getKontonr() {
		return kontonr;
	}

	public String getNavn() {
		return navn;
	}

	public boolean utførTransaksjon(double beløp) {
		int beløpØre = regnOmTilØre(beløp);
		if (saldo + beløpØre >= 0) {
			saldo += beløpØre;
			return true;
		} else {
			return false;
		}

	}

	private int regnOmTilØre(double beløp) {
		return (int) (beløp * 100);
	}
}
