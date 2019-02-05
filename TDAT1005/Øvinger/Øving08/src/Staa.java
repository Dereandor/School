public class Staa extends Tribune {

    private int antSolgteBilletter;

    public Staa(String tribunenavn, int pris, int kapasitet) {
        super(tribunenavn, pris, kapasitet);
    }

    @Override
    public int finnAntallSolgte() {
        return antSolgteBilletter;
    }

    @Override
    public int finnInntekt() {
        return getPris() * finnAntallSolgte();
    }

    @Override
    public Billett[] kjopBilletter(int antallBilletter) {
        Billett[] solgte;
        if(antallBilletter <= (getKapasitet() - finnAntallSolgte())) {
            solgte = new Billett[antallBilletter];
            for (int i = 0; i < antallBilletter; i++) {
                solgte[i] = new StaaplassBillett(getTribunenavn(), getPris());
            }
            antSolgteBilletter += antallBilletter;
            return solgte;
        }
        return null;
    }

    @Override
    public Billett[] kjopBilletter(String[] navn) {
        Billett[] solgte;
        if(navn.length <= (getKapasitet() - finnAntallSolgte())) {
            solgte = new Billett[navn.length];
            for (int i = 0; i < navn.length; i++) {
                solgte[i] = new StaaplassBillett(getTribunenavn(), getPris());
            }
            return solgte;
        }
        return null;
    }
}
