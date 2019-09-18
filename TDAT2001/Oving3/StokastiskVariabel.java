package Oving3;

public class StokastiskVariabel {
    private double[] x;
    private double[] p;

    public StokastiskVariabel(double[] x, double[]p) {
        if (x.length != p.length) throw new IllegalArgumentException("tabellene må være like lange");
        this.x = new double[x.length];
        this.p = new double[p.length];
        for(int i = 0; i < x.length; i++) {
            this.x[i] = x[i];
            this.p[i] = p[i];
        }
    }
    
    public double forventning() {
        double result = 0;
        for(int i = 0; i < x.length; i++) {
            result += (x[i]*p[i]);
        }
        return result;
    }

    public double varians() {
        double varians = 0;
        for(int i = 0; i < x.length; i++) {
            varians += (Math.pow(x[i], 2)*p[i]);
        }
        return varians - Math.pow(forventning(), 2);
    }

    public double standardAvvik() {
        return Math.sqrt(varians());
    }

    public double fordelingsFunksjon(double s) {
        double result = 0;
        for (int i = 0; this.x[i] < s; i++) {
            result += x[i];
        }
        return result;
    }

    public static void main(String[] args) {

        double[] x = new double[] {0, 0.3, 0.5, 0.6, 0.7, 0.8, 1.0, 1.2, 1.6};
        double[] p = new double[] {
            (double)1/28, 
            (double)2/28, 
            (double)5/28, 
            (double)8/28, 
            (double)5/28, 
            (double)3/28, 
            (double)2/28, 
            (double)3/56, 
            (double)1/56};

        StokastiskVariabel sv = new StokastiskVariabel(x, p);

        System.out.println(sv.forventning());
        System.out.println(sv.varians());
        System.out.println(sv.standardAvvik());
        System.out.println(sv.fordelingsFunksjon(1.6) - sv.fordelingsFunksjon(0.6));
    }
}
