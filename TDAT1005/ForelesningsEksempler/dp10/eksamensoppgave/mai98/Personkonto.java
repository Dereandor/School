package dp10.eksamensoppgave.mai98;

import java.time.LocalDate;

public class Personkonto extends Konto {
	boolean masterCard;
	double kreditt;

	public Personkonto(String navn, String kontonr) {
		super(navn, kontonr);
	}

	public boolean taUtPenger(double bel�p, LocalDate dato) {
		if (bel�p <= getSaldo() + kreditt) {			
			super.registrerTransaksjon(-bel�p, dato);
			return true;
		}
		return false;
	}

	public boolean isMasterCard() {
		return masterCard;
	}

	public void setMasterCard(boolean masterCard) {
		this.masterCard = masterCard;
	}

	public double getKreditt() {
		return kreditt;
	}

	public void setKreditt(double kreditt) {
		this.kreditt = kreditt;
	}

	@Override
	public String toString() {
		return "Personkonto [masterCard=" + masterCard + ", kreditt=" + kreditt + ", "+super.toString()+"]";
	}
	
}
