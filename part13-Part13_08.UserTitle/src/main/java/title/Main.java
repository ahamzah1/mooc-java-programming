package title;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter a title:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String inp = "--title="+input;
        
        Application.launch(UserTitle.class,inp);
        

    }

}
