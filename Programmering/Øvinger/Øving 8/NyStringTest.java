class NyStringTest {

    public static void main(String[]args) {

        NyString tekst = new NyString("Dette er en test");

        String init = tekst.getInit();
        System.out.println("Forbokstaver: " + init);

        String part = tekst.getPart("e");
        System.out.println("Bokstav fjernet: " + part);
    }
}
