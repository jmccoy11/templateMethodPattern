/*
  Author: Jonnathon McCoy
  Author: Sofiya Antonyuk
  Date: 3/13/2018
  Filename: EverythingButton.java

  A button that implements or overrides all methods provided by the abstract parent
  ButtonExtension class.
 */

package buttons;

import ui.UI;
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

import java.util.Random;

/**
 * A button that implements or overrides all methods provided by the abstract parent
 * ButtonExtension class.
 */
public class EverythingButton extends ButtonExtension {
    private Random random = new Random();
    private String firstToggleText = "3 months left!!!";
    private String secondToggleText = "Let's get CRAZY NOW!!!";
    String toggle = firstToggleText;

    /**
     * Constructor
     * @param label - String - the Button label.
     */
    public EverythingButton(String label) {
        super(label);
    }

    /**
     * Show the results in the ScrollPane upon clicking the button.
     *
     * @param event - MouseEvent - Click Listener
     */
    @Override
    public void showResultsText(ActionEvent event) {
        String text = toggle;

        Label colorChangePopup = new Label(text);
        colorChangePopup.setAlignment(Pos.CENTER);
        colorChangePopup.setTextFill(getRandomColor());
        colorChangePopup.setStyle("-fx-font: 25px Magneto;" +
                "-fx-font-weight: bolder;");

        ScrollPane popoverScrollPane = (ScrollPane) UI.getLabelPane();
        VBox popOverBox = (VBox) popoverScrollPane.getContent();
        popOverBox.getChildren().add(colorChangePopup);
    }

    /**
     * Change the text color and the background of the button.
     */
    public void changeColor() {
        setPadding(Insets.EMPTY);
        setFillAndTextColor(getRandomColor(), getRandomColor());
    }

    private void setFillAndTextColor(Color background, Color textColor) {
        setBackground(new Background(new BackgroundFill(background, CornerRadii.EMPTY, Insets.EMPTY)));
        setTextFill(textColor);
    }

    private Color getRandomColor() {
        return Color.rgb(random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255));
    }

    /**
     * Set the text of the button to the toggled value. then change this value to be either the
     * first or second toggle text.
     */
    public void changeText() {
        setText(toggle);

        if(toggle.equals(firstToggleText)) {
            toggle = secondToggleText;
        } else {
            toggle = firstToggleText;
        }
    }

    /**
     * Toggle the size of the button.
     */
    public void resizeButton() {
        if(getPrefWidth() == 300) {
            setPrefSize(600, 200);
            setStyle("-fx-font-size: 33");
        } else {
            setPrefSize(300, 100);
            setStyle("-fx-font-size: 28");
        }
    }
}
