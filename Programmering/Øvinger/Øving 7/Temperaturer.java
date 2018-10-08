/*
*   Programmeringsoppgave 2 side 314
*/
import java.util.Random;

class Temperaturer {

    private int[][] temperatur;
    private String navn;

    Random tall = new Random();

    public Temperaturer(String navn, int dager, int timer){
        this.navn = navn;
        this.temperatur = new int[dager][timer];
        setTemp(timer);
    }

    public void setTemp(int timer) {
        for(int i = 0; i < ; i++) {
            int temp = tall.nextInt(25);
            temp -= 10;

        }
    }
    //middeltemperatur for hver dag i måneden
}
