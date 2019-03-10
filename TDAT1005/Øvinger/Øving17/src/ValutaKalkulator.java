import javafx.application.Application;
import javafx.stage.Stage;

public class ValutaKalkulator extends Application {
    private Valuta[] valutaliste = {
            new Valuta("Euro", 8.10, 1), new Valuta("US Dollar", 6.23, 1),
            new Valuta("Britiske pund", 12.27, 1), new Valuta("Svenske kroner", 88.96, 100),
            new Valuta("Danske kroner", 108.75, 100), new Valuta("Yen", 5.14, 100),
            new Valuta("Islandske kroner", 9.16, 100), new Valuta("Norske kroner", 100, 100)
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
