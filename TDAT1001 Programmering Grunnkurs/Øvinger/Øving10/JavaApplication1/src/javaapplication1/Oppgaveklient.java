/*
*   Klient for Oppgaveoversikt.java
*/

import static javax.swing.JOptionPane.*;
import java.util.Arrays;

class Oppgaveklient {

    public static void main(String[]args) {

        int response = 0;

        Oppgaveoversikt test = new Oppgaveoversikt();
        test.newStudent("test tester");
        test.newStudent("test tester2");
        test.newStudent("test tester3");

        String[] options = new String[] {"Les Antall Studenter", "Øk oppgaver", "Søk spesifikk student",
        "Legg til ny student", "Avslutt"};
        while (response < options.length) {
                response = showOptionDialog(null,
                "Venligst velg hva du vil gjøre: ", "Endringsmuligheter",
                DEFAULT_OPTION, PLAIN_MESSAGE, null, options, options[0]);

            System.out.println(response);

            if (response == 0) {
                //legg inn lesing av student info
                showMessageDialog(null, test.getStudents());
            } else if (response == 1) {
                //legg inn øking av oppgaver
                int studNum = Integer.parseInt(showInputDialog("Tast inn Studentnummer: "));
                int studTasks = Integer.parseInt(showInputDialog("Tast inn antall øvinger godkjent: "));
                test.increaseTasks(studNum, studTasks);
                showMessageDialog(null, test.getStudentDone(studNum));
            } else if (response == 2) {
                //legg inn søking etter spesifikk student
                test.getStudent(Integer.parseInt(showInputDialog("Tast inn studentnummer: ")));
            } else if (response == 3) {
                //legg inn ny student funksjon
                test.newStudent(showInputDialog("Tast inn student navn: "));
            } else {
                break;
            }
        }
    }
}
