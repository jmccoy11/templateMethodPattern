/*
  Author: Jonnathon McCoy
  Author: Sofiya Antonyuk
  Date: 3/13/2018
  Filename: TextChangingButton.java

  A button that changes the label text of the button.
 */

package buttons;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import ui.UI;

/**
 * A button that changes the label text of the button.
 */
public class TextChangingButton extends ButtonExtension {
    
    private String oldText;
    private String defaultText = "Wanna know something?";

    /**
     * Constructor
     * @param label - String - the Button label.
     */
    public TextChangingButton(String label) {
        super(label);
    }

    /**
     * Show the results in the ScrollPane upon clicking the button.
     *
     * @param event - MouseEvent - Click Listener
     */
    @Override
    public void showResultsText(ActionEvent event) {
        String text;
        if(oldText == null) {
            text = defaultText;
        } else {
            text = oldText;
        }

        Label textChangePopup = new Label(text);
        textChangePopup.setAlignment(Pos.CENTER);
        textChangePopup.setStyle("-fx-font-size: 20;" +
                "-fx-text-fill: blue;" +
                "-fx-font-weight: bold");

        ScrollPane popoverScrollPane = (ScrollPane) UI.getLabelPane();
        VBox popOverBox = (VBox) popoverScrollPane.getContent();
        popOverBox.getChildren().add(textChangePopup);
    }

    /**
     * Set the text of the button to the toggled value. then change this value to be either the
     * defaultText or the text previously stored.
     */
    public void changeText() {
        if(oldText == null) {
            oldText = getText();
            setText(defaultText);
        } else {
            setText(oldText);
            oldText = null;
        }
    }
}
