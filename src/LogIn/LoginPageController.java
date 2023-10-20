/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package LogIn;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private JFXPasswordField login_showPassword;

    @FXML
    private JFXTextField login_password;

    @FXML
    private Button login_btn;

    @FXML
    private JFXCheckBox login_selectShowPassword;

    @FXML
    private Button login_createAcc;

    @FXML
    private Hyperlink login_forgetPassword;

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

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    public Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect
                    = DriverManager.getConnection("jdbc:mysql://localhost/erminoairlines", "root", "");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void login() {

    }

    
    // FOR ALERTS
    public void setAlertText(String message) {
        signup_alert.setText(message);
        signup_alert.setVisible(true); // Show the label
    }

    public void clearAlert() {
        signup_alert.setText("");
        signup_alert.setVisible(false); // Hide the label
    }

    public void createAcc() {
        // CHECK IF WE HAVE EMPTY FIELD
        if (signup_userID.getText().isEmpty()
                || signup_password.getText().isEmpty()
                || signup_confirmPassword.getText().isEmpty()
                || signup_selectQuestion.getSelectionModel().getSelectedItem() == null
                || signup_answer.getText().isEmpty()) {
            setAlertText("Please fill in all required fields.");
        } else if (!signup_password.getText().equals(signup_confirmPassword.getText())) {
            setAlertText("Password does not match.");
        } else if (signup_password.getText().length() < 8) {
            setAlertText("Invalid Password, at least 8 characters needed.");
        } else {
            // CHECK IF THE USERNAME IS ALREADY TAKEN
            String checkUsername = "SELECT * FROM signin_users WHERE username = '"
                    + signup_userID.getText() + "'";
            connect = connectDB();

            try {
                statement = connect.createStatement();
                result = statement.executeQuery(checkUsername);

                if (result.next()) {
                    setAlertText(signup_userID.getText() + " is already taken.");
                } else {
                    String insertData = "INSERT INTO signin_users"
                            + "(username, password, question, answer)"
                            + "VALUES (?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, signup_userID.getText());
                    prepare.setString(2, signup_password.getText());
                    prepare.setString(3, (String) signup_selectQuestion.getSelectionModel().getSelectedItem());
                    prepare.setString(4, signup_answer.getText());

                    prepare.executeUpdate();

                    setAlertText("Registered Successfully!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private String[] questionList = {"Who is the most handsome prof?","What is OOP"};
    public void questions(){
        List<String> listQ = new ArrayList<>();
        
        for(String data : questionList){
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
