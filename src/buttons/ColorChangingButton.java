/*
  Author: Jonnathon McCoy
  Author: Sofiya Antonyuk
  Date: 3/13/2018
  Filename: ColorChangingButton.java

  A button that changes in both background and text color.
 */

package buttons;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import ui.UI;

import java.util.Random;

/**
 * A button that changes in both background and text color.
 */
public class ColorChangingButton extends ButtonExtension {
    private Random random = new Random();
    private int RGB_COLOR_MAX_LIMIT = 255;

    /**
     * Constructor
     * @param label - String - the Button label.
     */
    public ColorChangingButton(String label) {
        super(label);
    }

    /**
     * Show the results in the ScrollPane upon clicking the button.
     *
     * @param event - MouseEvent - Click Listener
     */
    @Override
    public void showResultsText(ActionEvent event) {
        Label colorChangePopup = new Label("Changing color!");
        colorChangePopup.setAlignment(Pos.CENTER);
        colorChangePopup.setTextFill(getRandomColor());
        colorChangePopup.setStyle("-fx-font-size: 20;" +
                "-fx-font-weight: bold");

        ScrollPane popoverScrollPane = (ScrollPane) UI.getLabelPane();
        VBox popOverBox = (VBox) popoverScrollPane.getContent();
        popOverBox.getChildren().add(colorChangePopup);
    }

    /**
     * Change the text color and the background of the button.
     */
    public void changeColor() {
        setStyle("-fx-font-weight: bold");
        setFillAndTextColor(getRandomColor(), getRandomColor());
    }

    private void setFillAndTextColor(Color background, Color textColor) {
        setBackground(new Background(new BackgroundFill(background, CornerRadii.EMPTY, Insets.EMPTY)));
        setTextFill(textColor);
    }

    private Color getRandomColor() {
        return Color.rgb(random.nextInt(RGB_COLOR_MAX_LIMIT),
                random.nextInt(RGB_COLOR_MAX_LIMIT),
                random.nextInt(RGB_COLOR_MAX_LIMIT));
    }
}
