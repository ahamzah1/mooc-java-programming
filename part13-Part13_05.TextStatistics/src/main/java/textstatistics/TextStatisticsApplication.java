package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TextStatisticsApplication extends Application{

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        HBox texts = new HBox();
        texts.setSpacing(10);
        texts.getChildren().add(new Label("Letters: 0"));
        texts.getChildren().add(new Label("Words: 0"));
        texts.getChildren().add(new Label("The longest word is:"));

        layout.setBottom(texts);

        layout.setCenter(new TextArea(""));

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
}
