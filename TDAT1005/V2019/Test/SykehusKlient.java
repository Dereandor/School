package V2019.Test;

import static lib.Out.out;

import java.util.ArrayList;
import java.util.Collections;

import V2019.Ansatt;
import V2019.AvdSortKomparator;
import V2019.Avdeling;
import V2019.Lege;
import V2019.Pasient;
import V2019.Sykehus;
import V2019.Sykepleier;

public class SykehusKlient {

	public static void main(String[] args) {

		Sykehus sykehus = new Sykehus("St. Olav");

		// Opprett fødeavdeling
		Avdeling fødeAvdeling = new Avdeling("Fødeavdeling");

		Lege lege1 = new Lege("Odd Even", "Primtallet", "20108044221");
		fødeAvdeling.getAnsatte().add(lege1);

		Lege lege2 = new Lege("Huppasahn", "DelFinito", "30018041222");
		fødeAvdeling.getAnsatte().add(lege2);

		Sykepleier sykepleier = new Sykepleier("Rigmor", "Mortis", "12048021456");
		fødeAvdeling.getAnsatte().add(sykepleier);

		Ansatt ansatt = new Ansatt("Kurt", "Isere", "24119041756");
		fødeAvdeling.getAnsatte().add(ansatt);

		Pasient pasient = new Pasient("Horst", "Nuppentaler", "11059352706");
		lege1.setDiagnose(pasient, "Forkjølet");
		fødeAvdeling.getPasienter().add(pasient);

		sykehus.registrer(fødeAvdeling);

		// Opprett lungeavdeling
		Avdeling lungeAvdeling = new Avdeling("Lungemedisinsk avdeling");

		Lege lege3 = new Lege("Salti", "Kaffen", "02037352992");
		lungeAvdeling.getAnsatte().add(lege3);

		Sykepleier sykepleier2 = new Sykepleier("Anton", "Nym", "12098852990");
		lungeAvdeling.getAnsatte().add(sykepleier2);

		Ansatt ansatt2 = new Ansatt("Sesam", "Lukkopphagen", "10037852123");
		lungeAvdeling.getAnsatte().add(ansatt2);

		Pasient pasient2 = new Pasient("Gene", "Sis", "10067967732");
		lege3.setDiagnose(pasient, "Kalle føtter");
		lungeAvdeling.getPasienter().add(pasient2);

		sykehus.registrer(lungeAvdeling);

		// Sortering
		// Alt. 1
		sykehus.getAvdelinger().sort(new AvdSortKomparator());

		// Alt. 2
		Collections.sort(sykehus.getAvdelinger(), new AvdSortKomparator());

		// Alt. 3
		AvdSortKomparator sortering = new AvdSortKomparator();
		ArrayList<Avdeling> avdelinger = sykehus.getAvdelinger();
		for (int i = 0; i < avdelinger.size(); ++i) {
			Avdeling avd1 = avdelinger.get(i);
			for (int j = i + 1; j < avdelinger.size(); ++j) {
				if ((sortering.compare(avd1, avdelinger.get(j)) == -1)
						|| sortering.compare(avd1, avdelinger.get(j)) == 0) {
					Avdeling hjelp = avdelinger.get(j); // Lager et objekt for å ikke miste det når jeg
					avdelinger.remove(j);
					avdelinger.add(i, hjelp);
				}
			}
		}

		out(sykehus.toString());

		sykehus.fjern(pasient);
		out(sykehus.toString());

		sykehus.fjern(lege1);
		out(sykehus.toString());

		sykehus.fjern(fødeAvdeling);
		out(sykehus.toString());
	}
}
