class Oppgave365{

    public static void main(String[]args) {

        int tall1 = 3;
        int tall2 = 4;
        System.out.println("Før: " + tall1 + " " + tall2);

        int hjelp = tall1;
        tall1 = tall2;
        tall2 = hjelp;
        System.out.println("Etter: " + tall1 + " " + tall2);

        ToysOgTull etObjekt = new ToysOgTull();
        int a = 10;
        int b = 4;
        System.out.println("Før: " + a + " " + b);
        etObjekt.byttOmTall(a, b);
        System.out.println("Etter: " + a + " " + b);

        Navn navn1 = new Navn("Ole", "Olsen");
        Navn navn2 = new Navn("Kari", "Karidotter");

        etObjekt.byttOmObjekter1(navn1, navn2);
        System.out.println("A " + navn1 + " " + navn2);

        etObjekt.byttOmObjekter2(navn1, navn2);
        System.out.println("B " + navn1 + " " + navn2);

        etObjekt.byttOmObjekter3(navn1, navn2);
        System.out.println("C " + navn1 + " " + navn2);
    }
}

class ToysOgTull {

    public void byttOmTall(int t1, int t2) {
        int hjelp = t1;
        t1 = t2;
        t2 = hjelp;
    }

    public void byttOmObjekter1(Navn f1, Navn f2) {
        Navn hjelp = f1;
        f1 = f2;
        f2 = hjelp;
    }

    public void byttOmObjekter2(Navn f1, Navn f2) {
        Navn hjelp = new Navn(f1.getFornavn(), f1.getEtternavn());
        f1 = new Navn(f2.getFornavn(), f2.getEtternavn());
        f2 = hjelp;
    }

    public void byttOmObjekter3(Navn f1, Navn f2) {
        String fnavn = f1.getFornavn();
        String enavn = f1.getEtternavn();
        f1.setEtternavn(f2.getEtternavn());
        f1.setFornavn(f2.getFornavn());

        f2.setFornavn(fnavn);
        f2.setEtternavn(enavn);
    }
}
