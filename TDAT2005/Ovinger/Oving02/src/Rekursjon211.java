import java.util.Date;

public class Rekursjon211 {

    private static double rekursjonEnkel(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * rekursjonEnkel((x), (n-1));
    }

    public static void main(String[] args) {

        double x = 1.1001;
        int n = 5000;
        int testrunder = 100000;

        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
            rekursjonEnkel(x, n);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime() - start.getTime() < 1000);
        tid = (double) (slutt.getTime() - start.getTime()) / runder;
        System.out.println("Millisekund pr. runde:" + tid);
    }
}
