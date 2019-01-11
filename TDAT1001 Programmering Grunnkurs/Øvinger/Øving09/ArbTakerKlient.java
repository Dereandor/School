import static javax.swing.JOptionPane.*;

class ArbTakerKlient {

    public static void main(String[]args) {
        int response = 0;

        Person newPerson = new Person("Ole", "Olsen", 1988);
        Person newPerson2 = new Person("Knut", "Knutsen", 1985);

        ArbTaker newEmployee = new ArbTaker(newPerson, 1245, 2003, 30000, 36);
        ArbTaker newEmployee2 = new ArbTaker(newPerson2, 1234, 2002, 35000, 36);

        System.out.println(newEmployee);
        System.out.println(newEmployee2);

        String[] options = new String[] {"Les Ansatt Info", "Endre Skatteprosent", "Endre M�nedsl�nn",
        "Sjekk om ansatt lengre enn", "Cancel"};
        while (response < options.length) {
                response = showOptionDialog(null,
                "Venligst velg hva du vil gj�re: ", "Endringsmuligheter",
                DEFAULT_OPTION, PLAIN_MESSAGE,
                null, options, options[0]);

                System.out.println(response);


            if (response == 0) {
                showMessageDialog(null, "Navn: " + newEmployee.getNavn()
                + "\n F�dselsdato: " + newEmployee.getFdato()
                + "\n Alder: " + newEmployee.getAlder()
                + "\n Ansattnummer: " + newEmployee.getAnsattnummer()
                + "\n Ansettelses�r: " + newEmployee.getAnsettelse()
                + "\n M�nedsl�nn brutto: " + newEmployee.getLonn()
                + "\n Skattetrekk m�ned: " + newEmployee.getSkattetrekkMnd()
                + "\n Skatteprosent: " + newEmployee.getSkatteprosent());
            } else if (response == 1) {
                int nySkatt = Integer.parseInt(showInputDialog("N�v�rende skatteprosent: " + newEmployee.getSkatteprosent()
                + "\n Tast inn ny skatteprosent: "));
                newEmployee.setSkatteprosent(nySkatt);
            } else if (response == 2) {
                int nyLonn = Integer.parseInt(showInputDialog("N�v�rende m�nedsl�nn: " + newEmployee.getLonn()
                + "\n Tast inn ny m�nedsl�nn: "));
                newEmployee.setManedslonn(nyLonn);
            } else if (response == 3) {
                int sjekkTall = Integer.parseInt(showInputDialog("Tast inn hvor lenge du vil sjekke om har v�rt ansatt: "));
                showMessageDialog(null, newEmployee.getAnsattLengreEnn(sjekkTall));
            } else {
                break;
            }
        }
    }
}
