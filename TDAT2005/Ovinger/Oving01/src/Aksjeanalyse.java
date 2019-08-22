import java.util.Arrays;
import java.util.Date;

public class Aksjeanalyse {

    public int[] createRandomTable(int size) {
        java.util.Random r = new java.util.Random();
        int[] out = new int[size];
        for (int i = 0; i < out.length; i++) {
            out[i] = r.nextInt((10 - (-10)) + 1) + (-10);
        }
        return out;
    }

    public int[] buyAndSell(int[] endring) { //n² kompleksitet
        int kjopsdag = -1;
        int salgsdag = -1;
        int fortjeneste = 0;
        int[] resultat = new int[3];

        for (int i = 0; i < endring.length; i++) {
            int forskjell = 0;
            for (int j = i; j < endring.length; j++) {
                forskjell += endring[j];
                if (forskjell > fortjeneste) {
                    fortjeneste = forskjell;
                    kjopsdag = i;
                    salgsdag = j + 1;
                    resultat = new int[]{kjopsdag, salgsdag, fortjeneste};
                }
            }
        }
        //System.out.println("kjøp: " + resultat[0] + ", salg:" + resultat[1] + ", differanse: " + resultat[2]);
        return resultat;
    }

    public int bestBuyTime(int[] pris) {

        if (pris.length == 0) return 0;

        int min = pris[0];
        int buypoint = 0;
        for (int i = 0; i < pris.length; i++) {
            if (pris[i] <= min) {
                min = pris[i];
                buypoint = i;
            }
        }
        return buypoint + 1;
    }

    public int maxProfit(int[] pris) {
        if (pris.length == 0) return 0;

        int[] profit = new int[pris.length];

        for (int i = 0; i < profit.length; i++) {
            profit[i] = 0;
        }

        int min = pris[0];
        int low;
        int high;

        for (int i = 1; i < pris.length; i++) {
            if (pris[i] < min) {
                min = pris[i];
                low = i;
            }

            profit[i] = Math.max(profit[i - 1], pris[i] - min);
        }

        return profit[pris.length - 1];
    }

    public static void main(String[] args) {

        int[] kurs = {9, 12, 3, 5, 7, 6, 8, 7, 2};
        int[] kursendring = {-1, 3, -9, 2, 2, -1, 2, -1, -5};

        Aksjeanalyse a = new Aksjeanalyse();

        int[] randomKurs = a.createRandomTable(10);

        //int result = a.maxProfit(kurs);

        //System.out.println("max profit er: " + a.maxProfit(kurs));
        //System.out.println("beste kjøpstidspunkt er: " + a.bestBuyTime(kursendring));
        System.out.println(Arrays.toString(a.buyAndSell(kursendring)));

        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
            a.buyAndSell(kursendring);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime() - start.getTime() < 1000);
        tid = (double) (slutt.getTime() - start.getTime()) / runder;
        System.out.println("Millisekund pr. runde:" + tid);
    }
}
