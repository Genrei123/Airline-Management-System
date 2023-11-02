/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package LogIn;

import Database.Connector;
import Database.Database;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.xml.crypto.Data;
import java.util.Arrays;

/**
 *
 * @author Ervhyne
 */
public class LoginPageController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane login_form;

    @FXML
    private JFXTextField login_username;

    @FXML
    private JFXTextField login_showPassword;

    @FXML
    private JFXPasswordField login_password;

    @FXML
    private Button login_btn;

    @FXML
    private JFXCheckBox login_selectShowPassword;

    @FXML
    private Button login_createAcc;

    @FXML
    private Hyperlink login_forgetPassword;

    @FXML
    private Label signin_alert;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private JFXTextField signup_userID;

    @FXML
    private JFXTextField signup_password;

    @FXML
    private Button signup_btn;

    @FXML
    private Button signup_loginAcc;

    @FXML
    private JFXTextField signup_confirmPassword;

    @FXML
    private JFXComboBox<?> signup_selectQuestion;

    @FXML
    private JFXTextField signup_answer;

    @FXML
    private Label signup_alert;

    @FXML
    private AnchorPane forgot_form;

    @FXML
    private JFXTextField forgot_userID;

    @FXML
    private Button forgot_proceedBtn;

    @FXML
    private Button forgot_backBtn;

    @FXML
    private JFXComboBox<?> forgot_selectQuestion;

    @FXML
    private JFXTextField forgot_answer;

    @FXML
    private Label forgot_alert;

    @FXML
    private AnchorPane changePass_form;

    @FXML
    private JFXTextField changePass_password;

    @FXML
    private Button changePass_proceedBtn;

    @FXML
    private Button changePass_backBtn;

    @FXML
    private JFXTextField changePass_confirmPassword;

    @FXML
    private Label changePass_alert;

    // SQL variables
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
    private Connector connectDB = new Connector();
    private boolean showPasswordChecked = false;
    private String storedUsername;

    private Database checkAcc = new Database();

    //LOGIN FORM PART
