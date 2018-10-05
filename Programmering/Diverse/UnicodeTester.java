import static javax.swing.JOptionPane.*;

class UnicodeTester {

    public static void main(String[]args) {

        String tekst = showInputDialog("tast inn tekst: ");

        for (int i = 0; i < tekst.length(); i++) {
            char tegn = tekst.charAt(i);
            int verdi = tegn;
            System.out.println("Unicode-verdien til tegnet " + tegn + " på posisjon " + i + " er " + verdi);
        }
    }
}
