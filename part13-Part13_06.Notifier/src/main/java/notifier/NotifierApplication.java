package notifier;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class NotifierApplication extends Application{
    
    @Override
    public void start(Stage window){
        TextField text = new TextField();
        Button button = new Button("Update");
        Label label = new Label("");
        
        button.setOnAction((event) -> {
            label.setText(text.getText());
        });
        
        VBox layout = new VBox();
        layout.getChildren().addAll(text,button,label);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
