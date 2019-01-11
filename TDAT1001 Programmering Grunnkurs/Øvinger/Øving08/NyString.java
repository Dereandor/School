/*
*   Programmeringsoppgave 1 side 283
*/

class NyString {

    private final String tekst;
    //private String nyTekst;

    public NyString(String tekst) {
        this.tekst = tekst;
    }

    public String getInitial() {
        String[] ord = tekst.split(" ");
        String initial = "";
        for (int i = 0; i < ord.length; i++) {
            String kort = ord[i];
            initial += kort.charAt(0);
        }
        return initial;
    }

    public String getPartial(String letter) {
        String nyTekst = tekst;
        int letterIndex = nyTekst.indexOf(letter);
        while (letterIndex != -1) {
            nyTekst = nyTekst.substring(0, letterIndex) + "" + nyTekst.substring(letterIndex + 1);
            letterIndex = nyTekst.indexOf(letter, letterIndex + 1 );
        }
        return nyTekst;
    }

}
