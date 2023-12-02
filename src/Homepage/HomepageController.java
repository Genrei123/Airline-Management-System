package Homepage;

import Animations.SwitchForms;
import Database.Database;
import LogIn.Admin;
import LogIn.AlertManager;
import Receipt.ReceiptMaker;
import Receipt.TicketNo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;

import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.stage.StageHelper;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
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
    private AnchorPane whereWeFly_form;

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
    private JFXComboBox<?> cs_seatClass;

    @FXML
    private JFXButton seat_a1;

    @FXML
    private JFXButton seat_a2;

    @FXML
    private JFXButton seat_a3;

    @FXML
    private JFXButton seat_a4, seat_a5, seat_a6, seat_a7, seat_a8, seat_a11, seat_a21,
    seat_a31, seat_a41, seat_a51, seat_a61, seat_a71, seat_a81, seat_b91,
    seat_b101, seat_b111, seat_b121, seat_b131, seat_b141, seat_b151, seat_b161, seat_b171,
    seat_b181, seat_b191, seat_b201, seat_b211, seat_b221, seat_b231, seat_b241;

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
    private JFXButton booking_btn4;

    @FXML
    private JFXButton booking_btn3;

    @FXML
    private JFXButton booking_btn2;

    @FXML
    private JFXButton booking_btn1;

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
    private JFXComboBox<?> typeOfPayment;

    @FXML
    private Label book_alert;

    @FXML
    private JFXDatePicker birth_date;

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
    private TextField f_name, m_name, l_name, suffix, age, destination, origin, s_class, seat;

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
        Duration duration = Duration.seconds(5); // adjust the duration as needed
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

    //SWITCH FORM FUNCTIONS FOR home_form
    public void switchForm(ActionEvent event) {
        if (event.getSource() == menu_home) {
            //For PARENT FORMS
            home_form.setVisible(true);
            flightStats_form.setVisible(false);
            whereWeFly_form.setVisible(false);
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
            whereWeFly_form.setVisible(false);
            account_form.setVisible(false);
            top_form.setVisible(false);
            aboutUs_form.setVisible(false);

        } else if (event.getSource() == menu_whereWeFly) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            whereWeFly_form.setVisible(true);
            account_form.setVisible(false);
            top_form.setVisible(false);
            aboutUs_form.setVisible(false);
        } else if (event.getSource() == menu_account) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            whereWeFly_form.setVisible(false);
            account_form.setVisible(true);
            top_form.setVisible(false);
            aboutUs_form.setVisible(false);
        } else if (event.getSource() == menu_TOP) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            whereWeFly_form.setVisible(false);
            account_form.setVisible(false);
            top_form.setVisible(true);
            aboutUs_form.setVisible(false);
        } else if (event.getSource() == menu_aboutUs) {
            home_form.setVisible(false);
            flightStats_form.setVisible(false);
            whereWeFly_form.setVisible(false);
            account_form.setVisible(false);
            top_form.setVisible(false);
            aboutUs_form.setVisible(true);
        }
    }

    public void handleNextButtonClick(ActionEvent event) throws SQLException, IOException {
        // Switch to paymentForms initially
        switchPaymentForm(cardBtn);

        // Determine which button was clicked
        Button clickedButton = (Button) event.getSource();

        // Check the ID or other properties of the button
        if (clickedButton.getId().equals("c_nextBtn2") || clickedButton.getId().equals("g_nextBtn") || clickedButton.getId().equals("p_nextBtn")) {
            // Code for c_nextBtn2, g_nextBtn, and p_nextBtn

            // Insert data into the database
            insertDataIntoDatabase();
            clearPaymentForms();
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

    private void insertDataIntoDatabase() throws SQLException, IOException {
        // Insert Data into the database

        // Insert first into the booking table
        Database booking_table = new Database();
        Booking infos = Booking.getInstance();

        TicketNo ticketNo = new TicketNo();

        LocalDateTime now = LocalDateTime.now();
        now.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));




        String flight_id = "ERM101";
        String flight_no = TicketNo.generateTicketNo(infos.getFirst_name() + infos.getLast_name());
        System.out.println(flight_no);

        booking_table.insertData(
                "booked_flights",
                Arrays.asList("flight_id", "first_name", "middle_name", "last_name",
                        "suffix", "age", "birth_date", "destination", "origin", "class",
                        "seat", "flight_no", "amount"),

                Arrays.asList(flight_id, infos.getFirst_name(), infos.getMiddle_name(), infos.getLast_name(),
                        infos.getSuffix(), infos.getAge(), infos.getBirthdate(), infos.getDestination(),
                        infos.getOrigin(), infos.getClass1(), infos.getSeatNo(), flight_no,
                        infos.getAmount())

        );

        // Create receipt
        ReceiptMaker receipt = new ReceiptMaker();
        receipt.generateReceipt(infos.getFirst_name(), infos.getLast_name(), infos.getAge(), infos.getDestination(), infos.getOrigin(), infos.getClass1(), infos.getSeatNo(), flight_no, infos.getAmount());

        // Insert into sales
        Database sales_table = new Database();
        sales_table.insertData(
                "sales",
                Arrays.asList("ticket_no", "flight_no", "seat", "name", "payment_date", "status", "ticket_agent", "ticket_branch", "price"),

                Arrays.asList(flight_no, flight_id, infos.getSeatNo(), infos.getFirst_name(), now,  "ON" , "ONLINE", "ONLINE", infos.getAmount())
        );

    }

    private boolean areAllFieldsExceptSuffixEmpty() {
        return f_name.getText().isEmpty()
                && m_name.getText().isEmpty()
                && l_name.getText().isEmpty()
                && age.getText().isEmpty()
                && (birth_date.getValue() == null) // Check if JFXDatePicker value is null
                && destination.getText().isEmpty()
                && origin.getText().isEmpty()
                && s_class.getText().isEmpty()
                && seat.getText().isEmpty();
    }

    private boolean areFieldsEmpty() {
        // Check if all fields (except suffix) are empty
        if (areAllFieldsExceptSuffixEmpty() && suffix.getText().isEmpty()) {
            AlertManager alert = new AlertManager(book_alert);
            alert.setAlertText("Please fill in at least one field (excluding suffix).", "red");

            // Schedule a task to hide the alert after 5 seconds
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished(event -> alert.hideAlert());
            delay.play();

            return true; // Exit the method since all fields (except suffix) are empty
        }

        // Check if any of the required fields (excluding suffix) is empty
        boolean anyFieldEmpty = isNullOrEmpty(f_name)
                || isNullOrEmpty(m_name)
                || isNullOrEmpty(l_name)
                || isNullOrEmpty(age)
                || isNullOrEmpty(birth_date)
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
    private String[] classList = {"Economy", "Premium Economy", "Business", "First Class"};

    public void seatClass() {
        List<String> listC = new ArrayList<>();

        listC.addAll(Arrays.asList(classList));

        ObservableList listData = FXCollections.observableArrayList(listC);
        cs_seatClass.setItems(listData);
    }

    // Add this method to initialize the booking buttons
    private void initializeBookingButtons() {
        setBookingButtonAction(booking_btn1, "Boracay", "Manila");
        setBookingButtonAction(booking_btn2, "Coron", "Manila");
        setBookingButtonAction(booking_btn3, "Samar", "Manila");
        setBookingButtonAction(booking_btn4, "Bohol", "Manila");
        // Add more booking buttons as needed
    }

// Generic method to set the action for booking buttons
    private void setBookingButtonAction(JFXButton bookingButton, String destination, String origin) {
        bookingButton.setOnAction(event -> {
            switchForm(hf_chooseSeat, bookingButton);
            setDestinationAndOrigin(destination, origin);
        });
    }

    // Method to set destination and origin in cs_destination and cs_origin text fields
    private void setDestinationAndOrigin(String destination, String origin) {
        cs_destination.setText(destination);
        cs_origin.setText(origin);
    }

    // Method to clear seat selection fields
    private void clearSeatSelectionFields() {
        cs_seatNum.clear();
        cs_seatClass.getSelectionModel().clearSelection(); // Clear the selection
    }

    // Method to handle return to destination button click
    public void handleReturnToDestiButtonClick() {
        switchForm(hf_searchDesti, returnToDesti_btn);
        switchForm(hf_searchDesti, returnToDesti_btn1);
        // Add this line to hide overlayPane1
        clearSeatSelectionFields();
    }

    // Add this method to initialize the seat buttons
    private void initializeSeatButtons() {
        setSeatButtonAction(seat_a1, "A1");
        setSeatButtonAction(seat_a2, "A2");
        setSeatButtonAction(seat_a3, "A3");
        setSeatButtonAction(seat_a4, "A4");
        // Add more seat buttons as needed
    }

    // Generic method to set the action for seat buttons
    private void setSeatButtonAction(JFXButton seatButton, String seatNumber) {
        seatButton.setOnAction(event -> {
            cs_seatNum.setText(seatNumber);
        });
    }

    // Method to handle proceed button click
    public void proceedBooking() {
        // Switch form to hf_bookFlight
        switchForm(hf_bookFlight, proceed_btn);

        // Set values in text fields
        seat.setText(cs_seatNum.getText());
        destination.setText(cs_destination.getText());
        origin.setText(cs_origin.getText());

        // Check if cs_seatClass has a selected item before accessing it
        if (cs_seatClass.getSelectionModel().getSelectedItem() != null) {
            s_class.setText(cs_seatClass.getSelectionModel().getSelectedItem().toString());
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

        // Check if age matches the age calculated from birth_date
        if (!isAgeMatchingBirthDate()) {
            showAlert("Age does not match the given birth date.", "red");
            return;
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
        booking.setBirth_date(birth_date.getValue());
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

    //CHECKER IF BIRTHDAY DOES NOT MATCH ON GIVEN AGE 
    private boolean isAgeMatchingBirthDate() {
        // Get the entered age from the age text field
        String enteredAgeText = age.getText();

        // Validate that enteredAgeText is a number
        if (!enteredAgeText.matches("\\d+")) {
            return false;
        }

        int enteredAge = Integer.parseInt(enteredAgeText);

        // Get the birth date from the date picker
        LocalDate birthDate = birth_date.getValue();

        // Calculate the age based on the birth date
        int calculatedAge = calculateAge(birthDate);

        // Compare the entered age with the calculated age
        return enteredAge == calculatedAge;
    }

    private int calculateAge(LocalDate birthDate) {
        // Calculate age based on the birth date
        // You may need to adjust this calculation based on your requirements
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    private void showAlert(String message, String color) {
        AlertManager alert = new AlertManager(book_alert);
        alert.setAlertText(message, color);

        // Schedule a task to hide the alert after 5 seconds
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(event -> alert.hideAlert());
        delay.play();
    }

    public void handleSeatButton(JFXButton button) {
        String buttonLabel = button.getText();
        cs_seatNum.setText(buttonLabel);
    }

    // Add this method to initialize the seat buttons
    private void seatButtons() throws SQLException {
        // Check if the seat is already taken
        Database db = new Database();
        if (db.checkSeats(seat_a1.getText())) {
            seat_a1.setDisable(true);
            System.out.println("test");
        }
        else { seat_a1.setOnAction(event -> handleSeatButton(seat_a1)); }

        if (db.checkSeats(seat_a2.getText())) {
            seat_a2.setDisable(true);
        }
        else { seat_a2.setOnAction(event -> handleSeatButton(seat_a2)); }

        if (db.checkSeats(seat_a3.getText())) {
            seat_a3.setDisable(true);
        }
        else { seat_a3.setOnAction(event -> handleSeatButton(seat_a3)); }

        if (db.checkSeats(seat_a4.getText())) {
            seat_a4.setDisable(true);
        }
        else { seat_a4.setOnAction(event -> handleSeatButton(seat_a4)); }

        if (db.checkSeats(seat_a5.getText())) {
            seat_a5.setDisable(true);
        }
        else { seat_a5.setOnAction(event -> handleSeatButton(seat_a5)); }

        if (db.checkSeats(seat_a6.getText())) {
            seat_a6.setDisable(true);
        }
        else { seat_a6.setOnAction(event -> handleSeatButton(seat_a6)); }

        if (db.checkSeats(seat_a7.getText())) {
            seat_a7.setDisable(true);
        }
        else { seat_a7.setOnAction(event -> handleSeatButton(seat_a7)); }

        if (db.checkSeats(seat_a8.getText())) {
            seat_a8.setDisable(true);
        }
        else { seat_a8.setOnAction(event -> handleSeatButton(seat_a8)); }

        if (db.checkSeats(seat_a11.getText())) {
            seat_a11.setDisable(true);
        }
        else { seat_a11.setOnAction(event -> handleSeatButton(seat_a11)); }

        if (db.checkSeats(seat_a21.getText())) {
            seat_a21.setDisable(true);
        }
        else { seat_a21.setOnAction(event -> handleSeatButton(seat_a21)); }

        if (db.checkSeats(seat_a31.getText())) {
            seat_a31.setDisable(true);
        }
        else { seat_a31.setOnAction(event -> handleSeatButton(seat_a31)); }

        if (db.checkSeats(seat_a41.getText())) {
            seat_a41.setDisable(true);
        }
        else { seat_a41.setOnAction(event -> handleSeatButton(seat_a41)); }

        if (db.checkSeats(seat_a51.getText())) {
            seat_a51.setDisable(true);
        }
        else { seat_a51.setOnAction(event -> handleSeatButton(seat_a51)); }

        if (db.checkSeats(seat_a61.getText())) {
            seat_a61.setDisable(true);
        }
        else { seat_a61.setOnAction(event -> handleSeatButton(seat_a61)); }

        if (db.checkSeats(seat_a71.getText())) {
            seat_a71.setDisable(true);
        }
        else { seat_a71.setOnAction(event -> handleSeatButton(seat_a71)); }

        if (db.checkSeats(seat_a81.getText())) {
            seat_a81.setDisable(true);
        }
        else { seat_a81.setOnAction(event -> handleSeatButton(seat_a81)); }

        if (db.checkSeats(seat_b91.getText())) {
            seat_b91.setDisable(true);
        }
        else { seat_b91.setOnAction(event -> handleSeatButton(seat_b91)); }

        if (db.checkSeats(seat_b101.getText())) {
            seat_b101.setDisable(true);
        }
        else { seat_b101.setOnAction(event -> handleSeatButton(seat_b101)); }

        if (db.checkSeats(seat_b111.getText())) {
            seat_b111.setDisable(true);
        }
        else { seat_b111.setOnAction(event -> handleSeatButton(seat_b111)); }

        if (db.checkSeats(seat_b121.getText())) {
            seat_b121.setDisable(true);
        }
        else { seat_b121.setOnAction(event -> handleSeatButton(seat_b121)); }

        if (db.checkSeats(seat_b131.getText())) {
            seat_b131.setDisable(true);
        }
        else { seat_b131.setOnAction(event -> handleSeatButton(seat_b131)); }

        if (db.checkSeats(seat_b141.getText())) {
            seat_b141.setDisable(true);
        }
        else { seat_b141.setOnAction(event -> handleSeatButton(seat_b141)); }

        if (db.checkSeats(seat_b151.getText())) {
            seat_b151.setDisable(true);
        }
        else { seat_b151.setOnAction(event -> handleSeatButton(seat_b151)); }

        if (db.checkSeats(seat_b161.getText())) {
            seat_b161.setDisable(true);
        }
        else { seat_b161.setOnAction(event -> handleSeatButton(seat_b161)); }

        if (db.checkSeats(seat_b171.getText())) {
            seat_b171.setDisable(true);
        }
        else { seat_b171.setOnAction(event -> handleSeatButton(seat_b171)); }

        if (db.checkSeats(seat_b181.getText())) {
            seat_b181.setDisable(true);
        }
        else { seat_b181.setOnAction(event -> handleSeatButton(seat_b181)); }

        if (db.checkSeats(seat_b191.getText())) {
            seat_b191.setDisable(true);
        }
        else {seat_b191.setOnAction(event -> handleSeatButton(seat_b191)); }

        if (db.checkSeats(seat_b201.getText())) {
            seat_b201.setDisable(true);
        }
        else {seat_b201.setOnAction(event -> handleSeatButton(seat_b201)); }

        if (db.checkSeats(seat_b211.getText())) {
            seat_b211.setDisable(true);
        }
        else {seat_b211.setOnAction(event -> handleSeatButton(seat_b211)); }

        if (db.checkSeats(seat_b221.getText())) {
            seat_b221.setDisable(true);
        }
        else {seat_b221.setOnAction(event -> handleSeatButton(seat_b221)); }

        if (db.checkSeats(seat_b231.getText())) {
            seat_b231.setDisable(true);
        }
        else {seat_b231.setOnAction(event -> handleSeatButton(seat_b231)); }

        if (db.checkSeats(seat_b241.getText())) {
            seat_b241.setDisable(true);
        }

        else {
            seat_b241.setOnAction(event -> handleSeatButton(seat_b241));
        }

        // Add more seat buttons as needed
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize chooseseat buttons
        try {
            seatButtons();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Combo-Box initialize
        seatClass();
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
        returnToDesti_btn.setOnAction(e -> handleReturnToDestiButtonClick());
        returnToDesti_btn1.setOnAction(e -> handleReturnToDestiButtonClick());

        // Return actions for home_form
        returnToHome_btn.setOnAction(e -> switchForm(hf_home, returnToHome_btn));

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

        // Initialize seat buttons
        initializeSeatButtons();

        // Initialize booking buttons
        initializeBookingButtons();

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

    }
}
