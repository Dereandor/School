
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame{

    // Vanlig å ha GUI-komponenter som objektvariabler, fjerner fra konstruktør
    private JButton myButton = new JButton("Trykk her!");

    public MyWindow () {
        // Set title
        setTitle("Mitt første vindu");
        // To close the window ends the program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add button
        add(myButton);
        // Make and register button listener
        ButtonListener theListener = new ButtonListener();
        myButton.addActionListener(theListener);
    }

    // Knappelytter er nå en indre klasse:
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent theEvent){
            // Finner knappen som ble trykket på
            // Trenger ikke neste linje lenger, indre klasser har
            // direkte tilgang til medlemmer:
            // JButton myButton = (JButton) hendelse.getSource();
            // Endrer farge på knappen

            Color myColor = myButton.getForeground();
            if (myColor.equals(Color.RED)) {
                myButton.setForeground(Color.BLUE);
            } else {
                myButton.setForeground(Color.RED);
            }
            System.out.println("Du trykket på knappen!");
        }
    }
}

class OppgaveIndreKlasse {
    public static void main(String[] args) {
        MyWindow aWindow = new MyWindow();
        aWindow.setVisible(true);
    }
}