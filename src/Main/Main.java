/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Ervhyne
 */
public class Main extends Application {

    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/LogIn/LoginPage.fxml"));
        Image icon = new Image(getClass().getResourceAsStream("/Images/anyapfp.jpg"));
        stage.getIcons().add(icon);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Login Page"); // Set a title for your window
        stage.setResizable(false); // Make it unresizable
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
