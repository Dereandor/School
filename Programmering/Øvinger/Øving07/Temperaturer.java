/*
*   Programmeringsoppgave 2 side 314
*/
import java.util.Random;
import java.util.Arrays;
import java.text.DecimalFormat;

class Temperaturer {

    private int[][] temperatur;
    private String navn;

    Random tall = new Random();

    public Temperaturer(String navn, int dager, int timer){
        this.navn = navn;
        this.temperatur = new int[dager][timer];
        setTemp();
    }

    public void setTemp() {
        for(int i = 0; i < temperatur.length; i++) {
            for(int j = 0; j < temperatur[i].length; j++) {
                int temp = tall.nextInt(25);
                temp -= 10;
                temperatur[i][j] += temp;
            }
        }
    }
    //gjennomsnittstemperaturen for spesifikk dag i måneden
    public double getAverage(int dag) {
        double average = 0;
        int hourCount = 0;
        for(int i = 0; i < temperatur[(dag-1)].length; i++) {
            average += temperatur[(dag-1)][i];
            hourCount++;
        }
        double result = average / hourCount;
        return result;
    }
    //gjennomsnittstemperaturen for hver dag i måneden i egen tabell
    public double[] getAverageDay() {
        double[] averageDay = new double[temperatur.length];
        double temp;
        int hourCount;
        //double average = 0;
        for(int i = 0; i < temperatur.length; i++) {
            double average;
            temp = 0;
            hourCount = 0;
            for(int j = 0; j < temperatur[i].length; j++) {
                temp += temperatur[i][j];
                hourCount++;
            }
            average = temp / hourCount;
            averageDay[i] = average;
        }
        return averageDay;
    }
    //gjennomsnittstemperaturen for hver time i måneden
    public double[] getAverageHour() {
        double[] averageHour = new double[temperatur[0].length];
        double temp;
        int dayCount;
        for(int i = 0; i < temperatur[0].length; i++) {
            double average;
            temp = 0;
            dayCount = 0;
            for(int j = 0; j < temperatur.length; j++) {
                temp += temperatur[j][i];
                dayCount++;
            }
            average = temp / dayCount;
            averageHour[i] += average;
        }
        return averageHour;
    }
    //gjennomsnittstemperaturen for hele måneden
    public double getAverageMonth() {
        double tempHour;
        int hourCount;
        int dayCount = 0;
        double averageMonth = 0;
        double averageDay = 0;
        for(int i = 0; i < temperatur.length; i++) {
            double averageHour;
            tempHour = 0;
            hourCount = 0;
            for(int j = 0; j < temperatur[i].length; j++) {
                tempHour += temperatur[i][j];
                hourCount++;
            }
            averageHour = tempHour / hourCount;
            averageDay += averageHour;
            dayCount++;
        }
        averageMonth = averageDay / dayCount;
        return averageMonth;
    }
    //antall døgn med gjennomsnittstemperatur: <-5(0), -5 til 0(1), 0 til 5(2), 5 til 10(3) og >10(4)
    public double[] getAverageDays() {
        double[] averageMonth = new double[5];
        double[] averageDays = getAverageDay();
            for (int i = 0; i < averageDays.length; i++) {
                if (averageDays[i] <= -5) {
                    averageMonth[0] += 1.0;
                } else if (averageDays[i] > -5 && averageDays[i] <= 0) {
                    averageMonth[1] += 1.0;
                } else if (averageDays[i] > 0 && averageDays[i] <= 5) {
                    averageMonth[2] += 1.0;
                } else if (averageDays[i] > 5 && averageDays[i] <= 10) {
                    averageMonth[3] += 1.0;
                } else {
                    averageMonth[4] += 1.0;
                }
            }
        return averageMonth;
    }

    public String toString() {
        return Arrays.deepToString(temperatur).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
    }
}
