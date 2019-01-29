package dp10.eksamensoppgave.mai98;

import java.time.LocalDate;
import java.util.ArrayList;

import static lib.Out.*;

public abstract class Konto {
	String navn;
	String kontonr;
	double saldo;
	ArrayList<Transaksjon> transaksjoner;

	public Konto(String navn, String kontonr) {
		this.navn = navn;
		this.kontonr = kontonr;
		transaksjoner = new ArrayList<Transaksjon>();
		saldo = 0.0;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void registrerTransaksjon(double bel�p, LocalDate dato) {
		transaksjoner.add(new Transaksjon(bel�p, dato));
		saldo += bel�p;
	}

	public abstract boolean taUtPenger(double bel�p, LocalDate dato);

	@Override
	public String toString() {
		ArrayList<Object> objects = new ArrayList<Object>(transaksjoner);
		return "Konto [navn=" + navn + ", kontonr=" + kontonr + ", saldo=" + saldo + ", transaksjoner="
				+ getListArrayAsString(objects) + "]";
	}

}
