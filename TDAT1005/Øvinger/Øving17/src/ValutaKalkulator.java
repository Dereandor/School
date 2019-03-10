import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ValutaKalkulator extends Application implements EventHandler<ActionEvent> {
    private Valuta[] valutaliste = {
            new Valuta("Euro", 8.10, 1), new Valuta("US Dollar", 6.23, 1),
            new Valuta("Britiske pund", 12.27, 1), new Valuta("Svenske kroner", 88.96, 100),
            new Valuta("Danske kroner", 108.75, 100), new Valuta("Yen", 5.14, 100),
            new Valuta("Islandske kroner", 9.16, 100), new Valuta("Norske kroner", 100, 100)
    };

    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Valutakalkulator");
        button = new Button();
        button.setText("Click me");

        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button) {
            System.out.println("Text woop");
        }
    }
}
