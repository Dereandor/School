package dp10.eksamensoppgave.mai98;

import java.time.LocalDate;
import static lib.Out.*;

public class BankKlient {

	public static void main(String[] args) {
		int utskriftNr = 0;

		LocalDate bindingstid = LocalDate.of(2019, 01, 20);
		LocalDate etterBindingstid = bindingstid.plusDays(1);
		LocalDate f�rBindingstid = bindingstid.minusDays(1);
		LocalDate idag = LocalDate.of(2019, 01, 24);

		Kapitalkonto kapitalkonto = new Kapitalkonto(bindingstid, 0.025, "Hans Hansen", "86018655890");
		kapitalkonto.setSaldo(150000);

		Personkonto personkontoKreditt = new Personkonto("Hans Hansen", "86018655892");
		personkontoKreditt.setSaldo(20000);
		personkontoKreditt.setKreditt(10000);
		personkontoKreditt.setMasterCard(true);

		Personkonto personkonto = new Personkonto("Hans Hansen", "86018655892");
		personkonto.setSaldo(5000);
		personkonto.setMasterCard(false);

		L�nnskonto l�nnskonto = new L�nnskonto("Hans Hansen", "86018655891");
		l�nnskonto.setSaldo(25000);

		out("\nUtskrift " + utskriftNr++ + ":");
		out(kapitalkonto);

		out("\nUtskrift " + utskriftNr++ + ":");
		out("\nPr�ver � ta ut penger etter bindingstid fra kapitalkonto:");
		if (kapitalkonto.taUtPenger(1000, etterBindingstid)) {
			out(kapitalkonto);
		} else {
			out("Kan ikke ta ut penger");
		}

		out("\nUtskrift " + utskriftNr++ + ":");
		out("\nPr�ver � ta ut penger f�r bindingstid fra kapitalkonto:");
		if (kapitalkonto.taUtPenger(1000, f�rBindingstid)) {
			out(kapitalkonto);
		} else {
			out("Kan ikke ta ut penger");
		}

		out("\nUtskrift " + utskriftNr++ + ":");
		out(personkontoKreditt);

		out("\nUtskrift " + utskriftNr++ + ":");
		if (personkontoKreditt.taUtPenger(55000, idag)) {
			out(personkontoKreditt);
		} else {
			out("Kan ikke ta ut penger");
		}

		out("\nUtskrift " + utskriftNr++ + ":");
		if (personkonto.taUtPenger(4900, idag)) {
			out(personkonto);
		} else {
			out("Kan ikke ta ut penger");
		}

		out("\nUtskrift " + utskriftNr++ + ":");
		if (personkonto.taUtPenger(50, idag)) {
			out(personkonto);
		} else {
			out("Kan ikke ta ut penger");
		}

		out("\nUtskrift " + utskriftNr++ + ":");
		if (l�nnskonto.fastTrekk(1500, personkonto.kontonr)) {
			out(l�nnskonto);
			out(personkonto);
		} else {
			out("Kan ikke foreta fast trekk");
		}

		out("\nUtskrift " + utskriftNr++ + ":");
		if (l�nnskonto.fastTrekk(1500, personkonto.kontonr)) {
			out(l�nnskonto);
		} else {
			out("Kan ikke foreta fast trekk");
		}

		out("\nUtskrift " + utskriftNr++ + ":");
		if (l�nnskonto.fastTrekk(1500, idag, personkonto)) {
			out(l�nnskonto);
			out(personkonto);
		} else {
			out("Kan ikke foreta fast trekk");
		}
	}
}
