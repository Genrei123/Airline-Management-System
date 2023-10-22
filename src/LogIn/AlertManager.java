/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogIn;

import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * @author Ervhyne
 */
public class AlertManager {
    Label label;
    public AlertManager(Label label){
        this.label = label;
    }

    public void setAlertText(Label label, String message, String color) {
        label.setText(message);
        label.setStyle("-fx-text-fill: " + color + ";");
        label.setVisible(true);
    }

    public void hideAlert(Label label) {
        Platform.runLater(() -> {
            label.setText("");
            label.setVisible(false);
        });
    }
}
