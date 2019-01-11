class NyStringTest {

    public static void main(String[]args) {

        NyString tekst = new NyString("Dette er en test");

        String initial = tekst.getInitial();
        System.out.println("Forbokstaver: " + initial);

        String partial = tekst.getPartial("e");
        System.out.println("Bokstav fjernet: " + partial);
    }
}
