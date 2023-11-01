package Dashboard;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DashboardController implements Initializable {

    @FXML
    private AnchorPane topPane;

    @FXML
    private JFXButton dashboard_menu;

    @FXML
    private AnchorPane centerPane;

    @FXML
    private AnchorPane sales_form;

    @FXML
    private AnchorPane ticketRecords_form;

    @FXML
    private AnchorPane flightRecords_form;

    @FXML
    private AnchorPane bookedFlights_form;

    @FXML
    private TableView<?> bookedFlights_table;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private AnchorPane overlayPane;

    @FXML
    private AnchorPane dashboard_slider;

    @FXML
    private JFXButton dashboardForm_btn;

    @FXML
    private JFXButton bookedForm_btn;

    @FXML
    private JFXButton flightForm_btn;

    @FXML
    private JFXButton ticketForm_btn;

    @FXML
    private JFXButton salesForm_btn;

    @FXML
    private JFXButton logout_btn;

    private boolean isMenuVisible = false;
    private JFXButton currentSelectedButton;

    public void toggleAdminMenu() {
        if (isMenuVisible) {
            hideMenu();
        } else {
            showMenu();
        }
    }

    private void showMenu() {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.2));
        slide.setNode(dashboard_slider);
        slide.setToX(0);
        slide.play();

        isMenuVisible = true;

        overlayPane.setVisible(true);
        overlayPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");
    }

    private void hideMenu() {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.2));
        slide.setNode(dashboard_slider);
        slide.setToX(-dashboard_slider.getWidth());
        slide.play();

        isMenuVisible = false;

        overlayPane.setVisible(false);
    }

    public void logout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn/LoginPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Get the stage from the current button's scene
            Stage stage = (Stage) logout_btn.getScene().getWindow();

            // Set the minimum width and height for the Dashboard
            stage.setMinWidth(600);
            stage.setMinHeight(233);

            stage.setResizable(false); // Make it unresizable
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void switchForm(AnchorPane targetForm, JFXButton selectedButton) {
        // Hide all forms
        dashboard_form.setVisible(false);
        bookedFlights_form.setVisible(false);
        flightRecords_form.setVisible(false);
        ticketRecords_form.setVisible(false);
        sales_form.setVisible(false);

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
    public void initialize(URL url, ResourceBundle rb) {
        // Ensure the menu is initially closed
        dashboard_slider.setTranslateX(-210);
        overlayPane.setVisible(false);

        // Add event handlers to the overlayPane and topPane
        overlayPane.setOnMouseClicked(event -> {
            if (isMenuVisible) {
                hideMenu();
            }
        });

        topPane.setOnMouseClicked(event -> {
            if (isMenuVisible) {
                hideMenu();
            }
        });

        // Set the dashboard_form as the default visible form
        dashboard_form.setVisible(true);

        // Apply the selected-button style to the dashboardForm_btn
        dashboardForm_btn.getStyleClass().add("selected-button");

        // Create a reference to the currently selected button
        currentSelectedButton = dashboardForm_btn;

        // Add button click event handlers
        dashboardForm_btn.setOnAction(e -> switchForm(dashboard_form, dashboardForm_btn));
        bookedForm_btn.setOnAction(e -> switchForm(bookedFlights_form, bookedForm_btn));
        flightForm_btn.setOnAction(e -> switchForm(flightRecords_form, flightForm_btn));
        ticketForm_btn.setOnAction(e -> switchForm(ticketRecords_form, ticketForm_btn));
        salesForm_btn.setOnAction(e -> switchForm(sales_form, salesForm_btn));

    }
}
