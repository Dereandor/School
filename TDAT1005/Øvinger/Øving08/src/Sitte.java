public class Sitte extends Tribune {

    private int [] antOpptatt;  // tabellstørrelse: antall rader

    public Sitte(String tribunenavn, int pris, int rader, int seter) {
        super(tribunenavn, pris, rader*seter);
        antOpptatt = new int[rader];

    }

    @Override
    public int finnAntallSolgte() {
        int antSolgt = 0;
        for (int i = 0; i < antOpptatt.length; i++) {
            antSolgt += antOpptatt[i];
        }
        return antSolgt;
    }

    @Override
    public int finnInntekt() {
        return getPris() * finnAntallSolgte();
    }

    @Override
    public Billett[] kjopBilletter(int antallBilletter) {
        Billett[] solgte;
        for (int i = 0; i < antOpptatt.length; i++) {
            if(antallBilletter <= ((getKapasitet()/antOpptatt.length) - antOpptatt[i])) {
                solgte = new Billett[antallBilletter];
                for (int j = 0; j < antallBilletter; j++) {
                    solgte[j] = new SitteplassBillett(getTribunenavn(), getPris(), i, j);
                    antOpptatt[i]++;
                }
                return solgte;
            }

        }
        return null;
    }

    @Override
    public Billett[] kjopBilletter(String[] navn) {
        Billett[] solgte;
        for (int i = 0; i < antOpptatt.length; i++) {
            if(navn.length <= ((getKapasitet()/antOpptatt.length)-antOpptatt[i])) {
                solgte = new Billett[navn.length];
                for (int j = 0; j < navn.length; j++) {
                    solgte[j] = new SitteplassBillett(getTribunenavn(), getPris(), i, j);
                    antOpptatt[i]++;
                }
                return solgte;
            }
        }
        return null;
    }
}
