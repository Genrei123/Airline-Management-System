package Homepage;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Carousel {

    int carouselNumber = 0;
    int pageNum = 0;

    public void addCarousel(AnchorPane[] parent, int number, ObservableList<String[]> locations) {
        if (locations.isEmpty()) {
            return;
        }

        String originName;
        String destinationName;
        for (int i = 0; i < number; i++) {
            JFXButton btn = new JFXButton();
            String[] row = locations.get(i);
            if (row.length > 1) {
                originName = row[0];
                destinationName = row[1];
            } else {
                originName = row[0];
                destinationName = "";
            }

            if (i == 0) {
                btn.setLayoutX(0);
                btn.setLayoutY(0);
            } else if (i == 1) {
                btn.setLayoutX(346);
                btn.setLayoutY(0);
            }
            else if (i == 2) {
                btn.setLayoutX(692);
                btn.setLayoutY(0);
            }

            // Set the button sizes
            btn.setPrefWidth(303);
            btn.setPrefHeight(200);

            // Set the button images
            Image image = new Image(getClass().getResourceAsStream("/Images/LOCATION IMAGES/Bohol.png"));
            ImageView imageView = new ImageView(image);

            btn.setGraphic(imageView);

            // Btn created successfully
            carouselNumber++;
            if (carouselNumber > 3) {
                pageNum++;
                carouselNumber = 0;
            }
            parent[pageNum].getChildren().add(btn);
        }
    }


}
