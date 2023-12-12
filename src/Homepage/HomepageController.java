package Homepage;

import Animations.SwitchForms;
import Database.Database;
import LogIn.AlertManager;
import LogIn.Customer;
import Receipt.TicketMaker;
import Receipt.TicketNo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;

import java.awt.*;
import java.io.IOException;

import com.jfoenix.controls.JFXTextField;
import javafx.animation.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.textfield.TextFields;
import javafx.scene.Cursor;

public class HomepageController implements Initializable {

    @FXML
    private TextField departure_date, arrival_date;

    @FXML
    private AnchorPane topPane;

    @FXML
    private AnchorPane centrePane;

    @FXML
    private Pane starsPane;

    @FXML
    private AnchorPane aboutUs_form;

    @FXML
    private AnchorPane top_form;

    @FXML
    private AnchorPane top_form_pp;

    @FXML
    private AnchorPane account_form;

    @FXML
    private AnchorPane userNameField;

    @FXML
    private Label displayUserName;

    @FXML
    private AnchorPane bg;

    @FXML
    private AnchorPane innerBG;

    @FXML
    private JFXButton acc_bookedFlightbtn;

    @FXML
    private JFXButton acc_pastTransacbtn;

    @FXML
    private JFXButton acc_customerSuppbtn;

    @FXML
    private AnchorPane acc_imgBg;

    @FXML
    private AnchorPane acc_bookedFlights;

    @FXML
    private TableView<?> acc_bookedFlightTable;

    @FXML
    private JFXButton acc_bookedFlightsBTN;

    @FXML
    private AnchorPane acc_pastTransaction;

    @FXML
    private TableView<?> acc_pastTransacTable;

    @FXML
    private JFXButton acc_pastTransReceiptBTN;

    @FXML
    private JFXButton acc_flightStatusBTN;

    @FXML
    private AnchorPane flightStats_form;

    @FXML
    private AnchorPane home_form;

    @FXML
    private AnchorPane hf_bookFlight;

    @FXML
    private JFXButton returnToDesti_btn1;

    @FXML
    private JFXButton book_btn;

    @FXML
    private AnchorPane hf_chooseSeat;

    @FXML
    private JFXTextField cs_destination;

    @FXML
    private JFXTextField cs_origin, sd_searchByText;

    @FXML
    private JFXTextField cs_seatNum;

    @FXML
    private JFXTextField cs_price;

    @FXML
    private JFXTextField cs_seatClass;

    @FXML
    private JFXButton proceed_btn;

    @FXML
    private JFXButton returnToDesti_btn;

    @FXML
    private AnchorPane topPlaneSeat;

    @FXML
    private JFXButton planeSeat_1;

    @FXML
    private AnchorPane hf_searchDesti;

    @FXML
    private Label promptLabel1;

    @FXML
    private Label promptLabel2;

    @FXML
    private TextField searchTextField;

    @FXML
    private JFXButton returnToHome_btn;

    @FXML
    private AnchorPane hf_home;

    @FXML
    private JFXButton bookFlight_btn;

    @FXML
    private AnchorPane carousel;

    @FXML
    private AnchorPane c_slide1;

    @FXML
    private JFXButton c_bookingBtn1;

    @FXML
    private JFXButton c_bookingBtn2;

    @FXML
    private JFXButton c_bookingBtn3;

    @FXML
    private AnchorPane c_slide2;

    @FXML
    private JFXButton c_bookingBtn4;

    @FXML
    private JFXButton c_bookingBtn5;

    @FXML
    private JFXButton c_bookingBtn6;

    @FXML
    private AnchorPane c_slide3;

    @FXML
    private JFXButton c_bookingBtn7;

    @FXML
    private JFXButton c_bookingBtn8;

    @FXML
    private JFXButton c_bookingBtn9;

    @FXML
    private JFXButton slideToLeft_btn;

    @FXML
    private JFXButton slideToRight_btn;

    @FXML
    private AnchorPane overlayPane;

    @FXML
    private JFXButton menuBtn1;

    @FXML
    private AnchorPane menuSlider;

    @FXML
    private JFXButton menu_home;

    @FXML
    private JFXButton menu_flightStats;

    @FXML
    private JFXButton menu_customerSupp;

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
    private JFXComboBox<?> typeOfPayment;

    @FXML
    private Label book_alert;

    @FXML
    private AnchorPane overlayPane1;

    @FXML
    private AnchorPane payment_form;

    @FXML
    private AnchorPane topPane1;

    @FXML
    private Pane starsPane1;

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

    @FXML
    private AnchorPane paymentPane;

    @FXML
    private TextField f_name, m_name, l_name, suffix, age, destination, origin, s_class, seat, fare_price;

    @FXML
    private AnchorPane firstC_seats;

    @FXML
    private JFXButton seat_a1, seat_a2, seat_a3, seat_a4, seat_a5, seat_a6, seat_a7, seat_a8;

    @FXML
    private AnchorPane businessC_seats;

    @FXML
    private JFXButton seat_b9, seat_b10, seat_b11, seat_b12, seat_b13, seat_b14, seat_b15, seat_b16, seat_b17, seat_b18, seat_b19, seat_b20, seat_b21, seat_b22, seat_b23, seat_b24;

    @FXML
    private AnchorPane premEconomyC_seats;

    @FXML
    private JFXButton seat_c25, seat_c26, seat_c27, seat_c28, seat_c29, seat_c30, seat_c31, seat_c32, seat_c33, seat_c34, seat_c35, seat_c36;

    @FXML
    private AnchorPane economyC_seats;

    @FXML
    private JFXButton seat_d37, seat_d38, seat_d39, seat_d40, seat_d41, seat_d42, seat_d43, seat_d44, seat_d45, seat_d46, seat_d47, seat_d48, seat_d49, seat_d50, seat_d51, seat_d52, seat_d53, seat_d54, seat_d55, seat_d56, seat_d57, seat_d58, seat_d59, seat_d60, seat_d61, seat_d62, seat_d63, seat_d64, seat_d65, seat_d66, seat_d67, seat_d68, seat_d69, seat_d70, seat_d71, seat_d72, seat_d73, seat_d74, seat_d75, seat_d76, seat_d77, seat_d78, seat_d79, seat_d80;

    @FXML
    private ImageView seat_icon;

    @FXML
    private AnchorPane cs_changeInfoForm, cs_reBookingform, background, cs_chat;

    @FXML
    private TableView<String[]> flightStatTable;

    @FXML
    private TableColumn<String[], String> fs_airplaneID, fs_flightNo, fs_destination, fs_origin, fs_status, fs_departDate, fs_arrivalDate;

    @FXML
    private AnchorPane payingForm;

    @FXML
    private AnchorPane topPane2;

    @FXML
    private Pane starsPane2;

    @FXML
    private JFXButton closeButton1;

    @FXML
    private Label pf_farePrice;

    @FXML
    private Label pf_totalPrice;

    @FXML
    private Label pf_farePrice1;

    @FXML
    private JFXButton pf_payBtn;

    @FXML
    private JFXButton pf_backBtn;

    //FXML IDS FOR HF_SEARCHDESTI
    @FXML
    private TableView<String[]> sd_tableView;

    @FXML
    private TableColumn<String[], String> sdTbl_origin, sdTbl_destination, sdTbl_seatClass, sdTbl_farePrice, sdTbl_departure, sdTbl_arrival;

    @FXML
    private JFXButton sd_confirmBtn;

    @FXML
    private JFXButton sd_clearSearchBtn;

    @FXML
    private JFXTextField sdDi_origin;

