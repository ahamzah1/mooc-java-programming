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
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TextStatisticsApplication extends Application{

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        Label label1 = new Label("Letters: 0");
        Label label2 = new Label("Words: 0");
        Label label3 = new Label("The longest word is:");
        TextArea text = new TextArea("");
        text.textProperty().addListener((change,oldValue,newValue) ->{
            ArrayList<String> parts = new ArrayList<>(Arrays.asList(newValue.split(" ")));
            label1.setText("Letters: " + newValue.length());
            label2.setText("Words: " + parts.size());
            label3.setText("The longest word is: " + parts.stream().sorted((p1,p2)-> p2.length() - p1.length()).findFirst().get());
        });

        HBox texts = new HBox();
        texts.setSpacing(10);
        texts.getChildren().add(label1);
        texts.getChildren().add(label2);
        texts.getChildren().add(label3);

        layout.setBottom(texts);

        layout.setCenter(text);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
}
