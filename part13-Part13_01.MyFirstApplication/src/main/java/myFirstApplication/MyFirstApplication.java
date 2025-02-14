package myFirstApplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MyFirstApplication extends Application{
    
    @Override
    public void start(Stage window){
        Button button = new Button("This is a button");
        
        FlowPane comp = new FlowPane();
        comp.getChildren().add(button);
        
        Scene scene = new Scene(comp);
        window.setScene(scene);
        
        window.setTitle("My first application");
        window.show();
    }

    public static void main(String[] args) {
        launch(MyFirstApplication.class);
    }

}
