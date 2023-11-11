/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Homepage;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Ervhyne
 */
public class HomepageController implements Initializable {

    @FXML
    private AnchorPane topPane;

    @FXML
    private AnchorPane centrePane;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Pane starsPane;

    @FXML
    private AnchorPane hf_home;

    @FXML
    private JFXButton cheapestFlights_btn;

    @FXML
    private JFXButton bookFlight_btn;

    @FXML
    private AnchorPane hf_searchDesti;

    @FXML
    private Label promptLabel1;

    @FXML
    private Label promptLabel2;

    @FXML
    private TextField searchTextField;

    @FXML
    private AnchorPane flightStats_form;

    @FXML
    private AnchorPane whereWeFly_form;

    @FXML
    private AnchorPane account_form;

    @FXML
    private AnchorPane top_form;

    @FXML
    private AnchorPane aboutUs_form;

    @FXML
    private AnchorPane menuSlider;

    @FXML
    private JFXButton menu_home;

    @FXML
    private JFXButton menu_flightStats;

    @FXML
    private JFXButton menu_whereWeFly;

    @FXML
    private JFXButton menu_account;

    @FXML
    private JFXButton menu_TOP;

    @FXML
    private JFXButton menu_aboutUs;

    @FXML
    private JFXButton menu_logout;

    @FXML
    private JFXButton menuBtn;

    @FXML
    private Label antonFont;

    private boolean menuOpen = false;

    private double defaultSliderWidth = 232;
    private double defaultSliderHeight = 43;

    // Create a reference to the currently selected button
    private JFXButton currentSelectedButton;

    //MENU BAR SLIDER FUNCTION AND ANIMATION
    public void toggleMenuSlider() {
        if (menuOpen) {
            closeMenuSlider();
        } else {
            openMenuSlider();
        }
    }

    private void openMenuSlider() {
        // Define the animation for opening the menu slider
        TranslateTransition openTransition = new TranslateTransition(Duration.millis(300), menuSlider);
        openTransition.setToX(0);
        openTransition.play();

        // Update the menuOpen flag
        menuOpen = true;
    }

    private void closeMenuSlider() {
        // Set the height explicitly
        menuSlider.setPrefHeight(defaultSliderHeight);

        // Define the animation for closing the menu slider
        TranslateTransition closeTransition = new TranslateTransition(Duration.millis(300), menuSlider);
        closeTransition.setToX(-defaultSliderWidth);
        closeTransition.play();

        // Update the menuOpen flag
        menuOpen = false;
    }

    //LOG OUT FUNCTION
    public void logout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn/LoginPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage currentStage = (Stage) menu_logout.getScene().getWindow();
            currentStage.setScene(scene);
            currentStage.setTitle("Login Page"); // Set a title for your window

            // Center the login window on the primary screen
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            currentStage.setX((primScreenBounds.getWidth() - currentStage.getWidth()) / 2);
            currentStage.setY((primScreenBounds.getHeight() - currentStage.getHeight()) / 2);

            currentStage.setMinWidth(600);
            currentStage.setMinHeight(233);
            currentStage.setResizable(false); // Make it unresizable

            currentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //FOR HOMEPAGE STAR BG ANIMATION
    private void createTwinklingStars() {
        int numStars = 60;
        ParallelTransition parallelTransition = new ParallelTransition();

        for (int i = 0; i < numStars; i++) {
            Pane star = createStar();
            starsPane.getChildren().add(star);

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

    @FXML
    private void switchToForm(ActionEvent event) {
        JFXButton selectedButton = (JFXButton) event.getSource();
        AnchorPane targetForm = null;

        // Determine the target form based on the selected button
        if (selectedButton == menu_home) {
            targetForm = home_form;
        } else if (selectedButton == menu_flightStats) {
            targetForm = flightStats_form;
        } else if (selectedButton == menu_whereWeFly) {
            targetForm = whereWeFly_form;
        } else if (selectedButton == menu_account) {
            targetForm = account_form;
        } else if (selectedButton == menu_TOP) {
            targetForm = top_form;
        } else if (selectedButton == menu_aboutUs) {
            targetForm = aboutUs_form;
        }

        if (targetForm != null) {
            switchForm(targetForm, selectedButton);
        }
    }

    private void switchForm(AnchorPane targetForm, JFXButton selectedButton) {
        // Hide all forms
        home_form.setVisible(false);
        flightStats_form.setVisible(false);
        whereWeFly_form.setVisible(false);
        account_form.setVisible(false);
        top_form.setVisible(false);
        aboutUs_form.setVisible(false);

        // Show the selected form
        targetForm.setVisible(true);

        // Update button styles
        if (currentSelectedButton != null) {
            currentSelectedButton.getStyleClass().remove("selected-button");
        }

        currentSelectedButton = selectedButton;
        currentSelectedButton.getStyleClass().add("selected-button");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the menu slider in the closed state
        closeMenuSlider();

        // Make the starsPane visible when the application is running
        starsPane.setVisible(true);

        createTwinklingStars();

        // Initially, set the labels to be visible
        promptLabel1.setVisible(true);
        promptLabel2.setVisible(true);

        // Add focus event handler to hide labels when TextField is focused
        searchTextField.setOnMouseClicked(e -> {
            promptLabel1.setVisible(false);
            promptLabel2.setVisible(false);
        });

        // Add focus event handler to show labels when TextField loses focus and is empty
        searchTextField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && searchTextField.getText().isEmpty()) {
                promptLabel1.setVisible(true);
                promptLabel2.setVisible(true);
            }
        });

        // Add text change event handler to hide labels when text is entered
        searchTextField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.isEmpty()) {
                promptLabel1.setVisible(false);
                promptLabel2.setVisible(false);
            }
        });
    }
}
