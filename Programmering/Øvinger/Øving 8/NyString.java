/*
*   Programmeringsoppgave 1 side 283
*   Lag en klasse NyString, den skal ha en objektvariabel av klassen String.
*   Klassen NyString skal være immutabel og tilby følgende:
*
*   Konstruktør som tar et objekt av klassen String som argument.
*
*   Forkorting: det første tegnet i hvert ord skal plukkes ut, resultatet skal kunne hentes.
*   (tips, bruk split() som returnerer en tabell med ordene som teksten består av: String[] ord = tekst.split("");)
*
*   Fjerning av tegn. (Tips, bruk en while løkke og for eksempel String-metodene indexOf() og substring())
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
        String partial = tekst;

        return partial;

    }

}
