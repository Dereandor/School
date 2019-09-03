import java.util.Date;

public class Rekursjon223 {
    
    private static double rekursjonAvansert(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if ((n % 2)== 0) {
            return rekursjonAvansert((x*x), (n/2));
        }
        else {
            return x * rekursjonAvansert((x*x), ((n-1) / 2));
        }
    }
    
    private static int ytelseRekursjonAvansert(double x, int n, int testrunder){
        int runder = 0;
        long start = System.currentTimeMillis();
        long tidsbruk = 0;
        long slutt;
        int resultat;
        do {
            resultat = (int) rekursjonAvansert(x, n);
            slutt = System.currentTimeMillis();
            runder++;
            tidsbruk += (slutt - start);
        } while(tidsbruk < testrunder);
        double tid = (double) (tidsbruk / runder);
        System.out.println("Millisekund pr. runde (rekursjon): "+ tid);
        return resultat;
    }
    
    private static int ytelseMathPow(double x, int n, int testrunder){
        int runder = 0;
        long start = System.currentTimeMillis();
        long tidsbruk = 0;
        long slutt;
        int resultat;
        do {
            resultat = (int) Math.pow(x, n);
            slutt = System.currentTimeMillis();
            runder++;
            tidsbruk += (slutt - start);
        } while(tidsbruk < testrunder);
        double tid = (double) (tidsbruk / runder);
        System.out.println("Millisekund pr. runde (Math.pow): "+ tid);
        return resultat;
    }


    public static void main(String[] args) {

        double x = 1.1001;
        int n = 5000;
        int testrunder = 100000;
    
        System.out.println("Resultat: "+ytelseRekursjonAvansert(x, n, testrunder));
        System.out.println("Resultat: "+ytelseMathPow(x, n, testrunder));
    }
}
