package dp10.eksamensoppgave.mai98;

import static lib.Out.getListArrayAsString;

import java.time.LocalDate;
import java.util.ArrayList;

public class L�nnskonto extends Personkonto {
	ArrayList<FastTrekk> fastetrekk;

	public L�nnskonto(String navn, String kontonr) {
		super(navn, kontonr);

		fastetrekk = new ArrayList<FastTrekk>();
	}

	public boolean taUtPenger(double bel�p, LocalDate dato) {
		super.registrerTransaksjon(-bel�p, dato);
		return true;
	}
	
	public boolean fastTrekk(double bel�p, String konto) {
		fastetrekk.add(new FastTrekk(-bel�p, konto));
		saldo -= bel�p;
		return true;
	}
	
	public boolean fastTrekk(double bel�p, LocalDate dato, Konto konto) {
		fastetrekk.add(new FastTrekk(-bel�p, konto.kontonr));
		saldo -= bel�p;
		
		konto.taUtPenger(-bel�p, dato);
		return true;
	}

	@Override
	public String toString() {
		ArrayList<Object> objects = new ArrayList<Object>(fastetrekk);
		return "L�nnskonto [fastetrekk=" + getListArrayAsString(objects) + ", "+super.toString()+ "]";
	}	
	
}