    @FXML
    private JFXTextField sdDi_destination;

    @FXML
    private JFXTextField sdDi_seatClass;

    @FXML
    private JFXTextField sdDi_farePrice;

    @FXML
    private JFXComboBox<String> sd_origin, sd_searchBy;

    @FXML
    private JFXComboBox<String> sd_destination;

    @FXML
    private JFXComboBox<String> sd_seatClass;

    @FXML
    private JFXCheckBox checkBox_btn;

    @FXML
    private ImageView image1, image2, image3, image4;

    @FXML
    private Button TOPbtn;

    @FXML
    private Button Policybtn;

    private boolean menuOpen = false;

    private double defaultSliderWidth = 280;
    private double defaultSliderHeight = 43;

    // Create a Timeline for auto-sliding
    private Timeline autoSlideTimeline;
    // Variable to store the time of the last manual slide change
    private long lastSlideChangeTime = 0;

    // Create a reference to the currently selected button
    private JFXButton currentSelectedButton;

    private double x = 0;
    private double y = 0;

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
        openTransition.setNode(menuSlider);

        // Update the menuOpen flag
        menuOpen = true;

        overlayPane.setVisible(true);
        overlayPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");
    }

    private void closeMenuSlider() {
        // Set the height explicitly
        menuSlider.setPrefHeight(defaultSliderHeight);

        // Define the animation for closing the menu slider
        TranslateTransition closeTransition = new TranslateTransition(Duration.millis(300), menuSlider);
        closeTransition.setToX(-defaultSliderWidth);
        closeTransition.play();
        closeTransition.setNode(menuSlider);

        // Update the menuOpen flag
        menuOpen = false;

        overlayPane.setVisible(false);
    }

    //LOG OUT FUNCTION
    public void logout() throws IOException {
        SwitchForms switchForms = new SwitchForms();
        switchForms.Logout((Stage) menu_logout.getScene().getWindow());
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

    // Add this method to create twinkling stars for starsPane1
    private void createTwinklingStarsForPane1() {
        int numStars = 20;
        ParallelTransition parallelTransition = new ParallelTransition();

        // Set preferred size explicitly
        //starsPane1.setPrefSize(510, 106);
        for (int i = 0; i < numStars; i++) {
            Pane star = createStar();
            starsPane1.getChildren().add(star);

            // Set a random initial position within the bounds of starsPane1
            double initialX = Math.random() * (starsPane1.getWidth() + 508);  // Adjusted to consider star size
            double initialY = Math.random() * (starsPane1.getHeight() + 90); // Adjusted to consider star size
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

    // Add this method to create twinkling stars for starsPane2
    private void createTwinklingStarsForPane2() {
        int numStars = 20;
        ParallelTransition parallelTransition = new ParallelTransition();

        // Set preferred size explicitly
        //starsPane2.setPrefSize(510, 106);
        for (int i = 0; i < numStars; i++) {
            Pane star = createStar();
            starsPane2.getChildren().add(star);

            // Set a random initial position within the bounds of starsPane1
            double initialX = Math.random() * (starsPane1.getWidth() + 508);  // Adjusted to consider star size
            double initialY = Math.random() * (starsPane1.getHeight() + 90); // Adjusted to consider star size
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

    // Call this method in your initialize method to create twinkling stars for starsPane1
    private void initializeTwinklingStars() {
        createTwinklingStars();  // For starsPane
        createTwinklingStarsForPane1();  // For starsPane1
        createTwinklingStarsForPane2();
    }

    //CAROUSEL FUNCTIONS
    private void initializeAutoSlideTimeline() {
        // Set the duration and create a KeyFrame
        Duration duration = Duration.seconds(8); // adjust the duration as needed
        KeyFrame keyFrame = new KeyFrame(duration, this::autoSlide);

        // Create a timeline with the keyframe, set it to indefinite to repeat
        autoSlideTimeline = new Timeline(keyFrame);
        autoSlideTimeline.setCycleCount(Timeline.INDEFINITE);

        // Play the auto-slide timeline
        autoSlideTimeline.play();
    }

    // Auto-slide method
    private void autoSlide(ActionEvent event) {
        // If the user manually changed slides recently, wait for 10s before resuming auto-slide
        if (System.currentTimeMillis() - lastSlideChangeTime < 10000) {
            return;
        }

        // Perform the auto-slide action (slide to the left)
        slideToLeft(event);
    }

    // Modify the existing slideToLeft and slideToRight methods
    int show = 0;

    @FXML
    private void slideToRight(ActionEvent event) {
        if (show == 0) {
            switchForm(c_slide2);
            show++;
        } else if (show == 1) {
            switchForm(c_slide3);
            show++;
        } else if (show == 2) {
            switchForm(c_slide1);
            show = 0;
        }

        // Record the time of the manual slide change
        lastSlideChangeTime = System.currentTimeMillis();
        autoSlideTimeline.playFromStart(); // Resume auto-slide
    }

    @FXML
    private void slideToLeft(ActionEvent event) {
        if (show == 0) {
            switchForm(c_slide3);
            show = 2;
        } else if (show == 1) {
            switchForm(c_slide1);
            show--;
        } else if (show == 2) {
            switchForm(c_slide2);
            show--;
        }

        // Record the time of the manual slide change
        lastSlideChangeTime = System.currentTimeMillis();
        autoSlideTimeline.playFromStart(); // Resume auto-slide
    }

    //SWITCH FORM FUNCTIONS FOR CAROUSEL
    private void switchForm(AnchorPane targetForm) {
        //carousel slides
        c_slide1.setVisible(false);
        c_slide2.setVisible(false);
        c_slide3.setVisible(false);

        // Show the selected form or carousel slide
        targetForm.setVisible(true);
    }

    //SWITCH FORM FUNCTIONS FOR home_form
    private void switchForm(AnchorPane targetForm, JFXButton selectedButton) {
        hf_home.setVisible(false);
        hf_searchDesti.setVisible(false);
        hf_chooseSeat.setVisible(false);
        hf_bookFlight.setVisible(false);
        // Show the selected form
        targetForm.setVisible(true);
    }

    //SWITCH FORM FUNCTIONS FOR MENU SLIDER
    public void switchForm(ActionEvent event) {
        if (event.getSource() == menu_home) {
            //For PARENT FORMS
            home_form.setVisible(true);
            flightStats_form.setVisible(false);
            account_form.setVisible(false);
            top_form.setVisible(false);
            aboutUs_form.setVisible(false);

            //For home_form
            hf_home.setVisible(true);
            hf_searchDesti.setVisible(false);
            cs_seatClass.setDisable(false);
            hf_chooseSeat.setVisible(false);
            hf_bookFlight.setVisible(false);
        } else if (event.getSource() == menu_flightStats) {
            home_form.setVisible(false);
            flightStats_form.setVisible(true);
            account_form.setVisible(false);
            top_form.setVisible(false);
            aboutUs_form.setVisible(false);

        } else if (event.getSource() == menu_account) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            account_form.setVisible(true);
            top_form.setVisible(false);
            aboutUs_form.setVisible(false);

            switchAccForms();
            acc_imgBg.setVisible(true);
        } else if (event.getSource() == menu_TOP) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            account_form.setVisible(false);
            top_form.setVisible(true);
            aboutUs_form.setVisible(false);
        } else if (event.getSource() == menu_aboutUs) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            account_form.setVisible(false);
            top_form.setVisible(false);
            aboutUs_form.setVisible(true);
        }
    }

    //TOP and Privacy Policy selectors?
    public void switchTOPForms() {

        top_form.setVisible(false);
        top_form_pp.setVisible(false);

        //TO privacy Policy
        TOPbtn.setOnAction(event -> {
            top_form.setVisible(false);
            top_form_pp.setVisible(true);

        });

        //Back to TOP
        Policybtn.setOnAction(event -> {
            top_form.setVisible(true);
            top_form_pp.setVisible(false);

        });

        Policybtn.setOnAction(e -> switchForm(top_form, top_form_pp));
        TOPbtn.setOnAction(e -> switchForm(top_form_pp, top_form));
    }

    public void handleNextButtonClick(ActionEvent event) {
        // Determine which button was clicked
        Button clickedButton = (Button) event.getSource();

        // Check the ID or other properties of the button
        if (clickedButton.getId().equals("c_nextBtn2") || clickedButton.getId().equals("g_nextBtn") || clickedButton.getId().equals("p_nextBtn")) {

            // Set payment_form visibility to false
            payment_form.setVisible(false);
            payingForm.setVisible(true);
        }

    }

    public void handlePayButtonClick(ActionEvent event) throws SQLException, IOException {
        // Determine which button was clicked
        Button clickedButton = (Button) event.getSource();

        // Check the ID or other properties of the button
        if (clickedButton.getId().equals("pf_payBtn")) {

            // Insert data into the database
            insertDataIntoDatabase();
            clearPaymentForms();
            clearBookSelectionFields();
            clearSeatSelectionFields();
            resetHomeForm();
            // Set payment_form visibility to false
            payingForm.setVisible(false);
            overlayPane1.setVisible(false);
            // Show notification
            showNotification();
            switchForm(hf_home, returnToDesti_btn1);
        }

    }

    // Method to show notification
    private void showNotification() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage/Notif.fxml"));
            Parent root = loader.load();
            NotifController notifController = loader.getController(); // Get the controller of Notif.fxml

            // Set undecorated and not resizable properties
            Stage notifStage = new Stage();
            notifStage.initStyle(StageStyle.UTILITY); // Set stage style to UTILITY
            notifStage.initStyle(StageStyle.UNDECORATED);
            notifStage.setResizable(false);
            notifStage.initModality(Modality.APPLICATION_MODAL);
            notifStage.setScene(new Scene(root));

            notifStage.setOnShown(event -> {
                // Center the stage on the screen
                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                notifStage.setX((primScreenBounds.getWidth() - notifStage.getWidth()) / 2);
                notifStage.setY((primScreenBounds.getHeight() - notifStage.getHeight()) / 2);

                // Make overlayPane1 visible and set its style
                if (overlayPane1 != null) {
                    overlayPane1.setVisible(true);
                    overlayPane1.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");
                }
            });

            notifStage.setOnHidden(event -> {
                // Hide overlayPane1 when notifStage is hidden
                if (overlayPane1 != null) {
                    overlayPane1.setVisible(false);
                }
            });

            // Set the owner stage to null to prevent the taskbar icon
            notifStage.initOwner(null);

            // Get the controller of Notif.fxml
            notifController.setNotifStage(notifStage);

            // Show the stage
            notifStage.show();

            Image icon = new Image(getClass().getResourceAsStream("/Images/ICONS/EA Logo.png"));
            notifStage.getIcons().add(icon);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public String generateFlightID(String prefix, String origin, String destination) {
        String combinedString = origin + destination;
        int hashcode = Objects.hash(combinedString);

        int randomNum = Math.abs(hashcode) % 1000;

        Database flight_count = new Database();
        int counter = flight_count.flightCount(origin, destination);

        counter = counter - 80;

        if (counter < 0) {
            counter = 0;
        }

        randomNum = randomNum + counter;
        return prefix + randomNum;

    }

    private void insertDataIntoDatabase() throws SQLException, IOException {
        // Add into database

        String flight_id = generateFlightID("ERM", origin.getText(), destination.getText());

        String first_name = f_name.getText();

        String middle_name = m_name.getText();
        if (middle_name.isEmpty()) {
            middle_name = "";
        }

        String last_name = l_name.getText();
        String suffix_name = suffix.getText();
        if (suffix_name.isEmpty()) {
            suffix_name = "";
        }

        String age_name = age.getText();

        String destination_name = destination.getText();
        String origin_name = origin.getText();
        String seat_class = s_class.getText();
        String seat_num = seat.getText();
        Double fare = Double.valueOf(fare_price.getText());

        //Add booking in here
        String depart = departure_date.getText();
        //Add arrival
        String arrival = arrival_date.getText();

        LocalDate book_date = LocalDate.now();

        String ticket_no = TicketNo.generateTicketNo(f_name.getText());
        String status = "BOOKED";

        LocalDate now = LocalDate.now();

        Database insertData1 = new Database();
        insertData1.insertData(
                "booked_flights",
                Arrays.asList("flight_id", "first_name", "middle_name", "last_name", "suffix", "age", "destination", "origin", "class", "seat", "flight_no", "amount", "departure", "arrival", "book_date", "ticket_no", "status"),
                Arrays.asList(flight_id, first_name, middle_name, last_name, suffix_name, age_name, destination_name, origin_name, seat_class, seat_num, flight_id, fare, depart, arrival, now, ticket_no, status)
        );

        // Add to sales
        Database insertSales = new Database();
        insertSales.insertData(
                "sales",
                Arrays.asList("ticket_no", "flight_no", "seat", "name", "payment_date",
                        "status", "ticket_agent", "price"),
                Arrays.asList(ticket_no, flight_id, seat_num, last_name, book_date.toString(),
                        status, "ONLINE", fare)
        );

        // Generate ticket
        Booking infos = Booking.getInstance();
        TicketMaker ticketMaker = new TicketMaker();
        ticketMaker.generateTicket(first_name, middle_name,
                last_name, age_name, destination_name, origin_name, seat_class,
                seat_num, flight_id, infos.getAmount(), depart, ticket_no, fare);

    }

    private void checkSeats() throws SQLException {
        String flight_id = generateFlightID("ERM", origin.getText(), destination.getText());
        Database checkSeats = new Database();
        int counter = checkSeats.flightCount(destination.getText(), origin.getText());
        if (counter >= 80) {
            // Update flight_manager
            System.out.println(flight_id + " is full");
            Database updateFlightManager = new Database();
            updateFlightManager.insertData(
                    "flight_manager",
                    Arrays.asList("flight_id", "destination", "origin", "status"),
                    Arrays.asList(flight_id, destination.getText(), origin.getText(), "FULL")
            );
        }
    }

    //and Except middle name
    private boolean areAllFieldsExceptSuffixEmpty() {
        return f_name.getText().isEmpty()
                && l_name.getText().isEmpty()
                && age.getText().isEmpty()
                // Check if JFXDatePicker value is null
                && destination.getText().isEmpty()
                && origin.getText().isEmpty()
                && s_class.getText().isEmpty()
                && seat.getText().isEmpty();
    }

    private boolean areFieldsEmpty() {
        // Check if all fields (except suffix) are empty
        if (areAllFieldsExceptSuffixEmpty() && suffix.getText().isEmpty() && m_name.getText().isEmpty()) {
            AlertManager alert = new AlertManager(book_alert);
            alert.setAlertText("Please fill in all the fields", "red");

            // Schedule a task to hide the alert after 5 seconds
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished(event -> alert.hideAlert());
            delay.play();

            return true; // Exit the method since all fields (except suffix) are empty
        }

        // Check if any of the required fields (excluding suffix and m_name) is empty
        boolean anyFieldEmpty = isNullOrEmpty(f_name)
                || isNullOrEmpty(l_name)
                || isNullOrEmpty(age)
                || isNullOrEmpty(destination)
                || isNullOrEmpty(origin)
                || isNullOrEmpty(s_class)
                || isNullOrEmpty(seat);

        // If any required field (excluding suffix) is empty, show an alert
        if (anyFieldEmpty) {
            AlertManager alert = new AlertManager(book_alert);
            alert.setAlertText("Please fill in all required fields.", "red");

            // Schedule a task to hide the alert after 5 seconds
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished(event -> alert.hideAlert());
            delay.play();

            return true; // Exit the method since any required field (excluding suffix) is empty
        }

        return false; // All required fields (excluding suffix) are filled
    }

    // Method to check if a TextField is null or empty
    private boolean isNullOrEmpty(TextField textField) {
        return textField != null && textField.getText().trim().isEmpty();
    }

    // Method to clear seat selection fields
    private void clearSeatSelectionFields() {
        cs_seatNum.clear();
        cs_seatClass.clear(); // Clear the selection
    }

    // Method to clear seat selection fields
    private void clearBookSelectionFields() {
        f_name.clear();
        m_name.clear();
        l_name.clear();
        suffix.clear();
        age.clear();
        checkBox_btn.setSelected(false);
    }

    // Method to handle return to destination button click
    public void handleReturnToDestiButtonClick() {
        switchForm(hf_searchDesti, returnToDesti_btn);
        clearSeatSelectionFields();
    }

    // Method to handle return to destination button click
    public void handleReturnToChooseSeatButtonClick() {
        switchForm(hf_chooseSeat, returnToDesti_btn1);
        // Check if checkBox_btn is not null before calling setSelected
        if (checkBox_btn != null) {
            checkBox_btn.setSelected(false);
        } else {
            System.out.println("checkBox_btn is null");
        }
    }

    // Method to handle proceed button click
    public void proceedBooking() {
        // Switch form to hf_bookFlight
        switchForm(hf_bookFlight, proceed_btn);

        // Set values in texHomepaget fields
        seat.setText(cs_seatNum.getText());
        destination.setText(cs_destination.getText());
        origin.setText(cs_origin.getText());
        fare_price.setText(cs_price.getText());
        s_class.setText(cs_seatClass.getText());

        String destination_name = destination.getText();
        String origin_name = origin.getText();

        Database bdate = new Database();
        ObservableList<String[]> dep_date = bdate.pullData(
                "flight_manager",
                Arrays.asList("origin_date", "destination_date"),
                Arrays.asList("origin", "destination"),
                Arrays.asList(origin_name, destination_name)
        );

        if (!dep_date.isEmpty()) {
            departure_date.setText(dep_date.get(0)[0]);
            arrival_date.setText(dep_date.get(0)[1]);
        }

    }

    // Method to update the state of the proceed button based on cs_seatNum and cs_seatClass
    private void updateProceedButtonState() {
        boolean isDisabled = cs_seatNum.getText().isEmpty() || cs_seatClass.getText().isEmpty();
        proceed_btn.setDisable(isDisabled);
    }

    // Additional methods from PaymentController to be integrated into HomepageController
    private void initializeCountryComboBoxes() {
        List<String> countries = getAllCountries();
        setComboBoxItems(c_country, countries);
        setComboBoxItems(g_country, countries);

        makeComboBoxSearchable(c_country);
        makeComboBoxSearchable(g_country);

        // Add listeners to update the button state when the selected items change
        addCountryComboBoxListeners();

    }

    // Add this method to add listeners for country combo-boxes
    private void addCountryComboBoxListeners() {
        // Listener for c_country
        c_country.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateCardAddressButtonState(); // Assuming this method checks all conditions for the proceed button
        });

        // Listener for g_country
        g_country.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateGcashButtonState(); // Assuming this method checks all conditions for the proceed button
        });
    }

    private List<String> getAllCountries() {
        String[] countriesArray = {
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor (Timor-Leste)", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, North (North Korea)", "Korea, South (South Korea)", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia (formerly Macedonia)", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"
        };

        // Convert array to a List
        return Arrays.asList(countriesArray);
    }

    private void setComboBoxItems(JFXComboBox<String> comboBox, List<String> items) {
        comboBox.getItems().addAll(items);
    }

    private void makeComboBoxSearchable(JFXComboBox<String> comboBox) {
        TextFields.bindAutoCompletion(comboBox.getEditor(), comboBox.getItems());
    }

    private void switchPaymentForm(JFXButton selectedButton) {
        cardForm.setVisible(false);
        gcashForm.setVisible(false);
        paypalForm.setVisible(false);

        if (selectedButton == cardBtn) {
            paymentForms.setVisible(false);
            cardForm.setVisible(true);
        } else if (selectedButton == gcashBtn) {
            paymentForms.setVisible(false);
            gcashForm.setVisible(true);
        } else if (selectedButton == payPalBtn) {
            paymentForms.setVisible(false);
            paypalForm.setVisible(true);
        }
    }

    private void switchCardForm(String buttonId) {
        switch (buttonId) {
            case "c_nextBtn1":
                c_form1.setVisible(false);
                c_form2.setVisible(true);
                break;
            case "c_backBtn1":
                paymentForms.setVisible(true);
                cardForm.setVisible(false);
                gcashForm.setVisible(false);
                paypalForm.setVisible(false);
                c_form1.setVisible(true);
                c_form2.setVisible(false);
                clearCardFormFields();
                break;
            case "c_backBtn2":
                c_form1.setVisible(true);
                c_form2.setVisible(false);
                clearCardFormFields();
                break;
            // Add more cases as needed
        }
    }

    private void switchGcashForm(String buttonId) {
        switch (buttonId) {
            case "g_backBtn":
                clearGcashFormFields();
                paymentForms.setVisible(true);
                gcashForm.setVisible(false);
                break;
            // Add more cases as needed
        }
    }

    private void switchPaypalForm(String buttonId) {
        switch (buttonId) {
            case "p_backBtn":
                clearPaypalFormFields();
                paymentForms.setVisible(true);
                paypalForm.setVisible(false);
                break;
            // Add more cases as needed
        }
    }

    private void switchPayingForm(String buttonId) {
        switch (buttonId) {
            case "pf_backBtn":
                payment_form.setVisible(true);
                payingForm.setVisible(false);
                break;
            // Add more cases as needed
        }
    }

    public void handleBookButtonClick() {
        // Check if all fields in hf_bookFlight are empty
        if (areFieldsEmpty()) {
            AlertManager alert = new AlertManager(book_alert);
            alert.setAlertText("Please fill in at least one field in Book Flight.", "red");

            // Schedule a task to hide the alert after 5 seconds
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished(event -> alert.hideAlert());
            delay.play();

            return; // Exit the method since there are validation issues
        }

        // Switch to paymentForms initially
        switchPaymentForm(book_btn);

        // Open/visible the payment_form
        payment_form.setVisible(true);
        paymentForms.setVisible(true);
        // Make the overlayPane1 visible and dim
        overlayPane1.setVisible(true);
        overlayPane1.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");

        // Add the infos
        Booking booking = Booking.getInstance();
        booking.setFirst_name(f_name.getText());
        booking.setMiddle_name(m_name.getText());
        booking.setLast_name(l_name.getText());
        booking.setSuffix(suffix.getText());
        booking.setAge(Integer.parseInt(age.getText()));
        booking.setDestination(destination.getText());
        booking.setOrigin(origin.getText());
        booking.setClass(s_class.getText());
        booking.setSeatNo(seat.getText());
        booking.setBooking_date(LocalDate.now());
        booking.setFlight_no(generateFlightID("ERM", origin.getText(), destination.getText()));

        Double total = Double.valueOf(fare_price.getText());
        total = total + 50 + 30;
        booking.setAmount(total);

        booking.setTicketNo(TicketNo.generateTicketNo(booking.getFirst_name() + booking.getLast_name()));
    }

    public void switchPaymentForm(ActionEvent event) {
        JFXButton selectedButton = (JFXButton) event.getSource();
        switchPaymentForm(selectedButton);
    }

    public void switchCardForm(ActionEvent event) {
        String buttonId = ((JFXButton) event.getSource()).getId();
        switchCardForm(buttonId);
    }

    public void switchGcashForm(ActionEvent event) {
        String buttonId = ((JFXButton) event.getSource()).getId();
        switchGcashForm(buttonId);
    }

    public void switchPaypalForm(ActionEvent event) {
        String buttonId = ((JFXButton) event.getSource()).getId();
        switchPaypalForm(buttonId);
    }

    public void switchPayingForm(ActionEvent event) {
        String buttonId = ((JFXButton) event.getSource()).getId();
        switchPayingForm(buttonId);
    }

    public void closeForm() {
        clearPaymentForms(); // Clear fields in paymentForms
        // Hide the overlayPane1 and main_form
        overlayPane1.setVisible(false);
        payment_form.setVisible(false);
        paymentForms.setVisible(true);
        payingForm.setVisible(false);

    }

    // Add these methods to clear the fields in each form
    private void clearCardFormFields() {
        cardNumber.clear();
        expirationDate.clear();
        securityCode.clear();
        cardOwner.clear();
        c_country.getSelectionModel().clearSelection();
        c_name.clear();
        c_address1.clear();
        c_address2.clear();
        c_city.clear();
        c_state.clear();
        c_postalCode.clear();
    }

    private void clearGcashFormFields() {
        g_country.getSelectionModel().clearSelection();
        g_name.clear();
        g_address1.clear();
        g_address2.clear();
        g_city.clear();
        g_state.clear();
        g_postalCode.clear();
    }

    private void clearPaypalFormFields() {
        p_phoneNumber.clear();
    }

    // Add these methods to clear fields when the "Close" button is clicked
    public void clearPaymentForms() {
        clearCardFormFields();
        clearGcashFormFields();
        clearPaypalFormFields();
    }

    //Paymen Forms BTN's disabler
    private void updateCardNextButtonState() {
        String cardNumberText = cardNumber.getText();
        String expirationDateText = expirationDate.getText();
        String securityCodeText = securityCode.getText();
        String cardOwnerText = cardOwner.getText().trim();

        boolean isCardNumberValid = cardNumberText.length() >= 17 && cardNumberText.length() <= 19;
        boolean isExpirationDateValid = expirationDateText.matches("\\d{2} / \\d{2}");
        boolean isSecurityCodeValid = securityCodeText.length() == 3;
        boolean isCardOwnerValid = !cardOwnerText.isEmpty();

        boolean isDisabled = !isCardNumberValid || !isExpirationDateValid || !isSecurityCodeValid || !isCardOwnerValid;

        c_nextBtn1.setDisable(isDisabled);
    }

    private void updateCardAddressButtonState() {
        boolean isDisabled = c_country.getSelectionModel().isEmpty()
                || c_name.getText().isEmpty()
                || c_address1.getText().isEmpty()
                || c_city.getText().isEmpty()
                || c_state.getText().isEmpty()
                || c_postalCode.getText().length() != 4
                || !isValidCountry(c_country, getAllCountries()); // Add this condition
        c_nextBtn2.setDisable(isDisabled);
    }

    private void updateGcashButtonState() {
        boolean isDisabled = g_country.getSelectionModel().isEmpty()
                || g_name.getText().isEmpty()
                || g_address1.getText().isEmpty()
                || g_city.getText().isEmpty()
                || g_state.getText().isEmpty()
                || g_postalCode.getText().length() != 4
                || !isValidCountry(g_country, getAllCountries()); // Add this condition
        g_nextBtn.setDisable(isDisabled);
    }

    private void updatePaypalButtonState() {
        boolean isDisabled = p_phoneNumber.getText().isEmpty() || !p_phoneNumber.getText().matches("\\d{11}");
        p_nextBtn.setDisable(isDisabled);
    }

    // Add this method to check if the selected country is valid
    private boolean isValidCountry(JFXComboBox<String> countryComboBox, List<String> validCountries) {
        return validCountries.contains(countryComboBox.getSelectionModel().getSelectedItem());
    }

    public void handleSeatButton(JFXButton button) {
        String buttonLabel = button.getText();
        cs_seatNum.setText(buttonLabel);
    }
    //"Economy", "Premium Economy", "Business", "First Class"

    private boolean areFieldsFilled() {
        return !cs_origin.getText().isEmpty() && !cs_destination.getText().isEmpty() && !cs_seatClass.getText().isEmpty();
    }

    private void seatButtons() throws SQLException {
        if (areFieldsFilled()) {
            Database db = new Database();

            // Define a list of all seat buttons
            List<JFXButton> seatButtons = Arrays.asList(
                    seat_a1, seat_a2, seat_a3, seat_a4, seat_a5, seat_a6, seat_a7, seat_a8,
                    seat_b9, seat_b10, seat_b11, seat_b12, seat_b13, seat_b14, seat_b15, seat_b16, seat_b17, seat_b18, seat_b19, seat_b20, seat_b21, seat_b22, seat_b23, seat_b24,
                    seat_c25, seat_c26, seat_c27, seat_c28, seat_c29, seat_c30, seat_c31, seat_c32, seat_c33, seat_c34, seat_c35, seat_c36,
                    seat_d37, seat_d38, seat_d39, seat_d40, seat_d41, seat_d42, seat_d43, seat_d44, seat_d45, seat_d46, seat_d47, seat_d48, seat_d49, seat_d50,
                    seat_d51, seat_d52, seat_d53, seat_d54, seat_d55, seat_d56, seat_d57, seat_d58, seat_d59, seat_d60, seat_d61, seat_d62, seat_d63, seat_d64,
                    seat_d65, seat_d66, seat_d67, seat_d68, seat_d69, seat_d70, seat_d71, seat_d72, seat_d73, seat_d74, seat_d75, seat_d76, seat_d77, seat_d78,
                    seat_d79, seat_d80
            );

            String flight_id = generateFlightID("ERM", cs_origin.getText(), cs_destination.getText());
            // Iterate over each seat button
            for (JFXButton seatButton : seatButtons) {
                String seatLabel = seatButton.getText();

                if (db.checkSeats(seatLabel, flight_id)) {
                    seatButton.setDisable(true);
                    seatButton.setStyle("-fx-background-color: #8c8ce2;");
                } else {
                    seatButton.setOnAction(event -> handleSeatButton(seatButton));
                    seatButton.setStyle("-fx-background-color: #b2d58a;");
                    seatButton.setDisable(false);
                }
            }
        }
    }

    public void openPhoneDialer() {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.facebook.com/profile.php?id=61554275227122")); // You can replace this with the desired phone number
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Desktop not supported. Cannot open phone dialer.");
        }
    }

    public void sdSeatClass() {
        List<String> listP = new ArrayList<>(Arrays.asList("ECONOMY", "PREMIUM ECONOMY", "BUSINESS", "FIRST CLASS"));

        ObservableList<String> listData = FXCollections.observableArrayList(listP);
        sd_seatClass.setItems(listData);
    }

    private void loadFlightStat() {
        // Load the tables
        Database db = new Database();
        ObservableList<String[]> data = db.pullData(
                "flight_manager",
                Arrays.asList("airplane_id", "flight_no", "destination", "origin", "status", "origin_date", "destination_date")
        );

        // Set the table data
        if (data != null) {
            flightStatTable.setItems(data);
            fs_airplaneID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[0]));
            fs_flightNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[1]));
            fs_destination.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[2]));
            fs_origin.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[3]));
            fs_status.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[4]));
            fs_departDate.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[5]));
            fs_arrivalDate.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[6]));
        }
    }

    private void updateFarePriceLabels(String newValue) {
        // Check if pf_farePrice is not null before accessing it
        if (pf_farePrice != null) {
            pf_farePrice.setText("₱" + newValue);
        }

        // Check if pf_farePrice1 is not null before accessing it
        if (pf_farePrice1 != null) {
            pf_farePrice1.setText("₱" + newValue);
        }

        // Calculate total price with 12% VAT
        if (newValue != null && !newValue.isEmpty()) {
            try {
                double baseFare = Double.parseDouble(newValue);
                double vatPercentage = 0.12; // 12% VAT
                double totalFare = baseFare + (baseFare * vatPercentage);

                // Update pf_totalPrice label with the calculated total fare including the peso sign
                if (pf_totalPrice != null) {
                    pf_totalPrice.setText("₱" + String.format("%.2f", totalFare) + "*");
                }
            } catch (NumberFormatException e) {
                // Handle the case where newValue is not a valid number
                e.printStackTrace(); // You might want to handle this differently in a production scenario
            }
        }
    }

    /*---------------------- HF CHOOSEDESTI CODE SHOULD BE HERE ----------------------*/
    private ObservableList<String[]> destinationData = FXCollections.observableArrayList();
    // Load destinations initially, for example in your initialize method

    private void loadDestinations() {
        // Load the tables only if data is not already loaded
        if (destinationData.isEmpty()) {  // Change the condition to isEmpty()
            Database db = new Database();
            destinationData = db.searchDesti();

            // Set the table data
            if (destinationData != null) {
                sd_tableView.setItems(destinationData);
                sdTbl_origin.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[0]));
                sdTbl_destination.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[1]));
                sdTbl_seatClass.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[2]));
                sdTbl_farePrice.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[3]));
                sdTbl_departure.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[4]));
                sdTbl_arrival.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[5]));

                // Setup the click event
                setupTableClickEvent();
            }
        }
    }

    public void destiSearchBy() {
        List<String> listP = new ArrayList<>(Arrays.asList("Origin", "Destination", "Seat Class"));
        ObservableList<String> listData = FXCollections.observableArrayList(listP);
        sd_searchBy.setItems(listData);

        // Add listener to sd_searchBy
        sd_searchBy.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Enable or disable sd_searchByText based on the selected item
            sd_searchByText.setDisable(newValue == null);

            // Change cursor based on the enabled state
            if (sd_searchByText.isDisabled()) {
                sd_searchByText.setCursor(Cursor.DEFAULT);
            } else {
                sd_searchByText.setCursor(Cursor.TEXT);
            }
        });
    }

    public void desti_search() throws SQLException {
        String searchText = sd_searchByText.getText().toLowerCase(); // Convert to lowercase

        List<String> text = Arrays.asList(searchText);
        List<String> searchBy = Arrays.asList(sd_searchBy.getSelectionModel().getSelectedItem());

        FilteredList<String[]> filteredData = new FilteredList<>(destinationData, e -> true);

        // Apply search criteria based on the selected item in sd_searchBy
        filteredData.setPredicate(data -> dataMatchesSearchCriteria(data, searchBy.get(0), searchText));

        // Update the TableView with filtered data
        sd_tableView.setItems(filteredData);
    }

    private boolean dataMatchesSearchCriteria(String[] data, String searchBy, String searchCriteria) {
        // Placeholder logic; adjust based on your actual data structure and searchBy value
        switch (searchBy) {
            case "Origin":
                return data[0].toLowerCase().contains(searchCriteria);
            case "Destination":
                return data[1].toLowerCase().contains(searchCriteria);
            case "Seat Class":
                return data[2].toLowerCase().contains(searchCriteria);
            // Add more cases as needed
            default:
                return false;
        }
    }

    public void cleardesti_search() {
        // Clear the selection of the ComboBox
        sd_searchBy.getSelectionModel().clearSelection();

        // Clear the text of the TextField
        sd_searchByText.clear();

        // Reload the original data to revert the TableView
        destinationData.clear(); // Clear the existing data
        loadDestinations(); // Reload the data
    }

    private void resetHomeForm() {
        cleardesti_search();

        // Clear the text fields
        sdDi_origin.clear();
        sdDi_destination.clear();
        sdDi_seatClass.clear();
        sdDi_farePrice.clear();

        if (sd_origin != null && sd_origin.getSelectionModel() != null) {
            sd_origin.getSelectionModel().clearSelection();
        }

        if (sd_destination != null && sd_destination.getSelectionModel() != null) {
            sd_destination.getSelectionModel().clearSelection();
        }

        if (sd_seatClass != null && sd_seatClass.getSelectionModel() != null) {
            sd_seatClass.getSelectionModel().clearSelection();
        }

        // Switch form from hf_chooseSeat to hf_home
        switchForm(hf_searchDesti, hf_home);
    }

    /*------------------------------------------- HF CHOOSEDESTI CODE ENDS ABOVE -----------------------------------------------------------------*/
    private void setupTableClickEvent() {
        sd_tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Get the selected data from the clicked row
                String origin = newValue[0];
                String destination = newValue[1];
                String seatClass = newValue[2];
                String farePrice = newValue[3];

                // Set the values to the respective text fields
                sdDi_origin.setText(origin);
                sdDi_destination.setText(destination);
                sdDi_seatClass.setText(seatClass);
                sdDi_farePrice.setText(farePrice);
            }
        });
    }

    // Function to handle sd_confirmBtn click
    private void handleConfirmButtonClick() {
        // Get the text from sdDi_origin, sdDi_destination, sdDi_seatClass, and sdDi_farePrice
        String confirmedOrigin = sdDi_origin.getText();
        String confirmedDestination = sdDi_destination.getText();
        String confirmedSeatClass = sdDi_seatClass.getText();
        String confirmedFarePrice = sdDi_farePrice.getText();

        // Set the text to cs_origin, cs_destination, cs_seatClass, and cs_price
        cs_origin.setText(confirmedOrigin);
        cs_destination.setText(confirmedDestination);

        //cs_seatClass.setValue(confirmedSeatClass); // Assuming cs_seatClass is a JFXComboBox<String>
        cs_price.setText(confirmedFarePrice);
        cs_seatClass.setText(confirmedSeatClass);

        // Switch form from hf_searchDesti to hf_chooseSeat
        switchForm(hf_searchDesti, hf_chooseSeat);
    }

    // Function to check if text fields are empty and enable/disable sd_confirmBtn
    private void checkFieldsNotEmpty() {
        boolean fieldsNotEmpty = !sdDi_origin.getText().isEmpty()
                && !sdDi_destination.getText().isEmpty()
                && !sdDi_seatClass.getText().isEmpty()
                && !sdDi_farePrice.getText().isEmpty();

        sd_confirmBtn.setDisable(!fieldsNotEmpty);
    }

    // Function to switch forms
    private void switchForm(AnchorPane fromForm, AnchorPane toForm) {
        fromForm.setVisible(false);
        toForm.setVisible(true);
    }

    private void initCarousel() {
        Database countCarousel = new Database();
        int count = countCarousel.countCarousel();

        Database listLocations = new Database();
        ObservableList<String[]> locations = listLocations.listLocations();

        //Carousel
        Carousel carousel = new Carousel();

        AnchorPane[] slides = {c_slide1, c_slide2, c_slide3};
        carousel.addCarousel(slides, count, locations);
    }

    public void hoverFX() {
        ScaleTransition zoomIn = new ScaleTransition(Duration.seconds(0.5), image1);
        ScaleTransition zoomOut = new ScaleTransition(Duration.seconds(0.5), image1);

        image1.setOnMouseEntered(event -> {
            zoomIn.setFromX(1);
            zoomIn.setFromY(1);
            zoomIn.setToX(1.1);
            zoomIn.setToY(1.1);
            zoomIn.play();
        });

        image1.setOnMouseEntered(event -> {
            zoomOut.setFromX(1.1);
            zoomOut.setFromY(1.1);
            zoomOut.setToX(1);
            zoomOut.setToY(1);
            zoomOut.play();
        });

        ScaleTransition zoomIn1 = new ScaleTransition(Duration.seconds(0.5), image2);
        ScaleTransition zoomOut1 = new ScaleTransition(Duration.seconds(0.5), image2);

        image2.setOnMouseEntered(event -> {
            zoomIn1.setFromX(1);
            zoomIn1.setFromY(1);
            zoomIn1.setToX(1.1);
            zoomIn1.setToY(1.1);
            zoomIn1.play();
        });

        image2.setOnMouseEntered(event -> {
            zoomOut1.setFromX(1.1);
            zoomOut1.setFromY(1.1);
            zoomOut1.setToX(1);
            zoomOut1.setToY(1);
            zoomOut1.play();
        });

        ScaleTransition zoomIn2 = new ScaleTransition(Duration.seconds(0.5), image3);
        ScaleTransition zoomOut2 = new ScaleTransition(Duration.seconds(0.5), image3);

        image3.setOnMouseEntered(event -> {
            zoomIn2.setFromX(1);
            zoomIn2.setFromY(1);
            zoomIn2.setToX(1.1);
            zoomIn2.setToY(1.1);
            zoomIn2.play();
        });

        image3.setOnMouseEntered(event -> {
            zoomOut2.setFromX(1.1);
            zoomOut2.setFromY(1.1);
            zoomOut2.setToX(1);
            zoomOut2.setToY(1);
            zoomOut2.play();
        });

        ScaleTransition zoomIn3 = new ScaleTransition(Duration.seconds(0.5), image4);
        ScaleTransition zoomOut3 = new ScaleTransition(Duration.seconds(0.5), image4);

        image4.setOnMouseEntered(event -> {
            zoomIn3.setFromX(1);
            zoomIn3.setFromY(1);
            zoomIn3.setToX(1.1);
            zoomIn3.setToY(1.1);
            zoomIn3.play();
        });

        image4.setOnMouseEntered(event -> {
            zoomOut3.setFromX(1.1);
            zoomOut3.setFromY(1.1);
            zoomOut3.setToX(1);
            zoomOut3.setToY(1);
            zoomOut3.play();
        });
    }

    /* ---------------------------------------------- HFSearchDesti Functions Ends Here  ----------------------------------------- */
    private void switchAccForms() {
        // Set initial visibility
        acc_bookedFlights.setVisible(false);
        acc_pastTransaction.setVisible(false);

        // Handle acc_bookedFlightbtn click
        acc_bookedFlightbtn.setOnAction(event -> {
            acc_bookedFlights.setVisible(true);
            acc_pastTransaction.setVisible(false);
            acc_imgBg.setVisible(false);
        });

        // Handle acc_pastTransacbtn click
        acc_pastTransacbtn.setOnAction(event -> {
            acc_bookedFlights.setVisible(false);
            acc_pastTransaction.setVisible(true);
            acc_imgBg.setVisible(false);
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        hoverFX();
        switchAccForms();

        initCarousel();

        checkFieldsNotEmpty();

        Customer customer = Customer.getInstance();
        String username = customer.getUsername();
        System.out.println("User: " + username);
        displayUserName.setText(username);

        // Check seats
        try {
            checkSeats();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Initialize Table View
        loadFlightStat();
        loadDestinations();

        //Combo-Box initialize
        destiSearchBy();

        // Initialize the menu slider in the closed state
        closeMenuSlider();

        // Initialize the auto-slide timeline
        initializeAutoSlideTimeline();

        // Initialize the method to create twinkling stars
        initializeTwinklingStars();
        createTwinklingStarsForPane1();
        createTwinklingStarsForPane2();

        overlayPane.setVisible(false);
        overlayPane1.setVisible(false);

        // Add event handlers to the overlayPane and topPane
        overlayPane.setOnMouseClicked(event -> {
            if (menuOpen) {
                closeMenuSlider();
            }
        });

        // Make the starsPane visible when the application is running
        starsPane.setVisible(true);
        starsPane1.setVisible(true);

        // Switch Forms for home_form
        bookFlight_btn.setOnAction(e -> switchForm(hf_searchDesti, bookFlight_btn));

        // Return actions for home_form
        returnToHome_btn.setOnAction(e -> resetHomeForm());

        // Add listeners to cs_seatNum and cs_seatClass
        cs_seatNum.textProperty().addListener((observable, oldValue, newValue) -> updateProceedButtonState());
        cs_seatClass.textProperty().addListener((observable, oldValue, newValue) -> updateProceedButtonState());

        // Initially update the state of the proceed button
        updateProceedButtonState();

        // Initialize country combo-boxes
        initializeCountryComboBoxes();

        // Listeners for CardForm
        cardNumber.textProperty().addListener((observable, oldValue, newValue) -> updateCardNextButtonState());
        expirationDate.textProperty().addListener((observable, oldValue, newValue) -> updateCardNextButtonState());
        securityCode.textProperty().addListener((observable, oldValue, newValue) -> updateCardNextButtonState());
        cardOwner.textProperty().addListener((observable, oldValue, newValue) -> updateCardNextButtonState());

        c_country.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updateCardAddressButtonState());
        c_name.textProperty().addListener((observable, oldValue, newValue) -> updateCardAddressButtonState());
        c_address1.textProperty().addListener((observable, oldValue, newValue) -> updateCardAddressButtonState());
        c_address2.textProperty().addListener((observable, oldValue, newValue) -> updateCardAddressButtonState());
        c_city.textProperty().addListener((observable, oldValue, newValue) -> updateCardAddressButtonState());
        c_state.textProperty().addListener((observable, oldValue, newValue) -> updateCardAddressButtonState());
        c_postalCode.textProperty().addListener((observable, oldValue, newValue) -> updateCardAddressButtonState());

        // Listeners for GcashForm
        g_country.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updateGcashButtonState());
        g_name.textProperty().addListener((observable, oldValue, newValue) -> updateGcashButtonState());
        g_address1.textProperty().addListener((observable, oldValue, newValue) -> updateGcashButtonState());
        g_address2.textProperty().addListener((observable, oldValue, newValue) -> updateGcashButtonState());
        g_city.textProperty().addListener((observable, oldValue, newValue) -> updateGcashButtonState());
        g_state.textProperty().addListener((observable, oldValue, newValue) -> updateGcashButtonState());
        g_postalCode.textProperty().addListener((observable, oldValue, newValue) -> updateGcashButtonState());

        // Listeners for PaypalForm
        p_phoneNumber.textProperty().addListener((observable, oldValue, newValue) -> updatePaypalButtonState());

        updateCardNextButtonState();
        updateCardAddressButtonState();
        updateGcashButtonState();
        updatePaypalButtonState();

        topPane1.setVisible(true);

        /*------------------------------CONSTRAINTS FOR TEXTFIELDS ON PAYMENT FORM--------------------------*/
        // Set up event handler to add auto-spacing every 4 digits for cardNumber
        cardNumber.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String text = cardNumber.getText();
            if (!event.getCharacter().matches("[0-9/]")) {
                event.consume();
            } else if (text.length() == 4 || text.length() == 9 || text.length() == 14) {
                cardNumber.setText(text + " ");
                cardNumber.positionCaret(cardNumber.getLength() + 1);
            } else if (text.length() >= 19) {
                event.consume();
            }
        });

        // Set up event handler to limit the total length to 19 characters for cardNumber
        cardNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 19) {
                cardNumber.setText(oldValue);
            }
        });

        // Set up event handler for expirationDate to allow only MM/YY format
        expirationDate.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String text = expirationDate.getText();
            if (!event.getCharacter().matches("[0-9/]")) {
                event.consume();
            } else if (text.length() == 2 && event.getCharacter().matches("[0-9]")) {
                expirationDate.setText(text + " / ");
                expirationDate.positionCaret(expirationDate.getLength() + 1);
            } else if (text.length() >= 7) {
                event.consume();
            }
        });

        // Set up event handler for expirationDate to limit the total length to 5 characters
        expirationDate.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 7) {
                expirationDate.setText(oldValue);
            }
        });

        // Set up event handler for securityCode to allow only 3 numbers
        securityCode.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[0-9]")) {
                event.consume();
            }
        });

        // Set up event handler to limit the total length to 3 digits for securityCode
        securityCode.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 3) {
                securityCode.setText(oldValue);
            }
        });

        // Set up event handler to restrict input to strings only for cardOwner
        cardOwner.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s]")) {
                event.consume();
            }
        });

        /*------- Set up event handler to restrict input to strings only for Card Form TextFields ------------*/
        c_country.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s]")) {
                event.consume();
            }
        });

        c_name.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s\\.]")) {
                event.consume();
            }
        });

        c_city.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s]")) {
                event.consume();
            }
        });

        c_state.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s]")) {
                event.consume();
            }
        });

        // Set up event handler to restrict input to integers only for c_postalCode
        c_postalCode.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[0-9]")) {
                event.consume();
            }
        });

        // Set up event handler to limit the total length to 16 digits for c_postalCode
        c_postalCode.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 4) {
                c_postalCode.setText(oldValue);
            }
        });

        /*------- Set up event handler to restrict input to strings only for Gcash Form TextFields ------------*/
        g_country.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s]")) {
                event.consume();
            }
        });

        g_name.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s\\.]")) {
                event.consume();
            }
        });

        g_city.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s]")) {
                event.consume();
            }
        });

        g_state.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s]")) {
                event.consume();
            }
        });

        // Set up event handler to restrict input to integers only for g_postalCode
        g_postalCode.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[0-9]")) {
                event.consume();
            }
        });

        // Set up event handler to limit the total length to 4 digits for g_postalCode
        g_postalCode.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 4) {
                g_postalCode.setText(oldValue);
            }
        });

        /*------- Set up event handler to restrict input to strings only for Paypal Form TextFields ------------*/
        // Set up event handler to restrict input to integers only for p_phoneNumber
        p_phoneNumber.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[0-9]")) {
                event.consume();
            }
        });

        // Set up event handler to limit the total length to 11 digits for p_phoneNumber
        p_phoneNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 11) {
                p_phoneNumber.setText(oldValue);
            }
        });

        /*------- Set up event handler to restrict input to strings only for hf_bookFlight Form TextFields ------------*/
        f_name.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s\\.]")) {
                event.consume();
            }
        });

        m_name.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s\\.]")) {
                event.consume();
            }
        });

        l_name.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s\\.]")) {
                event.consume();
            }
        });

        suffix.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[a-zA-Z\\s\\.]")) {
                event.consume();
            }
        });

        // Set up event handler to restrict input to integers only for age
        age.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("[0-9]")) {
                event.consume();
            }
        });

        // Set up event handler to limit the total length to 3 digits for age
        age.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 3) {
                age.setText(oldValue);
            }
        });

        seat_icon.setVisible(true);
        // Disable all anchor panes by default
        firstC_seats.setVisible(false);
        businessC_seats.setVisible(false);
        premEconomyC_seats.setVisible(false);
        economyC_seats.setVisible(false);

        cs_seatClass.textProperty().addListener((observable, oldValue, newValue) -> {
            // Disable all anchor panes by default
            firstC_seats.setVisible(false);
            businessC_seats.setVisible(false);
            premEconomyC_seats.setVisible(false);
            economyC_seats.setVisible(false);

            // Enable the selected anchor pane based on the combo box value
            if ("ECONOMY".equals(newValue)) {
                economyC_seats.setVisible(true);
                seat_icon.setVisible(false);

                // Initialize chooseseat buttons
                try {
                    seatButtons();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            } else if ("BUSINESS".equals(newValue)) {
                businessC_seats.setVisible(true);
                seat_icon.setVisible(false);

                // Initialize chooseseat buttons
                try {
                    seatButtons();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            } else if ("PREMIUM ECONOMY".equals(newValue)) {
                premEconomyC_seats.setVisible(true);
                seat_icon.setVisible(false);

                // Initialize chooseseat buttons
                try {
                    seatButtons();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            } else if ("FIRST CLASS".equals(newValue)) {
                firstC_seats.setVisible(true);
                seat_icon.setVisible(false);

                // Initialize chooseseat buttons
                try {
                    seatButtons();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        cs_origin.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                seatButtons();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        // Auto requery when something is changed within the database
        // Create a timeline for periodic polling (adjust the Duration as needed)
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(30), event -> {
            // Code to re-query the database goes here
            System.out.println("Re-querying");

            try {
                seatButtons();

            } catch (SQLException ex) {
                Logger.getLogger(HomepageController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

            try {
                checkSeats();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        fare_price.textProperty().addListener((observable, oldValue, newValue) -> {
            // Update pf_farePrice and pf_farePrice1 labels based on the new value
            updateFarePriceLabels(newValue);
        });

        // Handle sd_confirmBtn click
        sd_confirmBtn.setOnAction(event -> handleConfirmButtonClick());

        // Add a listener to all text fields for enabling/disabling sd_confirmBtn
        sdDi_origin.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsNotEmpty());
        sdDi_destination.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsNotEmpty());
        sdDi_seatClass.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsNotEmpty());
        sdDi_farePrice.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsNotEmpty());

        // Add listener to ComboBox
        sd_searchBy.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Check if the selected value is null or empty
            boolean isSearchByEmpty = newValue == null || newValue.isEmpty();

            // Enable or disable the TextField accordingly
            sd_searchByText.setDisable(isSearchByEmpty);
        });

        // Initial check to disable the TextField if ComboBox is initially empty
        sd_searchByText.setDisable(sd_searchBy.getValue() == null || sd_searchBy.getValue().isEmpty());

        book_btn.setDisable(true);
        checkBox_btn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            // Check the state of checkBox_Btn and disable book_btn accordingly
            book_btn.setDisable(!newValue);
        });

        acc_flightStatusBTN.setOnAction(e -> {
            switchAccForms();
            acc_imgBg.setVisible(true);
            flightStats_form.setVisible(true);
            account_form.setVisible(false);
            
        });

    }
}
