package Animations;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class SwitchForms {

    Stage currentStage;
    Stage nextStage;

    public void Logout(Stage currentStage) throws IOException {
        currentStage.close();
        // Setup Login Stage
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn/LoginPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage Login = new Stage();
        Login.setScene(scene);
        Login.setTitle("Login Page"); // Set a title for your window

        Image icon = new Image(getClass().getResourceAsStream("/Images/anyapfp.jpg"));
        Login.getIcons().add(icon);

        Login.setOnShown(event -> {
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            Login.setX((primScreenBounds.getWidth() - Login.getWidth()) / 2);
            Login.setY((primScreenBounds.getHeight() - Login.getHeight()) / 2);
        });

        Login.show();
    }



    public void Link(Stage currentStage, String toLink) throws IOException {
        currentStage.close();

        StringBuilder nextStageName = new StringBuilder("/" + toLink + "/" + toLink + ".fxml");

        Parent root = FXMLLoader.load(getClass().getResource(nextStageName.toString()));
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setOnShown(event -> {
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
        });

        Image icon = new Image(getClass().getResourceAsStream("/Images/anyapfp.jpg"));
        stage.getIcons().add(icon);
        stage.setTitle(toLink); // Set a title for your window
        stage.setResizable(false); // Make it resizable
        stage.setScene(scene);
        // TO SHOW THE DASHBOARD FORM
        stage.show();

        // Set the minimum width and height for the Dashboard
        stage.setMinWidth(800);
        stage.setMinHeight(600);
    }
}
