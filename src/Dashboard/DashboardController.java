package Dashboard;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private JFXButton dashboard_menu;

    @FXML
    private VBox dashboard_slider;

    @FXML
    private AnchorPane centerPane;

    private boolean isMenuVisible = true; // Initially, the menu is open

    private TranslateTransition centerSlide = new TranslateTransition();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Ensure the menu is initially open
        centerSlide.setDuration(Duration.seconds(0.4));
        centerSlide.setNode(centerPane);
        centerSlide.setToX(dashboard_slider.getWidth());

        // Play the animation initially (no transition)
        centerSlide.playFrom(centerSlide.getTotalDuration());

        dashboard_menu.setOnAction(actionEvent -> toggleAdminMenu());
    }

    private void toggleAdminMenu() {
        // Disable the button while the animation is in progress
        dashboard_menu.setDisable(true);

        if (isMenuVisible) {
            hideMenu();
        } else {
            showMenu();
        }
    }

    private void showMenu() {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(dashboard_slider);
        slide.setToX(0);

        // Set an event handler for when the animation is finished
        slide.setOnFinished(event -> {
            // Enable the button when the animation is complete
            dashboard_menu.setDisable(false);
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
        slide.setNode(dashboard_slider);
        slide.setToX(-dashboard_slider.getWidth());

        // Set an event handler for when the animation is finished
        slide.setOnFinished(event -> {
            // Enable the button when the animation is complete
            dashboard_menu.setDisable(false);
        });

        slide.play();

        centerSlide.setDuration(Duration.seconds(0.4));
        centerSlide.setNode(centerPane);
        centerSlide.setToX(-dashboard_slider.getWidth()); // Move centerPane to the left
        centerSlide.play();

        isMenuVisible = false;
    }

}
