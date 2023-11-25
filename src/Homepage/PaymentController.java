/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Homepage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class PaymentController implements Initializable {

    private HomepageController homepageController;

    public void setHomepageController(HomepageController homepageController) {
        this.homepageController = homepageController;
    }

    public void notification() {
        // Close the current stage (Notif.fxml)
        //Stage stage = (Stage) .getScene().getWindow();
        //stage.close();

        // Call the method in HomepageController to switch to hf_searchDesti form
        if (homepageController != null) {
            homepageController.handleReturnToDestiButtonClick();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
