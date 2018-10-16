import static javax.swing.JOptionPane.*;
import java.util.Arrays;

class TemperaturerKlient {

    public static void main(String[]args) {

        //oprett ny månedstabell
        Temperaturer oktober = new Temperaturer("oktober", 6, 6);

        //hente ut hele tabellen
        System.out.println("Hele tabellen: \n" + oktober.toString());

        //hente gjennomsnittstemperaturen for spesifikk dag
        System.out.println("Snitt for valgt dag: \n" + oktober.getAverage(1));

        //hente ut gjennomsnittstemperaturen for hver dag
        System.out.println("Snitt for hver dag: \n" + Arrays.toString(oktober.getAverageDay()));

        //hente ut gjennomsnittstemperaturen for hver time
        System.out.println("Snitt for hver time: \n" + Arrays.toString(oktober.getAverageHour()));

        //hente ut gjennomsnittet for hele måneden
        System.out.println("Snitt for hele måneden: \n" + oktober.getAverageMonth());

        //hente ut ant. dager med gjennomsnittstemperatur: <-5(0), -5 til 0(1), 0 til 5(2), 5 til 10(3) og >10(4)
        System.out.println("Antall dager med oppgitt temp: \n" + Arrays.toString(oktober.getAverageDays()));

    }
}
