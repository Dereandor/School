/*
*   Programmeringsoppgave 1 side 283
*/

class NyString {

    private String tekst;

    public NyString(String tekst) {
        this.tekst = tekst;
    }

    public String getInit() {
        String[] ord = tekst.split(" ");
        String init = "";
        for (int i = 0; i < ord.length; i++) {
            String kort = ord[i];
            init += kort.charAt(0);
        }
        return init;
    }

    public String getPart(String letter) {
        int letterIndex = tekst.indexOf(letter);
        while (letterIndex != -1) {
            tekst = tekst.substring(0, letterIndex) + "" + tekst.substring(letterIndex + 1);
            letterIndex = tekst.indexOf(letter, letterIndex + 1 );
        }
        return tekst;

    }

}
