package dp10.eksamensoppgave.mai98;

public class FastTrekk {
	double beløp;
	String kontonr;
	public FastTrekk(double beløp, String kontonr) {
		this.beløp = beløp;
		this.kontonr = kontonr;
	}

	@Override
	public String toString() {
		return "FastTrekk [beløp=" + beløp + ", kontonr=" + kontonr + "]";
	}
}
