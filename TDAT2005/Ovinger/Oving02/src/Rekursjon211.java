import java.util.Date;

public class Rekursjon211 {

    private static double rekursjonEnkel(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * rekursjonEnkel((x), (n-1));
    }
    
    private static int ytelseRekursjonEnkel(double x, int n, int testrunder) {
        int runder = 0;
        long start = System.currentTimeMillis();;
        long tidsbruk = 0;
        long slutt;
        int resultat;
        do {
            resultat = (int) rekursjonEnkel(x, n);
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
        long start = System.currentTimeMillis();;
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
    
        double x = 1.01;
        int n = 10000;
        int testrunder = 100000;
        System.out.println("Resultat: "+ytelseRekursjonEnkel(x, n, testrunder));
        System.out.println("Resultat: "+ytelseMathPow(x, n, testrunder));
    }
}
