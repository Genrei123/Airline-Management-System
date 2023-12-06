package Dashboard;

import Animations.SwitchForms;
import Database.Database;
import LogIn.Admin;
import LogIn.AlertManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class DashboardController implements Initializable {

    @FXML
    private AnchorPane topPane;





    @FXML
    private Label d_flightsToday;

    @FXML
    private Label d_flightsBooked;

    @FXML
    private Label d_ticketSales;

    @FXML
    private Label d_username;

    @FXML
    private TableView<String[]> d_table;

    @FXML
    private TableColumn<String[], String> d_ticketNo, d_flightDate, d_flight, d_departure, d_arrival, d_fullname;

    @FXML
    private AnchorPane topPane_line;

    @FXML
    private AnchorPane centerPane;

    @FXML
    private AnchorPane customSupp_form;

    @FXML
    private AnchorPane sales_form;

    @FXML
    private TextField sl_search;

    @FXML
    private Label sl_ticketSoldPrv;

    @FXML
    private Label sl_ticketSoldNo;

    @FXML
    private Label sl_bookedFlightsNo;

    @FXML
    private Label sl_earningsNoPrv;

    @FXML
    private Label sl_earningsNo;

    @FXML
    private TableView<String[]> sl_table;

    @FXML
    private AnchorPane ticketRecords_form;

    @FXML
    private TextField tr_search;

    @FXML
    private TableView<String[]> tr_table;

    @FXML
    private TableColumn<String[], String> trt_flightNo;

    @FXML
    private TableColumn<String[], String> trt_airplaneNo;

    @FXML
    private TableColumn<String[], String> trt_initialDep;

    @FXML
    private TableColumn<String[], String> trt_departure;

    @FXML
    private TableColumn<String[], String> trt_destination;

    @FXML
    private TableColumn<String[], String> trt_origin;

    @FXML
    private TableColumn<String[], String> trt_seatNo;

    @FXML
    private TableColumn<String[], String> trt_class;

    @FXML
    private JFXComboBox<String> trt_searchBy;

    @FXML
    private JFXComboBox<String> sl_searchBy;

    @FXML
    private AnchorPane flightManager_form;

    @FXML
    private Label fm_managerBtn;

    @FXML
    private Label fm_recordsBtn;

    @FXML
    private TextField fr_search;

    @FXML
    private AnchorPane fm_managerForm;

    @FXML
    private AnchorPane fm_recordsForm;

    @FXML
    private AnchorPane bookedFlights_form;

    @FXML
    private TextField bf_search;

    @FXML
    private TableView<String[]> bookedFlights_table;

    @FXML
    private TableColumn<?, ?> bft_name;

    @FXML
    private TableColumn<?, ?> bft_flightNo;

    @FXML
    private TableColumn<?, ?> bft_seatNo;

    @FXML
    private TableColumn<?, ?> bft_class;

    @FXML
    private TableColumn<?, ?> bft_departure;

    @FXML
    private TableColumn<?, ?> bft_dateOfBooking;

    @FXML
    private TableColumn<?, ?> bft_destFrom;

    @FXML
    private TableColumn<?, ?> bft_destTo;

    @FXML
    private JFXDatePicker bf_date;

    @FXML
    private JFXTimePicker bf_time;

    @FXML
    private JFXButton bf_createBtn;

    @FXML
    private JFXButton bf_updateBtn;

    @FXML
    private JFXButton bf_clearBtn;

    @FXML
    private JFXButton bf_deleteBtn;



    @FXML
    private AnchorPane overlayPane;

    @FXML
    private AnchorPane dashboard_slider;

    @FXML
    private JFXButton dashboardForm_btn;

    @FXML
    private JFXButton bookedForm_btn;

    @FXML
    private JFXButton flightManForm_btn;

    @FXML
    private JFXButton ticketForm_btn;

    @FXML
    private JFXButton salesForm_btn;

    @FXML
    private JFXButton customerSupp_btn;

    @FXML
    private JFXButton logout_btn;

    @FXML
    private JFXButton slider_menu;

    @FXML
    private TableColumn<String[], String> s_ticketNo, s_flightNo, s_seat, s_name, s_paymentDate, s_status, s_agent, s_ticketBranch, s_price;

    @FXML
    private Label cs_rebookingBtn, cs_updateInfoBtn;

    @FXML
    private AnchorPane cs_rebookingForm, cs_updateForm;

    @FXML
    private TableView<String[]> fm_managerTable;

    @FXML
    private TableColumn<String[], String> fm_managerAirplaneID, fm_managerFlightNO, fm_managerDEST, fm_managerORIGIN, fm_managerSTATUS, fm_managerORIGINDATE, fm_managerDESTDATE;

    @FXML
    private JFXComboBox<String> fm_managerAirplaneIDbox, fm_managerFlightNObox, fm_managerDESTbox, fm_managerORIGINbox, fm_managerSTATUSbox, fm_managerDESTDATEbox;

    @FXML
    private TextField fm_managerFLIGHTNOtxt, cs_class;

    @FXML
    private JFXTimePicker fm_timeDeparture, ETOA;

    @FXML
    private JFXDatePicker fm_dateDeparture, fm_dateArrival;

    @FXML
    private JFXButton fm_managerADD, fm_managerUPDATE, fm_managerDELETE;

    @FXML
    private JFXButton airplaneManager_btn;

    @FXML
    private JFXComboBox<String> bf_searchBy;

    @FXML
    private JFXDatePicker bf_bookingDate, bf_departDate, bf_arrivalDate, cs_rebookDate;

    @FXML
    private TableColumn<String[], String> bf_flightNO, bf_depart, bf_dest, bf_arrival, bf_tableName, bf_cseat, bf_bookDate, bf_amountTable;

    @FXML
    private TextField bf_flightID, bf_classSeat, bf_destination, bf_amount, bf_name;

    @FXML
    private JFXComboBox<String> bf_class, cs_statusCombo, cs_statusSeatCombo, cs_classSeatCombo;

    @FXML
    private AnchorPane cs_options, cs_reBookingform, cs_changeInfoform;

    @FXML
    private JFXButton cs_changeInfo, cs_reBooking;

    @FXML
    private TableView<String[]> cs_ticketReq;

    @FXML
    private TableColumn<String[], String> cs_ticketNo, cs_reason, cs_date;

    @FXML
    private TextField cs_ticketText, cs_nameText, cs_contactText, cs_feedbackText, cs_rebookreason;

    @FXML
    private Label cs_alert;



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

    public void logout() throws IOException {
        SwitchForms switchForms = new SwitchForms();
        switchForms.Logout((Stage) logout_btn.getScene().getWindow());
    }

    private void switchForm(AnchorPane targetForm, JFXButton selectedButton) {
        // Hide all forms

        bookedFlights_form.setVisible(false);
        flightManager_form.setVisible(false);
        ticketRecords_form.setVisible(false);
        sales_form.setVisible(false);
        customSupp_form.setVisible(false);

        // Show the selected form
        targetForm.setVisible(true);

        // Update button styles
        if (currentSelectedButton != null) {
            currentSelectedButton.getStyleClass().remove("selected-button");
        }

        currentSelectedButton = selectedButton;
        currentSelectedButton.getStyleClass().add("selected-button");
    }

    private void switchForm(AnchorPane targetForm, Label selectedLabel, Label unselectedLabel) {
        // Hide all forms
        fm_managerForm.setVisible(false);
        fm_recordsForm.setVisible(false);

        cs_rebookingForm.setVisible(false);
        cs_updateForm.setVisible(false);



        // Show the selected form
        targetForm.setVisible(true);

        // Update label styles
        selectedLabel.setTextFill(Color.WHITE);
        unselectedLabel.setTextFill(Color.web("#a18b8b"));
    }

    public void setBf_clearBtn() {
        bf_clearBtn.setOnAction((ActionEvent event) -> {
            // Lagyan pa ng name yung ibang textfields
            bf_date.setValue(null);
            bf_time.setValue(null);
        });
    }

    public void tr_search() throws SQLException {
        List<String> text = Arrays.asList(tr_search.getText());
        List<String> searchBy = Arrays.asList(trt_searchBy.getSelectionModel().getSelectedItem());

        Database database = new Database();
        ObservableList<String[]> data = database.pullData("ticket_records", Arrays.asList("flight_no", "Airplane_no", "initial_depart", "departure", "destination", "origin", "seat_no", "class"), searchBy, text);
        if (data != null) {
            System.out.println("Data is not null");
            tr_table.setItems(data);

            trt_flightNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[0]));
            trt_airplaneNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[1]));
            trt_initialDep.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[2]));
            trt_departure.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[3]));
            trt_destination.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[4]));
            trt_origin.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[5]));
            trt_seatNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[6]));
            trt_class.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[7]));
        }

        else {
            System.out.println("Data is null");
        }

    }

    public void tr_clear() throws SQLException {
        tr_search.setText("");
        getTicketRecords();
    }

    public void getTicketRecords() throws SQLException {
        System.out.println("Getting ticket records");
        // For Ticket Records
        Database database = new Database();
        ObservableList<String[]> data = database.pullData("ticket_records", Arrays.asList("flight_no", "airplane_no", "initial_depart", "departure", "destination", "origin", "seat_no", "class"));

        if (data != null) {
            tr_table.setItems(data);

            trt_flightNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[0]));
            trt_airplaneNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[1]));
            trt_initialDep.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[2]));
            trt_departure.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[3]));
            trt_destination.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[4]));
            trt_origin.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[5]));
            trt_seatNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[6]));
            trt_class.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[7]));
        }

        else {
            System.out.println("Data is null");
        }
    }

    public void getSales() throws SQLException {
        System.out.println("Getting sales");
        Database database = new Database();

        ObservableList<String[]> data = database.pullData("sales", Arrays.asList("ticket_no", "flight_no", "seat", "name", "payment_date", "status", "ticket_agent", "ticket_branch", "price"));

        if (data != null) {
            sl_table.setItems(data);
            s_ticketNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[0]));
            s_flightNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[1]));
            s_seat.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[2]));
            s_name.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[3]));
            s_paymentDate.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[4]));
            s_status.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[5]));
            s_agent.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[6]));
            s_ticketBranch.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[7]));
            s_price.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[8]));

            // Today's earnings
            double earnings = todayEarnings();
            sl_earningsNo.setText("₱" + earnings);

            // Yesterday's earnings
            double yesterdayEarnings = yesterdayEarnings();
            sl_earningsNoPrv.setText("₱" + yesterdayEarnings);

            // Monthly earnings
            double monthlyEarnings = monthlyEarnings();
            sl_bookedFlightsNo.setText("₱" + monthlyEarnings);

        }

        else {
            System.out.println("Data is null");
        }

    }

    private double yesterdayEarnings() throws SQLException {
        Database database = new Database();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        date = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);

        ObservableList<String[]> data = database.pullData("sales", Arrays.asList("ticket_no", "flight_no", "seat", "name", "payment_date", "status", "ticket_agent", "ticket_branch", "price"), Arrays.asList("payment_date"), Arrays.asList(formattedDate));

        if (data != null) {
            double earnings = 0;
            for (String[] data1 : data) {
                earnings += Double.parseDouble(data1[8]);
            }
            return earnings;
        }

        else {
            System.out.println("Data is null");
        }
        return 0;
    }

    private double todayEarnings() throws SQLException {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter) ;

        Database database = new Database();
        ObservableList<String[]> data = database.pullData("sales", Arrays.asList("ticket_no", "flight_no", "seat", "name", "payment_date", "status", "ticket_agent", "ticket_branch", "price"), Arrays.asList("payment_date"), Collections.singletonList(formattedDate));


        if (data != null) {
            // For earnings
            double earnings = 0;
            for (String[] data1 : data) {
                earnings += Double.parseDouble(data1[8]);
            }

            // For the number of tickets sold today.
            sl_ticketSoldNo.setText(String.valueOf(data.size()));

            return earnings;
        }

        else {
            System.out.println("Data is null");
        }

        return 0;
    }

    private double monthlyEarnings() {
        Database database = new Database();
        return database.monthlyEarnings();
    }

    public void sl_search() throws SQLException {
        List<String> text = Arrays.asList(sl_search.getText());
        List<String> searchBy = Arrays.asList(sl_searchBy.getSelectionModel().getSelectedItem());

        Database database = new Database();
        ObservableList<String[]> data = database.pullData("sales", Arrays.asList("ticket_no", "flight_no", "seat", "name", "payment_date", "status", "ticket_agent", "ticket_branch", "price"), searchBy, text);
        if (data != null) {
            System.out.println("Data is not null");
            sl_table.setItems(data);

            s_ticketNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[0]));
            s_flightNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[1]));
            s_seat.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[2]));
            s_name.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[3]));
            s_paymentDate.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[4]));
            s_status.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[5]));
            s_agent.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[6]));
            s_ticketBranch.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[7]));
            s_price.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[8]));
        }

        else {
            System.out.println("Data is null");
        }
    }

    public void sl_clear() throws SQLException {
        sl_search.setText("");
        getSales();
    }

    public void load_fm_managerTable() throws SQLException {
        Database database = new Database();
        ObservableList<String[]> data = database.pullData("flight_manager", Arrays.asList("airplane_id", "flight_no", "destination", "origin", "status", "origin_date", "destination_date"));

        if (data != null) {
            fm_managerTable.setItems(data);
            fm_managerAirplaneID.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[0]));
            fm_managerFlightNO.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[1]));
            fm_managerDEST.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[2]));
            fm_managerORIGIN.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[3]));
            fm_managerSTATUS.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[4]));
            fm_managerORIGINDATE.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[5]));
            fm_managerDESTDATE.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[6]));
        }

        else {
            System.out.println("Data is null");
        }
    }

    public void fm_managerADD() throws SQLException {
        String airplane_id = fm_managerAirplaneIDbox.getSelectionModel().getSelectedItem();
        String flightNo = fm_managerFLIGHTNOtxt.getText();

        LocalDateTime departureDateTime = LocalDateTime.of(fm_dateDeparture.getValue(), fm_timeDeparture.getValue());
        LocalDateTime arrivalDateTime = LocalDateTime.of(fm_dateArrival.getValue(), ETOA.getValue());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String departure = departureDateTime.format(formatter);
        String arrival = arrivalDateTime.format(formatter);

        String destination = fm_managerDESTbox.getSelectionModel().getSelectedItem();
        String origin = fm_managerORIGINbox.getSelectionModel().getSelectedItem();
        String status = fm_managerSTATUSbox.getSelectionModel().getSelectedItem();

        Database database = new Database();
        database.insertData("flight_manager", Arrays.asList("airplane_id", "flight_no", "destination", "origin", "status", "origin_date", "destination_date"), Arrays.asList(airplane_id, flightNo, destination, origin, status, departure, arrival));

        load_fm_managerTable();
    }

    public void fm_managerDELETE() throws SQLException {
        String airplane_id = fm_managerAirplaneIDbox.getSelectionModel().getSelectedItem();
        String flightNo = fm_managerFLIGHTNOtxt.getText();

        LocalDateTime departureDateTime = LocalDateTime.of(fm_dateDeparture.getValue(), fm_timeDeparture.getValue());
        LocalDateTime arrivalDateTime = LocalDateTime.of(fm_dateArrival.getValue(), ETOA.getValue());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String departure = departureDateTime.format(formatter);
        String arrival = arrivalDateTime.format(formatter);

        String destination = fm_managerDESTbox.getSelectionModel().getSelectedItem();
        String origin = fm_managerORIGINbox.getSelectionModel().getSelectedItem();
        String status = fm_managerSTATUSbox.getSelectionModel().getSelectedItem();

        Database database = new Database();
        database.deleteData("flight_manager", Arrays.asList("airplane_id", "flight_no", "destination", "origin", "status", "origin_date", "destination_date"), Arrays.asList(airplane_id, flightNo, destination, origin, status, departure, arrival));

        load_fm_managerTable();
    }

    public void fm_managerUPDATE() throws SQLException {
        String airplane_id = fm_managerAirplaneIDbox.getSelectionModel().getSelectedItem();
        String flightNo = fm_managerFLIGHTNOtxt.getText();

        LocalDateTime departureDateTime = LocalDateTime.of(fm_dateDeparture.getValue(), fm_timeDeparture.getValue());
        LocalDateTime arrivalDateTime = LocalDateTime.of(fm_dateArrival.getValue(), ETOA.getValue());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String departure = departureDateTime.format(formatter);
        String arrival = arrivalDateTime.format(formatter);

        String destination = fm_managerDESTbox.getSelectionModel().getSelectedItem();
        String origin = fm_managerORIGINbox.getSelectionModel().getSelectedItem();

        String status = fm_managerSTATUSbox.getSelectionModel().getSelectedItem();

        // Update with this values

        String updated_airplane_id = fm_managerAirplaneIDbox.getValue();
        String updated_flightNo = fm_managerFLIGHTNOtxt.getText();

        LocalDateTime updated_departureDateTime = LocalDateTime.of(fm_dateDeparture.getValue(), fm_timeDeparture.getValue());
        LocalDateTime updated_arrivalDateTime = LocalDateTime.of(fm_dateArrival.getValue(), ETOA.getValue());

        DateTimeFormatter updated_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String updated_departure = departureDateTime.format(formatter);
        String updated_arrival = arrivalDateTime.format(formatter);

        String updated_destination = fm_managerDESTbox.getValue();
        String updated_origin = fm_managerORIGINbox.getValue();

        String updated_status = fm_managerSTATUSbox.getValue();

        Database database = new Database();
        database.updateData(
                "flight_manager",
                Arrays.asList("airplane_id", "flight_no", "destination", "origin", "status", "origin_date", "destination_date"),
                Arrays.asList(updated_airplane_id, updated_flightNo, updated_destination, updated_origin, updated_status, updated_departure, updated_arrival),
                Arrays.asList("airplane_id", "flight_no", "destination", "origin", "status", "origin_date", "destination_date"),
                Arrays.asList(airplane_id, flightNo, destination, origin, status, departure, arrival)

                );

        load_fm_managerTable();

    }

    private void loadBookedFlights() throws SQLException {
        Database database = new Database();
        ObservableList<String[]> data = database.pullData("booked_flights",
                Arrays.asList("flight_id", "departure", "destination", "arrival", "last_name", "class", "book_date", "amount"));

        if (data != null) {
            bookedFlights_table.setItems(data);
            bf_flightNO.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[0]));
            bf_depart.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[1]));
            bf_dest.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[2]));
            bf_arrival.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[3]));
            bf_tableName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[4]));
            bf_cseat.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[5]));
            bf_bookDate.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[6]));
            bf_amountTable.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[7]));
        }

        else {
            System.out.println("Data is null");
        }
    }

    public void bf_createBtn() throws SQLException {
        String flightID = bf_flightID.getText();
        String classSeat = bf_classSeat.getText();
        String destination = bf_destination.getText();
        String amount = bf_amount.getText();
        String name = bf_name.getText();

        LocalDateTime bookingDateTime = LocalDateTime.of(bf_bookingDate.getValue(), bf_time.getValue());
        LocalDateTime departureDateTime = LocalDateTime.of(bf_departDate.getValue(), bf_time.getValue());
        LocalDateTime arrivalDateTime = LocalDateTime.of(bf_arrivalDate.getValue(), bf_time.getValue());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String bookingDate = bookingDateTime.format(formatter);
        String departureDate = departureDateTime.format(formatter);
        String arrivalDate = arrivalDateTime.format(formatter);

        Database database = new Database();
        database.insertData("booked_flights",
                Arrays.asList("flight_no", "class", "destination", "amount", "name", "booking_date", "departure_date", "arrival_date"),
                Arrays.asList(flightID, classSeat, destination, amount, name, bookingDate, departureDate, arrivalDate));
    }

    public void bf_deleteBtn() throws SQLException {
        String flightID = bf_flightID.getText();
        String classSeat = bf_classSeat.getText();
        String destination = bf_destination.getText();
        String amount = bf_amount.getText();
        String name = bf_name.getText();

        LocalDateTime bookingDateTime = LocalDateTime.of(bf_bookingDate.getValue(), bf_time.getValue());
        LocalDateTime departureDateTime = LocalDateTime.of(bf_departDate.getValue(), bf_time.getValue());
        LocalDateTime arrivalDateTime = LocalDateTime.of(bf_arrivalDate.getValue(), bf_time.getValue());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String bookingDate = bookingDateTime.format(formatter);
        String departureDate = departureDateTime.format(formatter);
        String arrivalDate = arrivalDateTime.format(formatter);

        Database database = new Database();
        database.deleteData("booked_flights",
                Arrays.asList("flight_no", "class", "destination", "amount", "name", "booking_date", "departure_date", "arrival_date"),
                Arrays.asList(flightID, classSeat, destination, amount, name, bookingDate, departureDate, arrivalDate));
    }

    public void bf_clear() {
        bf_flightID.setText("");
        bf_classSeat.setText("");
        bf_destination.setText("");
        bf_amount.setText("");
        bf_name.setText("");
        bf_bookingDate.setValue(null);
        bf_departDate.setValue(null);
        bf_arrivalDate.setValue(null);
    }

    private void loadCustomerSupport() {
        // Load the table
        Database database = new Database();
        ObservableList<String[]> data = database.pullData(
                "customer_support",
                Arrays.asList("ticket_no", "reason", "preferred_date"));


        if (data != null) {
            cs_ticketReq.setItems(data);
            cs_ticketNo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[0]));
            cs_reason.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[1]));
            cs_date.setCellValueFactory(param -> new SimpleStringProperty(param.getValue()[2]));
        }

        else {
            System.out.println("Data is null");
        }

        // Load the status combo box
        List<String> status = Arrays.asList("Pending", "Approved", "Denied");
        ObservableList<String> statusData = FXCollections.observableArrayList(status);
        cs_statusCombo.setItems(statusData);

    }

    public void confirmRebook() throws SQLException {
        // Check if fields are empty in customer support rebooking page
        if (cs_ticketText.getText().isEmpty() || cs_nameText.getText().isEmpty() || cs_contactText.getText().isEmpty() || cs_statusCombo.getSelectionModel().isEmpty() || cs_statusSeatCombo.getSelectionModel().isEmpty() || cs_rebookDate.getValue() == null || cs_rebookreason.getText().isEmpty()) {
            AlertManager alertManager = new AlertManager(cs_alert);
            alertManager.setAlertText("Please fill in all the fields.", "Red");
        }

        else {
            // Get informations
            String ticketNo = cs_ticketText.getText();
            String name = cs_nameText.getText();
            String contact = cs_contactText.getText();
            String status = cs_statusCombo.getSelectionModel().getSelectedItem();
            String seat = cs_statusSeatCombo.getSelectionModel().getSelectedItem();
            LocalDate rebookDate = cs_rebookDate.getValue();
            String reason = cs_rebookreason.getText();
            String reasonOption = null;

            if ("Move Departure Date".equals(reason)) {
                reasonOption = "departure";
            }

            else if ("Move Arrival Date".equals(reason)) {
                reasonOption = "arrival";
            }

            // Perform queries
            Database database = new Database();
            database.updateData(
                    "customer_support",
                    Arrays.asList("status"),
                    Arrays.asList(status),
                    Arrays.asList("ticket_no"),
                    Arrays.asList(ticketNo)
            );

            database.updateData(
                    "booked_flights",
                    Arrays.asList(reasonOption, "seat"),
                    Arrays.asList(rebookDate, seat),
                    Arrays.asList("ticket_no"),
                    Arrays.asList(ticketNo)
            );
            


            AlertManager success = new AlertManager(cs_alert);
            success.setAlertText("Successfully rebooked flight.", "Green");
        }


    }

    private void loadseats(String seatClass) {
        Database db = new Database();
        // Check for the class and initialize seats available
        String[] firstC_seats = {"1A", "2A", "3A", "4A", "5A", "6A", "7A", "8A"};
        // Do it until 24
        String[] businessC_seats = {"9B", "10B", "11B", "12B", "13B", "14B", "15B", "16B", "17B", "18B", "19B", "20B", "21B", "22B", "23B", "24B"};
        // Do it until 36
        String[] premiumE_seats = {"25C", "26C", "27C", "28C", "29C", "30C", "31C", "32C", "33C", "34C", "35C", "36C"};
        // Do it until 80
        String[] economy_seats = {"37D", "38D", "39D", "40D", "41D", "42D", "43D", "44D", "45D", "46D", "47D", "48D", "49D", "50D", "51D", "52D", "53D", "54D", "55D", "56D", "57D", "58D", "59D", "60D", "61D", "62D", "63D", "64D", "65D", "66D", "67D", "68D", "69D", "70D", "71D", "72D", "73D", "74D", "75D", "76D", "77D", "78D", "79D", "80D"};

        if (Objects.equals(seatClass, "First Class")) {
            ObservableList<String> seats = FXCollections.observableArrayList(firstC_seats);
            cs_statusSeatCombo.setItems(seats);
        }

        else if (Objects.equals(seatClass, "Business Class")) {
            ObservableList<String> seats = FXCollections.observableArrayList(businessC_seats);
            cs_statusSeatCombo.setItems(seats);


        }

        else if (Objects.equals(seatClass, "Premium Economy")) {
            ObservableList<String> seats = FXCollections.observableArrayList(premiumE_seats);
            cs_statusSeatCombo.setItems(seats);
        }

        else if (Objects.equals(seatClass, "Economy")) {
            ObservableList<String> seats = FXCollections.observableArrayList(economy_seats);
            cs_statusSeatCombo.setItems(seats);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loadCustomerSupport();

        // Set sales to be visible
        sales_form.setVisible(true);

        Admin admin = Admin.getInstance();
        System.out.println(admin.getUsername());

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


        // Create a reference to the currently selected button
        currentSelectedButton = dashboardForm_btn;

        // Add button click event handlers
        bookedForm_btn.setOnAction(e -> switchForm(bookedFlights_form, bookedForm_btn));
        ticketForm_btn.setOnAction(e -> switchForm(ticketRecords_form, ticketForm_btn));
        salesForm_btn.setOnAction(e -> switchForm(sales_form, salesForm_btn));
        flightManForm_btn.setOnAction(e -> switchForm(flightManager_form, flightManForm_btn));
        customerSupp_btn.setOnAction(e -> switchForm(customSupp_form, customerSupp_btn));

        // Add button click event handlers
        fm_managerBtn.setOnMouseClicked(e -> switchForm(fm_managerForm, fm_managerBtn, fm_recordsBtn));
        fm_recordsBtn.setOnMouseClicked(e -> switchForm(fm_recordsForm, fm_recordsBtn, fm_managerBtn));




        // Set the default form to fm_managerForm
        switchForm(fm_managerForm, fm_managerBtn, fm_recordsBtn);
        switchForm(cs_rebookingForm, cs_rebookingBtn, cs_updateInfoBtn);



        // For Ticket Records
        try {
            getTicketRecords();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // For sales
        try {
            getSales();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // For flight manager
        try {
            load_fm_managerTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // For searching in ticket records
        String[] search_choices = {"flight_no", "airplane_no", "initial_departure", "departure", "destination", "origin", "seat_no", "class"};
        List<String> listQ = new ArrayList<>();

        for (String data1 : search_choices) {
            listQ.add(data1);
        }
        ObservableList listData = FXCollections.observableArrayList(listQ);
        trt_searchBy.setItems(listData);
        trt_searchBy.setValue("flight_no");

        // Ticket Records Ends here

        // For searching in sales
        String[] search_choices2 = {"ticket_no", "flight_no", "seat", "name", "payment_date", "status", "ticket_agent", "ticket_branch", "price"};
        List<String> listQ2 = new ArrayList<>();

        for (String data1 : search_choices2) {
            listQ2.add(data1);
        }
        ObservableList listData2 = FXCollections.observableArrayList(listQ2);
        sl_searchBy.setItems(listData2);
        sl_searchBy.setValue("ticket_no");

        // Sales ends here

        // For flight manager
        fm_managerTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String[] selected = fm_managerTable.getSelectionModel().getSelectedItem();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(selected[5], formatter);

                fm_dateDeparture.setValue(dateTime.toLocalDate());
                fm_timeDeparture.setValue(dateTime.toLocalTime());

                LocalDateTime dateTime2 = LocalDateTime.parse(selected[6], formatter);
                fm_dateArrival.setValue(dateTime2.toLocalDate());
                ETOA.setValue(dateTime2.toLocalTime());

                fm_managerAirplaneIDbox.setValue(selected[0]);
                fm_managerFLIGHTNOtxt.setText(selected[1]);
                fm_managerDESTbox.setValue(selected[2]);
                fm_managerORIGINbox.setValue(selected[3]);
                fm_managerSTATUSbox.setValue(selected[4]);

            }
        });

        String[] search_choices3 = {"airplane_id", "flight_no", "destination", "origin", "status", "origin_date", "destination_date"};
        List<String> listQ3 = new ArrayList<>();

        for (String data1 : search_choices3) {
            listQ3.add(data1);
        }
        ObservableList listData3 = FXCollections.observableArrayList(listQ3);
        fm_managerAirplaneIDbox.setItems(listData3);
        fm_managerAirplaneIDbox.setValue("airplane_id");

        fm_managerSTATUSbox.setItems(listData3);
        fm_managerSTATUSbox.setValue("status");

        fm_managerDESTbox.setItems(listData3);
        fm_managerDESTbox.setValue("destination");

        fm_managerORIGINbox.setItems(listData3);
        fm_managerORIGINbox.setValue("origin");


        // Flight manager ends here

        // Book flights starts here
        try {
            loadBookedFlights();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        bookedFlights_table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String[] selected = bookedFlights_table.getSelectionModel().getSelectedItem();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(selected[6], formatter);
                bf_bookingDate.setValue(dateTime.toLocalDate());

                LocalDateTime dateTime2 = LocalDateTime.parse(selected[1], formatter);
                bf_departDate.setValue(dateTime2.toLocalDate());

                LocalDateTime dateTime3 = LocalDateTime.parse(selected[3], formatter);
                bf_arrivalDate.setValue(dateTime3.toLocalDate());

                bf_flightID.setText(selected[0]);
                bf_classSeat.setText(selected[5]);
                bf_destination.setText(selected[2]);
                bf_amount.setText(selected[7]);
                bf_name.setText(selected[4]);

            }
        });

        String[] search_choices4 = {"ECONOMY", "BUSINESS", "PREMIUM", "VIP"};
        List<String> listQ4 = new ArrayList<>();

        for (String data1 : search_choices4) {
            listQ4.add(data1);
        }
        ObservableList listData4 = FXCollections.observableArrayList(listQ4);
        bf_class.setItems(listData4);
        bf_class.setValue("ECONOMY");

        bf_class.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == "ECONOMY") {
                bf_amount.setText("1000");
            }

            else if (newValue == "BUSINESS") {
                bf_amount.setText("2000");
            }

            else if (newValue == "PREMIUM") {
                bf_amount.setText("3000");
            }

            else if (newValue == "VIP") {
                bf_amount.setText("4000");
            }
        });

        // Book flights ends here

        // For customer support
        cs_ticketReq.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String[] selected = cs_ticketReq.getSelectionModel().getSelectedItem();


                // Query the database for the ticket information
                Database database = new Database();

                ObservableList<String[]> change = database.pullData(
                        "customer_support",
                        Arrays.asList("name", "ticket_no", "reason", "contact", "feedback", "status", "preferred_date"),
                        Arrays.asList("ticket_no", "reason", "preferred_date"),
                        Arrays.asList(selected[0], selected[1], selected[2])
                );


                String ticket_no = change.get(0)[1];
                String name = change.get(0)[0];
                String reason = change.get(0)[2];
                String contact = change.get(0)[3];
                String feedback = change.get(0)[4];
                LocalDate date = LocalDate.parse(change.get(0)[6]);


                cs_ticketText.setText(ticket_no);
                cs_nameText.setText(name);
                cs_contactText.setText(contact);
                cs_feedbackText.setText(feedback);
                cs_rebookDate.setValue(date);
                cs_rebookreason.setText(reason);




                ObservableList<String[]> data1 = database.pullData(
                        "booked_flights",
                        Arrays.asList("class"),
                        Arrays.asList("ticket_no", "status"),
                        Arrays.asList(ticket_no, "Booked")
                );

                cs_class.setText(data1.get(0)[0]);

                loadseats(data1.get(0)[0]);
            }
        });





        // Auto requery when something is changed within the database
        // Create a timeline for periodic polling (adjust the Duration as needed)
        Timeline timeline = new Timeline(new KeyFrame(Duration.minutes(1), event -> {
            // Code to re-query the database goes here
            System.out.println("Re-querying");
            try {
                getSales();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                getTicketRecords();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                load_fm_managerTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }


}
