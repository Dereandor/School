import java.awt.*;
import javax.swing.*;

class Vindu extends JFrame {
    public Vindu(String tittel) {
        setTitle(tittel);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Tegning tegningen = new Tegning();
        add(tegningen);
    }
}

class Tegning extends JPanel {
    public void paintComponent(Graphics tegneflate) {
        super.paintComponent(tegneflate);
        setBackground(Color.white);
        tegneflate.setColor(Color.red);
        tegneflate.drawOval(40, 30, 165, 85);
        tegneflate.setColor(Color.gray);
        tegneflate.drawString("Her er løsningen", 75, 75);
    }
}

class Oppg_10_1_1 {
    public static void main(String[]args) {
        Vindu etVindu = new Vindu("Oppgave 10.1.1");
        etVindu.setVisible(true);
    }
}
