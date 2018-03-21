/*
  Author: Jonnathon McCoy
  Author: Sofiya Antonyuk
  Date: 3/13/2018
  Filename: Ui.java

  User Interface for Template Method Pattern demonstration
 */

package ui;

import buttons.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * User Interface for Template Method Pattern demonstration
 */
public class UI extends Application {

    private static final int APP_WIDTH = 800;
    private static final int APP_HEIGHT = 300;
    private static final int DEFAULT_SPACING = 10;
    private static final int PANE_PREF_WIDTH = 400;

    private static HBox window;
    private static Node labelPane;

    /**
     * Entry point for the program.
     *
     * @param primaryStage - Stage - Application primary Stage
     * @throws Exception - Exception - throws any potential exceptions
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        createWindow();
        launchApp(primaryStage);
    }

    private void createWindow() {
        window = new HBox();
        window.setAlignment(Pos.CENTER);

        VBox buttonPane = createButtonPane();
        ScrollPane scrollPane = createScrollPane();

        window.getChildren().addAll(buttonPane, scrollPane);
        setLabelPane();
    }

    private void launchApp(Stage primaryStage) {
        primaryStage.setTitle("Template Method Pattern");
        Scene templateMethodScene = new Scene(window, APP_WIDTH, APP_HEIGHT);
        primaryStage.setScene(templateMethodScene);
        primaryStage.show();
    }

    private VBox createButtonPane() {
        VBox buttonPane = new VBox();
        setButtonPaneProperties(buttonPane);
        createButtons(buttonPane);

        return buttonPane;
    }

    private void createButtons(VBox box) {
        ButtonExtension defaultBtn = new DefaultButton("Default");
        ButtonExtension colorChangeBtn = new ColorChangingButton("Change Color");
        ButtonExtension sizeChangeBtn = new SizeChangingButton("Size Changing");
        ButtonExtension textChangeBtn = new TextChangingButton("Text Changer");
        ButtonExtension everythingBtn = new EverythingButton("Do everything!");

        box.getChildren().addAll(defaultBtn, colorChangeBtn, sizeChangeBtn, textChangeBtn, everythingBtn);
    }

    private void setButtonPaneProperties(VBox buttonPane) {
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setSpacing(DEFAULT_SPACING);
        buttonPane.setPadding(new Insets(DEFAULT_SPACING));
        buttonPane.setPrefWidth(PANE_PREF_WIDTH);
    }

    private ScrollPane createScrollPane() {
        VBox labelBox = new VBox();
        labelBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        labelBox.setAlignment(Pos.CENTER);

        ScrollPane labelPane = new ScrollPane();
        labelPane.setPrefWidth(PANE_PREF_WIDTH);
        labelPane.setFitToWidth(true);
        labelPane.setUserData("labelPane");
        labelPane.setContent(labelBox);

        // This binds the height property to the labelPane and will keep the viewpoint attached to the most
        // recently added label at the bottom.
        labelBox.heightProperty().addListener((observable, oldValue, newValue) -> {
            labelPane.setVvalue((Double) newValue);
        });

        return labelPane;
    }

    /**
     * Find and set the ScrollPane so that Labels can be added to it from the ButtonExtensions.
     */
    private void setLabelPane() {
                for(Node node : window.getChildren()) {
            Object nodeData = node.getUserData();
            if (nodeData != null) {
                if((nodeData).equals("labelPane")) {
                    labelPane = node;
                }
            }
        }
    }

    /**
     * Getter for labelPane so ButtonExtensions can add to it.
     * @return - Node - ScrollPane for Labels created by ButtonExtensions.
     */
    public static Node getLabelPane() {
        return labelPane;
    }
}
