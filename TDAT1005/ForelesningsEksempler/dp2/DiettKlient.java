package dp2;

import static lib.Out.*;

class DiettKlient {
	public static void main(String[] args) {
		out("Totalt antall tester: 5");
		Diett minDiett = new Diett(4);

		if (minDiett.registrerNyttMatslag("Due") == Diett.REGISTRERT
				&& minDiett.registrerNyttMatslag("Elg") == Diett.REGISTRERT && !minDiett.fullt()
				&& minDiett.registrerNyttMatslag("Due") == Diett.FINNS_FRA_FØR
				&& minDiett.registrerNyttMatslag("Rådyr") == Diett.REGISTRERT
				&& minDiett.registrerNyttMatslag("Rype") == Diett.REGISTRERT
				&& minDiett.registrerNyttMatslag("Bever") == Diett.FULLT && minDiett.fullt()) {
			out("Diett: Test 1 vellykket");
		}
		if (minDiett.toString().equals("Due Elg Rådyr Rype")) {
			out("Diett: Test 2 vellykket");
		}

		/* Bytter ut et bestemt matslag */
		minDiett.byttUt("Due", "Laks");
		if (minDiett.toString().equals("Laks Elg Rådyr Rype")) {
			out("Diett: Test 3 vellykket");
		}

		/*
		 * Fjerner alle, unntatt ett matslag, og bytter ut dette ved å bytte ut
		 * tilfeldig
		 */
		minDiett.fjern("Laks");
		minDiett.fjern("Elg");
		minDiett.fjern("Rådyr");
		minDiett.byttUt("Torsk");
		if (minDiett.toString().equals("Torsk")) {
			out("Diett: Test 4 vellykket");
		}

		/* Tester antall */
		if (minDiett.finnAntMatslag() == 1 && minDiett.finnMaksAntMatslag() == 4) {
			out("Diett: Test 5 vellykket");
		}
	}
}