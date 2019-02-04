
import java.time.LocalDate;

class TestMedlemsarkiv {

    public static void main(String[] args) {
        Medlemsarkiv medl = new Medlemsarkiv();

        Personalia ole = new Personalia("Ole", "Olsen", "ole@dot.com", "ole1");
        Personalia truls = new Personalia("Truls", "Trulsen", "truls@dot.com", "truls2");

        System.out.println("Lager medlemmer");
        int olesNr = medl.nyMedlem(ole, LocalDate.of(2009, 10, 15));
        medl.registrerPoeng(olesNr, 25000);

        int trulsNr = medl.nyMedlem(truls, LocalDate.of(2018, 7, 16));
        medl.registrerPoeng(trulsNr, 75000);

        System.out.println("Antall Tester: 5");

        Personalia ivar = new Personalia("Ivar", "iversen", "ivar@dot.com", "ivar3");
        int ivarsNr = medl.nyMedlem(ivar, LocalDate.now());
        System.out.println("Test 1: " + ivarsNr );

        System.out.println("Test 2: " + medl.registrerPoeng(ivarsNr, 25000));

        System.out.println("Test 3: " + medl.finnPoeng(ivarsNr, "ivar3"));

        System.out.println("Test 4 : " + medl.toString());

        medl.sjekkMedlemmer();

        System.out.println("Test 5: " + medl.toString());
    }
}
