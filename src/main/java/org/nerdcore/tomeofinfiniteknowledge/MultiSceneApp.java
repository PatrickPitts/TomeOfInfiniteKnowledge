package org.nerdcore.tomeofinfiniteknowledge;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultiSceneApp extends Application  {

    Scene scene1, scene2;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Multi-Scene App");
        Label label1 = new Label("This is the first scene!");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> stage.setScene(scene2));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1=new Scene(layout1, 300, 250);

        Button button2 = new Button("Go to scene 1");
        button2.setOnAction(e-> stage.setScene(scene1));
        Label label2 = new Label("This is scene number two!");
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 300, 250);

        stage.setScene(scene1);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
