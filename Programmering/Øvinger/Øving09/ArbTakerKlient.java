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

        String[] options = new String[] {"Les Ansatt Info", "Endre Skatteprosent", "Endre Månedslønn",
        "Sjekk om ansatt lengre enn", "Cancel"};
        while (response < options.length) {
                response = showOptionDialog(null,
                "Venligst velg hva du vil gjøre: ", "Endringsmuligheter",
                DEFAULT_OPTION, PLAIN_MESSAGE,
                null, options, options[0]);

                System.out.println(response);


            if (response == 0) {
                showMessageDialog(null, "Navn: " + newEmployee.getNavn()
                + "\n Fødselsdato: " + newEmployee.getFdato()
                + "\n Alder: " + newEmployee.getAlder()
                + "\n Ansattnummer: " + newEmployee.getAnsattnummer()
                + "\n Ansettelsesår: " + newEmployee.getAnsettelse()
                + "\n Månedslønn brutto: " + newEmployee.getLonn()
                + "\n Skattetrekk måned: " + newEmployee.getSkattetrekkMnd()
                + "\n Skatteprosent: " + newEmployee.getSkatteprosent());
            } else if (response == 1) {
                int nySkatt = Integer.parseInt(showInputDialog("Nåværende skatteprosent: " + newEmployee.getSkatteprosent()
                + "\n Tast inn ny skatteprosent: "));
                newEmployee.setSkatteprosent(nySkatt);
            } else if (response == 2) {
                int nyLonn = Integer.parseInt(showInputDialog("Nåværende månedslønn: " + newEmployee.getLonn()
                + "\n Tast inn ny månedslønn: "));
                newEmployee.setManedslonn(nyLonn);
            } else if (response == 3) {
                int sjekkTall = Integer.parseInt(showInputDialog("Tast inn hvor lenge du vil sjekke om har vært ansatt: "));
                showMessageDialog(null, newEmployee.getAnsattLengreEnn(sjekkTall));
            } else {
                break;
            }
        }
    }
}
