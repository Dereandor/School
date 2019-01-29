package dp10.eksamensoppgave.mai98;

import static lib.Out.getListArrayAsString;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lønnskonto extends Personkonto {
	ArrayList<FastTrekk> fastetrekk;

	public Lønnskonto(String navn, String kontonr) {
		super(navn, kontonr);

		fastetrekk = new ArrayList<FastTrekk>();
	}

	public boolean taUtPenger(double beløp, LocalDate dato) {
		super.registrerTransaksjon(-beløp, dato);
		return true;
	}
	
	public boolean fastTrekk(double beløp, String konto) {
		fastetrekk.add(new FastTrekk(-beløp, konto));
		saldo -= beløp;
		return true;
	}
	
	public boolean fastTrekk(double beløp, LocalDate dato, Konto konto) {
		fastetrekk.add(new FastTrekk(-beløp, konto.kontonr));
		saldo -= beløp;
		
		konto.taUtPenger(-beløp, dato);
		return true;
	}

	@Override
	public String toString() {
		ArrayList<Object> objects = new ArrayList<Object>(fastetrekk);
		return "Lønnskonto [fastetrekk=" + getListArrayAsString(objects) + ", "+super.toString()+ "]";
	}	
	
}
