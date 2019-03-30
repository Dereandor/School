public class Oppgave7 {
    
    public static void main(String[] args) {
        double lowerBounds = 1;
        double upperBounds = 2;
        
        double x = 0;
        
        int[] intervals = {10, 100, 1000};
        
        // Method 1: Trapezoid method
        // a: 10
        System.out.println("Trapezoid method:");
        for (int c = 0; c < intervals.length; c++) {
            double sum = 0;
            double changeInX = (upperBounds - lowerBounds) / intervals[c];
            
            for (int i = 0; i < intervals[c]; i++) {
                x = lowerBounds + changeInX * i;
                if (i > 0 && i < intervals[c])
                    sum += function(x) * 2;
                else
                    sum += function(x);
            }
            
            double integral = (changeInX / 2) * sum;
            
            System.out.println("With " + intervals[c] + " intervals: " + integral);
        }
        
        // Method 2: Middle method
        System.out.println("Middle method:");
        for (int c = 0; c < intervals.length; c++) {
            double sum = 0;
            double changeInX = (upperBounds - lowerBounds) / intervals[c];
            
            for (int i = 0; i < intervals[c]; i++) {
                x = (lowerBounds + i*changeInX) + (changeInX / 2);
                sum += function(x) * changeInX;
            }
            
            double integral = sum;
            
            System.out.println("With " + intervals[c] + " intervals: " + integral);
        }
        
        // Method 3: Simpsons method
        System.out.println("Simpsons method:");
        for (int c = 0; c < intervals.length; c++) {
            double sum = 0;
            double changeInX = (upperBounds - lowerBounds) / intervals[c];
            
            for (int i = 0; i < intervals[c]; i++) {
                x = lowerBounds + changeInX * i;
                if (i > 0 && i < intervals[c])
                    if (i % 2 != 0)
                        sum += function(x) * 2;
                    else
                        sum += function(x) * 4;
                else
                    sum += function(x);
            }
            
            double integral = (changeInX / 3) * sum;
            
            System.out.println("With " + intervals[c] + " intervals: " + integral);
        }
    }
    
    public static double function(double x) {
        return Math.sqrt(Math.pow(x, 3) - 1);
    }
}