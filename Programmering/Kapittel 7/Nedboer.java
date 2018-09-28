import static javax.swing.JOptionPane.*;

class Nedboer {
    public static void main(String[]args) {
        final int ANT_DG = 7;

        int[] dager = new int[ANT_DG];
        for (int i = 0; i < dager.length; i++) {
            String tallLest = showInputDialog("Nedbør på dag nr " + (i + 1) + ": ");
            dager[i] = Integer.parseInt(tallLest);
        }

        int antDgUtenNedboer = 0;
        for (int i = 0; i < dager.length; i++) {
            if(dager[i] == 0) {
                antDgUtenNedboer++;
            }
        }

        int total = 0;
        for (int i = 0; i < dager.length; i++) {
            total += dager[i];
        }

        showMessageDialog(null, "Antall dager uten nedbør: " + antDgUtenNedboer + "\n" + "Total nedbør: " + total);
    }
}
