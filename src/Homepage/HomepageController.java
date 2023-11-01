/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Homepage;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static oracle.net.aso.C05.e;

/**
 *
 * @author Ervhyne
 */
public class HomepageController implements Initializable{

    @FXML
    private JFXButton menuOpen;

    @FXML
    private JFXButton menuClose;

    @FXML
    private VBox menuPanel;

    @FXML
    private AnchorPane centerPane;

    private boolean isMenuVisible = true; // Initially, the menu is open

    private TranslateTransition centerSlide = new TranslateTransition();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Ensure the menu is initially open
        centerSlide.setDuration(Duration.seconds(0.4));
        centerSlide.setNode(centerPane);
        centerSlide.setToX(menuPanel.getWidth());

        // Play the animation initially (no transition)
        centerSlide.playFrom(centerSlide.getTotalDuration());

        menuOpen.setOnAction(actionEvent -> toggleAdminMenu());
    }

    private void toggleAdminMenu() {
        // Disable the button while the animation is in progress
        menuOpen.setDisable(true);

        if (isMenuVisible) {
            hideMenu();
        } else {
            showMenu();
        }
    }

    private void showMenu() {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(menuPanel);
        slide.setToX(0);

        // Set an event handler for when the animation is finished
        slide.setOnFinished(event -> {
            // Enable the button when the animation is complete
            menuOpen.setDisable(false);
        });

        slide.play();

        centerSlide.setDuration(Duration.seconds(0.4));
        centerSlide.setNode(centerPane);
        centerSlide.setToX(0); // Keep centerPane in its initial position
        centerSlide.play();

        isMenuVisible = true;
    }

    private void hideMenu() {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(menuPanel);
        slide.setToX(-menuPanel.getWidth());

        // Set an event handler for when the animation is finished
        slide.setOnFinished(event -> {
            // Enable the button when the animation is complete
            menuOpen.setDisable(false);
        });

        slide.play();

        centerSlide.setDuration(Duration.seconds(0.4));
        centerSlide.setNode(centerPane);
        centerSlide.setToX(-menuPanel.getWidth()); // Move centerPane to the left
        centerSlide.play();

        isMenuVisible = false;
    }

}
