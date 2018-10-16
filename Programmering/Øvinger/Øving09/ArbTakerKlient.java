import static javax.swing.JOptionPane.*;

class ArbTakerKlient {

    public static void main(String[]args) {

        Person nyPerson = new Person("Ole", "Olsen", 1988);
        Person nyperson2 = new Person("Knut", "Knutsen", 1985);

        ArbTaker nyArbtaker = new ArbTaker(nyPerson, 1245, 2003, 30000, 36);
        ArbTaker nyArbtaker2 = new ArbTaker(nyperson2, 1234, 2002, 35000, 36);

        System.out.println(nyArbtaker);
        System.out.println(nyArbtaker2);

        String[] options = new String[] {"LesInfo", "EndreSkatteprosent", "EndreMånedslønn", "Cancel"};
        int response = showOptionDialog(null,
            "Venligst velg hva du vil gjøre: ", "Endringsmuligheter",
            DEFAULT_OPTION, PLAIN_MESSAGE,
            null, options, options[0]);

    }
}
