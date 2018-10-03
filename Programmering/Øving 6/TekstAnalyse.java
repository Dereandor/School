/*
*   Oppgave 7.8.3
*   Leser inn en Tekst fra TekstLeser.java
*   Leser verdien på tegn og inkrementerer tilsvarende plass i tabell med 1
*   A-Z = 65-90, a-z = 97-122, Æ = 198, Ø = 216, Å = 197, æ = 230, ø = 248, å = 229
*   0 = aA, 1 = bB, 2 = cC... 25 = zZ, 26 = æÆ, 27 = øØ, 28 = åÅ, 29 = tegn(,.- space etc.)
*/
import java.util.Arrays;
import java.util.stream.*;
import java.lang.reflect.Array;
class TekstAnalyse {

    private String tekst;
    private int sum;

    int[] antallTegn = new int[30];

    public TekstAnalyse(String tekst){
        this.tekst = tekst;
        //getUnicode();

    }
//andel av teksten(prosent) som ikke er bokstaver
    public double getPerct() {
        double total = 0;
        double tegn = Array.getDouble(antallTegn, 29);
        for (double i : antallTegn) {
            total += i;
        }
        tegn /= total;
        return tegn;
    }
//antall av spesifikk bokstav (parameter til metoden)
    public int getLetter(String letter) {
        char code = letter.charAt(0);
        int tall = code;
        if (tall >= 65 && tall <= 90) {
            tall -= 65;
        } else if (tall >= 97 && tall <= 122) {
            tall -=97;
        }
        return antallTegn[tall];
    }
//maks antall forekomster av bokstav
    public int getMax() {
        int max = 0;
        for (int i = 0; i < antallTegn.length - 1; i++) {
            if (max < antallTegn[i]) {
                max = antallTegn[i];
            }
        }
        return max;
    }

    public int[] getMaxLett() {
        int max = getMax();

        int [] tabell = new int[antallTegn.length - 1];
        int antMax = 0;
        for (int i = 0; i < antallTegn.length - 1; i++) {
            if (antallTegn[i] == max) {
                tabell[antMax] = i;
                antMax++;
            }
        }

        int[] maxLetters = new int[antMax];
        for (int i = 0; i < antMax; i++) {
            maxLetters[i] = tabell[i];
        }
        return maxLetters;
    }

    public String getMaxLetters() {
        int[] max = getMaxLett();
        for (int i = 0; i < max.length; i++) {
            if (max[i] == 26) {
                max[i] += 172;
            } else if (max[i] == 27) {
                max[i] += 189;
            } else if (max[i] == 28) {
                max[i] += 169;
            } else {
                max[i] += 65;
            }
        }
        return Arrays.toString(max);
    }

//antall forskjellige bokstaver.
    public int getSumDiff() {
        int diff = 0;
        for (int i = 0; i < (antallTegn.length - 1); i++) {
            if (antallTegn[i] != 0){
                diff++;
            }
        }
        return diff;
    }
//finn total antall bokstaver i teksten
    public int getSum() {
        for (int i : antallTegn) {
            sum += i;

        }
        if (antallTegn[29] >= 1) {
            sum -= antallTegn[29];
        }
        return sum;
    }

    public void getUnicode() {
        for (int i = 0; i < tekst.length(); i++) {
            char code = tekst.charAt(i);
            int tall = code;
            if (tall >= 65 && tall <= 90) {
                tall -= 65;
                antallTegn[tall] += 1;
            } else if (tall >= 97 && tall <= 122) {
                tall -=97;
                antallTegn[tall] += 1;
            } else if (tall == 198 || tall == 230) {
                antallTegn[26] += 1;
            } else if (tall == 216 || tall == 248) {
                antallTegn[27] += 1;
            } else if (tall == 197 || tall == 229) {
                antallTegn[28] += 1;
            } else {
                antallTegn[29] += 1;
            }
        }

    }

    public String toString() {
        return Arrays.toString(antallTegn);
    }
}
