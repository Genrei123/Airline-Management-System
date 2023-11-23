
package LogIn;

import javafx.application.Platform;
import javafx.scene.control.Label;


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
