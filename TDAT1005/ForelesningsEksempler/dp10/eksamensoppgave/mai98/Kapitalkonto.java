package dp10.eksamensoppgave.mai98;

import java.time.LocalDate;

public class Kapitalkonto extends Konto {
	LocalDate bindingstid;
	double rente;

	public Kapitalkonto(LocalDate bindingstid, double rente, String navn, String kontonr) {
		super(navn, kontonr);
		this.bindingstid = bindingstid;
		this.rente = rente;
	}

	public boolean taUtPenger(double beløp, LocalDate dato) {
		if (beløp <= getSaldo() && dato.isAfter(bindingstid)) {
			super.registrerTransaksjon(-beløp, dato);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Kapitalkonto [bindingstid=" + bindingstid + ", rente=" + rente +", "+super.toString()+"]]";
	}
}
