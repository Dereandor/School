package dp4.sortering.flate;

import static lib.Out.out;

/**
 * SorteringAvFlater.java - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Prøver sorteringsmetodene på en tabell av Flate-objekter
 */
class FlaterKlient {
	public static void main(String[] args) {
		Flate[] flater = { new Flate("E", 10, 6), 
						   new Flate("B", 1, 50), 
						   new Flate("F", 5, 7), 
						   new Flate("A", 5, 80) };

		out("\nUten sortering:");
		out(flater);
		
		out("\nStandardsortering (iht. navn)");
		Sortering.sorterObjekter(flater);
		out(flater);

		out("\nSortering iht. areal (med komparator)");
		Sortering.sorterObjekter(flater, new FlateKompAreal());
		out(flater);
		
		out("\nSortering iht. omkrets (med komparator)");
		Sortering.sorterObjekter(flater, new FlateKompOmkrets());
		out(flater);
		
	}
}
