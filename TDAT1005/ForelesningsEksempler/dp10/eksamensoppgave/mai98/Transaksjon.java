package dp10.eksamensoppgave.mai98;

import java.time.LocalDate;

public class Transaksjon {
	double beløp;
	LocalDate dato;

	public Transaksjon(double beløp, LocalDate dato) {
		this.beløp = beløp;
		this.dato = dato;
	}

	@Override
	public String toString() {
		return "Transaksjon [beløp=" + beløp + ", dato=" + dato + "]";
	}
}
