/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package LogIn;

import Database.Connector;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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
    private AnchorPane changePass_form;

    @FXML
    private JFXTextField changePass_password;

    @FXML
    private Button changePass_proceedBtn;

    @FXML
    private Button changePass_backBtn;

    @FXML
    private JFXTextField changePass_confirmPassword;


    // Create class for alert class
    private AlertManager alert = new AlertManager(signup_alert);
    // SQL variables
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
    private Connector connectDB = new Connector();

    public void login() {
        if (login_username.getText().isEmpty() || login_password.getText().isEmpty()) {
            alert.setAlertText(signin_alert, "Please fill in all required fields.", "red");
        } else {
            String selectData = "SELECT username,password FROM signin_users WHERE " + "username = ? and password = ?";
            connect = connectDB.connectDB();

            try {
                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, login_username.getText());
                prepare.setString(2, login_password.getText());

                result = prepare.executeQuery();

                if (result.next()) {
                    alert.setAlertText(signin_alert, "Successfully Login!", "green");

                } else {
                    alert.setAlertText(signin_alert, "Incorrect Username/Password", "red");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showPassword(){
        if(login_selectShowPassword.isSelected()){
            login_showPassword.setText(login_password.getText());
            login_showPassword.setVisible(true);
            login_password.setVisible(false);
        } else {
            login_showPassword.setText(login_password.getText());
            login_showPassword.setVisible(false);
            login_password.setVisible(true);
        }
    }
    
    public void createAcc() {
        // CHECK IF WE HAVE EMPTY FIELD
        if (signup_userID.getText().isEmpty()
                || signup_password.getText().isEmpty()
                || signup_confirmPassword.getText().isEmpty()
                || signup_selectQuestion.getSelectionModel().getSelectedItem() == null
                || signup_answer.getText().isEmpty()) {
            alert.setAlertText(signup_alert, "Please fill in all required fields.", "red");
        } else if (!signup_password.getText().equals(signup_confirmPassword.getText())) {
            alert.setAlertText(signup_alert, "Password does not match.", "red");
        } else if (signup_password.getText().length() < 8) {
            alert.setAlertText(signup_alert, "Invalid Password, at least 8 characters needed.", "red");
        } else {
            // CHECK IF THE USERNAME IS ALREADY TAKEN
            String checkUsername = "SELECT * FROM signin_users WHERE username = '"
                    + signup_userID.getText() + "'";
            connect = connectDB.connectDB();

            try {
                statement = connect.createStatement();
                result = statement.executeQuery(checkUsername);

                if (result.next()) {
                    alert.setAlertText(signup_alert, signup_userID.getText() + " is already taken", "red");
                } else {
                    String insertData = "INSERT INTO signin_users"
                            + "(username, password, question, answer, date)"
                            + "VALUES (?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, signup_userID.getText());
                    prepare.setString(2, signup_password.getText());
                    prepare.setString(3, (String) signup_selectQuestion.getSelectionModel().getSelectedItem());
                    prepare.setString(4, signup_answer.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert.setAlertText(signup_alert, "Registered Successfully!", "green");

                    createAccClearFields();

                    // Clear and hide the alert after a certain period
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            alert.hideAlert(signup_alert);
                        }
                    }, 5000); // Hide the alert after 5 seconds (adjust as needed)
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

    public void switchForm(ActionEvent event) {
        if (event.getSource() == signup_loginAcc) {
            signup_form.setVisible(false);
            login_form.setVisible(true);
            forgot_form.setVisible(false);
            changePass_form.setVisible(false);
        } else if (event.getSource() == login_createAcc) {
            signup_form.setVisible(true);
            login_form.setVisible(false);
            forgot_form.setVisible(false);
            changePass_form.setVisible(false);
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
    }

}
