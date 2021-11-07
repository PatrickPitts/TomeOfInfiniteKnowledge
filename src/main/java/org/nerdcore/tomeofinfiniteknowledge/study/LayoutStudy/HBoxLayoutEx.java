package org.nerdcore.tomeofinfiniteknowledge.study.LayoutStudy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Places all child elements in a single row. Useful as a child pane for larger layouts.
 */
public class HBoxLayoutEx extends Application {

    public void start(Stage stage){
        initUI(stage);
    }

    private void initUI(Stage stage){
        //argument give space between child elements.
        HBox root = new HBox(50);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.BASELINE_RIGHT);

        Button prevButton = new Button("Previous");
        Button nextButton = new Button("Next");
        Button cancelButton = new Button("Cancel");
        Button helpButton = new Button("Help");

        root.getChildren().addAll(prevButton, nextButton, cancelButton, helpButton);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Layout Study - HBox Layout");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