// Modified login function to handle both password and showPassword fields
    public void login() {
        AlertManager alert = new AlertManager(signin_alert);

        if (login_username.getText().isEmpty() || (login_password.getText().isEmpty() && login_showPassword.getText().isEmpty())) {
            alert.setAlertText("Please fill in all required fields.", "red");
        } else {
            alert.setAlertText("", "red");

            String enteredAccountName = login_username.getText().trim();
            String enteredPassword = showPasswordChecked ? login_showPassword.getText() : login_password.getText();

            if (enteredAccountName.equals("Admin") && enteredPassword.equals("12345678")) {
                // Direct the specific user "Admin" to the dashboard
                alert.setAlertText("Successful Login!", "green");

                try {
                    // TO LINK TO DASHBOARD FORM
                    Parent root = FXMLLoader.load(getClass().getResource("/Dashboard/Dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    Image icon = new Image(getClass().getResourceAsStream("/Images/anyapfp.jpg"));
                    stage.getIcons().add(icon);
                    stage.setTitle("Dashboard"); // Set a title for your window
                    stage.setResizable(true); // Make it resizable
                    stage.setScene(scene);
                    // TO SHOW THE DASHBOARD FORM
                    stage.show();
                    // TO HIDE THE WINDOW OF LOG IN FORM
                    login_btn.getScene().getWindow().hide();
                    // Set the minimum width and height for the Dashboard
                    stage.setMinWidth(800);
                    stage.setMinHeight(600);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    boolean usernameExists = checkAcc.checkAccount(enteredAccountName);
                    boolean passwordCorrect = checkAcc.checkAccount(enteredAccountName, enteredPassword);

                    if (usernameExists) {
                        if (passwordCorrect) {
                            alert.setAlertText("Successful Login!", "green");

                            try {
                                // TO LINK TO DASHBOARD FORM
                                Parent root = FXMLLoader.load(getClass().getResource("/Homepage/Homepage.fxml"));
                                Stage stage = new Stage();
                                Scene scene = new Scene(root);

                                Image icon = new Image(getClass().getResourceAsStream("/Images/anyapfp.jpg"));
                                stage.getIcons().add(icon);
                                stage.setTitle("Homepage"); // Set a title for your window
                                stage.setResizable(false); // Make it resizable

                                stage.setScene(scene);
                                // TO SHOW THE DASHBOARD FORM
                                stage.show();
                                // TO HIDE THE WINDOW OF LOG IN FORM
                                login_btn.getScene().getWindow().hide();
                            } catch (Exception e) {
                                e.printStackTrace();
                                // Handle the exception appropriately (e.g., show an error message).
                            }
                        } else {
                            alert.setAlertText("Incorrect password.", "red");
                        }
                    } else {
                        alert.setAlertText("Username doesn't exist.", "red");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void showPassword() {
        showPasswordChecked = login_selectShowPassword.isSelected();
        if (showPasswordChecked) {
            login_showPassword.setText(login_password.getText());
            login_showPassword.setVisible(true);
            login_password.setVisible(false);
        } else {
            login_password.setText(login_showPassword.getText());
            login_showPassword.setVisible(false);
            login_password.setVisible(true);
        }
    }

    //FORGOT PASS FORM PART
    public void forgotPass() {
        AlertManager alert = new AlertManager(forgot_alert);

        if (forgot_userID.getText().isEmpty()
                || (forgot_selectQuestion.getSelectionModel().getSelectedItem() == null
                || forgot_answer.getText().isEmpty())) {
            alert.setAlertText("Please fill in all required fields.", "red");
        } else {
            connect = connectDB.connectDB();
            if (connect == null) {
                alert.setAlertText("Unable to connect to the database!", "red");
                return;
            }

            try {
                Database checkUsername = new Database();
                boolean isValidUser;

                isValidUser = checkUsername.checkAccount(forgot_userID.getText());
                if (!isValidUser) {
                    // Show an alert for incorrect username
                    alert.setAlertText("Username does not exist", "red");
                } else {
                    // Store the username for later use
                    storedUsername = forgot_userID.getText();
                    // Clear the alert for the username
                    alert.setAlertText("", "#2b2d31");

                    Database checkAccount = new Database();
                    boolean isValid = checkAccount.checkAccount(storedUsername, (String) forgot_selectQuestion.getSelectionModel().getSelectedItem(), forgot_answer.getText());

                    // IF CORRECT
                    if (isValid) {
                        // PROCEED TO CHANGE PASSWORD
                        signup_form.setVisible(false);
                        login_form.setVisible(false);
                        forgot_form.setVisible(false);
                        changePass_form.setVisible(true);

                        // Clear the forgot password fields
                        forgot_userID.setText("");
                        forgot_selectQuestion.getSelectionModel().clearSelection();
                        forgot_answer.setText("");
                    } else {
                        alert.setAlertText("Incorrect Information", "red");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                // Handle the exception appropriately, e.g., show an error alert or log the error.
            }
        }
    }

    public void forgotListQuestions() {
        List<String> listQ = new ArrayList<>();

        for (String data : questionList) {
            listQ.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listQ);
        forgot_selectQuestion.setItems(listData);
    }

    public void changePass() {
        AlertManager alert = new AlertManager(changePass_alert);

        // CHECK ALL FIELDS IF EMPTY OR NOT
        if (changePass_password.getText().isEmpty() || changePass_confirmPassword.getText().isEmpty()) {
            alert.setAlertText("Please fill in all required fields.", "red");
        } else if (!changePass_password.getText().equals(changePass_confirmPassword.getText())) {
            // CHECK IF THE PASSWORD AND CONFIRMATION ARE NOT MATCH
            alert.setAlertText("Password does not match", "red");
        } else if (changePass_password.getText().length() < 8) {
            // CHECK IF THE PASSWORD IS LESS THAN 8
            alert.setAlertText("Invalid Password, at least 8 characters needed.", "red");
        } else {
            //CLEAR ALERT WHEN SUCCESSFULLY CHANGED
            alert.setAlertText("", "#2b2d31");

            Database update = new Database();
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            List<String> updateColumn = Arrays.asList(
                    "password",
                    "update_date"
            );

            List<Object> values = Arrays.asList(
                    changePass_password.getText(),
                    sqlDate
            );

            List<String> condition = Arrays.asList(
                    "username"
            );

            List<Object> conditionValue = Arrays.asList(
                    storedUsername
            );

            try {
                update.updateData("signin_users", updateColumn, values, condition, conditionValue);

                login_username.setText("");
                login_password.setVisible(true);
                login_password.setText("");
                login_showPassword.setVisible(false);
                login_selectShowPassword.setSelected(false);

                // Clear the password and confirmation fields
                changePass_password.setText("");
                changePass_confirmPassword.setText("");

                //LOGIN WILL APPEAR
                signup_form.setVisible(false);
                login_form.setVisible(true);
                forgot_form.setVisible(false);
                changePass_form.setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //CREATE ACC FORM PART
    public void createAcc() {
        AlertManager alert = new AlertManager(signup_alert);

        // CHECK IF WE HAVE EMPTY FIELD
        if (signup_userID.getText().isEmpty()
                || signup_password.getText().isEmpty()
                || signup_confirmPassword.getText().isEmpty()
                || signup_selectQuestion.getSelectionModel().getSelectedItem() == null
                || signup_answer.getText().isEmpty()) {
            alert.setAlertText("Please fill in all required fields.", "red");
        } else if (!signup_password.getText().equals(signup_confirmPassword.getText())) {
            alert.setAlertText("Password does not match.", "red");
        } else if (signup_password.getText().length() < 8) {
            alert.setAlertText("Invalid Password, at least 8 characters needed.", "red");
        } else {
            // CHECK IF THE USERNAME IS ALREADY TAKEN
            String checkUsername = "SELECT * FROM signin_users WHERE username = '"
                    + signup_userID.getText() + "'";
            connect = connectDB.connectDB();

            Database checkAccount = new Database();
            boolean isValid = false;
            try {
                isValid = checkAccount.checkAccount(signup_userID.getText());

                if (!isValid) {
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    List<String> columnNames = Arrays.asList(
                            "username",
                            "password",
                            "question",
                            "answer",
                            "date");

                    List<Object> values = Arrays.asList(
                            signup_userID.getText(),
                            signup_password.getText(),
                            (String) signup_selectQuestion.getSelectionModel().getSelectedItem(),
                            signup_answer.getText(),
                            sqlDate);

                    checkAccount.insertData("signin_users", columnNames, values);
                    alert.setAlertText("Registered Successfully!", "green");
                    createAccClearFields();

                    // Clear and hide the alert after a certain period
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            alert.hideAlert();
                        }
                    }, 5000); // Hide the alert after 5 seconds (adjust as needed)
                } else {
                    alert.setAlertText(signup_userID.getText() + " is already taken", "red");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //CLEAR FIELDS OF CREATE ACC FORM
    public void createAccClearFields() {
        signup_userID.setText("");
        signup_password.setText("");
        signup_selectQuestion.getSelectionModel().clearSelection();
        signup_confirmPassword.setText("");
        signup_answer.setText("");
    }

    //SWITCH FORMS WHERE YOU WANT
    public void switchForm(ActionEvent event) {
        if (event.getSource() == signup_loginAcc || event.getSource() == forgot_backBtn) {
            signup_form.setVisible(false);
            login_form.setVisible(true);
            forgot_form.setVisible(false);
            changePass_form.setVisible(false);

            // Clear the login alert when coming back to the login form
            signin_alert.setText("");
        } else if (event.getSource() == login_createAcc) {
            signup_form.setVisible(true);
            login_form.setVisible(false);
            forgot_form.setVisible(false);
            changePass_form.setVisible(false);

        } else if (event.getSource() == login_forgetPassword) {
            signup_form.setVisible(false);
            login_form.setVisible(false);
            forgot_form.setVisible(true);
            changePass_form.setVisible(false);

            // Clear the login alert when going to the forgot password form
            signin_alert.setText("");

            // TO SHOW THE DATA OF OUR COMBO-BOX
            forgotListQuestions();
        } else if (event.getSource() == changePass_backBtn) {
            signup_form.setVisible(false);
            login_form.setVisible(false);
            forgot_form.setVisible(true);
            changePass_form.setVisible(false);

            // Clear the login alert when coming back to the forgot password form
            signin_alert.setText("");
        }
    }

    private String[] questionList = {"Who is the most handsome prof?", "What is OOP"};

    public void questions() {
        List<String> listQ = new ArrayList<>();

        for (String data : questionList) {
            listQ.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listQ);
        signup_selectQuestion.setItems(listData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        questions();
        forgotListQuestions();

        // Listen for Enter key press in the login form
        login_form.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Handle the Enter key press (e.g., call the login() method)
                login();
            }
        });

    }

}
