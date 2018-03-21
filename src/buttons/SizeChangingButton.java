/*
  Author: Jonnathon McCoy
  Author: Sofiya Antonyuk
  Date: 3/13/2018
  Filename: SizeChangingButton.java

  A button that changes size and toggles between two sizes.
 */

package buttons;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import ui.UI;

/**
 * A button that changes size and toggles between two sizes.
 */
public class SizeChangingButton extends ButtonExtension {

    /**
     * Constructor
     * @param label - String - the Button label.
     */
    public SizeChangingButton(String label) {
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
        if (getPrefWidth() == 400) {
            text = "100x50";
        } else {
            text = "400x100";
        }

        Label sizeChangePopup = new Label("Button size changing to " + text);
        sizeChangePopup.setAlignment(Pos.CENTER);
        sizeChangePopup.setStyle("-fx-font-size: 20;" +
                "-fx-text-fill: red;" +
                "-fx-font-weight: bold");

        ScrollPane popoverScrollPane = (ScrollPane)UI.getLabelPane();
        VBox popOverBox = (VBox) popoverScrollPane.getContent();
        popOverBox.getChildren().add(sizeChangePopup);
    }

    /**
     * Toggle the size of the button.
     */
    public void resizeButton() {
        if(getPrefWidth() == 400) {
            setPrefSize(150, 50);
        } else {
            setPrefSize(400, 100);
        }
    }
}
