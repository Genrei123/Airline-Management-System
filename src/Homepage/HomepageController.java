package Homepage;

import Animations.SwitchForms;
import Database.Database;
import LogIn.AlertManager;
import Receipt.TicketMaker;
import Receipt.TicketNo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;

import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.textfield.TextFields;

public class HomepageController implements Initializable {

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
    private AnchorPane account_form;

    @FXML
    private AnchorPane customerSupp_form;

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
    private JFXTextField cs_origin;

    @FXML
    private JFXTextField cs_seatNum;

    @FXML
    private JFXTextField cs_price;

    @FXML
    private JFXComboBox<String> cs_seatClass;

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
    private JFXComboBox<String> sd_origin;

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
    private JFXDatePicker booking_date;

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
    private JFXButton cs_rebookingBtn, cs_changeInfoBtn, cs_contactUsBTN, cs_return;

    @FXML
    private AnchorPane cs_changeInfoForm, cs_reBookingform, background, cs_chat;

    @FXML
    private ComboBox<String> cs_rebookingCombo;

    @FXML
    private DatePicker cs_rebookingDate;

    @FXML
    private TextField cs_rebookingTicketNo, cs_rebookingLastName, cs_rebookingFeedback, cs_rebookingActive;

    @FXML
    private Label cs_alert;

    @FXML
    private JFXButton booking_btn1, booking_btn2, booking_btn3, booking_btn4, booking_btn5,
            booking_btn6, booking_btn7, booking_btn8, booking_btn9;

    @FXML
    private Label sdCl_origin, sdCl_origin1, sdCl_origin2, sdCl_origin3, sdCl_origin4,
            sdCl_origin5, sdCl_origin6, sdCl_origin7, sdCl_origin8,
            sdCl_destination, sdCl_destination1, sdCl_destination2,
            sdCl_destination3, sdCl_destination4, sdCl_destination5, sdCl_destination6,
            sdCl_destination7, sdCl_destination8;
    ;

    @FXML
    private JFXComboBox<String> sd_checkPrice;

    @FXML
    private Label sdCl_price, sdCl_price1, sdCl_price2, sdCl_price3, sdCl_price4, sdCl_price5, sdCl_price6, sdCl_price7, sdCl_price8;

    @FXML
    private TableView<String[]> flightStatTable;

    @FXML
    private TableColumn<String[], String> fs_airplaneID, fs_flightNo, fs_destination, fs_origin, fs_status, fs_departDate, fs_arrivalDate;

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

