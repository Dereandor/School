public class VIP extends Tribune {

    private String[][] tilskuer; // tabellstørrelse: antall rader * antall plasser pr rad

    public VIP(String tribunenavn, int pris, int rader, int seter) {
        super(tribunenavn, pris, rader*seter);
        tilskuer = new String[rader][seter];
    }

    @Override
    public int finnAntallSolgte() {
        int antSolgt = 0;
        for (int i = 0; i < tilskuer.length; i++) {
            for (int j = 0; j < tilskuer[i].length; j++) {
                if(tilskuer[i][j] != null){
                    antSolgt++;
                }
            }
        }
        return antSolgt;
    }

    @Override
    public int finnInntekt() {
        return finnAntallSolgte() * getPris();
    }

    @Override
    public Billett[] kjopBilletter(int antallBilletter) {
        return null;
    }

    @Override
    public Billett[] kjopBilletter(String[] navn) {
        Billett[] solgte;
        for (int i = 0; i < tilskuer.length; i++) {
            if(navn.length <= tilskuer[i].length) {
                solgte = new Billett[navn.length];
                for (int j = 0; j < navn.length; j++) {
                    solgte[j] = new SitteplassBillett(getTribunenavn(), getPris(), i, j);
                    tilskuer[i][j] = navn[j];
                }
                return solgte;
            }
        }
        return null;
    }

}
