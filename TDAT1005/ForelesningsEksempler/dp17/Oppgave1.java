import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame{

    public MyWindow () {
        // Set title
        setTitle("Mitt første vindu");
        // To close the window ends the program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add button
        JButton myButton = new JButton("Trykk her!");
        add(myButton);
        // Make and register button listener
        ButtonListener theListener = new ButtonListener();
        myButton.addActionListener(theListener);
    }
}

class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent theEvent){
        // Finner knappen som ble trykket på
        JButton theButton = (JButton) theEvent.getSource();
        // Endrer farge på knappen
        Color myColor = theButton.getForeground();
        if (myColor.equals(Color.RED)) {
            theButton.setForeground(Color.BLUE);
        } else {
            theButton.setForeground(Color.RED);
        }
        System.out.println("Du trykket på knappen!");
    }
}

class Oppgave1 {
    public static void main(String[] args) {
        MyWindow aWindow = new MyWindow();
        aWindow.setVisible(true);
    }
}