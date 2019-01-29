package dp10.eksamensoppgave.mai98;

import java.time.LocalDate;

public class Transaksjon {
	double bel�p;
	LocalDate dato;

	public Transaksjon(double bel�p, LocalDate dato) {
		this.bel�p = bel�p;
		this.dato = dato;
	}

	@Override
	public String toString() {
		return "Transaksjon [bel�p=" + bel�p + ", dato=" + dato + "]";
	}
}
