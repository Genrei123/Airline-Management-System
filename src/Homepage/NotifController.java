/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Homepage;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NotifController implements Initializable {

    @FXML
    private Pane starsPane;

    @FXML
    private JFXButton okBtn;

    @FXML
    private Label ticketNum;

    private HomepageController homepageController;

    private Stage notifStage;

    public void setHomepageController(HomepageController homepageController) {
        this.homepageController = homepageController;
    }

    public void notification() {
        // Close the current stage (Notif.fxml)
        Stage stage = (Stage) okBtn.getScene().getWindow();
        stage.close();

        // Call the method in HomepageController to switch to hf_searchDesti form
        if (homepageController != null) {
            homepageController.handleReturnToDestiButtonClick();
        }
    }

    @FXML
    private void initialize() {
        // Add initialization code if needed
    }

    @FXML
    private void handleOkBtnClick() {
        // Close the notifStage when the OK button is clicked
        notifStage.close();
    }

    // Getter and setter for notifStage
    public Stage getNotifStage() {
        return notifStage;
    }

    public void setNotifStage(Stage notifStage) {
        this.notifStage = notifStage;
    }

    //FOR HOMEPAGE STAR BG ANIMATION
    private void createTwinklingStars() {
        int numStars = 60;
        ParallelTransition parallelTransition = new ParallelTransition();

        for (int i = 0; i < numStars; i++) {
            Pane star = createStar();
            starsPane.getChildren().add(star);

            // Set a random initial position within the bounds of starsPane
            double initialX = Math.random() * (starsPane.getWidth() + 633);  // Adjusted to consider star size
            double initialY = Math.random() * (starsPane.getHeight() + 326); // Adjusted to consider star size
            star.setLayoutX(initialX);
            star.setLayoutY(initialY);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), star);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.setCycleCount(Animation.INDEFINITE);
            fadeTransition.setAutoReverse(true);

            // Add a random initial delay to each star
            Duration initialDelay = Duration.seconds(Math.random() * 5);
            fadeTransition.setDelay(initialDelay);

            parallelTransition.getChildren().add(fadeTransition);
        }

        parallelTransition.play();
    }

    private Pane createStar() {
        Pane star = new Pane();

        // Set a fixed size for the star, adjust as needed
        double starSize = new Random().nextInt(5) + 1;
        star.setPrefSize(starSize, starSize);

        star.setLayoutX(new Random().nextDouble() * starsPane.getPrefWidth());
        star.setLayoutY(new Random().nextDouble() * starsPane.getPrefHeight());

        // Set the background color and radius directly
        star.setStyle("-fx-background-color: white; -fx-background-radius: 50%;");

        star.setOpacity(1.0);

        return star;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        // Call the starsPane function during initialization
        createTwinklingStars();
        // Make the starsPane visible when the application is running
        starsPane.setVisible(true);
    }

}
