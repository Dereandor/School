
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame{

    // Vanlig å ha GUI-komponenter som objektvariabler
    private JButton myButton = new JButton("Trykk her!");
    private JButton myOtherButton = new JButton("Nei, trykk her!");
    private JLabel myLabel = new JLabel("Foreløpig tomt");
    private JTextField myTextField = new JTextField(20);

    public MyWindow () {
        // Set title
        setTitle("Mitt første vindu");
        // To close the window ends the program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // layoutmanager:
        LayoutManager layout = new FlowLayout();
        setLayout(layout);
        // add shortcuts
        myButton.setMnemonic(KeyEvent.VK_U);
        myOtherButton.setMnemonic(KeyEvent.VK_L);
        // Add components
        add(myButton);
        add(myOtherButton);
        add(myLabel);
        add(myTextField);
        pack();
        // Make and register button listener
        ButtonListener theListener = new ButtonListener();
        myButton.addActionListener(theListener);
        myOtherButton.addActionListener(theListener);
    }

    // Knappelytter er nå en indre klasse:
    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent theEvent){
            String command = theEvent.getActionCommand();
            String text = myTextField.getText();
            JButton theButton = (JButton) theEvent.getSource();
            if (theButton == myButton) {
                text = text.toUpperCase();
            } else {
                text = text.toLowerCase();
            }
            myLabel.setText(text);
            System.out.println(command);
        }
    }
}

class Oppgave3 {
    public static void main(String[] args) {
        MyWindow aWindow = new MyWindow();
        aWindow.setVisible(true);
    }
}