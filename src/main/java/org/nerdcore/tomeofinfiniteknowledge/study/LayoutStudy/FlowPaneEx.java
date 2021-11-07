package org.nerdcore.tomeofinfiniteknowledge.study.LayoutStudy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * FlowPane places elements in a row (or column), with elements wrapping at the end of the row. Defaults to horiz.
 */
public class FlowPaneEx extends Application {

    public void start(Stage stage){
        initUI(stage);
    }

    private void initUI(Stage stage){
        FlowPane root = new FlowPane(Orientation.HORIZONTAL, 5, 5);
        root.setPadding(new Insets(5));

        for (int i = 1; i<= 20; i++){
            root.getChildren().add(new Button(String.valueOf(i)));
        }

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Layout Study - Flow Pane");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
