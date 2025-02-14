package buttonandlabel;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ButtonAndLabelApplication extends Application{

    @Override
    public void start(Stage window){
        window.setTitle("Button and label");
        
        Button button = new Button("Button");
        Label label = new Label("Label");
        
        FlowPane comp = new FlowPane();
        comp.getChildren().add(button);
        comp.getChildren().add(label);
        Scene scene = new Scene(comp);
        
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
