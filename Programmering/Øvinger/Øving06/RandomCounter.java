/*
*   Oppgave 7.8.1
*   generer random tall 0-9
*   inkrementer tilsvarende tabellplass med 1
*   looper et valgt antal runder
*/

import java.util.Random;
import java.util.Arrays;
import static javax.swing.JOptionPane.*;

class RandomCounter {

    public static void main(String[]args) {

        java.util.Random random = new java.util.Random();

        String loopsRead = showInputDialog("Tast inn antall runder: ");
        int loops = Integer.parseInt(loopsRead);

        int[] sum = new int [10];

        for (int i = 0; i < loops; i++) {
            int number = random.nextInt(10);
            sum[number] += 1;
        }

        System.out.println("test 1: " + Arrays.toString(sum));
    }
}
