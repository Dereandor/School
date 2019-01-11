import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Vindu extends JFrame {

    public Vindu(String tittel) {

        setTitle(tittel);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Tegning tegningen = new Tegning();
        add(tegningen);
    }
}

class Tegning extends JPanel {

    public void paintComponent(Graphics tegneflate) {

        super.paintComponent(tegneflate);
        setBackground(Color.RED);
        tegneflate.setColor(Color.YELLOW);
        tegneflate.fillOval(30, 30, 300, 300);
        tegneflate.setColor(Color.BLACK);
        tegneflate.fillOval(90, 120, 40, 40);
        tegneflate.setColor(Color.BLACK);
        tegneflate.fillOval(230, 120, 40, 40);
        tegneflate.setColor(Color.BLACK);
        tegneflate.fillArc(90, 170, 180, 120, 180, 180);
    }
}


class Smiley {

    public static void main(String[]args) {

        Vindu etVindu = new Vindu("Smiley");
        etVindu.setVisible(true);
    }
}
