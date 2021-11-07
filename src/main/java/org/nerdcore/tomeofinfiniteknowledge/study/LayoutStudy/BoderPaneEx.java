package org.nerdcore.tomeofinfiniteknowledge.study.LayoutStudy;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class MyLabel extends Label{
    public MyLabel(String s) {
        super(s);
        setAlignment(Pos.BASELINE_CENTER);
    }
}

public class BoderPaneEx extends Application {
    private BorderPane root;
    private final int SIZE = 60;

    public void start(Stage stage){
        initUI(stage);
    }

    private void initUI(Stage stage){
        root = new BorderPane();

    }

    private Label getTopLabel(){
        Label lbl = new MyLabel("TOP");
        lbl.setPrefHeight(SIZE);
        //binds width of this label to the width of the root pane
        lbl.prefWidthProperty().bind(root.widthProperty());
        lbl.setStyle("-fx-border-style: dotted; -fx-border-width: 0 0 1 0; -fx-border-color: gray; -fx-font-weight: bold");
        return lbl;
    }

    private Label getBottomLabel(){
        Label lbl = new MyLabel("BOTTOM");
        lbl.setPrefHeight(SIZE);
        lbl.prefWidthProperty().bind(root.widthProperty());
        lbl.setStyle("-fx-border-style: dotted; -fx-border-width: 1 0 0 0; -fx-border-color: gray; -fx-font-weight: bold");
        return lbl;
    }

    private Label getLeftLabel(){
        Label lbl = new MyLabel("LEFT");
        lbl.setPrefWidth(SIZE);
        lbl.prefHeightProperty().bind(root.heightProperty().subtract(2*SIZE));
        lbl.setStyle("-fx-border-style: dotted; -fx-border-width: 0 1 0 0; -fx-border-color: gray; -fx-font-weight: bold");
        return lbl;
    }

    private Label getRightLabel(){
        Label lbl = new MyLabel("RIGHT");
        lbl.setPrefWidth(SIZE);
        lbl.prefHeightProperty().bind(root.heightProperty().subtract(2*SIZE));
        lbl.setStyle("-fx-border-style: dotted; -fx-border-width: 0 0 0 1; -fx-border-color: gray; -fx-font-weight: bold");
        return lbl;
    }
}
