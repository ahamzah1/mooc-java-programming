package ticTacToe;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TicTacToeApplication extends Application{
    private String currentPlayer;
    private Label label;
    boolean gameEnded;
    Button[][] buttons;
    
    @Override
    public void init() throws Exception{
        this.gameEnded = false;
        this.currentPlayer = "X";
        this.label = new Label("Turn: " + this.currentPlayer);
        this.buttons = new Button[3][3];
    }
    
    @Override
    public void start(Stage window){
        
        BorderPane layout = new BorderPane();
        GridPane layout_B = getView();
        
        layout.setTop(this.label);
        layout.setCenter(layout_B);
        Button button = new Button("reset");
        layout.setBottom(button);
        
        Scene scene = new Scene(layout);
        button.setOnAction((event)->{
            start(window);
        });
        window.setScene(scene);
        window.show();
        
    }
    
    public GridPane getView(){
        GridPane grid = new GridPane();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button(" ");
                button.setMinSize(100, 100);  


                grid.add(button, col, row);
                buttons[row][col] = button;

                
                int finalRow = row, finalCol = col;  
                button.setOnAction((event) -> handleButtonClick(finalRow, finalCol, button));

            }
        }    
        return grid;
    }
    
    private void handleButtonClick(int row, int col, Button button) {
        if (gameEnded || !button.getText().equals(" ")) return;  

        button.setText(this.currentPlayer);  // "X" or "O"
        if(checkWin(currentPlayer) || checkDraw()){
            label.setText("Game end");
            gameEnded = true;
            disableAllButtons();
        }
        else{
            this.currentPlayer = this.currentPlayer.equals("X") ? "O" : "X";
            this.label.setText("Turn: " + this.currentPlayer); 
        } 
        
    }
    
    private boolean checkWin(String player) {
       // Check rows and columns
       for (int i = 0; i < 3; i++) {
           if (buttons[i][0].getText().equals(player) &&
               buttons[i][1].getText().equals(player) &&
               buttons[i][2].getText().equals(player)) return true;

           if (buttons[0][i].getText().equals(player) &&
               buttons[1][i].getText().equals(player) &&
               buttons[2][i].getText().equals(player)) return true;
       }

       // Check diagonals
       if (buttons[0][0].getText().equals(player) &&
           buttons[1][1].getText().equals(player) &&
           buttons[2][2].getText().equals(player)) return true;

       if (buttons[0][2].getText().equals(player) &&
           buttons[1][1].getText().equals(player) &&
           buttons[2][0].getText().equals(player)) return true;

       return false;
   }

    private boolean checkDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().equals(" ")) {
                    return false; 
                }
            }
        }
        return true; 
    }
  
    
   private void disableAllButtons() {
       for (int row = 0; row < 3; row++) {
           for (int col = 0; col < 3; col++) {
               buttons[row][col].setDisable(true);
           }
       }
   }   

    
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
