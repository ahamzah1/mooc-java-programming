package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application{

    @Override
    public void start(Stage window){
        window.setTitle("Button and label");
        
        Button button = new Button("Button");
        TextField label = new TextField();
        
        FlowPane comp = new FlowPane();
        comp.getChildren().add(button);
        comp.getChildren().add(label);
        Scene scene = new Scene(comp);
        
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

}
