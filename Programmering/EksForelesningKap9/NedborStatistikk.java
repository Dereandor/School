/*
 * NedborStatistikk.java   E.L. 2002-07-18
 *
 * Filen inneholder to klasser:
 * Maned: Immutabel klasse som lagrer nedbørdata for en måned. Tilbyr operasjoner
 * for å analysere disse: finn gjennomsnitt, finn total, finn tørre dager, osv.
 * NedborStatistikk: Enkel testklient
 */

class Maned {
  private String mndNavn;
  private int[] nedbør;

  /*
   * Konstruktøren lager en kopi av argumentet med nedbørdata.
   * Klienten kan dermed bruke den samme datastrukturen til å lagre
   * data for forskjellige måneder. Hvert enkelt Maneds-objekt holder
   * dermed rede på sine egne nedbørdata, uavhengig av klientens data.
   */
  public Maned(String startMndNavn, int[] startNedbør) {
    mndNavn = startMndNavn;
    int antDager = startNedbør.length;
    nedbør = new int[antDager];
    for (int i = 0; i < antDager; i++) nedbør[i] = startNedbør[i];
  }

  public String finnMndNavn() {
    return mndNavn;
  }

  public int finnAntDager() {
    return nedbør.length;
  }

  /*
   * Metoden finner nedbøren på en gitt dag. Returnerer -1 dersom ugyldig indeks.
   */
  public int finnNedbør(int indeks) {
    if (indeks >= 0 && indeks < nedbør.length) return nedbør[indeks];
    else return -1;  // ugyldig indeks
  }

  /*
   * Metoden finner maksimalnedbøren i måneden.
   */
  public int finnMaksimum() {
    int maks = 0;  // Husk at lokale variabler ikke automatisk får en startverdi.
    if (nedbør.length > 0) {
      maks = nedbør[0];
      for (int i = 1; i < nedbør.length; i++) {
        if (nedbør[i] > maks) maks = nedbør[i];
      }
    }
    return maks;
  }

  /*
   * Metoden finner gjennomsnittlig nedbør i måneden.
   */
  public double finnGjSnitt() {
    int sum = 0;
    for (int i = 0; i < nedbør.length; i++) {
      sum += nedbør[i];
    }
    if (nedbør.length > 0) return (double) sum / (double) nedbør.length;
    else return 0.0;
  }

  /*
   * Metoden finner antall dager uten nedbør.
   */
  public int finnAntTørreDager() {
    int antall = 0;
    for (int i = 0; i < nedbør.length; i++) {
      if (nedbør[i] == 0) antall++;
    }
    return antall;
  }

  /*
   * Metoden finner hvilke dager som har nedbør lik maksimalnedbøren for måneden.
   * Returnerer en tabell med indekser til disse dagene.
   */
  public int[] finnDgMaks() {
    int maks = finnMaksimum();

    /* Lager en tabell med plass til alle dagene, det verst tenkelige...*/
    int [] tabell = new int[nedbør.length];
    int antMaks = 0;
    for (int i = 0; i < nedbør.length; i++) {
      if (nedbør[i] == maks) {
        tabell[antMaks] = i;
        antMaks++;
      }
    }
    /* Lager nå en tabell med eksakt riktig størrelse og kopierer over. */
    int[] maksDager = new int[antMaks];
    for (int i = 0; i < antMaks; i++) maksDager[i] = tabell[i];
    return maksDager;
  }
}

/*
 * Testprogram av enkleste slag, det vil si at dataene "hardkodes".
 */
class NedborStatistikk {
  public static void main(String[] args) {
    int[] nedbør = {1, 4, 0, 4, 3};  // liten måned for testformål
    /*int[] nedbør = {};  // har også prøvd med tabell med lengde 0
     *int[] nedbør = {1};  // og lengde 1 */
    Maned januar = new Maned("Januar", nedbør);
    System.out.println("Statistikk for " + januar.finnMndNavn());
    System.out.println("Maksimum: " + januar.finnMaksimum());
    System.out.println("Gjennomsnitt: " + januar.finnGjSnitt());
    System.out.println("Antall tørre dager: " + januar.finnAntTørreDager());

    for (int i = 0; i < januar.finnAntDager(); i++) {
      System.out.println("Nedbør dag nr " + (i + 1) + " er "
        + januar.finnNedbør(i));
    }

    int[] maksDg = januar.finnDgMaks();
    for (int i = 0; i < maksDg.length; i++) {
      System.out.println("Maks. nedbør dag nr: " + (maksDg[i] + 1));
    }
  }
	public static int søk(int[] tab, int verdi){
		int indeks = 0;
		while(indeks < tab.length && tab[indeks] <= verdi){
			if(tab[indeks] == verdi)return indeks;
			indeks++;
		}
		return -1;
	}
}

/* Kjøring av programmet:
Statistikk for Januar
Maksimum: 4
Gjennomsnitt: 2.4
Antall tørre dager: 1
Nedbør dag nr 1 er 1
Nedbør dag nr 2 er 4
Nedbør dag nr 3 er 0
Nedbør dag nr 4 er 4
Nedbør dag nr 5 er 3
Maks. nedbør dag nr: 2
Maks. nedbør dag nr: 4
*/