class Maned {
    private final String mndNavn;
    private final int[] nedbør;


    public Maned(String mndNavn, int[] nedbør) {
        this.mndNavn = mndNavn;
        int antDager = nedbør.length;
        this.nedbør = new int[antDager];
        for (int i = 0; i < antDager; i++) {
            this.nedbør[i] = nedbør[i];
        }
    }

    public String getMndNavn() {
        return mndNavn;
    }


    public int finnnedbør(int indeks) {
        return (indeks >= 0 && indeks < nedbør.length) ? nedbør[indeks] : -1;
    }


    public int finnAntDager() {
        return nedbør.length;
    }

    public int finnMaksimum() {
        int maks = 0;
        if (nedbør.length > 0) {
            maks = nedbør[0];
            for (int i = 1; i < nedbør.length; i++) {
                if (nedbør[i] > maks) {
                    maks = nedbør[i];
                }
            }
        }
        return maks;
    }

    public int finnGjSnitt() {
        int sum = 0;
        for (int i = 0; i < nedbør.length; i++) {
            sum += nedbør[i];
        }
        if (nedbør.length > 0) {
            double snitt = (double) sum / (double) nedbør.length;
            return (int) (snitt + 0.5);
        } else {
            return -1;
        }
    }

    public int finnAntTørreDager() {
        int antall = 0;
        for (int i = 0; i < nedbør.length; i++) {
            if (nedbør[i] == 0) {
                antall++;
            }
        }
        return antall;
    }

    public int[] finnDgMaks() {
        int maks = finnMaksimum();

        int [] tabell = new int[nedbør.length];
        int antMaks = 0;
        for (int i = 0; i < nedbør.length; i++) {
            if (nedbør[i] == maks) {
                tabell[antMaks] = i;
                antMaks++;
            }
        }

        int[] maksDager = new int[antMaks];
        for (int i = 0; i < antMaks; i++) {
            maksDager[i] = tabell[i];
        }
        return maksDager;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < nedbør.length; i++) {
            res += nedbør[i] + " ";
        }
        return res;
    }
}

class NedborStatistikk {
    public static void main(String[] args) {
        int[] nedbør = {1, 4, 0, 4, 3};
        Maned januar = new Maned("Januar", nedbør);
        System.out.println("Statistikk for " + januar.getMndNavn());
        System.out.println("Maksimum: " + januar.finnMaksimum());
        System.out.println("Gjennomsnitt: " + januar.finnGjSnitt());
        System.out.println("Antall tørre dager: " + januar.finnAntTørreDager());

        for (int i = 0; i < januar.finnAntDager(); i++) {
            System.out.println("nedbør dag nr " + (i + 1) + " er "
                + januar.finnnedbør(i));
        }

        int[] maksDg = januar.finnDgMaks();
        for (int i = 0; i < maksDg.length; i++) {
            System.out.println("Maks. nedbør dag nr: " + (maksDg[i] + 1));
        }
    }
}
