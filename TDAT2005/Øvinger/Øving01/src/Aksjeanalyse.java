import java.util.Arrays;

public class Aksjeanalyse {

    public int maxProfit(int[] pris) {
        if(pris.length == 0) return 0;

        int[] profit = new int[pris.length];

        for (int i = 0; i < profit.length; i++) {
            profit[i] = 0;
        }

        int min = pris[0];
        int low;
        int high;

        for (int i = 1; i < pris.length; i++) {
            if(pris[i] < min) {
                min = pris[i];
                low = i ;
            }

            profit[i] = Math.max(profit[i-1], pris[i] - min);
        }

        return profit[pris.length -1];
    }

    public static void main(String[]args) {

        int[] kurs = {9, 12, 3, 5, 7, 6, 8, 7, 2};

        Aksjeanalyse a = new Aksjeanalyse();

        int result = a.maxProfit(kurs);

        System.out.println("max profit er: " + result);

    }
}
