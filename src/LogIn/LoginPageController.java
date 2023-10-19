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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
