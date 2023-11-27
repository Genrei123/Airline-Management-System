package Homepage;
import javafx.scene.control.TextField;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PaymentController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane topPane;

    @FXML
    private Pane starsPane;

    @FXML
    private JFXButton closeButton;

    @FXML
    private AnchorPane paymentForms;

    @FXML
    private JFXButton cardBtn;

    @FXML
    private JFXButton payPalBtn;

    @FXML
    private JFXButton gcashBtn;

    @FXML
    private AnchorPane cardForm;

    @FXML
    private ScrollPane c_form1;

    @FXML
    private JFXTextField cardNumber;

    @FXML
    private JFXTextField expirationDate;

    @FXML
    private JFXTextField securityCode;

    @FXML
    private JFXTextField cardOwner;

    @FXML
    private JFXButton c_nextBtn1;

    @FXML
    private JFXButton c_backBtn1;

    @FXML
    private ScrollPane c_form2;

    @FXML
    private JFXComboBox<String> c_country;

    @FXML
    private JFXTextField c_name;

    @FXML
    private JFXTextField c_address1;

    @FXML
    private JFXTextField c_address2;

    @FXML
    private JFXTextField c_city;

    @FXML
    private JFXTextField c_state;

    @FXML
    private JFXTextField c_postalCode;

    @FXML
    private JFXButton c_nextBtn2;

    @FXML
    private JFXButton c_backBtn2;

    @FXML
    private AnchorPane gcashForm;

    @FXML
    private ScrollPane g_form1;

    @FXML
    private JFXComboBox<String> g_country;

    @FXML
    private JFXTextField g_name;

    @FXML
    private JFXTextField g_address1;

    @FXML
    private JFXTextField g_address2;

    @FXML
    private JFXTextField g_city;

    @FXML
    private JFXTextField g_state;

    @FXML
    private JFXTextField g_postalCode;

    @FXML
    private JFXButton g_nextBtn;

    @FXML
    private JFXButton g_backBtn;

    @FXML
    private AnchorPane paypalForm;

    @FXML
    private JFXTextField p_phoneNumber;

    @FXML
    private JFXButton p_nextBtn;

    @FXML
    private JFXButton p_backBtn;

    private HomepageController homepageController;
    private TextField fName;
    private TextField mName;
    private TextField lName;
    private TextField suffix;
    private TextField age;
    private TextField birthDate;
    private TextField destination;
    private TextField origin;
    private TextField sClass;
    private TextField modePayment;
    private TextField flightNo;

    public void setHomepageController(HomepageController homepageController) {
        this.homepageController = homepageController;
    }

    //FOR HOMEPAGE STAR BG ANIMATION
    private void createTwinklingStars() {
        int numStars = 35;
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

    //SWITCH FORM FUNCTIONS FOR home_form
    private void switchForm(AnchorPane targetForm, JFXButton selectedButton) {
        cardForm.setVisible(false);
        gcashForm.setVisible(false);
        paypalForm.setVisible(false);
        // Show the selected form
        targetForm.setVisible(true);
    }

    //SWITCH FORM FUNCTIONS FOR home_form
    public void switchForm(ActionEvent event) {
        if (event.getSource() == cardBtn) { //CARD FORM SWITCH FORMS 
            //For PARENT FORMS
            paymentForms.setVisible(false);
            cardForm.setVisible(true);
            gcashForm.setVisible(false);
            paypalForm.setVisible(false);

        } else if (event.getSource() == c_nextBtn1) { //NEXT C_FORM
            //For Card FORMS
            c_form1.setVisible(false);
            c_form2.setVisible(true);

        } else if (event.getSource() == c_backBtn1) { //BACK C_FORM
            //For Card FORMS
            paymentForms.setVisible(true);
            cardForm.setVisible(false);
            gcashForm.setVisible(false);
            paypalForm.setVisible(false);
            c_form1.setVisible(true);
            c_form2.setVisible(false);

        } else if (event.getSource() == c_backBtn2) { //BACK C_FORM
            //For Card FORMS
            c_form1.setVisible(true);
            c_form2.setVisible(false);

        } else if (event.getSource() == gcashBtn) { //GCASH FORM SWITCH FORMS 
            //For PARENT FORMS
            paymentForms.setVisible(false);
            cardForm.setVisible(true);
            gcashForm.setVisible(false);
            paypalForm.setVisible(false);

        } else if (event.getSource() == g_backBtn) { //BACK G_FORM
            //For GCash FORMS
            paymentForms.setVisible(true);
            gcashForm.setVisible(false);

        } else if (event.getSource() == payPalBtn) { //PAYPAL FORM SWITCH FORMS  
            //For PARENT FORMS
            paymentForms.setVisible(false);
            cardForm.setVisible(true);
            gcashForm.setVisible(false);
            paypalForm.setVisible(false);

        } else if (event.getSource() == p_backBtn) { //BACK P_FORM
            //For GCash FORMS
            paymentForms.setVisible(true);
            paypalForm.setVisible(false);
        }
    }

    public void closeForm() {
        // Get the stage (window) associated with the current form
        Stage stage = (Stage) main_form.getScene().getWindow();

        // Close the stage
        stage.close();
    }

    private void setupTextFieldListeners() {
        // Add listeners to the text fields
        cardNumber.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        expirationDate.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        securityCode.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        cardOwner.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        c_name.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        c_address1.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        c_address2.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        c_city.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        c_state.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        c_postalCode.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        g_name.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        g_address1.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        g_address2.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        g_city.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        g_state.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        g_postalCode.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
        p_phoneNumber.textProperty().addListener((observable, oldValue, newValue) -> checkNextButtonEnable());
    }

    private void checkNextButtonEnable() {
        // List of text fields to check for emptiness
        JFXTextField[] textFields = {cardNumber, expirationDate, securityCode, cardOwner,
            c_name, c_address1, c_address2, c_city, c_state, c_postalCode,
            g_name, g_address1, g_address2, g_city, g_state, g_postalCode, p_phoneNumber};

        // Check if all text fields are not empty
        boolean allFieldsFilled = Arrays.stream(textFields)
                .allMatch(field -> !field.getText().trim().isEmpty());

        // Enable or disable the next buttons based on the check
        c_nextBtn1.setDisable(!allFieldsFilled);
        c_nextBtn2.setDisable(!allFieldsFilled);
        g_nextBtn.setDisable(!allFieldsFilled);
        p_nextBtn.setDisable(!allFieldsFilled);
    }

    private void initializeCountryComboBoxes() {
        List<String> countries = getAllCountries();
        setComboBoxItems(c_country, countries);
        setComboBoxItems(g_country, countries);
        makeComboBoxSearchable(c_country);
        makeComboBoxSearchable(g_country);
    }

    private List<String> getAllCountries() {
        String[] countriesArray = {
            "Afghanistan", "Albania", "Algeria", /* ... (add all countries here) ... */ "Zimbabwe"
        };

        // Convert array to a List
        return Arrays.asList(countriesArray);
    }

    private void setComboBoxItems(JFXComboBox<String> comboBox, List<String> items) {
        comboBox.getItems().addAll(items);
    }

    private void makeComboBoxSearchable(JFXComboBox<String> comboBox) {
        TextField editor = comboBox.getEditor();

        // Listen for changes in the text field and filter the combo box items accordingly
        editor.textProperty().addListener((observable, oldValue, newValue) -> {
            comboBox.show();
            List<String> filteredList = filterItems(comboBox.getItems(), newValue);
            if (!comboBox.isShowing()) {
                comboBox.show();
            }
            if (comboBox.getItems().size() > 10) {
                comboBox.setVisibleRowCount(10);
            } else {
                comboBox.setVisibleRowCount(comboBox.getItems().size());
            }
            comboBox.getItems().setAll(filteredList);
        });
    }

    private List<String> filterItems(List<String> items, String filter) {
        return items.stream()
                .filter(item -> item.toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Constructor to receive data from HomepageController
    public PaymentController(
            HomepageController homepageController, TextField fName, TextField mName, TextField lName, TextField suffix, TextField age, TextField birthDate, TextField destination, TextField origin, TextField sClass, TextField seat, TextField modePayment) {
        this.homepageController = homepageController;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.suffix = suffix;
        this.age = age;
        this.birthDate = birthDate;
        this.destination = destination;
        this.origin = origin;
        this.sClass = sClass;
        this.modePayment = modePayment;
        // Initialize other fields if needed
    }

    @FXML
    private void handleNextBtn(ActionEvent event) throws SQLException {
        // You can use the data (f_name, m_name, etc.) in this method as needed
        // ...

        // Close the current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

        // Open the Notif.fxml form
        openNotifForm();
    }

    @FXML
    private void handlePNextBtn(ActionEvent event) throws SQLException {
        // Additional logic specific to PNextBtn if needed

        // Call the common handler
        handleNextBtn(event);
    }

    @FXML
    private void handleGNextBtn(ActionEvent event) throws SQLException {
        // Additional logic specific to GNextBtn if needed

        // Call the common handler
        handleNextBtn(event);
    }

    @FXML
    private void handleCNextBtn2(ActionEvent event) throws SQLException {
        // Additional logic specific to CNextBtn2 if needed

        // Call the common handler
        handleNextBtn(event);
    }

    // Add this method to open Notif.fxml
    private void openNotifForm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage/Notif.fxml"));
            Parent root = loader.load();
            Stage notifStage = new Stage();
            Scene scene = new Scene(root);

            // Set the stage properties as needed
            notifStage.setScene(scene);
            notifStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOa
        createTwinklingStars();

        // Call your methods for setting up text field listeners and checking the next button state
        setupTextFieldListeners();
        checkNextButtonEnable();

        // Initialize the countries in the ComboBoxes
        initializeCountryComboBoxes();

    }

}
