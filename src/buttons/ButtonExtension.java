/*
  Author: Jonnathon McCoy
  Author: Sofiya Antonyuk
  Date: 3/13/2018
  Filename: ButtonExtension.java

  Abstract class from which other buttons are extended from to dictate the behavior
  for child classes using the Template Method Pattern.
 */

package buttons;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Abstract class from which other buttons are extended from to dictate the behavior
 * for child classes using the Template Method Pattern.
 */
public abstract class ButtonExtension extends Button{

    /**
     * Super Constructor for each class that extends from this class that will then pass
     * the parameters to the javafx.scene.control.Button from which this class extends from.
     *
     * Then sets a ClickListener to run each of the 4 methods defined in this class.
     * @param label - String - the Button label.
     */
    ButtonExtension(String label) {
        super(label);

        /*
         Create a ClickListener that will run each of the 4 methods included in this class.

         If the child class does not implement the method, the default behavior defined below
         will be performed with the exception of the abstract method showResultsText() which must be
         implemented by any class that extends from this class.
        */
        setOnAction((event) -> {
            showResultsText(event);
            changeColor();
            changeText();
            resizeButton();
        });
    }

    /**
     * Show the results in the ScrollPane upon clicking the button.
     * @param event - MouseEvent - Click Listener
     */
    public abstract void showResultsText(ActionEvent event);

    /**
     * Intended behavior is to change the color properties of the button.
     *
     * Default behavior is a blank method meaning the child class may choose to implement this
     * method.
     */
    public void changeColor(){
    
    }

    /**
     * Change the text within the button.
     *
     * The default behavior is to print the class that called this method and print it to the
     * console.
     */
    public void changeText() {
        System.out.println(this.getClass().getSimpleName() + " is the button class that called changeText()");
        System.out.println("This is default behaviour and doesn't do anything.");
        System.out.println();
    }

    /**
     * Intended behavior is to change the size of a button.
     *
     * Default behavior is a blank method meaning the child class may choose to implement this
     * method.
     */
    public void resizeButton() {
    
    }
}
