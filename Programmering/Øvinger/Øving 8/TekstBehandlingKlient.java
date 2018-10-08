class TekstBehandlingKlient {

    public static void main(String[]args){

        TekstBehandling tekst = new TekstBehandling("Dette er en test tekst! Den skal teste programmet.");

        int words = tekst.getCount();
        System.out.println("Antall ord i teksten: " + words);

        double avg = tekst.getAvg();
        System.out.println("Gjennomsnittlig ordlengde er: " + avg);

        double avgPer = tekst.getPeriod();
        System.out.println("Gjennomsnittling antall ord per periode er: " + avgPer);

        String replace = tekst.getReplace("tekst", "fil");
        System.out.println("Resultatet av utskiftingen er: " + replace);

        System.out.println("Teksten er: " + tekst.getText());

        System.out.println("Teksten med store bokstaver er: " + tekst.getUpper());
    }
}
