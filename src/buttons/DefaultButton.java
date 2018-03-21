/*
  Author: Jonnathon McCoy
  Author: Sofiya Antonyuk
  Date: 3/13/2018
  Filename: DefaultButton.java

  A default button that only implements showResultsText().
 */

package buttons;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import ui.UI;

/**
 * A default button that only implements showResultsText().
 */
public class DefaultButton extends ButtonExtension {

    /**
     * Constructor
     * @param label - String - the Button label.
     */
    public DefaultButton(String label) {
        super(label);
    }

    /**
     * Show the results in the ScrollPane upon clicking the button.
     *
     * @param event - MouseEvent - Click Listener
     */
    @Override
    public void showResultsText(ActionEvent event) {
        Label defaultChange = new Label("You clicked a default button.");
        defaultChange.setAlignment(Pos.CENTER);
        defaultChange.setStyle("-fx-font-size: 20;" +
                "-fx-text-fill: black;" +
                "-fx-font-weight: bold");

        ScrollPane popoverScrollPane = (ScrollPane) UI.getLabelPane();
        VBox popOverBox = (VBox) popoverScrollPane.getContent();
        popOverBox.getChildren().add(defaultChange);
    }
}
