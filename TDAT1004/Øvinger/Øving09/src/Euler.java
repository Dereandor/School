public class Euler {
    private static void euler (double y0, double a, double b, double h) {
        double t = a;
        double y = y0;
        while (t < b) {
            System.out.println ("" + t + " " + y);
            t += h;
            y += h * func(a, y0);
            
        }
        System.out.println("" + t + " " + y);
        System.out.println ("DONE");
    }
    private static double func(double x, double y) {
        return (x + y + x * y);
    }
    
    public static void main (String[] args) {
        double[] steps = {1, 0.1, 0.01};
        for (double stepSize : steps) {
            System.out.println ("Step size: " + stepSize);
            euler (3.0, 0, 1, stepSize);
        }
    }
}
