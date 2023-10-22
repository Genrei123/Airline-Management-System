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

    public void setAlertText(String message, String color) {
        label.setText(message);
        label.setStyle("-fx-text-fill: " + color + ";");
        label.setVisible(true);
    }

    public void hideAlert() {
        Platform.runLater(() -> {
            label.setText("");
            label.setVisible(false);
        });
    }
}