    // Call this method in your initialize method to create twinkling stars for starsPane1
    private void initializeTwinklingStars() {
        createTwinklingStars();  // For starsPane
        createTwinklingStarsForPane1();  // For starsPane1
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
            show = 1;
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

    private void CSswitchForm(AnchorPane targetForm, JFXButton selectedButton) {
        background.setVisible(false);
        cs_changeInfoForm.setVisible(false);
        cs_reBookingform.setVisible(false);
        cs_chat.setVisible(false);
        // Show the selected form
        targetForm.setVisible(true);

        String targetName = targetForm.getId();
        System.out.println(targetName);
    }

    //SWITCH FORM FUNCTIONS FOR home_form
    public void switchForm(ActionEvent event) {
        if (event.getSource() == menu_home) {
            //For PARENT FORMS
            home_form.setVisible(true);
            flightStats_form.setVisible(false);
            customerSupp_form.setVisible(false);
            account_form.setVisible(false);
            top_form.setVisible(false);
            aboutUs_form.setVisible(false);

            //For home_form
            hf_home.setVisible(true);
            hf_searchDesti.setVisible(false);
            hf_chooseSeat.setVisible(false);
            hf_bookFlight.setVisible(false);
        } else if (event.getSource() == menu_flightStats) {
            home_form.setVisible(false);
            flightStats_form.setVisible(true);
            customerSupp_form.setVisible(false);
            account_form.setVisible(false);
            top_form.setVisible(false);
            aboutUs_form.setVisible(false);

        } else if (event.getSource() == menu_customerSupp) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            customerSupp_form.setVisible(true);
            account_form.setVisible(false);
            top_form.setVisible(false);
            aboutUs_form.setVisible(false);
        } else if (event.getSource() == menu_account) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            customerSupp_form.setVisible(false);
            account_form.setVisible(true);
            top_form.setVisible(false);
            aboutUs_form.setVisible(false);
        } else if (event.getSource() == menu_TOP) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            customerSupp_form.setVisible(false);
            account_form.setVisible(false);
            top_form.setVisible(true);
            aboutUs_form.setVisible(false);
        } else if (event.getSource() == menu_aboutUs) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            customerSupp_form.setVisible(false);
            account_form.setVisible(false);
            top_form.setVisible(false);
            aboutUs_form.setVisible(true);
        }
    }

    public void handleNextButtonClick(ActionEvent event) throws SQLException, IOException {
        // Determine which button was clicked
        Button clickedButton = (Button) event.getSource();

        // Check the ID or other properties of the button
        if (clickedButton.getId().equals("c_nextBtn2") || clickedButton.getId().equals("g_nextBtn") || clickedButton.getId().equals("p_nextBtn")) {
            // Code for c_nextBtn2, g_nextBtn, and p_nextBtn

            // Insert data into the database
            insertDataIntoDatabase();
            clearPaymentForms();
            clearBookSelectionFields();
            // Set payment_form visibility to false
            payment_form.setVisible(false);
            overlayPane1.setVisible(false);
            // Show notification
            showNotification();
            switchForm(hf_searchDesti, returnToDesti_btn1);
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

    public String generateFlightID(String prefix) {
        Random random = new Random();
        int randomNum = random.nextInt(900) + 100;

        return prefix + randomNum;
    }

    private void insertDataIntoDatabase() throws SQLException, IOException {
        // First check if flight_id is UNIQUE
        String flight_id;
        Database check_flight_id = new Database();
        Boolean isflight_id = check_flight_id.isFlightUnique(destination.getText(), origin.getText());

        if (!isflight_id) {
            // Means that the flight is unique
            // Create new flight_id
            flight_id = generateFlightID("ERM");

            // Insert into database
            Database insertFlight = new Database();
            insertFlight.insertData(
                    "flight_records",
                    Arrays.asList("flight_id", "destination", "origin", "passenger_number"),
                    Arrays.asList(flight_id, destination.getText(), origin.getText(), 1)
            );

            // Check if the flight reaches 80 seats
            Database booked_passengers = new Database();
            int counter = booked_passengers.flightCount(destination.getText(), origin.getText());

            if (counter < 80 && counter > 0) {
                System.out.println("Flight is full");

                // Get the flight_id of the flight
                Database getflight_id = new Database();
                flight_id = getflight_id.getFlightID(
                        destination.getText(),
                        origin.getText()
                );

                // Update passenger number
                Database updatePassengerNumber = new Database();
                updatePassengerNumber.updateData(
                        "flight_records",
                        Collections.singletonList("passenger_number"),
                        Collections.singletonList("passenger_number + 1"),
                        Collections.singletonList("flight_id"),
                        Collections.singletonList(flight_id)
                );

                // Insert Data into booked_flights
                Database insertBookedFlights = new Database();
                insertBookedFlights.insertData(
                        "booked_flights",
                        Arrays.asList("flight_id", "first_name", "middle_name", "last_name", "suffix", "age", "booking_date", "seat_class", "seat_number", "fare_price"),
                        Arrays.asList(flight_id, f_name.getText(), m_name.getText(), l_name.getText(), suffix.getText(), age.getText(), booking_date.getValue().toString(), s_class.getText(), seat.getText(), fare_price.getText())
                );


            } else if (counter == 80) {
                System.out.println("Flight is full");
                // Update flight_manager
                Database updateFlightManager = new Database();
                updateFlightManager.updateData(
                        "flight_manager",
                        Collections.singletonList("status"),
                        Collections.singletonList("CLOSED"),
                        Collections.singletonList("flight_id"),
                        Collections.singletonList(flight_id)
                );

                
            }
        }

        else {
                // Means that the flight is not unique
                // Get the flight_id of the flight
                Database getflight_id = new Database();
                flight_id = getflight_id.getFlightID(destination.getText(), origin.getText());

                // Update the passenger_number of the flight
                Database updatePassengerNumber = new Database();
                updatePassengerNumber.updateData(
                        "flight_records",
                        Collections.singletonList("passenger_number"),
                        Collections.singletonList("passenger_number + 1"),
                        Collections.singletonList("flight_id"),
                        Collections.singletonList(flight_id)
                );
        }
    }


    //and Except middle name
    private boolean areAllFieldsExceptSuffixEmpty() {
        return f_name.getText().isEmpty()
                && l_name.getText().isEmpty()
                && age.getText().isEmpty()
                && (booking_date.getValue() == null) // Check if JFXDatePicker value is null
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
                || isNullOrEmpty(booking_date)
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

    // Method to check if a JFXDatePicker is null or its value is empty
    private boolean isNullOrEmpty(JFXDatePicker datePicker) {
        return datePicker == null || datePicker.getValue() == null;
    }

    //COMBO-BOX for Seat Class
    private String[] classList = {"ECONOMY", "PREMIUM ECONOMY", "BUSINESS", "FIRST CLASS"};

    public void seatClass() {
        List<String> listC = new ArrayList<>();

        listC.addAll(Arrays.asList(classList));

        ObservableList listData = FXCollections.observableArrayList(listC);
        cs_seatClass.setItems(listData);
    }

    // Method to clear seat selection fields
    private void clearSeatSelectionFields() {
        cs_seatNum.clear();
        cs_seatClass.getSelectionModel().clearSelection(); // Clear the selection
    }

    // Method to clear seat selection fields
    private void clearBookSelectionFields() {
        f_name.clear();
        m_name.clear();
        l_name.clear();
        suffix.clear();
        age.clear();

    }

    // Method to handle return to destination button click
    public void handleReturnToDestiButtonClick() {
        switchForm(hf_searchDesti, returnToDesti_btn);
        clearSeatSelectionFields();
    }
    
    // Method to handle return to destination button click
    public void handleReturnToChooseSeatButtonClick() {
        switchForm(hf_chooseSeat, returnToDesti_btn1);
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

        // Check if cs_seatClass has a selected item before accessing it
        if (cs_seatClass.getSelectionModel().getSelectedItem() != null) {
            s_class.setText(cs_seatClass.getSelectionModel().getSelectedItem());
        }
    }

    // Method to update the state of the proceed button based on cs_seatNum and cs_seatClass
    private void updateProceedButtonState() {
        boolean isDisabled = cs_seatNum.getText().isEmpty() || cs_seatClass.getSelectionModel().isEmpty();
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

    public void closeForm() {
        clearPaymentForms(); // Clear fields in paymentForms
        // Hide the overlayPane1 and main_form
        overlayPane1.setVisible(false);
        payment_form.setVisible(false);
        paymentForms.setVisible(true);

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
                || c_address2.getText().isEmpty()
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
                || g_address2.getText().isEmpty()
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
        return !cs_origin.getText().isEmpty() && !cs_destination.getText().isEmpty() && !cs_seatClass.getSelectionModel().isEmpty();
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

            // Iterate over each seat button
            for (JFXButton seatButton : seatButtons) {
                String seatLabel = seatButton.getText();

                if (db.checkSeats(seatLabel, cs_origin.getText(), cs_destination.getText())) {
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

    public void handleChangeInfoButtonClick() {
        CSswitchForm(cs_changeInfoForm, cs_rebookingBtn);
    }

    public void handleRebookingButtonClick() {
        CSswitchForm(cs_reBookingform, cs_changeInfoBtn);

        // Initialize combo box
        cs_rebookingCombo.getItems().addAll(
                "Move Departure Date",
                "Move Arrival Date");
    }

    public void handleReturnButton() {
        CSswitchForm(background, cs_return);
    }

    public void handleChatButtonClick() {
        CSswitchForm(cs_chat, cs_contactUsBTN);
    }

    public void handleRebooking() throws SQLException {
        // Check for empty fields
        if (cs_rebookingTicketNo.getText().isEmpty() || cs_rebookingLastName.getText().isEmpty() || cs_rebookingFeedback.getText().isEmpty() || cs_rebookingActive.getText().isEmpty() || cs_rebookingDate.getValue() == null) {
            AlertManager alert = new AlertManager(cs_alert);
            alert.setAlertText("Please fill in all required fields.", "red");

            // Schedule a task to hide the alert after 5 seconds
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished(event -> alert.hideAlert());
            delay.play();
            return;
        }

        String issue = cs_rebookingCombo.getValue();
        String ticketNo = cs_rebookingTicketNo.getText();
        String last_name = cs_rebookingLastName.getText();
        String feedback = cs_rebookingFeedback.getText();
        String active = cs_rebookingActive.getText();
        LocalDate date = cs_rebookingDate.getValue();

        // Check if flight exists
        Database db = new Database();

        if (db.checkFlight(ticketNo, last_name)) {
            // Insert into database.
            db.insertData(
                    "customer_support",
                    Arrays.asList("name", "ticket_no", "reason", "contact", "feedback", "status", "preferred_date"),
                    Arrays.asList(last_name, ticketNo, issue, active, feedback, "Pending", date)
            );

            AlertManager alert = new AlertManager(cs_alert);
            alert.setAlertText("Rebooking request sent.", "green");

        } else {
            System.out.println("Flight does not exist!");

            AlertManager alert = new AlertManager(cs_alert);
            alert.setAlertText("Flight does not exist!", "red");

            System.out.println(last_name + " " + ticketNo);
        }
    }

    // COMBO-BOX for Origin
    private String[] originList = {"BORACAY", "PALAWAN", "DAVAO", "MANILA", "BOHOL", "CEBU", "SIARGAO", "BAGUIO", "ILO-ILO"};

    public void originDesti() {
        // Populate ComboBox with origin locations
        sd_origin.getItems().addAll(originList);

        // Set listener for changes in the selected item
        sd_origin.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            // Update sdCl_origin with the selected location
            sdCl_origin.setText(newValue);
            sdCl_origin1.setText(newValue);
            sdCl_origin2.setText(newValue);
            sdCl_origin3.setText(newValue);
            sdCl_origin4.setText(newValue);
            sdCl_origin5.setText(newValue);
            sdCl_origin6.setText(newValue);
            sdCl_origin7.setText(newValue);
            sdCl_origin8.setText(newValue);

            // Update sdCl_destination buttons excluding the selected location
            updateSdClDestinations(newValue);
        });
    }

    private void updateSdClDestinations(String selectedLocation) {
        // Assuming sdCl_destination to sdCl_destination8 are your text fields
        List<Label> sdClDestinations = Arrays.asList(sdCl_destination, sdCl_destination1, sdCl_destination2, sdCl_destination3, sdCl_destination4, sdCl_destination5, sdCl_destination6, sdCl_destination7, sdCl_destination8);

        // Hide the 9th text field
        sdClDestinations.get(8).setVisible(false);

        // Update sdCl_destination text fields with locations excluding the selected location
        int index = 0;
        for (String location : originList) {
            if (!location.equals(selectedLocation)) {
                sdClDestinations.get(index).setText(location);
                sdClDestinations.get(index).setVisible(true);
                index++;

                // Break the loop if all text fields are updated
                if (index >= sdClDestinations.size()) {
                    break;
                }
            }
        }
        // Hide any remaining text fields if there are more text fields than locations
        for (int i = index; i < sdClDestinations.size(); i++) {
            sdClDestinations.get(i).setVisible(false);
        }

        // Assuming booking_btn9 is a button, hide it
        booking_btn9.setVisible(false);
    }

    public void priceClass() {
        List<String> listP = new ArrayList<>(Arrays.asList("ECONOMY", "PREMIUM ECONOMY", "BUSINESS", "FIRST CLASS"));

        ObservableList<String> listData = FXCollections.observableArrayList(listP);
        sd_checkPrice.setItems(listData);
    }

    // Prices based on seat class and location
    private Map<String, Map<String, Integer>> priceMap = new HashMap<>();

    private void initPriceMap() {
        // Initialize the price map with prices based on seat class and location
        // Prices are stored as (origin, destination) -> price
        // Note: Adjust the prices based on your actual requirements
        priceMap.put("FIRST CLASS", new HashMap<String, Integer>() {
            {
                put("MANILA", 4999);
                put("BORACAY", 5499);
                put("PALAWAN", 5999);
                put("CEBU", 3499);
                put("DAVAO", 4499);
                put("BOHOL", 3499);
                put("SIARGAO", 4999);
                put("BAGUIO", 3499);
                put("ILO-ILO", 4499);
            }
        });

        priceMap.put("BUSINESS", new HashMap<String, Integer>() {
            {
                put("MANILA", 4299);
                put("PALAWAN", 5499);
                put("CEBU", 3000);
                put("DAVAO", 4000);
                put("BOHOL", 3000);
                put("BORACAY", 5499);
                put("SIARGAO", 4499);
                put("BAGUIO", 3000);
                put("ILO-ILO", 4000);
            }
        });

        priceMap.put("PREMIUM ECONOMY", new HashMap<String, Integer>() {
            {
                put("MANILA", 4000);
                put("PALAWAN", 5000);
                put("CEBU", 2500);
                put("DAVAO", 3500);
                put("BOHOL", 2500);
                put("BORACAY", 5499);
                put("SIARGAO", 4499);
                put("BAGUIO", 3000);
                put("ILO-ILO", 4000);
            }
        });

        priceMap.put("ECONOMY", new HashMap<String, Integer>() {
            {
                put("MANILA", 1000);
                put("PALAWAN", 1000);
                put("CEBU", 1000);
                put("DAVAO", 1000);
                put("BOHOL", 1000);
                put("BORACAY", 1000);
                put("SIARGAO", 1000);
                put("BAGUIO", 1000);
                put("ILO-ILO", 1000);
            }
        });
        // ... Add more seat classes as needed
    }

    private void updateSdClPrices(String selectedSeatClass, List<Label> destinationLabels) {
        // Get the prices based on the selected seat class
        Map<String, Integer> prices = priceMap.getOrDefault(selectedSeatClass, Collections.emptyMap());

        for (int i = 0; i < destinationLabels.size(); i++) {
            Label destinationLabel = destinationLabels.get(i);
            String selectedDestination = destinationLabel.getText();

            // Get the price for the selected destination
            Integer selectedDestinationPrice = prices.get(selectedDestination);

            if (selectedDestinationPrice != null) {
                // Update the corresponding sdCl_price label for the matching destination
                switch (i) {
                    case 0:
                        sdCl_price.setText(String.valueOf(selectedDestinationPrice));
                        break;
                    case 1:
                        sdCl_price1.setText(String.valueOf(selectedDestinationPrice));
                        break;
                    case 2:
                        sdCl_price2.setText(String.valueOf(selectedDestinationPrice));
                        break;
                    case 3:
                        sdCl_price3.setText(String.valueOf(selectedDestinationPrice));
                        break;
                    case 4:
                        sdCl_price4.setText(String.valueOf(selectedDestinationPrice));
                        break;
                    case 5:
                        sdCl_price5.setText(String.valueOf(selectedDestinationPrice));
                        break;
                    case 6:
                        sdCl_price6.setText(String.valueOf(selectedDestinationPrice));
                        break;
                    case 7:
                        sdCl_price7.setText(String.valueOf(selectedDestinationPrice));
                        break;
                    case 8:
                        sdCl_price8.setText(String.valueOf(selectedDestinationPrice));
                        break;
                    // Add more cases for the remaining labels if needed
                }
            } else {
                // Hide the label if no price is found for the destination
                switch (i) {
                    case 0:
                        sdCl_price.setText("");
                        break;
                    case 1:
                        sdCl_price1.setText("");
                        break;
                    case 2:
                        sdCl_price2.setText("");
                        break;
                    case 3:
                        sdCl_price3.setText("");
                        break;
                    case 4:
                        sdCl_price4.setText("");
                        break;
                    case 5:
                        sdCl_price5.setText("");
                        break;
                    case 6:
                        sdCl_price6.setText("");
                        break;
                    case 7:
                        sdCl_price7.setText("");
                        break;
                    case 8:
                        sdCl_price8.setText("");
                        break;
                    // Add more cases for the remaining labels if needed
                }
            }
        }
    }

    // Add this method to set the state of booking buttons (enable/disable)
    private void setBookingButtonsEnabled(boolean enabled) {
        List<JFXButton> bookingButtons = Arrays.asList(
                booking_btn1, booking_btn2, booking_btn3, booking_btn4, booking_btn5,
                booking_btn6, booking_btn7, booking_btn8, booking_btn9
        );

        for (JFXButton bookingButton : bookingButtons) {
            bookingButton.setDisable(!enabled);
        }
    }

    // Function to update cs_destination based on the clicked button
    private void updateCsDestination(JFXButton bookingButton) {
        String destinationText = "";

        // Switch based on the clicked button and update cs_destination accordingly
        switch (bookingButton.getId()) {
            case "booking_btn1":
                destinationText = sdCl_destination.getText();
                break;
            case "booking_btn2":
                destinationText = sdCl_destination1.getText();
                break;
            case "booking_btn3":
                destinationText = sdCl_destination2.getText();
                break;
            case "booking_btn4":
                destinationText = sdCl_destination3.getText();
                break;
            case "booking_btn5":
                destinationText = sdCl_destination4.getText();
                break;
            case "booking_btn6":
                destinationText = sdCl_destination5.getText();
                break;
            case "booking_btn7":
                destinationText = sdCl_destination6.getText();
                break;
            case "booking_btn8":
                destinationText = sdCl_destination7.getText();
                break;
        }

        // Update cs_destination text field
        cs_destination.setText(destinationText);

        // Update sd_price based on the clicked button
        updateSdPrice(bookingButton);
    }

    // Function to update sd_price based on the clicked button
    private void updateSdPrice(JFXButton bookingButton) {
        String priceText = "";

        // Switch based on the clicked button and update sd_price accordingly
        switch (bookingButton.getId()) {
            case "booking_btn1":
                priceText = sdCl_price.getText();
                break;
            case "booking_btn2":
                priceText = sdCl_price1.getText();
                break;
            case "booking_btn3":
                priceText = sdCl_price2.getText();
                break;
            case "booking_btn4":
                priceText = sdCl_price3.getText();
                break;
            case "booking_btn5":
                priceText = sdCl_price4.getText();
                break;
            case "booking_btn6":
                priceText = sdCl_price5.getText();
                break;
            case "booking_btn7":
                priceText = sdCl_price6.getText();
                break;
            case "booking_btn8":
                priceText = sdCl_price7.getText();
                break;
        }

        // Update cs_price text field
        cs_price.setText(priceText);
    }

    private void updateCsPrice(String selectedSeatClass) {
        // Get the prices based on the selected seat class
        Map<String, Integer> prices = priceMap.getOrDefault(selectedSeatClass, Collections.emptyMap());

        // Assuming cs_price is the TextField where you want to display the price
        cs_price.clear();  // Clear any previous value

        // Get the price for the selected destination
        Integer selectedDestinationPrice = prices.get(cs_destination.getText());  // Assuming cs_destination is the selected destination

        if (selectedDestinationPrice != null) {
            // Update the cs_price TextField with the selected destination's price
            cs_price.setText(String.valueOf(selectedDestinationPrice));
        } else {
            // Handle the case where no price is found for the selected destination
            cs_price.setText("N/A");  // Replace "N/A" with your desired default value or an empty string
        }
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initialize flight stat
        loadFlightStat();

        //Combo-Box initialize
        seatClass();
        originDesti();
        priceClass();

        // Initialize the menu slider in the closed state
        closeMenuSlider();

        // Initialize the auto-slide timeline
        initializeAutoSlideTimeline();

        // Initialize the method to create twinkling stars
        initializeTwinklingStars();
        createTwinklingStarsForPane1();

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

        //Clear textFields of hf_chooseSeat textFields
        //returnToDesti_btn.setOnAction(e -> handleReturnToDestiButtonClick());
        //returnToDesti_btn1.setOnAction(e -> handleReturnToChooseSeatButtonClick());

        // Return actions for home_form
        returnToHome_btn.setOnAction(e -> switchForm(hf_home, returnToHome_btn));

        // Add listeners to cs_seatNum and cs_seatClass
        cs_seatNum.textProperty().addListener((observable, oldValue, newValue) -> updateProceedButtonState());
        cs_seatClass.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updateProceedButtonState());

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

        cs_seatClass.valueProperty().addListener((observable, oldValue, newValue) -> {
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
                Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Initialize price map
        initPriceMap();

        List<Label> destinationLabels = Arrays.asList(sdCl_destination, sdCl_destination1, sdCl_destination2, sdCl_destination3, sdCl_destination4, sdCl_destination5, sdCl_destination6, sdCl_destination7, sdCl_destination8);

        sd_checkPrice.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            // Update sdCl_price labels with the selected seat class and destination
            updateSdClPrices(newValue, destinationLabels);
        });

        // Set listener for changes in the selected item in sdCl_origin
        sdCl_origin.textProperty().addListener((observable, oldOrigin, newOrigin) -> {
            // Get the selected seat class
            String selectedSeatClass = sd_checkPrice.getValue(); // Assuming sd_checkPrice is a ComboBox<String>

            // Update sdCl_price labels with the selected seat class and destination
            updateSdClPrices(selectedSeatClass, destinationLabels);
        });

        // Set listener for changes in the selected item in sdCl_origin
        sdCl_origin.textProperty().addListener((observable, oldOrigin, newOrigin) -> {
            // Update cs_origin text field with the selected origin
            cs_origin.setText(newOrigin);

            // Update sdCl_destination text fields with locations excluding the selected location
            updateSdClDestinations(newOrigin);
        });

        // Switch Forms for home_form when any of the booking buttons is clicked
        List<JFXButton> bookingButtons = Arrays.asList(
                booking_btn1, booking_btn2, booking_btn3, booking_btn4, booking_btn5,
                booking_btn6, booking_btn7, booking_btn8, booking_btn9);

        for (JFXButton bookingButton : bookingButtons) {
            bookingButton.setOnAction(e -> {
                // Update cs_destination based on the clicked button
                updateCsDestination(bookingButton);
                // Update cs_seatClass based on the selected item from sd_checkPrice
                cs_seatClass.setValue(sd_checkPrice.getValue());
                // Switch to hf_chooseSeat form
                switchForm(hf_chooseSeat, bookingButton);

                try {
                    // Call seatButtons after switching the form
                    seatButtons();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
        }

        // Set the text of cs_origin with the selected item from sd_origin
        sd_origin.valueProperty().addListener((observable, oldOrigin, newOrigin) -> {
            cs_origin.setText(newOrigin);
        });

        // Initialize the disable state of booking buttons based on sd_origin and sd_checkPrice
        setBookingButtonsEnabled(sd_origin.getValue() != null && !sd_origin.getValue().trim().isEmpty() && sd_checkPrice.getValue() != null && !sd_checkPrice.getValue().trim().isEmpty());

        // Add a listener to sd_origin ComboBox
        sd_origin.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Check if sd_origin is empty
            boolean isSdOriginEmpty = newValue == null || newValue.trim().isEmpty();

            // Set the state of booking buttons based on both sd_origin and sd_checkPrice
            setBookingButtonsEnabled(!isSdOriginEmpty && sd_checkPrice.getValue() != null && !sd_checkPrice.getValue().trim().isEmpty());
        });

        // Add a listener to sd_checkPrice ComboBox
        sd_checkPrice.valueProperty().addListener((observable, oldPrice, newPrice) -> {
            // Clear existing items and add the new price to cs_seatClass
            cs_seatClass.getItems().clear();
            cs_seatClass.getItems().addAll("ECONOMY", "PREMIUM ECONOMY", "BUSINESS", "FIRST CLASS");
            // Select the new price
            cs_seatClass.getSelectionModel().select(newPrice);

            // Enable or disable booking buttons based on both sd_origin and sd_checkPrice
            setBookingButtonsEnabled(sd_origin.getValue() != null && !sd_origin.getValue().trim().isEmpty() && newPrice != null && !newPrice.trim().isEmpty());
        });

        cs_seatClass.valueProperty().addListener((observable, oldSeatClass, newSeatClass) -> {
            updateCsPrice(newSeatClass);
        });
    }
}
