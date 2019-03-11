import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ValutaKalkulator extends Application {
    private Valuta[] valutaliste = {
            new Valuta("Euro", 8.10, 1), new Valuta("US Dollar", 6.23, 1),
            new Valuta("Britiske pund", 12.27, 1), new Valuta("Svenske kroner", 88.96, 100),
            new Valuta("Danske kroner", 108.75, 100), new Valuta("Yen", 5.14, 100),
            new Valuta("Islandske kroner", 9.16, 100), new Valuta("Norske kroner", 100, 100)
    };

    Button button;
    Stage window;
    Scene scene1;
    ListView<String> listFrom;
    ListView<String> listTo;
    TextField inputbox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Valutakalkulator");
        button = new Button("Convert");

        listFrom = new ListView<>();
        for (int i = 0; i <valutaliste.length; i++) {
            listFrom.getItems().add(valutaliste[i].getName());
        }
        listTo = new ListView<>();
        for (int i = 0; i < valutaliste.length; i++) {
            listTo.getItems().add(valutaliste[i].getName());
        }
        listFrom.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listTo.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        listFrom.setPrefWidth(100);
        listFrom.setPrefHeight(100);
        listTo.setPrefWidth(100);
        listTo.setPrefHeight(100);

        Text from = new Text();
        from.setText("From: ");
        Text to = new Text();
        to.setText("To: ");

        inputbox = new TextField();


        button.setOnAction(e -> buttonClicked());

        VBox fromList = new VBox(10);
        fromList.setPadding(new Insets(20, 20, 20, 20));
        fromList.getChildren().addAll(from, listFrom, to, listTo, inputbox, button);

        scene1 = new Scene(fromList, 400, 350);
        window.setScene(scene1);
        window.show();
    }

    private void buttonClicked(){

        double convertFrom = valutaliste[listFrom.getSelectionModel().getSelectedIndex()].beregnTilNOK(Integer.parseInt(inputbox.getText()));
        double convertTo = valutaliste[listTo.getSelectionModel().getSelectedIndex()].beregnFraNOK(convertFrom);

        System.out.println(convertFrom + " " + valutaliste[listFrom.getSelectionModel().getSelectedIndex()].getName());
        System.out.println(convertTo + " " + valutaliste[listTo.getSelectionModel().getSelectedIndex()].getName());


    }

}
