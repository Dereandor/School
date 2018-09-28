/*
 * NedborStatistikk.java   E.L. 2002-07-18
 *
 * Filen inneholder to klasser:
 * Maned: Immutabel klasse som lagrer nedb�rdata for en m�ned. Tilbyr operasjoner
 * for � analysere disse: finn gjennomsnitt, finn total, finn t�rre dager, osv.
 * NedborStatistikk: Enkel testklient
 */

class Maned {
  private String mndNavn;
  private int[] nedb�r;

  /*
   * Konstrukt�ren lager en kopi av argumentet med nedb�rdata.
   * Klienten kan dermed bruke den samme datastrukturen til � lagre
   * data for forskjellige m�neder. Hvert enkelt Maneds-objekt holder
   * dermed rede p� sine egne nedb�rdata, uavhengig av klientens data.
   */
  public Maned(String startMndNavn, int[] startNedb�r) {
    mndNavn = startMndNavn;
    int antDager = startNedb�r.length;
    nedb�r = new int[antDager];
    for (int i = 0; i < antDager; i++) nedb�r[i] = startNedb�r[i];
  }

  public String finnMndNavn() {
    return mndNavn;
  }

  public int finnAntDager() {
    return nedb�r.length;
  }

  /*
   * Metoden finner nedb�ren p� en gitt dag. Returnerer -1 dersom ugyldig indeks.
   */
  public int finnNedb�r(int indeks) {
    if (indeks >= 0 && indeks < nedb�r.length) return nedb�r[indeks];
    else return -1;  // ugyldig indeks
  }

  /*
   * Metoden finner maksimalnedb�ren i m�neden.
   */
  public int finnMaksimum() {
    int maks = 0;  // Husk at lokale variabler ikke automatisk f�r en startverdi.
    if (nedb�r.length > 0) {
      maks = nedb�r[0];
      for (int i = 1; i < nedb�r.length; i++) {
        if (nedb�r[i] > maks) maks = nedb�r[i];
      }
    }
    return maks;
  }

  /*
   * Metoden finner gjennomsnittlig nedb�r i m�neden.
   */
  public double finnGjSnitt() {
    int sum = 0;
    for (int i = 0; i < nedb�r.length; i++) {
      sum += nedb�r[i];
    }
    if (nedb�r.length > 0) return (double) sum / (double) nedb�r.length;
    else return 0.0;
  }

  /*
   * Metoden finner antall dager uten nedb�r.
   */
  public int finnAntT�rreDager() {
    int antall = 0;
    for (int i = 0; i < nedb�r.length; i++) {
      if (nedb�r[i] == 0) antall++;
    }
    return antall;
  }

  /*
   * Metoden finner hvilke dager som har nedb�r lik maksimalnedb�ren for m�neden.
   * Returnerer en tabell med indekser til disse dagene.
   */
  public int[] finnDgMaks() {
    int maks = finnMaksimum();

    /* Lager en tabell med plass til alle dagene, det verst tenkelige...*/
    int [] tabell = new int[nedb�r.length];
    int antMaks = 0;
    for (int i = 0; i < nedb�r.length; i++) {
      if (nedb�r[i] == maks) {
        tabell[antMaks] = i;
        antMaks++;
      }
    }
    /* Lager n� en tabell med eksakt riktig st�rrelse og kopierer over. */
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
    int[] nedb�r = {1, 4, 0, 4, 3};  // liten m�ned for testform�l
    /*int[] nedb�r = {};  // har ogs� pr�vd med tabell med lengde 0
     *int[] nedb�r = {1};  // og lengde 1 */
    Maned januar = new Maned("Januar", nedb�r);
    System.out.println("Statistikk for " + januar.finnMndNavn());
    System.out.println("Maksimum: " + januar.finnMaksimum());
    System.out.println("Gjennomsnitt: " + januar.finnGjSnitt());
    System.out.println("Antall t�rre dager: " + januar.finnAntT�rreDager());

    for (int i = 0; i < januar.finnAntDager(); i++) {
      System.out.println("Nedb�r dag nr " + (i + 1) + " er "
        + januar.finnNedb�r(i));
    }

    int[] maksDg = januar.finnDgMaks();
    for (int i = 0; i < maksDg.length; i++) {
      System.out.println("Maks. nedb�r dag nr: " + (maksDg[i] + 1));
    }
  }
	public static int s�k(int[] tab, int verdi){
		int indeks = 0;
		while(indeks < tab.length && tab[indeks] <= verdi){
			if(tab[indeks] == verdi)return indeks;
			indeks++;
		}
		return -1;
	}
}

/* Kj�ring av programmet:
Statistikk for Januar
Maksimum: 4
Gjennomsnitt: 2.4
Antall t�rre dager: 1
Nedb�r dag nr 1 er 1
Nedb�r dag nr 2 er 4
Nedb�r dag nr 3 er 0
Nedb�r dag nr 4 er 4
Nedb�r dag nr 5 er 3
Maks. nedb�r dag nr: 2
Maks. nedb�r dag nr: 4
*/