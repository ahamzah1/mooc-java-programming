package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MultipleViews extends  Application{

    
    @Override
    public void start(Stage window){
        BorderPane layout_first = new BorderPane();
        VBox layout_second = new VBox();
        GridPane layout_third = new GridPane();
        Scene first = new Scene(layout_first);
        Scene second = new Scene(layout_second);
        Scene third = new Scene(layout_third);
        
        Button button = new Button("To the second view!");
        button.setOnAction((event)->{
            window.setScene(second);
        });
        
        layout_first.setTop(new Label("First view!"));
        layout_first.setCenter(button);
        
        Button button_2 = new Button("To the third view!");
        button_2.setOnAction((event)->{
            window.setScene(third);
        });
        layout_second.getChildren().addAll(button_2,new Label("Second view!"));
        
        Button button_3 = new Button("To the first view!");
        button_3.setOnAction((event)->{
            window.setScene(first);
        });
        layout_third.add(new Label("Third view!"),0,0);
        layout_third.add(button_3,1,1);
        
        window.setScene(first);
        window.show();
        
        
    }
    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
